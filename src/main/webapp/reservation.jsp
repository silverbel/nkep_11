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
							<li><a href="blog.jsp">소개</a>
							</li>
							<li><a href="work.jsp">예약</a>
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
							<h2 class="page-title__title">예약하기</h2>
							<p class="page-title__text">예약하실 곳을 선택해 주세요.</p>
							<div class="page-title__divider"></div>
						</div><!-- End / page-title -->
						
					</div>
				</section>
				<!-- End / Section -->
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
									<!--<td rowspan="5">
										<table class="table table-striped">
											<caption>2018.06</caption>
											<thead>
												<tr>
													<th style="color:red;" width="30px">Sun</th>
													<th width="30px">Mon</th>
													<th width="30px">Tue</th>
													<th width="30px">Wed</th>
													<th width="30px">Thu</th>
													<th width="30px">Fri</th>
													<th style="color:blue;" width="30px">Sat</th>
												</tr>
											</thead>
											<tbody>
												<tr>
													<th style="color:red;"></th>
													<th></th>
													<th></th>
													<th></th>
													<th></th>
													<th>1</th>
													<th style="color:blue;">2</th>
												</tr>
												<tr>
													<th style="color:red;">3</th>
													<th>4</th>
													<th>5</th>
													<th class="btn-danger">6</th>
													<th>7</th>
													<th>8</th>
													<th style="color:blue;">9</th>
												</tr>
												<tr>
													<th style="color:red;">10</th>
													<th>11</th>
													<th class="btn-info">12</th>
													<th class="btn-info">13</th>
													<th class="btn-info">14</th>
													<th>15</th>
													<th style="color:blue;">16</th>
												</tr>
												<tr>
													<th style="color:red;">17</th>
													<th>18</th>
													<th>19</th>
													<th>20</th>
													<th>21</th>
													<th>22</th>
													<th style="color:blue;">23</th>
												</tr>
												<tr>
													<th style="color:red;">24</th>
													<th class="btn-danger">25</th>
													<th class="btn-danger">26</th>
													<th>27</th>
													<th>28</th>
													<th>29</th>
													<th style="color:blue;">30</th>
												</tr>
											</tbody>
										</table>
									</td>-->
									<td rowspan="5" class="text-left">
										<div class="btn btn-default disabled">09:00</div>
										<div class="btn btn-default disabled">09:30</div>
										<div class="btn btn-default disabled">10:00</div>
										<div class="btn btn-default disabled">10:30</div>
										<div class="btn btn-default disabled">11:00</div>
										<div class="btn btn-default disabled">11:30</div>
										<div class="btn btn-default disabled">12:00</div>
										<div class="btn btn-default disabled">12:30</div>
										<div class="btn btn-default ">13:00</div>
										<div class="btn btn-default ">13:30</div>
										<div class="btn btn-default ">14:00</div>
										<div class="btn btn-default ">14:30</div>
										<div class="btn btn-default ">15:00</div>
										<div class="btn btn-info ">15:30</div>
										<div class="btn btn-info">16:00</div>
										<div class="btn btn-info">16:30</div>
										<div class="btn btn-default ">17:00</div>
										<div class="btn btn-default ">17:30</div>
										<div class="btn btn-default ">18:00</div>
										<div class="btn btn-default ">18:30</div>
										<div class="btn btn-default ">19:00</div>
										<div class="btn btn-default ">19:30</div>
										<div class="btn btn-default ">20:00</div>
										<div class="btn btn-default ">20:30</div>
										<div class="btn btn-danger disabled">21:00</div>
										<div class="btn btn-danger disabled">21:30</div>
										<div class="btn btn-default ">22:00</div>
										<div class="btn btn-default ">22:30</div>
										<div class="btn btn-default ">23:00</div>
										<div class="btn btn-default ">23:30</div>
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
							<button class="btn btn-default btn-kdb">이전</button>
						</div>
						<div class="pull-right">
							<button class="btn btn-primary btn-kdb">다음</button>
						</div>
					</div>
				</section>
				
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