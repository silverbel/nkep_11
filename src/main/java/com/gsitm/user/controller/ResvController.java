/**
 * @programName : ResvController.java
 * @author      : 은종현
 * @date        : 2018-06-11
 * @function    : 예약 서비스
 *
 * [이름]   [수정일]     [내용]
 * ----------------------------------------------------------
 * 은종현	   2018-06-11	초안
 */ 
package com.gsitm.user.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gsitm.user.service.ResvService;

@Controller
@RequestMapping("/resv/*")
public class ResvController {
	
	@Resource(name="resvService")
	private ResvService ResvService;
	
	@RequestMapping(value="resvStep1.do", method=RequestMethod.GET)
	public String resvStep1(Model model) {
		
		return "user/rsvSelectWork";
	}
	
	@RequestMapping("resvStep2.do")
	public String resvStep2() {
		return "user/reservation";
	}
}
