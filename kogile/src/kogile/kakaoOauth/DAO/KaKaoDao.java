package kogile.kakaoOauth.DAO;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kogile.kakaoOauth.Mapper.kakaoOauthMapper;
import kogile.module.ExterMember;

public class KaKaoDao {
	private static KaKaoDao dao = new KaKaoDao();
	
	public static KaKaoDao getInstance() {
		return dao;
	}
	
	private KaKaoDao(){};
	
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
	
	public int insertExterMember(ExterMember extermember) {
		SqlSession sql = dao.getSql().openSession();
		int re = -1;
		try {
			re = sql.getMapper(kakaoOauthMapper.class).insertExterMember(extermember);
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
	
	public ExterMember selectExterMember(int interlinked_info) {
		SqlSession sql = dao.getSql().openSession();
		
		ExterMember exterMember = new ExterMember();
		try {
			exterMember = sql.getMapper(kakaoOauthMapper.class).selectExterMember(interlinked_info);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sql.close();
		}
		return exterMember;
	}
	
	
}
