<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
	<head>
		<title>Homepage</title>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
		<meta name="format-detection" content="telephone=no">
		<meta name="apple-mobile-web-app-capable" content="yes">
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
		<meta http-equiv="Content-Type" content="text/jsp; charset=UTF-8">
		<script type="text/javascript">
			function fn_go(path, url1, url2) {
				location.href = path+"/info/workspaceDetail.do?workName="
						+encodeURIComponent(url1)+
						"&workAddr="+encodeURIComponent(url2);
			}
		</script>
		<style type="text/css">
		body{
			background-image: url("/assets/img/back.png");
		}
		</style>

	</head>
	<body>
	<%-- <a href="<%=request.getContextPath()%>/memo.do">메모장</a> --%>
	<!-- Test!!! -->
	<div class="page-wrap" id="root">
			
			<!-- header -->
				<jsp:include page="/WEB-INF/views/user/common/header.jsp" />
			<!-- End / header -->
			
			<!-- Content-->
			<div class="wil-content">
				
				<!-- Section -->
				<section class="awe-section kdb-title">
					<div class="container">
						
						<!-- page-title -->
						<div class="page-title">
							<h2 class="page-title__title">${sessionID.empName}님 환영합니다!<br>
								 GS ITM 회의실 예약 시스템입니다.<br>
								<!-- typing__module -->
								<div class="typing__module">
									<div class="typed-strings"><span>근무지 별로</span><span>회의실과</span><span>교육실 예약이 가능합니다!</span>
									</div><span class="typed"></span>
								</div><!-- End / typing__module -->
								
							</h2>
							<p class="page-title__text"></p>
							<div class="page-title__divider"></div>
						</div><!-- End / page-title -->
						
					</div>
				</section>
				<!-- End / Section -->
				
				
				<!-- Section -->
				<section class="awe-section bg-gray">
					<div class="container">
						<div class="grid-css grid-css--masonry" data-col-lg="3" data-col-md="2" data-col-sm="2" data-col-xs="1" data-gap="30">
							<div class="grid__inner">
								<div class="grid-sizer"></div>
								
								<c:forEach var="item" items="${workSpaceList}">

									<div class="grid-item">
										<div class="grid-item__inner">
											<div class="grid-item__content-wrapper">
												
												<!-- post -->
												<div class="post">
													<div class="post__media"><a href="javascript:fn_go('${path}','${item.workName}','${item.workAddr}');"><img src="/getByteWorkSpaceImage/${item.workSeq}"/></a></div>
													<div class="post__body">
														<h2 class="post__title"><a href="javascript:fn_go('${path}','${item.workName}','${item.workAddr}');">${item.workName}</a></h2>
														<p class="post__text">${item.workDescription}</p>
														<a class="md-btn md-btn--outline-primary" href="javascript:fn_go('${path}','${item.workName}','${item.workAddr}');">read more
														</a>
													</div>
												</div><!-- End / post -->
												
											</div>
										</div>
									</div>
								</c:forEach>
								
								
								
								<!-- <div class="grid-item">
									<div class="grid-item__inner">
										<div class="grid-item__content-wrapper">
											
											post
											<div class="post">
												<div class="post__media"><a href="work-detail.jsp"><img src="/assets/img/works/gsnam.jpg"/><img src="https://images.pexels.com/photos/609687/pexels-photo-609687.jpeg?w=1260&amp;h=750&amp;auto=compress&amp;cs=tinysrgb" alt=""/></a></div>
												<div class="post__body">
													<div class="post__meta"><span class="date">Nov 26, 2017</span><span class="author"><a href="#">by Bryan Ryan</a></span></div>
													<h2 class="post__title"><a href="work-detail.jsp">GS 강남타워</a></h2>
													<p class="post__text">Nam suscipit nisi risus, et porttitor metus molestie a. Phasellus id quam id turpis suscipit pretium. Maecenas ultrices, lacus ut </p>
													<a class="md-btn md-btn--outline-primary" href="#">read more
													</a>
												</div>
											</div>End / post
											
										</div>
									</div>
								</div>
								<div class="grid-item">
									<div class="grid-item__inner">
										<div class="grid-item__content-wrapper">
											
											post
											<div class="post">
												<div class="post__media"><a href="work-detail.jsp"><img src="/assets/img/works/gsseo.jpg"/><img src="https://images.pexels.com/photos/754949/pexels-photo-754949.jpeg?w=1260&amp;h=750&amp;auto=compress&amp;cs=tinysrgb" alt=""/></a></div>
												<div class="post__body">
													<div class="post__meta"><span class="date">Dec 20, 2017</span><span class="author"><a href="#">by Bruce Powell</a></span></div>
													<h2 class="post__title"><a href="work-detail.jsp">GS 강서 N 타워</a></h2>
													<p class="post__text">Maecenas lorem ex, euismod eget pulvinar non, facilisis ut leo. Quisque placerat purus in neque efficitur ornare. Nam at justo mag</p>
													<a class="md-btn md-btn--outline-primary" href="#">read more
													</a>
												</div>
											</div>End / post
											
										</div>
									</div>
								</div> -->
						</div>
						<div class="awe-text-center mt-50">
							<a class="md-btn md-btn--outline-primary " href="#">Load more
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
		<script type="text/javascript" src="/assets/vendors/jquery/jquery.min.js"></script>
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