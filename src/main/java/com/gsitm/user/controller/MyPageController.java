package com.gsitm.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @programName : MyPageController.java
 * @author      : 김동범
 * @date        : 2018. 6. 11. 
 * @function    : mypage 처리 controller
 *
 * [이름]   [수정일]     [내용]
 * ----------------------------------------------------------
 * 
 */ 

@Controller
public class MyPageController {

	
	@RequestMapping(value="/myPage/info.do", method=RequestMethod.GET)
	public String myPageInfoView() {
		return "user/myPage/myInfo";
	}
	
	
	@RequestMapping(value="/myPage/myReserva.do", method=RequestMethod.GET)
	public String myPageRsvView() {
		return "user/myPage/myReservation";
	}
}
