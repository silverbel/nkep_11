package com.gsitm.admin.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gsitm.admin.service.WorkSpaceForAdminService;
import com.gsitm.common.dto.WorkSpaceDTO;

@Controller
public class WorkSpaceForAdminController {
	
	@Inject
	private WorkSpaceForAdminService workSpaceForAdminService;

	@RequestMapping("/getWorkSpaceListForAdmin.do")
	public ModelAndView getWorkSpaceListForAdmin(ModelAndView mv,WorkSpaceDTO workSpaceDTO) {
		List<WorkSpaceDTO> list = workSpaceForAdminService.getWorkSpaceListForAdmin(workSpaceDTO);
		System.out.println(list.get(0).getWorkName());
		mv.setViewName("/admin/workSpaceList");
		mv.addObject("workSpaceList", list);
		return mv;
	}
	
	@RequestMapping("/newWorkSpaceForAdmin.do")
	public ModelAndView newWorkSpaceForAdmin(ModelAndView mv) {
		mv.setViewName("/admin/workSpaceWrite");
		return mv;
	}
	
	@RequestMapping("/modifyWorkSpaceForAdmin.do")
	public ModelAndView modifyWorkSpaceForAdmin(ModelAndView mv) {
		mv.setViewName("/admin/workSpaceModify");
		return mv;
	}
}
