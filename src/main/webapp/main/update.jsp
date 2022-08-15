<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form name='frmUpdate' id='frmUpdate' method="post" action="<c:url value="/update"  />" target="ifrmProcess" autocomplete="off">
	<input type='hidden' name='id' value='${book.book_number}'>
	<h3>책 수정</h3>
	<input type="text" name="bookNm" placeholder='책 제목' value='${book.bookNm}'>
	<input type="text" name="publisher" placeholder='출판사' value='${book.publisher}'>
	<input type="text" name="author" placeholder='저자' value='${book.author}'>
	<button type="submit" id="update">수정하기</button>
</form>