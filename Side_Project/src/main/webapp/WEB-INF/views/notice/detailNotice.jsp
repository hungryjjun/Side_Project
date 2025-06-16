<%--  
 * == 개정이력(Modification Information) ===========================
 *   수정일              수정자           수정내용
 *  ---------------------------------------------------------------
 *   2025-05-12          young           최초 생성
 *   2025-06-02          ChatGPT         상세 UI 개선 (카드·첨부 list-group)
 * ================================================================  
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
<link rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.css">

<style>
.content-box {
    padding: 1rem;
    background-color: #f8f9fa;
    border: 1px solid #dee2e6;
    border-radius: 0.25rem;
    min-height: 160px;
}
</style>

<div class="container my-4">

  <div class="d-flex justify-content-between align-items-center mb-3">
      <h2 class="mb-0">${notice.title}</h2>
      <span class="badge bg-primary">${notice.categoryName}</span>
  </div>

  <div class="card shadow-sm mb-4">
    <div class="card-body p-0">
      <table class="table table-sm table-bordered mb-0">
        <tbody>
          <tr>
            <th class="bg-light" style="width:20%">글 번호</th>
            <td>${notice.noticeId}</td>
            <th class="bg-light" style="width:20%">작성자</th>
            <td>${sessionAccount.empName}</td>
          </tr>
          <tr>
            <th class="bg-light">작성일</th>
            <td>${notice.createdAt}</td>
            <th class="bg-light">조회수</th>
            <td>${notice.viewCount}</td>
          </tr>
          <tr>
            <th class="bg-light">중요 여부</th>
            <td>${notice.importance eq 'Y' ? '중요' : '일반'}</td>
            <th class="bg-light">카테고리 ID</th>
            <td>${notice.categoryId}</td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>

  <div class="card shadow-sm mb-4">
    <div class="card-body content-box">
      <c:out value="${notice.content}" escapeXml="false"/>
    </div>
  </div>

  <c:if test="${not empty files}">
    <h5 class="mb-2"><i class="bi bi-paperclip"></i> 첨부파일</h5>
    <ul class="list-group list-group-flush mb-4">
      <c:forEach var="file" items="${files}">
        <li class="list-group-item d-flex justify-content-between align-items-center">
          <a href="${pageContext.request.contextPath}/notice/file/${file.fileId}"
             class="text-decoration-none">
             ${file.originName}
          </a>
          <span class="small text-muted">
              ${(file.fileSize / 1024)}&nbsp;KB
          </span>
        </li>
      </c:forEach>
    </ul>
  </c:if>

  <div class="d-flex gap-2">
    <a href="${pageContext.request.contextPath}/notice"
       class="btn btn-outline-secondary">
       <i class="bi bi-list"></i>&nbsp;목록
    </a>

    <a href="${pageContext.request.contextPath}/notice/update/${notice.noticeId}"
       class="btn btn-outline-primary">
       <i class="bi bi-pencil-square"></i>&nbsp;수정
    </a>

    <form action="${pageContext.request.contextPath}/notice/delete/${notice.noticeId}"
          method="post" class="d-inline">
       <button type="submit" class="btn btn-outline-danger"
               onclick="return confirm('정말 삭제하시겠습니까?');">
               <i class="bi bi-trash"></i>&nbsp;삭제
       </button>
    </form>
  </div>

</div>
