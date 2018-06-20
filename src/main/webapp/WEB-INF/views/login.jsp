<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<%--
subject    : 
author     : 김동범
date       : 2018. 6. 11.
description : 로그인 화면
 
  [이름]   [수정일]     [내용]
  ----------------------------------------------------------
  
--%> 

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>로그인</title>
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
		<link rel="stylesheet" type="text/css" href="/style.css">
		<style type="text/css">
			.tableSetting{
				margin: 20px;
				margin-bottom: 0;
			}
			h1 {
				font-size: 2em;
				font-weight: bolder;
			}
			.tableSetting tr td:first-child {
				width: 70px;
				height: 70px;
			}
			tr td:nth-child(2n) {
				text-align: left;
				padding: 0 0 0 10px;
				width: 330px;
			}
			th {
				border-top: 1px solid black;
			}
			#twinBtnContainer>.btn {
				padding: 0 20px;
			}
			#loginBtn {
				height: 100px;
			}
			#fieldSet {
				height: 340px;
				padding-bottom: 0;
			}
			#containerCenter {
				padding: 50px;
				margin-top: -250px;
				margin-left: -350px;
				border-radius: 30px 0 50px 0;
				box-shadow: 0px 0px 100px #A9E2F3;
			}
			.twinBtn {
				margin: 25px 25px;
			}
			img {
				position: absolute;
				top: 50px;
				right: 50px;
				width: 15%;
			}
		</style>
	</head>
	<body>
			<div id="containerCenter">
				<img src="/logoM.png">
				<h1>회의실 예약관리 시스템</h1>
					<div>
						<form action="/login.do" method="post" >
							<table class="tableSetting table">
								<colgroup>
									<col width="30%">
									<col width="70%">
								</colgroup>
								<tr>
									<td><label for="idInput"><strong>사번</strong></label></td>
									<td>
										<select id="idInput" name="idInput" class="form-control">
											<option value="1">IT1053</option>
											<option value="2">회의실 관리자</option>
											<option value="3">시스템 관리자</option>
										</select>
									</td>
									<td rowspan="2"><button class="btn" id="loginBtn"><h1>로그인</h1></button></td>
								</tr>
								<tr>
									<td><label for="pwInput"><strong>비밀번호</strong></label></td>
									<td><input type="password" id="pwInput" name="passwordInput" class="form-control" ></td>
								</tr>
							</table>
						</form>
					</div>
			</div>
	</body>
</html>