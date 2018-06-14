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

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gsitm.common.dto.ResvConfirmInfoDTO;
import com.gsitm.common.dto.ResvDTO;
import com.gsitm.common.dto.ResvItemInfoDTO;
import com.gsitm.common.dto.ResvUserInfoDTO;

@Repository(value="resvDao")
public class ResvDAOImpl implements ResvDAO {
	
	@Autowired
	SqlSession sqlSession;

	@Override
	public void create(ResvDTO dto){
		sqlSession.insert("resv.insert", dto);
	}

	@Override
	public List<ResvUserInfoDTO> showResvUserList(String empId) {
		return sqlSession.selectList("resv.showResvUserList", empId);
	}

	@Override
	public List<ResvItemInfoDTO> showResvItemList(String empId) {
		return sqlSession.selectList("resv.showResvItemList", empId);
	}

	@Override
	public List<ResvConfirmInfoDTO> showResvConfirmList(String empId) {
		return sqlSession.selectList("resv.showResvConfirmList", empId);
	}

	@Override
	public int resvCount(String empId) {
		return sqlSession.selectOne("resv.resvCount", empId);
	}

}
