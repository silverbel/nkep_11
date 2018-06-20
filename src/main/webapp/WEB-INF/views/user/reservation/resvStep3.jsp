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
		<!-- data table -->
		<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.18/css/jquery.dataTables.css">
		<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.18/js/jquery.dataTables.js"></script>
		<script type="text/javascript">
			var count = 1;
			var MAXCNT = ${insertResv.maxCnt}
			var $emp;
			$(document).ready(function() {
				$emp = $('#empId');
				$('#empListTable').DataTable({         
					pageLength : 5,
					responsive : {
						breakpoints:[
							{name:'empId', width:1250},
							{name:'empName', width:1000},
							{name:'teamName', width:750},
							{name:'email', width:500},
							{name:'blackYn', width:250}
						]
					},
					bLengthChange : false,
					ordering : true,
					searching : true,
					paging : true,
					ajax : {
					"url" : "/resv/allMemberListAjax.do",
					"type" : "POST",
					"dataSrc" : 'empList'
					},
					columns : [
						{data : "empId"},
						{data : "empName"},
						{data : "teamName"},
						{data : "email"},
						{data : "blackYn"}
					]
 				});
				$('#empListTable tbody').on('click','tr',function(){
					if(count <= MAXCNT){
						var val = $('#empListTable').DataTable().row(this).data();
						if(val.blackYn != 'Y'){
							var str = $emp.val();
							if(str.match(val.empId)){
								alert('이미 추가한 사원입니다.');
								return;
							}
							str += val.empId + '/';
							$emp.val(str);
							
							$('#attendList').append('<tr id="'+val.empId+'"><td>'+val.empId+'</td><td>'+val.empName+'</td><td>'+val.teamName+'</td><td>'+val.email+'</td><td>'
							+'<button type="button" class="btn btn-info form-control" onclick="javascript:fn_deleteBtn(\''+val.empId+'\')" >삭제</button></td></tr>');
							count++;
						} else alert('해당 사원은 블랙리스트입니다.');
					} else{
						alert('해당 시설의 최대 인원 수를 넘었습니다.');
					}
				})
			})
			function fn_prev(){
				location.href = "/resv/resvStep2.do?workSeq="+${insertResv.workSeq};
			}
			function fn_deleteBtn(value){
				var str = $emp.val();
				console.log(value);
				console.log(str);
				str = str.replace(value+'/', '');
				console.log(str);
				$emp.val(str);
				count--;
				$('#'+value).remove();
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
			#empListTable tbody tr:hover {
				cursor: pointer;
				background-color: rgba(100,200,255,0.2);
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
							<p class="page-title__text">회의에 참석할 인원을 선택해 주세요.</p>
							<div class="page-title__divider"></div>
						</div><!-- End / page-title -->
						
					</div>
				</section>
				<!-- End / Section -->
				<section class="awe-section bg-gray">
					<div class="container">
						<div class="table-responsive-lg">
							<table class="table table-hover" id="empListTable">
								<thead>
									<tr>
										<td>사번</td>
										<td>이름</td>
										<td>소속</td>
										<td>이메일</td>
										<td>블랙리스트 여부</td>
									</tr>
								</thead>
							</table>
						</div>
						<div class="table-responsive-lg">
							<table class="table table-hover">
								<thead>
									<tr>
										<td>사번</td>
										<td>이름</td>
										<td>소속</td>
										<td>이메일</td>
										<td>삭제</td>
									</tr>
								</thead>
								<tbody id="attendList">
								</tbody>
							</table>
						</div>
						<div class="pull-left ">
							<button class="btn btn-default btn-kdb" onclick="fn_prev();">이전</button>
						</div>
						<div class="pull-right">
							<form action="/resv/resvStep4.do" method="post">
								<input type="hidden" name="empId" id="empId" value="" />
								<button class="btn btn-primary btn-kdb">다음</button>
							</form>
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