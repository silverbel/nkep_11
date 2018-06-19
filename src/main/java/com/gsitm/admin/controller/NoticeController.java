package com.gsitm.admin.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gsitm.admin.service.NoticeService;
import com.gsitm.common.dto.NoticeDTO;

/**
 * @programName : NoticeController.java
 * @author : 은종현
 * @date : 2018. 6. 17.
 * @function : 공지사항 controller
 *
 *           [이름] [수정일] [내용]
 *           ----------------------------------------------------------
 * 
 */
@Controller
public class NoticeController {

	@Inject
	private NoticeService noticeService;

	private static final Logger logger = LoggerFactory.getLogger(WorkSpaceForAdminController.class);

	@GetMapping("/noticeList.do")
	public ModelAndView getWorkSpaceListForAdmin(ModelAndView mv, NoticeDTO noticeDTO) {
		List<NoticeDTO> list = noticeService.getNoticeList(noticeDTO);
		mv.setViewName("/admin/noticeList");
		mv.addObject("noticeList", list);
		return mv;
	}
	
	@PostMapping("/noticeList.do")
	public void createNotice(NoticeDTO noticeDTO) {
		noticeService.insert(noticeDTO);
	}

	@RequestMapping("/deleteNotice.do")
	public ModelAndView deleteNotice(ModelAndView mv,@RequestParam("noticeNo") int noticeNo, NoticeDTO noticeDTO) {
		noticeDTO.setNoticeNo(noticeNo);
		noticeService.deleteNotice(noticeDTO);
		mv.setViewName("redirect:/noticeList.do");
		return mv;
	}

}
