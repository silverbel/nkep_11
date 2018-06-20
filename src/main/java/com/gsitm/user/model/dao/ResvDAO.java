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
import java.util.Map;

import com.gsitm.common.dto.InsertResvDTO;
import com.gsitm.common.dto.ConfirmDTO;
import com.gsitm.common.dto.ResvConfirmInfoDTO;
import com.gsitm.common.dto.ResvDTO;
import com.gsitm.common.dto.ResvDetailDTO;
import com.gsitm.common.dto.ResvItemInfoDTO;
import com.gsitm.common.dto.ResvUserInfoDTO;

public interface ResvDAO {
	
	
	public void create(ResvDTO dto);
	
	List<ResvUserInfoDTO> showResvUserList(String rsvSeq);
	List<ResvItemInfoDTO> showResvItemList(String rsvSeq);
	List<ResvConfirmInfoDTO> showResvConfirmList(String empId);
	ResvConfirmInfoDTO showResvDetail(String rsvSeq);
	List<ResvDTO> getResvShortInfoByDate(Map<?,?> check);
	List<ResvDTO> getResvLongInfoByDate(Map<?,?> check);
	
	// ajax
	List<ResvItemInfoDTO> roomItemListCheckByRoomSeqAjax(String workSeq);
	
	int resvCount(String empId);
	
	
	void deleteResv(ResvDTO resvDTO);
	
	void deleteConfirm(ConfirmDTO confirmDTO);
	
	void deleteResv(ResvDetailDTO resvDetailDTO);

	public void insertResv(InsertResvDTO insert);

	public void insertRI(InsertResvDTO insert);

	public void insertRDNotApplicant(InsertResvDTO insert);

	public void insertRDApplicant(InsertResvDTO insert);

	public void insertConfirm(InsertResvDTO insert);

}
