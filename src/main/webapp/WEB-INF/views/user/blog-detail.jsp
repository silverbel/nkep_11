<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Post detail</title>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
		<meta name="format-detection" content="telephone=no">
		<meta name="apple-mobile-web-app-capable" content="yes">
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
							<h2 class="page-title__title">회의실 및 교육실 선택</h2>
							<div class="post-detail__meta"><span class="date">Feb 22, 2018</span><span class="author"><a href="#">by Brandon Hanson</a></span></div>
							<div class="page-title__divider"></div>
						</div><!-- End / page-title -->
						
					</div>
				</section>
				<!-- End / Section -->
				
				
				<!-- Section -->
				<section class="awe-section bg-gray">
					<div class="container">
						
						<!--  -->
						<div class="col-xs-6">
							<div class="post-detail__media"><a href="discussRooms.jsp"><img src="./assets/img/works/discuss.jpg"/></a><!--<img src="https://images.pexels.com/photos/395132/pexels-photo-395132.jpeg?w=1260&amp;h=750&amp;auto=compress&amp;cs=tinysrgb" alt=""/>--></div>
							<div class="post-detail__entry row">
								<div class="col-md-8">
									<h5>Vivamus eget vulputate risus. Aliquam id fringilla lacus, vitae maximus felis. Suspendisse in posuere urna. Ut ipsum nisi, suscipit at nisl nec, pulvinar dapibus risus. Etiam non hendrerit nulla, in volutpat dui.</h5>
									<p>In nec porttitor nisi. Nunc at egestas ante. Sed vestibulum velit eu nibh commodo, non fermentum libero pellentesque. Fusce sed posuere ex, non ultrices nibh. <b>Fusce quis leo non ex rutrum convallis non ut ante.</b> Phasellus hendrerit ante nec est porta, et elementum massa euismod. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque et quam facilisis, posuere justo ut, maximus nulla. Quisque id fermentum tortor. Duis sem mi, luctus sed luctus eget, viverra et ante. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Donec faucibus imperdiet porttitor. Etiam fringilla ligula et porttitor tristique.</p>
								
									<p>Donec quis molestie magna. Sed mattis ac nunc sit amet scelerisque. Curabitur a aliquam sem. Suspendisse condimentum elementum eros, a vehicula tortor ornare sit amet. Donec ac commodo enim, eget mattis ipsum.</p>
									<p>In vestibulum vestibulum suscipit. Phasellus velit felis, imperdiet quis dolor ut, aliquet iaculis mauris. Pellentesque consectetur placerat suscipit. Donec quis hendrerit eros. Mauris sed leo aliquet, feugiat magna et, feugiat mauris. Integer a nunc eu risus ultrices euismod. Pellentesque at dictum turpis. Fusce sed mauris lorem. Nam condimentum odio diam, vitae congue sapien mollis vitae. Pellentesque nulla est, dapibus finibus sapien in, euismod dapibus diam.</p>
									<p>In dictum, magna non suscipit volutpat, ligula ligula scelerisque purus, et dapibus ipsum enim quis nisi. Sed eget faucibus velit. Integer in felis consequat, aliquam neque vitae, pellentesque nibh. Donec id lobortis risus, at finibus tortor. Praesent consequat elementum tristique. Sed dictum quis magna a consequat. Maecenas id malesuada sem. Phasellus pharetra odio purus, sit amet commodo tortor mollis ac. Donec gravida aliquet tellus.</p>
								</div>
							</div>
							
							<div class="awe-text-center mt-50">
							<a class="md-btn md-btn--outline-primary " href="blog-detail.jsp">All block content
							</a>
						</div>
						</div><!-- End /  -->
						<div class="col-xs-6">
							<div class="post-detail__media"><a href="educationRooms.jsp"><img src="./assets/img/works/education.png"/></a><!--<img src="https://images.pexels.com/photos/395132/pexels-photo-395132.jpeg?w=1260&amp;h=750&amp;auto=compress&amp;cs=tinysrgb" alt=""/>--></div>
							<div class="post-detail__entry row">
								<div class="col-md-8">
									<h5>Vivamus eget vulputate risus. Aliquam id fringilla lacus, vitae maximus felis. Suspendisse in posuere urna. Ut ipsum nisi, suscipit at nisl nec, pulvinar dapibus risus. Etiam non hendrerit nulla, in volutpat dui.</h5>
									<p>In nec porttitor nisi. Nunc at egestas ante. Sed vestibulum velit eu nibh commodo, non fermentum libero pellentesque. Fusce sed posuere ex, non ultrices nibh. <b>Fusce quis leo non ex rutrum convallis non ut ante.</b> Phasellus hendrerit ante nec est porta, et elementum massa euismod. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque et quam facilisis, posuere justo ut, maximus nulla. Quisque id fermentum tortor. Duis sem mi, luctus sed luctus eget, viverra et ante. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Donec faucibus imperdiet porttitor. Etiam fringilla ligula et porttitor tristique.</p>
								
									<p>Donec quis molestie magna. Sed mattis ac nunc sit amet scelerisque. Curabitur a aliquam sem. Suspendisse condimentum elementum eros, a vehicula tortor ornare sit amet. Donec ac commodo enim, eget mattis ipsum.</p>
									<p>In vestibulum vestibulum suscipit. Phasellus velit felis, imperdiet quis dolor ut, aliquet iaculis mauris. Pellentesque consectetur placerat suscipit. Donec quis hendrerit eros. Mauris sed leo aliquet, feugiat magna et, feugiat mauris. Integer a nunc eu risus ultrices euismod. Pellentesque at dictum turpis. Fusce sed mauris lorem. Nam condimentum odio diam, vitae congue sapien mollis vitae. Pellentesque nulla est, dapibus finibus sapien in, euismod dapibus diam.</p>
									<p>In dictum, magna non suscipit volutpat, ligula ligula scelerisque purus, et dapibus ipsum enim quis nisi. Sed eget faucibus velit. Integer in felis consequat, aliquam neque vitae, pellentesque nibh. Donec id lobortis risus, at finibus tortor. Praesent consequat elementum tristique. Sed dictum quis magna a consequat. Maecenas id malesuada sem. Phasellus pharetra odio purus, sit amet commodo tortor mollis ac. Donec gravida aliquet tellus.</p>
								</div>
							</div>
							
							<div class="awe-text-center mt-50">
							<a class="md-btn md-btn--outline-primary " href="blog-detail.jsp">All block content
							</a>
						</div>
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