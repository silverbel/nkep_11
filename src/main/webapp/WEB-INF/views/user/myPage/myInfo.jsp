<%--
subject    : myInfo.jsp
author     : 김동범
date       : 2018. 6. 11.
description : my page, 나의 정보 확인
 
  [이름]   [수정일]     [내용]
  ----------------------------------------------------------
  김동범			2018.06.12	include 추가, 기본 레이아웃 수정
  김동범			2018.06.13	db연동, modal 적용
--%> 


<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
		<title>MY PAGE :: MY INFO</title>
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
		<link href="/assets/dist/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
		<!-- Custom fonts for this template -->
		<link href="/assets/dist/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
		<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
		<link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css">

		<!-- Plugin CSS -->
		<link href="/assets/dist/vendor/magnific-popup/magnific-popup.css" rel="stylesheet" type="text/css">

		<style type="text/css">
			.table-kdb td, .table-kdb th{
				font-size: 1.5em;
			}
			.btn-kdb {
				width:15%;
				height:3em;
				font-size: 2 em;
			}
		</style>
		
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
		<script src="https://code.highcharts.com/modules/drilldown.js"></script>
		<script type="text/javascript">
			$(document).ready(function(){
				var $num = comma(<c:out value="${team.budget}" />);
				
				$('#tBudget').html($num+' 원');
				
				function comma(num) {
					var len, point, str;

					num = num + "";
					point = num.length % 3;
					len = num.length;

					str = num.substring(0, point);
					while (point < len) {
						if (str != "")
							str += ",";
						str += num.substring(point, point + 3);
						point += 3;
					}
					return str;
				}
			})
		</script>
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
						<h2 class="page-title__title">${sessionID.empId }-
							${sessionID.empName }님</h2>
						<p class="page-title__text">회원 정보 보기</p>
						<div class="page-title__divider"></div>
					</div>
					<!-- End / page-title -->

				</div>
			</section>
			<!-- End / Section -->


			<!-- BlackList Section -->
			<section class="awe-section bg-gray">
				<div class="container">
					<h2>블랙리스트 내역</h2>
					<table class="table table-hover table-kdb">
						<colgroup>
							<col width="20%">
							<col width="30%">
							<col width="50%">
						</colgroup>
						<thead>
							<tr class="text-center">
								<th>번호</th>
								<th>날짜</th>
								<th>사유</th>
							</tr>
						</thead>
						<tbody>
							<c:if test="${0 eq blkCount }">
								<tr>
									<td colspan="3"><h2 class="text-center">블랙리스트 내역이
											없습니다.</h2></td>
								</tr>
							</c:if>
							<c:if test="${0 ne blkCount }">
								<c:forEach var="blk" items="${blkList }">
									<tr class="text-center">
										<td>${blk.blkSeq }</td>
										<td><c:out value="${blk.regDate}" /> ~ <c:out
												value="${blk.finDate}" /></td>
										<td>${blk.blkRes}</td>
									</tr>
								</c:forEach>
							</c:if>
						</tbody>
					</table>
				</div>
			</section>
			<!-- End / Section -->


			<!-- Team Section -->
			<section class="awe-section bg-gray">
				<div class="container">
					<h2>팀 정보</h2>
					<table class="table table-hover table-kdb">
						<colgroup>
							<col width="20%">
							<col width="20%">
							<col width="20%">
							<col width="20%">
							<col width="20%">
						</colgroup>
						<thead>
							<tr class="text-center">
								<th>팀 번호</th>
								<th>팀 이름</th>
								<th>팀장</th>
								<th>총 인원</th>
								<th>팀 예산</th>
							</tr>
						</thead>
						<tbody>
							<tr class="text-center" data-toggle="modal" data-target="#teamMember">
								<td>${team.teamSeq }</td>
								<td>${team.teamName }</td>
								<td>${team.bossId }</td>
								<td>${memCount}</td>
								<td id="tBudget"></td>
							</tr>
						</tbody>
					</table>
				</div>
			</section>
			<!-- End / Section -->

		</div>
		<!-- End / Content-->

		<!-- footer -->
			<jsp:include page="/WEB-INF/views/user/common/footer.jsp" />
		<!-- End / footer -->

	</div>

	<!-- Team Mate Modal -->
	<div class="modal fade" id="teamMember" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<h3 class="modal-title" id="myModalLabel">팀 정보</h3>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<table class="table table-hover table-kdb">
						<colgroup>
							<col width="15%" />
							<col width="15%" />
							<col width="40%" />
							<col width="30%" />
						</colgroup>
						<thead>
							<tr class="text-center">
								<th>ID</th>
								<th>이름</th>
								<th>EMAIL 주소</th>
								<th>블랙리스트</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="mem" items="${memList}">
								<tr class="text-center">
									<td>${mem.empId}</td>
									<td>${mem.empName}</td>
									<td>${mem.email}</td>
									<td>${mem.blackYn}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<div class="modal-footer">
					<button type="button" class="md-btn md-btn--outline-primary btn-kdb" data-dismiss="modal">닫기</button>
				</div>
			</div>
		</div>
	</div><!-- End / Modal -->
	
	<!-- Vendors-->
		<!-- Bootstrap Core Javascript -->
		<script type="text/javascript" src="/assets/vendors/jquery/jquery.min.js"></script>
		<script src="/assets/dist/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
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