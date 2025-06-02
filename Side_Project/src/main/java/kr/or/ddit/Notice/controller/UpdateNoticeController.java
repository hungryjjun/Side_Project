package kr.or.ddit.Notice.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.Notice.service.NoticeService;
import kr.or.ddit.Notice.vo.NoticeVO;
import kr.or.ddit.file.service.FileService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/notice/update")
@Controller
public class UpdateNoticeController {
	
	@Autowired
	private NoticeService service;
	@Autowired
	private FileService fileservice;
	
	@GetMapping("{noticeId}")
	public String updateForm(
			@PathVariable("noticeId")Long noticeId,
			Model model
			){
		NoticeVO selected = service.selectedNotice(noticeId);
			
		model.addAttribute("selectedNotice", selected);
		model.addAttribute("files", fileservice.getFiles(noticeId));
		log.info("selected++++ : {}",selected);
		
		return "tiles:notice/updateForm";
	}

	@PostMapping("what/{noticeId}")
	public String updateNotice(
			@ModelAttribute("noticeUpdate")NoticeVO noticeUpdate,
			@PathVariable("noticeId")Long noticeId,
			@RequestParam(name="files", required = false)List<MultipartFile>newFiles,
			@RequestParam(name="deleteIds", required = false)List<Long>deleteIds
			) throws IOException{
		//파일삭제
		fileservice.deleteFiles(deleteIds);
		
		//새파일추가
		fileservice.saveFiles(noticeId, newFiles);
		
		//게시글 수정
		service.updateNotice(noticeUpdate);
		
		return "redirect:/notice/who/" + noticeId;
	}
}



