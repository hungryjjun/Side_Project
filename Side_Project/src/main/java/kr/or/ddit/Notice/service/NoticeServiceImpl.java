package kr.or.ddit.Notice.service;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.io.IOException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.Notice.dao.NoticeMapper;
import kr.or.ddit.Notice.vo.NoticeVO;
import kr.or.ddit.paging.PagingInfo;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	private NoticeMapper mapper;
	
	@Override
	public List<NoticeVO> noticeList(PagingInfo<NoticeVO>paging) {
		
		if(paging!=null) {
			int totalRecord = mapper.selectTotalRecord(paging);
			paging.setTotalRecord(totalRecord);
		}
		return mapper.noticeList(paging);
	}

	@Override
	public NoticeVO selectedNotice(Long noticeId) {
		if(noticeId !=null) {
			mapper.noticeCountView(noticeId);
		}
		return mapper.selectedNotice(noticeId);
	}

	@Value("#{fileInfo.noticeFile}")//문자열 경로저장
	private String FileUrl;
	@Value("#{fileInfo.noticeFile}")//리소스 객체로 참조
	private Resource FileRes;
	@Value("#{fileInfo.noticeFile}")//파일이 저장될 로컬 디렉터리
	private File Filefolder;
	
	private void processFile(NoticeVO notice) {
		log.info("Filefolder111++++++:{}",Filefolder);
		try {
			//1.업로드된 파일 꺼냄
			MultipartFile noticeMultiFile = notice.getNoticeMultiFile();
			log.info("noticeMultiFile33333333++++++:{}",noticeMultiFile);
			if(noticeMultiFile==null) return;
			//2.db에 저장할 파일명
			String noticeFile = notice.getNoticeFile();
			log.info("noticeFile22222++++++:{}",noticeFile);
			//3.저장경로+파일명으로 새 파일 객체 생성 (/upload/폴더/a1234.png)
			File destFile = new File(Filefolder,noticeFile);
			//4.업로드된 파일을 해당 경로에 저장 (실제 복사)
			noticeMultiFile.transferTo(destFile);
			
			log.info("noticeMultiFile++++++:{}",noticeMultiFile);
			log.info("destFile++++++:{}",destFile);
			log.info("notice++++++:{}",notice);
			log.info("Filefolder++++++:{}",Filefolder);
			
		} catch (Exception e) {
			//실패시 예외발생 -> 트랜잭션 콜백유도
			throw new RuntimeException(e);
		}
	}
	
	@Transactional//게시글이나 파일저장 실패시 콜백
	@Override
	public void inertNotice(NoticeVO notice) {
		log.info("noticeInsert의notice++++++:{}",notice);
		int cnt = mapper.inertNotice(notice);
		if(cnt ==0) {
			throw new IllegalStateException("공지등록 실패");
		}
		
	}
	
	@Override
	public int updateNotice(NoticeVO notice) {
		return mapper.updateNotice(notice);
	}


	@Override
	public int NoticeDelete(Long noticeId) {
		return mapper.NoticeDelete(noticeId);

	}

}
