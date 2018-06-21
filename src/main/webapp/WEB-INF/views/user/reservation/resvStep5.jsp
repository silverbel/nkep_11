<%--
subject    : reservation.jsp
author     : 남동길
date       : 2018-06-20
description : 예약하기
 
  [이름]   [수정일]     [내용]
  ----------------------------------------------------------
  남동길	2018-06-11	 초안
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<title>예약하기</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<meta name="format-detection" content="telephone=no">
<meta name="apple-mobile-web-app-capable" content="yes">
<!-- BootStrap & CSS -->
<link rel="stylesheet" type="text/css" href="/assets/css/bootstrap.css">
<link rel="stylesheet" type="text/css"
	href="/assets/css/css_full/bootstrap.css">
<link rel="stylesheet" type="text/css"
	href="/assets/css/css_full/font-awesome.css">
<!-- Fonts-->
<link rel="stylesheet" type="text/css"
	href="/assets/fonts/fontawesome/font-awesome.min.css">
<link rel="stylesheet" type="text/css"
	href="/assets/fonts/pe-icon/pe-icon.css">
<!-- Vendors-->
<link rel="stylesheet" type="text/css"
	href="/assets/vendors/bootstrap/grid.css">
<link rel="stylesheet" type="text/css"
	href="/assets/vendors/magnific-popup/magnific-popup.min.css">
<link rel="stylesheet" type="text/css"
	href="/assets/vendors/swiper/swiper.css">
<!-- App & fonts-->
<link rel="stylesheet" type="text/css"
	href="https://fonts.googleapis.com/css?family=Montserrat:300,400,500,600,700|Open+Sans:400,700">
<link rel="stylesheet" type="text/css" id="app-stylesheet"
	href="/assets/css/main.css">
<!--[if lt IE 9]>
			<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
		<![endif]-->
<!-- jQuery v2.1.4 -->
<script src="/assets/dist/js/jquery.js"></script>
<!-- Bootstrap Core JavaScript -->
<script src="/assets/dist/js/bootstrap.js"></script>
<!-- Custom Theme JavaScript -->
<!-- DatePicker JavaScript -->
<script src="/assets/dist/js/moment-ko.js"></script>
<script src="/assets/dist/js/transition.js"></script>
<script src="/assets/dist/js/collapse.js"></script>
<script src="/assets/dist/js/bootstrap-datetimepicker.js"></script>
<!-- DataTables JavaScript -->
<script src="/assets/dist/js/jquery.dataTables.js"></script>
<script src="/assets/dist/js/dataTables.bootstrap.js"></script>
<script src="/assets/dist/js/dataTables.responsive.js"></script>
<script src="/assets/dist/js/responsive.bootstrap.js"></script>
<!-- tabletools -->
<script src="/assets/dist/js/dataTables.tableTools.js"></script>
<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/data.js"></script>
<script type="text/javascript"
	src="/assets/vendors/jquery/jquery.min.js"></script>
<!-- data table -->
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.10.18/css/jquery.dataTables.css">
<script type="text/javascript" charset="utf8"
	src="https://cdn.datatables.net/1.10.18/js/jquery.dataTables.js"></script>
<style type="text/css">
.awe-section {
	padding: 40px;
}

* { /*  margin: 0; padding: 0; */
	font-size: 100%;
	font-family: 'Avenir Next', "Helvetica Neue", "Helvetica", Helvetica,
		Arial, sans-serif;
	line-height: 1.65;
}

img {
	max-width: 100%;
	margin: 0 auto;
	display: block;
}

.body-wrap {
	width: 100% !important;
	height: 100%;
	background: #f8f8f8;
}

a {
	color: #3DB7CC;
	text-decoration: none;
}

a:hover {
	text-decoration: underline;
}

.text-center {
	text-align: center;
}

.text-right {
	text-align: right;
}

.text-left {
	text-align: left;
}

.button {
	display: inline-block;
	color: white;
	background: #3DB7CC;
	border: solid #3DB7CC;
	border-width: 10px 20px 8px;
	font-weight: bold;
	border-radius: 4px;
}

.button:hover {
	text-decoration: none;
}

h1, h2, h3, h4, h5, h6 {
	margin-bottom: 20px;
	line-height: 1.25;
}

h1 {
	font-size: 32px;
}

h2 {
	font-size: 28px;
}

h3 {
	font-size: 24px;
}

h4 {
	font-size: 20px;
}

h5 {
	font-size: 16px;
}

p, ul, ol {
	font-size: 16px;
	font-weight: normal;
	margin-bottom: 20px;
}

.container_t {
	display: block !important;
	clear: both !important;
	margin: 0 auto !important;
	max-width: 580px !important;
}

.container_t table {
	width: 100% !important;
	border-collapse: collapse;
}

/* .container_t */ .masthead {
	padding: 80px 0;
	background: #3DB7CC;
	color: white;
}

.container_t .masthead h1 {
	margin: 0 auto !important;
	max-width: 90%;
	text-transform: uppercase;
}

.container_t .content_t {
	background: white;
	padding: 30px 35px;
}

.container_t .content_T.footer {
	background: none;
}

.container_t .content_t.footer p {
	margin-bottom: 0;
	color: #888;
	text-align: center;
	font-size: 14px;
}

.container_t .content_t.footer a {
	color: #888;
	text-decoration: none;
	font-weight: bold;
}

.container_t .content_t.footer a:hover {
	text-decoration: underline;
}
</style>
</head>

<body>
	<div class="page-wrap" id="root">
		<!-- header -->
		<jsp:include page="/WEB-INF/views/user/common/header.jsp" />
		<!-- End / header -->

		<!-- Content-->
		<div class="wil-content">

			<!-- Section -->
			<section class="awe-section">
				<div class="container">

					<!-- page-title -->
					<div class="page-title pb-40">

						<h2 class="page-title__title">예약신청 완료</h2>
						<p class="page-title__text">예약이 확정되기 위해서 승인절차를 기다려주세요.</p>
						<div class="page-title__divider"></div>
					</div>
					<!-- End / page-title -->

				</div>
			</section>
			<!-- End / Section -->
			<section class="awe-section bg-gray">
				<div class="container">
					<div class="row">

        <!-- Post Content Column -->
        <div class="col-lg-12" style="background:white; box-shadow: 0 2px 92px 0 rgba(0, 0, 0, .18);">

          <!-- Title -->
          <h1 class="mt-4 masthead" style="background: #3DB7CC;" align="center" >예약 승인이 대기중입니다.</h1>
          <hr>
          <div class="container_t"><img src="https://i.imgur.com/Q0zUYOW.png" /></div>
          

          <!-- Post Content -->
          <div class="col-lg-12 text-center">
          		<h1>예약이 신청되었습니다!</h1>
          		<h3>승인 절차가 진행중이니 기다려 주십시오.</h3>
          		<h4>감사합니다.</h4>
          		
			</div>
<div class="container_t">
<table>
									<tr>
										<td class="content_t footer" align="center">
											<p>
												Sent by <a href="#">GS ITM</a>, 서울특별시 종로구 계동 84
											</p>
											<p>
												<a href="mailto:">gsitm@gsitm.com</a> | <a href="#">Unsubscribe</a>
											</p>
										</td>
									</tr>
								</table>
								</div>
          <hr>
        </div>

      </div>
					

					<%-- 근무지 번호 :
					<c:out value="${insertResv.workSeq}" />
					공간 종류 :
					<c:out value="${insertResv.roomType}" />
					공간 번호 :
					<c:out value="${insertResv.roomSeq}" />
					예약 종류 :
					<c:out value="${insertResv.rsvType}" />
					시작 시간 :
					<c:out value="${insertResv.startTime}" />
					종료 시간 :
					<c:out value="${insertResv.finTime}" />
					최대 인원 수 :
					<c:out value="${insertResv.maxCnt}" />
					멤버 :
					<c:forEach items="${insertResv.empIdList }" var="emp">
						<c:out value="${emp }" />
					</c:forEach>
					<c:forEach items="${insertResv.EXPENDABLE }" var="emp">
						<c:out value="${emp }" />
					</c:forEach>
					<c:forEach items="${insertResv.FIXTURES }" var="emp">
						<c:out value="${emp }" />
					</c:forEach>
					<c:forEach items="${insertResv.SNACK }" var="emp">
						<c:out value="${emp }" />
					</c:forEach>
					오늘 :
					<c:out value="${insertResv.today}" /> --%>
					<br>
					<div class="row">
						<div class="col-lg-12">
					<div class="pull-left ">
						<button class="btn btn-default btn-kdb" onclick="fn_prev();">이전</button>
					</div>
					<div class="pull-right">
						<form action="/main.do" method="get">
							<button class="btn btn-primary btn-kdb">확인</button>
						</form> 
					</div>
					</div>
					</div>
				</div>
			</section>

		</div>
		<!-- End / Content-->

		<!-- footer -->
		<jsp:include page="/WEB-INF/views/user/common/footer.jsp" />
		<!-- End / footer -->

	</div>

	<!-- Vendors-->
	<script type="text/javascript"
		src="/assets/vendors/imagesloaded/imagesloaded.pkgd.js"></script>
	<script type="text/javascript"
		src="/assets/vendors/isotope-layout/isotope.pkgd.js"></script>
	<script type="text/javascript"
		src="/assets/vendors/jquery-one-page/jquery.nav.min.js"></script>
	<script type="text/javascript"
		src="/assets/vendors/jquery.easing/jquery.easing.min.js"></script>
	<script type="text/javascript"
		src="/assets/vendors/jquery.matchHeight/jquery.matchHeight.min.js"></script>
	<script type="text/javascript"
		src="/assets/vendors/magnific-popup/jquery.magnific-popup.min.js"></script>
	<script type="text/javascript"
		src="/assets/vendors/masonry-layout/masonry.pkgd.js"></script>
	<script type="text/javascript"
		src="/assets/vendors/jquery.waypoints/jquery.waypoints.min.js"></script>
	<script type="text/javascript"
		src="/assets/vendors/swiper/swiper.jquery.js"></script>
	<script type="text/javascript" src="/assets/vendors/menu/menu.js"></script>
	<script type="text/javascript" src="/assets/vendors/typed/typed.min.js"></script>
	<!-- App-->
	<script type="text/javascript" src="/assets/js/main.js"></script>
</body>
</html>