<%--
subject    : 
author     : 남동길
date       : 2018. 6. 14.
description :
 
  [이름]   [수정일]     [내용]
  ----------------------------------------------------------
  
--%>
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

</head>
<body>
	<!-- Navigation -->
	<nav class="navbar navbar-default navbar-static-top" role="navigation"
		style="margin-bottom: 0">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-collapse">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="/admin.do">시스템 관리자 Page</a>
		</div>
		<!-- /.navbar-header -->
		<div class="text-right" style="line-height: 50px; margin-right: 20px;">
			<a href="${path}/logout.do"><i class="fa fa-sign-out fa-fw"></i>
				Logout</a>
		</div>
		<div class="navbar-default sidebar" role="navigation">
			<div class="sidebar-nav navbar-collapse">
				<ul class="nav" id="side-menu">
					<c:if test="${'S_MGR' eq sessionID.role }">
						<li><a href="/admin.do"><i class="fa fa-dashboard fa-fw"></i>
								Dashboard</a></li>
						<li><a href="#"><i class="fa fa-edit fa-fw"></i> 근무지 관리 <span
								class="fa arrow"></span></a>
							<ul class="nav nav-second-level">
								<li><a href="getWorkSpaceListForAdmin.do">근무지 리스트</a></li>
							</ul></li>
						<li><a href="#"><i class="fa fa-edit fa-fw"></i> 권한 관리 <span
								class="fa arrow"></span></a>
							<ul class="nav nav-second-level">
								<li><a href="getAuthorityForAdmin.do">권한 관리</a></li>
							</ul></li>
						<li><a href="#"><i class="fa fa-edit fa-fw"></i> 공지사항 관리
								<span class="fa arrow"></span></a>
							<ul class="nav nav-second-level">
								<li><a href="noticeList.do">공지사항</a></li>
							</ul></li>
					</c:if>
					<!-- <li>
                            <a href="#"><i class="fa fa-wrench fa-fw"></i>회원 관리<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="blackList.html">블랙리스트 관리</a>
                                </li>
                            </ul>
                        </li> -->
				</ul>
			</div>
			<!-- /.sidebar-collapse -->
		</div>
		<!-- /.navbar-static-side -->
	</nav>
</body>
</html>