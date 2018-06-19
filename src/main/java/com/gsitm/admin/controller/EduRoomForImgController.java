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

import com.gsitm.admin.service.EduRoomForImgService;
import com.gsitm.common.dto.EducationRoomDTO;


/**
 * @programName : EduRoomForImgController.java
 * @author : 은종현
 * @date : 2018. 6. 14.
 * @function : 교육실 소개하기에서 이미지 뿌려주기
 *
 *           [이름] [수정일] [내용]
 *           ----------------------------------------------------------
 * 
 */
@Controller
public class EduRoomForImgController {

	@Inject
	private EduRoomForImgService eduRoomForImgService;

	private static final Logger logger = LoggerFactory.getLogger(EduRoomForImgController.class);

	@RequestMapping(value = "/getByteEduImage/{eduSeq}", method = RequestMethod.GET)
	public void getEduImageAsByteArray(HttpServletResponse response,@PathVariable String eduSeq, EducationRoomDTO educationRoomDTO) throws IOException {
		educationRoomDTO.setEduSeq(eduSeq);
		logger.info(eduSeq);
		Map<String, Object> map = eduRoomForImgService.getByteEduImage(educationRoomDTO);
		logger.info(map.get("IMG").toString());
		byte[] imageContent = (byte[]) map.get("IMG");

	    InputStream in = new ByteArrayInputStream(imageContent);
	    response.setContentType(MediaType.IMAGE_JPEG_VALUE);
	    IOUtils.copy(in, response.getOutputStream());
	}
}
