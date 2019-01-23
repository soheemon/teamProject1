package kogile.post.DAO;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kogile.post.DTO.DescriptionDTO;
import kogile.post.DTO.ReplyDTO;
import kogile.post.DTO.ReplyMemberDTO;
import kogile.post.DTO.ReplyUpdateSearchDTO;
import kogile.post.DTO.TagDTO;
import kogile.post.Mapper.PostLabelMapper;
import kogile.post.Mapper.PostMapper;
import kogile.post.Model.CardDTO;
import kogile.post.Model.ChargeDTO;
import kogile.post.Model.DdateDTO;
import kogile.post.Model.LabelDTO;
import kogile.post.Model.LabelInfoDTO;
import kogile.post.Model.MemberDTO;
import kogile.post.Model.PostDTO;
import kogile.post.Model.PostMemberDTO;
import kogile.project.Model.PostDragDTO;


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
	public List<LabelDTO> listlabel(int pjt_no){
		SqlSession sql = getSql().openSession();
		List<LabelDTO> list = null;
		try {
			list = sql.getMapper(PostLabelMapper.class).labellist(pjt_no);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sql.close();
		}
		return list;
	}
	
	public void insertlabel(LabelDTO label) {
		SqlSession sql = getSql().openSession();
		int re = -1;
		try {
			re = sql.getMapper(PostLabelMapper.class).insertlabel(label);
			if(re>0) {
				sql.commit();
			}else {
				sql.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sql.close();
		}
	}
	
	public void deletelabel(LabelDTO label) {
		SqlSession sql = getSql().openSession();
		int re = -1;
		try {
			re = sql.getMapper(PostLabelMapper.class).deletelabel(label);
			if(re>0) {
				sql.commit();
			}else {
				sql.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sql.close();
		}
	}
	
	public void updateLabel(LabelDTO label) {
		SqlSession sql = getSql().openSession();
		int re = -1;
		try {
			re = sql.getMapper(PostLabelMapper.class).updatelabel(label);
			if(re>0) {
				sql.commit();
			}else {
				sql.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sql.close();
		}
	}
	
	public LabelDTO searchLabel(int label_no) {
		SqlSession sql = getSql().openSession();
		LabelDTO label = null;
		try {
			label = sql.getMapper(PostLabelMapper.class).searchlabel(label_no);			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sql.close();
		}
		return label;
	}
	
	public int searchpjt (int p_no) {
		SqlSession sql = getSql().openSession();
		int pjt_no = -1;
		try {
			pjt_no = sql.getMapper(PostLabelMapper.class).searchpjt(p_no);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sql.close();
		}
		return pjt_no;
	}
	
	public List<LabelDTO> detialviewlabel(int p_no){
		SqlSession sql = getSql().openSession();
		List<LabelDTO> list = null;
		try {
			list = sql.getMapper(PostLabelMapper.class).detialviewlabel(p_no);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sql.close();
		}
		return list;
	}
	
	public void insertLabelInfo(LabelInfoDTO label_info) {
		SqlSession sql = getSql().openSession();
		int re = -1;
		try {
			re = sql.getMapper(PostLabelMapper.class).insertLabelInfo(label_info);
			if(re>0) {
				sql.commit();
			}else {
				sql.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sql.close();
		}
	}
	
	public void deleteLabelInfo(LabelInfoDTO label_info) {
		SqlSession sql = getSql().openSession();
		int re = -1;

		try {
			re = sql.getMapper(PostLabelMapper.class).deleteLabelInfo(label_info);
			if(re > 0) {
				sql.commit();
			}else {
				sql.rollback();
			}
			
			System.out.println(re);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sql.close();
		}
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
			int re = -1;

			try {
				re = sql.getMapper(PostMapper.class).selectPost();

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				sql.close();
			}
			return re;
		}

		// listPost (Post list 보기)
		public List<PostDTO> listPost(int pjt_no) {
			SqlSession sql = getSql().openSession();
			List<PostDTO> list = null;

			try {
				list = sql.getMapper(PostMapper.class).listPost(pjt_no);
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

		// insertPostForm에 Project 참여자 담기
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
			} finally {
				sql.close();
			}

			return list;
		}

		// insertPostForm에 Project에 있는 card 정보 담기
		public List<CardDTO> card_info(int pjt_no) {
			SqlSession sql = getSql().openSession();
			List<CardDTO> list = null;

			try {
				list = sql.getMapper(PostMapper.class).card_info(pjt_no);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				sql.close();
			}

			return list;
		}

		// Post 내부에 있는 담당자들 출력하기
		public List<PostMemberDTO> PostMemberlist(int p_no) {
			SqlSession sql = getSql().openSession();
			List<PostMemberDTO> list = null;
			List<PostMemberDTO> list2 = null;

			try {
				list = sql.getMapper(PostMapper.class).post_inter_member(p_no);
				list2 = sql.getMapper(PostMapper.class).post_exter_member(p_no);
				list.addAll(list2);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				sql.close();
			}

			return list;
		}

		// insertPostForm에 현재 날짜 가져가기
		public DdateDTO DdateInfo(int p_no) {
			SqlSession sql = getSql().openSession();
			DdateDTO ddateDTO = new DdateDTO();

			try {
				ddateDTO = sql.getMapper(PostMapper.class).ddateInfo(p_no);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				sql.close();
			}

			return ddateDTO;
		}

		// insertPostDdate 삽입
		public void DdateInsertPost(DdateDTO ddateDTO) {
			SqlSession sql = getSql().openSession();
			int re = -1;

			try {
				re = sql.getMapper(PostMapper.class).ddateInsertPost(ddateDTO);

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

		// updateDdate 마감일 수정하기
		public void updateDdate(DdateDTO ddateDTO) {
			SqlSession sql = getSql().openSession();
			int re = -1;

			try {
				re = sql.getMapper(PostMapper.class).updateDdate(ddateDTO);

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

		// detailPost (Post 상세보기)
		public DdateDTO detailDdate(int p_no) {
			SqlSession sql = getSql().openSession();
			DdateDTO ddateDTO = new DdateDTO();

			try {
				ddateDTO = sql.getMapper(PostMapper.class).detailDdate(p_no);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				sql.close();
			}

			return ddateDTO;
		}

		// deleteDdate (마감일 삭제하기)
		public void deleteDdate(int p_no) {
			SqlSession sql = getSql().openSession();
			int re = -1;
			
			try {
				re = sql.getMapper(PostMapper.class).deleteDdate(p_no);
				
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
	
	public void dragPost(PostDragDTO postDragDTO) {
		SqlSession sql = getSql().openSession();
		int re = -1;
		
		try {
			re = sql.getMapper(PostMapper.class).dragPost(postDragDTO);
			System.out.println(re);
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
	
}
