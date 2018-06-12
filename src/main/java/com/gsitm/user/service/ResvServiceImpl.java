/**
 * @programName : ResvServiceImpl.java
 * @author      : 은종현
 * @date        : 2018-06-11
 * @function    : 메일링 서비스
 *
 * [이름]   [수정일]     [내용]
 * ----------------------------------------------------------
 * 은종현	   2018-06-11	초안
 */ 
package com.gsitm.user.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.gsitm.user.model.dao.ResvDAO;
import com.gsitm.common.dto.ResvDTO;

@Service
public class ResvServiceImpl implements ResvService {

	@Inject
	ResvDAO resvDao;
	
	@Override
	public void create(ResvDTO dto) {
		// TODO Auto-generated method stub
		resvDao.create(dto);
	}

}
