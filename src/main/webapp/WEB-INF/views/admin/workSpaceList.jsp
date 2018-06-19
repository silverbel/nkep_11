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
	var workSeq = null;
	var workName = null;
	var fTime = null;
	$(document).ready(function(){
		$('.deleteBtn').click(function(){
			workSeq = $(this).prev().val();
			console.log(workSeq);
			workName = $(this).prevAll().eq(5).children().text();
			$.ajax(
					{	type : 'GET'
						,url: "/getResvFTime.do?workSeq="+workSeq
						, success: function(result){
				$(".modal-body").children('h3').empty();
				if(result ==''){
					$(".modal-body").children('h3').append(workName+"에 <br>예약된 회의실이나 교육실이 없습니다.<br> 즉시 삭제가 가능합니다.");
					fTime = result;
		            $('#deleteA').attr('href','/deleteWorkSapceForAdmin.do?workSeq='+workSeq);
					console.log('fTime : '+fTime);
				}else{
					result = result.substring(0,19);
					$(".modal-body").children('h3').append("정말 삭제하시겠습니까??<br><h5>"+workName+"의 최종 예약시간은 : <strong style='font-size:18px;'>"+result+"</strong></h5><br><h4>삭제버튼을 누르시면 최종예약시간 <strong>1분</strong>뒤에 근무지가 삭제 됩니다.</h4>");
					fTime = result;
		            $('#deleteA').attr('href','/deleteWorkSapceForAdmin.do?workSeq='+workSeq+'&fTime='+fTime);
					console.log('fTime : '+fTime);
				}
	            
	            
	       		 									}
					}
					);
			
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
          <h4 class="modal-title">근무지 삭제</h4>
        </div>
        <div class="modal-body">
          <h3></h3>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
          <a href="" id="deleteA"><button type="button" class="btn btn-danger">삭제</button></a>
        </div>
      </div>
      
    </div>
  </div>
	<div id="wrapper">

		<jsp:include page="/WEB-INF/views/admin/common/headerAndLeft.jsp"></jsp:include>

		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">근무지 관리</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading">근무지 리스트</div>
						<!-- /.panel-heading -->
						<div class="panel-body">
							<c:forEach var="workspace" items="${workSpaceList}"
								varStatus="status">
								<c:if test="${status.index == 0  || status.index % 3 == 0 }">
									<c:out value="<div class='row'>"  escapeXml="false" />
								</c:if>
								<div class="col-xs-6 col-md-4 text-center">
									 <img
										src=<c:url value="/getByteWorkSpaceImage/${workspace.workSeq}"/>
										class="img-responsive img-thumbnail" />
									<br>
									<h3>
										<a style="text-decoration:none;"
											href="/showWorkSpaceDetailForAdmin.do?workSeq=${workspace.workSeq }">
											<c:out value="${workspace.workName}" />
										</a>
									</h3>
									주소 :
									<c:out value="${workspace.workAddr}" />
									<br> 전화번호 :
									<c:out value="${workspace.workTel}" />
									<br>
									<c:forEach var="log" items="${logs }">
										<c:if test="${workspace.workSeq eq log.workSeq }">
											<strong><c:out value="${ log.deleteTime}"/>에 삭제될 예정입니다.</strong><br>
										</c:if>
									</c:forEach>
									<a href="/modifyWorkSpaceForAdminForm.do?workSeq=${workspace.workSeq }" class="btn btn-default">수정</a>&nbsp;&nbsp;
									<input type="text" id="workSeq" value="${workspace.workSeq }" hidden="hidden"/>
									<button class="btn btn-danger deleteBtn" data-toggle="modal" data-target="#myModal" id="deleteBtn">삭제</button>
								</div>
								<c:if test="${ status.index % 2 == 0 && status.index != 0 }">
									<c:out value="</div>"  escapeXml="false" />
								</c:if>
							</c:forEach>
						</div>
						<!-- /.panel-body -->
					</div>
					<div class="col-lg-12 text-right">
						<a href="/newWorkSpaceForAdminForm.do" class="btn btn-default">근무지 추가</a>
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
