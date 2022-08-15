package service;

import javax.servlet.http.HttpServletRequest;

import dao.BookDao;
import dto.BookDto;

public class BookUpdateService {
	
	public void update(HttpServletRequest request) {
		BookDto book = new BookDto();
		
		String book_number = request.getParameter("id");
		String bookNm = request.getParameter("bookNm");
		String publisher = request.getParameter("publisher");
		String author = request.getParameter("author");
		
		if (book_number == null || book_number.trim().isEmpty()) {
			throw new BookException("잘못된 접근입니다.");
		}
		
		if (bookNm == null || bookNm.trim().isEmpty()) {
			throw new BookException("책 제목을 입력해주세요");
		}
		
		if (publisher == null || publisher.trim().isEmpty()) {
			throw new BookException("출판사를 입력해주세요.");
		}
		
		if (author == null || author.trim().isEmpty()) {
			throw new BookException("저자를 입력해주세요.");
		}

		book.setBook_number(Integer.valueOf(book_number));
		book.setBookNm(bookNm);
		book.setPublisher(publisher);
		book.setAuthor(author);
		
		new BookDao().update(book);

	}

}
