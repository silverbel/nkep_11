package com.gsitm.admin.model.dao;

import java.util.List;
import java.util.Map;

import com.gsitm.common.dto.LogWSDeleteDTO;
import com.gsitm.common.dto.WorkSpaceDTO;

/**
 * @programName : WorkSpaceForAdminDAO.java
 * @author      : 남동길
 * @date        : 2018. 6. 13. 
 * @function    :  
 *
 * [이름]   [수정일]     [내용]
 * ----------------------------------------------------------
 * 
 */ 
public interface WorkSpaceForAdminDAO {

	List<WorkSpaceDTO> getWorkSpaceListForAdmin(WorkSpaceDTO workSpaceDTO);
	
	WorkSpaceDTO getWorkSpaceForAdmin(WorkSpaceDTO workSpaceDTO);
	
	void insertWorkSpaceForAdmin(WorkSpaceDTO workSpaceDTO);
	
	void deleteWorkSpaceForAdmin(WorkSpaceDTO workSpaceDTO);

	Map<String, Object> getByteImage(WorkSpaceDTO workSpaceDTO);

	WorkSpaceDTO getWorkSpaceByWorkSeq(WorkSpaceDTO workSpaceDTO);

	void updateWorkSpaceNotIncludePic(WorkSpaceDTO workSpaceDTO);

	void updateWorkSpaceIncludePic(WorkSpaceDTO workSpaceDTO);

	String getResvFTime(WorkSpaceDTO workSpaceDTO);

	void deleteAfterCompleteReservation(WorkSpaceDTO workSpaceDTO);

	List<LogWSDeleteDTO> getLogWorkSpaceDeleteForAdmin();

	void insertLogDeleteWSForAdmin(WorkSpaceDTO workSpaceDTO);

	Map<String, Object> getByteImage2(WorkSpaceDTO workSpaceDTO);

	Map<String, Object> getByteImage3(WorkSpaceDTO workSpaceDTO);
}
