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
	var mtSeq = null;
	var j = 0;
	$(document).ready(function(){
		$('.panel-body').on('click', '.deleteBtn', function() {
			console.log($(this).prev().val());
			mtSeq = $(this).prev().val();
			$('#deleteA').attr('href','/deleteMtRoomForAdmin.do?mtSeq='+mtSeq);
			mtSeq = null;
		});
		/*$('.deleteBtn').click(function(){
			console.log($(this).prev().val());
			mtSeq = $(this).prev().val();
			$('#deleteA').attr('href','/deleteMtRoomForAdmin.do?mtSeq='+mtSeq);
			mtSeq = null;
		});*/
		$('#workSelect').on('change',function(){
			alert($(this).val());
			if($(this).val() == 'total'){
				location.href="http://localhost:9090/meetingRoomList.do";				
			}else{
				$.ajax(
						{	type : 'GET'
							,url: "/getMtRoomByWorkSeq.do?workSeq="+$(this).val()
							, success: function(result){
								console.log(result);
					$(".panel-body").children().remove();
					if(result.length > 0){
						for(var i  = 0 ; i<result.length; i++){
							console.log(result[i]);
							if(i == 0 || i % 3 == 0){
								j = i;
								$(".panel-body").append("<div class='row' id=row"+j+">");
							}
							console.log(result[i].mtName);
							$("#row"+j).append('<div class="col-xs-6 col-md-4 text-center" id="result'+i+'">')
							$("#result"+i).append('<img src="/getByteMeetingRoomImage/'+result[i].mtSeq+'" class="img-responsive img-thumbnail" /><br>');
							$("#result"+i).append('<h3><a href="#">'+result[i].mtName+'</a></h3');
							$("#result"+i).append('회의실 크기 :	'+result[i].mtSize+' 평	<br> ');
							$("#result"+i).append('회의실 가격 :	'+result[i].mtPrice+' 원 / 30분	<br><br>');
							$("#result"+i).append('<a href="/modifyMeetingRoomForAdminForm.do?mtSeq='+result[i].mtSeq +'" class="btn btn-default">수정</a>&nbsp;&nbsp;	<input type="text" id="mtSeq" value="'+result[i].mtSeq +'" hidden="hidden"/>');
							$("#result"+i).append('<button class="btn btn-danger deleteBtn" data-toggle="modal" data-target="#myModal" id="deleteBtn">삭제</button>');
							$("#row"+j).append('</div>')
							if(i== 0 || i%3 ==0){
								$(".panel-body").append($("</div><br>"));
							}
						}
						
					}else{
						
					} 
		            
		            
		       		 									}
						}
						);
			}

		});
	});

</script>
</head>

<body>
<!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">회의실 삭제</h4>
        </div>
        <div class="modal-body">
          <h2>정말 삭제하시겠습니까??</h2>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
          <a href="" id="deleteA"><button type="button" class="btn btn-danger">삭제</button></a>
        </div>
      </div>
      
    </div>
  </div>
	<div id="wrapper">

		<jsp:include page="/WEB-INF/views/mAdmin/common/headerAndLeft.jsp"></jsp:include>

		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">회의실 관리</h1>
					<select id="workSelect" class="form-control">
						<option value="total">전체</option> 
						<c:forEach var="workspace" items="${workSpaceList }">
							<option value="${workspace.workSeq }<%-- /${workspace.workCode } --%>">${workspace.workName }</option>
						</c:forEach>
					</select>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<br>
			<!-- /.row -->
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading">회의실 리스트</div>
						<!-- /.panel-heading -->
						<div class="panel-body">
							<c:forEach var="mtRoom" items="${meetRoomList}"
								varStatus="status">
								<c:if test="${status.index == 0  || status.index % 3 == 0 }">
									<c:out value="<div class='row'>" escapeXml="false"/>
								</c:if>
								<div class="col-xs-6 col-md-4 text-center">
									 <img
										src=<c:url value="/getByteMeetingRoomImage/${mtRoom.mtSeq}"/>
										 class="img-responsive img-thumbnail" />
									<br>
									<h3>
										<a
											href="/showMtRoomDetailForAdmin.do?mtSeq=${mtRoom.mtSeq}">
											<c:out value="${mtRoom.mtName}" />
										</a>
									</h3>
									회의실 크기 :
									<c:out value="${mtRoom.mtSize}" /> 평
									<br> 회의실 가격 :
									<c:out value="${mtRoom.mtPrice}" />원 / 30분
									<br>
									<br> <a href="/modifyMeetingRoomForAdminForm.do?mtSeq=${mtRoom.mtSeq }" class="btn btn-default">수정</a>&nbsp;&nbsp;
									<input type="text" id="mtSeq" value="${mtRoom.mtSeq }" hidden="hidden"/>
									<button class="btn btn-danger deleteBtn" data-toggle="modal" data-target="#myModal" id="deleteBtn">삭제</button>
								</div>
								<c:if test="${ status.index % 2 == 0 && status.index != 0 }">
									<c:out value="</div><br>" escapeXml="false" />
								</c:if>
							</c:forEach>
						</div>
						<!-- /.panel-body -->
					</div>
					<div class="col-lg-12 text-right">
						<a href="/newMeetingRoomForAdminForm.do" class="btn btn-default">회의실 추가</a>
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
