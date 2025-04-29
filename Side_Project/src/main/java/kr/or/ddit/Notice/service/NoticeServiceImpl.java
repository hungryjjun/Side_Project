package kr.or.ddit.Notice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ddit.Notice.dao.NoticeMapper;
import kr.or.ddit.Notice.vo.NoticeVO;

@Service
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	private NoticeMapper mapper;
	
	@Override
	public List<NoticeVO> noticeList() {
		return mapper.noticeList();
	}

}
