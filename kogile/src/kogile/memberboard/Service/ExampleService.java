package kogile.memberboard.Service;

import kogile.memberboard.DAO.MemberBoardDao;

public class ExampleService {
	private static ExampleService service = new ExampleService();
	private static MemberBoardDao dao;
	
	public static ExampleService getInstance() {
		dao = MemberBoardDao.getInstance();
		return service;
	}
	
	
}
