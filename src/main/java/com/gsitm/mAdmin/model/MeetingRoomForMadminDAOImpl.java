package com.gsitm.mAdmin.model;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.gsitm.common.dto.MeetingRoomDTO;
import com.gsitm.common.dto.MeetingRoomPlusWSNameDTO;
import com.gsitm.common.dto.WorkSpaceDTO;

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

	@Override
	public void updateMtRoomIncludePic(MeetingRoomDTO meetingRoomDTO) {
		sqlSession.update("mtRoom.updateMtRoomIncludePic",meetingRoomDTO);
	}

	@Override
	public void updateMtRoomNotIncludePic(MeetingRoomDTO meetingRoomDTO) {
		sqlSession.update("mtRoom.updateMtRoomNotIncludePic",meetingRoomDTO);
	}

	@Override
	public void deleteMtRoomForAdmin(MeetingRoomDTO meetingRoomDTO) {
		sqlSession.delete("mtRoom.deleteMtRoomForAdmin",meetingRoomDTO);
	}

	@Override
	public List<MeetingRoomDTO> getMtRoomByWorkSeq(MeetingRoomDTO meetingRoomDTO) {
		return sqlSession.selectList("mtRoom.getMtRoomByWorkSeq",meetingRoomDTO);
	}

	@Override
	public Map<String, Object> getByteMeetingRoomImage2(MeetingRoomDTO meetingRoomDTO) {
		return sqlSession.selectOne("mtRoom.getByteMeetingRoomImage2", meetingRoomDTO);
	}

	@Override
	public Map<String, Object> getByteMeetingRoomImage3(MeetingRoomDTO meetingRoomDTO) {
		return sqlSession.selectOne("mtRoom.getByteMeetingRoomImage3", meetingRoomDTO);
	}

}
