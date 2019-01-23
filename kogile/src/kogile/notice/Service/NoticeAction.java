package kogile.notice.Service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kogile.notice.DAO.NoticeDao;

public class NoticeAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		NoticeDao dao = NoticeDao.getInstance();
		
//		String str = request.getParameter("no");
//		int no=0;
//		if(str!=null) {
//			no=Integer.parseInt(str);
//		}
		
		int no = 5;
		
		List<Notice> list5 = dao.notice(no);
		System.out.println("action list5 : " + list5);
		
		request.setAttribute("list5", list5);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("notice.jsp");
		
		return forward;
	}

}
