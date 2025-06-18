package kr.or.ddit.Notice.controller;

import java.io.IOException;
import java.net.URLEncoder;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;

import java.nio.charset.StandardCharsets;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.Notice.service.NoticeService;
import kr.or.ddit.Notice.vo.NoticeVO;
import kr.or.ddit.file.service.FileService;
import kr.or.ddit.file.vo.FileVO;
import kr.or.ddit.paging.DefaultPagingRender;
import kr.or.ddit.paging.PagingInfo;
import kr.or.ddit.paging.PagingRender;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/notice")
@Controller
public class NoticeReadController {
	
	@Autowired
	private NoticeService service;
	@Autowired
	private FileService fileService;
	
	@GetMapping
	public String NoticeList(
			Model model
			,@RequestParam(name="page", required = false, defaultValue = "1")int currentPage
			,@ModelAttribute("condition1") NoticeVO condition1
			){
		
		PagingInfo<NoticeVO>paging = new PagingInfo<>();
		paging.setCurrentPage(currentPage);
		paging.setDetailCondition(condition1);
		
		List<NoticeVO>noticeList = service.noticeList(paging);
		
		PagingRender render = new DefaultPagingRender();
		String pagingHTML = render.renderPaging(paging);
		
		log.info("pagingHTML++++++{}",pagingHTML);
		log.info("paging++++++{}",paging);
		
		model.addAttribute("noticeList", noticeList);
		model.addAttribute("pagingHTML", pagingHTML);
		model.addAttribute("pagingInfo", paging);
		
        return "tiles:notice/noticeList"; 
	}
	
	@GetMapping("who/{noticeId}")
	public String SelectedNotice(
			@PathVariable("noticeId")Long noticeId
			,Model model
			){
		
		NoticeVO notice =  service.selectedNotice(noticeId);
		List<FileVO>files = fileService.getFiles(noticeId);
		model.addAttribute("notice", notice);
		model.addAttribute("files", files);
		log.info("noticeId{}",notice);
		
		return "tiles:notice/detailNotice";
	}
	
	@GetMapping("/file/{fileId}")
	public ResponseEntity<Resource>download(@PathVariable("fileId") Long fileId) throws IOException{
		FileVO selectedFile = fileService.selectedFile(fileId);
		Resource res = fileService.getResource(selectedFile);
		
		String encoded = URLEncoder.encode(selectedFile.getOriginName(), StandardCharsets.UTF_8)
				.replace("+", "%20");
		
		return ResponseEntity.ok()
				.contentType(MediaType.parseMediaType(
						selectedFile.getMimeType() == null ? "application/octet-stream" : selectedFile.getMimeType()))
				.header(HttpHeaders.CONTENT_DISPOSITION,
						ContentDisposition.attachment()
						.filename(encoded, StandardCharsets.UTF_8)
						.build()
						.toString())
				.body(res);

	}
}






