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
package com.gsitm.user.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gsitm.common.dto.MeetingRoomDTO;
import com.gsitm.common.dto.WorkSpaceDTO;
import com.gsitm.user.service.MtRoomService;
import com.gsitm.user.service.WorkSpaceService;


@Controller
@RequestMapping("/info/*")
public class InfoController {
	
	@Inject
	private WorkSpaceService workSpaceService;
	
	@Inject
	private MtRoomService mtRoomService;
	
	@RequestMapping("workspace.do")
	public ModelAndView workspaceInfoView(ModelAndView mv,WorkSpaceDTO workSpaceDTO) {
		List<WorkSpaceDTO> list = workSpaceService.getWorkSpaceList(workSpaceDTO);
		mv.setViewName("user/info/workspaceInfo");
		mv.addObject("workSpaceList", list);
		return mv;
	}
	
	@RequestMapping("workspaceDetail.do")
	public ModelAndView workspaceDetail(ModelAndView mv, MeetingRoomDTO meetingRoomDTO, @RequestParam("workName") String workName, @RequestParam("workAddr") String workAddr) {
		List<MeetingRoomDTO> mtRoomList = mtRoomService.getMtRoomList(meetingRoomDTO);
		mv.setViewName("user/info/workInfo-detail");
		mv.addObject("mtRoomList", mtRoomList);
		mv.addObject("workName", workName);
		mv.addObject("workAddr", workAddr);
		return mv;
	}
}
