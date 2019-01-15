package kogile.memberboard.DAO;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kogile.memberboard.Mapper.MemberBoardMapper;
import kogile.memberboard.Service.MemberBoard;
import kogile.memberboard.Service.MemberSearch;

public class MemberBoardDao {
	private static MemberBoardDao dao = new MemberBoardDao();
	
	public static MemberBoardDao getInstance() {
		return dao;
	}
	
	public SqlSessionFactory getSql() {
		String resource = "mybatis-config.xml";
		InputStream in = null;
		try {
			in = Resources.getResourceAsStream(resource);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new SqlSessionFactoryBuilder().build(in);
	}
	
	public List<MemberBoard> memberBoard(MemberSearch search) {
		
		List<MemberBoard> list = null;
		
		SqlSession sqlSession = getSql().openSession();
		try {
			list = sqlSession.getMapper(MemberBoardMapper.class).memberBoard(search);
			System.out.println("dao¸®½ºÆ® : " + list.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	

}
