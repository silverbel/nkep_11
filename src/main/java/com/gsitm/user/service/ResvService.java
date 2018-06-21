package com.gsitm.user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsitm.common.dto.EmployeeDTO;
import com.gsitm.common.dto.InsertResvDTO;
import com.gsitm.common.dto.ConfirmDTO;
import com.gsitm.common.dto.ResvConfirmInfoDTO;
import com.gsitm.common.dto.ResvDTO;
import com.gsitm.common.dto.ResvDetailDTO;
import com.gsitm.common.dto.ResvItemInfoDTO;
import com.gsitm.common.dto.ResvUserInfoDTO;
import com.gsitm.user.model.dao.MemberDAO;
import com.gsitm.user.model.dao.ResvDAO;

/**
 * @programName : ResvService.java
 * @author      : 김동범
 * @date        : 2018. 6. 11. 
 * @function    :  
 *
 * [이름]   [수정일]     [내용]
 * ----------------------------------------------------------
 * 
 */ 
@Service(value="resvService")
public class ResvService {
	
	@Autowired
	private ResvDAO rDao;
	
	@Autowired
	private MemberDAO mDao;
	
	public List<ResvDTO> mtRoomRsvList(ResvDTO dto) {
		return rDao.mtRoomRsvList(dto);
	}
	
	public List<ResvUserInfoDTO> showResvUserList(String rsvSeq) {
		return rDao.showResvUserList(rsvSeq);
	}

	public List<ResvItemInfoDTO> showResvItemList(String rsvSeq) {
		return rDao.showResvItemList(rsvSeq);
	}

	public List<ResvConfirmInfoDTO> showResvConfirmList(String empId) {
		return rDao.showResvConfirmList(empId);
	}
	
	public int resvCount(String empId) {
		return rDao.resvCount(empId);
	}
	
	public ResvConfirmInfoDTO showResvDetail(String rsvSeq) {
		return rDao.showResvDetail(rsvSeq);
	}
	
	public List<ResvConfirmInfoDTO> getResvInfoByDate(String rsvType, String selDate, String roomSeq){
		Map<String, String> check = new HashMap<>();
		check.put("selDate", selDate);
		check.put("roomSeq", roomSeq);
		if (rsvType.equals("S")) return rDao.getResvShortInfoByDate(check);
		else return rDao.getResvLongInfoByDate(check);
	}
	
	public List<ResvItemInfoDTO> roomItemListCheckByRoomSeqAjax(String workSeq){
		return rDao.roomItemListCheckByRoomSeqAjax(workSeq);
	}
	
	public void registerReservation(String[] snack, String[] expendables, String[] fixtures,
			String workSeq, String today, String roomType, String roomSeq, String rsvType,
			String startTime, String finTime) {
		
		String rsvSeq = roomType+rsvType+today;
		
		if(snack != null) {
			
		}
	}
	
	public List<EmployeeDTO> allMemberListAjax(){
		return mDao.allMemberListAjax();
	}
	
	public void deleteResv(ResvDTO resvDTO) {
		rDao.deleteResv(resvDTO);
	}
	
	public void deleteConfirm(ConfirmDTO confirmDTO) {
		rDao.deleteConfirm(confirmDTO);
	}
	
	public void deleteResvDetail(ResvDetailDTO resvDetailDTO) {
		rDao.deleteResv(resvDetailDTO);
	}

	public void insertResv(InsertResvDTO insert) {
		rDao.insertResv(insert);
	}

	public void insertRI(InsertResvDTO insert) {
		rDao.insertRI(insert);
	}

	public void insertRDNotApplicant(InsertResvDTO insert) {
		rDao.insertRDNotApplicant(insert);
	}

	public void insertRDApplicant(InsertResvDTO insert) {
		rDao.insertRDApplicant(insert);
	}

	public void insertConfirm(InsertResvDTO insert) {
		rDao.insertConfirm(insert);
	}

}

