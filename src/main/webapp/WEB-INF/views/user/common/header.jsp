<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<%--
subject    : header.jsp
author     : 김동범
date       : 2018. 6. 11.
description : header 부분. 메뉴를 담당
 
  [이름]   [수정일]     [내용]
  ----------------------------------------------------------
  
--%>
<header class="header header--fixed">
	<div class="header__inner">
		<div class="header__logo">
			<a href="index.jsp"><img src="assets/img/gsitm.jpg" alt=""
				style="width: 122px;" /></a>
		</div>
		<div class="navbar-toggle" id="fs-button">
			<div class="navbar-icon">
				<span></span>
			</div>
		</div>
	</div>

	<!-- fullscreenmenu__module -->
	<div class="fullscreenmenu__module" trigger="#fs-button">

		<!-- overlay-menu -->
		<nav class="overlay-menu">

			<!--  -->
			<ul class="wil-menu-list">
				<li class="current-menu-item"><a href="index.jsp">Home</a></li>
				<li><a href="blog.jsp">소개</a></li>
				<li><a href="${path}/resv/resvStep1.do">예약</a></li>
				<li><a href="about.jsp">My Page</a></li>
				<li><a href="contact.jsp">Contact</a></li>
				<li><a href="${path}/email/write.do">Report</a></li>
				<c:if test="${'R_MGR' eq sessionID.role }">
					<li><a href="contact.jsp">관리자 page</a></li>
				</c:if>
			</ul>
			<!--  -->

		</nav>
		<!-- End / overlay-menu -->

	</div>
	<!-- End / fullscreenmenu__module -->

</header>