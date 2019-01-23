package kogile.post.Service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kogile.post.DAO.PostDao;
import kogile.post.DTO.DescriptionDTO;
import kogile.post.DTO.ReplyDTO;
import kogile.post.DTO.ReplyMemberDTO;
import kogile.post.DTO.ReplyUpdateSearchDTO;
import kogile.post.DTO.TagDTO;
import kogile.post.Model.CardDTO;
import kogile.post.Model.ChargeDTO;
import kogile.post.Model.DdateDTO;
import kogile.post.Model.LabelDTO;
import kogile.post.Model.LabelInfoDTO;
import kogile.post.Model.MemberDTO;
import kogile.post.Model.PostDTO;
import kogile.post.Model.PostMemberDTO;
import kogile.project.Model.PostDragDTO;
import net.sf.json.JSONArray;

public class PostService {
	private static PostService service = new PostService();
	private static PostDao dao;
	
	public static PostService getInstance() {
		dao = PostDao.getInstance();
		
		return service;
	}
	
	public void listlabel(HttpServletRequest request, HttpServletResponse response)throws Exception{
		HttpSession session = request.getSession();
//		int pjt_no = (Integer)session.getAttribute("pjt_no");
		int pjt_no = (Integer)session.getAttribute("pjt_no");		
		List<LabelDTO> list = dao.listlabel(pjt_no);
		
		JSONArray jsonarr = new JSONArray();
		jsonarr = JSONArray.fromObject(list);
		response.setCharacterEncoding("utf-8");
		response.getWriter().print(jsonarr.toString());
		
//		return list;
	}
	
	public void insertLabelService(HttpServletRequest request, HttpServletResponse response)throws Exception{
		HttpSession session = request.getSession();
		
		LabelDTO label = new LabelDTO();
		
		int p_no = (Integer)session.getAttribute("p_no");
		
		label.setColor_no(Integer.parseInt(request.getParameter("label_color")));
		label.setLabel_text(request.getParameter("label_text"));
		label.setPjt_no(dao.searchpjt(p_no));	
		dao.insertlabel(label);
	}
	
	public void deleteLabelService(HttpServletRequest request, HttpServletResponse response)throws Exception {
		LabelDTO label = new LabelDTO();
//		String text = request.getParameter("label_text");
//		int color_no = Integer.parseInt(request.getParameter("color_no"));
		
		int label_no = Integer.parseInt(request.getParameter("label_no"));
		label.setLabel_no(label_no);
		
		dao.deletelabel(label);
	}
	
	
	public void updateLabelService(HttpServletRequest request, HttpServletResponse response)throws Exception{
		LabelDTO label = new LabelDTO();
		int label_no = Integer.parseInt(request.getParameter("label_no"));
		String label_text = request.getParameter("label_text");
		int color_no = Integer.parseInt(request.getParameter("color_no"));
		
		label.setLabel_no(label_no);
		label.setLabel_text(label_text);
		label.setColor_no(color_no);
		
		dao.updateLabel(label);
	}
	
	public LabelDTO updateLabelFormService(HttpServletRequest request, HttpServletResponse response)throws Exception {
		int label_no = Integer.parseInt(request.getParameter("label_no"));
		LabelDTO label = dao.searchLabel(label_no);
		
		return label;
	}
	
	public List<LabelDTO> postDetailViewService(HttpServletRequest request, HttpServletResponse response)throws Exception{
		
		HttpSession session = request.getSession();
		
		int p_no = (Integer)session.getAttribute("p_no");
		
		if(request.getParameter("label_no") != null) {
			int label_no = Integer.parseInt(request.getParameter("label_no"));
			LabelInfoDTO label_info = new LabelInfoDTO();
			label_info.setLabel_no(label_no);
			label_info.setP_no(p_no);
			
			dao.insertLabelInfo(label_info);
		}
		
		List<LabelDTO> list = dao.detialviewlabel(p_no);
		
		
		return list;
	}
	
	public void deleteLabelInfoService(HttpServletRequest request, HttpServletResponse response)throws Exception{
		HttpSession session = request.getSession();
		
		LabelInfoDTO label_info = new LabelInfoDTO();
		int label_no = Integer.parseInt(request.getParameter("label_no"));
		int p_no = (Integer)session.getAttribute("p_no");
		
		
		label_info.setLabel_no(label_no);
		label_info.setP_no(p_no);
		dao.deleteLabelInfo(label_info);
	}
	
	public void insertPostActionService(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PostDTO postDTO = new PostDTO();

		// insertForm에서 입력한 값을 PostDTO에 담는다.
		postDTO.setP_title(request.getParameter("p_title"));
		postDTO.setC_no(Integer.parseInt(request.getParameter("pjt_card")));
		dao.insertPost(postDTO);

		// 최근에 생성된 Post의 p_no를 가져오는 작업
		int p_no = dao.selectPost();
		
		//생성한 post 정보를 json 객체로 처리
		JSONArray jsonarr = new JSONArray();
		jsonarr.add(dao.detailPost(p_no));

		// insertForm에서 체크한 담당자들을 chargeDTO를 통해 담는 과정
		ChargeDTO chargeDTO = new ChargeDTO();

		// checkbox에서 선택된 담당자들을 담는다.
		// String 배열에 선택한 member를 담는다.
		String[] supervisorStr = request.getParameterValues("pjt_member");

		// int 배열에 member들을 선언한다.
		int[] supervisors = new int[supervisorStr.length];

		// 받은 담당자들을 int로 형변환 시킨다.
		for (int i = 0; i < supervisorStr.length; i++) {
			System.out.println(supervisorStr[i]);
			supervisors[i] = Integer.parseInt(supervisorStr[i]);
		}

		// 형변환 시킨 pjt_member를 for문으로 전부 출력한다.
		for (int i = 0; i < supervisors.length; i++) {

			// 형변환 시킨 담당자들을 DTO 객체에 set한다.
			chargeDTO.setP_no(p_no);
			chargeDTO.setInfo_no(supervisors[i]);

			// 담긴 DTO를 Mapping한다.
			dao.chargeInfo(chargeDTO);
		}

		// 마감일 구하는 객체
		DdateDTO ddateDTO = new DdateDTO();

		ddateDTO.setP_no(p_no);

		// 입력한 Form name을 입력한다.
		ddateDTO.setD_date(request.getParameter("DateInfo"));

		// 해당 Post에 Mapping한다.
		dao.DdateInsertPost(ddateDTO);
	}

	// listPostAction (Post 리스트 보기)(card_no로불러오기)
	public void listPostActionService(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session = request.getSession();
		int pjt_no = (Integer)session.getAttribute("pjt_no");
		// list에 Mapping할 메소드를 담는다.
		List<CardDTO> cards = dao.card_info(pjt_no);
		request.setAttribute("card", cards);
		System.out.println(cards.toString());
		
		List<PostDTO> post = dao.listPost(pjt_no);
		request.setAttribute("post", post);
		System.out.println(post.toString());
		
		
//		List<PostDTO> todo = dao.listPost(cards.get(0).getC_no());
//		request.setAttribute("todo", todo);
//		
//		List<PostDTO> doing = dao.listPost(cards.get(1).getC_no());
//		request.setAttribute("doing", doing);
//		
//		List<PostDTO> done = dao.listPost(cards.get(2).getC_no());
//		request.setAttribute("done", done);
//		
//		List<PostDTO> close = dao.listPost(cards.get(3).getC_no());
//		request.setAttribute("close", close);
		

		// list를 return하여 Action에서 Forward한다.
//		return list;
	}

	// detailPostAction (Post 내용 보기)
	public void detailPostActionService(HttpServletRequest request, HttpServletResponse response)throws IOException {
		HttpSession session = request.getSession();

		// PostDTO에 있는 p_no를 가지고 온다.
		int p_no = (Integer)session.getAttribute("p_no");

		// postDTO에 mapping할 메소드를 넣는다.
		PostDTO postDTO = dao.detailPost(p_no);

		// DdateDTO에 Mapping할 메소드를 넣는다.
		DdateDTO ddateDTO = dao.DdateInfo(p_no);

		// d_day에 set한다.
//		request.setAttribute("DdateDTO", ddateDTO);

		// postDTO를 return하여 Action에서 Forward한다.
//		return postDTO;
		
		JSONArray jsonarr = new JSONArray();
		jsonarr.add(postDTO);
//		jsonarr.add(JSONArray.fromObject(postDTO));
//		jsonarr.add(JSONArray.fromObject(ddateDTO)); 
		jsonarr.add(ddateDTO);
		
		response.setCharacterEncoding("utf-8");
//		System.out.println(jsonarr.toString());
		response.getWriter().print(jsonarr.toString());
		
	}

	// updatePostFormAction (Post 내용 수정 Form 이동)
	public PostDTO updatePostFormActionService(HttpServletRequest request) {
		HttpSession session = request.getSession();
		// p_no를 가져온다.
		int p_no = (Integer)session.getAttribute("p_no");

		// postDTO에 담는다.
		PostDTO postDTO = dao.detailPost(p_no);

		// postDTO를 return하여 Action에서 Form으로 Forward한다.
		return postDTO;
	}

	// updatePostAction (Post 내용 수정)
	public void updatePostActionService(HttpServletRequest request) {

		PostDTO postDTO = new PostDTO();
		HttpSession session = request.getSession();
		// 수정된 내용의 번호를 set한다.
		postDTO.setP_no((Integer)session.getAttribute("p_no"));

		// 수정된 내용의 제목을 set한다.
		postDTO.setP_title(request.getParameter("update_title"));

		// Mapping한다.
		dao.updatePost(postDTO);

	}

	// updateDdateAction (마감일 내용 수정)
	public void updateDdateActionService(HttpServletRequest request, HttpServletResponse response) {

		DdateDTO ddateDTO = new DdateDTO();

		HttpSession session = request.getSession();
		
		int p_no = (Integer)session.getAttribute("p_no");
		
		ddateDTO.setP_no(p_no);
		
		ddateDTO.setD_date(request.getParameter("update_Ddate"));
		
		
		if (dao.detailDdate(p_no) != null) {
			
			ddateDTO.setD_date(request.getParameter("update_Ddate"));

			dao.updateDdate(ddateDTO);
			
		} else {

			// 해당 Post에 Mapping한다.
			dao.DdateInsertPost(ddateDTO);
		}
		
	}

	// updateDdateFormAction (Ddate 수정 Form 이동)
	public DdateDTO updateDdateFormActionService(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		
		// p_no를 가져온다.
		int p_no = (Integer)session.getAttribute("p_no"); 
		// DdateDTO에 담는다.
		DdateDTO ddateDto = dao.detailDdate(p_no);

		// DdateDTO를 return하여 Action에서 Form으로 Forward한다.
		return ddateDto;
	}

	// deletePostAction (Post 내용 삭제)
	public void deletePostActionService(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		// 삭제할 postDTO의 p_no를 가져온다.
		int p_no = (Integer)session.getAttribute("p_no");

		// Mapping한다.
		dao.deletePost(p_no);
	}
	
	// deleteDdateAction (마감일 삭제)
	public void deleteDdateActionService(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		
		// 삭제할 p_no 가져온다.
		int p_no = (Integer)session.getAttribute("p_no");
		
		// 삭제할 메소드 Mapping
		dao.deleteDdate(p_no);
	}
	

	// list에 회원 이름, 이메일 담기 //card 정보 추가 json처
	public void listMemberService(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session = request.getSession();

		// Project에 포함될 인원을 담아야 하기 때문에 프로젝트 번호를 가져온다.
		int pjt_no = (Integer)session.getAttribute("pjt_no"); 
		System.out.println(pjt_no);

		// list에 Mapping할 메소드를 담는다.
		List<MemberDTO> list = dao.listMember(pjt_no);
		
		JSONArray jsonarr = new JSONArray();
		jsonarr.add(JSONArray.fromObject(list));
//		response.getWriter().print(jsonarr.toString());
		
		List<CardDTO> list2 = dao.card_info(pjt_no);
//
		jsonarr.add(JSONArray.fromObject(list2));
//		System.out.println(jsonarr.toString());
		response.setCharacterEncoding("utf-8");
		response.getWriter().print(jsonarr.toString());
		// list를 return하여 Action에서 Set 후 Forward 한다.
//		return list;
	}

//	// list에 card 이름, 위치 담기 
//	public void cardInfoService(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		HttpSession session = request.getSession();
//		int pjt_no = (Integer)session.getAttribute("pjt_no");
//		// 프로젝트에 포함된 card 목록을 가져오기 위해 list에 담는다.
//		List<CardDTO> list = dao.card_info(pjt_no);
//		
//		JSONArray jsonarr = new JSONArray();
//		jsonarr.add(JSONArray.fromObject(list));
//		System.out.println(jsonarr.toString());
//		response.getWriter().print(jsonarr.toString());
//		// list를 return하여 Action에서 set 후 Forward 한다.
////		return list;
//
//	}

	// Post 내부에 담당자를 출력하기
	public List<PostMemberDTO> PostMemberListService(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session = request.getSession();
		// p_no에 포함된 담당자를 가져와야 한다.
		int p_no = (Integer)session.getAttribute("p_no");

		// 가져온 p_no를 mapping하여 list에 담는다.
		List<PostMemberDTO> list = dao.PostMemberlist(p_no);

		// list를 return하여 Action에서 set 후 Forward 한다.
		return list;
	}

	// 현재날짜를 insertForm에 가져가기
	public DdateDTO DateInfoService(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		
		int p_no = (Integer)session.getAttribute("p_no");

		DdateDTO ddateDTO = dao.DdateInfo(p_no);

		return ddateDTO;
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
	public void descriptionDetailService(HttpServletRequest request, HttpServletResponse response)throws Exception{
		//session 에서pno 정보 받아서 설명 출력
		HttpSession session = request.getSession();
		
		int p_no=(Integer)session.getAttribute("p_no");
		DescriptionDTO detail = dao.descriptionDetail(p_no);
//		request.setAttribute("p_no", p_no);
//		request.setAttribute("detail", detail);
		
		JSONArray jsonarr = new JSONArray();
		jsonarr.add(detail);
		response.setCharacterEncoding("utf-8");
		response.getWriter().print(jsonarr.toString());
		
//		return detail;
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
		reply.setP_no(2);
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
		int p_no =2;
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
	
	public void PostDragService(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession(); 
		
		// p_no를 session에서 가져온다.
		int p_no = (Integer)session.getAttribute("p_no");
		
		// 옮긴 후의 card no를 가져와야 함
		int new_c_no = Integer.parseInt(request.getParameter("new_c_no"));
		System.out.println(new_c_no);
		// 옮기기 전의 card no를 가져온다.
		int old_c_no = Integer.parseInt(request.getParameter("old_c_no"));
		System.out.println(old_c_no);
		// 객체 생성
		PostDragDTO postDragDTO = new PostDragDTO();
		
		// 가져온 값을 set
		postDragDTO.setP_no(p_no);
		postDragDTO.setNew_c_no(new_c_no);
		postDragDTO.setOld_c_no(old_c_no);
		
		// mapping 한다.
		dao.dragPost(postDragDTO);
		
	}
	
}

