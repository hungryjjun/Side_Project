<!-- 
 * == 개정이력(Modification Information) ==
 *   
 *   수정일      			수정자           수정내용
 *  ============   	============== =======================
 *  2025. 5. 12.     	young           최초 생성
 *
-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<style>
.content-box-scroll {
    max-height: 300px;
    overflow-y: auto;
    padding: 1rem;
    background-color: #f8f9fa;
    border: 1px solid #dee2e6;
    border-radius: 0.25rem;
    white-space: pre-line;
}
</style>


<form method="POST" action="${pageContext.request.contextPath}/notice/update/what/${selectedNotice.noticeId}">>

<table class="table table-bordered">
    <tbody>
        <tr>
            <th scope="row" style="width: 15%;">글 번호</th>
            <td>${selectedNotice.noticeId}</td>
            <th scope="row" style="width: 15%;">유형</th>
            <td>${selectedNotice.categoryName}</td>
        </tr>
		<tr>
		    <th scope="row">제목</th>
		    <td colspan="3"> 
		        <input name="title" value="${selectedNotice.title}" type="text">
		    </td>
		</tr>
		
        <tr>
            <th scope="row">작성자</th>
            <td colspan="3">${selectedNotice.empId}</td>
        </tr>
        <tr>
            <th scope="row">작성일</th>
            <td>${selectedNotice.createdAt}</td>
            <th scope="row">조회수</th>
            <td>${selectedNotice.viewCount}</td>
        </tr>
			<tr>
			    <th scope="row">내용</th>
			    <td colspan="3">
					<textarea name="content" rows="10" cols="50" style="width: 98%;">${selectedNotice.content}</textarea>
			    </td>
			</tr>
    </tbody>
  </table>
  
<div style="text-align: right; margin-top: 10px;">
        <button type="submit" class="btn btn-primary">완료</button>
        <a href="${pageContext.request.contextPath}/notice" class="btn btn-secondary">목록으로</a>
    </div>
  </form>
  