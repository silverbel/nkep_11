<%--
subject    : myInfo.jsp -> myReservation.jsp
author     : 김동범
date       : 2018. 6. 11.
description : my page, 나의 정보 확인
 
  [이름]   [수정일]     [내용]
  ----------------------------------------------------------
  김동범			2018.06.12	include 추가, 기본 레이아웃 수정
  김동범			2018.06.12	db 연동
  김동범			18.06.13		예약 내역 쿼리 수정 
  김동범			18.06.14		예약 내역 쿼리 완료 
  김동범			18.06.15		모달 적용 
  김동범			18.06.16		버그 수정 
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
		
		<!-- Datatables Mobile CSS -->	
		<link href="https://cdn.datatables.net/1.10.18/css/jquery.dataTables.min.css" rel="stylesheet">
		<link href="https://cdn.datatables.net/rowreorder/1.2.4/css/rowReorder.dataTables.min.css" rel="stylesheet">
		<link href="https://cdn.datatables.net/responsive/2.2.2/css/responsive.dataTables.min.css" rel="stylesheet">
		
		
		<!-- Datatables Mobile JS -->
		<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
		<script src="https://cdn.datatables.net/1.10.18/js/jquery.dataTables.min.js"></script>
		<script src="https://cdn.datatables.net/rowreorder/1.2.4/js/dataTables.rowReorder.min.js"></script>
		<script src="https://cdn.datatables.net/responsive/2.2.2/js/dataTables.responsive.min.js"></script>

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
				$('.rsvSeqCheck').click(function(){
					$this = $(this);
					var seq = $this.find('.seq').html();
					$.ajax({
						type:"POST",
						url:"/myPage/showResvAllInfo.do",
						data:{
							"rsvSeq" : seq
						},
						dataType: "JSON",
						success: function(data) {
							
							$('#resvTable').empty();
							var rsvSeq = data.rcInfo.rsvSeq;
							var bossYn = data.rcInfo.bossYn;
							var mgrYn = data.rcInfo.mgrYn;
							var rsvDate = data.rcInfo.rsvDate;
							var rsvFdate = data.rcInfo.rsvFdate;
							var roomName = data.rcInfo.roomName;
							var applicant = data.rcInfo.applicant;
							var rsvPrice = data.rcInfo.rsvPrice;
							var reject = data.rcInfo.reject;
							var confirm = '';
							var isConfirm = true;
							if(mgrYn == 'Y'){
								confirm = '승인 완료';
							} else if(bossYn=='Y'){
								confirm = '1차 승인 완료';
							} else confirm = '승인 대기';
							
							// 승인 거절
							if(mgrYn=='N' || bossYn=='N') {
								confirm = "승인 거절";
								isConfirm = false;
							}
							
							$('#resvTable').append('<thead>'
															+'<tr class="text-center">'
																+'<th colspan="2" id="resrvSeq">'+rsvSeq+'</th>'
															+'</tr>'
														+'</thead>'
														+'<tbody>'
															+'<tr>'
																+'<td>신청자</td>'
																+'<td>'+applicant+'</td>'
															+'</tr>'
															+'<tr>'
																+'<td>대여 시설</td>'
																+'<td>'+roomName+'</td>'
															+'</tr>'
															+'<tr>'
																+'<td>신청기간</td>'
																+'<td>'+rsvDate+' ~ '+rsvFdate+'</td>'
															+'</tr>'
															+'<tr>'
																+'<td>비용</td>'
																+'<td>'+rsvPrice+'원</td>'
															+'</tr>'
															+'<tr>'
																+'<td>승인 상태</td>'
																+'<td>'+confirm+'</td>'
															+'</tr>');
							if(!isConfirm){
								$('#resvTable').append('<tr><td>반려 사유</td><td>'+reject+'</td></tr>');
							}
							$('#resvTable').append('<tr><td>사용 비품</td><td id="itemList"></td></tr></tbody>');
							for(var i=0; i<data.riList.length; i++){
								var itemName = data.riList[i].itemName;
								var itemCnt = data.riList[i].itemCnt;
								$('#itemList').append('<p>'+itemName+' : '+itemCnt+'개</p>')
							}
							
							$('#ruListTbody').empty();
							for(i=0; i<data.ruList.length; i++){
								var useId = data.ruList[i].useId;
								var empName = data.ruList[i].empName;
								var email= data.ruList[i].email;
								var teamName= data.ruList[i].teamName;
								var appl = '';
								if(data.ruList[i].applYn == 'Y'){
									appl = '신청자';
								}
								$('#ruListTbody').append("<tr><td>"+teamName+"</td><td>"
										+useId+"</td><td>"+empName+"</td><td>"+email+"</td><td>"+appl+"</td></tr>");
							}
						}
			    });

				})
			})
		</script>
		<script>
			function fn_delete(url) {
				location.href="/myPage/deleteMyResv.do?rsvSeq="
						+encodeURIComponent(url);
			}
		</script>
		<script type="text/javascript">
			$(document).ready(function($){
				$(document).ready(function(){
					var table = $('#resvInfoList-table').DataTable( {
		        rowReorder: {
		            selector: 'td:nth-child(2)'
		        },
		        responsive: true,
		        paging : true,
						ordering: false,
						bAutoWidth: false,
						bPaginate : false,
						bFilter : false,
						bInfo : false,
						dom: 'Bfrtip'
			    } );
					var table2 = $('#usedList-table').DataTable( {
		        rowReorder: {
		            selector: 'td:nth-child(2)'
		        },
		        responsive: true,
		        paging : true,
						ordering: false,
						bAutoWidth: false,
						bPaginate : false,
						bFilter : false,
						bInfo : false,
						dom: 'Bfrtip'
			    } );
					
					var $num = comma(<c:out value="${rcList.get(0).rsvPrice}" />);
					
					$('#rsvBudget').html($num+' 원');
					
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
			})
		</script>
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
				<section class="awe-section kdb-title">
					<div class="container">
						<!-- page-title -->
						<div class="page-title pb-40">
							<h2 class="page-title__title">${sessionID.empId }-
								${sessionID.empName}님</h2>
							<p class="page-title__text">예약 및 사용 정보 보기</p>
							<div class="page-title__divider"></div>
						</div>
						<!-- End / page-title -->
	
					</div>
				</section>
				<!-- End / Section -->
	
	
				<!-- Reservation Section -->
				<section class="awe-section bg-gray">
					<div class="container">
						<h2>예약 내역</h2>
						<table class="table table-hover table-kdb display nowrap" id="resvInfoList-table" style="width:100%">
							<colgroup>
								<col width="20%">
								<col width="30%">
								<col width="10%">
								<col width="10%">
								<col width="20%">
								<col width="10%">
							</colgroup>
							<thead>
								<tr class="text-center">
									<th>번호</th>
									<th>장소</th>
									<th>신청자</th>
									<th>비용</th>
									<th>승인 여부</th>
									<th></th>
								</tr>
							</thead>
							<tbody>
								<c:if test="${0 eq resvCnt }">
									<tr>
										<td colspan="5">
											<h2 class="text-center">예약 내역이 없습니다.</h2>
										</td>
									</tr>
								</c:if>
								<c:if test="${0 ne resvCnt }">
									<c:forEach var="rc" items="${rcList }">
										<tr class="text-center rsvSeqCheck" data-toggle="modal" data-target="#myResvInfo">
											<td class="seq">${rc.rsvSeq}</td>
											<td>${rc.roomName}</td>
											<td>${rc.applicant}</td>
											<td id="rsvBudget"></td>
											<td>
												<c:if test="${'Y' eq rc.mgrYn}">
													승인 완료
												</c:if>
												<c:if test="${'N' eq rc.mgrYn}">
													승인 거절
												</c:if>
												<c:if test="${null eq rc.mgrYn}">
													승인 대기
												</c:if>
											</td>
											<td>
												<a class="md-btn md-btn--outline-primary" href="javascript:fn_delete('${rc.rsvSeq}');">Cancle</a>
											</td>
										</tr>
									</c:forEach>
								</c:if>
							</tbody>
						</table>
					</div>
				</section>
				<!-- End / Section -->
	
	
				<!-- Used Section -->
				<section class="awe-section bg-gray">
					<div class="container">
						<h2>사용 내역</h2>
						<table class="table table-hover table-kdb display nowrap" id="usedList-table" style="width:100%">
							<colgroup>
								<col width="30%">
								<col width="30%">
								<col width="20%">
								<col width="20%">
							</colgroup>
							<thead>
								<tr class="text-center">
									<th>사용 번호</th>
									<th>장소</th>
									<th>사용 인원</th>
									<th>비용</th>
								</tr>
							</thead>
							<tbody>
									<tr>
										<th colspan="4">사용 내역이 없습니다.</th>
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
	
		<!-- Resveration Modal -->
		<div class="modal fade" id="myResvInfo" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog modal-lg">
				<div class="modal-content">
					<div class="modal-header">
						<h3 class="modal-title" id="myModalLabel">예약 상세 정보</h3>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<h2></h2>
						<table class="table table-hover table-kdb" id="resvTable">
							<colgroup>
								<col width="20%" />
								<col width="80%" />
							</colgroup>
						</table>
						<br>
						<h2>참석자 명단</h2>
						<table class="table table-hover table-kdb">
							<colgroup>
								<col width="10%" />
								<col width="20%" />
								<col width="20%" />
								<col width="30%" />
								<col width="20%" />
							</colgroup>
							<thead>
								<tr class="text-center">
									<th>팀</th>
									<th>ID</th>
									<th>이름</th>
									<th>EMAIL 주소</th>
									<th>신청자</th>
								</tr>
							</thead>
							<tbody id="ruListTbody">
							</tbody>
						</table>
						<table class="table table-hover">
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