<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<meta name="format-detection" content="telephone=no">
<meta name="apple-mobile-web-app-capable" content="yes">

<title>관리자 PAGE :: 자재 상세 보기</title>

<!-- BootStrap & CSS -->
<link rel="stylesheet" type="text/css" href="/assets/css/bootstrap.css">
<link rel="stylesheet" type="text/css"
	href="/assets/css/css_full/bootstrap.css">
<link rel="stylesheet" type="text/css"
	href="/assets/css/css_full/font-awesome.css">
<!-- Fonts-->
<link rel="stylesheet" type="text/css"
	href="/assets/fonts/fontawesome/font-awesome.min.css">
<link rel="stylesheet" type="text/css"
	href="/assets/fonts/pe-icon/pe-icon.css">
<!-- Vendors-->
<link rel="stylesheet" type="text/css"
	href="/assets/vendors/bootstrap/grid.css">
<link rel="stylesheet" type="text/css"
	href="/assets/vendors/magnific-popup/magnific-popup.min.css">
<link rel="stylesheet" type="text/css"
	href="/assets/vendors/swiper/swiper.css">
<!-- App & fonts-->
<link rel="stylesheet" type="text/css"
	href="https://fonts.googleapis.com/css?family=Montserrat:300,400,500,600,700|Open+Sans:400,700">
<link rel="stylesheet" type="text/css" id="app-stylesheet"
	href="/assets/css/main.css">
<!--[if lt IE 9]>
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
<script type="text/javascript"
	src="/assets/vendors/jquery/jquery.min.js"></script>
<!-- data table -->
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.10.18/css/jquery.dataTables.css">
<script type="text/javascript" charset="utf8"
	src="https://cdn.datatables.net/1.10.18/js/jquery.dataTables.js"></script>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
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

</head>
<body>

	<div id="wrapper">

		<c:if test="${'S_MGR' eq sessionID.role}">
			<jsp:include page="/WEB-INF/views/admin/common/headerAndLeft.jsp"></jsp:include>
		</c:if>
		<c:if test="${'E_MGR' eq sessionID.role}">
			<jsp:include page="/WEB-INF/views/eAdmin/common/headerAndLeft.jsp"></jsp:include>
		</c:if>
		<c:if test="${'M_MGR' eq sessionID.role}">
			<jsp:include page="/WEB-INF/views/mAdmin/common/headerAndLeft.jsp"></jsp:include>
		</c:if>
		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">자재 상세정보</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
			<div class="container">
				<div class="row">
					<div class="col-lg-12">
						<div class="panel panel-default">
							<div class="panel-heading">자재 정보</div>
							<!-- /.panel-heading -->
							<div class="panel-body">
								<div class="container">
									<div class="row">
										<div class="col-lg-12">
											<h3>${itemDTO.itemName }</h3>
										</div>
									</div>
									<br>
									<div class="col-lg-12">
										<div class="col-md-4 text-center">
											<c:if test="${itemDTO.itemImg eq null }">
												<img src="/assets/img/nono.png"
													class="img-responsive img-thumbnail" />
											</c:if>
											<c:if test="${itemDTO.itemImg ne null }">
												<img
													src=<c:url value="/getByteItemImage/${itemDTO.itemSeq}"/>
													class="img-responsive img-thumbnail" />
											</c:if>
										</div>
										<div class="col-md-4 text-center">
											<c:if test="${itemDTO.itemImg2 ne null }">
												<img
													src=<c:url value="/getByteItemImage2/${itemDTO.itemSeq}"/>
													class="img-responsive img-thumbnail" />
											</c:if>
										</div>
										<div class="col-md-4 text-center">
											<c:if test="${itemDTO.itemImg3 ne null }">
												<img
													src=<c:url value="/getByteItemImage3/${itemDTO.itemSeq}"/>
													class="img-responsive img-thumbnail" />
											</c:if>
										</div>
									</div>
									<br> <br>
									<div class="row col-xs-12 text-center">
										<table class="table">
											<colgroup>
												<col width="30%">
												<col width="70%">
											</colgroup>
											<tr>
												<td>근무지 이름 :</td>
												<td><c:out value="${itemDTO.workName }" /></td>
											</tr>
											<tr>
												<td>자재 수량 :</td>
												<td><c:out value="${itemDTO.stCnt }" /></td>
											</tr>
											<tr>
												<td>자재 종류 :</td>
												<td><c:out value="${itemDTO.itemType }" /></td>
											</tr>
											<tr>
												<td>가격 :</td>
												<td><c:out
														value="${itemDTO.itemPrice} 원  / ${itemDTO.itemUnit }" /></td>
											</tr>
											<tr>
												<td>상세 정보 :</td>
												<td><c:out value="${itemDTO.itemDescription }" /></td>
											</tr>
										</table>
									</div>



									<div class="row text-right">
										<a href="/getItemListForAdmin.do" class="btn btn-default">목록</a>
										<a class="btn btn-primary"
											href="/modifyItemForAdminForm.do?itemSeq=${itemDTO.itemSeq }&workSeq=${itemDTO.workSeq}">수정</a>
										<a href="/getItemListForAdmin.do" class="btn btn-danger">삭제</a>
									</div>
								</div>
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
	<!-- iOS에서는 position:fixed 버그가 있음, 적용하는 사이트에 맞게 position:absolute 등을 이용하여 top,left값 조정 필요 -->
	<div id="layer"
		style="display: none; position: fixed; overflow: hidden; z-index: 1; -webkit-overflow-scrolling: touch;">
		<img
			src="//t1.daumcdn.net/localimg/localimages/07/postcode/320/close.png"
			id="btnCloseLayer"
			style="cursor: pointer; position: absolute; right: -3px; top: -3px; z-index: 1; width: 5%; height: auto;"
			onclick="closeDaumPostcode()" alt="닫기 버튼">
	</div>
	<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
	<script>
		// 우편번호 찾기 화면을 넣을 element
		var element_layer = document.getElementById('layer');
		function closeDaumPostcode() {
			// iframe을 넣은 element를 안보이게 한다.
			element_layer.style.display = 'none';
		}
		function sample2_execDaumPostcode() {
			new daum.Postcode(
					{
						oncomplete : function(data) {
							// 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
							// 각 주소의 노출 규칙에 따라 주소를 조합한다.
							// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
							var fullAddr = data.address; // 최종 주소 변수
							var extraAddr = ''; // 조합형 주소 변수
							// 기본 주소가 도로명 타입일때 조합한다.
							if (data.addressType === 'R') {
								//법정동명이 있을 경우 추가한다.
								if (data.bname !== '') {
									extraAddr += data.bname;
								}
								// 건물명이 있을 경우 추가한다.
								if (data.buildingName !== '') {
									extraAddr += (extraAddr !== '' ? ', '
											+ data.buildingName
											: data.buildingName);
								}
								// 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
								fullAddr += (extraAddr !== '' ? ' ('
										+ extraAddr + ')' : '');
							}
							// 우편번호와 주소 정보를 해당 필드에 넣는다.
							document.getElementById('sample2_postcode').value = data.zonecode; //5자리 새우편번호 사용
							document.getElementById('sample2_address').value = fullAddr;
							// iframe을 넣은 element를 안보이게 한다.
							// (autoClose:false 기능을 이용한다면, 아래 코드를 제거해야 화면에서 사라지지 않는다.)
							closeDaumPostcode();
						},
						width : '100%',
						height : '100%',
						maxSuggestItems : 5
					}).embed(element_layer);
			// iframe을 넣은 element를 보이게 한다.
			element_layer.style.display = 'block';
			// iframe을 넣은 element의 위치를 화면의 가운데로 이동시킨다.
			initLayerPosition();
		}
		// 브라우저의 크기 변경에 따라 레이어를 가운데로 이동시키고자 하실때에는
		// resize이벤트나, orientationchange이벤트를 이용하여 값이 변경될때마다 아래 함수를 실행 시켜 주시거나,
		// 직접 element_layer의 top,left값을 수정해 주시면 됩니다.
		function initLayerPosition() {
			var width = 300; //우편번호서비스가 들어갈 element의 width
			var height = 400; //우편번호서비스가 들어갈 element의 height
			var borderWidth = 5; //샘플에서 사용하는 border의 두께
			// 위에서 선언한 값들을 실제 element에 넣는다.
			element_layer.style.width = width + 'px';
			element_layer.style.height = height + 'px';
			element_layer.style.border = borderWidth + 'px solid';
			// 실행되는 순간의 화면 너비와 높이 값을 가져와서 중앙에 뜰 수 있도록 위치를 계산한다.
			element_layer.style.left = (((window.innerWidth || document.documentElement.clientWidth) - width) / 2 - borderWidth)
					+ 'px';
			element_layer.style.top = (((window.innerHeight || document.documentElement.clientHeight) - height) / 2 - borderWidth)
					+ 'px';
		}
	</script>
</body>

</html>
