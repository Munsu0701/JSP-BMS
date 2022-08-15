package service;

import javax.servlet.http.HttpServletRequest;

import dao.BookDao;
import dto.StudentDto;

public class StudentRegisterService {
	
	public void process(HttpServletRequest request) {
		String student_name = request.getParameter("studentNm");
		if(student_name == null || student_name.trim().isEmpty()) {
			throw new BookException("학생 이름을 입력해주세요.");
		}
		
		BookDao dao = new BookDao();
		StudentDto student = new StudentDto();
		student.setStudent_name(student_name);
		dao.st_register(student);
	}
	
}
