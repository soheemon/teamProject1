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
	
	public int insertMemberBoard(MemberBoard board){
		int re = -1;
		SqlSession sqlSession = getSql().openSession();
		try {
			re = sqlSession.getMapper(MemberBoardMapper.class).insertMemberBoard(board);
			if(re>0){
				sqlSession.commit();
			}else{
				sqlSession.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			sqlSession.close();
		}
		return re;
	}
	
	public List<MemberBoard> memberBoard(MemberSearch search) {
		
		List<MemberBoard> list = null;
		List<MemberBoard> list2 = null;
		
		SqlSession sqlSession = getSql().openSession();
		try {
			list = sqlSession.getMapper(MemberBoardMapper.class).memberBoard(search);
			list2 = sqlSession.getMapper(MemberBoardMapper.class).memberBoard2(search);
			
			list.addAll(list2);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	

	

}
