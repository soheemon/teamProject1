package kogile.post.Dao;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kogile.post.Mapper.PostLabelMapper;
import kogile.post.Model.LabelDTO;
import kogile.post.Model.LabelInfoDTO;



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
	
}
