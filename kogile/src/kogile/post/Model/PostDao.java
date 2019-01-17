package kogile.post.Model;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kogile.post.Mapper.PostMapper;

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
	
	// insertPost (Post 데이터 삽입)
	public void insertPost(PostDTO postDTO) {
		SqlSession sql = getSql().openSession();
		int re = -1;
		
		try {
			re = sql.getMapper(PostMapper.class).insertPost(postDTO);
			
			if (re > 0) {
				sql.commit();
			} else {
				sql.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace(); 
		} finally {
			sql.close();
		}
	}
	
	public int chargeInfo(ChargeDTO chargeDTO) {
		SqlSession sql = getSql().openSession();
		int re = -1;
		
		try {
			re = sql.getMapper(PostMapper.class).chargeInfo(chargeDTO);
			
			if (re > 0) {
				sql.commit();
			} else {
				sql.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sql.close();
		}
		
		return re;
	}
	
	public int selectPost() {
		SqlSession sql = getSql().openSession();
		int re =-1;
		
		try {
			re = sql.getMapper(PostMapper.class).selectPost();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sql.close();
		}
		return re;
	}
	
	// listPost  (Post list 보기)
	public List<PostDTO> listPost(PostDTO postDTO) {
		SqlSession sql = getSql().openSession();
		List<PostDTO> list = null;
		
		try {
			list = sql.getMapper(PostMapper.class).listPost(postDTO);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sql.close();
		}
		
		return list;
	}
	
	// detailPost (Post 상세보기)
	public PostDTO detailPost(int p_no) {
		SqlSession sql = getSql().openSession();
		PostDTO postDTO = new PostDTO();
		
		try {
			postDTO = sql.getMapper(PostMapper.class).detailPost(p_no);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sql.close();
		}
		
		return postDTO;
	}
	
	// updatePost (Post 수정하기)
	public void updatePost(PostDTO postDTO) {
		SqlSession sql = getSql().openSession();
		int re = -1;
		
		try {
			re = sql.getMapper(PostMapper.class).updatePost(postDTO);
			
			if (re > 0) {
				sql.commit();
			} else {
				sql.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sql.close();
		}
	}
	
	// deletePost (Post 삭제하기)
	public void deletePost(int p_no) {
		SqlSession sql = getSql().openSession();
		int re = -1;
		
		try {
			re = sql.getMapper(PostMapper.class).deletePost(p_no);
			
			if (re > 0) {
				sql.commit();
			} else {
				sql.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sql.close();
		}
	}
	
	// list에 Project 참여자 담기
	public List<MemberDTO> listMember(int pjt_no) {
		SqlSession sql = getSql().openSession();
		List<MemberDTO> list = null;
		List<MemberDTO> list2 = null;
		
		try {
			list2 = sql.getMapper(PostMapper.class).inter_member(pjt_no);
			list = sql.getMapper(PostMapper.class).exter_member(pjt_no);
			list.addAll(list2);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sql.close();
		}
		
		return list;
	}
	
	// list에 Project에 있는 card 정보 담기
	public List<CardDTO> card_info() {
		SqlSession sql = getSql().openSession();
		List<CardDTO> list = null;
		
		try {
			list = sql.getMapper(PostMapper.class).card_info();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sql.close();
		}
		
		return list;
	}
}
