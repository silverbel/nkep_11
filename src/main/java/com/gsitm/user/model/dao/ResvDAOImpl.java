/**
 * @programName : ResvDAOImpl.java
 * @author      : 은종현
 * @date        : 2018-06-11
 * @function    : 메일링 서비스
 *
 * [이름]   [수정일]     [내용]
 * ----------------------------------------------------------
 * 은종현	   2018-06-11	초안
 */ 
package com.gsitm.user.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gsitm.common.dto.InsertResvDTO;
import com.gsitm.common.dto.ConfirmDTO;
import com.gsitm.common.dto.ResvConfirmInfoDTO;
import com.gsitm.common.dto.ResvDTO;
import com.gsitm.common.dto.ResvDetailDTO;
import com.gsitm.common.dto.ResvItemDTO;
import com.gsitm.common.dto.ResvItemInfoDTO;
import com.gsitm.common.dto.ResvUserInfoDTO;

@Repository(value="resvDao")
public class ResvDAOImpl implements ResvDAO {
	
	@Autowired
	SqlSession sqlSession;

	@Override
	public void create(ResvDTO dto){
		sqlSession.insert("resv.insert", dto);
	}
	/* 승인 페이지 */
	@Override
	public List<ResvConfirmInfoDTO> mtRoomRsvList() {
		return sqlSession.selectList("resv.mtRoomRsvList");
	}
	
	@Override
	public List<ResvConfirmInfoDTO> mtRoomRsvRejectList() {
		return sqlSession.selectList("resv.mtRoomRsvRejectList");
	}

	@Override
	public List<ResvUserInfoDTO> showResvUserList(String rsvSeq) {
		return sqlSession.selectList("resv.showResvUserList", rsvSeq);
	}

	@Override
	public List<ResvItemInfoDTO> showResvItemList(String rsvSeq) {
		return sqlSession.selectList("resv.showResvItemList", rsvSeq);
	}

	@Override
	public List<ResvConfirmInfoDTO> showResvConfirmList(String empId) {
		return sqlSession.selectList("resv.showResvConfirmList", empId);
	}

	@Override
	public int resvCount(String empId) {
		return sqlSession.selectOne("resv.resvCount", empId);
	}

	@Override
	public ResvConfirmInfoDTO showResvDetail(String rsvSeq) {
		return sqlSession.selectOne("resv.showResvDetail", rsvSeq);
	}

	@Override
	public List<ResvConfirmInfoDTO> getResvShortInfoByDate(Map<?, ?> check) {
		return sqlSession.selectList("resv.getResvShortInfoByDate", check);
	}

	@Override
	public List<ResvConfirmInfoDTO> getResvLongInfoByDate(Map<?, ?> check) {
		return sqlSession.selectList("resv.getResvLongInfoByDate", check);
	}

	@Override
	public List<ResvItemInfoDTO> roomItemListCheckByRoomSeqAjax(String workSeq) {
		return sqlSession.selectList("resv.roomItemListCheckByRoomSeqAjax", workSeq);
	}
	
	@Override
	public void deleteResv(ResvDTO resvDTO) {
		sqlSession.delete("resv.deleteResv", resvDTO);
	}
	
	@Override
	public void deleteConfirm(ConfirmDTO confirmDTO) {
		sqlSession.delete("resv.deleteConfirm", confirmDTO);
	}
	
	@Override
	public void deleteResv(ResvDetailDTO resvDetailDTO) {
		sqlSession.delete("resv.deleteResvDetail", resvDetailDTO);
	}


	@Override
	public void insertResv(InsertResvDTO insert) {
		sqlSession.insert("resv.insertResv",insert);
	}

	@Override
	public void insertRI(InsertResvDTO insert) {
		for(int i = 0; i<insert.getItems().size();i++) {
			ResvItemDTO dt = new ResvItemDTO(insert.getRsvSeq(),insert.getItems().get(i));
			sqlSession.insert("resv.insertRI",dt);
		}
	}

	@Override
	public void insertRDNotApplicant(InsertResvDTO insert) {
		for(int i = 0; i<insert.getEmpIds().size(); i++) {
			ResvDetailDTO dt = new ResvDetailDTO();
			dt.setRsvSeq(insert.getRsvSeq());
			dt.setTeamSeq(insert.getTeamSeq());
			dt.setUseId(insert.getEmpIds().get(i));
			sqlSession.insert("resv.insertRDNotApplicant",dt);
		}
	}

	@Override
	public void insertRDApplicant(InsertResvDTO insert) {
		ResvDetailDTO dt = new ResvDetailDTO();
		dt.setApplYn("Y");
		dt.setRsvSeq(insert.getRsvSeq());
		dt.setUseId(insert.getApplicant());
		dt.setTeamSeq(insert.getTeamSeq());
		sqlSession.insert("resv.insertRDApplicant",dt);
	}

	@Override
	public void insertConfirm(InsertResvDTO insert) {
		ConfirmDTO dt = new ConfirmDTO();
		dt.setRsvSeq(insert.getRsvSeq());
		sqlSession.insert("resv.insertConfirm",dt);
	}
	@Override
	public void mtConfirm(String rsvSeq) {
		sqlSession.update("resv.mtConfirm", rsvSeq);
	}
	@Override
	public void mtReject(String rsvSeq) {
		sqlSession.update("resv.mtReject", rsvSeq);
	}


}
