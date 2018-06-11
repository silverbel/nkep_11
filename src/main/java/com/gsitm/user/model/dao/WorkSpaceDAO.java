package com.gsitm.user.model.dao;

import java.util.List;

import com.gsitm.common.dto.WorkSpaceDTO;


public interface WorkSpaceDAO {

	List<WorkSpaceDTO> getWorkSpaceList(WorkSpaceDTO workSpaceDTO);


}
