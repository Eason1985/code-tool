package com.web.common.service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import  org.springframework.transaction.annotation.Transactional  ; 

import com.web.facade.AbsRequest;
import com.web.facade.AbsResponse;


@Transactional (propagation = Propagation.REQUIRED,isolation=Isolation.DEFAULT,rollbackFor=Exception.class)
public abstract class  BusinessAbstractor implements IService {
	
	
	public final AbsResponse execute(AbsRequest obj){
		return (AbsResponse)handle((AbsRequest) obj  )  ;
	}
	
	public abstract  AbsResponse handle(AbsRequest request  ) ; 
	
}
