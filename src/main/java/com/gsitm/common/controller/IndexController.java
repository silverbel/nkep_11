package com.gsitm.common.controller;


import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gsitm.common.dto.WorkSpaceDTO;
import com.gsitm.user.service.WorkSpaceService;

@Controller
public class IndexController {
	
	@Inject
	private WorkSpaceService workSpaceService;

	
	@RequestMapping("/main.do")
	public ModelAndView goMain(ModelAndView mv, WorkSpaceDTO workSpaceDTO) {
		List<WorkSpaceDTO> list = workSpaceService.getWorkSpaceList(workSpaceDTO);
		mv.setViewName("user/index");
		mv.addObject("workSpaceList", list);
		return mv;
	}
	
}
