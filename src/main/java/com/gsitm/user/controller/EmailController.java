/**
 * @programName : EmailController.java
 * @author      : 은종현
 * @date        : 2018-06-11
 * @function    : 메일링 서비스
 *
 * [이름]   [수정일]     [내용]
 * ----------------------------------------------------------
 * 은종현	   2018-06-11	초안
 */ 
package com.gsitm.user.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gsitm.common.dto.EmailDTO;
import com.gsitm.user.service.EmailService;

@Controller
@RequestMapping("/email/*")
public class EmailController {
	@Inject
	EmailService emailService;
	
	@RequestMapping("write.do")
	public String write() {
		return "user/contact";	//email/write.jsp로 포워딩
	}
	
	@RequestMapping("send.do")
	public String send(@ModelAttribute EmailDTO dto, Model model){
		try {
			emailService.sendMail(dto);
			model.addAttribute("message", "메일이 발송되었습니다.");
			
		} catch (Exception e) {
			e.printStackTrace();
			emailService.sendMail(dto);
			model.addAttribute("message", "메일이 발송 실패...");
		}
		return "/user/contact";	// write.jsp 로 포워딩
	}
}
