package kr.or.ddit.Account.vo;

import lombok.Data;

@Data
public class AccountVO {
	
	private String accountId; // 사원번호와 동일
	private String password; // 직원 로그인 비밀번호 (보안을 위해 암호화 권장) 기본값:1234
	private Long roleId; // 직원의 권한
	private String accountStatus; // 직원의 계정상태('Y'활성화, 'N'비활성화)
	private String accountDate; // 직원의 계정등록일
	private String accountDel; // 직원의 비활성화 일자
	private String accountUpdate; // 직원의 계정수정일
	private Long tmId; // 직원의 팀
	private String accountEmail; // 계정직원의 이메일
	private String accountAdd2; // 계정직원의 상세주소
	private String accountPh; // 계정직원의 핸드폰번호
	private Long rankId; // 직원의직급
	private String empId; // 직원 정보를 저장하는 테이블
	private String departmentId; // 직원의 부서정보
	private String jobId; // 직원의 직책정보
	private String empName; // 직원의 이름

}
