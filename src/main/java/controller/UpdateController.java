package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDao;
import dto.BookDto;
import service.BookException;
import service.BookUpdateService;

@WebServlet("/update")
public class UpdateController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");

		BookDao dao = new BookDao();
		BookDto book = dao.get(Integer.valueOf(req.getParameter("id")));
		req.setAttribute("book", book);
		
		RequestDispatcher rd = req.getRequestDispatcher("main/update.jsp");
		rd.forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = resp.getWriter();
		BookUpdateService service = new BookUpdateService();
		try {
			
			service.update(req);
			out.println("<script>parent.location.reload();</script>");
			
		} catch(BookException e) {
			e.printStackTrace();
			out.println("<script>alert('" + e.getMessage() + "');</script>");
		}
		
		
	}
	
	
	
}
