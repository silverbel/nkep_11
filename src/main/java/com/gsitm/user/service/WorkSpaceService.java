package com.gsitm.user.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.gsitm.common.dto.WorkSpaceDTO;
import com.gsitm.user.model.dao.WorkSpaceDAO;

@Service
public class WorkSpaceService {

	@Inject
	private WorkSpaceDAO workSpaceDAO;
	
	public List<WorkSpaceDTO> getWorkSpaceList(WorkSpaceDTO workSpaceDTO){
		return workSpaceDAO.getWorkSpaceList(workSpaceDTO);
	}
}
