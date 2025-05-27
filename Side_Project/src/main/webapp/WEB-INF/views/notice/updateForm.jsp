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


<form method="POST" action="${pageContext.request.contextPath}/notice/update/what/${selectedNotice.noticeId}">
    <div class="container mt-4">
        <div class="card shadow">
            <div class="card-header bg-primary text-white">
                공지사항 수정
            </div>
            <div class="card-body">
                <div class="row mb-3">
                    <div class="col-md-6">
                        <label class="form-label">글 번호</label>
                        <input type="text" class="form-control" value="${selectedNotice.noticeId}" readonly>
                    </div>
                    <div class="col-md-6">
                        <label class="form-label">유형</label>
                        <select name="categoryId" class="form-select">
                            <option>유형</option>
                            <c:forEach items="${categoryList}" var="category">
                                <option value="${category.categoryId}">${category.categoryName}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>

                <div class="mb-3">
                    <label class="form-label">제목</label>
                    <input type="text" name="title" class="form-control" value="${selectedNotice.title}">
                </div>

                <div class="row mb-3">
                    <div class="col-md-6">
                        <label class="form-label">작성자</label>
                        <input type="text" class="form-control" value="${selectedNotice.empId}" readonly>
                    </div>
                    <div class="col-md-6">
                        <label class="form-label">작성일</label>
                        <input type="text" class="form-control" value="${selectedNotice.createdAt}" readonly>
                    </div>
                </div>

                <div class="mb-3">
                    <label class="form-label">조회수</label>
                    <input type="text" class="form-control" value="${selectedNotice.viewCount}" readonly>
                </div>

                <div class="mb-3">
                    <label class="form-label">내용</label>
                    <textarea name="content" class="form-control" rows="8">${selectedNotice.content}</textarea>
                </div>

                <div class="text-end">
                    <button type="submit" class="btn btn-primary">완료</button>
                    <a href="${pageContext.request.contextPath}/notice" class="btn btn-secondary">목록으로</a>
                </div>
            </div>
        </div>
    </div>
</form>
  