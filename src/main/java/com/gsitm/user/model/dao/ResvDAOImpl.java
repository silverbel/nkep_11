/**
 * @programName : ResvDAOImpl.java
 * @author      : 은종현
 * @date        : 2018-06-11
 * @function    : 메일링 서비스
 *
 * [이름]   [수정일]     [내용]
 * ----------------------------------------------------------
 * 은종현	   2018-06-11	초안
 */ 
package com.gsitm.user.model.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.gsitm.common.dto.ResvDTO;

@Repository
public class ResvDAOImpl implements ResvDAO {
	
	@Inject
	SqlSession sqlSession;

	@Override
	public void create(ResvDTO dto){
		// TODO Auto-generated method stub
		sqlSession.insert("resv.insert", dto);
	}

}
