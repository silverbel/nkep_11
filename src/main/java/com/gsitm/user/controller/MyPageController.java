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
package com.gsitm.user.controller;

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
import com.gsitm.common.dto.EmployeeDTO;
import com.gsitm.common.dto.ResvConfirmInfoDTO;
import com.gsitm.common.dto.ResvItemInfoDTO;
import com.gsitm.common.dto.ResvUserInfoDTO;
import com.gsitm.common.dto.TeamDTO;
import com.gsitm.user.service.BlackListService;
import com.gsitm.user.service.MemberService;
import com.gsitm.user.service.ResvService;


@Controller
public class MyPageController {
	
	
	@Resource(name="blkService")
	private BlackListService bService;
	
	@Resource(name="resvService")
	private ResvService rService;

	@Resource(name="memService")
	private MemberService mService;
	
	@RequestMapping(value="/myPage/info.do", method=RequestMethod.GET)
	public ModelAndView myPageInfoView(HttpSession session) {
		ModelAndView model = new ModelAndView("user/myPage/myInfo");
		EmployeeDTO emp = (EmployeeDTO) session.getAttribute("sessionID");
		
		// blackList
		List<BlackListLogDTO> blkList = bService.forUserList(emp.getEmpId());
		int blkCount = bService.blackListCount(emp.getEmpId());
		
		// teamList
		List<EmployeeDTO> memList = mService.showTeamMember(emp.getTeamSeq());
		TeamDTO team = mService.showTeamInfo(emp.getEmpId());
		int memCount = mService.memCount(emp.getTeamSeq());
		
		model.addObject("blkList", blkList);
		model.addObject("blkCount", blkCount);
		model.addObject("memList", memList);
		model.addObject("team", team);
		model.addObject("memCount", memCount);
		return model;
	}
	
	
	@RequestMapping(value="/myPage/myReserva.do", method=RequestMethod.GET)
	public ModelAndView myPageRsvView(HttpSession session) {
		ModelAndView model = new ModelAndView("user/myPage/myReservation");
		EmployeeDTO emp = (EmployeeDTO) session.getAttribute("sessionID");
		
		List<ResvConfirmInfoDTO> rcList = rService.showResvConfirmList(emp.getEmpId());
		int resvCnt = rService.resvCount(emp.getEmpId());
		
		model.addObject("rcList", rcList);
		model.addObject("resvCnt", resvCnt);
		
		return model;
	}
	
	@ResponseBody
	@RequestMapping(value="/myPage/showResvAllInfo.do", method=RequestMethod.POST)
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
}
