package com.gsitm.admin.controller;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.gsitm.admin.service.WorkSpaceForAdminService;
import com.gsitm.common.dto.WorkSpaceDTO;

/**
 * @programName : WorkSpaceForAdminController.java
 * @author : 남동길
 * @date : 2018. 6. 13.
 * @function :
 *
 *           [이름] [수정일] [내용]
 *           ----------------------------------------------------------
 * 
 */
@Controller
public class WorkSpaceForAdminController {

	@Inject
	private WorkSpaceForAdminService workSpaceForAdminService;

	private static final Logger logger = LoggerFactory.getLogger(WorkSpaceForAdminController.class);

	@RequestMapping("/getWorkSpaceListForAdmin.do")
	public ModelAndView getWorkSpaceListForAdmin(ModelAndView mv, WorkSpaceDTO workSpaceDTO) {
		List<WorkSpaceDTO> list = workSpaceForAdminService.getWorkSpaceListForAdmin(workSpaceDTO);
		mv.setViewName("/admin/workSpaceList");
		mv.addObject("workSpaceList", list);
		return mv;
	}

	@RequestMapping(value = "/newWorkSpaceForAdminForm.do", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView newWorkSpaceForAdminForm(HttpServletRequest request, ModelAndView mv) {
		mv.setViewName("/admin/workSpaceWrite");

		return mv;
	}

	@RequestMapping("/newWorkSpaceForAdmin.do")
	public ModelAndView newWorkSpaceForAdmin(ModelAndView mv, MultipartHttpServletRequest multipartHttpServletRequest,
			WorkSpaceDTO workSpaceDTO) throws IOException {
		String workName = multipartHttpServletRequest.getParameter("workName");
		String addrPost = multipartHttpServletRequest.getParameter("addr_postcode");
		String addrPrimary = multipartHttpServletRequest.getParameter("addr_primary");
		String addrDetail = multipartHttpServletRequest.getParameter("addr_detail");
		String tel1 = multipartHttpServletRequest.getParameter("workTel1");
		String tel2 = multipartHttpServletRequest.getParameter("workTel2");
		String tel3 = multipartHttpServletRequest.getParameter("workTel3");
		String workDescription = multipartHttpServletRequest.getParameter("workDescription");
		List<MultipartFile> multipartFiles = multipartHttpServletRequest.getFiles("files[]");

		workSpaceDTO.setWorkName(workName);
		workSpaceDTO.setWorkAddr(addrPrimary +"|"+ addrDetail +"|"+ addrPost);
		workSpaceDTO.setWorkTel(tel1 + "-" + tel2 + "-" + tel3);
		workSpaceDTO.setWorkDescription(workDescription);
		workSpaceDTO.setWorkImg(multipartFiles.get(0).getBytes());
		workSpaceDTO.setWorkImg2(multipartFiles.get(1).getBytes());
		workSpaceDTO.setWorkImg3(multipartFiles.get(2).getBytes());

		workSpaceForAdminService.insertWorkSpaceForAdmin(workSpaceDTO);
		mv.setViewName("redirect:/getWorkSpaceListForAdmin.do");
		return mv;
	}

	@RequestMapping("/modifyWorkSpaceForAdminForm.do")
	public ModelAndView modifyWorkSpaceForAdminForm(ModelAndView mv,WorkSpaceDTO workSpaceDTO,@RequestParam("workSeq") String workSeq) {
		workSpaceDTO.setWorkSeq(workSeq);
		workSpaceDTO = workSpaceForAdminService.getWorkSpaceByWorkSeq(workSpaceDTO);
		String[] addr  = workSpaceDTO.getWorkAddr().split("\\|");
		workSpaceDTO.setMainAddr(addr[0]);
		workSpaceDTO.setSubAddr(addr[1]);
		workSpaceDTO.setPostCode(addr[2]);
		String[] tel = workSpaceDTO.getWorkTel().split("\\-");
		logger.info(tel[0]+","+tel[1]+","+tel[2]);
		workSpaceDTO.setTel1(tel[0]);
		workSpaceDTO.setTel2(tel[1]);
		workSpaceDTO.setTel3(tel[2]);
		workSpaceDTO.setWorkImg((byte[]) workSpaceDTO.getWorkImg());
		mv.addObject("workSpace", workSpaceDTO);
		mv.setViewName("/admin/workSpaceModify");
		return mv;
	}
	
	@RequestMapping("modifyWorkSpaceForAdmin.do")
	public ModelAndView modifyWorkSpaceForAdmin(ModelAndView mv,MultipartHttpServletRequest multipartHttpServletRequest,
			WorkSpaceDTO workSpaceDTO,
			@RequestParam("workSeq") String workSeq) throws IOException {
		String workName = multipartHttpServletRequest.getParameter("workName");
		String addrPost = multipartHttpServletRequest.getParameter("addr_postcode");
		String addrPrimary = multipartHttpServletRequest.getParameter("addr_primary");
		String addrDetail = multipartHttpServletRequest.getParameter("addr_detail");
		String tel1 = multipartHttpServletRequest.getParameter("workTel1");
		String tel2 = multipartHttpServletRequest.getParameter("workTel2");
		String tel3 = multipartHttpServletRequest.getParameter("workTel3");
		String workDescription = multipartHttpServletRequest.getParameter("workDescription");
		if(multipartHttpServletRequest.getParameter("changeFlag") == null) {
			workSpaceDTO.setWorkSeq(workSeq);
			List<MultipartFile> multipartFiles = multipartHttpServletRequest.getFiles("files[]");
			workSpaceDTO.setWorkImg(multipartFiles.get(0).getBytes());
			workSpaceDTO.setWorkImg2(multipartFiles.get(1).getBytes());
			workSpaceDTO.setWorkImg3(multipartFiles.get(2).getBytes());
			workSpaceDTO.setWorkName(workName);
			workSpaceDTO.setWorkAddr(addrPrimary +"|"+ addrDetail +"|"+ addrPost);
			workSpaceDTO.setWorkTel(tel1 + "-" + tel2 + "-" + tel3);
			workSpaceDTO.setWorkDescription(workDescription);
			workSpaceForAdminService.updateWorkSpaceIncludePic(workSpaceDTO);
		}else {
			workSpaceDTO.setWorkSeq(workSeq);
			workSpaceDTO.setWorkName(workName);
			workSpaceDTO.setWorkAddr(addrPrimary +"|"+ addrDetail +"|"+ addrPost);
			workSpaceDTO.setWorkTel(tel1 + "-" + tel2 + "-" + tel3);
			workSpaceDTO.setWorkDescription(workDescription);
			logger.info("방금!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!@######################################");
			workSpaceForAdminService.updateWorkSpaceNotIncludePic(workSpaceDTO);
			
		}
		mv.setViewName("redirect:/getWorkSpaceListForAdmin.do");
		return mv;
	}
	
	@RequestMapping("/deleteWorkSapceForAdmin.do")
	public ModelAndView deleteWorkSpaceForAdmin(ModelAndView mv,@RequestParam("workSeq") String workSeq,WorkSpaceDTO workSpaceDTO) {
		workSpaceDTO.setWorkSeq(workSeq);
		workSpaceForAdminService.deleteWorkSpaceForAdmin(workSpaceDTO);
		mv.setViewName("redirect:/getWorkSpaceListForAdmin.do");
		return mv;
	}

	@RequestMapping(value = "/getByteImage/{workSeq}", method = RequestMethod.GET)
	public void getImageAsByteArray(HttpServletResponse response,@PathVariable String workSeq, WorkSpaceDTO workSpaceDTO) throws IOException {
		workSpaceDTO.setWorkSeq(workSeq);
		logger.info(workSeq);
		Map<String, Object> map = workSpaceForAdminService.getByteImage(workSpaceDTO);
		logger.info(map.get("IMG").toString());
		byte[] imageContent = (byte[]) map.get("IMG");

	    InputStream in = new ByteArrayInputStream(imageContent);
	    response.setContentType(MediaType.IMAGE_JPEG_VALUE);
	    IOUtils.copy(in, response.getOutputStream());
	}
}
