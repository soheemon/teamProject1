package kogile.memberboard.Service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kogile.memberboard.DAO.InviteListDao;

public class InviteListAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		InviteListDao dao = InviteListDao.getInstance();
		
		List<InviteList> list3 = dao.inviteLists();
		
		request.setAttribute("list3", list3);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("inviteList.jsp");
		
		return forward;
	}

}
