package kr.or.ddit.Account.controller;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.Account.service.AccountService;
import kr.or.ddit.Account.vo.AccountVO;
import kr.or.ddit.Authentication.AuthenticationService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private AccountService service;
	@Autowired
	private AuthenticationService authService;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@GetMapping
	public String loginForm() {
		return "login/loginForm";
	}
	
	@PostMapping("sucess")
	public String home(
			@ModelAttribute("account") AccountVO account,
			HttpServletRequest req
			){
		//1.db계정 조회
		AccountVO dbUser = service.selectedAccount(account, account.getAccountId());
		log.info("loginController+++++account:{}",account);
		log.info("loginController+++++dbuser:{}",dbUser);
		
		//2.존재 여부확인
		if(dbUser ==null) {
			return "redirect:/login";
		}
		
		//3.비밀번호 일치여부
		if(!passwordEncoder.matches(account.getPassword(), dbUser.getPassword())) {
			log.info("불일치시 출력");
			return "redirect:/login";
		}
		
		//세션주입
		authService.getAuthentication(account.getAccountId(), dbUser, req);
		log.info("세션주입아래");
		return "tiles:content";
	}
	

	
}
