package kogile.checklist.DAO;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kogile.checklist.Mapper.CheckListMapper;
import kogile.checklist.Service.Board;
import kogile.checklist.Service.Search;

public class CheckListDao {
	private static CheckListDao dao = new CheckListDao();
	
	public static CheckListDao getInstance() {
		return dao;
	}

	public SqlSessionFactory getSqlSessionFactory() {
		String resource = "mybatis-config.xml";
		InputStream in = null;
		try {
			in = Resources.getResourceAsStream(resource);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new SqlSessionFactoryBuilder().build(in);
	}
	
	public int insertchecklist(Board board) {
		SqlSession sql = dao.getSqlSessionFactory().openSession();
		int re = -1;
		
		try {
			re = sql.getMapper(CheckListMapper.class).insertchecklist(board);
			if(re >0) {
				sql.commit();
			}else {
				sql.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sql.close();
		}
		return re;
	}
	
	
	// --------------------------------------------------------------------------------------------	
		// 글갯수 추가하기. 
		public List<Board> listBoard(Search search, int startRow){
//		public List<Board> listBoard(Search search){
			SqlSession sqlSession = getSqlSessionFactory().openSession();
			List<Board> list = null;
			
			try {
				list = sqlSession.getMapper(CheckListMapper.class).listBoard(new RowBounds(startRow, 2), search);
//				list = sqlSession.getMapper(BoardMapper.class).listBoard(search);
				//list = sqlSession.selectList("kosta.mapper.BoardMapper.listBoard");
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				sqlSession.close();
			}
			
			return list;
		}
	
	
	
	
}
