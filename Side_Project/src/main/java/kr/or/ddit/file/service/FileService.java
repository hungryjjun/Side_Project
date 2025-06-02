package kr.or.ddit.file.service;

import java.io.IOException;
import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.file.vo.FileVO;

public interface FileService {

	/**
	 * 업로드 / 새 파일 저장후 DB인서트
	 * @param noticeId
	 * @param files
	 * @return
	 * @throws IOException
	 */
	public List<FileVO>saveFiles(Long noticeId, List<MultipartFile>files)throws IOException;
	
	
	/**
	 * @param noticeId
	 * @return
	 */
	public  List<FileVO> getFiles(Long noticeId);
	
	
	/**
	 * 파일선택삭제
	 * @param fileIds
	 */
	public void deleteFiles(List<Long>fileIds);
	
	//다운로드용 메타 + 리소스
	public FileVO getMeta(Long fileId);
	public Resource getResource(FileVO meta) throws IOException;
}
