package com.gsitm.admin.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.gsitm.admin.model.dao.WorkSpaceForAdminDAO;
import com.gsitm.common.dto.EmployeeDTO;
import com.gsitm.common.dto.LogWSDeleteDTO;
import com.gsitm.common.dto.WorkSpaceDTO;

/**
 * @programName : WorkSpaceForAdminService.java
 * @author      : 남동길
 * @date        : 2018. 6. 13. 
 * @function    :  
 *
 * [이름]   [수정일]     [내용]
 * ----------------------------------------------------------
 * 
 */ 
@Service
public class WorkSpaceForAdminService {

	@Inject
	private WorkSpaceForAdminDAO workSpaceForAdminDAO;
	
	public List<WorkSpaceDTO> getWorkSpaceListForAdmin(WorkSpaceDTO workSpaceDTO){
		return workSpaceForAdminDAO.getWorkSpaceListForAdmin(workSpaceDTO);
	}
	
	public void insertWorkSpaceForAdmin(WorkSpaceDTO workSpaceDTO) {
		workSpaceForAdminDAO.insertWorkSpaceForAdmin(workSpaceDTO);
	}

	public Map<String, Object> getByteImage(WorkSpaceDTO workSpaceDTO) {
		return workSpaceForAdminDAO.getByteImage(workSpaceDTO);
	}

	public WorkSpaceDTO getWorkSpaceByWorkSeq(WorkSpaceDTO workSpaceDTO) {
		return workSpaceForAdminDAO.getWorkSpaceByWorkSeq(workSpaceDTO);
	}

	public void updateWorkSpaceNotIncludePic(WorkSpaceDTO workSpaceDTO) {
		workSpaceForAdminDAO.updateWorkSpaceNotIncludePic(workSpaceDTO);
	}

	public void updateWorkSpaceIncludePic(WorkSpaceDTO workSpaceDTO) {
		workSpaceForAdminDAO.updateWorkSpaceIncludePic(workSpaceDTO);
	}

	public void deleteWorkSpaceForAdmin(WorkSpaceDTO workSpaceDTO) {
		workSpaceForAdminDAO.deleteWorkSpaceForAdmin(workSpaceDTO);
	}

	public List<EmployeeDTO> getAuthorityForAdmin(EmployeeDTO employeeDTO) {
		return null;
	}

	public String getResvFTime(WorkSpaceDTO workSpaceDTO) {
		return workSpaceForAdminDAO.getResvFTime(workSpaceDTO);
	}

	public void deleteAfterCompleteReservation(WorkSpaceDTO workSpaceDTO) {
		workSpaceForAdminDAO.deleteAfterCompleteReservation(workSpaceDTO);
	}

	public List<LogWSDeleteDTO> getLogWorkSpaceDeleteForAdmin() {
		return workSpaceForAdminDAO.getLogWorkSpaceDeleteForAdmin();
	}

	public void insertLogDeleteWSForAdmin(WorkSpaceDTO workSpaceDTO) {
		workSpaceForAdminDAO.insertLogDeleteWSForAdmin(workSpaceDTO);
	}

	public Map<String, Object> getByteImage2(WorkSpaceDTO workSpaceDTO) {
		return workSpaceForAdminDAO.getByteImage2(workSpaceDTO);
	}

	public Map<String, Object> getByteImage3(WorkSpaceDTO workSpaceDTO) {
		return workSpaceForAdminDAO.getByteImage3(workSpaceDTO);
	}
}
