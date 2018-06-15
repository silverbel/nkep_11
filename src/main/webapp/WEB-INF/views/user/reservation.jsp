<%--
subject    : reservation.jsp
author     : 은종현
date       : 2018-06-11
description : 예약하기
 
  [이름]   [수정일]     [내용]
  ----------------------------------------------------------
  은종현	2018-06-11	 초안
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
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
		<meta name="format-detection" content="telephone=no">
		<meta name="apple-mobile-web-app-capable" content="yes">
		<!-- BootStrap & CSS -->
		<link rel="stylesheet" type="text/css" href="/assets/css/bootstrap.css">
		<link rel="stylesheet" type="text/css" href="/assets/css/css_full/bootstrap.css">
		<link rel="stylesheet" type="text/css" href="/assets/css/css_full/font-awesome.css">
		<!-- Fonts-->
		<link rel="stylesheet" type="text/css" href="/assets/fonts/fontawesome/font-awesome.min.css">
		<link rel="stylesheet" type="text/css" href="/assets/fonts/pe-icon/pe-icon.css">
		<!-- Vendors-->
		<link rel="stylesheet" type="text/css" href="/assets/vendors/bootstrap/grid.css">
		<link rel="stylesheet" type="text/css" href="/assets/vendors/magnific-popup/magnific-popup.min.css">
		<link rel="stylesheet" type="text/css" href="/assets/vendors/swiper/swiper.css">
		<!-- App & fonts-->
		<link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Montserrat:300,400,500,600,700|Open+Sans:400,700">
		<link rel="stylesheet" type="text/css" id="app-stylesheet" href="/assets/css/main.css"><!--[if lt IE 9]>
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
		<script type="text/javascript" src="/assets/vendors/jquery/jquery.min.js"></script>
		<script type="text/javascript">
			// this 클래스 btn-info => btn-default
			// 		  btn-default => btn-info
			$(document).ready(function(){
				$('.times').click(function(){
					if($(this).hasClass('disabled')){
						return;
					}else if($(this).hasClass('btn-default')){
						$(this).removeClass('btn-default');
						$(this).addClass('btn-info');
					}else if($(this).hasClass('btn-info')){
						$(this).removeClass('btn-info');
						$(this).addClass('btn-default');
					} 
				})
			})
		function fn_prev(){
			location.href = "/resv/resvStep1.do";
		}
		
		
		</script>
		<style type="text/css">
			.btn-kdb{
				width:200px;
				height:50px;
				margin: 10px;
			}
			.awe-section{
				padding:40px;
			}
			.btn-kdb-times {
				width:70px;
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
					
							<h2 class="page-title__title">예약하기</h2>
							<p class="page-title__text">예약하실 곳을 선택해 주세요.</p>
							<div class="page-title__divider"></div>
						</div><!-- End / page-title -->
						
					</div>
				</section>
				<!-- End / Section -->
				
				<!-- Booking Section -->
				<form action="" method="post">
				<section class="awe-section bg-gray">
					<div class="container">
						<table class="table text-center">
							<colgroup>
								<col width="20%"/>
								<col width="20%"/>
								<col width="10%"/>
								<col width="60%"/>
							</colgroup>
							<thead>
								<tr>
									<th>종류</th>
									<th>이름</th>
									<th>구분</th>
									<th>시간 선택</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td rowspan="5">
										<button class="btn btn-info btn-kdb">회의실</button><br>
										<button class="btn btn-default btn-kdb">교육실</button><br>
									</td>
									<td><button class="btn btn-default btn-kdb">미팅룸 1</button></td>
									<td rowspan="5">
										<button class="btn btn-default btn-kdb">단기 예약</button>
										<button class="btn btn-info btn-kdb">장기 예약</button>
									</td>
									<td rowspan="5" class="text-left" id="time">
										
									</td>
								</tr>
								<tr>
									<td><button class="btn btn-default btn-kdb">미팅룸 2</button></td>
								</tr>
								<tr>
									<td><button class="btn btn-default btn-kdb">미팅룸 3</button></td>
								</tr>
								<tr>
									<td><button class="btn btn-info btn-kdb">미팅룸 4</button></td>
								</tr>
								<tr>
									<td><button class="btn btn-default btn-kdb">미팅룸 5</button></td>
								</tr>
							</tbody>
						</table>
						<div class="pull-left ">
							<button class="btn btn-default btn-kdb" onclick="fn_prev();">이전</button>
						</div>
						<div class="pull-right">
							<button class="btn btn-primary btn-kdb">다음</button>
						</div>
					</div>
				</section>
				</form><!-- END / Booking -->
				
				<!-- Section -->
				<section class="awe-section bg-gray">
					<div class="container">
						<div class="awe-text-center mt-50">
							<a class="md-btn md-btn--outline-primary " href="#">more work
							</a>
						</div>
					</div>
				</section>
				<!-- End / Section -->
				
			</div>
			<!-- End / Content-->
			
			<!-- footer -->
				<jsp:include page="/WEB-INF/views/user/common/footer.jsp" />
			<!-- End / footer -->
			
		</div>
		<!-- Vendors-->
		<script type="text/javascript" src="/assets/vendors/imagesloaded/imagesloaded.pkgd.js"></script>
		<script type="text/javascript" src="/assets/vendors/isotope-layout/isotope.pkgd.js"></script>
		<script type="text/javascript" src="/assets/vendors/jquery-one-page/jquery.nav.min.js"></script>
		<script type="text/javascript" src="/assets/vendors/jquery.easing/jquery.easing.min.js"></script>
		<script type="text/javascript" src="/assets/vendors/jquery.matchHeight/jquery.matchHeight.min.js"></script>
		<script type="text/javascript" src="/assets/vendors/magnific-popup/jquery.magnific-popup.min.js"></script>
		<script type="text/javascript" src="/assets/vendors/masonry-layout/masonry.pkgd.js"></script>
		<script type="text/javascript" src="/assets/vendors/jquery.waypoints/jquery.waypoints.min.js"></script>
		<script type="text/javascript" src="/assets/vendors/swiper/swiper.jquery.js"></script>
		<script type="text/javascript" src="/assets/vendors/menu/menu.js"></script>
		<script type="text/javascript" src="/assets/vendors/typed/typed.min.js"></script>
		<!-- App-->
		<script type="text/javascript" src="/assets/js/main.js"></script>
	</body>
</html>