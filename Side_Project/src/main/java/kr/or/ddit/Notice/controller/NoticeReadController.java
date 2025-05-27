package kr.or.ddit.Notice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.Notice.service.NoticeService;
import kr.or.ddit.Notice.vo.NoticeVO;
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
	
	@GetMapping
	public String NoticeList(
			Model model
			,@RequestParam(name="page", required = false, defaultValue = "1")int currentPage
			,@ModelAttribute("condition") NoticeVO condition
			){
		
		PagingInfo<NoticeVO>paging = new PagingInfo<>(5,3);
		paging.setCurrentPage(currentPage);
		paging.setDetailCondition(condition);
		
		List<NoticeVO>noticeList = service.noticeList(paging);
		
		PagingRender render = new DefaultPagingRender();
		String pagingHTML = render.renderPaging(paging);
		
		log.info("pagingHTML++++++{}",pagingHTML);
		log.info("paging++++++{}",paging);
		
		model.addAttribute("noticeList", noticeList);
		model.addAttribute("pagingHTML", pagingHTML);
		
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
