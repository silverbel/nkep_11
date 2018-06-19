package com.gsitm.admin.controller;

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

import com.gsitm.admin.service.ItemForAdminService;
import com.gsitm.admin.service.StockForAdminService;
import com.gsitm.admin.service.WorkSpaceForAdminService;
import com.gsitm.common.dto.ItemDTO;
import com.gsitm.common.dto.ItemStockByWorkSpaceDTO;
import com.gsitm.common.dto.StockDTO;
import com.gsitm.common.dto.WorkSpaceDTO;

@Controller
public class ItemForAdminController {

	@Inject
	private ItemForAdminService itemForAdminService;
	
	@Inject
	private WorkSpaceForAdminService workSpaceForAdminService;
	
	@Inject
	private StockForAdminService stockForAdminService;
	
	private static final Logger logger = LoggerFactory.getLogger(ItemForAdminController.class);
	
	@RequestMapping("/getItemListForAdmin.do")
	public ModelAndView getItemListForAdmin(ModelAndView mv, ItemDTO itemDTO, WorkSpaceDTO workSpaceDTO) {
		List<ItemStockByWorkSpaceDTO> itemList = itemForAdminService.getItemListForAdmin();
		List<WorkSpaceDTO> workSpaceList = workSpaceForAdminService.getWorkSpaceListForAdmin(workSpaceDTO);
		mv.setViewName("/admin/common/itemList");
		mv.addObject("workSpaceList",workSpaceList);
		mv.addObject("itemList",itemList);
		return mv;
	}
	
	@RequestMapping("/newItemForAdminForm.do")
	public ModelAndView newItemForAdminForm(ModelAndView mv,WorkSpaceDTO workSpaceDTO){
		List<WorkSpaceDTO> workSpaceList = workSpaceForAdminService.getWorkSpaceListForAdmin(workSpaceDTO);
		mv.addObject("workSpaceList",workSpaceList);
		mv.setViewName("/admin/common/itemWrite");
		return mv;
	}
	@RequestMapping("/newItemForAdmin.do")
	public ModelAndView newItemForAdmin(ModelAndView mv,MultipartHttpServletRequest httpServletRequest,ItemDTO itemDTO,
			StockDTO stockDTO) throws IOException {
		itemDTO.setItemName(httpServletRequest.getParameter("itemName"));
		itemDTO.setItemType(httpServletRequest.getParameter("itemType"));
		itemDTO.setItemPrice(httpServletRequest.getParameter("itemPrice"));
		itemDTO.setItemUnit(httpServletRequest.getParameter("itemUnit"));
		itemDTO.setItemDescription(httpServletRequest.getParameter("itemDescription"));
		stockDTO.setWorkSeq(httpServletRequest.getParameter("workSeq"));
		stockDTO.setStCnt(httpServletRequest.getParameter("stCnt"));
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
		String curPK = itemForAdminService.getItemMaxPK();
		stockDTO.setItemSeq(curPK);
		stockForAdminService.insertStockForAdmin(stockDTO);
		mv.setViewName("redirect:/getItemListForAdmin.do");
		return mv;
	}
	
	@RequestMapping(value = "/getByteItemImage/{itemSeq}", method = RequestMethod.GET)
	public void getImageAsByteArray(HttpServletResponse response,@PathVariable String itemSeq, ItemDTO itemDTO) throws IOException {
		itemDTO.setItemSeq(itemSeq);
		Map<String, Object> map = itemForAdminService.getByteImage(itemDTO);
		byte[] imageContent = (byte[]) map.get("IMG");

	    InputStream in = new ByteArrayInputStream(imageContent);
	    response.setContentType(MediaType.IMAGE_JPEG_VALUE);
	    IOUtils.copy(in, response.getOutputStream());
	}
	
	@RequestMapping(value = "/getByteItemImage2/{itemSeq}", method = RequestMethod.GET)
	public void getImageAsByteArray2(HttpServletResponse response,@PathVariable String itemSeq, ItemDTO itemDTO) throws IOException {
		itemDTO.setItemSeq(itemSeq);
		Map<String, Object> map = itemForAdminService.getByteImage2(itemDTO);
		byte[] imageContent = (byte[]) map.get("IMG");

	    InputStream in = new ByteArrayInputStream(imageContent);
	    response.setContentType(MediaType.IMAGE_JPEG_VALUE);
	    IOUtils.copy(in, response.getOutputStream());
	}
	
	@RequestMapping(value = "/getByteItemImage3/{itemSeq}", method = RequestMethod.GET)
	public void getImageAsByteArray3(HttpServletResponse response,@PathVariable String itemSeq, ItemDTO itemDTO) throws IOException {
		itemDTO.setItemSeq(itemSeq);
		Map<String, Object> map = itemForAdminService.getByteImage3(itemDTO);
		byte[] imageContent = (byte[]) map.get("IMG");

	    InputStream in = new ByteArrayInputStream(imageContent);
	    response.setContentType(MediaType.IMAGE_JPEG_VALUE);
	    IOUtils.copy(in, response.getOutputStream());
	}
	
	@RequestMapping("/showItemDetailForAdmin.do")
	public ModelAndView showItemDetail(@RequestParam("itemSeq") String itemSeq,
			@RequestParam("workSeq") String workSeq,ModelAndView mv,ItemStockByWorkSpaceDTO itemStockByWorkSpaceDTO) {
		itemStockByWorkSpaceDTO.setItemSeq(itemSeq);
		itemStockByWorkSpaceDTO.setWorkSeq(workSeq);
		itemStockByWorkSpaceDTO = itemForAdminService.getItemByItemSeq(itemStockByWorkSpaceDTO);
		mv.addObject("itemDTO",itemStockByWorkSpaceDTO);
		mv.setViewName("/admin/common/itemShow");
		return mv;
	}
	
	@RequestMapping("/modifyItemForAdminForm.do")
	public ModelAndView modifyItemForAdminForm(ModelAndView mv,ItemStockByWorkSpaceDTO itemStockByWorkSpaceDTO,
			@RequestParam("itemSeq") String itemSeq,
			@RequestParam("workSeq") String workSeq) {
		itemStockByWorkSpaceDTO.setItemSeq(itemSeq);
		itemStockByWorkSpaceDTO.setWorkSeq(workSeq);
		itemStockByWorkSpaceDTO = itemForAdminService.getItemByItemSeq(itemStockByWorkSpaceDTO);
		mv.setViewName("/admin/common/itemModify");
		mv.addObject("itemDTO",itemStockByWorkSpaceDTO);
		return mv;
	}
	
	@RequestMapping("/modifyItemForAdmin.do")
	public ModelAndView modifyItemForAdmin(MultipartHttpServletRequest httpServletRequest,
			ModelAndView mv,ItemStockByWorkSpaceDTO itemStockByWorkSpaceDTO) throws IOException {
		itemStockByWorkSpaceDTO.setItemSeq(httpServletRequest.getParameter("itemSeq"));
		itemStockByWorkSpaceDTO.setWorkSeq(httpServletRequest.getParameter("workSeq"));
		itemStockByWorkSpaceDTO.setItemName(httpServletRequest.getParameter("itemName"));
		itemStockByWorkSpaceDTO.setStCnt(httpServletRequest.getParameter("stCnt"));
		itemStockByWorkSpaceDTO.setItemType(httpServletRequest.getParameter("itemType"));
		itemStockByWorkSpaceDTO.setItemPrice(httpServletRequest.getParameter("itemPrice"));
		itemStockByWorkSpaceDTO.setItemDescription(httpServletRequest.getParameter("itmeDescription"));
		if(httpServletRequest.getParameter("changeFlag") == null) {
			List<MultipartFile> multipartFiles = httpServletRequest.getFiles("files[]");
			if(multipartFiles.size() == 1) {
				itemStockByWorkSpaceDTO.setItemImg(multipartFiles.get(0).getBytes());
			}else if(multipartFiles.size() ==2) {
				itemStockByWorkSpaceDTO.setItemImg(multipartFiles.get(0).getBytes());
				itemStockByWorkSpaceDTO.setItemImg2(multipartFiles.get(1).getBytes());
			}else if(multipartFiles.size() == 3) {
				itemStockByWorkSpaceDTO.setItemImg(multipartFiles.get(0).getBytes());
				itemStockByWorkSpaceDTO.setItemImg2(multipartFiles.get(1).getBytes());
				itemStockByWorkSpaceDTO.setItemImg3(multipartFiles.get(2).getBytes());
			}
			itemForAdminService.updateItemIncludePic(itemStockByWorkSpaceDTO);
		}else {
			itemForAdminService.updateItemNotIncludePic(itemStockByWorkSpaceDTO);
		}
		mv.setViewName("redirect:/getItemListForAdmin.do");
		return mv;
	}
}
