<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


	<h3>책 목록</h3>
	<div class="list_title">
		<ul class="list_wrap">
			<li class="list_sub">
				<div>책 번호</div>
				<div>책 이름</div>
				<div>출판사</div>
				<div>저자</div>
				<div>대여 상태</div>
				<div>삭제</div>
			</li>
			<c:forEach var="book" items="${list}">
			<li class="list_sub">
				<div>${book.book_number}</div>
				<div>${book.bookNm}</div>
				<div>${book.publisher}</div>
				<div>${book.author}</div>
				<div>${book.status == "RETURN" ? "대여가능" : "대여중" }</div>
				<div>
				<form name='frmUpdate' id='frmUpdate' method="post" action="<c:url value="/delete"  />" target="ifrmProcess" autocomplete="off">
					<button type="submit" class="delete" onclick="return confirm('정말 삭제하시겠습니까?')">삭제</button>
					<input type="hidden" name="bookNum" value="${book.book_number}">
				</form>
				</div>
			</li>
			</c:forEach>
		</ul>
	</div>
