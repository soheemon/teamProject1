package kogile.example.DAO;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kogile.Module.DescriptionDTO;
import kogile.Module.ReplyDTO;
import kogile.Module.ReplyMemberDTO;
import kogile.Module.ReplyUpdateSearchDTO;
import kogile.Module.TagDTO;
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
	//설명 작성
	public int insertDescription(DescriptionDTO description) {
	
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
	//설명 보기
	public DescriptionDTO descriptionDetail(int seq){
		DescriptionDTO list = null;
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
	//설명 삭제
	public int deleteDescription(DescriptionDTO description) {
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
	//설명 수정
	public int updateDescription(DescriptionDTO description) {
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
	//댓글 작성
	public int insertReply(ReplyDTO reply) {
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
	//댓글 목록 보기
	public List<ReplyDTO> replyList(int p_no){
		List<ReplyDTO> list =null;
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
	//댓글 작성자를 알기위해 작성자 뽑아오기
	public List<ReplyMemberDTO> replyMemberList(int p_no){
		List<ReplyMemberDTO> list = null;
		List<ReplyMemberDTO> list2 = null;
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
	// 댓글 삭제
	public int deleteReply(ReplyDTO reply) {
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
	//댓글 수정위해 프로젝트 참여자 번호와 댓글번호 가지오기
	public ReplyDTO replyUpdateSearch(ReplyUpdateSearchDTO search) {
		ReplyDTO reply = null;
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
	//댓글 수정
	public int updateReply(ReplyDTO reply) {
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
	//태그 작성
	public int insertTag(TagDTO tag) {
		int re=-1;
		SqlSession session = getSql().openSession();
		try {
			re=session.getMapper(PostMapper.class).insertTag(tag);
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
	//댓글번호 가져오기
	public int replyNum() {
		int replyNum = 0;
		SqlSession session = getSql().openSession();
		try {
			replyNum = session.getMapper(PostMapper.class).replyNum();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return replyNum;	
	}
	//태그하기위해 프로젝트 참여자 명단 가져오기
	public List<TagDTO> tagMemberList(int seq){
		List<TagDTO> list = null;
		List<TagDTO> list2 = null;
		SqlSession session = getSql().openSession();
		try {
			list2 = session.getMapper(PostMapper.class).tagMember2(seq);
			list = session.getMapper(PostMapper.class).tagMember(seq);
			list.addAll(list2);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return list;
	}
	//알림보내기위해 태그 번호가져오기
	public int tagNum() {
		int tagNum=0;
		SqlSession session = getSql().openSession();
		try {
			tagNum = session.getMapper(PostMapper.class).tagNum();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return tagNum;
	}
	//알림보내기위해 총 회원들 번호 가져오기
	public int tag_total_m_no(TagDTO tag) {
		int tag_total_m_no=0;
		SqlSession session = getSql().openSession();
		try {
			tag_total_m_no = session.getMapper(PostMapper.class).tag_total_m_no(tag);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return tag_total_m_no;
	}
	//알림 보내기
	public int insertTagNotice(TagDTO tag) {
		int re=-1;
		SqlSession session = getSql().openSession();
		try {
			re=session.getMapper(PostMapper.class).insertTagNotice(tag);
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
