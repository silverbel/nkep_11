/**
 * @programName : LoginController.java
 * @author      : 김동범
 * @date        : 2018. 6. 11. 
 * @function    : 로그인 컨트롤러
 *
 * [이름]		[수정일]     [내용]
 * ----------------------------------------------------------
 * 김동범		2018.
 */ 
package com.gsitm.common.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gsitm.common.dto.EmployeeDTO;
import com.gsitm.common.service.LoginService;


@Controller
public class LoginController {
	
	@Resource(name="loginService")
	private LoginService lService;
	
	
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String loginPageView(String error, Model model) {
		if (error != null) {
			model.addAttribute("err","Wrong ID or PASSWORD!");
		}
		return "/login";
	}
	
	@RequestMapping(value="/logout.do", method=RequestMethod.GET)
	public void logout(String error, Model model, HttpServletResponse response, HttpSession session) throws IOException {
		session.invalidate();
		response.sendRedirect("/login.do");
	}
	
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public void loginProcess(String username, String password, HttpServletRequest request, HttpServletResponse response) throws IOException {
		boolean loginCheck = false;
		HttpSession session = request.getSession();
		loginCheck = lService.loginCheck(username, password);
		if(loginCheck) {
			EmployeeDTO emp = lService.empInfo(username);
			session.setAttribute("sessionID", emp);
			response.sendRedirect("/");
		} else response.sendRedirect("/login.do?error");
	}
}
