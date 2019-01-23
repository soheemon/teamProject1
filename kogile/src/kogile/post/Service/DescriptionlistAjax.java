package kogile.post.Service;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.w3c.dom.Document;

import kogile.post.DAO.PostDao;
import kogile.post.DTO.DescriptionDTO;
import kogile.post.DTO.ReplyDTO;
import kogile.post.DTO.ReplyMemberDTO;
import net.sf.json.JSONArray;

public class DescriptionlistAjax implements Action {
	//class Re
	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		
		PostDao dao = PostDao.getInstance();
		int p_no= (Integer)session.getAttribute("p_no");
		List<ReplyMemberDTO> replyList = dao.replyMemberList(p_no);

		//멤버를 포함한 리스트를 가져온다.
		//아까 했던것처럼 똑같이 보내줌 
		JSONArray jsonarr = new JSONArray();
		jsonarr = JSONArray.fromObject(replyList);
		
		System.out.println(jsonarr.toString());
		response.setCharacterEncoding("utf-8");
//		response.getWriter().print(jsonarr.toString());

		PrintWriter pw = response.getWriter();
		pw.print(jsonarr.toString());
		pw.flush();
		pw.close();

		return null;
	}

}
