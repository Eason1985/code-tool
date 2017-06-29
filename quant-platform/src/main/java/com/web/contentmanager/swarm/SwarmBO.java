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
import com.web.contentmanager.swarm.assitobj.Mount;
import com.web.contentmanager.swarm.assitobj.PortConfig;
import com.web.contentmanager.swarm.assitobj.TaskSpec;
import com.web.contentmanager.sysproperty.SysPropertyHandle;


@SuppressWarnings({ "rawtypes", "static-access" , "unchecked" })
public class SwarmBO {
	
	// post  创建应用url:eg. http://10.139.49.97:8888/v1/:cluster/services/create
	private static final String CREATE_CONTAINER_ADDRESS = "{swarmAddress}/v1/{cluster}/services/create";
	
	// post 删除应用url:eg. http://10.139.49.97:8888/v1/:cluster/services/remove/:service
	private static final String REMOVE_CONTAINER_ADDRESS = "{swarmAddress}/v1/{cluster}/services/remove/{serviceId}" ;
	
	// get 应用列表  http://10.139.49.97:8888/v1/:cluster/services/list
	private static final String CONTAINER_LIST_ADDRESS = "{swarmAddress}/v1/{cluster}/services/list" ;
	
	// get	应用详情 http://10.139.49.97:8888/v1/:cluster/services/inspect/:service
	private static final String CONTAINER_DETAIL_ADDRESS = "{swarmAddress}/v1/{cluster}/services/inspect/{serviceId}" ;
	
	/**
	 * 1:申请docker 
	 * @param mountPath
	 * @param userId
	 * @param port
	 * @return
	 */
	public static ContainerBO createDockerContainer (
			final String mountPath  , 
			final String userId ,
			final Integer hostPort ,
			final Integer dockerPort ,
			final String comand[]){
		String swarmAddress = SysPropertyHandle.getProperty(ContentSubjectKeyEnum.SWARM_ADDRESS) ; 
		String swarmClusterName = SysPropertyHandle.getProperty(ContentSubjectKeyEnum.SWARM_CLUSTER_NAME) ; 
		String image = SysPropertyHandle.getProperty(ContentSubjectKeyEnum.DOCKER_IMAGE_NAME) ; 

		PortConfig portConfig= new PortConfig("tcp",hostPort , dockerPort);
		final PortConfig[] portConfigse = new PortConfig[]{portConfig} ; 
		Mount mount = new Mount(mountPath,"/tmp",false); 
		final TaskSpec taskSpec=new TaskSpec(image); 
		taskSpec.setMounts(new Mount[]{mount});
		taskSpec.setCommand(comand);
		
		final ContainerBO containerBO = new ContainerBO(); 
		SwarmContentFactory.applyHttpPost(
				StringFormatByParamMean.format(CREATE_CONTAINER_ADDRESS, swarmAddress,swarmClusterName),
				new HttpParamHandle(){
					
					@Override
					public void assimbleParam(JSONObject jsonParam) {
						jsonParam.put("Name", userId);
						jsonParam.put("Mode", "replicated");//replicated`模式需要用户指定实例个数、`global`模式会在所有满足条件的节点上启动一个实例
						jsonParam.put("Replicas", 1);
						jsonParam.put("Ports", portConfigse) ; 
						jsonParam.put("Task",  taskSpec ) ; 
					}
		
					@Override
					public void obtainResult(String jsonResult ) {
						fillContainerBO(containerBO, jsonResult);
					}

			}) ; 
		
		
		return containerBO ; 
	}
	/**
	 * 2:删除docker 
	 * http://10.139.49.97:8888/v1/:cluster/services/remove/:service
	 * post 方式
	 * @param mountPath
	 * @return
	 */
	public static  boolean removeDockerContainer ( String dockerContainerIdOrUserId ){
		String swarmAddress = SysPropertyHandle.getProperty(ContentSubjectKeyEnum.SWARM_ADDRESS) ; 
		String swarmClusterName = SysPropertyHandle.getProperty(ContentSubjectKeyEnum.SWARM_CLUSTER_NAME) ; 
		SwarmContentFactory.applyHttpPost(
				StringFormatByParamMean.format(REMOVE_CONTAINER_ADDRESS, swarmAddress,swarmClusterName,dockerContainerIdOrUserId),
				new HttpParamHandle(){
					@Override
					public void assimbleParam(JSONObject jsonParam) {
					}
		
					@Override
					public void obtainResult(String jsonResult ) {
						JSONObject jSONObject = JSONObject.fromObject(jsonResult);
						Map result = (Map) jSONObject.toBean(jSONObject, HashMap.class);  
						if(result.get("IsSuccess")!=null && (Boolean)result.get("IsSuccess")){
							//查询
							
						} else{
							throw new BusinessException((String)result.get("ErrMsg") );
						}
					}

			}) ; 
		return true ; 
	}
	
	/**
	 * 
	 * 3应用列表  http://10.139.49.97:8888/v1/:cluster/services/list
	 * get方式
	 * @param mountPath
	 * @return
	 */
	public static List<ContainerBO> queryContainerList( ){
		String swarmAddress = SysPropertyHandle.getProperty(ContentSubjectKeyEnum.SWARM_ADDRESS) ; 
		String swarmClusterName = SysPropertyHandle.getProperty(ContentSubjectKeyEnum.SWARM_CLUSTER_NAME) ; 
		final List<ContainerBO> dockeres = new ArrayList<ContainerBO> () ; 
		
		SwarmContentFactory.applyHttpGet(
				StringFormatByParamMean.format(CONTAINER_LIST_ADDRESS, swarmAddress,swarmClusterName ),
				new HttpParamHandle(){
					@Override
					public void assimbleParam(JSONObject jsonParam) {
					}
					@Override
					public void obtainResult(String jsonResult ) {
						JSONObject jSONObject = JSONObject.fromObject(jsonResult);
						Map result = (Map) jSONObject.toBean(jSONObject, HashMap.class);  
						if(result.get("IsSuccess")!=null && (Boolean)result.get("IsSuccess")){
							//查询
							MorphDynaBean bean = (MorphDynaBean)result.get("Data") ; 
//							Integer bength = (Integer)bean.get("Length") ;
							List<MorphDynaBean> resultes = (List<MorphDynaBean>)bean.get("Result");
							ContainerBO docker ; 
							for(MorphDynaBean resultData:resultes){
								docker = new ContainerBO();
								fillContainerBO(docker, resultData);
								dockeres.add(docker) ; 
							}
						}else{
							throw new BusinessException((String)result.get("ErrMsg") );
						}
					}
			}) ; 
		return dockeres ; 
		
	}
	// 
	/**
	 * 4:应用详情 
	 *  http://10.139.49.97:8888/v1/:cluster/services/inspect/:service
	 * get 方式
	 * @param mountPath
	 * @return 如果没有，返回null
	 */
	public static  ContainerBO queryDockerDetailContainer ( String dockerContainerIdOrUserId ){
		String swarmAddress = SysPropertyHandle.getProperty(ContentSubjectKeyEnum.SWARM_ADDRESS) ; 
		String swarmClusterName = SysPropertyHandle.getProperty(ContentSubjectKeyEnum.SWARM_CLUSTER_NAME) ; 
		final Map<String,Object> resultTemp = new HashMap<String,Object>();
		
		SwarmContentFactory.applyHttpGet(
				StringFormatByParamMean.format(CONTAINER_DETAIL_ADDRESS, swarmAddress,swarmClusterName ,dockerContainerIdOrUserId ),
				new HttpParamHandle(){
					@Override
					public void assimbleParam(JSONObject jsonParam) {
					}
		
					
					@Override
					public void obtainResult(String jsonResult ) {
						JSONObject jSONObject = JSONObject.fromObject(jsonResult);
						Map result = (Map) jSONObject.toBean(jSONObject, HashMap.class);  
						ContainerBO containerBO = new ContainerBO(); 
						if(result.get("IsSuccess")!=null && (Boolean)result.get("IsSuccess")){
							//查询
							resultTemp.put("haveContainer", true);
							resultTemp.put("containerBO",containerBO);
							MorphDynaBean bean = (MorphDynaBean)result.get("Data") ; 
							fillContainerBO(containerBO, bean);
						}else{
							resultTemp.put("haveContainer", false);
						}
					}

			}) ; 
		if((boolean)resultTemp.get("haveContainer")){
			return (ContainerBO)resultTemp.get("containerBO") ; 
		}else {
			return null ; 
		}
	}
	
	private static  void  fillContainerBO(ContainerBO containerBO , String jsonResult){
		JSONObject jSONObject = JSONObject.fromObject(jsonResult);
		Map result = (Map) jSONObject.toBean(jSONObject, HashMap.class);  
		if(result.get("IsSuccess")!=null && (Boolean)result.get("IsSuccess")){
			//查询
			MorphDynaBean bean = (MorphDynaBean)result.get("Data") ; 
			fillContainerBO(containerBO, bean);
		}else{
			throw new BusinessException((String)result.get("ErrMsg") );
		}
	}
	
	private static  void  fillContainerBO(ContainerBO containerBO ,MorphDynaBean bean ){
			String serviceId = (String)bean.get("ID");
			MorphDynaBean spec = (MorphDynaBean)bean.get("Spec"); 
			MorphDynaBean endpointSpec = (MorphDynaBean)spec.get("EndpointSpec"); 
			List<MorphDynaBean> ports = (List<MorphDynaBean>)endpointSpec.get("Ports"); 
			List<PortConfig> portConfiges  = new ArrayList<PortConfig> (); 
			for(MorphDynaBean port:ports){
				portConfiges.add(new PortConfig("tcp", 
										(Integer)(port.get("TargetPort")),
										(Integer)(port.get("PublishedPort")) 
									)
						);
			}
			containerBO.setServiceId(serviceId);
			containerBO.setPortes(portConfiges);
	}
}
