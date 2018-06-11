package com.gsitm.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyPageController {

	
	@RequestMapping(value="/myPage/info.do", method=RequestMethod.GET)
	public String myPageInfoView() {
		return "user/myPageInfo";
	}
	
	
	@RequestMapping(value="/myPage/myReserva.do", method=RequestMethod.GET)
	public String myPageRsvView() {
		return "user/myPageRsv";
	}
}
