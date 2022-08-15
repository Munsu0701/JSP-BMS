package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDao;
import dto.RentalDto;
import service.BookException;
import service.ReturnService;

@WebServlet("/return")
public class ReturnController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		
		BookDao dao = new BookDao();
		List<RentalDto> list = dao.getsRental();
		req.setAttribute("list", list);
		
		RequestDispatcher rd = req.getRequestDispatcher("main/return.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = resp.getWriter();
		ReturnService service = new ReturnService();
		try {
			
			service.returnBook(req);
			out.println("<script>parent.location.reload();</script>");
			
		} catch(BookException e) {
			e.printStackTrace();
			out.println("<script>alert('" + e.getMessage() + "');</script>");
		}
		
		
	}

	
	
}
