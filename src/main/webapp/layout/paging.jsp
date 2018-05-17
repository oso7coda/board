<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="paginate">
	<ul class="pagination pagination">
		<li><a href="javascript:goPage(${param.firstPageNo})"
			class="first">처음 페이지</a></li>
		<li><a href="javascript:goPage(${param.prevPageNo})" class="prev">이전
				페이지</a></li>
		<span> <c:forEach var="i" begin="${param.startPageNo}"
				end="${param.endPageNo}" step="1">
				<c:choose>
					<c:when test="${i eq param.pageNo}">
						<li><a href="javascript:goPage(${i})" class="choice">${i}</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="javascript:goPage(${i})">${i}</a></li>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</span>
		<li><a href="javascript:goPage(${param.nextPageNo})" class="next">다음
				페이지</a></li>
		<li><a href="javascript:goPage(${param.finalPageNo})"
			class="last">마지막 페이지</a></li>
	</ul>
</div>


