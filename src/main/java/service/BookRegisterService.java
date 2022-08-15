package service;

import javax.servlet.http.HttpServletRequest;

import dao.BookDao;
import dto.BookDto;

public class BookRegisterService {
	
	public void process(HttpServletRequest request) {
		
		String bookNm = request.getParameter("bookNm");
		String publisher = request.getParameter("publisher");
		String author = request.getParameter("author");
		
		if(bookNm == null || bookNm.trim().isEmpty()) {
			throw new BookException("책 제목을 입력해주세요.");
		}
		if(publisher == null || publisher.trim().isEmpty()) {
			throw new BookException("출판사를 입력해주세요.");
		}
		if(author == null || author.trim().isEmpty()) {
			throw new BookException("저자를 입력해주세요.");
		}
		
		
		BookDto book = new BookDto();
		book.setBookNm(bookNm);
		book.setPublisher(publisher);
		book.setAuthor(author);
		
		BookDao dao = new BookDao();
		dao.register(book);
		
	}

}
