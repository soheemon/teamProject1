package kogile.chat.DAO;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kogile.chat.Mapper.ChatMapper;
import kogile.chat.Model.ChatDTO;
import kogile.project.DAO.ProjectDAO;
import kogile.project.Mapper.ProjectMapper;
import kogile.project.Model.ProjectDTO;

public class ChatDAO {
	public static ChatDAO dao = new ChatDAO();
	public static ChatDAO getInstance() {
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
	
	
	public int insertChat(ChatDTO chat){
		int re = -1;
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		
		try {
			re = sqlSession.getMapper(ChatMapper.class).insertChat(chat);
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
		return re;
	} 

	
	public List<ChatDTO> listChat() {
		
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		List<ChatDTO> list = null;
		
		try {
			list = sqlSession.getMapper(ChatMapper.class).listChat();
			//list = sqlSession.selectList("kosta.mapper.BoardMapper.listBoard");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return list;
	}
}
