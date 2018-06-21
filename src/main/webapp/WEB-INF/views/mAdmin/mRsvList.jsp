<%--
subject    : mRsvList.jsp
author     : 은종현
date       : 2018. 6. 20.
description :
 
  [이름]   [수정일]     [내용]
  ----------------------------------------------------------
  
--%> 
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>회의실 예약 관리</title>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <!-- DataTable CSS -->
    <link href="/dist/css/dataTables.bootstrap.css" rel="stylesheet">
	<!-- tabletools -->
	<link href="/dist/css/dataTables.tableTools.css" rel="stylesheet" />
	<!-- DataTables JavaScript -->
	
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="/dist/js/jquery.dataTables.js"></script>
    <script src="/dist/js/dataTables.bootstrap.js"></script>
    <script src="/dist/js/dataTables.responsive.js"></script>
		<script src="/dist/js/responsive.bootstrap.js"></script>
		<!-- tabletools -->
		<script src="/dist/js/dataTables.tableTools.js"></script>
	  
		<!-- Bootstrap Core CSS -->
		<link href="../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
		
		<!-- MetisMenu CSS -->
		<link href="../vendor/metisMenu/metisMenu.min.css" rel="stylesheet">
		
		<!-- Custom CSS -->
		<link href="../dist/css/sb-admin-2.css" rel="stylesheet">
		
		<!-- Morris Charts CSS -->
		<link href="../vendor/morrisjs/morris.css" rel="stylesheet">
		
		<!-- Custom Fonts -->
		<link href="../vendor/font-awesome/css/font-awesome.min.css"
			rel="stylesheet" type="text/css">
			
		<!-- Datatables Mobile CSS -->	
		<link href="https://cdn.datatables.net/1.10.18/css/jquery.dataTables.min.css" rel="stylesheet">
		<link href="https://cdn.datatables.net/rowreorder/1.2.4/css/rowReorder.dataTables.min.css" rel="stylesheet">
		<link href="https://cdn.datatables.net/responsive/2.2.2/css/responsive.dataTables.min.css" rel="stylesheet">
		
		
		<!-- Datatables Mobile JS -->
		<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
		<script src="https://cdn.datatables.net/1.10.18/js/jquery.dataTables.min.js"></script>
		<script src="https://cdn.datatables.net/rowreorder/1.2.4/js/dataTables.rowReorder.min.js"></script>
		<script src="https://cdn.datatables.net/responsive/2.2.2/js/dataTables.responsive.min.js"></script>
    <script>
			$(document).ready(function($) {
				$(document).ready(function() {
					$('#dataTables-mtRoom').DataTable({
		    			rowReorder: {
		    				selector: 'td:nth-child(2)'
		    			},
		    			responsive: true
					});
					$('#dataTables-mtRoom-cancel').DataTable({
		    			rowReorder: {
		    				selector: 'td:nth-child(2)'
		    			},
		    			responsive: true,
		    			ordering: true,
		    			"bAutoWidth": true,
		    			"columnDefs": [
		    				{ "orderable": false, "targets": 0 }
							] 
					});
					$('.btn-info').click(function(){
						console.log('!!');
						console.log($(this).val());
						location.href = '/mtRoomRsvConfirm.do?rsvSeq='+$(this).val();
					})
					$('.btn-danger').click(function(){
						location.href = '/mtRoomRsvReject.do?rsvSeq='+$(this).val();
					})
		    });
	    });
    	function fn_go_list(url) {
    		location.href = "/deleteNotice.do?noticeNo="+url;
    	}
    </script>
</head>
<body>
<div id="wrapper">

		<jsp:include page="/WEB-INF/views/mAdmin/common/headerAndLeft.jsp"></jsp:include>

		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">예약 관리</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			
			<!-- /.row -->
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading">회의실 예약 관리</div></div>
						<!-- /.panel-heading -->
						<div class="panel-body">
							<div class="table-responsive">
								<table class="table table-bordered table-striped table-hover nowrap display" style="width:100%" 
									id="dataTables-mtRoom" data-order='[[ 0, "desc" ],[ 2, "asc" ]]' data-page-length='10'>
									<colgroup>
										<col width="20%">
										<col width="30%">
										<col width="20%">
										<col width="10%">
										<col width="20%">
									</colgroup>
									<thead>
									<tr>
										<th class="text-center">예약번호</th>
										<th class="text-center">장소</th>
										<th class="text-center">신청자</th>
										<th class="text-center">가격</th>
										<th class="text-center">승인 처리</th>
									</tr>
									</thead>
									<tbody>
								<c:forEach var="list" items="${mtRoomRsvList}" varStatus="status">
									<tr>
											<td class="text-center">${list.rsvSeq}</td>
											<td class="text-center">${list.roomName}</td>
											<td class="text-center">${list.applicant}</td>
											<td class="text-center">${list.rsvPrice} 원</td>
											<td>
												<c:if test="${'Y' ne list.mgrYn }">
														<button type="button" class="btn btn-info" style="width: 50%" value="${list.rsvSeq }">승인</button>
														<button type="button" class="btn btn-danger" style="width: 50%" value="${list.rsvSeq }">반려</button>
												</c:if>
												<c:if test="${'Y' eq list.mgrYn }">
													승인 완료
												</c:if>
											</td>
									</tr>
								</c:forEach>
								</tbody>
								</table>
							</div>
						<!-- /.panel-body -->
					</div>
					<!-- /.panel -->
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
			
			<!-- /.row -->
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading">반려된 예약 리스트</div></div>
						<!-- /.panel-heading -->
						<div class="panel-body">
						<div class="table-responsive">
							<table class="table table-bordered table-striped table-hover nowrap display" style="width:100%" 
								id="dataTables-mtRoom-cancel" data-order='[[ 0, "desc" ],[ 2, "asc" ]]' data-page-length='10'>
								<colgroup>
									<col width="20%">
									<col width="30%">
									<col width="20%">
									<col width="30%">
								</colgroup>
								<thead>
								<tr>
									<th class="text-center">예약번호</th>
									<th class="text-center">장소</th>
									<th class="text-center">신청자</th>
									<th class="text-center">가격</th>
								</tr>
								</thead>
								<tbody>
							<c:forEach var="list" items="${mtRoomRsvRejectList}" varStatus="status">
								<tr>
										<td class="text-center">${list.rsvSeq}</td>
										<td class="text-center">${list.roomName}</td>
										<td class="text-center">${list.applicant}</td>
										<td class="text-center">${list.rsvPrice} 원</td>
								</tr>
							</c:forEach>
							</tbody>
							</table>
						</div>
						<!-- /.panel-body -->
					</div>
					<!-- /.panel -->
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
		</div>
		<!-- /#page-wrapper -->
		</div>
	<!-- /#wrapper -->

	<!-- jQuery -->
	<script src="../vendor/jquery/jquery.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="../vendor/bootstrap/js/bootstrap.min.js"></script>

	<!-- Metis Menu Plugin JavaScript -->
	<script src="../vendor/metisMenu/metisMenu.min.js"></script>

	<!-- Flot Charts JavaScript -->
	<script src="../vendor/flot/excanvas.min.js"></script>
	<script src="../vendor/flot/jquery.flot.js"></script>
	<script src="../vendor/flot/jquery.flot.pie.js"></script>
	<script src="../vendor/flot/jquery.flot.resize.js"></script>
	<script src="../vendor/flot/jquery.flot.time.js"></script>
	<script src="../vendor/flot-tooltip/jquery.flot.tooltip.min.js"></script>
	<script src="../data/flot-data.js"></script>

	<!-- Custom Theme JavaScript -->
	<script src="../dist/js/sb-admin-2.js"></script>

</body>

</html>
