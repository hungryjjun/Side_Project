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
}
