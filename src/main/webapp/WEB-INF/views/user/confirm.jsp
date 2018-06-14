<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width" />
	
	<!-- For development, pass document through inliner -->
	
	<link rel="stylesheet" type="text/css" href="assets/css/bootstrap.css">
	<link rel="stylesheet" type="text/css"
		href="assets/css/css_full/bootstrap.css">
	<link rel="stylesheet" type="text/css"
		href="assets/css/css_full/font-awesome.css">
	<!-- Fonts-->
	<link rel="stylesheet" type="text/css"
		href="assets/fonts/fontawesome/font-awesome.min.css">
	<link rel="stylesheet" type="text/css"
		href="assets/fonts/pe-icon/pe-icon.css">
	<!-- Vendors-->
	<link rel="stylesheet" type="text/css"
		href="assets/vendors/bootstrap/grid.css">
	<link rel="stylesheet" type="text/css"
		href="assets/vendors/magnific-popup/magnific-popup.min.css">
	<link rel="stylesheet" type="text/css"
		href="assets/vendors/swiper/swiper.css">
	<!-- App & fonts-->
	<link rel="stylesheet" type="text/css"
		href="https://fonts.googleapis.com/css?family=Montserrat:300,400,500,600,700|Open+Sans:400,700">
	<link rel="stylesheet" type="text/css" id="app-stylesheet"
		href="assets/css/main.css">
	
	<style type="text/css">
	img {
		width: 50%;
	}
	/* Your custom styles go here */
	* {
		margin: 0;
		padding: 0;
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
	
	body, .body-wrap {
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
	
	.container {
		display: block !important;
		clear: both !important;
		margin: 0 auto !important;
		max-width: 580px !important;
	}
	
	.container table {
		width: 100% !important;
		border-collapse: collapse;
	}
	
	.container .masthead {
		padding: 80px 0;
		background: #3DB7CC;
		color: white;
	}
	
	.container .masthead h1 {
		margin: 0 auto !important;
		max-width: 90%;
		text-transform: uppercase;
	}
	
	.container .content {
		background: white;
		padding: 30px 35px;
	}
	
	.container .content.footer {
		background: none;
	}
	
	.container .content.footer p {
		margin-bottom: 0;
		color: #888;
		text-align: center;
		font-size: 14px;
	}
	
	.container .content.footer a {
		color: #888;
		text-decoration: none;
		font-weight: bold;
	}
	
	.container .content.footer a:hover {
		text-decoration: underline;
	}
	</style>
	
	</head>
	<body>
		<table class="body-wrap">
			<tr>
				<td class="container">
					<!-- Message start -->
					<table>
						<tr>
							<td align="center" class="masthead">
								<h1 style="color:white;">예약 완료!</h1>
							</td>
						</tr>
						<tr>
							<td>
								<img src="assets/img/gsitm.jpg" />
							</td>
						</tr>
						<tr>
							<td class="content"><img src="assets/img/works/discuss.jpg" /> <br>
								<h2 class="text-center">회의실 예약 정보</h2>
	
								<table class="table">
									<thead>
										<tr>
											<th colspan="2" class="text-center">총 금액 : 18,000원</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<th>근무지</th>
											<td>보헌 빌딩</td>
										</tr>
										<tr>
											<th>종류</th>
											<td>회의실</td>
										</tr>
										<tr>
											<th>이름</th>
											<td>미팅룸 1</td>
										</tr>
										<tr>
											<th>사용 유형</th>
											<td>단기 예약</td>
										</tr>
										<tr>
											<th>사용 시간</th>
											<td>2018.06.05 15:30 ~ 2018.06.05 16:30</td>
										</tr>
										<tr>
											<th>사용 비훔</th>
											<td>마우스 : 3개 3,000원</td>
										</tr>
									</tbody>
									<tfoot>
										<tr>
											<th>비용 계산</th>
											<td>7,500원 * 2 + 3,000원 = <strong>18,000 원</strong></td>
										</tr>
									</tfoot>
								</table>
	
								<table>
									<tr>
										<td align="center">
											<button class="btn btn-primary form-control" >확인</button>
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td class="container">
					<!-- Message start -->
					<table>
						<tr>
							<td class="content footer" align="center">
								<p>
									Sent by <a href="#">GS ITM</a>, 서울특별시 종로구 계동 84
								</p>
								<p>
									<a href="mailto:">gsitm@gsitm.com</a> | <a href="#">Unsubscribe</a>
								</p>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</body>
</html>