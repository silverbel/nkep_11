package com.gsitm.admin.model.dao;

import java.util.List;

import com.gsitm.common.dto.ItemDTO;

public interface ItemForAdminDAO {

	List<ItemDTO> getItemListForAdmin(ItemDTO itemDTO);

	void insertItemForAdmin(ItemDTO itemDTO);

}
