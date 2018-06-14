package com.gsitm.user.controller;

import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gsitm.common.dto.WorkSpaceDTO;
import com.gsitm.user.service.WorkSpaceService;

/**
 * @programName : WorkSpaceController.java
 * @author      : 남동길
 * @date        : 2018. 6. 13. 
 * @function    :  
 *
 * [이름]   [수정일]     [내용]
 * ----------------------------------------------------------
 * 
 */ 
@Controller
public class WorkSpaceController {
	@Inject
	private WorkSpaceService workSpaceService;


	@RequestMapping("/getWorkSpace.do")
	public ModelAndView memo_list(ModelAndView mv,WorkSpaceDTO workSpaceDTO) {
		List<WorkSpaceDTO> list = workSpaceService.getWorkSpaceList(workSpaceDTO);
		System.out.println(list.get(0).getWorkName());
		mv.setViewName("/user/work");
		mv.addObject("workSpaceList", list);
		return mv;
	}


}
