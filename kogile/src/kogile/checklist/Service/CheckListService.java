package kogile.checklist.Service;

import javax.servlet.http.HttpServletRequest;


import kogile.checklist.DAO.CheckListDao;

public class CheckListService {
	private static CheckListService service = new CheckListService();
	private static CheckListDao dao;
	
	public static CheckListService getInstance() {
		dao = CheckListDao.getInstance();
		return service;
	}

	public int insertCheckBoardService(HttpServletRequest request)throws Exception {
		request.setCharacterEncoding("utf-8");

		
		Board board = new Board();
		board.setChecklist_no(Integer.parseInt(request.getParameter("checklist_no")));
		board.setCheck_title(request.getParameter("checklist_title"));
		board.setChecklist_no(Integer.parseInt(request.getParameter("p_no")));
		
		return dao.insertchecklist(board);
	}

}
