package kr.or.ddit.Account.dao;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.Account.vo.AccountVO;

@Mapper
public interface AccountMapper {

	
	/**
	 * 선택된 계정조회
	 * @param empId
	 * @return
	 */
	public AccountVO selectedAccount(String accountId);
}
