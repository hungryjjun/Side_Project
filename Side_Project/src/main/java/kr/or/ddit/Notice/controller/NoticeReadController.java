package kr.or.ddit.Notice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.Notice.service.NoticeService;
import kr.or.ddit.Notice.vo.NoticeVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/notice")
@Controller
public class NoticeReadController {
	
	@Autowired
	private NoticeService service;
	
	@GetMapping
	public String NoticeList(Model model) {
		model.addAttribute("noticeList", service.noticeList());
        return "tiles:notice/noticeList"; 
	}
	
	@GetMapping("who/{noticeId}")
	public String SelectedNotice(
			@PathVariable("noticeId")Long noticeId
			,Model model
			){
		
		NoticeVO notice =  service.selectedNotice(noticeId);
		model.addAttribute("notice", notice);
		log.info("noticeId{}",notice);
		
		return "tiles:notice/detailNotice";
	}

}
