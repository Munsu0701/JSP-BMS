package mybatis;

import java.io.IOException;
import java.io.Reader;
import java.util.ResourceBundle;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Connection {
	
	private static SqlSessionFactory sqlSessionFactory;

	static {// 클래스 로더에 올라갈때 초기화 실행
		try {
			String env = null;
			try {
				ResourceBundle application = ResourceBundle.getBundle("application");
				env = application.getString("environment");
			} catch (Exception e) {}
			
			env = (env == null || env.trim().isEmpty()) ? "development" : env;
			
			Reader reader = Resources.getResourceAsReader("mybatis/config/mybatis-config.xml");
			
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader, env);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static SqlSession getSession() {
		SqlSession session = sqlSessionFactory.openSession();
		return session;
	}
	
}
