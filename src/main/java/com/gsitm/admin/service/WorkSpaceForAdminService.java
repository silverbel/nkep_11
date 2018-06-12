package com.gsitm.admin.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.gsitm.admin.model.dao.WorkSpaceForAdminDAO;
import com.gsitm.common.dto.WorkSpaceDTO;

@Service
public class WorkSpaceForAdminService {

	@Inject
	private WorkSpaceForAdminDAO workSpaceForAdminDAO;
	
	public List<WorkSpaceDTO> getWorkSpaceListForAdmin(WorkSpaceDTO workSpaceDTO){
		return workSpaceForAdminDAO.getWorkSpaceListForAdmin(workSpaceDTO);
	}
}
