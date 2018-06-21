package com.gsitm.admin.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gsitm.admin.service.NoticeService;
import com.gsitm.common.dto.NoticeDTO;
import com.gsitm.common.dto.WorkSpaceDTO;
import com.gsitm.user.service.WorkSpaceService;

@Controller
public class AdminMasterController {

	@Inject
	private NoticeService noticeService;
	
	@Resource(name="wServiceForUser")
	private WorkSpaceService wService;
	
	@RequestMapping("/admin.do")
	public ModelAndView adminIndex(ModelAndView mv, NoticeDTO noticeDTO) {
		List<NoticeDTO> list = noticeService.getNoticeList(noticeDTO);
		mv.setViewName("/admin/index");
		mv.addObject("noticeList", list);
		return mv;
	}
	
	@RequestMapping("/eAdmin.do")
	public ModelAndView eAdminIndex(ModelAndView mv) {
		mv.setViewName("/eAdmin/index");
		return mv;
	}
	
	@RequestMapping("/mAdmin.do")
	public ModelAndView mAdminIndex(ModelAndView mv, NoticeDTO noticeDTO) {
		List<NoticeDTO> list = noticeService.getNoticeList(noticeDTO);
		mv.setViewName("/mAdmin/index");
		mv.addObject("noticeList", list);
		return mv;
	}
}
