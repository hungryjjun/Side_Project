package kr.or.ddit.Notice.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ddit.Notice.dao.NoticeMapper;
import kr.or.ddit.Notice.vo.NoticeVO;
import kr.or.ddit.paging.PagingInfo;

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
		return mapper.selectedNotice(noticeId);
	}

	@Override
	public int updateNotice(NoticeVO notice) {
		return mapper.updateNotice(notice);
	}

	@Override
	public int inertNotice(NoticeVO notice) {
		return mapper.inertNotice(notice);
	}

}
