/**
 * @programName : MtRoomDAO.java
 * @author      : 은종현
 * @date        : 2018-06-14
 * @function    : 회의실 DAO
 *
 * [이름]   [수정일]     [내용]
 * ----------------------------------------------------------
 * 은종현	   2018-06-11	초안
 */ 
package com.gsitm.user.model.dao;

import java.util.List;

import com.gsitm.common.dto.MeetingRoomDTO;

public interface MtRoomDAO {
	List<MeetingRoomDTO> getMtRoomList(MeetingRoomDTO meetingRoomDTO);
	List<MeetingRoomDTO> getAnyRoomInfo(String roomSeq);
}
