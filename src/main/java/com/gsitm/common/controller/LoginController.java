package com.gsitm.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @programName : LoginController.java
 * @author      : 김동범
 * @date        : 2018. 6. 11. 
 * @function    : 로그인 컨트롤러
 *
 * [이름]   [수정일]     [내용]
 * ----------------------------------------------------------
 * 
 */ 
@Controller
public class LoginController {
	
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String loginPageView() {
		return "login";
	}
}
