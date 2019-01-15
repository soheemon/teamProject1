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
//		board.setChecklist_no(Integer.parseInt(request.getParameter("checklist_no")));
		
		board.setCheck_title(request.getParameter("check_title"));
//		board.setP_no(Integer.parseInt(request.getParameter("p_no")));
		
		
//		System.out.println("board.getChecklist_no() :" + board.getChecklist_no());
		System.out.println("board.getCheck_title() :" + board.getCheck_title());
//		System.out.println("board.getP_no() :" + board.getP_no());
//		dao.insertchecklist(board);
		return dao.insertchecklist(board);
	}

}
