<!-- 
 * == 개정이력(Modification Information) ==
 *   
 *   수정일      			수정자           수정내용
 *  ============   	============== =======================
 *  2025. 5. 19.     	young           최초 생성
 *
-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<form action="${pageContext.request.contextPath }/notice/insert/ok" method="POST">

	<div>
		<input type="text" name="empId">사번(임시) : 	
	</div>
	
	<div>
		<input type="text" name="title">제목 : 	
	</div>
	
	<div>
		<input type="text" name="content">내용 : 	
	</div>
	
	<div>
		<input type="text" name="categoryId">카테고리 : 	
	</div>
	
	<button type="submit">등록</button>
</form>