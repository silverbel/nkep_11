package com.gsitm.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @programName : InfoController.java
 * @author      : 은종현
 * @date        : 2018. 6. 12. 
 * @function    : 소개 페이지 처리 controller
 *
 * [이름]   [수정일]     [내용]
 * ----------------------------------------------------------
 * 은종현 	  2018-06-12    초안 	
 */ 

@Controller
@RequestMapping("/info/*")
public class InfoController {
	
	@RequestMapping("workspace.do")
	public String workspaceInfoView() {
		return "user/info/workspaceInfo";
	}
}
