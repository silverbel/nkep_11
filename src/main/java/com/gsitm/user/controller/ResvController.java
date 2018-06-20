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

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gsitm.admin.service.EmployeeForAdminService;
import com.gsitm.admin.service.ItemForAdminService;
import com.gsitm.admin.service.WorkSpaceForAdminService;
import com.gsitm.common.dto.EducationRoomDTO;
import com.gsitm.common.dto.EducationRoomPlusWSNameDTO;
import com.gsitm.common.dto.EmployeeDTO;
import com.gsitm.common.dto.InsertResvDTO;
import com.gsitm.common.dto.ItemDTO;
import com.gsitm.common.dto.MeetingRoomDTO;
import com.gsitm.common.dto.MeetingRoomPlusWSNameDTO;
import com.gsitm.common.dto.ResvDTO;
import com.gsitm.common.dto.ResvItemInfoDTO;
import com.gsitm.common.dto.RoomPlusWSNameDTO;
import com.gsitm.common.dto.WorkSpaceDTO;
import com.gsitm.eAdmin.service.EducationRoomForEadminService;
import com.gsitm.mAdmin.service.MeetingRoomForMadminService;
import com.gsitm.user.service.MemberService;
import com.gsitm.user.service.ResvService;
import com.gsitm.user.service.WorkSpaceService;

@Controller
@RequestMapping("/resv/*")
public class ResvController {
	
	@Inject
	private JavaMailSender mailSender;
	
	@Resource(name="resvService")
	private ResvService rService;
	
	@Resource(name="wServiceForUser")
	private WorkSpaceService wService;
	
	@Inject
	private ItemForAdminService itemForAdminService;
	
	@Inject 
	private MeetingRoomForMadminService mtRoomService;
	
	@Inject
	private EducationRoomForEadminService eduRoomService;
	
	@Inject
	private MemberService memberService;
	
	private final DecimalFormat df = new DecimalFormat("#,##0");
	
	private final SimpleDateFormat fm = new SimpleDateFormat("yyyy년 MM월 dd일");
	private final SimpleDateFormat parser = new SimpleDateFormat("yyyyMMdd");
	
	private final SimpleDateFormat fm2 = new SimpleDateFormat("HH:mm");
	private final SimpleDateFormat parser2 = new SimpleDateFormat("HHmm");
	
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
		System.out.println(insert.toString());
		session.setAttribute("insertResv", insert);
		return "user/reservation/resvStep3";
	}
	
	@RequestMapping(value="resvStep4.do", method=RequestMethod.POST)
	public ModelAndView resvStep4(@RequestParam("empId") String empId,HttpSession session,
			MeetingRoomDTO meetingRoomDTO,EducationRoomDTO educationRoomDTO,ModelAndView mv,
			MeetingRoomPlusWSNameDTO temp1, EducationRoomPlusWSNameDTO temp2,
			RoomPlusWSNameDTO roomInfo, EmployeeDTO employeeDTO) throws ParseException, CloneNotSupportedException {
		InsertResvDTO insert = (InsertResvDTO) session.getAttribute("insertResv");
		String[] empIdList = empId.split("/");
		insert.setEmpIdList(empIdList);
		System.out.println(insert.toString());
		session.setAttribute("insertResv", insert);
		InsertResvDTO tempInsert = insert.clone();
		Date sTemp = parser2.parse(tempInsert.getStartTime());
		Date eTemp = parser2.parse(tempInsert.getFinTime());
		tempInsert.setStartTime(fm2.format(sTemp));
		tempInsert.setFinTime(fm2.format(eTemp));
		Date temp = parser.parse(tempInsert.getToday());
		tempInsert.setToday(fm.format(temp));
		List<String> parameter = new ArrayList<String>(tempInsert.getSNACK().length+tempInsert.getFIXTURES().length+tempInsert.getEXPENDABLE().length);
	    Collections.addAll(parameter, tempInsert.getSNACK());
	    Collections.addAll(parameter, tempInsert.getFIXTURES());
	    Collections.addAll(parameter, tempInsert.getEXPENDABLE());
		List<ItemDTO> selectItems = itemForAdminService.getItemByManyItemSeq(parameter);
		for(ItemDTO i : selectItems) {
			i.setItemPrice(df.format(Double.parseDouble(i.getItemPrice())));
		}
		List<String> parameter2 = new ArrayList<String>(tempInsert.getEmpIdList().length);
		Collections.addAll(parameter2, tempInsert.getEmpIdList());
		List<EmployeeDTO> empList = memberService.getEmployeeBySabun(parameter2);
		if(tempInsert.getRoomType().equals("M")) {
			meetingRoomDTO.setMtSeq(insert.getRoomSeq());
			temp1 = mtRoomService.getMeetingRoomByMtSeq(meetingRoomDTO);
//			temp1.setMtPrice(df.format(Double.parseDouble(temp1.getMtPrice())));
			roomInfo.setRoomSeq(temp1.getMtSeq());
			roomInfo.setRoomCode(temp1.getMtCode());
			roomInfo.setRoomName(temp1.getMtName());
			roomInfo.setRoomSize(temp1.getMtSize());
			roomInfo.setRoomPrice(df.format(Double.parseDouble(temp1.getMtPrice())));
			roomInfo.setRoomAvail(temp1.getMtAvail());
			roomInfo.setRoomDescription(temp1.getMtDescription());
			roomInfo.setWorkSeq(temp1.getWorkSeq());
			roomInfo.setWorkCode(temp1.getWorkCode());
			roomInfo.setWorkName(temp1.getWorkName());
			roomInfo.setRoomAvailEtime(temp1.getMtAvailEtime());
			roomInfo.setRoomAvailStime(temp1.getMtAvailStime());
			mv.addObject("roomInfo",roomInfo);
		}else if(tempInsert.getRoomType().equals("E")) {
			educationRoomDTO.setEduSeq(insert.getRoomSeq());
			temp2 = eduRoomService.getEducationRoomByEduSeq(educationRoomDTO);
			roomInfo.setRoomSeq(temp2.getEduSeq());
			roomInfo.setRoomCode(temp2.getEduCode());
			roomInfo.setRoomName(temp2.getEduName());
			roomInfo.setRoomSize(temp2.getEduSize());
			roomInfo.setRoomPrice(df.format(Double.parseDouble(temp2.getEduPrice())));
			roomInfo.setRoomAvail(temp2.getEduAvail());
			roomInfo.setRoomDescription(temp2.getEduDescription());
			roomInfo.setWorkSeq(temp2.getWorkSeq());
			roomInfo.setWorkCode(temp2.getWorkCode());
			roomInfo.setWorkName(temp2.getWorkName());
			roomInfo.setRoomAvailEtime(temp2.getEduAvailEtime());
			roomInfo.setRoomAvailStime(temp2.getEduAvailStime());
			mv.addObject("roomInfo",roomInfo);
		}
		mv.setViewName("user/reservation/resvStep4");
		mv.addObject("items",selectItems);
		mv.addObject("empList",empList);
		mv.addObject("insert",tempInsert);
		return mv;
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
		/*for(Object ed : roomInfo) {
			System.out.println(((EducationRoomDTO) ed).toString());
		}*/
		List<ResvItemInfoDTO> itemlist = rService.roomItemListCheckByRoomSeqAjax(workSeq);
		Map<String, Object> roomItemList = new HashMap<>();
		roomItemList.put("roomItemList", itemlist);
		roomItemList.put("roomInfo", roomInfo);
		return roomItemList;
	}
	
	@ResponseBody
	@RequestMapping(value="allMemberListAjax.do")
	public Map<?,?> allMemberListAjax(){
		List<EmployeeDTO> empList = rService.allMemberListAjax();
		Map<String, Object> data = new HashMap<>();
		data.put("empList", empList);
		return data;
	}
}
