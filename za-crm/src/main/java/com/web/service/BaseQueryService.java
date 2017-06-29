package com.web.service;

import org.springframework.stereotype.Service;

import com.web.common.service.IService;
import com.web.facade.AbsRequest;
import com.web.facade.AbsResponse;
import com.web.facade.basequery.BaseObjectOPRequest;
import com.web.facade.basequery.BaseObjectOPResponse;
import com.web.mapper.AllEntityMapperFactory;
@Service
public class BaseQueryService implements IService {

	@SuppressWarnings("unchecked")
	@Override
	public AbsResponse execute(AbsRequest obj) {
		BaseObjectOPRequest rqes = (BaseObjectOPRequest)obj; 
		BaseObjectOPResponse res = new BaseObjectOPResponse(); 
		res.setReturnCode(AbsResponse.SUCCESS);
		res.setMessage("查询成功");
		switch (rqes.getQueryType()) {
			case BaseObjectOPRequest.QUERYTYPE_SELECTOBJECT_1:{
				res.setSelectObject(AllEntityMapperFactory.getAllEntityMapper().selectObject(rqes.getObject()));
				break;
			}
			case BaseObjectOPRequest.QUERYTYPE_SELECTLIST_2:{
				res.setSelectList(AllEntityMapperFactory.getAllEntityMapper().selectList(rqes.getObject(),rqes.getHandle()));
				break;
			}case BaseObjectOPRequest.QUERYTYPE_SELECTLISTBYPAGE_3:{
				res.setSelectList(AllEntityMapperFactory.getAllEntityMapper().selectListByPage(rqes.getObject(),rqes.getHandle()));
				break;
			}case BaseObjectOPRequest.QUERYTYPE_SELECTCOUNT_4:{
				res.setDataExeNumber(AllEntityMapperFactory.getAllEntityMapper().selectCount(rqes.getObject() ));
				break;
			}case BaseObjectOPRequest.QUERYTYPE_SELECTCOUNT_HAVE_HANDLE_5:{
				res.setDataExeNumber(AllEntityMapperFactory.getAllEntityMapper().selectCount(rqes.getObject() , rqes.getHandle() ));
				break;
			}
			default:{
				res.setReturnCode(AbsResponse.PARAMERROR);
				res.setMessage("参数错误");
				break;
			}
		}
		return res;
	}

	@Override
	public String serviceCode() {
		return "BASEQUERY";
	}

	
}
