<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%--
subject    : educationRoomModify.jsp
author     : 남동길
date       : 2018. 6. 11.
description :
 
  [이름]   [수정일]     [내용]
  ----------------------------------------------------------
  
--%> 


<html lang="ko">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>SB Admin 2 - Bootstrap Admin Theme</title>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	var sel_files = [];
	$(document).ready(function() {
		$('#input_imgs').on("change",handleImgsFilesSelect);
		 $("#changeFlag").change(function(){
		        if($("#changeFlag").is(":checked")){
		            $('#input_imgs').attr("disabled", true);
		        }else{
		            $('#input_imgs').attr("disabled", false);
		        }
		    });
	});
	function handleImgsFilesSelect(e) {
		sel_files = [];
		$('.imgs_wrap').empty();
		var files = e.target.files;
		var filesArr = Array.prototype.slice.call(files);

		var index = 0;
		filesArr.forEach(function(f) {
			if(!f.type.match("image.*")){
				alert("확장자는 이미지 확장자만 가능합니다.");
				return;
			}

			sel_files.push(f);

			var reader = new FileReader();
			reader.onload = function(e) {
				var html = "<a href=\"javascript:void(0);\" onclick=\"deleteImageAction("+index+")\" id=\"img_id_"+index+"\"><img src=\"" + e.target.result +"\" data-file='"+f.name+"' class='selProductFile' title='Click to remove' width=200px height=200px></a>";
				/* var img_html = "<img src=\"" + e.target.result + "\" width=200px height=200px />";
				$(".imgs_wrap").append(img_html); */
				$(".imgs_wrap").append(html);
				index++;
			}
			reader.readAsDataURL(f);
			
		});
	}
	
	function deleteImageAction(index){
		console.log("index : "+index);
		sel_files.splice(index, 1);
		if(sel_files.length === 0){
			$('.imgs_wrap').empty();
		}
		var img_id = "#img_id_" + index;
		$(img_id).remove();
		
		console.log(sel_files);


	}

</script>
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

		
	<jsp:include page="/WEB-INF/views/admin/common/headerAndLeft.jsp"></jsp:include>

		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">교육실 관리</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading">교육실 리스트</div>
						<!-- /.panel-heading -->
						<div class="panel-body">
							<div class="container">
								<form action="modifyEducationRoomForAdmin.do?eduSeq=${educationRoomDTO.eduSeq }"
									enctype="multipart/form-data" method="post">
									<div class="row">
										<div class="col-25">
											<label for="workName">근무지</label>
										</div>
										<div class="col-75">
											<input type="text" id="workName" name="workName" value="${educationRoomPlusWSNameDTO.workName }" class="form-control" readonly/>
										</div>
									</div>
									<br>
									<br>
									<div class="row">
										<div class="col-25">
											<label for="eduName">교육실 이름</label>
										</div>
										<div class="col-75 form-inline text-left">
											<input type="text" class="form-control" name="eduName" id="eduName" value="${educationRoomPlusWSNameDTO.eduName}"/>
										</div>
									</div>
									<br>
									<div class="row">
										<div class="col-25">
											<label for="eduAvail">교육실 인원수</label>
										</div>
										<div class="col-75 form-inline text-left">
											<input type="text" class="form-control" name="eduAvail" id="eduAvail" value="${educationRoomPlusWSNameDTO.eduAvail}"/>
										</div>
									</div>
									<br>
									<div class="row">
										<div class="col-25">
											<label for="eduSize">교육실 크기</label>
										</div>
										<div class="col-75 form-inline text-left">
											<input type="text" class="form-control" name="eduSize" id="eduSize" value="${educationRoomPlusWSNameDTO.eduSize}"/>
										</div>
									</div>
									<br>
									<div class="row">
										<div class="col-25">
											<label for="eduPrice">교육실 가격</label>
										</div>
										<div class="col-75 form-inline text-left">
											<input type="text" class="form-control" name="eduPrice" id="eduPrice" value="${educationRoomPlusWSNameDTO.eduPrice}"/>
										</div>
									</div>
									<br>
									<div class="row">
										사진 삭제여부 : <input type="checkbox" name="changeFlag" id="changeFlag" value="changeFlag" />
										<br><br>
										<div class="col-25">
											<label for="pic">교육실 사진</label>
										</div>
										<div class="col-75">
											<div>
												<input type="file" id="input_imgs" multiple name="files[]"
													maxlength="3" />
											</div>
											<div>
												<div class="imgs_wrap"></div>
											</div>
										</div>
									</div>
									<br>
									<br>
									<div class="row">
										<div class="col-25">
											<label for="eduDescription">교육실 설명</label>
										</div>
										<div class="col-75">
											<textarea id="eduDescription" name="eduDescription"
												placeholder="Write something.." style="height: 200px"
												class="form-control">${educationRoomPlusWSNameDTO.eduDescription}</textarea>
										</div>
									</div>
									<br>
									<div class="row text-right">
										<input class="btn btn-primary" type="submit" value="수정">
										<a href="/showEduRoomDetailForAdmin.do?eduSeq=${ educationRoomPlusWSNameDTO.eduSeq}" class="btn btn-default">상세보기</a>
										<a href="/educationRoomList.do" class="btn btn-default">목록</a>
									</div>
								</form>
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
