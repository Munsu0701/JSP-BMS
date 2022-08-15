<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form name='frmUpdate' id='frmUpdate' method="post" action="<c:url value="/soloList"  />" target="ifrmProcess" autocomplete="off">
	<h3>대여 목록</h3>
	<div class="list_title">
		<ul class="list_wrap">
			<li class="list_sub">
				<div>책 번호</div>
				<div>책 이름</div>
				<div>출판사</div>
				<div>저자</div>
				<div>대여 날짜</div>
				<div>학생 이름</div>
			</li>
		<c:forEach var="rentalList" items="${rental}">
			<li class="list_sub">
				<div>${rentalList.book_num}</div>
				<div>${rentalList.bookNm}</div>
				<div>${rentalList.publisher}</div>
				<div>${rentalList.author}</div>
				<div>${rentalList.date_format}</div>
				<div>${rentalList.student_name}</div>
			</li>
		</c:forEach>
		</ul>
	</div>
</form>