package com.gsitm.user.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gsitm.common.dto.BlackListLogDTO;

@Repository(value="blkDao")
public class BlackListDAOImpl implements BlackListDAO {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<BlackListLogDTO> forUserList(String empId) {
		return sqlSession.selectList("blackList.forUserList",empId);
	}
	
	@Override
	public int blackListCount(String empId) {
		return sqlSession.selectOne("blackList.blackListCount", empId);
	}
	
	@Override
	public void insertBlackList(BlackListLogDTO bList) {
		sqlSession.insert("blackList.insertBlackList", bList);
	}
}
