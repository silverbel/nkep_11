package com.gsitm.admin.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.gsitm.admin.model.dao.ItemForAdminDAO;
import com.gsitm.common.dto.ItemDTO;
import com.gsitm.common.dto.ItemStockByWorkSpaceDTO;
import com.gsitm.common.dto.WorkSpaceDTO;

@Service
public class ItemForAdminService {

	@Inject
	private ItemForAdminDAO itemForAdminDAO;
	
	public List<ItemStockByWorkSpaceDTO> getItemListForAdmin() {
		return itemForAdminDAO.getItemListForAdmin();
	}

	public void insertItemForAdmin(ItemDTO itemDTO) {
		itemForAdminDAO.insertItemForAdmin(itemDTO);
	}

	public Map<String, Object> getByteImage(ItemDTO itemDTO) {
		return itemForAdminDAO.getByteImage(itemDTO);
	}

	public ItemStockByWorkSpaceDTO getItemByItemSeq(ItemStockByWorkSpaceDTO itemStockByWorkSpaceDTO) {
		return itemForAdminDAO.getItemByItemSeq(itemStockByWorkSpaceDTO);
	}

	public Map<String, Object> getByteImage2(ItemDTO itemDTO) {
		return itemForAdminDAO.getByteImage2(itemDTO);
	}

	public Map<String, Object> getByteImage3(ItemDTO itemDTO) {
		return itemForAdminDAO.getByteImage3(itemDTO);
	}

	public String getItemMaxPK() {
		return itemForAdminDAO.getItemMaxPK();
	}

}
