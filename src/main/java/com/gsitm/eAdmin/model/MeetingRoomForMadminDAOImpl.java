package com.gsitm.eAdmin.model;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.gsitm.common.dto.MeetingRoomDTO;
import com.gsitm.common.dto.MeetingRoomPlusWSNameDTO;

@Repository
public class MeetingRoomForMadminDAOImpl implements MeetingRoomForMadminDAO {

	@Inject
	private SqlSession sqlSession;
	
	@Override
	public List<MeetingRoomDTO> getMtRoomList(MeetingRoomDTO meetingRoomDTO) {
		return sqlSession.selectList("mtRoom.getMtRoomList",meetingRoomDTO);
	}

	@Override
	public void insertMeetingRoomForAdmin(MeetingRoomDTO meetingRoomDTO) {
		sqlSession.insert("mtRoom.insertMeetingRoomForAdmin",meetingRoomDTO);
	}

	@Override
	public Map<String, Object> getByteMeetingRoomImage(MeetingRoomDTO meetingRoomDTO) {
		return sqlSession.selectOne("mtRoom.getByteMeetingRoomImage", meetingRoomDTO);
	}

	@Override
	public MeetingRoomPlusWSNameDTO getMeetingRoomByMtSeq(MeetingRoomDTO meetingRoomDTO) {
		return sqlSession.selectOne("mtRoom.getMeetingRoomByMtSeq",meetingRoomDTO);
	}

}
