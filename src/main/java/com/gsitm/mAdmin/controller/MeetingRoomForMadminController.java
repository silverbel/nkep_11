package com.gsitm.mAdmin.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.gsitm.admin.service.WorkSpaceForAdminService;
import com.gsitm.common.dto.EducationRoomDTO;
import com.gsitm.common.dto.EducationRoomPlusWSNameDTO;
import com.gsitm.common.dto.MeetingRoomDTO;
import com.gsitm.common.dto.MeetingRoomPlusWSNameDTO;
import com.gsitm.common.dto.WorkSpaceDTO;
import com.gsitm.mAdmin.service.MeetingRoomForMadminService;

@Controller
public class MeetingRoomForMadminController {

	private static final Logger logger = LoggerFactory.getLogger(MeetingRoomForMadminController.class);
	@Inject
	private MeetingRoomForMadminService meetingRoomForMadminService;
	
	@Inject
	private WorkSpaceForAdminService workSpaceForAdminService;
	
	@RequestMapping("/meetingRoomList.do")
	public ModelAndView meetingRoomList(ModelAndView mv, MeetingRoomDTO meetingRoomDTO, WorkSpaceDTO workSpaceDTO) {
		List<MeetingRoomDTO> meetRoomList = meetingRoomForMadminService.getMtRoomList(meetingRoomDTO);
		List<WorkSpaceDTO> workSpaceList = workSpaceForAdminService.getWorkSpaceListForAdmin(workSpaceDTO);
		mv.addObject("meetRoomList", meetRoomList);
		mv.addObject("workSpaceList",workSpaceList);
		mv.setViewName("mAdmin/meetingRoomList");
		return mv;
	}
	
	@RequestMapping("/newMeetingRoomForAdminForm.do")
	public ModelAndView newMeetingRoomForAdminForm(ModelAndView mv,WorkSpaceDTO workSpaceDTO) {
		List<WorkSpaceDTO> workSpaceList = workSpaceForAdminService.getWorkSpaceListForAdmin(workSpaceDTO);
		mv.addObject("workSpaceList", workSpaceList);
		mv.setViewName("mAdmin/meetingRoomWrite");
		return mv;
	}
	
	@RequestMapping("/newMeetingRoomForAdmin.do")
	public ModelAndView newMeetingRoomForAdmin(ModelAndView mv,MultipartHttpServletRequest multipartHttpServletRequest,
			MeetingRoomDTO meetingRoomDTO) throws IOException {
		String workSeqPlusWorkCode = multipartHttpServletRequest.getParameter("workSeq");
		String[] workSpaces = workSeqPlusWorkCode.split("\\/");
		String workSeq = workSpaces[0];
		String workCode = workSpaces[1];
		String mtName = multipartHttpServletRequest.getParameter("mtName");
		String mtSize = multipartHttpServletRequest.getParameter("mtSize");
		String mtPrice = multipartHttpServletRequest.getParameter("mtPrice");
		String mtAvail = multipartHttpServletRequest.getParameter("mtAvail");
		String mtDescription = multipartHttpServletRequest.getParameter("mtDescription");
		List<MultipartFile> multipartFiles = multipartHttpServletRequest.getFiles("files[]");

		meetingRoomDTO.setWorkSeq(workSeq);
		meetingRoomDTO.setWorkCode(workCode);
		meetingRoomDTO.setMtName(mtName);
		meetingRoomDTO.setMtPrice(mtPrice);
		meetingRoomDTO.setMtSize(mtSize);
		meetingRoomDTO.setMtAvail(mtAvail);
		meetingRoomDTO.setMtDescription(mtDescription);
		if(multipartFiles.size() == 1) {
			meetingRoomDTO.setMtImg(multipartFiles.get(0).getBytes());
		}else if(multipartFiles.size() == 2) {
			meetingRoomDTO.setMtImg(multipartFiles.get(0).getBytes());
			meetingRoomDTO.setMtImg2(multipartFiles.get(1).getBytes());
		}else if(multipartFiles.size() == 3) {
			meetingRoomDTO.setMtImg(multipartFiles.get(0).getBytes());
			meetingRoomDTO.setMtImg2(multipartFiles.get(1).getBytes());
			meetingRoomDTO.setMtImg3(multipartFiles.get(2).getBytes());
		}
		

		meetingRoomForMadminService.insertMeetingRoomForAdmin(meetingRoomDTO);
		mv.setViewName("redirect:/meetingRoomList.do");
		return mv;
	}
	
	@RequestMapping("/modifyMeetingRoomForAdminForm.do")
	public ModelAndView modifyMeetingRoomForAdminForm(ModelAndView mv,
			@RequestParam("mtSeq") String mtSeq,MeetingRoomDTO meetingRoomDTO) {
		MeetingRoomPlusWSNameDTO dto = meetingRoomForMadminService.getMeetingRoomByMtSeq(meetingRoomDTO);
		mv.addObject("meetingRoomPlusWSNameDTO", dto);
		mv.setViewName("/mAdmin/meetingRoomModify");
		return mv;
	}
	
	@RequestMapping("/modifyMeetingRoomForAdmin.do")
	public ModelAndView modifyMeetingRoomForAdmin(ModelAndView mv,
			MultipartHttpServletRequest multipartHttpServletRequest,
			@RequestParam("mtSeq") String mtSeq, MeetingRoomDTO meetingRoomDTO) throws IOException {
		meetingRoomDTO.setMtSeq(mtSeq);
		String mtName = multipartHttpServletRequest.getParameter("mtName");
		String mtAvail = multipartHttpServletRequest.getParameter("mtAvail");
		String mtSize = multipartHttpServletRequest.getParameter("mtSize");
		String mtPrice = multipartHttpServletRequest.getParameter("mtPrice");
		String mtDescription = multipartHttpServletRequest.getParameter("mtDescription");
		if(multipartHttpServletRequest.getParameter("changeFlag") == null) {
			List<MultipartFile> multipartFiles = multipartHttpServletRequest.getFiles("files[]");
			if(multipartFiles.size() == 1) {
				meetingRoomDTO.setMtImg(multipartFiles.get(0).getBytes());
			}else if(multipartFiles.size() ==2) {
				meetingRoomDTO.setMtImg(multipartFiles.get(0).getBytes());
				meetingRoomDTO.setMtImg2(multipartFiles.get(1).getBytes());
			}else if(multipartFiles.size() == 3) {
				meetingRoomDTO.setMtImg(multipartFiles.get(0).getBytes());
				meetingRoomDTO.setMtImg2(multipartFiles.get(1).getBytes());
				meetingRoomDTO.setMtImg3(multipartFiles.get(2).getBytes());
			}
			meetingRoomDTO.setMtName(mtName);
			meetingRoomDTO.setMtAvail(mtAvail);
			meetingRoomDTO.setMtSize(mtSize);
			meetingRoomDTO.setMtPrice(mtPrice);
			meetingRoomDTO.setMtDescription(mtDescription);
			logger.info(meetingRoomDTO.toString());
			meetingRoomForMadminService.updateMtRoomIncludePic(meetingRoomDTO);
		}else {
			meetingRoomDTO.setMtName(mtName);
			meetingRoomDTO.setMtAvail(mtAvail);
			meetingRoomDTO.setMtSize(mtSize);
			meetingRoomDTO.setMtPrice(mtPrice);
			meetingRoomDTO.setMtDescription(mtDescription);
			logger.info(meetingRoomDTO.toString());
			meetingRoomForMadminService.updateMtRoomNotIncludePic(meetingRoomDTO);
		}
		mv.setViewName("redirect:/meetingRoomList.do");
		return mv;
	}
	
	@RequestMapping("/deleteMtRoomForAdmin.do")
	public ModelAndView deleteMtRoomForAdmin(ModelAndView mv,@RequestParam("mtSeq") String mtSeq,
			MeetingRoomDTO meetingRoomDTO) {
		meetingRoomDTO.setMtSeq(mtSeq);
		logger.info("들어오너라~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+meetingRoomDTO.getMtSeq());
		meetingRoomForMadminService.deleteMtRoomForAdmin(meetingRoomDTO);
		mv.setViewName("redirect:meetingRoomList.do");
		return mv;
	}
	
	@RequestMapping(value = "/getByteMeetingRoomImage/{mtSeq}", method = RequestMethod.GET)
	public void getImageAsByteArrayMtRoom(HttpServletResponse response,@PathVariable String mtSeq, MeetingRoomDTO meetingRoomDTO) throws IOException {
		meetingRoomDTO.setMtSeq(mtSeq);
		logger.info(mtSeq);
		Map<String, Object> map = meetingRoomForMadminService.getByteMeetingRoomImage(meetingRoomDTO);
//		logger.info(map.get("IMG").toString());
		byte[] imageContent = (byte[]) map.get("IMG");

	    InputStream in = new ByteArrayInputStream(imageContent);
	    response.setContentType(MediaType.IMAGE_JPEG_VALUE);
	    IOUtils.copy(in, response.getOutputStream());
	}
	@RequestMapping(value = "/getByteMeetingRoomImage2/{mtSeq}", method = RequestMethod.GET)
	public void getImageAsByteArrayMtRoom2(HttpServletResponse response,@PathVariable String mtSeq, MeetingRoomDTO meetingRoomDTO) throws IOException {
		meetingRoomDTO.setMtSeq(mtSeq);
		logger.info(mtSeq);
		Map<String, Object> map = meetingRoomForMadminService.getByteMeetingRoomImage2(meetingRoomDTO);
//		logger.info(map.get("IMG").toString());
		byte[] imageContent = (byte[]) map.get("IMG");

	    InputStream in = new ByteArrayInputStream(imageContent);
	    response.setContentType(MediaType.IMAGE_JPEG_VALUE);
	    IOUtils.copy(in, response.getOutputStream());
	}
	@RequestMapping(value = "/getByteMeetingRoomImage3/{mtSeq}", method = RequestMethod.GET)
	public void getImageAsByteArrayMtRoom3(HttpServletResponse response,@PathVariable String mtSeq, MeetingRoomDTO meetingRoomDTO) throws IOException {
		meetingRoomDTO.setMtSeq(mtSeq);
		logger.info(mtSeq);
		Map<String, Object> map = meetingRoomForMadminService.getByteMeetingRoomImage3(meetingRoomDTO);
//		logger.info(map.get("IMG").toString());
		byte[] imageContent = (byte[]) map.get("IMG");

	    InputStream in = new ByteArrayInputStream(imageContent);
	    response.setContentType(MediaType.IMAGE_JPEG_VALUE);
	    IOUtils.copy(in, response.getOutputStream());
	}
	
	@ResponseBody
	@RequestMapping("/getMtRoomByWorkSeq.do")
	public List<MeetingRoomDTO> getMtRoomByWorkSeq(@RequestParam("workSeq") String workSeq,MeetingRoomDTO meetingRoomDTO){
		meetingRoomDTO.setWorkSeq(workSeq);
		List<MeetingRoomDTO> mtListByworkSeq = meetingRoomForMadminService.getMtRoomByWorkSeq(meetingRoomDTO);
		return mtListByworkSeq;
	}
	
	@RequestMapping("/showMtRoomDetailForAdmin.do")
	public ModelAndView showMtRoomDetailForAdmin(@RequestParam("mtSeq") String mtSeq, MeetingRoomDTO meetingRoomDTO,ModelAndView mv) {
		meetingRoomDTO.setMtSeq(mtSeq);
		MeetingRoomPlusWSNameDTO returnVal  = meetingRoomForMadminService.getMeetingRoomByMtSeq(meetingRoomDTO);
		mv.addObject("meetingRoom",returnVal);
		mv.setViewName("/mAdmin/meetingRoomShow");
		return mv;
	}
}
