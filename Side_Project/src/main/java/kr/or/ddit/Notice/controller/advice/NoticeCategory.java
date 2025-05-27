package kr.or.ddit.Notice.controller.advice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import kr.or.ddit.Notice.dao.NoticeMapper;
import kr.or.ddit.Notice.service.NoticeService;
import kr.or.ddit.Notice.vo.NoticeVO;

@ControllerAdvice(basePackages = "kr.or.ddit.Notice.controller")
public class NoticeCategory {

//	@Autowired
//	private NoticeService service;
	@Autowired
	private NoticeMapper mapper;
	
	@ModelAttribute("categoryList")
	private List<NoticeVO> category() {
		return mapper.Noticecatagory();
	}
	
}
