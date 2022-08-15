<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form name='frmUpdate' id='frmUpdate' method="get" action="<c:url value="/search"  />" target="ifrmProcess" autocomplete="off">
	<h3>검색 목록</h3>
	<div class="list_title">
		<ul class="list_wrap">
			<li class="list_sub">
				<div>책 번호</div>
				<div>책 이름</div>
				<div>출판사</div>
				<div>저자</div>
				<div>대여 상태</div>
			</li>
		<c:forEach var="search" items="${search}">
			<li class="list_sub">
				<div>${search.book_number}</div>
				<div>${search.bookNm}</div>
				<div>${search.publisher}</div>
				<div>${search.author}</div>
				<div>${search.status == "RETURN" ? "대여가능" : "대여중" }</div>
			</li>
		</c:forEach>
		</ul>
	</div>
</form>