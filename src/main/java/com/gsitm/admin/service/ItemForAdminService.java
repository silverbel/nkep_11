package com.gsitm.admin.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.gsitm.admin.model.dao.ItemForAdminDAO;
import com.gsitm.common.dto.ItemDTO;

@Service
public class ItemForAdminService {

	@Inject
	private ItemForAdminDAO itemForAdminDAO;
	
	public List<ItemDTO> getItemListForAdmin(ItemDTO itemDTO) {
		return itemForAdminDAO.getItemListForAdmin(itemDTO);
	}

	public void insertItemForAdmin(ItemDTO itemDTO) {
		itemForAdminDAO.insertItemForAdmin(itemDTO);
	}

}
