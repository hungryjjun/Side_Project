<!-- 
 * == 개정이력(Modification Information) ==
 *   
 *   수정일      			수정자           수정내용
 *  ============   	============== =======================
 *  2025. 6. 2.     	young           최초 생성
 *
-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<form action="${pageContext.request.contextPath }/login/sucess" method="POST">
<div>
	<h5>아이디</h5>
	<input type="text" name="accountId">
</div>

<div>
	<h5>비밀번호</h5>
	<input type="password" name="password">
</div>

	<button type="submit">로그인</button>
</form>