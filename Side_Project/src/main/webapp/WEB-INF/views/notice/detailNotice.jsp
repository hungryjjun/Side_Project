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

<%-- <form action="${pageContext.request.contextPath}/notice/update/what" method="POST"> --%>
<div class="container mt-4">
    <div class="card shadow">
        <div class="card-header bg-primary text-white">
            공지사항 상세보기
        </div>
        <div class="card-body">
            <table class="table table-bordered align-middle">
                <tbody>
                    <tr>
                        <th style="width: 15%;">글 번호</th>
                        <td>${notice.noticeId}</td>
                        <th style="width: 15%;">유형</th>
                        <td>${notice.categoryName}</td>
                    </tr>
                    <tr>
                        <th>제목</th>
                        <td colspan="3">${notice.title}</td>
                    </tr>
                    <tr>
                        <th>작성자</th>
                        <td colspan="3">${notice.empId}</td>
                    </tr>
                    <tr>
                        <th>작성일</th>
                        <td>${notice.createdAt}</td>
                        <th>조회수</th>
                        <td>${notice.viewCount}</td>
                    </tr>
                    <tr>
                        <th>내용</th>
                        <td colspan="3">
                            <div class="content-box-scroll">
                                ${notice.content}
                            </div>
                        </td>
                    </tr>
                </tbody>
            </table>

            <div class="text-end">
                <a href="${pageContext.request.contextPath}/notice/update/${notice.noticeId}" class="btn btn-warning">수정</a>
                <a href="${pageContext.request.contextPath}/notice" class="btn btn-secondary">목록으로</a>
            </div>
        </div>
    </div>
</div>
    	
    		
  
  
<!-- </form> -->

