package kh.gazimarket.db.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

public class LoginInterceptor implements HandlerInterceptor{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Object obj = request.getSession().getAttribute("SsLoginId");
		
		if(obj!=null) { //로그인 되어있지않다면
			response.sendRedirect(request.getContextPath()+"/login");
			return false;
		}
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}
}
