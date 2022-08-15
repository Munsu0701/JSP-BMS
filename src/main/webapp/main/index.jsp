<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<layout:main title="도서관리" >
		<div class="submenu_wrap">
			<div class="btn_wrap">
					<button type="submit" id="delete">도서 삭제</button>
			</div>
			<div class="btn_wrap">
				<button type="submit" id="add">도서 추가</button>
			</div>
			<div class="btn_wrap">
					<button type="submit" id="stAdd">학생 추가</button>
			</div>
			<div>
				<h1>도서목록</h1>
			</div>
			<div class="btn_wrap">
					<button type="submit" id="return">반납 하기</button>
			</div>
			<div class="btn_wrap">
					<button type="submit" id="stList">학생 목록</button>
			</div>
			<div class="btn_wrap" >
					<button type="submit" id="rentalList">총 대여 목록</button>
			</div>
		</div>
		<div class="btn_wrap">
			<select id="select" name="select">
				<option value="bookNm">책 제목</option>
				<option value="publisher">책 출판사</option>
				<option value="author">책 저자</option>
			</select>
			<input type="text" id="searchText" name="bookNm" placeholder="책 제목을 입력해주세요.">
			<button type="submit" id="searchBtn">검색</button>
		</div>
		<div class="btn_wrap">
			<input type="text" id="soloNm" name="soloNm" placeholder="학생 이름을 입력해주세요.">
			<button type="submit" name="soloList" id="soloList" data-name="">개인 대여 목록 확인</button>
		</div>
		<div class="list_title">
			<ul class="list_wrap">
				<li class="list_sub">
					<div>책 번호</div>
					<div>책 이름</div>
					<div>출판사</div>
					<div>저자</div>
					<div>대여 상태</div>
					<div>대여 버튼</div>
					<div>수정 버튼</div>
				</li>
				<c:forEach var="list" items="${list}">
				<li class="list_sub">
					<div>${list.book_number }</div>
					<div>${list.bookNm }</div>
					<div>${list.publisher }</div>
					<div>${list.author }</div>
					<div>${list.status == "RETURN" ? "대여가능" : "대여중" }</div>
					<div>
						<c:if test="${list.status == 'RETURN'}">
							<button type="submit" class="rentalBtn" data-id="${list.book_number}">대여하기</button>
						</c:if>
					</div>
					<div>
							<button class="edit" type="submit" data-id="${list.book_number}">수정하기</button>
					</div>
				</li>
				</c:forEach>
			</ul>
		</div>
	</layout:main>