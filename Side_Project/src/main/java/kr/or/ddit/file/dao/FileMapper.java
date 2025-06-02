package kr.or.ddit.file.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import kr.or.ddit.file.vo.FileVO;

@Mapper
public interface FileMapper {
	
	/**
	 * 단건 조회 다운로드
	 * @param fileId
	 * @return
	 */
	public FileVO selectById(Long fileId);
	
	/**
	 * 모든 게시글 파일
	 * @param noticeId
	 * @return
	 */
	public List<FileVO>selectByAllId(Long noticeId);

	
	/**
	 * 파일 등록
	 * @param file
	 * @return
	 */
	public int insert(FileVO file);
	
	/**
	 * 논리삭제
	 * @param fileId
	 * @return
	 */
	public int markDelete(@Param("fileId")Long fileId);
	
	/**
	 * 실제 레코드 삭제
	 * @param fileId
	 * @return
	 */
	public int deletePhysical(@Param("fileId")Long fileId);
}
