package com.gsitm.admin.model.dao;

import java.util.List;
import java.util.Map;

import com.gsitm.common.dto.ItemDTO;
import com.gsitm.common.dto.ItemStockByWorkSpaceDTO;
import com.gsitm.common.dto.WorkSpaceDTO;

public interface ItemForAdminDAO {

	List<ItemStockByWorkSpaceDTO> getItemListForAdmin();

	void insertItemForAdmin(ItemDTO itemDTO);

	Map<String, Object> getByteImage(ItemDTO itemDTO);

	ItemStockByWorkSpaceDTO getItemByItemSeq(ItemStockByWorkSpaceDTO itemStockByWorkSpaceDTO);

	Map<String, Object> getByteImage2(ItemDTO itemDTO);

	Map<String, Object> getByteImage3(ItemDTO itemDTO);

	String getItemMaxPK();

	void updateItemIncludePic(ItemStockByWorkSpaceDTO itemStockByWorkSpaceDTO);
	
	void updateItemNotIncludePic(ItemStockByWorkSpaceDTO itemStockByWorkSpaceDTO);
}
