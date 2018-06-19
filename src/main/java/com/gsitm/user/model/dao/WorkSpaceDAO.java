package com.gsitm.user.model.dao;

import java.util.List;

import com.gsitm.common.dto.WorkSpaceDTO;


/**
 * @programName : WorkSpaceDAO.java
 * @author      : 남동길
 * @date        : 2018. 6. 13. 
 * @function    :  
 *
 * [이름]   [수정일]     [내용]
 * ----------------------------------------------------------
 * 
 */ 
public interface WorkSpaceDAO {

	List<WorkSpaceDTO> getWorkSpaceList(WorkSpaceDTO workSpaceDTO);
}
