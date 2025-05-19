package kr.or.ddit.Notice.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.Notice.vo.NoticeVO;

@Mapper
public interface NoticeMapper {

	/**
	 * 전체 게시글 조회
	 * @return
	 */
	public List<NoticeVO> noticeList();
	
	/**
	 * 게시글 상세조회
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
