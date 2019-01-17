package kogile.invitelist.Service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kogile.invitelist.DAO.InviteListDao;
import kogile.invitelist.Service.Action;
import kogile.invitelist.Service.ActionForward;

public class InviteListAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		InviteListDao dao = InviteListDao.getInstance();
		
		String str = request.getParameter("pjt_no");
		int pjt_no = 0;
		if(str!=null){
			pjt_no=Integer.parseInt(str);
		}
		
		List<InviteList> list3 = dao.inviteLists(pjt_no);
		System.out.println("action list3 : "+ list3);
		
		request.setAttribute("list3", list3);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("inviteList.jsp");
		
		return forward;
	}

}
