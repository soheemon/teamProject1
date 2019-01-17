package kogile.startPage.DAO;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kogile.startPage.DTO.ProjectBoard;
import kogile.startPage.Mapper.PbMapper;


public class ProjectBoardDao {
	public static ProjectBoardDao dao=new ProjectBoardDao();
	
	public static ProjectBoardDao getInstance() {
		return dao;
	}
	
	public SqlSessionFactory getSqlSessionFactory() {
		String resource ="mybatis-config.xml";
		InputStream in = null;
		try {
			in = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		return new SqlSessionFactoryBuilder().build(in);
	}
	
	public int insertBoard(ProjectBoard pb){
		System.out.println(pb);
		int re = -1;
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		
		try {
			re = sqlSession.getMapper(PbMapper.class).insertBoard(pb);
			if(re >0){
				sqlSession.commit();
			}else{
				sqlSession.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		} 
		System.out.println(re);
		return re;
	} 

	public List<ProjectBoard> listBoard() {
		
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		List<ProjectBoard> list = null;
		try {
			list = sqlSession.getMapper(PbMapper.class).projectList();
			//list = sqlSession.selectList("kosta.mapper.BoardMapper.listBoard");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		
		return list;
	}

	public ProjectBoard mainDetail(int seq) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		ProjectBoard pb = new ProjectBoard();
		try {
			pb = sqlSession.getMapper(PbMapper.class).mainDetail(seq);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}

		return pb;
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

