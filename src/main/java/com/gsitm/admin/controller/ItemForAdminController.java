package com.gsitm.admin.controller;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.gsitm.admin.service.ItemForAdminService;
import com.gsitm.common.dto.ItemDTO;

@Controller
public class ItemForAdminController {

	@Inject
	private ItemForAdminService itemForAdminService;
	
	private static final Logger logger = LoggerFactory.getLogger(ItemForAdminController.class);
	
	@RequestMapping("/getItemListForAdmin.do")
	public ModelAndView getItemListForAdmin(ModelAndView mv, ItemDTO itemDTO) {
		List<ItemDTO> itemList = itemForAdminService.getItemListForAdmin(itemDTO);
		mv.setViewName("/admin/common/itemList");
		mv.addObject("itemList",itemList);
		return mv;
	}
	
	@RequestMapping("/newItemForAdminForm.do")
	public ModelAndView newItemForAdminForm(ModelAndView mv){
		mv.setViewName("/admin/common/itemWrite");
		return mv;
	}
	@RequestMapping("/newItemForAdmin.do")
	public ModelAndView newItemForAdmin(ModelAndView mv,MultipartHttpServletRequest httpServletRequest,ItemDTO itemDTO) throws IOException {
		httpServletRequest.getParameter("itemName");
		httpServletRequest.getParameter("itemType");
		httpServletRequest.getParameter("itemPrice");
		httpServletRequest.getParameter("itemUnit");
		httpServletRequest.getParameter("itemDescription");
		List<MultipartFile> multipartFiles = httpServletRequest.getFiles("files[]");
		if(multipartFiles.size() == 1) {
			itemDTO.setItemImg(multipartFiles.get(0).getBytes());
		}else if(multipartFiles.size() ==2) {
			itemDTO.setItemImg(multipartFiles.get(0).getBytes());
			itemDTO.setItemImg2(multipartFiles.get(1).getBytes());
		}else if(multipartFiles.size() == 3) {
			itemDTO.setItemImg(multipartFiles.get(0).getBytes());
			itemDTO.setItemImg2(multipartFiles.get(1).getBytes());
			itemDTO.setItemImg3(multipartFiles.get(2).getBytes());
		}
		itemForAdminService.insertItemForAdmin(itemDTO);
		mv.setViewName("redirect:/getItemListForAdmin.do");
		return mv;
	}
}
