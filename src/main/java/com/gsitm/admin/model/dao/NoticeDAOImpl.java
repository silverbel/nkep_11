package com.gsitm.admin.model.dao;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.gsitm.common.dto.NoticeDTO;


/**
 * @programName : NoticeDAOImpl.java
 * @author      : 은종현
 * @date        : 2018. 6. 17. 
 * @function    :  
 *
 * [이름]   [수정일]     [내용]
 * ----------------------------------------------------------
 * 
 */ 
@Repository
public class NoticeDAOImpl implements NoticeDAO{

	@Inject
	private SqlSession sqlSession;

	@Override
	public List<NoticeDTO> getNoticeList(NoticeDTO noticeDTO) {
		return sqlSession.selectList("notice.noticeList");
	}
	
	@Override
	public void deleteNotice(NoticeDTO noticeDTO) {
		sqlSession.delete("notice.deleteNotice", noticeDTO);
	}


	@Override
	public void insertNotice(NoticeDTO noticeDTO) {
		sqlSession.insert("notice.insertNotice", noticeDTO);
	}
}
