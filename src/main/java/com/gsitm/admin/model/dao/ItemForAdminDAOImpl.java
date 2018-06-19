package com.gsitm.admin.model.dao;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.gsitm.common.dto.ItemDTO;
import com.gsitm.common.dto.ItemStockByWorkSpaceDTO;
import com.gsitm.common.dto.WorkSpaceDTO;

@Repository
public class ItemForAdminDAOImpl implements ItemForAdminDAO {

	@Inject
	private SqlSession sqlSession;
	
	@Override
	public List<ItemStockByWorkSpaceDTO> getItemListForAdmin() {
		return sqlSession.selectList("item.getItemListForAdmin");
	}

	@Override
	public void insertItemForAdmin(ItemDTO itemDTO) {
		sqlSession.insert("item.insertItemForAdmin",itemDTO);
	}

	@Override
	public Map<String, Object> getByteImage(ItemDTO itemDTO) {
		return sqlSession.selectOne("item.getByteImage", itemDTO);
	}

	@Override
	public ItemStockByWorkSpaceDTO getItemByItemSeq(ItemStockByWorkSpaceDTO itemStockByWorkSpaceDTO) {
		return sqlSession.selectOne("item.getItemByItemSeq",itemStockByWorkSpaceDTO);
	}

	@Override
	public Map<String, Object> getByteImage2(ItemDTO itemDTO) {
		return sqlSession.selectOne("item.getByteImage2", itemDTO);
	}

	@Override
	public Map<String, Object> getByteImage3(ItemDTO itemDTO) {
		return sqlSession.selectOne("item.getByteImage3", itemDTO);
	}

	@Override
	public String getItemMaxPK() {
		return sqlSession.selectOne("item.getItemMaxPK");
	}


}
