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
		<link rel="stylesheet" type="text/css" href="assets/css/bootstrap.css">
		<link rel="stylesheet" type="text/css" href="assets/css/css_full/bootstrap.css">
		<link rel="stylesheet" type="text/css" href="assets/css/css_full/font-awesome.css">
		<!-- Fonts-->
		<link rel="stylesheet" type="text/css" href="assets/fonts/fontawesome/font-awesome.min.css">
		<link rel="stylesheet" type="text/css" href="assets/fonts/pe-icon/pe-icon.css">
		<!-- Vendors-->
		<link rel="stylesheet" type="text/css" href="assets/vendors/bootstrap/grid.css">
		<link rel="stylesheet" type="text/css" href="assets/vendors/magnific-popup/magnific-popup.min.css">
		<link rel="stylesheet" type="text/css" href="assets/vendors/swiper/swiper.css">
		<!-- App & fonts-->
		<link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Montserrat:300,400,500,600,700|Open+Sans:400,700">
		<link rel="stylesheet" type="text/css" id="app-stylesheet" href="assets/css/main.css"><!--[if lt IE 9]>
			<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
		<![endif]-->
		<style type="text/css">
			.btn-kdb{
				width:200px;
				height:50px;
				margin: 10px;
			}
			.awe-section{
				padding:40px;
			}
		</style>
		<style type="text/css">
		body{
			background-image: url("/assets/img/back.png");
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
							<p class="page-title__text">사용하실 비품을 선택해 주세요.</p>
							<div class="page-title__divider"></div>
						</div><!-- End / page-title -->
						
					</div>
				</section>
				<!-- End / Section -->
				<section class="awe-section bg-gray">
					<div class="container">
						<table class="table text-center">
							<colgroup>
								<col width="10%"/>
								<col width="10%"/>
								<col width="10%"/>
								<col width="10%"/>
								<col width="10%"/>
								<col width="50%"/>
							</colgroup>
							<thead>
								<tr>
									<th colspan="2">종류</th>
									<th colspan="2">이름</th>
									<th>수량</th>
									<th>기타 요구사항</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td colspan="2" rowspan="2">
										<button class="btn btn-default btn-kdb">간식</button>
										<button class="btn btn-info btn-kdb">비품/자재</button>
									</td>
									<td colspan="2">
										<br>
										<select class="form-control">
											<option>마우스</option>
											<option>키보드</option>
											<option>빔 프로젝트</option>
											<option>레이저 포인터</option>
											<option>무선 마이크</option>
										</select>
									</td>
									<td>
										<Br><input type="text" class="form-control" placeholder="수량 입력" />
									</td>
									<td>
										<br><input type="text" class="form-control" placeholder="요구사항 입력" />
									</td>
								</tr>
							</tbody>
							<tfoot>
								<tr>
									<td>종류</td>
									<td colspan="2">비품 이름</td>
									<td>수량</td>
									<td>가격</td>
									<td>요구사항</td>
								</tr>
								<tr>
									<td>비품/자재</td>
									<td colspan="2">마우스</td>
									<td>3</td>
									<td>3,000 원</td>
									<td>입력 없음</td>
								</tr>
							</tfoot>
						</table>
						<div class="pull-left ">
							<button class="btn btn-default btn-kdb">이전</button>
						</div>
						<div class="pull-right">
							<button class="btn btn-primary btn-kdb">다음</button>
						</div>
					</div>
				</section>
				
				<!-- Section -->
				<!-- End / Section -->
				
			</div>
			<!-- End / Content-->
			
			<!-- footer -->
				<jsp:include page="/WEB-INF/views/user/common/footer.jsp" />
			<!-- End / footer -->
			
		</div>
		<!-- Vendors-->
		<script type="text/javascript" src="assets/vendors/jquery/jquery.min.js"></script>
		<script type="text/javascript" src="assets/vendors/imagesloaded/imagesloaded.pkgd.js"></script>
		<script type="text/javascript" src="assets/vendors/isotope-layout/isotope.pkgd.js"></script>
		<script type="text/javascript" src="assets/vendors/jquery-one-page/jquery.nav.min.js"></script>
		<script type="text/javascript" src="assets/vendors/jquery.easing/jquery.easing.min.js"></script>
		<script type="text/javascript" src="assets/vendors/jquery.matchHeight/jquery.matchHeight.min.js"></script>
		<script type="text/javascript" src="assets/vendors/magnific-popup/jquery.magnific-popup.min.js"></script>
		<script type="text/javascript" src="assets/vendors/masonry-layout/masonry.pkgd.js"></script>
		<script type="text/javascript" src="assets/vendors/jquery.waypoints/jquery.waypoints.min.js"></script>
		<script type="text/javascript" src="assets/vendors/swiper/swiper.jquery.js"></script>
		<script type="text/javascript" src="assets/vendors/menu/menu.js"></script>
		<script type="text/javascript" src="assets/vendors/typed/typed.min.js"></script>
		<!-- App-->
		<script type="text/javascript" src="assets/js/main.js"></script>
	</body>
</html>