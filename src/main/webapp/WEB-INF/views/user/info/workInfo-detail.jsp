<%--
subject    : workInfo-detail.jsp
author     : 은종현
date       : 2018-06-13
description : 근무지 디테일 페이지
 
  [이름]   [수정일]     [내용]
  ----------------------------------------------------------
   은종현	 2018-06-13	  초안 
--%> 
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<title>Post detail</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<meta name="format-detection" content="telephone=no">
<meta name="apple-mobile-web-app-capable" content="yes">
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
						<span class="post-detail__cat">Free stuff</span>
						<h2 class="page-title__title">${workName}</h2>
						<div class="page-title__divider"></div>
					</div>
					<!-- End / page-title -->

				</div>
			</section>
			<!-- End / Section -->

			<!-- Section -->
			<section class="awe-section bg-gray">
				<div class="container">
				        <div class="my-auto">
				         	<h2 class="mb-5">위치 안내</h2>
				          	<!-- 지도를 표시할 div 입니다 -->
							<div id="map" style="width:100%;height:350px;"></div>
							
							<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=604a17dd3f6e5c4edf18d6f354545eea&libraries=services,clusterer,drawing"></script>
							<script>
							var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
							    mapOption = { 
							        center: new daum.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
							        level: 3 // 지도의 확대 레벨
							    };
							
							// 지도를 생성합니다    
							var map = new daum.maps.Map(mapContainer, mapOption); 

							// 주소-좌표 변환 객체를 생성합니다
							var geocoder = new daum.maps.services.Geocoder();

							// 주소로 좌표를 검색합니다
							geocoder.addressSearch('${workAddr}', function(result, status) {

							    // 정상적으로 검색이 완료됐으면 
							     if (status === daum.maps.services.Status.OK) {

							        var coords = new daum.maps.LatLng(result[0].y, result[0].x);

							        // 결과값으로 받은 위치를 마커로 표시합니다
							        var marker = new daum.maps.Marker({
							            map: map,
							            position: coords
							        });

							        // 인포윈도우로 장소에 대한 설명을 표시합니다
							        var infowindow = new daum.maps.InfoWindow({
							            content: '<div style="width:150px;text-align:center;padding:6px 0;">${workName}</div>'
							        });
							        infowindow.open(map, marker);

							        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
							        map.setCenter(coords);
							    } 
							});    
							</script>
				        </div>				
				</div>
			</section>
			<!-- End / Section -->
			
			<!-- Section -->
			<section class="awe-section bg-gray">
				<div class="container">
					<h4 class="mb-5">회의실 및 교육실 상세 보기</h4>
					<center>
						<a class="md-btn md-btn--outline-primary" href="#mtRoom">회의실 보기</a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<a class="md-btn md-btn--outline-primary" href="#eduRoom">교육실 보기</a>
					</center>					
				</div>
			</section>
			<section id="mtRoom">
				<div class="container">
					<div class="my-auto">
						<div class="grid-css grid-css--masonry" data-col-lg="3" data-col-md="2" data-col-sm="2" data-col-xs="1" data-gap="30">
								<div class="grid__inner">
									<div class="grid-sizer"></div>
									
									<c:forEach var="item" items="${mtRoomList}">
	
										<div class="grid-item">
											<div class="grid-item__inner">
												<div class="grid-item__content-wrapper">
													
													<!-- post -->
													<div class="post">
														<div class="post__media"><a href="${path}/info/workspaceDetail.do"><img src="/assets/img/works/samhwan.jpg"/><!--<img src="https://images.pexels.com/photos/807034/pexels-photo-807034.jpeg?w=1260&amp;h=750&amp;auto=compress&amp;cs=tinysrgb" alt=""/>--></a></div>
														<div class="post__body">
															<h2 class="post__title"><a href="${path}/info/workspaceDetail.do">${item.mtName}</a></h2>
															<p class="post__text">${item.mtDescription}</p>
														</div>
													</div><!-- End / post -->
													
												</div>
											</div>
										</div>
									</c:forEach>
								</div>
							</div>
					</div>
				</div>				
			</section>
			
			<section class="awe-section bg-gray" id="eduRoom">
				<div class="container">
					<div class="my-auto">
						<div class="grid-css grid-css--masonry" data-col-lg="3" data-col-md="2" data-col-sm="2" data-col-xs="1" data-gap="30">
								<div class="grid__inner">
									<div class="grid-sizer"></div>
									
									<c:forEach var="item" items="${eduRoomList}">
	
										<div class="grid-item">
											<div class="grid-item__inner">
												<div class="grid-item__content-wrapper">
													
													<!-- post -->
													<div class="post">
														<div class="post__media"><a href="${path}/info/workspaceDetail.do"><img src="/assets/img/works/samhwan.jpg"/><!--<img src="https://images.pexels.com/photos/807034/pexels-photo-807034.jpeg?w=1260&amp;h=750&amp;auto=compress&amp;cs=tinysrgb" alt=""/>--></a></div>
														<div class="post__body">
															<h2 class="post__title"><a href="${path}/info/workspaceDetail.do">${item.eduName}</a></h2>
															<p class="post__text">${item.eduDescription}</p>
														</div>
													</div><!-- End / post -->
													
												</div>
											</div>
										</div>
									</c:forEach>
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
		src="/assets/vendors/jquery/jquery.min.js"></script>
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