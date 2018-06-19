package com.gsitm.eAdmin.model;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.gsitm.common.dto.EducationRoomDTO;
import com.gsitm.common.dto.EducationRoomPlusWSNameDTO;
import com.gsitm.common.dto.MeetingRoomDTO;

@Repository
public class EducationRoomForEadminDAOImpl implements EducationRoomForEadminDAO {

	@Inject
	private SqlSession sqlSession;
	@Override
	public List<MeetingRoomDTO> getEduRoomList(EducationRoomDTO educationRoomDTO) {
		return sqlSession.selectList("eduRoom.getEduRoomList",educationRoomDTO);
	}
	@Override
	public void insertEducationRoomForAdmin(EducationRoomDTO educationRoomDTO) {
		sqlSession.insert("eduRoom.insertEducationRoomForAdmin",educationRoomDTO);
	}
	@Override
	public EducationRoomPlusWSNameDTO getEducationRoomByEduSeq(EducationRoomDTO educationRoomDTO) {
		return sqlSession.selectOne("eduRoom.getEducationRoomByEduSeq",educationRoomDTO);
	}
	@Override
	public void updateEduRoomIncludePic(EducationRoomDTO educationRoomDTO) {
		sqlSession.update("eduRoom.updateEduRoomIncludePic",educationRoomDTO);
	}
	@Override
	public void updateEduRoomNotIncludePic(EducationRoomDTO educationRoomDTO) {
		sqlSession.update("eduRoom.updateEduRoomNotIncludePic",educationRoomDTO);
	}
	@Override
	public void deleteEduRoomForAdmin(EducationRoomDTO educationRoomDTO) {
		sqlSession.delete("eduRoom.deleteEduRoomForAdmin",educationRoomDTO);
	}
	@Override
	public Map<String, Object> getByteEducationRoomImage(EducationRoomDTO educationRoomDTO) {
		return sqlSession.selectOne("eduRoom.getByteEducationRoomImage",educationRoomDTO);
	}
	@Override
	public List<EducationRoomDTO> getEduRoomByWorkSeq(EducationRoomDTO educationRoomDTO) {
		return sqlSession.selectList("eduRoom.getEduRoomByWorkSeq",educationRoomDTO);
	}
	@Override
	public Map<String, Object> getByteEducationRoomImage2(EducationRoomDTO educationRoomDTO) {
		return sqlSession.selectOne("eduRoom.getByteEducationRoomImage2",educationRoomDTO);
	}
	@Override
	public Map<String, Object> getByteEducationRoomImage3(EducationRoomDTO educationRoomDTO) {
		return sqlSession.selectOne("eduRoom.getByteEducationRoomImage3",educationRoomDTO);
	}

}
