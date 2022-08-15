package service;

import javax.servlet.http.HttpServletRequest;

import constants.Status;
import dao.BookDao;
import dto.BookDto;

public class DeleteService {
	
	public void delete(HttpServletRequest request) {
		
		String book_number = request.getParameter("bookNum");
		
		int number = Integer.parseInt(book_number);
		
		BookDao dao = new BookDao();
		
		BookDto dto = dao.get(number);
		
		if(dto.getStatus() == Status.RENTAL) {
			throw new BookException("대여 상태인 책은 삭제할수 없습니다.");
		}
		
		dao.delete(number);
		
	}

}
