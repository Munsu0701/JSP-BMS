package service;

import javax.servlet.http.HttpServletRequest;

import dao.BookDao;
import dto.BookDto;
import dto.StudentDto;

public class RentalService {
	
	public void rental(HttpServletRequest request) {
		String student_name = request.getParameter("studentNm");
		String book_number = request.getParameter("bookNum");
		
		if(student_name == null || student_name.trim().isEmpty()) {
			throw new BookException("학생 이름을 올바르게 입력해주세요");
		}
		if(book_number == null || book_number.trim().isEmpty()) {
			throw new BookException("책 번호가 입력되지 않았습니다.");
		}
		
		BookDao dao = new BookDao();
		
		StudentDto student = dao.getStudent(student_name);
		BookDto book = dao.get(Integer.parseInt(book_number));
		
		dao.rental(book, student);
		
	}

}
