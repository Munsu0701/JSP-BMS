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
import service.StudentRegisterService;

@WebServlet("/stAdd")
public class StudentAddController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");

		
		RequestDispatcher rd = req.getRequestDispatcher("main/stAdd.jsp");
		rd.forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = resp.getWriter();
		try {
			StudentRegisterService service = new StudentRegisterService();
			service.process(req);
			out.println("<script>parent.location.reload();</script>");
		} catch (BookException e) {
			e.printStackTrace();
			out.println("<script>alert('" + e.getMessage() + "');</script>");
		}
		
	}
	
	
	
}
