package kr.or.ddit.Notice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ddit.Notice.dao.NoticeMapper;
import kr.or.ddit.Notice.vo.NoticeVO;

public interface NoticeService {
	
	/**
	 * 전체 게시글 조회
	 * @return
	 */
	public List<NoticeVO> noticeList();
}
