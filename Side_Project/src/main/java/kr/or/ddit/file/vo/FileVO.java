package kr.or.ddit.file.vo;

import lombok.Data;

@Data
public class FileVO {

	private Long fileId; 
	private Long noticeId; 
	private String originName; // 원본파일명
	private String saveName; // DB저장명UUID
	private String path; // 저장경로
	private Long fileSize; 
	private String mimeType; 
	private String status; // 삭제여부
	private String uploadDt;
}
