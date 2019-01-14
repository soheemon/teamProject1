package kogile.checklist.Service;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

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

		MultipartRequest multi = 
				new MultipartRequest(request, "utf-8");

		
		Board board = new Board();
		board.setChecklist_no(Integer.parseInt(multi.getParameter("checklist_no")));
		board.setCheck_title(multi.getParameter("checklist_title"));
		board.setChecklist_no(Integer.parseInt(multi.getParameter("p_no")));
		
		return dao.insertchecklist(board);
	}

}
