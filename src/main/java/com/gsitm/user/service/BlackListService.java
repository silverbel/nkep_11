package com.gsitm.user.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gsitm.common.dto.BlackListLogDTO;
import com.gsitm.user.model.dao.BlackListDAOImpl;

/**
 * @programName : BlackListService.java
 * @author      : �赿��
 * @date        : 2018. 6. 21. 
 * @function    : ������Ʈ
 *
 * [�̸�]   [������]     [����]
 * ----------------------------------------------------------
 * 
 */ 
@Service(value="blkService")
public class BlackListService {

	@Resource(name="blkDao")
	private BlackListDAOImpl bDao;
	
	public List<BlackListLogDTO> forUserList(String empId){
		return bDao.forUserList(empId);
	}
	
	public int blackListCount(String empId) {
		return bDao.blackListCount(empId);
	}
	
	public void insertBlackList(BlackListLogDTO bList) {
		bDao.insertBlackList(bList);
	};
}
