package service;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.mindrot.bcrypt.BCrypt;

import dto.MemberDto;
import mybatis.Connection;

public class MemberLoginService {
	
	public boolean idPwCheck(HttpServletRequest req) {
		boolean result = false;
		
		String id = req.getParameter("id");
		String password = req.getParameter("password");
		
		SqlSession session = Connection.getSession();
		List<MemberDto> list = session.selectList("MemberMapper.members");
		session.close();
		for(MemberDto dto : list) {
			if(id.equals(dto.getMemId())) {
				if(BCrypt.checkpw(password, dto.getMemPw())) {
					HttpSession httpSession = req.getSession();
					dto.setMemPw("");
					httpSession.setAttribute("member", dto);
					return !result;
				}
			}
		}
		
		return result;
	}

}
