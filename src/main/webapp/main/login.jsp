<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>

<layout:main title="로그인">
			<div class="login_wrap">
				<form method="post" class="form" action="<c:url value="/login" />" target="ifrmProcess" autocomplete="off">
					<div class="login_sub">
						<label for="id">아이디</label>
						<input type="text" name="id" maxlength="20" placeholder="아이디를 입력하세요." required>
					</div>
					<div class="login_sub">
						<label for="password">비밀번호</label>
						<input type="password" name="password" maxlength="20" placeholder="비밀번호를 입력하세요." required>
					</div>
					<div class="login_sub">
						<button type="submit" class="loBtn">로그인</button>
						<button type="button" id="joBtn" class="joBtn">회원가입</button>
					</div>
				</form>
			</div>
</layout:main>