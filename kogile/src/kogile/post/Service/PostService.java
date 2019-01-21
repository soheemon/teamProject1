package kogile.post.Service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kogile.post.DAO.PostDao;
import kogile.post.DTO.DescriptionDTO;
import kogile.post.DTO.ReplyDTO;
import kogile.post.DTO.ReplyMemberDTO;
import kogile.post.DTO.ReplyUpdateSearchDTO;
import kogile.post.DTO.TagDTO;

public class PostService {
	private static PostService service = new PostService();
	private static PostDao dao;
	
	public static PostService getInstance() {
		dao = PostDao.getInstance();
		return service;
	}
	//설명 작성
	public int insertDescriptionService(HttpServletRequest request)throws Exception {
		DescriptionDTO description = new DescriptionDTO();
		//설명내용 받아와 셋팅
		description.setD_contents(request.getParameter("d_contents"));
		//훗날 수정필요 >> 포스트 넘버 받아와 셋팅
		description.setP_no(1);
		return dao.insertDescription(description);
	}
	//포스트 내부페이지 보이기
	public DescriptionDTO descriptionDetailService(HttpServletRequest request)throws Exception{
		//훗날 수정필요 >>포스트 넘버 셋팅
		int p_no=1;
		DescriptionDTO detail = dao.descriptionDetail(p_no);
		request.setAttribute("p_no", p_no);
		request.setAttribute("detail", detail);
		
		return detail;
	}
	//설명 삭제
	public int deleteDescription(HttpServletRequest request)throws Exception {
		DescriptionDTO description = new DescriptionDTO();
		//해당하는 포스트 넘버 받아와 셋팅
		int seq = Integer.parseInt(request.getParameter("p_no"));
		description.setP_no(seq);
		return dao.deleteDescription(description);	
	}
	//설명 수정
	public int updateDescription(HttpServletRequest request)throws Exception{
		DescriptionDTO description = new DescriptionDTO();
		//해당하는 포스트 넘버 받아와 셋팅
		int seq = Integer.parseInt(request.getParameter("p_no"));
		description.setP_no(seq);
		//설명내용 받아와 셋팅
		description.setD_contents(request.getParameter("d_contents"));
		return dao.updateDescription(description);
	}
	//댓글 작성
	public int insertReplyService(HttpServletRequest request)throws Exception {
		ReplyDTO reply = new ReplyDTO();
		//댓글내용받아와 셋팅
		reply.setR_contents(request.getParameter("r_contents"));
		//훗날 수정필요 >>포스트넘버 셋팅 , 사용자 셋팅
		reply.setP_no(1);
		reply.setInfo_no(1);
		return dao.insertReply(reply);
	}
	//댓글 리스트 보이기
	public List<ReplyDTO> replyListService(HttpServletRequest request)throws Exception{
		//훗날 수정필요 >> 포스트 넘버 셋팅
		int p_no =1;
		//해당하는 포스트 넘버의 댓글들 리스트로 셋팅
		List<ReplyDTO> list = dao.replyList(p_no);
		request.setAttribute("list", list);
		
		return dao.replyList(p_no);
	}
	//댓글 작성자
	public List<ReplyMemberDTO> replyMemberListService(HttpServletRequest request)throws Exception{
		//훗날 수정필요 >> 포스트 넘버 셋팅
		int p_no =1;
		//댓글 작성자 셋팅
		List<ReplyMemberDTO> list = dao.replyMemberList(p_no);
		request.setAttribute("memberList", list);
		
		return list;
	}
	//댓글 삭제
	public int deleteReplyService(HttpServletRequest request)throws Exception {
		ReplyDTO reply = new ReplyDTO();
		//댓글 번호 받아오기
		int seq = Integer.parseInt(request.getParameter("r_no"));
		//댓글 작성자 넘버 받아오기
		int seq2 = Integer.parseInt(request.getParameter("info_no"));
		//댓글 번호 셋팅하기
		reply.setR_no(seq);
		//댓글 작성자 넘버 셋팅하기
		reply.setInfo_no(seq2);
		return dao.deleteReply(reply);
	}
	//댓글 수정 폼보이기
	public void replyUpdateFormService(HttpServletRequest request)throws Exception {
		//댓글 번호 가져오기
		int seq = Integer.parseInt(request.getParameter("r_no"));
		//댓글 작성자 넘버 가져오기
		int seq2 = Integer.parseInt(request.getParameter("info_no"));
		//메서드에 파라미터로 넘겨줄 리플
		ReplyUpdateSearchDTO search = new ReplyUpdateSearchDTO();
		//댓글 번호 셋팅하기
		search.setSearch_r_no(seq);
		//댓글 작성자 넘버 셋팅하기
		search.setSearch_info_no(seq2);
		//쿼리 실행후받아올 리플
		ReplyDTO reply = dao.replyUpdateSearch(search);

		request.setAttribute("replyOrgin", reply);
	}
	//댓글 수정
	public int updateReplyService(HttpServletRequest request)throws Exception {
		ReplyDTO reply = new ReplyDTO();
		//댓글 번호 가져오기
		int seq = Integer.parseInt(request.getParameter("r_no"));
		//작성자 넘버 가져오기
		int seq2 = Integer.parseInt(request.getParameter("info_no"));
		//댓글 내용 셋팅
		reply.setR_contents(request.getParameter("r_contents"));
		//댓글 번호 셋팅
		reply.setR_no(seq);
		//작성자 넘버 셋팅
		reply.setInfo_no(seq2);
		return dao.updateReply(reply);
	}
	//태그하기
	public int insertTagService(HttpServletRequest request)throws Exception {
		TagDTO tag = new TagDTO();
		//댓글넘버 가져오기
		int replyNum = dao.replyNum();
		//댓글넘버 셋팅하기
		tag.setR_no(replyNum);
		//작성자 번호 가져오기
		String test = request.getParameter("t.info_no");
		//작성자 번호가 ex)회원1.1 로 되어있음 그래서 일단 .을 찾는다
		int start = test.indexOf('.');
		//.부터 끝까지 짤라낸다
		String test1 = test.substring(start + 1, test.length());
		// 만약 짤라낸게 아무것도 없다면 롤백한다
		if(test1 =="") {
			return -1;
		}else {
		// 무슨 값이 들어가 있다면 작성자번호를 셋팅한다
			tag.setInfo_no(Integer.parseInt(test1));
			return dao.insertTag(tag);
		}
	}
	//태그대상 설정
	public List<TagDTO> tagMemberListService(HttpServletRequest request)throws Exception{
		//수정필요 >> 포스트 넘버 셋팅한다
		int pjt_no = 1;
		List<TagDTO> list = dao.tagMemberList(pjt_no);
		//태그할 애들 리스트로 세팅한다
		request.setAttribute("tagMember", list);
		return list;
	}
	//알림가게 하기
	public int insertTagNoticeService(HttpServletRequest request)throws Exception {
		TagDTO tag = new TagDTO();
		//태그넘버 가져온다
		int tagNum = dao.tagNum();
		//태그넘버 셋팅한다
		tag.setTag_no(tagNum);
		//작성자넘버 가져온다. 회원1.1이런식으로 되어있다.
		String test = request.getParameter("t.info_no");
		//.의 위치를 찾는다.
		int start = test.indexOf('.');
		//.의 위치 다음부터 끝까지 추출한다
		String test1 = test.substring(start + 1, test.length());
		//만약 그 값이 아무것도 없다면 롤백한다.
		if(test1 =="") {
			return -1;
		}else {
			//값이 있다면 작성자 넘버를 셋팅한다
			tag.setInfo_no(Integer.parseInt(test1));
			//태그될수 있는애들의 토탈넘버를 가져온다
			int tag_total_m_no = dao.tag_total_m_no(tag);
			//토탈넘버를 셋팅한다
			tag.setTotal_m_no(tag_total_m_no);
			//알람이 가도록한다
			return dao.insertTagNotice(tag);
		}
		
	}
}

