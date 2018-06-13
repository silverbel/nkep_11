/**
 * @programName : ResvService.java
 * @author      : 은종현
 * @date        : 2018-06-11
 * @function    : 메일링 서비스
 *
 * [이름]   [수정일]     [내용]
 * ----------------------------------------------------------
 * 은종현	   2018-06-11	초안
 */ 

package com.gsitm.user.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gsitm.user.model.dao.ResvDAOImpl;

@Service(value="resvService")
public class ResvService {
	
	@Resource(name="resvDao")
	private ResvDAOImpl rDao;
	
	
}

