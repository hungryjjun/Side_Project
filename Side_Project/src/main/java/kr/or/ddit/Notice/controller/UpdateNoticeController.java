package kr.or.ddit.Notice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.Notice.service.NoticeService;
import kr.or.ddit.Notice.vo.NoticeVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/notice/update")
@Controller
public class UpdateNoticeController {
	
	@Autowired
	private NoticeService service;
	
	@GetMapping("{noticeId}")
	public String updateForm(
			@PathVariable("noticeId")Long noticeId,
			Model model
			){
		NoticeVO selected = service.selectedNotice(noticeId);
			
		model.addAttribute("selectedNotice", selected);
		
		return "tiles:notice/updateForm";
	}

	@PostMapping("what/{noticeId}")
	public String updateNotice(
			@ModelAttribute("noticeUpdate")NoticeVO noticeUpdate,
			@PathVariable("noticeId")Long noticeId
			){
		NoticeVO selected = service.selectedNotice(noticeId);
		int update = service.updateNotice(noticeUpdate);
		log.info("noticeUpdate{}",noticeUpdate);
		
		if(update >0) {
			return "redirect:/notice";
		}
		
		return "notice/update"+selected;
	}
}



