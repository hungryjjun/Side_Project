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

    <title>공지사항 등록</title>

<div class="container mt-5">
    <div class="card shadow">
        <div class="card-header bg-primary text-white">
            <h5 class="mb-0">공지사항 등록</h5>
        </div>
        <div class="card-body">
            <form action="${pageContext.request.contextPath }/notice/insert/ok" method="POST" enctype="multipart/form-data">
                <div class="mb-3">
                    <label for="empId" class="form-label"></label>
                    <input type="hidden" class="form-control" id="empId" name="empId" value="${sessionAccount.accountId }">
                </div>
                
              <div class="mb-3">
                    <label for="categoryId" class="form-label">카테고리</label>
                    <select class="form-select" id="categoryId" name="categoryId">
                        <option value="" selected disabled>유형 선택</option>
                        <c:forEach items="${categoryList}" var="category">
                            <option value="${category.categoryId}">${category.categoryName}</option>
                        </c:forEach>
                    </select>
                </div>

                <div class="mb-3">
                    <label for="title" class="form-label">제목</label>
                    <input type="text" class="form-control" id="title" name="title" placeholder="제목 입력">
                </div>

                <div class="mb-3">
                    <label for="content" class="form-label">내용</label>
                    <textarea class="form-control" id="content" name="content" rows="4" placeholder="내용 입력"></textarea>
                </div>
                
                <div class="mb-3">
                    <label for="noticeFile" class="form-label">파일첨부</label>
                    <input type="file" name="files" multiple="multiple" class="text-danger" element="span" />
                </div>



                <div class="text-end">
                    <button type="submit" class="btn btn-success">등록</button>
                </div>
            </form>
        </div>
    </div>
</div>