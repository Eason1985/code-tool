package com.web.business.basesubmit;

import org.springframework.stereotype.Service;

import com.web.common.service.BusinessAbstractor;
import com.web.facade.AbsRequest;
import com.web.facade.AbsResponse;
import com.web.facade.basequery.BaseObjectOPRequest;
import com.web.facade.basequery.BaseObjectOPResponse;
import com.web.mapper.AllEntityMapperFactory;
@Service
public class BaseSubmitService extends BusinessAbstractor {

	@SuppressWarnings("unchecked")
	@Override
	public AbsResponse handle(AbsRequest obj) {
		BaseObjectOPRequest rqes = (BaseObjectOPRequest)obj; 
		BaseObjectOPResponse res = new BaseObjectOPResponse(); 
		res.setReturnCode(AbsResponse.SUCCESS);
		res.setMessage("操作成功");
		switch (rqes.getQueryType()) {
			case BaseObjectOPRequest.SUBMITTYPE_INSERT_1:{
				res.setDataExeNumber(AllEntityMapperFactory.getAllEntityMapper().insertEntity(rqes.getObject()));
				break;
			}
			case BaseObjectOPRequest.SUBMITTYPE_UPDATEBYID_2:{
				res.setDataExeNumber(AllEntityMapperFactory.getAllEntityMapper().updateEntityById(rqes.getObject() ));
				break;
			}case BaseObjectOPRequest.SUBMITTYPE_DELETEBYID_3:{
				res.setDataExeNumber(AllEntityMapperFactory.getAllEntityMapper().deleteEntity(rqes.getObject() ));
				break;
			}default:{
				res.setReturnCode(AbsResponse.PARAMERROR);
				res.setMessage("参数错误");
				break;
			}
		}
		return res;
	}

	@Override
	public String serviceCode() {
		return "BASESUBMIT";
	}

	
}
