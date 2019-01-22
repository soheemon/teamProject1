package kogile.notice.DAO;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kogile.notice.Mapper.NoticeMapper;
import kogile.notice.Service.Notice;

public class NoticeDao {
	private static NoticeDao dao = new NoticeDao();
	
	public static NoticeDao getInstance(){
		return dao;
	}
	
	public SqlSessionFactory getSql(){
		String resource = "mybatis-config.xml";
		InputStream in = null;
		try {
			in = Resources.getResourceAsStream(resource);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new SqlSessionFactoryBuilder().build(in);
	}
	
	public List<Notice> notice(int no){
		List<Notice> list5 = null;
		
		SqlSession sqlSession = getSql().openSession();
		try{
			list5 = sqlSession.getMapper(NoticeMapper.class).notice(no);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list5;
	}
	
	
}
