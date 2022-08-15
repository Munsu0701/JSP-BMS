package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDao;
import dto.RentalDto;

@WebServlet("/rentalList")
public class RentalListController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		
			
		BookDao dao = new BookDao();
		List<RentalDto> list = dao.getsRental();
		req.setAttribute("list", list);
			
		
		RequestDispatcher rd = req.getRequestDispatcher("main/rentalList.jsp");
		rd.forward(req, resp);
	}
	
	
	
}
