/**
 * @programName : ResvController.java
 * @author      : 은종현
 * @date        : 2018-06-11
 * @function    : 예약 서비스
 *
 * [이름]   [수정일]     [내용]
 * ----------------------------------------------------------
 * 은종현	   2018-06-11	초안
 */ 
package com.gsitm.user.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gsitm.common.dto.InsertResvDTO;
import com.gsitm.common.dto.ResvDTO;
import com.gsitm.common.dto.ResvItemInfoDTO;
import com.gsitm.common.dto.WorkSpaceDTO;
import com.gsitm.user.service.ResvService;
import com.gsitm.user.service.WorkSpaceService;

@Controller
@RequestMapping("/resv/*")
public class ResvController {
	
	@Resource(name="resvService")
	private ResvService rService;
	
	@Resource(name="wServiceForUser")
	private WorkSpaceService wService;
	
	@RequestMapping(value="resvStep1.do", method=RequestMethod.GET)
	public String resvStep1(Model model, WorkSpaceDTO workSpaceDTO) {
		
		model.addAttribute("workSpaceList", wService.getWorkSpaceList(workSpaceDTO));
		return "user/reservation/resvStep1";
	}
	
	@RequestMapping(value="resvStep2.do", method=RequestMethod.GET)
	public String resvStep2(String workSeq, Model model) {
		model.addAttribute("workSeq", workSeq);
		model.addAttribute("eduList", wService.getEduRoomList(workSeq));
		model.addAttribute("mtList", wService.getMtRoomList(workSeq));
		return "user/reservation/resvStep2";
	}
	
	@RequestMapping(value="resvStep3.do", method=RequestMethod.POST)
	public String resvStep3(InsertResvDTO insert, HttpSession session) {
		session.setAttribute("insertResv", insert);
		return "user/reservation/resvStep3";
	}
	
	@ResponseBody
	@RequestMapping(value="resvCheck.do", method=RequestMethod.POST)
	public Map<?,?> resvAlreadyBookedCheck(@RequestParam("rsvType") String rsvType,
			@RequestParam("selDate") String selDate, @RequestParam("roomSeq") String roomSeq){
		List<ResvDTO> list = rService.getResvInfoByDate(rsvType, selDate, roomSeq);
		Map<String, Object> resvList = new HashMap<>();
		resvList.put("resvList", list);
		return resvList;
	}
	
	@ResponseBody
	@RequestMapping(value="roomItemList.do", method=RequestMethod.POST)
	public Map<?,?> roomItemListCheckByRoomSeqAjax(@RequestParam("roomSeq") String roomSeq,
			@RequestParam("roomType") String roomType, @RequestParam("workSeq") String workSeq){
		
		List<?> roomInfo = wService.getAnyRoomInfo(roomType, roomSeq);
		List<ResvItemInfoDTO> itemlist = rService.roomItemListCheckByRoomSeqAjax(workSeq);
		Map<String, Object> roomItemList = new HashMap<>();
		roomItemList.put("roomItemList", itemlist);
		roomItemList.put("roomInfo", roomInfo);
		return roomItemList;
	}
}
