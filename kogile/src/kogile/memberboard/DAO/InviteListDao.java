package kogile.memberboard.DAO;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kogile.memberboard.Mapper.InviteListMapper;
import kogile.memberboard.Service.InviteList;

public class InviteListDao {
	private static InviteListDao dao = new InviteListDao();
	
	public static InviteListDao getInstance(){
		return dao;
	}
	
	public SqlSessionFactory getsql(){
		String resource = "mybatis-config.xml";
		InputStream in = null;
		try {
			in = Resources.getResourceAsStream(resource);
			System.out.println("dao in °ª : "+in);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new SqlSessionFactoryBuilder().build(in);
	}
	
	public List<InviteList> inviteLists(){
		List<InviteList> list3 = null;
		List<InviteList> list4 = null;
		
		SqlSession sqlSession = getsql().openSession();
		try {
			list3 = sqlSession.getMapper(InviteListMapper.class).inviteList();
			list4 = sqlSession.getMapper(InviteListMapper.class).inviteList2();
		
			list3.addAll(list4);
			
			System.out.println("dao list" + list3);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list3;
	}
}
