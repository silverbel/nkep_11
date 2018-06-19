package com.gsitm.admin.model.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.gsitm.common.dto.ItemDTO;

@Repository
public class ItemForAdminDAOImpl implements ItemForAdminDAO {

	@Inject
	private SqlSession sqlSession;
	
	@Override
	public List<ItemDTO> getItemListForAdmin(ItemDTO itemDTO) {
		return sqlSession.selectList("item.getItemListForAdmin",itemDTO);
	}

	@Override
	public void insertItemForAdmin(ItemDTO itemDTO) {
		sqlSession.insert("item.insertItemForAdmin",itemDTO);
	}

}
