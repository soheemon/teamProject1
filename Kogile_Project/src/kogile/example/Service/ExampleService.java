package kogile.example.Service;

import kogile.example.DAO.ExampleDao;

public class ExampleService {
	private static ExampleService service = new ExampleService();
	private static ExampleDao dao;
	
	public static ExampleService getInstance() {
		dao = ExampleDao.getInstance();
		return service;
	}
}
