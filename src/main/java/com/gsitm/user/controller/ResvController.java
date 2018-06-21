
package com.gsitm.user.controller;

import java.io.UnsupportedEncodingException;
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
import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gsitm.admin.service.ItemForAdminService;
import com.gsitm.common.dto.EducationRoomDTO;
import com.gsitm.common.dto.EducationRoomPlusWSNameDTO;
import com.gsitm.common.dto.EmployeeDTO;
import com.gsitm.common.dto.InsertResvDTO;
import com.gsitm.common.dto.ItemDTO;
import com.gsitm.common.dto.MeetingRoomDTO;
import com.gsitm.common.dto.MeetingRoomPlusWSNameDTO;
import com.gsitm.common.dto.ResvConfirmInfoDTO;
import com.gsitm.common.dto.ResvItemInfoDTO;
import com.gsitm.common.dto.RoomPlusWSNameDTO;
import com.gsitm.common.dto.TeamDTO;
import com.gsitm.common.dto.WorkSpaceDTO;
import com.gsitm.eAdmin.service.EducationRoomForEadminService;
import com.gsitm.mAdmin.service.MeetingRoomForMadminService;
import com.gsitm.user.mail.MailHandler;
import com.gsitm.user.service.MemberService;
import com.gsitm.user.service.ResvService;
import com.gsitm.user.service.WorkSpaceService;

/**
 * @programName : ResvController.java
 * @author      : 은종현
 * @date        : 2018-06-11
 * @function    : 예약 서비스
 *
 * [이름]	   	[수정일]     [내용]
 * ----------------------------------------------------------
 * 은종현	   2018-06-11	초안
 * 김동범		18.06.15	예약 내역 확인
 * 김동범		18.06.18	뷰에서 보내는 데이터 확인
 */ 


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

		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!" + insert.getStartTime());
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!" + insert.getFinTime());
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
		InsertResvDTO tempInsert = insert.clone();
		Date sTemp = null;
		Date eTemp = null;
		if("S".equals(tempInsert.getRsvType())) {
			sTemp = parser2.parse(tempInsert.getStartTime());
			eTemp = parser2.parse(tempInsert.getFinTime());
			tempInsert.setStartTime(fm2.format(sTemp));
			tempInsert.setFinTime(fm2.format(eTemp));
		}
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
		List<EmployeeDTO> empList = memberService.getEmployeeByManySabun(parameter2);
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
			insert.setWorkName(temp1.getWorkName());
			insert.setRoomPrice(temp1.getMtPrice());
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
			insert.setWorkName(temp2.getWorkName());
			insert.setRoomPrice(temp2.getEduPrice());
			mv.addObject("roomInfo",roomInfo);
		}
		session.setAttribute("insertResv", insert);
		session.setAttribute("trimedInsertResv", tempInsert);
		session.setAttribute("items", selectItems);
		session.setAttribute("empList", empList);
		System.out.println(insert.toString());
		mv.setViewName("user/reservation/resvStep4");
		mv.addObject("items",selectItems);
		mv.addObject("empList",empList);
		mv.addObject("insert",tempInsert);
		return mv;
	}
	
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/resvStep5.do")
	public ModelAndView resvvStep5(ModelAndView mv,HttpSession session,InsertResvDTO insert,
			TeamDTO teamDTO,EmployeeDTO bossInfo) throws MessagingException, ParseException, UnsupportedEncodingException {
		EmployeeDTO currnetLoginEmp = (EmployeeDTO) session.getAttribute("sessionID");
		System.out.println("현재 로그인한 아이디!!!!!!!!!!!!!!"+currnetLoginEmp.getEmpId());
		insert = (InsertResvDTO) session.getAttribute("insertResv");
		insert.setTeamSeq(currnetLoginEmp.getTeamSeq());
		System.out.println(insert.toString());
		insert.setRsvSeq(insert.getRoomType()+insert.getRsvType()+insert.getToday()+insert.getStartTime()+insert.getFinTime());
		insert.setRsvCnt(String.valueOf(insert.getEmpIdList().length+1));
		Date end = parser2.parse(insert.getFinTime());
		Date start = parser2.parse(insert.getStartTime());
		insert.setStartTime(fm2.format(start));
		insert.setFinTime(fm2.format(end));
		if("S".equals(insert.getRsvType())) {
			insert.setRsvDate(insert.getSelDate()+" "+insert.getStartTime());
			insert.setRsvFdate(insert.getSelDate()+" "+insert.getFinTime());
		} else {
			insert.setRsvDate(insert.getStartTime());
			insert.setRsvFdate(insert.getFinTime());
		}
	
		long diff = end.getTime() - start.getTime();
		long _30minutes = diff / 1800000;
		String rsvPrice = String.valueOf(Long.parseLong(insert.getRoomPrice()) * _30minutes);
		insert.setRsvPrice(rsvPrice);
		insert.setApplicant(currnetLoginEmp.getEmpId());
		rService.insertResv(insert);
		
		
		ArrayList<String> parameter = new ArrayList<String>(insert.getSNACK().length+insert.getFIXTURES().length+insert.getEXPENDABLE().length);
	    Collections.addAll(parameter, insert.getSNACK());
	    Collections.addAll(parameter, insert.getFIXTURES());
	    Collections.addAll(parameter, insert.getEXPENDABLE());
	    insert.setItems(parameter);
		rService.insertRI(insert);
		
		ArrayList<String> empIds = new ArrayList<>();
		Collections.addAll(empIds, insert.getEmpIdList());
		insert.setEmpIds(empIds);
		rService.insertRDNotApplicant(insert);
		rService.insertRDApplicant(insert);
		
		
		rService.insertConfirm(insert);
		
		teamDTO = memberService.showTeamInfo(currnetLoginEmp.getEmpId());
		String bossId = teamDTO.getBossId();
		bossInfo = memberService.getTeamBossById(bossId);

		InsertResvDTO trimedInsert = (InsertResvDTO) session.getAttribute("trimedInsertResv");
		List<ItemDTO> items = (List<ItemDTO>) session.getAttribute("items");
		List<EmployeeDTO> emps = (List<EmployeeDTO>) session.getAttribute("empList");
		
		MailHandler sendMail = new MailHandler(mailSender);
		sendMail.setSubject(bossInfo.getTeamSeq()+"팀 팀장님 예약을 위한 승인이 필요합니다.");
		String mailContent = insert.getApplicant()+"가(이) 예약을 신청했습니다.<br>"+insert.getWorkName()+
				insert.getRoomName()+"에서"+"&nbsp;"+insert.getRsvDate()+"~"+insert.getRsvFdate()+"<br>대여비 : "+insert.getRoomPrice()+"원<br>";
		
		for(ItemDTO item : items) {
			mailContent += item.getItemName()+"&nbsp;&nbsp;"+item.getItemPrice()+"<br>";
		}
		mailContent += "총 " +insert.getRsvCnt()+"명<br>";
		for(EmployeeDTO emp : emps) {
			mailContent += emp.getEmpId()+"&nbsp;&nbsp;"+emp.getEmpName()+"\t"+emp.getEmail()+"<br>";
		}
		sendMail.setText(new StringBuffer().append("<!DOCTYPE html>\r\n" + 
				"<html>\r\n" + 
				"<head>\r\n" + 
				"  <title></title>\r\n" + 
				"</head>\r\n" + 
				"<body sytle=\"width: 100% !important; height: 100%; background: #f8f8f8;\">\r\n" + 
				"<table class=\"body-wrap\" style=\"width: 100% !important; height: 100%; background: #f8f8f8;\">\r\n" + 
				"    <tr>\r\n" + 
				"        <td class=\"container\">\r\n" + 
				"\r\n" + 
				"            <!-- Message start -->\r\n" + 
				"            <table style=\"width: 580px; height: 40px; margin: 0 auto;\">\r\n" + 
				"                <tr>\r\n" + 
				"                    <td align=\"center\" class=\"masthead\" style=\"padding: 80px 0; background: #3DB7CC; color: white; \">\r\n" + 
				"\r\n" + 
				"                        <h1 style=\"margin: 0 auto !important; max-width: 90%\"> 승인을 기다립니다. </h1>\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"                    </td>\r\n" + 
				"                </tr>\r\n" + 
				"                <tr>\r\n" + 
				"                    <td class=\"content\" style=\"background: white; padding: 30px 35px;\">\r\n" + 
				"            <img style=\"max-width: 100%; margin: 0 auto; display: block;\" src=\"https://i.imgur.com/Q0zUYOW.png\"/> <br>\r\n" + 
				"                        <h2>시스템 관리자에게,</h2>\r\n" + 
				"\r\n" + 
				"                        <p>"+bossInfo.getTeamSeq() +"조 팀장님"+mailContent+"<br>감사합니다.</p>\r\n" + 
				"\r\n" + 
				"                        <table>\r\n" + 
				"                            <tr>\r\n" + 
				"                                <td align=\"center\">\r\n" + 
				"                                    <p>\r\n" + 
				"                                        <a href=\"http://localhost:9090/resv/confirm.do?rsvSeq="+insert.getRsvSeq()+"&bossYn=Y\" class=\"button\">승인</a> <a href=\"http://localhost:9090/resv/confirm.do?rsvSeq=\"+trimedInsert.getRsvSeq()+\"&bossYn=N\" class=\"button\">반려</a>\r\n" + 
				"                                    </p>\r\n" + 
				"                                </td>\r\n" + 
				"                            </tr>\r\n" + 
				"                        </table>\r\n" + 
				"\r\n" + 
				"                        <p>문의사항이 문의는, <a href=\"https://www.gsitm.com/\">GS ITM</a>에 방문해 주십시오.</p>\r\n" + 
				"\r\n" + 
				"                        <p><em>-GS ITM 예약시스템</em></p>\r\n" + 
				"\r\n" + 
				"                    </td>\r\n" + 
				"                </tr>\r\n" + 
				"            </table>\r\n" + 
				"\r\n" + 
				"        </td>\r\n" + 
				"    </tr>\r\n" + 
				"    <tr>\r\n" + 
				"        <td class=\"container\">\r\n" + 
				"\r\n" + 
				"            <!-- Message start -->\r\n" + 
				"            <table style=\"margin: 0 auto;\">\r\n" + 
				"                <tr>\r\n" + 
				"                    <td class=\"content footer\" align=\"center\" style=\"padding:30px 35px\">\r\n" + 
				"                        <p style=\"margin-bottom: 0; color: #888; text-align: center; font-size: 14px;\">&nbsp;&nbsp;&nbsp;&nbsp;Sent by <a href=\"#\" style=\"color: #888; text-decoration: none; font-weight: bold;\">GS ITM</a>, 서울특별시 종로구 계동 84</p>\r\n" + 
				"                        <p style=\"margin-bottom: 0; color: #888; text-align: center; font-size: 14px;\"><a href=\"mailto:\" style=\"color: #888; text-decoration: none; font-weight: bold;\">&nbsp;&nbsp;&nbsp;&nbsp;gsitm@gsitm.com</a> | <a href=\"#\">Unsubscribe</a></p>\r\n" + 
				"                    </td>\r\n" + 
				"                </tr>\r\n" + 
				"            </table>\r\n" + 
				"\r\n" + 
				"        </td>\r\n" + 
				"    </tr>\r\n" + 
				"</table>\r\n" + 
				"</body>\r\n" + 
				"</html>")
				.toString());
		sendMail.setFrom("abc@abc.com", "GS ITM 예약시스템");
		sendMail.setTo(bossInfo.getEmail());
		if(!(insert.getRoomType().equals("M") && insert.getRsvType().equals("S"))) {
	         sendMail.send();
	         mv.setViewName("user/reservation/resvStep5");
	      }
	      
	      mv.setViewName("user/reservation/resvStep5");
	      mv.addObject("complete", "예약완료");
		return mv;
	}
	
	@RequestMapping("/confirm.do")
	public ModelAndView confirm(ModelAndView mv,@RequestParam("rsvSeq") String rsvSeq,
			@RequestParam("bossYn") String bossYn) {
		mv.setViewName("/main.do");
		return mv;
	}
	
	
	@ResponseBody
	@RequestMapping(value="resvCheck.do", method=RequestMethod.POST)
	public Map<?,?> resvAlreadyBookedCheck(@RequestParam("rsvType") String rsvType,
			@RequestParam("selDate") String selDate, @RequestParam("roomSeq") String roomSeq){
		List<ResvConfirmInfoDTO> list = rService.getResvInfoByDate(rsvType, selDate, roomSeq);
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
	
	@ResponseBody
	@RequestMapping(value="allMemberListAjax.do")
	public Map<?,?> allMemberListAjax(){
		List<EmployeeDTO> empList = rService.allMemberListAjax();
		Map<String, Object> data = new HashMap<>();
		data.put("empList", empList);
		return data;
	}
}
