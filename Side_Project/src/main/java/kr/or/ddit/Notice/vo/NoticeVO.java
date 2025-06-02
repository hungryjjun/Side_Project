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
	
	/*파일업로드
	1.사용자 파일 업로드
	2.MultipartFile noticeMultiFile가 파일을 받음
	3.서버에서 파일을 저장
	4.noticeFile가 db컬럼에 저장 */
	
	//파일명, 경로db로 저장 UUID기반 
	private String noticeFile; 
	//업로드 파일데이터를 받는 필드, 일시적으로 파일자체 받음, 파일명만 noticeFile에 저장
	private MultipartFile noticeMultiFile;
	
//	public void setNoticeFile(MultipartFile noticeMultiFile ) {
//		if(noticeMultiFile==null || noticeMultiFile.isEmpty()) return;
//		else {
//			this.noticeMultiFile = noticeMultiFile;
//			this.noticeFile = UUID.randomUUID().toString();
//		}
//	}
	public void setNoticeMultiFile(MultipartFile noticeMultiFile) {
	    this.noticeMultiFile = noticeMultiFile;

	    if (noticeMultiFile != null && !noticeMultiFile.isEmpty()) {
	        String originalName = noticeMultiFile.getOriginalFilename();
	        String ext = "";
	        if (originalName != null && originalName.contains(".")) {
	            ext = originalName.substring(originalName.lastIndexOf("."));
	        }
	        this.noticeFile = UUID.randomUUID().toString() + ext;
	    }
	}
	//페이징
	private int rnum;
	
}


