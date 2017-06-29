package com.web.common.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.filter.OncePerRequestFilter;

import com.web.common.controller.BaseController;
import com.web.common.exception.BusinessException;

public class LoginFilter extends OncePerRequestFilter {
	/**
	 * Should a character encoding specified by the client be ignored?
	 */
	private final static String[] ignore_url = {"/login.jsp" ,"/index.do", "/login.do", "/logout.do" };// 进入各子平台时不用坐登录check

	private String checkErrorPage = "/webapp/login.jsp";
	
	public void doFilterInternal(HttpServletRequest request,
			HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		boolean haveCheck = true;
		int isDoRequest = request.getRequestURI().indexOf(".do") ; 
		int isJspRequest = request.getRequestURI().indexOf(".jsp") ; 
		if (isDoRequest < 0 && isJspRequest < 0) {
			haveCheck = false;
		}
		if(haveCheck){
			for (int i = 0; i < ignore_url.length; i++) {
				if (request.getRequestURI().indexOf(ignore_url[i]) >= 0) {
					haveCheck = false;
					break;
				}
			}
		}
		if("app".equals(request.getParameter("from"))){
			haveCheck = false ; 
		}
		if (haveCheck) {
			Object username = session
					.getAttribute(BaseController.SESSION_SET_KEY_USER);// 这里获取session，为了检查session里有没有保存用户信息，没有的话回转发到登陆页面
			// 跳转到登陆页面
			if (username == null) {
				if (isDoRequest > 0 ) {
					String json = "{\"error\":" + true + ",\"errorCode\":\"" + "00000001"+"\""+ ",\"message\":\"" + "请先登录!"+"\"}";
					outJSOND(response,  json) ;
					return ;
				}
			}
		}
		// 已经登陆,继续此次请求
		try{ 
			long beginTime = System.currentTimeMillis() ; 
			filterChain.doFilter(request, response);
			if(isDoRequest > 0 && (System.currentTimeMillis()-beginTime)/1000 > 2 ){
				logger.error(request.getRequestURI()+"===========END===============耗时:"+((System.currentTimeMillis()-beginTime)/1000)+"毫秒");
			}
		}catch(BusinessException  e ){
			logger.error(e.getMessage(),e);
			String message = e.getErrorMessage();
			String errorCode = e.getErrorCode();
			String json = "{\"error\":" + true + ",\"errorCode\":\"" + errorCode +"\""+ ",\"message\":\"" + message+"\"}";
			outJSOND(response,  json) ; 
		}catch(Exception e ){
			logger.error("请求["+request.getRequestURI()+"]服务错误",e);
			if( e.getCause() instanceof BusinessException){
				String message = ((BusinessException)e.getCause()).getErrorMessage();
				String errorCode = ((BusinessException)e.getCause()).getErrorCode();
				String json = "{\"error\":" + true + ",\"errorCode\":\"" + errorCode +"\""+ ",\"message\":\"" + message+"\"}";
				outJSOND(response,  json) ; 
			}else{
				String message =  "请求服务错误";
				String errorCode = "99999999";
				String json = "{\"error\":" + true + ",\"errorCode\":\"" + errorCode +"\""+ ",\"message\":\"" + message+"\"}";
				outJSOND(response,  json) ; 
			}
		}
		
	}

	public String getCheckErrorPage() {
		return checkErrorPage;
	}

	public void setCheckErrorPage(String checkErrorPage) {
		this.checkErrorPage = checkErrorPage;
	}
	
	/**
	 * 输出JSOND数据   
	 * **/
	 public void outJSOND(HttpServletResponse response, String content)  {
		response.setContentType( "text/plain;charset=UTF-8" );
		try {
			PrintWriter _writer  = response.getWriter();
			_writer.print(content);
			_writer.flush();
			_writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	 }
}
