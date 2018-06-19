package com.gsitm.mAdmin.model;

import java.util.List;
import java.util.Map;

import com.gsitm.common.dto.MeetingRoomDTO;
import com.gsitm.common.dto.MeetingRoomPlusWSNameDTO;
import com.gsitm.common.dto.WorkSpaceDTO;


public interface MeetingRoomForMadminDAO {

	List<MeetingRoomDTO> getMtRoomList(MeetingRoomDTO meetingRoomDTO);

	void insertMeetingRoomForAdmin(MeetingRoomDTO meetingRoomDTO);

	Map<String, Object> getByteMeetingRoomImage(MeetingRoomDTO meetingRoomDTO);

	MeetingRoomPlusWSNameDTO getMeetingRoomByMtSeq(MeetingRoomDTO meetingRoomDTO);

	void updateMtRoomIncludePic(MeetingRoomDTO meetingRoomDTO);

	void updateMtRoomNotIncludePic(MeetingRoomDTO meetingRoomDTO);

	void deleteMtRoomForAdmin(MeetingRoomDTO meetingRoomDTO);

	List<MeetingRoomDTO> getMtRoomByWorkSeq(MeetingRoomDTO meetingRoomDTO);

	Map<String, Object> getByteMeetingRoomImage2(MeetingRoomDTO meetingRoomDTO);

	Map<String, Object> getByteMeetingRoomImage3(MeetingRoomDTO meetingRoomDTO);

}
