package com.gsitm.eAdmin.model;

import java.util.List;
import java.util.Map;

import com.gsitm.common.dto.MeetingRoomDTO;
import com.gsitm.common.dto.MeetingRoomPlusWSNameDTO;


public interface MeetingRoomForMadminDAO {

	List<MeetingRoomDTO> getMtRoomList(MeetingRoomDTO meetingRoomDTO);

	void insertMeetingRoomForAdmin(MeetingRoomDTO meetingRoomDTO);

	Map<String, Object> getByteMeetingRoomImage(MeetingRoomDTO meetingRoomDTO);

	MeetingRoomPlusWSNameDTO getMeetingRoomByMtSeq(MeetingRoomDTO meetingRoomDTO);

}
