<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form name='frmUpdate' id='frmUpdate' method="post" action="<c:url value="/add"  />" target="ifrmProcess" autocomplete="off">
	<h3>책 추가</h3>
	<input type="text" name="bookNm" placeholder='책 제목'>
	<input type="text" name="publisher" placeholder='출판사'>
	<input type="text" name="author" placeholder='저자'>
	<button type="submit" id="add">책 추가</button>
</form>