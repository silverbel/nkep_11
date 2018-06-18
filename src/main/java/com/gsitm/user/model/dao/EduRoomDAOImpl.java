/**
 * @programName : EduRoomDAO.java
 * @author      : 은종현
 * @date        : 2018. 6. 14. 
 * @function    : 교육실 DAO
 *
 * [이름]   [수정일]     [내용]
 * ----------------------------------------------------------
 * 은종현 	  2018-06-14    초안 	
 */ 
package com.gsitm.user.model.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.gsitm.common.dto.EducationRoomDTO;

@Repository
public class EduRoomDAOImpl implements EduRoomDAO {

	@Inject
	private SqlSession sqlSession;
	
	@Override
	public List<EducationRoomDTO> getEduRoomList(EducationRoomDTO educationRoomDTO) {
		return sqlSession.selectList("eduRoom.getEduRoomList", educationRoomDTO);
	}

}
