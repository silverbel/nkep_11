package com.gsitm.user.model.dao;

import java.util.List;

import com.gsitm.user.model.dto.WorkSpaceDTO;


public interface WorkSpaceDAO {

	List<WorkSpaceDTO> getWorkSpaceList(WorkSpaceDTO workSpaceDTO);


}
