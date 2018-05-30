<%@page import="board.model.BoardVo"%>
<%@page import="board.model.ReplyVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Main</title>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="css/dashboard.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

</head>
<body>
	<!--상단바  -->
				<%@ include file="/layout/header.jsp"%>
	<!--네비  -->
				<%@ include file="/layout/left.jsp"%>
	
	<!--본문-->
		<div class="container-fluid">
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
			<div class="table-responsive">
					<table class="table">
				<!--제목  -->
				<tr>
				<th>제목</th><td>${boardVo.board_title }</td>
				</tr>
				
				<!--작성자  -->
				<tr>
				<th>작성자</th><td>${boardVo.board_reg_id }</td>
				</tr>
				
				<!--작성일  -->
				<tr>
				<th>작성일</th><td>${boardVo.board_reg_dt }</td>
				</tr>
				
				<!--내용-->
				<tr>
				<th>내용</th><td>${boardVo.board_content }</td>
				</tr>
				
				<!--이미지-->
				<tr>
				<th>이미지</th><td></td>
				</tr>
				
				</table>
			</div>
				<div class="container">
					<%
					BoardVo boardVo = (BoardVo)request.getAttribute("boardVo");
					if(session.getAttribute("mem_id").equals(boardVo.getBoard_reg_id())){ 
					%>
					<table>
					<tr>
						<td>
							<form action="BoardtoBoard.do" method="get?board_seq=<%=boardVo.getBoard_seq()%>?option=update">
							<button class="btn btn-default" type="button">답글달기</button>
							</form>
						</td>
						<td>
							<form action="updateBoard.do" method="get?board_seq=<%=boardVo.getBoard_seq()%>?option=update">
							<button class="btn btn-default" type="button">글수정</button>
							</form>
						</td>
						<td>
							<form action="updateBoard.do" method="get?board_seq=<%=boardVo.getBoard_seq()%>?board_del=<%=boardVo.getBoard_del()%>">
							<button class="btn btn-default" type="submit">글삭제</button>
							</form>
						</td>
					</tr>
					
					</table>
					
					
					
					
					
					
					<% }%>
				</div>
			
				<hr>
				<div class="table-responsive">
					<table class="table table-hover">
						<%
						List<ReplyVo> list = (List<ReplyVo>)request.getAttribute("replyVoList");
						for(ReplyVo vo : list){
						%>
						<tr>
						<th>아이디: <%=vo.getReply_mem_id() %></td><br>
						<%if(vo.getReply_del().equals("del")){
							%>
							<th>내용  : 삭제된 댓글입니다.</td>
							<%
						}else{
							%>
							<th>내용  : <%=vo.getReply_content() %></td>
							<%
						}%>
						<th>작성일: <%=vo.getReply_date() %></td>
						<th></th>
						
						<%
						if(session.getAttribute("mem_id").equals(vo.getReply_mem_id())){
							if(vo.getReply_del().equals("yes")){
								
							
						%>
							<td><a href="replyDelete.do?reply_seq=<%=vo.getReply_seq() %>&board_seq=${boardVo.board_seq}&reply_del=<%=vo.getReply_del() %>">삭제</a></td>
										
						<%}else{
							%>
							<td><a href="replyDelete.do?reply_seq=<%=vo.getReply_seq() %>&board_seq=${boardVo.board_seq}&reply_del=<%=vo.getReply_del() %>">삭제취소</a></td>
							<%
						}
							
						}}//본인만 삭제가능 %>
						<tr>
					</table>
				</div>
				
				
				<!--리플 입력창  -->
				<div class="col-xs-4">
					<form action="insertReply.do" method="post">
						<input type="hidden" name="board_seq" value="${boardVo.board_seq}">
				    	<label for="reply_content">리플</label>
				    	<input class="form-control" id="reply_content" name="reply_content" type="text">
				    	<button class="btn btn-default" type="submit">댓글작성</button>
					</form>
			  	</div>
				
				
				<!--본문끝  -->
			</div>
		</div>
	<!--바깥 본문-->
</body>
</html>