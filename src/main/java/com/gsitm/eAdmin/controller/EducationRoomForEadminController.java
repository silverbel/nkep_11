package com.gsitm.eAdmin.controller;

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
import com.gsitm.eAdmin.service.EducationRoomForEadminService;
import com.gsitm.mAdmin.controller.MeetingRoomForMadminController;

@Controller
public class EducationRoomForEadminController {

	private static final Logger logger = LoggerFactory.getLogger(EducationRoomForEadminController.class);
	@Inject
	private EducationRoomForEadminService educationRoomForEadminService;
	@Inject
	private WorkSpaceForAdminService workSpaceForAdminService;
	@RequestMapping("/educationRoomList.do")
	public ModelAndView educationRoomList(ModelAndView mv,EducationRoomDTO educationRoomDTO,WorkSpaceDTO workSpaceDTO) {
		List<MeetingRoomDTO> eduRoomList = educationRoomForEadminService.getEduRoomList(educationRoomDTO);
		List<WorkSpaceDTO> workSpaceList = workSpaceForAdminService.getWorkSpaceListForAdmin(workSpaceDTO);
		mv.addObject("eduRoomList", eduRoomList);
		mv.addObject("workSpaceList",workSpaceList);
		mv.setViewName("eAdmin/educationRoomList");
		return mv;
	}
	@RequestMapping("/newEducationRoomForAdminForm.do")
	public ModelAndView newEducationRoomForAdminForm(ModelAndView mv,WorkSpaceDTO workSpaceDTO) {
		List<WorkSpaceDTO> workSpaceList = workSpaceForAdminService.getWorkSpaceListForAdmin(workSpaceDTO);
		mv.addObject("workSpaceList", workSpaceList);
		mv.setViewName("eAdmin/educationRoomWrite");
		return mv;
	}
	
	@RequestMapping("/newEducationRoomForAdmin.do")
	public ModelAndView newEducationRoomForAdmin(ModelAndView mv,MultipartHttpServletRequest multipartHttpServletRequest,
			EducationRoomDTO educationRoomDTO) throws IOException {
		String workSeqPlusWorkCode = multipartHttpServletRequest.getParameter("workSeq");
		String[] workSpaces = workSeqPlusWorkCode.split("\\/");
		String workSeq = workSpaces[0];
		String workCode = workSpaces[1];
		String eduName = multipartHttpServletRequest.getParameter("eduName");
		String eduSize = multipartHttpServletRequest.getParameter("eduSize");
		String eduPrice = multipartHttpServletRequest.getParameter("eduPrice");
		String eduAvail = multipartHttpServletRequest.getParameter("eduAvail");
		String eduDescription = multipartHttpServletRequest.getParameter("eduDescription");
		List<MultipartFile> multipartFiles = multipartHttpServletRequest.getFiles("files[]");

		educationRoomDTO.setWorkSeq(workSeq);
		educationRoomDTO.setWorkCode(workCode);
		educationRoomDTO.setEduName(eduName);
		educationRoomDTO.setEduPrice(eduPrice);
		educationRoomDTO.setEduSize(eduSize);
		educationRoomDTO.setEduAvail(eduAvail);
		educationRoomDTO.setEduDescription(eduDescription);
		if(multipartFiles.size() == 1) {
			educationRoomDTO.setEduImg(multipartFiles.get(0).getBytes());
		}else if(multipartFiles.size() == 2) {
			educationRoomDTO.setEduImg(multipartFiles.get(0).getBytes());
			educationRoomDTO.setEduImg2(multipartFiles.get(1).getBytes());
		}else if(multipartFiles.size() == 3) {
			educationRoomDTO.setEduImg(multipartFiles.get(0).getBytes());
			educationRoomDTO.setEduImg2(multipartFiles.get(1).getBytes());
			educationRoomDTO.setEduImg3(multipartFiles.get(2).getBytes());
		}
		

		educationRoomForEadminService.insertEducationRoomForAdmin(educationRoomDTO);
		mv.setViewName("redirect:/educationRoomList.do");
		return mv;
	}
	
	@RequestMapping("/modifyEducationRoomForAdminForm.do")
	public ModelAndView modifyEducationRoomForAdminForm(ModelAndView mv,
			@RequestParam("eduSeq") String eduSeq,EducationRoomDTO educationRoomDTO) {
		EducationRoomPlusWSNameDTO dto = educationRoomForEadminService.getEducationRoomByEduSeq(educationRoomDTO);
		mv.addObject("educationRoomPlusWSNameDTO", dto);
		mv.setViewName("/eAdmin/educationRoomModify");
		return mv;
	}
	
	@RequestMapping("/modifyEducationRoomForAdmin.do")
	public ModelAndView modifyEducationRoomForAdmin(ModelAndView mv,
			MultipartHttpServletRequest multipartHttpServletRequest,
			@RequestParam("eduSeq") String eduSeq, EducationRoomDTO educationRoomDTO) throws IOException {
		educationRoomDTO.setEduSeq(eduSeq);
		String eduName = multipartHttpServletRequest.getParameter("eduName");
		String eduAvail = multipartHttpServletRequest.getParameter("eduAvail");
		String eduSize = multipartHttpServletRequest.getParameter("eduSize");
		String eduPrice = multipartHttpServletRequest.getParameter("eduPrice");
		String eduDescription = multipartHttpServletRequest.getParameter("eduDescription");
		if(multipartHttpServletRequest.getParameter("changeFlag") == null) {
			List<MultipartFile> multipartFiles = multipartHttpServletRequest.getFiles("files[]");
			if(multipartFiles.size() == 1) {
				educationRoomDTO.setEduImg(multipartFiles.get(0).getBytes());
			}else if(multipartFiles.size() ==2) {
				educationRoomDTO.setEduImg(multipartFiles.get(0).getBytes());
				educationRoomDTO.setEduImg2(multipartFiles.get(1).getBytes());
			}else if(multipartFiles.size() == 3) {
				educationRoomDTO.setEduImg(multipartFiles.get(0).getBytes());
				educationRoomDTO.setEduImg2(multipartFiles.get(1).getBytes());
				educationRoomDTO.setEduImg3(multipartFiles.get(2).getBytes());
			}
			educationRoomDTO.setEduName(eduName);
			educationRoomDTO.setEduAvail(eduAvail);
			educationRoomDTO.setEduSize(eduSize);
			educationRoomDTO.setEduPrice(eduPrice);
			educationRoomDTO.setEduDescription(eduDescription);
			logger.info(educationRoomDTO.toString());
			educationRoomForEadminService.updateEduRoomIncludePic(educationRoomDTO);
		}else {
			educationRoomDTO.setEduName(eduName);
			educationRoomDTO.setEduAvail(eduAvail);
			educationRoomDTO.setEduSize(eduSize);
			educationRoomDTO.setEduPrice(eduPrice);
			educationRoomDTO.setEduDescription(eduDescription);
			logger.info(educationRoomDTO.toString());
			educationRoomForEadminService.updateEduRoomNotIncludePic(educationRoomDTO);
		}
		mv.setViewName("redirect:/educationRoomList.do");
		return mv;
	}
	
	@RequestMapping("/deleteEduRoomForAdmin.do")
	public ModelAndView deleteEduRoomForAdmin(ModelAndView mv,@RequestParam("eduSeq") String eduSeq,
			EducationRoomDTO educationRoomDTO) {
		educationRoomDTO.setEduSeq(eduSeq);
		educationRoomForEadminService.deleteEduRoomForAdmin(educationRoomDTO);
		mv.setViewName("redirect:educationRoomList.do");
		return mv;
	}
	
	@RequestMapping(value = "/getByteEducationRoomImage/{eduSeq}", method = RequestMethod.GET)
	public void getImageAsByteArrayEduRoom(HttpServletResponse response,@PathVariable String eduSeq, EducationRoomDTO educationRoomDTO) throws IOException {
		educationRoomDTO.setEduSeq(eduSeq);
		logger.info(eduSeq);
		Map<String, Object> map = educationRoomForEadminService.getByteEducationRoomImage(educationRoomDTO);
		byte[] imageContent = (byte[]) map.get("IMG");

	    InputStream in = new ByteArrayInputStream(imageContent);
	    response.setContentType(MediaType.IMAGE_JPEG_VALUE);
	    IOUtils.copy(in, response.getOutputStream());
	}
	@RequestMapping(value = "/getByteEducationRoomImage2/{eduSeq}", method = RequestMethod.GET)
	public void getImageAsByteArrayEduRoom2(HttpServletResponse response,@PathVariable String eduSeq, EducationRoomDTO educationRoomDTO) throws IOException {
		educationRoomDTO.setEduSeq(eduSeq);
		logger.info(eduSeq);
		Map<String, Object> map = educationRoomForEadminService.getByteEducationRoomImage2(educationRoomDTO);
		byte[] imageContent = (byte[]) map.get("IMG");

	    InputStream in = new ByteArrayInputStream(imageContent);
	    response.setContentType(MediaType.IMAGE_JPEG_VALUE);
	    IOUtils.copy(in, response.getOutputStream());
	}
	@RequestMapping(value = "/getByteEducationRoomImage3/{eduSeq}", method = RequestMethod.GET)
	public void getImageAsByteArrayEduRoom3(HttpServletResponse response,@PathVariable String eduSeq, EducationRoomDTO educationRoomDTO) throws IOException {
		educationRoomDTO.setEduSeq(eduSeq);
		logger.info(eduSeq);
		Map<String, Object> map = educationRoomForEadminService.getByteEducationRoomImage3(educationRoomDTO);
		byte[] imageContent = (byte[]) map.get("IMG");

	    InputStream in = new ByteArrayInputStream(imageContent);
	    response.setContentType(MediaType.IMAGE_JPEG_VALUE);
	    IOUtils.copy(in, response.getOutputStream());
	}
	
	
	@ResponseBody
	@RequestMapping("/getEduRoomByWorkSeq.do")
	public List<EducationRoomDTO> getMtRoomByWorkSeq(@RequestParam("workSeq") String workSeq,EducationRoomDTO educationRoomDTO){
		educationRoomDTO.setWorkSeq(workSeq);
		List<EducationRoomDTO> eduListByworkSeq = educationRoomForEadminService.getEduRoomByWorkSeq(educationRoomDTO);
		return eduListByworkSeq;
	}
	
	
	@RequestMapping("/showEduRoomDetailForAdmin.do")
	public ModelAndView showEduRoomDetailForAdmin(@RequestParam("eduSeq") String eduSeq, EducationRoomDTO educationRoomDTO,ModelAndView mv) {
		educationRoomDTO.setEduSeq(eduSeq);
		EducationRoomPlusWSNameDTO returnVal  = educationRoomForEadminService.getEducationRoomByEduSeq(educationRoomDTO);
		mv.addObject("educationRoom",returnVal);
		mv.setViewName("/eAdmin/educationRoomShow");
		return mv;
	}
	
}
