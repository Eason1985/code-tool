package com.web.contentmanager.swarm;

import java.util.HashMap;
import java.util.Map;

import net.sf.ezmorph.bean.MorphDynaBean;
import net.sf.json.JSONObject;

import com.web.common.exception.BusinessException;
import com.web.common.util.StringFormatByParamMean;
import com.web.contentmanager.ContentSubjectKeyEnum;
import com.web.contentmanager.swarm.SwarmContentFactory.HttpParamHandle;
import com.web.contentmanager.sysproperty.SysPropertyHandle;

public class ContainerInstanceBO {

	// get 实例所在的node的信息   http://10.139.49.97:8888/v1/:cluster/services/nodes/inspect/:nodeid
	private static final String INSTANCE_NODE_INFO_ADDRESS = "{swarmIp}/v1/{cluster}/nodes/inspect/{nodeId}" ;
	
	private String serviceId ;
	
	private String instanceId ;

	private String nodeId ; 
	
	private NodeInfoBO nodeInfo ;

	
	
	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public String getInstanceId() {
		return instanceId;
	}

	public void setInstanceId(String instanceId) {
		this.instanceId = instanceId;
	}

	public String getNodeId() {
		return nodeId;
	}

	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}

	public NodeInfoBO getNodeInfo() {
		if(nodeInfo == null ){
			queryDockerInstanceNodeInfo( ) ; 
		}
		return nodeInfo;
	}

	public void setNodeInfo(NodeInfoBO nodeInfo) {
		this.nodeInfo = nodeInfo;
	} 
	
	/**
	 * 6:查询实例所在的node的信息
	 *  http://10.139.49.97:8888/v1/:cluster/services/nodes/inspect/:nodeid
	 * get 方式
	 * @param mountPath
	 * @return
	 */
	public void queryDockerInstanceNodeInfo ( ){
		String swarmAddress = SysPropertyHandle.getProperty(ContentSubjectKeyEnum.SWARM_ADDRESS) ; 
		String swarmClusterName = SysPropertyHandle.getProperty(ContentSubjectKeyEnum.SWARM_CLUSTER_NAME) ; 
		SwarmContentFactory.applyHttpGet(
				StringFormatByParamMean.format(INSTANCE_NODE_INFO_ADDRESS, swarmAddress,swarmClusterName ,nodeId ),
				new HttpParamHandle(){
					@Override
					public void assimbleParam(JSONObject jsonParam) {
					}
					
					@SuppressWarnings({ "static-access", "rawtypes" })
					@Override
					public void obtainResult(String jsonResult ) {
						 //获取nodeid列表
						JSONObject jSONObject = JSONObject.fromObject(jsonResult);
						Map result = (Map) jSONObject.toBean(jSONObject, HashMap.class);  
						if(result.get("IsSuccess")!=null && (Boolean)result.get("IsSuccess")){
							//查询
							MorphDynaBean bean = (MorphDynaBean)result.get("Data") ; 
							MorphDynaBean status = (MorphDynaBean)bean.get("Status");
							MorphDynaBean description = (MorphDynaBean)bean.get("Description");
							//获取nodeid列表
							nodeInfo = new NodeInfoBO((String)bean.get("ID"),
									(String)status.get("Addr"),
									(String)description.get("Hostname")
									);
						}else{
							throw new BusinessException((String)result.get("ErrMsg") );
						}
					}
			}) ; 
	}
		
}
