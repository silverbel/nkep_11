/**
 * @programName : ResvDAO.java
 * @author      : 은종현
 * @date        : 2018-06-11
 * @function    : 예약 서비스
 *
 * [이름]   [수정일]     [내용]
 * ----------------------------------------------------------
 * 은종현	   2018-06-11	초안
 */ 
package com.gsitm.user.model.dao;

import java.util.List;

import com.gsitm.common.dto.ResvConfirmInfoDTO;
import com.gsitm.common.dto.ResvDTO;
import com.gsitm.common.dto.ResvItemInfoDTO;
import com.gsitm.common.dto.ResvUserInfoDTO;

public interface ResvDAO {
	
	
	public void create(ResvDTO dto);
	
	List<ResvUserInfoDTO> showResvUserList(String rsvSeq);
	List<ResvItemInfoDTO> showResvItemList(String rsvSeq);
	List<ResvConfirmInfoDTO> showResvConfirmList(String empId);
	ResvConfirmInfoDTO showResvDetail(String rsvSeq);
	
	
	int resvCount(String empId);
}
