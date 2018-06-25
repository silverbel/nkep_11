
package com.gsitm.user.model.dao;

import java.util.List;

import com.gsitm.common.dto.BlackListLogDTO;

/**
 * @programName : BlackListDAO.java
 * @author      : �赿��
 * @date        : 2018. 6. 12. 
 * @function    :  
 *
 * [�̸�]   [������]     [����]
 * ----------------------------------------------------------
 * 
 */ 
public interface BlackListDAO {
	
	/**
	 * @methodName : forUserList 
	 * @author     : �赿�� 
	 * @date       : 2018. 6. 12. 
	 * @function   : ����ڰ� �ڽ��� ������Ʈ ����� Ȯ���ϴ� �Լ�
	 * @param empId : ���� �����
	 * @return : ��ϵ��� ����
	 */ 
	List<BlackListLogDTO> forUserList(String empId);
	
	int blackListCount(String empId);
	
	void insertBlackList(BlackListLogDTO bList);
}
