package com.gsitm.admin.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gsitm.common.dto.WorkSpaceDTO;
import com.gsitm.user.service.WorkSpaceService;

@Controller
public class AdminMasterController {

	@Resource(name="wServiceForUser")
	private WorkSpaceService wService;
	
	@RequestMapping("/admin.do")
	public ModelAndView adminIndex(ModelAndView mv, WorkSpaceDTO workSpaceDTO) {
		mv.setViewName("/admin/index");
		mv.addObject("workSpaceList", wService.getWorkSpaceList(workSpaceDTO));
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
