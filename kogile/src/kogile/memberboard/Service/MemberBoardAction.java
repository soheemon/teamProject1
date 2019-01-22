package kogile.memberboard.Service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kogile.memberboard.DAO.MemberBoardDao;



public class MemberBoardAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		MemberBoardDao dao = MemberBoardDao.getInstance();
		
		MemberSearch search = new MemberSearch();
		search.setSearch('%' + request.getParameter("search") + '%');
		List<MemberBoard> list = dao.memberBoard(search);
		
		request.setAttribute("list", list);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("inviteSearch.jsp");
		
		return forward;
	}

}
