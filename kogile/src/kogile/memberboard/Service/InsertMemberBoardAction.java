package kogile.memberboard.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kogile.memberboard.DAO.MemberBoardDao;

public class InsertMemberBoardAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		
		
		MemberBoard board = new MemberBoard();
		MemberBoardDao dao = MemberBoardDao.getInstance();
		
		board.setNo(Integer.parseInt(request.getParameter("no")));
		board.setPjt_no(Integer.parseInt(request.getParameter("pjt_no")));
		
		dao.insertMemberBoard(board);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("inviteSearch.jsp");
		
		return forward;
	}

}
