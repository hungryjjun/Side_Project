<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="container-fluid"> 

    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">공지사항</h6>
        </div>
        <div class="card-body">
            <div class="table-responsive"> 
                <table class="table table-striped table-bordered table-hover" id="dataTable" width="100%" cellspacing="0">
                    <thead class="thead-light">
                        <tr>
                            <th>번호</th>
                            <th>분류</th>
                            <th>제목</th>
                            <th>게시일</th>
                            <th>조회수</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:if test="${not empty noticeList }">
                            <c:forEach items="${noticeList }" var="noticeVO">
                                <tr>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/notice/who/${noticeVO.noticeId}">
                                            ${noticeVO.noticeId}
                                        </a>
                                    </td>
                                    <td>${noticeVO.categoryName }</td>
                                    <td>${noticeVO.title }</td>
                                    <td>${noticeVO.createdAt }</td>
                                    <td>${noticeVO.viewCount }</td>
                                </tr>
                            </c:forEach>
                        </c:if>
                        <c:if test="${empty noticeList }">
                            <tr>
                                <td colspan="5" style="text-align: center;">등록된 공지사항이 없습니다.</td>
                            </tr>
                        </c:if>
                    </tbody>
                </table>
            </div> <%-- table-responsive div 종료 --%>

            <%-- 등록하기 버튼: 테이블 아래, 오른쪽 정렬 --%>
            <div style="text-align: right; margin-top: 15px;">
                <a href="${pageContext.request.contextPath}/notice/insert" class="btn btn-primary">
                    <i class="fas fa-pencil-alt"></i> 등록하기 
                </a>
            </div>

        </div>
    </div> 
</div>