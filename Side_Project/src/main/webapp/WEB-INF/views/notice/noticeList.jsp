<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="container mt-5">

    <div class="card shadow">
        <div class="card-header bg-primary text-white">
            <h5 class="mb-0">공지사항</h5>
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-hover align-middle text-center">
                    <thead class="table-light">
                        <tr>
                            <th>번호</th>
                            <th>분류</th>
                            <th>제목</th>
                            <th>게시일</th>
                            <th>작성자</th>
                            <th>조회수</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:choose>
                            <c:when test="${not empty noticeList}">
                                <c:forEach items="${noticeList}" var="noticeVO">
                                    <tr>
                                        <td>
                                            <a href="${pageContext.request.contextPath}/notice/who/${noticeVO.noticeId}" class="text-decoration-none">
                                                ${noticeVO.noticeId}
                                            </a>
                                        </td>
                                        <td>${noticeVO.categoryName}</td>
                                        <td class="text-start">${noticeVO.title}</td>
                                        <td>${noticeVO.createdAt.substring(0,10)}</td>
                                        <td>${sessionAccount.empName}</td>
                                        <td>${noticeVO.viewCount}</td>
                                    </tr>
                                </c:forEach>
                            </c:when>
                            <c:otherwise>
                                <tr>
                                    <td colspan="5">등록된 공지사항이 없습니다.</td>
                                </tr>
                            </c:otherwise>
                        </c:choose>
                    </tbody>
                    <tfoot>
                        <tr>
                            <td colspan="5" class="text-center">
                                ${pagingHTML}
                                <div id="search-ui">
                                	<select name="categoryId" data-init-value="${condition1.categoryId}">
                                		<option value>공지유형</option>
                                		<c:forEach items="${noticeList}" var="notice">
                                			<option value="${notice.categoryId}">${notice.categoryName }</option>
                                		</c:forEach>
                                	</select>
                                	<input type="text" name="title" placeholder="제목검색" value="${condition1.title}">
                                	<button type="button" id="search-btn">조회하기</button>
                                </div>
                            </td>
                        </tr>
                    </tfoot>
                </table>

                <form id="search-form">
                    <input type="hidden" name="page" value="1" />
                    <input type="hidden" name="categoryId"/>
                    <input type="hidden" name="title"/>
                </form>
            </div>

            <div class="text-end mt-3">
                <a href="${pageContext.request.contextPath}/notice/insert" class="btn btn-primary">
                    <i class="fas fa-pencil-alt"></i> 등록하기
                </a>
            </div>
        </div>
    </div>
</div>

<script src="${pageContext.request.contextPath }/resources/js/common/paging.js"></script>