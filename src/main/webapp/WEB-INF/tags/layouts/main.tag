<%@ tag description="메인 공통 레이아웃" pageEncoding="utf-8" %>
<%@ tag body-content="scriptless" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<%@ attribute name="title" type="java.lang.String" %>
<fmt:setBundle basename="bundle.common" />
<layout:common title="${title}">
	<jsp:attribute name="header">
		<header>
			<section class="top-menu">
				<div class="layout_width">
					<a href="<c:url value="/join" />">
					회원가입
					</a>
					<a href="<c:url value="/login" />">
					로그인
					</a>
				</div>
			</section>
			<section class="logo">
				<a href="<c:url value="/main" />">
					<img src='<c:url value="/static/img/BMS.png" />'>
				</a>
			</section>
		</header>
	</jsp:attribute>
	<jsp:attribute name="footer">
		<footer>
			&copy; Copyright...
		</footer>
	</jsp:attribute>
	
	<jsp:body>
		<main class="layout_width">
			<jsp:doBody />
		</main>
	</jsp:body>
</layout:common>