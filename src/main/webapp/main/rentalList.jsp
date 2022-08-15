<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<form name='frmUpdate' id='frmUpdate' method="post" action="<c:url value="/stList"  />" target="ifrmProcess" autocomplete="off">
	<h3>총 대여 목록</h3>
	<div class="list_title">
		<ul class="list_wrap">
			<li class="list_sub">
				<div>책 번호</div>
				<div>책 이름</div>
				<div>출판사</div>
				<div>저자</div>
				<div>대여 날짜</div>
				<div>대여자</div>
			</li>
			<c:forEach var="rental" items="${list}">
			<li class="list_sub">
				<div>${rental.book_num}</div>
				<div>${rental.bookNm}</div>
				<div>${rental.publisher}</div>
				<div>${rental.author}</div>
				<div>${rental.date_format}</div>
				<div>${rental.student_name}</div>
			</li>
			</c:forEach>
		</ul>
	</div>
</form>