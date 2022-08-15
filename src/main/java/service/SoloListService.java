package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import dao.BookDao;
import dto.RentalDto;

public class SoloListService {
	
	public List<RentalDto> process(HttpServletRequest request) {
		String student_name = request.getParameter("studentNm");
		if(student_name == null || student_name.trim().isEmpty()) {
			throw new BookException("학생 이름을 입력해주세요.");
		}
		
		BookDao dao = new BookDao();
		
		return dao.getSolo(student_name);
	}

}
