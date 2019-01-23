package kogile.post.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kogile.post.DAO.PostDao;
import kogile.post.DTO.ReplyDTO;
import kogile.post.DTO.ReplyUpdateSearchDTO;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class ReplyUpdateFormAjax implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub

			//댓글 번호 가져오기
			String replyInfo = request.getParameter("replyInfo");
			System.out.println(replyInfo);
			int sep = replyInfo.indexOf('#');
			int r_no = Integer.parseInt(replyInfo.substring(0, sep));
			int info_no = Integer.parseInt(replyInfo.substring(sep + 1, replyInfo.length()));
			
			System.out.println(r_no + ":" + info_no);
//			//댓글 작성자 넘버 가져오기
//			int seq2 = Integer.parseInt(request.getParameter("info_no"));
//			//메서드에 파라미터로 넘겨줄 리플
			ReplyUpdateSearchDTO search = new ReplyUpdateSearchDTO();
//			//댓글 번호 셋팅하기
			search.setSearch_r_no(r_no);
//			//댓글 작성자 넘버 셋팅하기
			search.setSearch_info_no(info_no);
//			//쿼리 실행후받아올 리플
			PostDao dao = PostDao.getInstance();
			ReplyDTO reply = dao.replyUpdateSearch(search);
			
			//JSONArray jsonarr = new JSONArray();
			JSONObject jsonobj = new JSONObject();
			jsonobj.element("reply",reply); // 의심스러운 코드
			
			//jsonarr = JSONArray.fromObject(replyList);
			
			//System.out.println(jsonarr.toString());
			response.setCharacterEncoding("utf-8");
			response.getWriter().print(jsonobj.toString());
//			request.setAttribute("replyOrgin", reply);

		return null;
	}

}
