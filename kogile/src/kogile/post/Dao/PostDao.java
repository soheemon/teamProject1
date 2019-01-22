package kogile.post.Dao;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

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
	
}
