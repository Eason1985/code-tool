package com.web.contentmanager.swarm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.ezmorph.bean.MorphDynaBean;
import net.sf.json.JSONObject;

import com.web.common.exception.BusinessException;
import com.web.common.util.StringFormatByParamMean;
import com.web.contentmanager.ContentSubjectKeyEnum;
import com.web.contentmanager.swarm.SwarmContentFactory.HttpParamHandle;
import com.web.contentmanager.swarm.assitobj.PortConfig;
import com.web.contentmanager.sysproperty.SysPropertyHandle;

public class ContainerBO {

	// get	应用实例列表 http://10.139.49.97:8888/v1/:cluster/services/ps/:service
	private static final String CONTAINER_INSTANCE_LIST_ADDRESS = "{swarmIp}/v1/{cluster}/services/ps/{serviceId}" ;
	
	/**
	 * 端口信息
	 */
    private List<PortConfig> portes ;
	
    /**
     * serviceId信息
     */
	private String serviceId ; 
	
	/**
     * instanceInfo信息
     */
	private List<ContainerInstanceBO> containerInstanceInfoList ; 
	
	/**
	 * cpu信息
	 */
	private String cpuRunInfo ; 
	
	/**
	 * 内存信息
	 */
	private String ramRunInfo ;
 
	/**
	 * 5:应用实例列表
	 *  http://10.139.49.97:8888/v1/test/services/ps/:service
	 * get 方式
	 * @param mountPath
	 * @return
	 */
	public void queryDockerInstanceList(){
		String swarmAddress = SysPropertyHandle.getProperty(ContentSubjectKeyEnum.SWARM_ADDRESS) ; 
		String swarmClusterName = SysPropertyHandle.getProperty(ContentSubjectKeyEnum.SWARM_CLUSTER_NAME) ; 
		SwarmContentFactory.applyHttpGet(
				StringFormatByParamMean.format(CONTAINER_INSTANCE_LIST_ADDRESS, swarmAddress,swarmClusterName ,serviceId ),
				new HttpParamHandle(){
					@Override
					public void assimbleParam(JSONObject jsonParam) {
					}
					
					@SuppressWarnings({ "rawtypes", "static-access", "unchecked" })
					@Override
					public void obtainResult(String jsonResult ) {
						JSONObject jSONObject = JSONObject.fromObject(jsonResult);
						Map result = (Map) jSONObject.toBean(jSONObject, HashMap.class);  
						if(result.get("IsSuccess")!=null && (Boolean)result.get("IsSuccess")){
							//查询
							MorphDynaBean bean = (MorphDynaBean)result.get("Data") ; 
//							Integer bength = (Integer)bean.get("Length") ;
							List<MorphDynaBean> resultes = (List<MorphDynaBean>)bean.get("Result");
							List<ContainerInstanceBO> containerInstanceInfoListTemp = new ArrayList<ContainerInstanceBO>();
							ContainerInstanceBO containerInstanceBOTemp ; 
							for(MorphDynaBean resultData:resultes){
								containerInstanceBOTemp  = new ContainerInstanceBO();
								containerInstanceBOTemp.setInstanceId((String)resultData.get("ID"));
								containerInstanceBOTemp.setNodeId((String)resultData.get("NodeID"));
								containerInstanceBOTemp.setServiceId((String)resultData.get("ServiceID"));
								containerInstanceInfoListTemp.add(containerInstanceBOTemp); 
							}
							//获取nodeid列表
							containerInstanceInfoList = containerInstanceInfoListTemp ; 
						}else{
							throw new BusinessException((String)result.get("ErrMsg") );
						}
						
					}

			}) ; 
	}

	 
	public List<PortConfig> getPortes() {
		return portes;
	}


	public void setPortes(List<PortConfig> portes) {
		this.portes = portes;
	}


	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public String getCpuRunInfo() {
		return cpuRunInfo;
	}

	public void setCpuRunInfo(String cpuRunInfo) {
		this.cpuRunInfo = cpuRunInfo;
	}

	public String getRamRunInfo() {
		return ramRunInfo;
	}

	public void setRamRunInfo(String ramRunInfo) {
		this.ramRunInfo = ramRunInfo;
	}
	public List<ContainerInstanceBO> getContainerInstanceInfoList() {
		if(containerInstanceInfoList == null ){
			queryDockerInstanceList() ; 
		}
		return containerInstanceInfoList;
	}
	public void setContainerInstanceInfoList(
			List<ContainerInstanceBO> containerInstanceInfoList) {
		this.containerInstanceInfoList = containerInstanceInfoList;
	}

	
}
