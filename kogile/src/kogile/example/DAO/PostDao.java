package kogile.example.DAO;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kogile.Module.Description;
import kogile.Module.Reply;
import kogile.Module.ReplyMember;
import kogile.Module.ReplyUpdateSearch;
import kogile.example.Mapper.PostMapper;

public class PostDao {
	private static PostDao dao = new PostDao();
	public static PostDao getInstance() {
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
	
	public int insertDescription(Description description) {
	
		int re =-1;
		SqlSession session = getSql().openSession();
		try {
			re = session.getMapper(PostMapper.class).insertDescription(description);
			if(re>0) {
				session.commit();
			}else {
				session.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return re;
	}
	
	public Description descriptionDetail(int seq){
		Description list = null;
		SqlSession session = getSql().openSession();
		try {
			list = session.getMapper(PostMapper.class).descriptionList(seq);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return list;
		
	}
	
	public int deleteDescription(Description description) {
		int re =-1;
		SqlSession session = getSql().openSession();
		try {
			re = session.getMapper(PostMapper.class).deleteDescription(description);
			if(re>0) {
				session.commit();
			}else {
				session.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return re;
	}
	
	public int updateDescription(Description description) {
		int re =-1;
		SqlSession session = getSql().openSession();
		try {
			re = session.getMapper(PostMapper.class).updateDescription(description);
			if(re>0) {
				session.commit();
			}else {
				session.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return re;
	}
	//Reply
	public int insertReply(Reply reply) {
		int re=-1;
		SqlSession session = getSql().openSession();
		try {
			re=session.getMapper(PostMapper.class).insertReply(reply);
			if(re>0) {
				session.commit();
			}else {
				session.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return re;
	}
	public List<Reply> replyList(int p_no){
		List<Reply> list =null;
		SqlSession session = getSql().openSession();
		try {
			list=session.getMapper(PostMapper.class).replyList(p_no);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return list;
	}
	public List<ReplyMember> replyMemberList(int p_no){
		List<ReplyMember> list = null;
		List<ReplyMember> list2 = null;
		SqlSession session = getSql().openSession();
		try {
			list=session.getMapper(PostMapper.class).replyMemberList(p_no);
			list2=session.getMapper(PostMapper.class).replyMemberList2(p_no);
			list.addAll(list2);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return list;
	}
	
	public int deleteReply(Reply reply) {
		int re =-1;
		SqlSession session = getSql().openSession();
		try {
			re = session.getMapper(PostMapper.class).deleteReply(reply);
			if(re>0) {
				session.commit();
			}else {
				session.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return re;
	}
	
	public Reply replyUpdateSearch(ReplyUpdateSearch search) {
		Reply reply = null;
		SqlSession session = getSql().openSession();
		try {
			reply=session.getMapper(PostMapper.class).replyUpdateSearch(search);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return reply;
	}
	
	public int updateReply(Reply reply) {
		int re=-1;
		SqlSession session = getSql().openSession();
		try {
			re=session.getMapper(PostMapper.class).updateReply(reply);
			if(re>0) {
				session.commit();
			}else {
				session.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return re;
	}
	
}
