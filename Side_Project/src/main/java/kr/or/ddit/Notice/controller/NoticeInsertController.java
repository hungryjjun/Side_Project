package kr.or.ddit.Notice.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.Notice.service.NoticeService;
import kr.or.ddit.Notice.vo.NoticeVO;
import kr.or.ddit.file.service.FileService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("notice/insert")
public class NoticeInsertController {

	@Autowired
	private NoticeService service;
	@Autowired
	private FileService fileService; //파일첨부
	
	@GetMapping
	public String InsertForm() {
		return "tiles:notice/noticeInsertForm";
	}
	
	@PostMapping("ok")
    public String process(
            @ModelAttribute NoticeVO notice,                 
            @RequestParam(name = "files", required = false) 
            List<MultipartFile> files) throws IOException {
			
		//게시글 먼저등록
		service.inertNotice(notice);
		//파일존재시 부모키 noticeId 참조하여 등록
		if(files !=null && !files.isEmpty()) {
			fileService.saveFiles(notice.getNoticeId(), files);
			log.info("등록 완료 → noticeId={}, files={}", notice.getNoticeId(), files.size());
		}
		 
		return"redirect:/notice";
	}
}
