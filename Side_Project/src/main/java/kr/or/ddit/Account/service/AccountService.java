package kr.or.ddit.Account.service;

import kr.or.ddit.Account.vo.AccountVO;

public interface AccountService {

	/**
	 * 선택된 계정조회
	 * @param empId
	 * @return
	 */
	public AccountVO selectedAccount(AccountVO authUser,String accountId);
}
