package com.example.sample.controller;

import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.sample.model.dao.WorkSpaceDAO;
import com.example.sample.model.dto.WorkSpaceDTO;

@Controller
public class WorkSpaceController {
	@Inject
	private WorkSpaceDAO workSpaceDAO;


	@RequestMapping("/getWorkSpace.do")
	public ModelAndView memo_list(ModelAndView mv) {
		List<WorkSpaceDTO> list = workSpaceDAO.getWorkSpaceList();
		System.out.println(list.get(0).getWorkName());
		mv.setViewName("work.jsp");
		mv.addObject("workSpaceList", list);
		return mv;
	}


}
