<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="css/dashboard.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<%@ include file="/include/jquery.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>

</style>
</head>
<body>
<!--상단바  -->
				<%@ include file="/layout/header.jsp"%>
	<!--네비  -->
				<%@ include file="/layout/left.jsp"%>
	
	<!--본문-->
		<div class="container-fluid">
				<!-- 본문 -->
				<div class="container">
				<div>
					<h1>게시판 관리</h1>
				</div>
				<table id="pboardTable" class="table table-bordered">
					<tr>
						<th>게시판이름</th>
						<th>게시판생성일</th>
						<th>사용여부</th>
						<th>활성화선택</th>
					</tr>
					<c:forEach items="${pboardList }" var="pboardList">
						<tr>
							<td>${pboardList.pboard_name }</td>
							<td>${pboardList.pboard_date }</td>
							<td>${pboardList.pboard_del }</td>
							
							<td>
								<form action="deletePboard.do" method="get">
									<button type="submit"
										class="btn btn-primary btn-xs">비활성화</button><input type="hidden" value="${pboardList.pboard_seq }" name="pboard_seq" >
								</form>
							
								<form action="updatePboard.do" method="get">
									<button type="submit"
										class="btn btn-primary btn-xs">활성화</button><input type="hidden" value="${pboardList.pboard_seq }" name="pboard_seq" >
								</form>
							</td>
						</tr>
					</c:forEach>
				</table>
				
				<form action="createPboard.jsp" method="get">
					<button type="submit" class="btn btn-primary btn-xs">게시판 추가하기</button>
				</form>
				
				<!--본문끝  -->
		</div>
		</div>
	<!--바깥 본문-->


	

</body>
</html>