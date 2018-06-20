<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<%--
subject    : 
author     : 김동범
date       : 2018. 6. 20.
description :
 
  [이름]   [수정일]     [내용]
  ----------------------------------------------------------
  
--%> 

		<style>
    td, th {
      border-width: 0px;
      height: 60px;
      width:60px;
      font-size: 16px;
      text-align:center;
    }
    .date{
    	border-radius: 10px;
    	cursor: pointer;
    	user-drag: none; 
			user-select: none;
			-moz-user-select: none;
			-webkit-user-drag: none;
			-webkit-user-select: none;
			-ms-user-select: none;	
    }
    .header {
      font-size: 24px;
      font-weight: bold;
    }
    .sun {
      color: red;
    }
    .sat {
      color: blue;
    }
    button {
      font-size: 26px;
      cursor: pointer;
      border-width: 0px;
      background-color: white;
    }
    .kdb-disabled{
			color: #999;
			cursor: not-allowed;
			opacity:.65;
			user-drag: none; 
			user-select: none;
			-moz-user-select: none;
			-webkit-user-drag: none;
			-webkit-user-select: none;
			-ms-user-select: none;
		}
		.kdb-resv{
			color: #FFF;
			background-color:#d9534f;
			cursor: not-allowed;
			user-drag: none; 
			user-select: none;
			-moz-user-select: none;
			-webkit-user-drag: none;
			-webkit-user-select: none;
			-ms-user-select: none;
		}
		.kdb-select{
			color:#FFF;
			background-color: #31b0d5;
		}
  </style>
  <script type="text/javascript">
      
  </script>
	<table class="table">
    <tr>
      <th class='header'><button type="button" id="prev">&lt;</button></th>
      <th class='header' colspan="5" id="selMonth"><span id="year"></span>-<span id="mon"></span></th>
      <th class='header'><button type="button" id="next">&gt;</button></th>
    </tr>
    <tr>
      <th class='sun'>일</th>
      <th class='week'>월</th>
      <th class='week'>화</th>
      <th class='week'>수</th>
      <th class='week'>목</th>
      <th class='week'>금</th>
      <th class='sat'>토</th>
    </tr>
    <c:forEach begin="0" end="6">
	    <tr>
	      <td class='sun calCell'></td>
	      <td class='week calCell'></td>
	      <td class='week calCell'></td>
	      <td class='week calCell'></td>
	      <td class='week calCell'></td>
	      <td class='week calCell'></td>
	      <td class='sat calCell'></td>
	    </tr>
    </c:forEach>
  </table>
