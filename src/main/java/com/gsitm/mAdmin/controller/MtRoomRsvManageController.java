/**
 * @programName : MyPageController.java
 * @author      : 김동범
 * @date        : 2018. 6. 11. 
 * @function    : mypage 처리 controller
 *
 * [이름]   [수정일]     [내용]
 * ----------------------------------------------------------
 * 
 */ 
package com.gsitm.mAdmin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gsitm.common.dto.BlackListLogDTO;
import com.gsitm.common.dto.ConfirmDTO;
import com.gsitm.common.dto.EmployeeDTO;
import com.gsitm.common.dto.ResvConfirmInfoDTO;
import com.gsitm.common.dto.ResvDTO;
import com.gsitm.common.dto.ResvDetailDTO;
import com.gsitm.common.dto.ResvItemInfoDTO;
import com.gsitm.common.dto.ResvUserInfoDTO;
import com.gsitm.common.dto.TeamDTO;
import com.gsitm.user.service.BlackListService;
import com.gsitm.user.service.MemberService;
import com.gsitm.user.service.ResvService;


@Controller
public class MtRoomRsvManageController {
	
	@Resource(name="resvService")
	private ResvService rService;
	
			
	@RequestMapping(value="/mtRoomRsvManagement.do", method=RequestMethod.GET)
	public ModelAndView myPageRsvView(ModelAndView mv, ResvDTO dto) {
		List<ResvDTO> list = rService.mtRoomRsvList(dto);
		mv.setViewName("mAdmin/mRsvList");
		mv.addObject("mtRoomRsvList", list);
		return mv;
	}
	
/*	@ResponseBody
	@RequestMapping(value="/mtRoomRsvManagement.do", method=RequestMethod.POST)
	public Map<String, Object> showResvInfoByAjax(@RequestParam(value="rsvSeq") String rsvSeq) {
		
		List<ResvUserInfoDTO> ruList = rService.showResvUserList(rsvSeq);
		List<ResvItemInfoDTO> riList = rService.showResvItemList(rsvSeq);
		ResvConfirmInfoDTO rcInfo = rService.showResvDetail(rsvSeq);
		
		Map<String, Object> resvInfo = new HashMap<>();
		resvInfo.put("ruList", ruList);
		resvInfo.put("riList", riList);
		resvInfo.put("rcInfo", rcInfo);
		
		
		return resvInfo;
	}
	
	@RequestMapping(value="/myPage/deleteMyResv.do")
	public ModelAndView deleteMyResv(ModelAndView mv, @RequestParam("rsvSeq") String rsvSeq,
			ResvDTO resvDTO, ConfirmDTO confirmDTO, ResvDetailDTO resvDetailDTO) {
		resvDTO.setRsvSeq(rsvSeq);
		rService.deleteResv(resvDTO);
		
		confirmDTO.setRsvSeq(rsvSeq);
		rService.deleteConfirm(confirmDTO);
		
		resvDetailDTO.setRsvSeq(rsvSeq);
		rService.deleteResvDetail(resvDetailDTO);
		
		mv.setViewName("redirect:/myPage/myReserva.do");
		return mv;		
	}*/
		
}
