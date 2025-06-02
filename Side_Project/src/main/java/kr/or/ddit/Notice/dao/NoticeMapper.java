package kr.or.ddit.Notice.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import kr.or.ddit.Notice.vo.NoticeVO;
import kr.or.ddit.paging.PagingInfo;

@Mapper
public interface NoticeMapper {
	
	/**
	 * 페이징 전체 레코드수 조회
	 * @return
	 */
	public int selectTotalRecord(@Param("paging") PagingInfo<NoticeVO>paging);

	/**
	 * 전체 게시글 조회 (페이징 처리)
	 * @return
	 */
	public List<NoticeVO> noticeList(@Param("paging")PagingInfo<NoticeVO>paging);
	
	/**
	 * 게시글 상세조회
	 * @param noticeId
	 * @return
	 */
	public NoticeVO selectedNotice(Long noticeId);
	
	
	/**
	 * 게시글 조회수 
	 * @param noticeId
	 * @return
	 */
	public int noticeCountView(Long noticeId);
	
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
	
	/**
	 * 게시글 유형조회
	 * @return
	 */
	public List<NoticeVO>Noticecatagory();
	
	/**
	 * 게시글 삭제
	 * @param noticeId
	 * @return
	 */
	public int NoticeDelete(Long noticeId);
}
