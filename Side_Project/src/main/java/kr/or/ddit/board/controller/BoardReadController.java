package kr.or.ddit.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")
@Controller
public class BoardReadController {
	
	@GetMapping
	public String BoardList() {
        return "tiles:content"; // 
	}

}
