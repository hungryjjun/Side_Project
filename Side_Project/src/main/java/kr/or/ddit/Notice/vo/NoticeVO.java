package kr.or.ddit.Notice.vo;

import java.io.Serializable;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;
import lombok.Setter;
import lombok.ToString;

@Data
@ToString
@Setter
public class NoticeVO implements Serializable {
	
	private Long noticeId; // 공지사항 고유식별자
	private Long viewCount; // No Description
	private Long categoryId; // 공지 카테고리 식별자
	private String empId; // 작성자 ID (EMPLOYEE 테이블 FK)
	private String title; // 공지사항 제목 (1~30글자 제한)
	private String content; // 공지사항 내용 (1~200자 제한)
	private String categoryName; // 공지 카테고리 (기본값: 기타)
	private String importance; // 중요 공지 여부 (Y, N)
	private String createdAt; // 생성일자
	private String updatedAt; // 수정일자
	
	//페이징
	private int rnum;
	
}


