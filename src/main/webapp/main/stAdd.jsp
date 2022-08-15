<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form name='frmUpdate' id='frmUpdate' method="post" action="<c:url value="/stAdd"  />" target="ifrmProcess" autocomplete="off">
	<h3>학생 추가</h3>
	<input type="text" name="studentNm" placeholder='학생 이름'>
	<button type="submit" id="stAdd">학생 추가</button>
</form>