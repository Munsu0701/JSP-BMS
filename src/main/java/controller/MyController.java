package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.MemberDto;
import service.MemberSearchService;

@WebServlet("/member")
public class MyController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		
		MemberSearchService service = new MemberSearchService();
		
		MemberDto member = service.sessionSer(req);
		req.setAttribute("name", member.getMemNm());
		req.setAttribute("member", member);
		
		
		
		RequestDispatcher rd = req.getRequestDispatcher("main/my.jsp");
		rd.forward(req, resp);
	}

}
