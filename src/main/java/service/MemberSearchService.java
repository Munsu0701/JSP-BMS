package service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import dto.MemberDto;
import mybatis.Connection;

public class MemberSearchService {
	
	public void idCookie(HttpServletRequest req) {
		boolean result = false;
		
		Cookie[] cookies = req.getCookies();
		
		for(Cookie cookie : cookies) {
			if(cookie.getName().equals("id")) {
				result = true;
			}
		}
		
		if(!result) {
			throw new BookException("권한이 없습니다.");
		}
		
	}
	
	public MemberDto sessionSer(HttpServletRequest req) {
		HttpSession session = req.getSession();
		
		MemberDto member = (MemberDto)session.getAttribute("member");
		
		return member;
	}
	
	public void authority(HttpServletRequest req) {
		HttpSession session = req.getSession();
		
		MemberDto member = (MemberDto)session.getAttribute("member");
		
		
		if(member == null) {
			throw new BookException("권한이 없습니다. 로그인 후 이용해 주세요.");
		}
		
	}
	
	public MemberDto getMem(String id) {
		SqlSession session = Connection.getSession();
		
		MemberDto param = new MemberDto();
		param.setMemId(id);
		
		MemberDto member = session.selectOne("MemberMapper.member", param);
		
		
		return member;
	}

}
