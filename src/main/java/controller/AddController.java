package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BookException;
import service.BookRegisterService;
import service.MemberSearchService;

@WebServlet("/add")
public class AddController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = resp.getWriter();
		try {
			BookRegisterService service = new BookRegisterService();
			service.process(req);
			out.println("<script>parent.location.reload();</script>");
		} catch (BookException e) {
			e.printStackTrace();
			out.println("<script>alert('" + e.getMessage() + "');</script>");
		}
		
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		
		
		
		RequestDispatcher rd = req.getRequestDispatcher("main/add.jsp");
		rd.forward(req, resp);
	}
	
	
	
	
	
}
