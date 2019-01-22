package kogile.invitelist.DAO;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kogile.invitelist.Mapper.InviteListMapper;
import kogile.invitelist.Service.InviteList;

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
	
	public List<InviteList> inviteLists(int pjt_no){
		List<InviteList> list3 = null;
		List<InviteList> list4 = null;
		
		SqlSession sqlSession = getsql().openSession();
		try {
			list3 = sqlSession.getMapper(InviteListMapper.class).inviteList(pjt_no);
			list4 = sqlSession.getMapper(InviteListMapper.class).inviteList2(pjt_no);
			
			list3.addAll(list4);
			
			System.out.println("dao list" + list3);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list3;
	}
	
	public int deleteInviteList(InviteList list){
		int re = -1;
		SqlSession sqlSession = getsql().openSession();
		try{
			re = sqlSession.getMapper(InviteListMapper.class).deleteInviteList(list);
			System.out.println("delete re°ª : " + re);
			if(re>0){
				sqlSession.commit();
			}else{
				sqlSession.rollback();
			}
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		
		return re;
	}
}
