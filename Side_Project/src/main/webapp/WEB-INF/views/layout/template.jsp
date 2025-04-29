<!-- 
 * == 개정이력(Modification Information) ==
 *   
 *   수정일      			수정자           수정내용
 *  ============   	============== =======================
 *  2025. 4. 29.     	young           최초 생성
 *
-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>


<html lang="en">
<head>
<title><tiles:getAsString name="title" /></title>

<style>
body {
    background-color: #F2F6FA    !important; /* !important 추가 */
    caret-color: transparent;
}

html, body, #layoutSidenav, #layoutSidenav_nav, #layoutSidenav_content {
    height: 100%;
</style>

<tiles:insertAttribute name="preScript" />
		
</head>
<body>

		<tiles:insertAttribute name="sidebar" />
		<tiles:insertAttribute name="header" />
		<tiles:insertAttribute name="content" />
		<tiles:insertAttribute name="footer" />

		<tiles:insertAttribute name="postScript" />



</body>
</html>

