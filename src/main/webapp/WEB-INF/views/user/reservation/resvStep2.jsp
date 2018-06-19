<%--
subject    : reservation.jsp
author     : 은종현
date       : 2018-06-11
description : 예약하기
 
  [이름]   [수정일]     [내용]
  ----------------------------------------------------------
  은종현	2018-06-11	 초안
--%>  
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
	<head>
		<title>예약하기</title>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
		<meta name="format-detection" content="telephone=no">
		<meta name="apple-mobile-web-app-capable" content="yes">
		<!-- BootStrap & CSS -->
		<link rel="stylesheet" type="text/css" href="/assets/css/bootstrap.css">
		<link rel="stylesheet" type="text/css" href="/assets/css/css_full/bootstrap.css">
		<link rel="stylesheet" type="text/css" href="/assets/css/css_full/font-awesome.css">
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
		<script type="text/javascript" src="/assets/vendors/jquery/jquery.min.js"></script>
		<script type="text/javascript">
			// this 클래스 btn-info => btn-default
			// 		  btn-default => btn-info
			var initNum = 0;
			var finNum = 0;
			var isFirst = true;
			var nowDay = new Date();
			$(document).ready(function(){
				var today = 10000*nowDay.getFullYear()+100*(nowDay.getMonth()+1)+nowDay.getDate();
				$('#today').val(today);
				$('.times').click(function(){
					var $this = $(this);
					var $btn = parseInt($this.attr('id'));
					if(isFirst){
						if($this.hasClass('disabled')){
							return;
						}else if($this.hasClass('btn-default')){
							$this.removeClass('btn-default');
							$this.addClass('btn-info');
						}else if($this.hasClass('btn-info')){
							$this.removeClass('btn-info');
							$this.addClass('btn-default');
						}
						initNum = $btn;
						isFirst = false;						
					} else if(initNum * finNum){
						isFirst = true;
						initNum = 0;
						finNum = 0;
						$('.times').removeClass('btn-info');
						$('.times').addClass('btn-default');
					} else{
						finNum = $btn;
						isFlag = true;
						for(var i=initNum; i<=finNum; i++){
							if($('#'+i).hasClass('disabled')) {
								isFlag = false;
							}
						}
						if(isFlag){
							for(var i=initNum; i<=finNum; i++){
								$('#'+i).removeClass('btn-default');
								$('#'+i).addClass('btn-info');
							}
							$('#startTime').val(initNum);
							$('#finTime').val(finNum);
						} else{
							alert('유효하지 않은 시간입니다.');
							isFlag = true;
						}
					}
				})
				$('.btn-roomType').click(function(){
					$('.btn-roomType').attr('class','btn btn-default btn-kdb btn-roomType');
					$('.onOffBox').addClass('displayNone');
					$(this).attr('class','btn btn-info btn-kdb btn-roomType');
					var $val = $(this).val(); 
					$('#roomType').val($val);
					if($val == 'M') {
						$('#mtRoomBox').attr('class','displayNone');
						$('#eduRoomBox').attr('class','displayNone');
						$('#mtRoomBox').attr('class','dispalyBlock');
					} else{
						$('#eduRoomBox').attr('class','displayNone');
						$('#mtRoomBox').attr('class','displayNone');
						$('#eduRoomBox').attr('class','dispalyBlock');
					}
				})
				
				// room name select
				$('.btn-roomName').click(function(){
					var $roomSeq = $(this).val();
					var $workSeq = $('#workSeq').val();
					var $roomType = $('#roomType').val();
					$('.btn-roomName').attr('class','btn btn-default btn-kdb btn-roomName');
					$('#timeButton').attr('class','displayNone onOffBox');
					// ajax
					$.ajax({
						type:"POST",
						url:"/resv/roomItemList.do",
						data:{
							"roomType" : $roomType,
							"roomSeq" : $roomSeq,
							"workSeq" : $workSeq,
						},
						dataType: "JSON",
						success: function(data) {
							
							$('.img-box-kdb').empty();
							$('.ajax-clean').html('');
							
							if($roomType == 'M'){
								$('.img-box-kdb').append('<img src="/getByteMtImage/'+data.roomInfo[0].mtSeq+'" />');
								$('#roomPrice').append('<p>30분 당 가격 : '+data.roomInfo[0].mtPrice+' 원</p>');
								$('#roomPrice').append('<p>하루 가격 : '+parseInt(data.roomInfo[0].mtPrice)*16+' 원</p>');
								$('#roomAvail').append(data.roomInfo[0].mtAvail);
								$('#maxCnt').val(data.roomInfo[0].mtAvail);
								$('#roomDescription').append(data.roomInfo[0].mtDescription);
							} else {
								$('.img-box-kdb').append('<img src="/getByteEduImage/"'+data.roomInfo[0].eduSeq+'" />');
								$('#roomPrice').append('<p>30분 당 가격 : '+data.roomInfo[0].eduPrice+' 원</p>');
								$('#roomPrice').append('<p>하루 가격 : '+parseInt(data.roomInfo[0].eduPrice)*16+' 원</p>');
								$('#roomAvail').append(data.roomInfo[0].eduAvail);
								$('#maxCnt').val(data.roomInfo[0].eduAvail);
								$('#roomDescription').append(data.roomInfo[0].eduDescription);
							}
							var beforeItem = '';
							var str = '';
							if(data.roomItemList.length != 0){
								for(var i=0; i<data.roomItemList.length; i++){
									var itemName = data.roomItemList[i].itemName;
									var itemSeq = data.roomItemList[i].itemSeq;
									var itemType = data.roomItemList[i].itemType;
									if(beforeItem != itemType){
										if(str != '') {
											$('#itemBox').append(str);
										}
										str = '<p>'+itemType+' : '+itemName+'<input type="checkbox" name="'+itemType+'" value="'+itemSeq+'" />';
										beforeItem = itemType;
									} else if(i+1 == data.roomItemList.length){
										str += '</p>';
										$('#itemBox').append(str);
									} else {
										str += ' '+itemName+'<input type="checkbox" name="'+itemType+'" value="'+itemSeq+'" />';
									}
									console.log(i+'. : '+itemSeq);
								}
							} else {
									$('#itemBox').append('<p>사용 가능한 비품이 없습니다.</p>');
							}
						}
			    });
					$('.btn-rsvType').attr('class','btn btn-default btn-kdb btn-rsvType');
					$(this).attr('class','btn btn-info btn-kdb btn-roomName');
					$('#roomSeq').val($roomSeq);
				})
				
				// reservation type select
				$('.btn-rsvType').click(function(){
					$('.btn-rsvType').attr('class','btn btn-default btn-kdb btn-rsvType');
					$(this).attr('class','btn btn-info btn-kdb btn-rsvType');
					var $val = $(this).val();
					$('#rsvType').val($val);
					if($val == 'S') {
						$('#timeButton').attr('class','displayNone onOffBox');
						$('#calendarButton').attr('class','displayNone onOffBox');
						$('#timeButton').attr('class','dispalyBlock onOffBox');
						$('.times').attr('class','times btn btn-default btn-kdb-times');
					} else{
						$('#timeButton').attr('class','displayNone onOffBox');
						$('#calendarButton').attr('class','displayNone onOffBox');
						$('#calendarButton').attr('class','dispalyBlock onOffBox');
					}
				})
				
				// date Select
				$('#selDate').on("change",function(){
					var $selDate = $(this).val();
					var $rsvType = $('#rsvType').val();
					var $roomSeq = $('#roomSeq').val();
					var currentDay = nowDay.getFullYear()+'-'+((nowDay.getMonth()+1<10?'0'+(nowDay.getMonth()+1):nowDay.getMonth()+1))+'-'+nowDay.getDate();
					$.ajax({
						type:"POST",
						url:"/resv/resvCheck.do",
						data:{
							"rsvType" : $rsvType,
							"selDate" : $selDate,
							"roomSeq" : $roomSeq
						},
						dataType: "JSON",
						success: function(data) {
							$('.times').attr('class','times btn btn-default btn-kdb-times');
							if(currentDay > $selDate){
								$('.times').addClass('disabled');
							} else if(currentDay == $selDate){
								var curTime = nowDay.getMinutes()<40?nowDay.getHours()*100+nowDay.getMinutes()+20:(nowDay.getHours()+1)*100+nowDay.getMinutes()-40;
								$('.times').each(function(){
									var $this = $(this);
									var $distime = parseInt($this.attr('id'));
									if(curTime>=$distime){
										$this.addClass('disabled');
									}
								})	
							}
							for(var i=0; data.resvList.length; i++){
								var iniDate = validTimeView(data.resvList[i].rsvDate,0);
								var finDate = validTimeView(data.resvList[i].rsvFdate,1);
								$('.times').each(function(idx){
									var $this = $(this);
									$timeNum = parseInt($this.attr('id'));
									if(iniDate<=$timeNum && finDate>=$timeNum){
										$this.removeClass('btn-default');
										$this.addClass('btn-danger');
									}
								})
							}
							
						}
			    });
				})
				// function
				function validTimeView(num,idx){
					var no = parseInt(num);
					var q = parseInt(no / 100);
					var x = no % 100;
					if(no==900 || no==2230) return no;
					if(!idx) {
						if(x==30){
							x = 0;
						} else {
							q = q-1;
							x = 30;
						}
					} else {
						if(x==0){
							x = 30;
						} else {
							q = q+1;
							x = 0;
						}
					}
					return 100*q+x;
				}
			})
			
			// prev page
			function fn_prev(){
				location.href = "/resv/resvStep1.do";
			}
		
			function fn_submitCheck(){
				var submitFlag = true;
				$('.valueValid').each(function(){
					var $this = $(this);
					if(!$this.val()){
						submitFlag = false;
					}
				})
				if(submitFlag) $('form').submit();
				else alert('정보를 모두 입력해주세요.');
			}
		</script>
		<style type="text/css">
			.btn-kdb{
				width:100%;
				height:40px;
				margin: 10px;
			}
			.awe-section{
				padding:40px;
			}
			.btn-kdb-times {
				width:70px;
			}
			.displayNone{
				display: none;
			}
			.displayBlock{
				display: block;
			}
		</style>
	</head>
	
	<body>
		<div class="page-wrap" id="root">
			
			<!-- header -->
				<jsp:include page="/WEB-INF/views/user/common/header.jsp" />
			<!-- End / header -->
			
			<form action="/resv/resvStep3.do" method="post">
			<!-- Content-->
			<div class="wil-content">
				
				<!-- Section -->
				<section class="awe-section">
					<div class="container">
						
						<!-- page-title -->
						<div class="page-title pb-40">
							<h2 class="page-title__title">예약하기</h2>
							<p class="page-title__text">예약하실 곳을 선택해 주세요.</p>
							<div class="page-title__divider"></div>
						</div><!-- End / page-title -->
						
					</div>
				</section>
				<!-- End / Section -->
				<section class="awe-section bg-gray">
					<div class="container">
						<table class="table text-center">
							<colgroup>
								<col width="20%"/>
								<col width="20%"/>
								<col width="10%"/>
								<col width="60%"/>
							</colgroup>
							<thead>
								<tr>
									<th>종류</th>
									<th>이름</th>
									<th>구분</th>
									<th>시간 선택</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>
										<button type="button" class="btn btn-default btn-kdb btn-roomType" value="M" >회의실</button><br>
										<button type="button" type="button" class="btn btn-default btn-kdb btn-roomType" value="E" >교육실</button><br>
									</td>
									<td id="roomList">
										<div id="mtRoomBox" class="displayNone onOffBox">
											<c:forEach var="mt" items="${mtList }">
												<button type="button" class="btn btn-default btn-kdb btn-roomName" data-toggle="modal" data-target="#roomInfo" value="${mt.mtCode}" >${mt.mtName }</button>
											</c:forEach>
										</div>
										<div id="eduRoomBox" class="displayNone onOffBox">
											<c:forEach var="ed" items="${eduList }">
												<button type="button" class="btn btn-default btn-kdb btn-roomName" data-toggle="modal" data-target="#roomInfo" value="${ed.eduCode}" >${ed.eduName }</button>
											</c:forEach>
										</div>
									</td>
									<td>
										<button type="button" class="btn btn-default btn-kdb btn-rsvType" value="S">단기 예약</button>
										<button type="button" class="btn btn-default btn-kdb btn-rsvType" value="L">장기 예약</button>
									</td>
									<td class="text-left" id="time">
										<div id="timeButton" class="displayNone onOffBox">
											<input type="date" name="selDate" id="selDate" />
											<c:forEach var="idx" begin="9" end="22" varStatus="vSts">
												<div class="times btn btn-default btn-kdb-times" id="${vSts.index*100}">${idx }:00</div>
												<div class="times btn btn-default btn-kdb-times" id="${vSts.index*100+30}">${idx }:30</div>
											</c:forEach>
										</div>
										<div id="calendarButton" class="displayNone onOffBox">
										</div>
									</td>
								</tr>
							</tbody>
						</table>
						<div class="pull-left ">
							<button type="button" class="btn btn-default btn-kdb" onclick="fn_prev();">이전</button>
						</div>
						<div class="pull-right">
								<input type="hidden" id="workSeq" name="workSeq" value="${workSeq }" />
								<input type="hidden" id="today" name="today" />
								<input type="hidden" id="roomType" name="roomType" class="valueValid" />
								<input type="hidden" id="roomSeq" name="roomSeq" class="valueValid" />
								<input type="hidden" id="rsvType" name="rsvType" class="valueValid" />
								<input type="hidden" id="startTime" name="startTime" class="valueValid" />
								<input type="hidden" id="finTime" name="finTime" class="valueValid" />
								<input type="hidden" id="maxCnt" name="maxCnt" class="valueValid" />
								<button type="button" class="btn btn-primary btn-kdb" onclick="javascript:fn_submitCheck()">다음</button>
						</div>
					</div>
				</section>
				
			</div>
			<!-- End / Content-->
			
			<!-- Item Stock Modal -->
			<div class="modal fade" id="roomInfo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog modal-lg">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">방 정보</h4>
					</div>
					<div class="modal-body">
						<div class="text-center img-box-kdb">
						</div>
						<table class="table table-hover">
							<tr>
								<td>방 가격</td>
								<td id="roomPrice" class="ajax-clean"></td>
							</tr>
							<tr>
								<td>최대 인원</td>
								<td id="roomAvail" class="ajax-clean" ></td>
							</tr>
							<tr>
								<td>기타 설명</td>
								<td id="roomDescription" class="ajax-clean"></td>
							</tr>
							<tr>
								<td>사용 가능 비품</td>
								<td id="itemBox" class="ajax-clean"></td>
							</tr>
						</table>
					</div>
					<div class="modal-footer form-inline">
						<table class="form-group">
							<tr>
								<td><div style="width: 20px;"></div></td>
								<th><button type="button" class="btn btn-success btn-kdb" data-dismiss="modal">확인</button></th>
								<td><div style="width: 10px;"></div></td>
							</tr>
						</table>
					</div>
				</div>
			</div>
		</div><!-- End / Modal -->
			</form>
			
			<!-- footer -->
				<jsp:include page="/WEB-INF/views/user/common/footer.jsp" />
			<!-- End / footer -->
			
		</div>
		<!-- Vendors-->
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