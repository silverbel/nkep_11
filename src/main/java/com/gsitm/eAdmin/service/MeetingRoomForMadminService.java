package com.gsitm.eAdmin.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.gsitm.common.dto.MeetingRoomDTO;
import com.gsitm.common.dto.MeetingRoomPlusWSNameDTO;
import com.gsitm.eAdmin.model.MeetingRoomForMadminDAO;

@Service
public class MeetingRoomForMadminService {

	@Inject
	private MeetingRoomForMadminDAO meetingRoomForMadminDAO;
	public List<MeetingRoomDTO> getMtRoomList(MeetingRoomDTO meetingRoomDTO) {
		return meetingRoomForMadminDAO.getMtRoomList(meetingRoomDTO);
	}
	public void insertMeetingRoomForAdmin(MeetingRoomDTO meetingRoomDTO) {
		meetingRoomForMadminDAO.insertMeetingRoomForAdmin(meetingRoomDTO);
	}
	public Map<String, Object> getByteMeetingRoomImage(MeetingRoomDTO meetingRoomDTO) {
		return meetingRoomForMadminDAO.getByteMeetingRoomImage(meetingRoomDTO);
	}
	public MeetingRoomPlusWSNameDTO getMeetingRoomByMtSeq(MeetingRoomDTO meetingRoomDTO) {
		return meetingRoomForMadminDAO.getMeetingRoomByMtSeq(meetingRoomDTO);
	}

}
