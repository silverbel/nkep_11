package com.gsitm.admin.model.dao;

import java.util.List;

import com.gsitm.common.dto.WorkSpaceDTO;

public interface WorkSpaceForAdminDAO {

	List<WorkSpaceDTO> getWorkSpaceListForAdmin(WorkSpaceDTO workSpaceDTO);
	
	WorkSpaceDTO getWorkSpaceForAdmin(WorkSpaceDTO workSpaceDTO);
	
	void insertWorkSpaceForAdmin(WorkSpaceDTO workSpaceDTO);
	
	void updateWorkSpaceForAdmin(WorkSpaceDTO workSpaceDTO);
	
	void deleteWorkSpaceForAdmin(WorkSpaceDTO workSpaceDTO);
}
