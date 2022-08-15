<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>

<layout:main title="회원가입">
			<div class="login_wrap">
				<form method="post" class="form" action="<c:url value="/join" />" target="ifrmProcess" autocomplete="off">
					<div class="login_sub">
						<label for="id">아이디</label>
						<input type="text" name="id" maxlength="20" placeholder="아이디를 입력하세요." required>
					</div>
					<div class="login_sub">
						<label for="password">비밀번호</label>
						<input type="password" name="password" maxlength="20" placeholder="비밀번호를 입력하세요." required>
					</div>
					<div class="login_sub">
						<label for="repassword">비밀번호 확인</label>
						<input type="password" name="repassword" maxlength="20" placeholder="비밀번호를 한번 더 입력하세요." required>
					</div>
					<div class="login_sub">
						<label for="memNm">이름</label>
						<input type="text" name="memNm" maxlength="20" placeholder="이름을 입력하세요." required>
					</div>
					<div class="login_sub">
						<label for="email">이메일</label>
						<input type="email" name="email" maxlength="20" placeholder="이메일을 입력하세요." required>
					</div>
					<div class="login_sub">
						<label for="mobile">핸드폰번호</label>
						<input type="number" name="mobile" maxlength="20" placeholder="핸드폰 번호를 입력하세요." required>
					</div>
					<div class="login_sub">
						<button type="submit" id="joBtn" class="joBtn">회원가입</button>
						<button type="reset">리셋</button>
					</div>
				</form>
			</div>
</layout:main>