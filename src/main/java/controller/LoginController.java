package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.MemberLoginService;

@WebServlet("/login")
public class LoginController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		
		String[] addCss = {"login"};
		String[] addJs = {"login"};
		
		req.setAttribute("addCss", addCss);
		req.setAttribute("addJs", addJs);
		
		RequestDispatcher rd = req.getRequestDispatcher("main/login.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		
		MemberLoginService service = new MemberLoginService();
		PrintWriter out = resp.getWriter();
		if(service.idPwCheck(req)) {
			out.println("<script>parent.location.href = '/bms/main';</script>");
		} else {
			out.println("<script>alert('아이디나 비밀번호를 잘못입력하셨습니다.');</script>");
		}
		
		
	}
	
	

}
