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
