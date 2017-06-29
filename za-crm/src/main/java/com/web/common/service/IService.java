package com.web.common.service;

import com.web.facade.AbsRequest;
import com.web.facade.AbsResponse;

/**	
 * 					 Controller
 * 						 |			
 * 						 |
 * 			       ServiceFacade
 * 					  /    \					
 *                   /      \
 *                  /        \
 *               Service<--- Business(与service的区别是business有数据库事务,且business可以调用service)
 *                  \         /
 *                   \       /
 *                    \     /
 *                     \   /
 *                      APP (Service与business都可以访问APP)  
 * 
 * 
 * 
 * 
 * @author Administrator
 *
 */
public interface IService {

	AbsResponse execute(AbsRequest obj) ;
	String serviceCode () ; 
}
