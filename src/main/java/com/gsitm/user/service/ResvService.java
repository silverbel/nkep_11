/**
 * @programName : ResvService.java
 * @author      : 은종현
 * @date        : 2018-06-11
 * @function    : 메일링 서비스
 *
 * [이름]   [수정일]     [내용]
 * ----------------------------------------------------------
 * 은종현	   2018-06-11	초안
 */ 

package com.gsitm.user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gsitm.common.dto.ResvConfirmInfoDTO;
import com.gsitm.common.dto.ResvDTO;
import com.gsitm.common.dto.ResvItemInfoDTO;
import com.gsitm.common.dto.ResvUserInfoDTO;
import com.gsitm.user.model.dao.ResvDAOImpl;

@Service(value="resvService")
public class ResvService {
	
	@Resource(name="resvDao")
	private ResvDAOImpl rDao;
	
	
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
	
	public List<ResvDTO> getResvInfoByDate(String rsvType, String selDate, String roomSeq){
		Map<String, String> check = new HashMap<>();
		check.put("selDate", selDate);
		check.put("roomSeq", roomSeq);
		if (rsvType == "S") return rDao.getResvShortInfoByDate(check);
		else return rDao.getResvShortInfoByDate(check);
	}
	
	public List<ResvItemInfoDTO> roomItemListCheckByRoomSeqAjax(String roomSeq){
		return rDao.roomItemListCheckByRoomSeqAjax(roomSeq);
	}
	
	public void registerReservation(String[] snack, String[] expendables, String[] fixtures,
			String workSeq, String today, String roomType, String roomSeq, String rsvType,
			String startTime, String finTime) {
		
		String rsvSeq = roomType+rsvType+today;
		
		if(snack != null) {
			
		}
	}
}

