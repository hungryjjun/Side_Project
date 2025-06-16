package kr.or.ddit.Account.vo;

import lombok.Data;

@Data
public class EmployeeVO {
	
	private String empId; // 직원ID
	private String name; // 이름
	private Long teamId; // 팀ID
	private String tenure; // 근속년월
	private String retireDate; // 퇴사 날짜
	private String empStatus; // 근무상태(퇴사/휴직/재직)
	private Long empImg; // 프로필
	private Long roleId; // 직원권한
	private String retireReason; // 퇴사 사유
	private String leaveStartDate; // 휴직 시작일
	private String leaveEndDate; // 휴직 종료일
	private String leaveReason; // 휴직 사유
	private Long departmentId; // 부서ID
	private Long jobId; // 직책ID
	private Long positionId; // 직무ID
	private Long rankId; // 직급ID

}
