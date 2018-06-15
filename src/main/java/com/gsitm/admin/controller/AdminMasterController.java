package com.gsitm.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminMasterController {

	@RequestMapping("/admin.do")
	public ModelAndView adminIndex(ModelAndView mv) {
		mv.setViewName("/admin/index");
		return mv;
	}
	
	@RequestMapping("/eAdmin.do")
	public ModelAndView eAdminIndex(ModelAndView mv) {
		mv.setViewName("/eAdmin/index");
		return mv;
	}
	
	@RequestMapping("/mAdmin.do")
	public ModelAndView mAdminIndex(ModelAndView mv) {
		mv.setViewName("/mAdmin/index");
		return mv;
	}
}
