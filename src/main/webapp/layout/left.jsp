<%@page import="java.util.List"%>
<%@page import="board.service.BoardService"%>
<%@page import="board.service.BoardServiceInf"%>
<%@page import="board.model.PboardVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <div id="navbar navbar-default"  class="col-sm-3 col-md-2 sidebar">
 	<div class="container-fluid">
          <ul class="nav nav-sidebar">
					<!--  class="active" -->
					<%-- <li><a href="<%=request.getContextPath()%>/studentList">멤버 --%>
					<li><a href="pboardControl.do">게시판 관리</a></li>
					<c:forEach items="${pboardList }" var="pboardList">
					<c:if test="${pboardList.pboard_del=='yes'}" >
						
						<%-- <!--  -->
						<form action="board.do" method="post">
						<button type="submit"class="btn btn-primary active .btn-lg">${pboardList.pboard_name }</button><input type="hidden" value="${pboardList.pboard_seq }" name="pboard_seq" >
								</form> 
						<!--  --> --%>
						<li><a href="board.do?pboard_seq=${pboardList.pboard_seq }">${pboardList.pboard_name }</a></li> 
					</c:if>
					</c:forEach>
				</ul>
			</div>
		 </div> 