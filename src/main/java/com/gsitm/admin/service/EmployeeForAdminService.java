package com.gsitm.admin.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.gsitm.admin.model.dao.EmployeeForAdminDAO;
import com.gsitm.common.dto.EmployeeDTO;

/**
 * @programName : EmployeeForAdminService.java
 * @author      : 남동길
 * @date        : 2018. 6. 14. 
 * @function    :  
 *
 * [이름]   [수정일]     [내용]
 * ----------------------------------------------------------
 * 
 */ 
@Service
public class EmployeeForAdminService {
	
	@Inject
	private EmployeeForAdminDAO employeeForAdminDAO;

	public List<EmployeeDTO> getAuthorityForAdmin(EmployeeDTO employeeDTO) {
		return employeeForAdminDAO.getWorkSpaceListForAdmin(employeeDTO);
	}

	public List<EmployeeDTO> getNormalForAdmin(EmployeeDTO employeeDTO) {
		return employeeForAdminDAO.getNormalForAdmin(employeeDTO);
	}

	public void changeEmpMgrToNormal(EmployeeDTO employeeDTO) {
		employeeForAdminDAO.changeEmpMgrToNormal(employeeDTO);
	}

	public void changeEmpNormalToMgr(EmployeeDTO employeeDTO) {
		employeeForAdminDAO.changeEmpNormalToMgr(employeeDTO);
	}
}
