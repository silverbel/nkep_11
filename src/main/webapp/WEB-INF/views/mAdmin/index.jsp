<%--
subject    : 
author     : 남동길
date       : 2018. 6. 11.
description :
 
  [이름]   [수정일]     [내용]
  ----------------------------------------------------------
  은종현	2018-06-21 	index 페이지에 공지사항 및 예약하기 적용.
  
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
    <link href="../vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

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
					var table = $('#notice-board').DataTable( {
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
	        $("#createBtn").on("click", function() {
						action ='createNotice';
						type='POST';
						$("#modal-title").text("새 공지 사항 작성");
						$("#myModal").modal();
					});
		    });
			});
    	function fn_go() {
    		location.href = "/resv/resvStep1.do";
    	}
    </script>
    <script type="text/javascript">
    	$(document).ready(function($){
    		var action = '';
			var url = '';
			var type = '';
			var noticeNo=0;
			
			// insert
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

        <jsp:include page="/WEB-INF/views/mAdmin/common/headerAndLeft.jsp" />

        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">MeetingRoom MANAGEMENT</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading">
							<a href="javascript:fn_go()"
											class="btn btn-info">예약 하기</a>
						</div>
						<!-- /.panel-heading -->
						<div class="panel-body">
						<div class="table-responsive">
							<table class="table table-bordered table-striped table-hover display nowrap" style="width: 100%" 
							id="notice-board" data-order='[[ 0, "desc" ],[ 2, "asc" ]]' data-page-length='10'>
								<thead>
								<tr>
									<th class="text-center" width="50%">공지 사항</th>
									<th class="text-center" width="20%">등록일자</th>
								</tr>
								</thead>
								<tbody>
							<c:forEach var="list" items="${noticeList}" varStatus="status">
								<tr data-toggle="modal" data-target="#noticeDetail">
										<td class="text-center">${list.noticeTitle}</td>
										<td class="text-center">${list.regDate}</td>
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
		
        </div>
        <!-- /#page-wrapper -->
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

    </div>
    <!-- /#wrapper -->

    <!-- jQuery -->
    <script src="../vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="../vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="../vendor/metisMenu/metisMenu.min.js"></script>

    <!-- Morris Charts JavaScript -->
    <script src="../vendor/raphael/raphael.min.js"></script>
    <script src="../vendor/morrisjs/morris.min.js"></script>
    <script src="../data/morris-data.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="../dist/js/sb-admin-2.js"></script>

</body>

</html>
