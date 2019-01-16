package kogile.example.Service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kogile.Module.Description;
import kogile.Module.Reply;
import kogile.Module.ReplyUpdateSearch;
import kogile.example.DAO.PostDao;

public class PostService {
	private static PostService service = new PostService();
	private static PostDao dao;
	
	public static PostService getInstance() {
		dao = PostDao.getInstance();
		return service;
	}
	
	public int insertDescriptionService(HttpServletRequest request)throws Exception {
		Description description = new Description();
		description.setD_contents(request.getParameter("d_contents"));
		//훗날 수정필요
		description.setP_no(1);
		return dao.insertDescription(description);
	}
	
	public Description descriptionDetailService(HttpServletRequest request)throws Exception{
		//훗날 수정필요
		int p_no=1;
		Description detail = dao.descriptionDetail(p_no);
		request.setAttribute("p_no", p_no);
		request.setAttribute("detail", detail);
		
		return detail;
	}
	
	public int deleteDescription(HttpServletRequest request)throws Exception {
		Description description = new Description();
		int seq = Integer.parseInt(request.getParameter("p_no"));
		description.setP_no(seq);
		return dao.deleteDescription(description);	
	}

	public int updateDescription(HttpServletRequest request)throws Exception{
		Description description = new Description();
		int seq = Integer.parseInt(request.getParameter("p_no"));
		description.setD_contents(request.getParameter("d_contents"));
		description.setP_no(seq);
		return dao.updateDescription(description);
	}
	
	public int insertReplyService(HttpServletRequest request) {
		Reply reply = new Reply();
		reply.setR_contents(request.getParameter("r_contents"));
		//훗날 수정필요
		reply.setP_no(1);
		reply.setInfo_no(1);
		return dao.insertReply(reply);
	}
	
	public List<Reply> replyListService(HttpServletRequest request){
		//훗날 수정필요
		int p_no =1;
		List<Reply> list = dao.replyList(p_no);
		request.setAttribute("list", list);
		
		return dao.replyList(p_no);
	}
	
	public int deleteReplyService(HttpServletRequest request) {
		Reply reply = new Reply();
		int seq = Integer.parseInt(request.getParameter("r_no"));
		int seq2 = Integer.parseInt(request.getParameter("info_no"));
		reply.setR_no(seq);
		reply.setInfo_no(seq2);
		return dao.deleteReply(reply);
	}
	
	public void replyUpdateFormService(HttpServletRequest request) {
		int seq = Integer.parseInt(request.getParameter("r_no"));
		int seq2 = Integer.parseInt(request.getParameter("info_no"));
		//메서드에 파라미터로 넘겨줄 리플
		System.out.println(seq + "  " + seq2);
		ReplyUpdateSearch search = new ReplyUpdateSearch();
		search.setSearch_r_no(seq);
		search.setSearch_info_no(seq2);
		//쿼리 실행후받아올 리플
		//Reply reply2 = dao.replyUpdateForm(reply);
		Reply reply = dao.replyUpdateSearch(search);

		request.setAttribute("replyOrgin", reply);
		System.out.println("fdfdsfsd" + reply.getR_contents());
	}
	
	public int updateReplyService(HttpServletRequest request) {
		Reply reply = new Reply();
		int seq = Integer.parseInt(request.getParameter("r_no"));
		int seq2 = Integer.parseInt(request.getParameter("info_no"));
		reply.setR_contents(request.getParameter("r_contents"));
		reply.setR_no(seq);
		reply.setInfo_no(seq2);
		return dao.updateReply(reply);
	}
}
