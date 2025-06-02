package kr.or.ddit.Notice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.Notice.service.NoticeService;
import kr.or.ddit.file.service.FileService;

@Controller
@RequestMapping("noticeDelete")
public class NoticeDeleteController {

	@Autowired
	private NoticeService service;
	@Autowired
	private FileService fileService;
	
	@PostMapping("{noticeId}")
	public String deleteNotice(@PathVariable("noticeId")Long noticeId) {
		
		
		service.NoticeDelete(noticeId);
		return "redirect:/notice";
	}
}
