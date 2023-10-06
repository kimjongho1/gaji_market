package kh.spring.gaji.user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

public class CustomAuthenticationFailure implements AuthenticationFailureHandler {

	@Override
	public void onAuthenticationFailure(HttpServletRequest req, HttpServletResponse res, AuthenticationException arg2)
			throws IOException, ServletException {
		res.sendRedirect(req.getContextPath() + "/login?error=true");
	}
}
