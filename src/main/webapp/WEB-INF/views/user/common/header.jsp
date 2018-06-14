<%--
subject    : header.jsp
author     : 김동범
date       : 2018. 6. 11.
description : header 부분. 메뉴를 담당
 
  [이름]   [수정일]     [내용]
  ----------------------------------------------------------
	김동범		2018.06.12	메뉴 수정  
	김동범		2018.06.12	로그아웃 추가  
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<header class="header header--fixed">
	<div class="header__inner">
		<div class="header__logo">
			<a href="/"><img src="/assets/img/gsitm.png" alt=""
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
				<li class="current-menu-item"><a href="/">Home</a></li>
				<li><a href="${path}/info/workspace.do">소개</a></li>
				<li><a href="${path}/resv/resvStep1.do">예약</a></li>
				<li><a href="${path }/myPage/info.do">My Page</a></li>
				<li><a href="${path }/myPage/myReserva.do">My Reservation</a></li>
				<li><a href="contact.jsp">Contact</a></li>
				<li><a href="${path}/email/write.do">Report</a></li>
				<li><a href="${path}/logout.do">Log Out</a></li>
				<c:if test="${'S_MGR' eq sessionID.role }">
					<li><a href="/admin.do">시스템 관리자 page</a></li>
				</c:if>
				<c:if test="${'E_MGR' eq sessionID.role }">
					<li><a href="contact.jsp">교육실 관리자 page</a></li>
				</c:if>
				<c:if test="${'M_MGR' eq sessionID.role }">
					<li><a href="contact.jsp">회의실 관리자 page</a></li>
				</c:if>
			</ul>
			<!--  -->

		</nav>
		<!-- End / overlay-menu -->

	</div>
	<!-- End / fullscreenmenu__module -->

</header>