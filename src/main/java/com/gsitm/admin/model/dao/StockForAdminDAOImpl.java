package com.gsitm.admin.model.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.gsitm.common.dto.StockDTO;

@Repository
public class StockForAdminDAOImpl implements StockForAdminDAO {

	@Inject
	private SqlSession sqlSession;
	@Override
	public void insertStockForAdmin(StockDTO stockDTO) {
		sqlSession.insert("stock.insertStockForAdmin",stockDTO);
	}

}
