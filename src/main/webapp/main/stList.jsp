<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form name='frmUpdate' id='frmUpdate' method="post" action="<c:url value="/stList"  />" target="ifrmProcess" autocomplete="off">
	<h3>학생 목록</h3>
	<div class="list_title">
		<ul class="list_wrap">
			<li class="list_sub">
				<div>학생   번호</div>
				<div>학생   이름</div>
				<div>누적 대여 횟수</div>
			</li>
			<c:forEach var="student" items="${list}">
			<li class="list_sub">
				<div>${student.student_id}</div>
				<div>${student.student_name}</div>
				<div>${student.rental_count}</div>
			</li>
			</c:forEach>
		</ul>
	</div>
</form>