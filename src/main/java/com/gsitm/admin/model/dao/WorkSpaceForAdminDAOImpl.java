package com.gsitm.admin.model.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.gsitm.common.dto.WorkSpaceDTO;

@Repository
public class WorkSpaceForAdminDAOImpl implements WorkSpaceForAdminDAO{

	@Inject
	private SqlSession sqlSession;

	@Override
	public List<WorkSpaceDTO> getWorkSpaceListForAdmin(WorkSpaceDTO workSpaceDTO) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("workSpace.getWorkSpaceListForAdmin");
	}

	@Override
	public WorkSpaceDTO getWorkSpaceForAdmin(WorkSpaceDTO workSpaceDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertWorkSpaceForAdmin(WorkSpaceDTO workSpaceDTO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateWorkSpaceForAdmin(WorkSpaceDTO workSpaceDTO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteWorkSpaceForAdmin(WorkSpaceDTO workSpaceDTO) {
		// TODO Auto-generated method stub
		
	}

}
