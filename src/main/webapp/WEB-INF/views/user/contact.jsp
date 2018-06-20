<%--
subject    : contact.jsp
author     : 은종현
date       : 2018-06-11
description : 메일링
 
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
		<title>Contact</title>
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
		<style>
			.page-title__title {
				color : red;
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
							<h2 class="page-title__title">Report Email</h2>
							<p class="page-title__text">회의실 및 교육실 사용에 있어 불편 사항이 있으시면 신고해 주시길 바랍니다. </p>
							<div class="page-title__divider"></div>
						</div><!-- End / page-title -->
						
					</div>
				</section>
				<!-- End / Section -->
				
				
				<!-- Section -->
				<section class="awe-section bg-gray">
					<div class="container">
						<div class="row">
							<div class="col-md-4 col-lg-3 ">
								
								<!-- contact -->
								<div class="contact">
									<div class="contact__icon"><i class="pe-7s-note"></i></div>
									<h3 class="contact__title">address</h3>
									<div class="contact__text">서울시 종로구 계동길 31 보헌빌딩 1F & 2F (우)03059</div>
								</div><!-- End / contact -->
								
								
								<!-- contact -->
								<div class="contact">
									<div class="contact__icon"><i class="pe-7s-back"></i></div>
									<h3 class="contact__title">call us</h3>
									<div class="contact__text">02-2189-6700</div>
								</div><!-- End / contact -->
								
								
								<!-- contact -->
								<div class="contact">
									<div class="contact__icon"><i class="pe-7s-voicemail"></i></div>
									<h3 class="contact__title">e-mail</h3>
									<div class="contact__text"><a href="#">silverbell@gsitm.com</a></div>
								</div><!-- End / contact -->
								
							</div>
							<div class="col-md-7 col-lg-8 col-xs-offset-0 col-sm-offset-0 col-md-offset-0 col-lg-offset-1 ">
								<div class="form-wrapper">
									<form method="post" action="${path}/email/send.do">
										<!-- form-item -->
										<div class="form-item form-item--half">
											<input class="form-control" type="text" name="senderName" placeholder="Your name"/>
										</div><!-- End / form-item -->
										
										
										<!-- form-item -->
										<!-- End / form-item -->
										<input type="hidden" class="form-control" name="receiveMail" value="ndgndgal@gsitm.com">
										
										<!-- form-item -->
										<div class="form-item">
											<input class="form-control" type="text" name="subject" placeholder="Subject"/>
										</div><!-- End / form-item -->
										
										
										<!-- form-item -->
										<div class="form-item">
											<textarea class="form-control" name="message" placeholder="Your message" style="min-height:200px;"></textarea>
										</div><!-- End / form-item -->
										
										
										<!-- form-item -->
										<div class="form-item">
											<input type="submit" class="md-btn md-btn--primary md-btn--lg" value="Report">										
										</div><!-- End / form-item -->
									</form>
									<!-- 메일 전송 결과 확인 메세지 출력 -->
									<span style="color:red;">${message}</span>
								</div>
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