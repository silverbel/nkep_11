package com.gsitm.admin.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.gsitm.admin.model.dao.StockForAdminDAO;
import com.gsitm.common.dto.StockDTO;

@Service
public class StockForAdminService {

	@Inject
	private StockForAdminDAO stockForAdminDAO;

	public void insertStockForAdmin(StockDTO stockDTO) {
		stockForAdminDAO.insertStockForAdmin(stockDTO);
	}
	
	
}
