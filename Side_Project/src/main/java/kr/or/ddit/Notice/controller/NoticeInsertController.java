package kr.or.ddit.Notice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.Notice.service.NoticeService;
import kr.or.ddit.Notice.vo.NoticeVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("notice/insert")
public class NoticeInsertController {

	@Autowired
	private NoticeService service;
	
	@GetMapping
	public String InsertForm() {
		return "tiles:notice/noticeInsertForm";
	}
	
	@PostMapping("ok")
	public String InsertOk(
		@ModelAttribute("notice")NoticeVO notice
			){
		log.info("게시물등록 ======={}",notice);
		service.inertNotice(notice);
		return"redirect:/notice";
	}
}
