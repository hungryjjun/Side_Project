package kr.or.ddit.Notice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ddit.Notice.dao.NoticeMapper;
import kr.or.ddit.Notice.vo.NoticeVO;
import kr.or.ddit.paging.PagingInfo;

public interface NoticeService {
	
	public default List<NoticeVO>noticeList(){
		return noticeList(null);
	}
	
	
	/**
	 * 전체 게시글 조회 (페이징 처리)
	 * @return
	 */
	public List<NoticeVO> noticeList(PagingInfo<NoticeVO>paging);
	
	/**
	 * 게시글상세조회
	 * @param noticeId
	 * @return
	 */
	public NoticeVO selectedNotice(Long noticeId);
	
	/**
	 * 게시물 수정
	 * @return
	 */
	public int updateNotice(NoticeVO notice);
	
	/**
	 * 게시글 등록
	 * @param notice
	 * @return
	 */
	public int inertNotice(NoticeVO notice);
}
