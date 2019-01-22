package kogile.invitelist.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kogile.invitelist.DAO.InviteListDao;

public class DeleteInviteListAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		
		InviteList list = new InviteList();
		InviteListDao dao = InviteListDao.getInstance();
		
		list.setNo(Integer.parseInt(request.getParameter("no")));
		list.setPjt_no(Integer.parseInt(request.getParameter("pjt_no")));
		
		System.out.println("delete getno°ª : " + list.getNo() +"\t" + "delete getpjt_no°ª : "+ list.getPjt_no());
		System.out.println("list°ª : " + list);

		dao.deleteInviteList(list);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("startPage.jsp");
		
		return forward;
	}

}
