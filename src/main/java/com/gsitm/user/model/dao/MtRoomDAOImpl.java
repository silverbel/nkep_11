/**
 * @programName : MtRoomDAOImpl.java
 * @author      : 은종현
 * @date        : 2018-06-14
 * @function    : 회의실 DAOImpl
 *
 * [이름]   [수정일]     [내용]
 * ----------------------------------------------------------
 * 은종현	   2018-06-14	초안
 */ 
package com.gsitm.user.model.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.gsitm.common.dto.MeetingRoomDTO;

@Repository
public class MtRoomDAOImpl implements MtRoomDAO {
	
	@Inject
	private SqlSession sqlSession;

	@Override
	public List<MeetingRoomDTO> getMtRoomList(MeetingRoomDTO meetingRoomDTO) {
		return sqlSession.selectList("mtRoom.getMtRoomList", meetingRoomDTO);
	}

	@Override
	public List<MeetingRoomDTO> getAnyRoomInfo(String roomSeq) {
		return sqlSession.selectList("mtRoom.getAnyRoomInfo", roomSeq);
	}

}
