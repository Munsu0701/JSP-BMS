package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import dao.BookDao;
import dto.BookDto;

public class SearchService {
	
	public List<BookDto> search(HttpServletRequest request) {
		
		String select = request.getParameter("select");
		String bookNm = request.getParameter("bookNm");
		
		if(select == null || select.trim().isEmpty()) {
			throw new BookException("선택이 잘못 되었습니다.");
		}
		if(bookNm == null || bookNm.trim().isEmpty()) {
			throw new BookException("검색어가 잘못 되었습니다.");
		}
		
		BookDao dao = new BookDao();
		
		return dao.serachBook(select, bookNm);
		
	}

}
