package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.mindrot.bcrypt.BCrypt;

import dto.MemberDto;
import mybatis.Connection;

public class MemberJoinService {
	
	public void join(HttpServletRequest req) {
		String memId = req.getParameter("id");
		String memPw = req.getParameter("password");
		String rePw = req.getParameter("repassword");
		String memNm = req.getParameter("memNm");
		String email = req.getParameter("email");
		String mobile = req.getParameter("mobile");
		
		if(idCheck(memId)) {
			throw new BookException("아이디가 중복 됩니다.");
		}
		
		if(!memPw.equals(rePw)) {
			throw new BookException("비밀번호가 일치하지 않습니다.");
		}
		
		MemberDto dto = new MemberDto();
		String hash = BCrypt.hashpw(memPw, BCrypt.gensalt(12));
		dto.setMemId(memId);
		dto.setMemPw(hash);
		dto.setMemNm(memNm);
		dto.setEmail(email);
		dto.setMobile(mobile);
		
		SqlSession session = Connection.getSession();
		
		int affectedRows = session.insert("MemberMapper.register", dto);
		
		if(affectedRows <= 0) {
			throw new BookException("회원가입이 정상적으로 진행되지 않았습니다.");
		}
		
		session.commit();
		session.close();
		
		
	}
	
	private boolean idCheck(String id) {
		boolean result = false;
		
		SqlSession session = Connection.getSession();
		
		List<MemberDto> list = session.selectList("MemberMapper.members");
		session.close();
		for(MemberDto dto : list) {
			if(id.equals(dto.getMemId())) {
				return !result;
			}
		}
		
		return result;
	}

}
