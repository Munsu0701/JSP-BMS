package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BookDao;
import dto.BookDto;
import dto.MemberDto;
import service.MemberSearchService;

public class MainController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		
		if(req.getAttribute("list") == null) {
			BookDao dao = new BookDao();
			List<BookDto> list = dao.getsBook();
			req.setAttribute("list", list);
		}
		
		RequestDispatcher rd = null;
		
		MemberSearchService ser = new MemberSearchService();
		MemberDto mem = ser.sessionSer(req);
		
		if(mem == null) {
			rd = req.getRequestDispatcher("main/index.jsp");
			rd.forward(req, resp);
		} else {
			
			/*
			 * String[] addJs = {"logout"}; req.setAttribute("addJs", addJs);
			 */
			req.setAttribute("name", mem.getMemNm());
			rd = req.getRequestDispatcher("main/mainLogin.jsp");
			rd.forward(req, resp);
		}
		
		
		
		/*
		 * Cookie[] cookies = req.getCookies();
		 * 
		 * for(Cookie cookie : cookies) { if(cookie.getName().equals("id")) { String[]
		 * addJs = {"logout"}; req.setAttribute("addJs", addJs);
		 * 
		 * MemberSearchService service = new MemberSearchService(); MemberDto member =
		 * service.getMem(cookie.getValue());
		 * 
		 * req.setAttribute("name", member.getMemNm());
		 * 
		 * rd = req.getRequestDispatcher("main/mainLogin.jsp"); rd.forward(req, resp); }
		 * } if(rd == null) { rd = req.getRequestDispatcher("main/index.jsp");
		 * rd.forward(req, resp); }
		 */
	}

}
