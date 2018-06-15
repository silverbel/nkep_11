package com.gsitm.admin.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gsitm.admin.service.EmployeeForAdminService;
import com.gsitm.common.dto.EmployeeDTO;

/**
 * @programName : EmployeeForAdminController.java
 * @author      : 남동길
 * @date        : 2018. 6. 14. 
 * @function    :  
 *
 * [이름]   [수정일]     [내용]
 * ----------------------------------------------------------
 * 
 */ 
@Controller
public class EmployeeForAdminController {

	@Inject
	private EmployeeForAdminService employeeForAdminService;
	
	@RequestMapping("/getAuthorityForAdmin.do")
	public ModelAndView getAuthorityForAdmin(ModelAndView mv,EmployeeDTO employeeDTO) {
		List<EmployeeDTO> mgrList = employeeForAdminService.getAuthorityForAdmin(employeeDTO);
		List<EmployeeDTO> normalList = employeeForAdminService.getNormalForAdmin(employeeDTO);
		mv.addObject("employeeMgrList", mgrList);
		mv.addObject("employeeNormalList",normalList);
		mv.setViewName("/admin/authorityList");
		return mv;
	}
	
	@RequestMapping(value = "/changeEmpMgrToNormal.do",method=RequestMethod.POST)
	public ModelAndView changeEmpMgrToNormal(ModelAndView mv, @RequestParam("empId") String empId,
			@RequestParam("teamSeq") String teamSeq, EmployeeDTO employeeDTO) {
		employeeDTO.setEmpId(empId);
		employeeDTO.setTeamSeq(teamSeq);
		employeeForAdminService.changeEmpMgrToNormal(employeeDTO);
		mv.setViewName("redirect:/getAuthorityForAdmin.do");
		return mv;
	}
	
	@RequestMapping("/changeEmpNormalToMgr.do")
	public ModelAndView changeEmpNormalToMgr(ModelAndView mv, @RequestParam("empId") String empId,
			@RequestParam("role") String role,EmployeeDTO employeeDTO) {
		employeeDTO.setEmpId(empId);
		employeeDTO.setRole(role);
		employeeForAdminService.changeEmpNormalToMgr(employeeDTO);
		mv.setViewName("redirect:/getAuthorityForAdmin.do");
		return mv;
	}
}
