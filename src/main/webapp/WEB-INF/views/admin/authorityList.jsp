<%--
subject    : 
author     : 남동길
date       : 2018. 6. 14.
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
    </script>
</head>
<body>
<div id="wrapper">

		<jsp:include page="/WEB-INF/views/admin/common/headerAndLeft.jsp"></jsp:include>

		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">권한 관리</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading">현재 관리자 리스트</div>
						<!-- /.panel-heading -->
						<div class="panel-body">
							<table class="table table-bordered">
								<tr>
									<th class="text-center">사용자 아이디</th>
									<th class="text-center">사용자 이름</th>
									<th class="text-center">사용자 권한</th>
									<th class="text-center">사용자 팀</th>
									<th class="text-center">사용자 이메일</th>
									<th colspan="2"></th>
								</tr>
							<c:forEach var="mgr" items="${employeeMgrList}" varStatus="status">
								<tr>
										<td class="text-center">${mgr.empId}</td>
										<td class="text-center">${mgr.empName}</td>
										<td class="text-center">${mgr.role}</td>
										<td class="text-center">${mgr.teamSeq}</td>
										<td class="text-center">${mgr.email }</td>
										<td colspan="2" class="text-center">
										<c:choose>
											<c:when test="${ mgr.empId eq 'sysmgr' }">
       											 시스템 관리자입니다.
    										</c:when>
    										<c:otherwise>
    										<form action="/changeEmpMgrToNormal.do" method="post" >
    											<div class="form-inline">
    											<input type="hidden" id="empId" name="empId" value="${mgr.empId }"/>
										        <input type="text" id="teamSeq" name="teamSeq" class="form-control" placeholder="배정하실 팀을 입력하세요."/>&nbsp;&nbsp;
										        <input type="submit" class="btn btn-danger" value="일반 회원">
										        <%-- id="manageBtn${status.index }" --%>
											</div>
											</form> 
										    </c:otherwise>

										</c:choose>
										</td>
									</tr>
							</c:forEach>
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
						<div class="panel-heading">회원 리스트</div>
						<!-- /.panel-heading -->
						<div class="panel-body">
						<div class="table-responsive">
							<table class="table table-bordered table-striped table-hover" id="dataTables-authority" data-order='[[ 0, "desc" ],[ 2, "asc" ]]' data-page-length='10'>
								<thead>
								<tr>
									<th class="text-center">사용자 아이디</th>
									<th class="text-center">사용자 이름</th>
									<th class="text-center">사용자 권한</th>
									<th class="text-center">사용자 팀</th>
									<th class="text-center">사용자 이메일</th>
									<th class="text-center">변경</th>
								</tr>
								</thead>
								<tbody>
							<c:forEach var="normal" items="${employeeNormalList}">
								<tr>
										<td class="text-center">${normal.empId}</td>
										<td class="text-center">${normal.empName}</td>
										<td class="text-center">${normal.role}</td>
										<td class="text-center">${normal.teamSeq}</td>
										<td class="text-center">${normal.email }</td>
										<td class="text-center"><a href="/changeEmpNormalToMgr.do?empId=${normal.empId }&role=M_MGR"
											class="btn btn-primary">회의실관리자</a> <a href="/changeEmpNormalToMgr.do?empId=${normal.empId }&role=E_MGR"
											class="btn btn-info">교육실관리자</a></td>
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
