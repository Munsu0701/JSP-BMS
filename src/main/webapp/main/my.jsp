<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<layout:login title="도서관리" >
		<div>
			<h1>${name}님, 안녕하세요.</h1>
		</div>
		<div class="login_wrap">
				<form method="post" class="form" action="<c:url value="/member" />" target="ifrmProcess" autocomplete="off">
					<div class="login_sub">
						<label for="id">아이디</label>
						<input type="text" name="id" maxlength="20" value="${member.memId}" required disabled>
					</div>
					<div class="login_sub">
						<label for="memNm">이름</label>
						<input type="text" name="memNm" maxlength="20" value="${member.memNm}" required disabled>
					</div>
					<div class="login_sub">
						<label for="email">이메일</label>
						<input type="email" name="email" maxlength="20" value="${member.email}" required>
					</div>
					<div class="login_sub">
						<label for="mobile">핸드폰번호</label>
						<input type="number" name="mobile" maxlength="20" value="${member.mobile}" required>
					</div>
					<div class="login_sub">
						<button type="submit" id="joBtn" class="joBtn">수정하기</button>
						<button type="reset">리셋</button>
					</div>
				</form>
			</div>
	</layout:login>