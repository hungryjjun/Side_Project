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

	<title><tiles:getAsString name="title"></tiles:getAsString></title>
	<tiles:insertAttribute name="preScript"/>

<body class="index-page">
	<tiles:insertAttribute name="header"/>
	
	<div id="main">
		<tiles:insertAttribute name="content"/>
		<tiles:insertAttribute name="footer"/>
	</div>
	
	<tiles:insertAttribute name="postScript"/>
</body>
