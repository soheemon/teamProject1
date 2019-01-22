package kogile.project.DAO;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kogile.project.Mapper.ProjectMapper;
import kogile.project.Model.InviteDTO;
import kogile.project.Model.ProjectDTO;


public class ProjectDAO {
	public static ProjectDAO dao=new ProjectDAO();
	
	public static ProjectDAO getInstance() {
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
	
	public void insertBoard(ProjectDTO pb){
		int re1 = 0;
		int re2= 0;
		int re3= 0;
		int re4 = 0;
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		
		try {
			re1 = sqlSession.getMapper(ProjectMapper.class).insertBoard(pb);
			InviteDTO invite = sqlSession.getMapper(ProjectMapper.class).selectPjt();
			int pjt_no = invite.getPjt_no();
			re2 = sqlSession.getMapper(ProjectMapper.class).insertInvite(invite);
			int invite_no = sqlSession.getMapper(ProjectMapper.class).selectInvite();
			re3 = sqlSession.getMapper(ProjectMapper.class).insertPjt_Info(invite_no);
			re4 = sqlSession.getMapper(ProjectMapper.class).insertCard(pjt_no);
					
			int re = re1 * re2 * re3 * re4;
			
			if(re >0) {
			sqlSession.commit();
			}else{
				sqlSession.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		} 
		
	} 

	public List<ProjectDTO> listBoard() {
		
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		List<ProjectDTO> list = null;
		try {
			list = sqlSession.getMapper(ProjectMapper.class).projectList();
			//list = sqlSession.selectList("kosta.mapper.BoardMapper.listBoard");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		
		return list;
	}

	public ProjectDTO mainDetail(int seq) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		ProjectDTO pb = new ProjectDTO();
		try {
			pb = sqlSession.getMapper(ProjectMapper.class).mainDetail(seq);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}

		return pb;
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

