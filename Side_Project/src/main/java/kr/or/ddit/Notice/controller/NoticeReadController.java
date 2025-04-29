package kr.or.ddit.Notice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.Notice.service.NoticeService;

@RequestMapping("/notice")
@Controller
public class NoticeReadController {
	
	@Autowired
	private NoticeService service;
	
	@GetMapping
	public String NoticeList(Model model) {
		model.addAttribute("noticeList", service.noticeList());
        return "tiles:board/noticeList"; 
	}

}
