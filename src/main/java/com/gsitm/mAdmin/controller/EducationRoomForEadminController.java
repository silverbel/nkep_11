package com.gsitm.mAdmin.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gsitm.mAdmin.service.EducationRoomForEadminService;

@Controller
public class EducationRoomForEadminController {

	@Inject
	private EducationRoomForEadminService educationRoomForEadminService;
	
	@RequestMapping("/educationRoomList.do")
	public ModelAndView educationRoomList(ModelAndView mv) {
		mv.setViewName("eAdmin/educationRoomList");
		return mv;
	}
	
}
