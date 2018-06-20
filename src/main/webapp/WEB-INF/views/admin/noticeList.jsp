<%--
subject    : 
author     : 은종현
date       : 2018. 6. 17.
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
<title>SB Admin 2 - Bootstrap Admin Theme</title>
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


<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <script>
	    $(document).ready(function($) {
			$(document).ready(function() {
		        $('#dataTables-authority').DataTable({
		             responsive: true
		            ,ordering: true
		            ,"bAutoWidth": true
	                ,"columnDefs": [
	                               { "orderable": false, "targets": 0 }
	                             ] 
		        });
		    });
		});
    	function fn_go_list(url) {
    		location.href = "/deleteNotice.do?noticeNo="+url;
    	}
    </script>
    <script type="text/javascript">
    	$(document).ready(function($){
    		var action = '';
			var url = '';
			var type = '';
			var noticeNo=0;
			
			// insert
			$(document).on("click", function(){
				$("#createBtn").on("click", function() {
					action ='createNotice';
					type='POST';
					$("#modal-title").text("새 공지 사항 작성");
					$("#myModal").modal();
				});
			});
			
			$("#modalSubmit").on("click", function() {
				if(action=='create') {
					url = 'noticeList.do';
				}
				
				var data = {
					"noticeTitle" : $("#noticeTitle").val(),
					"noticeContent" : $("#noticeContent").val()
				};
				$.ajax({
					url :url,
					type : type,
					data : data
				})
				
				location.reload();
			});
    	});
    </script>
</head>
<body>
<div id="wrapper">

		<jsp:include page="/WEB-INF/views/admin/common/headerAndLeft.jsp"></jsp:include>

		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">공지사항 관리</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			
			<!-- /.row -->
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading">NOTICE</div>
						<!-- /.panel-heading -->
						<div class="panel-body">
						<div class="table-responsive">
							<table class="table table-bordered table-striped table-hover" id="dataTables-authority" data-order='[[ 0, "desc" ],[ 2, "asc" ]]' data-page-length='10'>
								<thead>
								<tr>
									<th class="text-center" width="50%">공지 사항</th>
									<th class="text-center" width="20%">등록일자</th>
									<th class="text-center" width="20%"></th>
								</tr>
								</thead>
								<tbody>
							<c:forEach var="list" items="${noticeList}" varStatus="status">
								<tr data-toggle="modal" data-target="#noticeDetail">
										<td class="text-center">${list.noticeTitle}</td>
										<td class="text-center">${list.regDate}</td>
										<td class="text-center"><a href="javascript:fn_go_list('${list.noticeNo}')"
											class="btn btn-danger">삭제</a></td>
								</tr>
							</c:forEach>
							</tbody>
							</table>
							<button id="createBtn" type="button" class="btn btn-info btn-sm" data-toggle="modal" data-target="#myModal">공지 사항 작성</button>
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
		<!-- Modal -->
	<div class="modal fade" id="noticeDetail" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<h3 class="modal-title" id="myModalLabel">NOTICE</h3>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<h4>${noticeList.get(0).noticeContent}</h4>
				</div>
			</div>
		</div>
	</div><!-- End / Modal -->
	<!-- Modal -->
	<div class="modal fade" id="myModal" role="dialog">
		<div class="modal-dialog">
	
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 id="modal-title" class="modal-title"></h4>
				</div>
				<div class="modal-body">
					<table class="table">
						<tr>
							<td>제목</td>
							<td><input class="form-control" id="noticeTitle" type="text"></td>
						</tr>
						<tr>
							<td>내용</td>
							<td><textarea class="form-control" id="noticeContent" rows="10"></textarea></td>
						</tr>					
					</table>
				</div>
				<div class="modal-footer">
					<button id="modalSubmit" type="button" class="btn btn-success">Submit</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>
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
