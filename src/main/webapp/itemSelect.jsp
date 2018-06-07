<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
	<head>
		<title>ìì½íê¸°</title>
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
	</head>
	
	<body>
		<div class="page-wrap" id="root">
			
			<!-- header -->
			<header class="header header--fixed">
				<div class="header__inner">
					<div class="header__logo"><a href="index.jsp"><img src="assets/img/gsitm.jpg" alt="" style="width: 122px;"/></a></div>
					<div class="navbar-toggle" id="fs-button">
						<div class="navbar-icon"><span></span></div>
					</div>
				</div>
				
				<!-- fullscreenmenu__module -->
				<div class="fullscreenmenu__module" trigger="#fs-button">
					
					<!-- overlay-menu -->
					<nav class="overlay-menu">
						
						<!--  -->
						<ul class="wil-menu-list">
							<li class="current-menu-item"><a href="index.jsp">Home</a>
							</li>
							<li><a href="blog.jsp">ìê°</a>
							</li>
							<li><a href="work.jsp">ìì½</a>
							</li>
							<li><a href="about.jsp">My Page</a>
							</li>
							<li><a href="contact.jsp">Contact</a>
							</li>
						</ul><!--  -->
						
					</nav><!-- End / overlay-menu -->
					
				</div><!-- End / fullscreenmenu__module -->
				
			</header><!-- End / header -->
			
			<!-- Content-->
			<div class="wil-content">
				
				<!-- Section -->
				<section class="awe-section">
					<div class="container">
						
						<!-- page-title -->
						<div class="page-title pb-40">
							<h2 class="page-title__title">ìì½íê¸°</h2>
							<p class="page-title__text">ì¬ì©íì¤ ë¹íì ì íí´ ì£¼ì¸ì.</p>
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
									<th colspan="2">ì¢ë¥</th>
									<th colspan="2">ì´ë¦</th>
									<th>ìë</th>
									<th>ê¸°í ìêµ¬ì¬í­</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td colspan="2" rowspan="2">
										<button class="btn btn-default btn-kdb">ê°ì</button>
										<button class="btn btn-info btn-kdb">ë¹í/ìì¬</button>
									</td>
									<td colspan="2">
										<br>
										<select class="form-control">
											<option>ë§ì°ì¤</option>
											<option>í¤ë³´ë</option>
											<option>ë¹ íë¡ì í¸</option>
											<option>ë ì´ì  í¬ì¸í°</option>
											<option>ë¬´ì  ë§ì´í¬</option>
										</select>
									</td>
									<td>
										<Br><input type="text" class="form-control" placeholder="ìë ìë ¥" />
									</td>
									<td>
										<br><input type="text" class="form-control" placeholder="ìêµ¬ì¬í­ ìë ¥" />
									</td>
								</tr>
							</tbody>
							<tfoot>
								<tr>
									<td>ì¢ë¥</td>
									<td colspan="2">ë¹í ì´ë¦</td>
									<td>ìë</td>
									<td>ê°ê²©</td>
									<td>ìêµ¬ì¬í­</td>
								</tr>
								<tr>
									<td>ë¹í/ìì¬</td>
									<td colspan="2">ë§ì°ì¤</td>
									<td>3</td>
									<td>3,000 ì</td>
									<td>ìë ¥ ìì</td>
								</tr>
							</tfoot>
						</table>
						<div class="pull-left ">
							<button class="btn btn-default btn-kdb">ì´ì </button>
						</div>
						<div class="pull-right">
							<button class="btn btn-primary btn-kdb">ë¤ì</button>
						</div>
					</div>
				</section>
				
				<!-- Section -->
				<!-- End / Section -->
				
			</div>
			<!-- End / Content-->
			
			<!-- footer -->
			<div class="footer">
				<div class="container">
					<div class="row">
						<div class="col-md-6 col-lg-6 ">
							<p class="footer__coppy">2018 &copy; Copyright <a href="http://awe7.com/">Awe7</a>. All rights Reserved.</p>
						</div>
						<div class="col-md-6 col-lg-6 ">
							<div class="footer__social">
								
								<!-- social-icon -->
								<a class="social-icon" href="#"><i class="social-icon__icon fa fa-facebook"></i>
								</a><!-- End / social-icon -->
								
								
								<!-- social-icon -->
								<a class="social-icon" href="#"><i class="social-icon__icon fa fa-twitter"></i>
								</a><!-- End / social-icon -->
								
								
								<!-- social-icon -->
								<a class="social-icon" href="#"><i class="social-icon__icon fa fa-linkedin"></i>
								</a><!-- End / social-icon -->
								
								
								<!-- social-icon -->
								<a class="social-icon" href="#"><i class="social-icon__icon fa fa-behance"></i>
								</a><!-- End / social-icon -->
								
								
								<!-- social-icon -->
								<a class="social-icon" href="#"><i class="social-icon__icon fa fa-vimeo"></i>
								</a><!-- End / social-icon -->
								
							</div>
						</div>
					</div>
				</div>
			</div><!-- End / footer -->
			
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