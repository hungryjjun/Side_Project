package kr.or.ddit.Authentication;

import java.net.http.HttpRequest;
import java.util.Objects;
import java.util.logging.ErrorManager;

import javax.security.sasl.AuthenticationException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ddit.Account.dao.AccountMapper;
import kr.or.ddit.Account.vo.AccountVO;

@Service
public class AuthenticationService {
	
	@Autowired
	private AccountMapper mapper;
	
	public void getAuthentication(
			String accountId,
			AccountVO authUser,
			HttpServletRequest req
			){
		req.changeSessionId();
		req.getSession().setAttribute("sessionAccount", authUser);
		
		
		
	}

}
