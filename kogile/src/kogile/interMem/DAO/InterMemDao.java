package kogile.interMem.DAO;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kogile.interMem.Mapper.InterMemMapper;
import kogile.module.TotalMemInfo;
import kogile.module.InterMember;
import kogile.module.IsInterMem;

public class InterMemDao {
	private static InterMemDao dao = new InterMemDao();
	
	public static InterMemDao getInstance() {
		return dao;
	}
	
	private InterMemDao(){};
	
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
	
	public int insertInterMember(InterMember member) {
		SqlSession sql = dao.getSql().openSession();
		int re = -1;
		try {
			re = sql.getMapper(InterMemMapper.class).insertInterMember(member);
			if(re > 0) {
				sql.commit();
			}else {
				sql.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sql.close();
		}
		return re;
	}
	
	public InterMember selectInterMember(String email) {
		SqlSession sql = dao.getSql().openSession();
		
		InterMember InterMember = new InterMember();
		try {
			InterMember = sql.getMapper(InterMemMapper.class).selectInterMember(email);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sql.close();
		}
		return InterMember;
	}
	public IsInterMem IsInterMember(int total_m_no) {
		SqlSession sql = dao.getSql().openSession();
		
		IsInterMem isintermem = new IsInterMem();
		try {
			isintermem = sql.getMapper(InterMemMapper.class).IsInterMember(total_m_no);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sql.close();
		}
		return isintermem;
	}
	public TotalMemInfo exterMemSearch(int exter_m_no) {
		SqlSession sql = dao.getSql().openSession();
		
		TotalMemInfo totalMemInfo = new TotalMemInfo();
		try {
			totalMemInfo = sql.getMapper(InterMemMapper.class).exterMemSearch(exter_m_no);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sql.close();
		}
		return totalMemInfo;
	}
	public TotalMemInfo interMemSearch(int member_no) {
		SqlSession sql = dao.getSql().openSession();
		
		TotalMemInfo totalMemInfo = new TotalMemInfo();
		try {
			totalMemInfo = sql.getMapper(InterMemMapper.class).interMemSearch(member_no);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sql.close();
		}
		return totalMemInfo;
	}
	public int selectTotalMemNumWithInMem(int member_no) {
		int total_m_no = -1;
		SqlSession sql = dao.getSql().openSession();

		try {
			total_m_no = sql.getMapper(InterMemMapper.class).selectTotalMemNumWithInMem(member_no);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sql.close();
		}
		
		return total_m_no;
	}
	
	
}
