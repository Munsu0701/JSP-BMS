<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form name='frmUpdate' id='frmUpdate' method="post" action="<c:url value="/rental"  />" target="ifrmProcess" autocomplete="off">
	<input type="hidden" name="bookNum" value="${book.book_number}">
	<h3>책 대여</h3>
	<div class="list_title">
		<ul class="list_wrap">
			<li class="list_sub">
				<div>책 번호</div>
				<div>책 이름</div>
				<div>출판사</div>
				<div>저자</div>
				<div>대여 상태</div>
			</li>
			<li class="list_sub">
				<div>${book.book_number}</div>
				<div>${book.bookNm}</div>
				<div>${book.publisher}</div>
				<div>${book.author}</div>
				<div>${book.status}</div>
			</li>
		</ul>
	</div>
	<input type="text" name="studentNm" placeholder="대여하는 학생 이름을 입력해주세요.">
	<button type="submit" id="rentalBtn">대여하기</button>
</form>