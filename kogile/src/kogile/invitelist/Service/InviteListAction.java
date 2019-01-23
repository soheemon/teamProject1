package kogile.invitelist.Service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kogile.invitelist.DAO.InviteListDao;
import kogile.invitelist.Service.Action;
import kogile.invitelist.Service.ActionForward;
import net.sf.json.JSONArray;

public class InviteListAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		InviteListDao dao = InviteListDao.getInstance();
		
		HttpSession session = request.getSession();
		int pjt_no = (Integer)session.getAttribute("pjt_no");
		
//		
//		String str = request.getParameter("pjt_no");
//		int pjt_no = 0;
//		if(str!=null){
//			pjt_no=Integer.parseInt(str);
//		}
		
		List<InviteList> list3 = dao.inviteLists(pjt_no);
		
		JSONArray jsonarr = new JSONArray();
		jsonarr = JSONArray.fromObject(list3);
		
		response.setCharacterEncoding("utf-8");
		response.getWriter().print(jsonarr.toString());
		System.out.println(jsonarr);
		
//		request.setAttribute("list3", list3);
		
//		ActionForward forward = new ActionForward();
//		forward.setRedirect(false);
//		forward.setPath("detailProject.jsp");
		
		return null;
	}

}
