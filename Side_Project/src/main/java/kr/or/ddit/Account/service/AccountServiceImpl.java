package kr.or.ddit.Account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ddit.Account.dao.AccountMapper;
import kr.or.ddit.Account.vo.AccountVO;
import kr.or.ddit.Authentication.AuthenticationService;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountMapper mapper;
	
	@Autowired
	private AuthenticationService authService;
	
	@Override
	public AccountVO selectedAccount(AccountVO authUser, String accountId) {
		return mapper.selectedAccount(accountId);
	}

}
