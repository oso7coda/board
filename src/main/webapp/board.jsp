<%@page import="board.model.BoardVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="css/dashboard.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
	$(function() {
		//$('#pboard_btn').on('click', function(){		
		//})

	})
</script>
</head>
<body>

	<!--상단바  -->
	<%@ include file="/layout/header.jsp"%>
	<!--네비  -->
	<%@ include file="/layout/left.jsp"%>

	<!--본문-->
	<div class="container-fluid">
		<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
			<!-- 본문 -->
			<div class="container">
				<table class="table">
					<thead>
						<tr>
							<th>번호</th>
							<th>제목</th>
							<th>작성자</th>
							<th>작성일</th>
							<th>조횟수</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
					
					<%
				
					List<BoardVo> list = null;
					if(request.getAttribute("boardList")!=null){
						list = (List<BoardVo>)request.getAttribute("boardList");
							
						int totalRecodeSize = list.size();
							int recodeSizeperPage = 10;
							int pageSizePerBlock =3;
							int curBlock = 0;
						
							if(request.getAttribute("curBlock")!=null){
								curBlock = Integer.parseInt(request.getAttribute("curBlock").toString());
							}
							
							int curPage = curBlock*pageSizePerBlock;
							if(request.getAttribute("curPage")!=null){
								curPage = Integer.parseInt(request.getAttribute("curPage").toString());
							}
							int beginNum = curPage*recodeSizeperPage;
						
							int pageSize = (int)Math.ceil((double)totalRecodeSize/recodeSizeperPage);
							
						for(int i=beginNum ; i <beginNum+recodeSizeperPage ; i ++){
							if(totalRecodeSize<=i) break;
							
							BoardVo boardvo = list.get(i);
					%>
							<tr>
								<td><%=boardvo.getBoard_seq() %></td>
								<td><a class="btn-link" href="readBoard.do?board_seq=<%=boardvo.getBoard_seq() %>">
								<%if(boardvo.getBoard_group()>0){
									for(int j =beginNum; j<boardvo.getBoard_group(); j++){
								%>
									&nbsp;&nbsp;&nbsp;&nbsp;
								<%	}//nbsp for end%>
									└답글:
								<%}// group if end%>
								
								<%=boardvo.getBoard_title() %></a></td>
								<td><%=boardvo.getBoard_reg_id() %></td>
								<td><%=boardvo.getBoard_reg_dt() %></td>
								<td><%=boardvo.getBoard_hit() %></td>
								<%if(boardvo.getBoard_reg_id().equals((session.getAttribute("mem_id")))){ %>
								<td><a href="boardDelete.do?board_seq=<%=boardvo.getBoard_seq() %>">삭제</a></td>
								<%}//본인만 삭제가능 %>
							</tr>
					<%
						}//end of for
						int startPage =	curBlock*pageSizePerBlock;
						int endPage = startPage+pageSizePerBlock;
						%>
						</table>
						<hr>
						<%
						if(curBlock > 0){
						out.print("<hr>");
						
						%>
						<ul class="pagination">
						<li><a href="board.do?curBlock=0">◁◁</a></li>
						<li><a href="board.do?curBlock=<%=curBlock-1%>">◁</a></li>
						</ul>
						<%
						}
						
						
						for(int i = startPage; i<endPage ; i++){
							if(pageSize <=i)break;
						%>
							<ul class="pagination">
							<li><a class="" href="board.do?curBlock=<%=curBlock%>&curPage=<%=i%>"><%=i %></a></li>
							</ul>
						<%
						}//end for
						
						if(curBlock < pageSize/pageSizePerBlock){
						%>
						<%int finalPage = (list.size()+(pageSize-1))/pageSize; %>
						<ul class="pagination">
						<li><a href="board.do?curBlock=<%=curBlock+1%>">▷</a></li>
						<li><a href="board.do?curBlock=2">▷▷</a></li>
						</ul><%
								
						}
					}//end of if
					
					
					%>
					
			
				
			</div>
			<form action="set_qboard_seq.do" method="get">
			<input type="hidden" name="pboard_seq" value="${pboard_seq}">
			<button type="submit" >글쓰기</button>
			</form>
			
			<!--본문끝  -->
		</div>
	</div>
	<!--바깥 본문-->


</body>
</html>