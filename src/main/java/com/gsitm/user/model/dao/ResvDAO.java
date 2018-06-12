/**
 * @programName : ResvDAO.java
 * @author      : 은종현
 * @date        : 2018-06-11
 * @function    : 예약 서비스
 *
 * [이름]   [수정일]     [내용]
 * ----------------------------------------------------------
 * 은종현	   2018-06-11	초안
 */ 
package com.gsitm.user.model.dao;

import com.gsitm.common.dto.ResvDTO;

public interface ResvDAO {
	public void create(ResvDTO dto);
}
