package kogile.post.Model;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.apache.ibatis.type.IntegerTypeHandler;

public class PostService {

	// static으로 DAO 객체 생성 준비
	public static PostDao dao;

	// static으로 Service 객체 생성
	public static PostService service = new PostService();
	

	// 싱클톤으로 생성하여 PostService.getInstance를 호출하면 dao 호출과 동시에 service를 return한다.
	public static PostService getInstance() {
		dao = PostDao.getInstance();
		return service;
	}

	// insertPostAction (Post 데이터 삽입)
	public void insertPostActionService(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PostDTO postDTO = new PostDTO();

		// insertForm에서 입력한 제목을 PostDTO에 담는다.
		postDTO.setP_title(request.getParameter("p_title"));
		
		// Card의 선택한 위치를 가져와서 set 한다.
		postDTO.setC_no(Integer.parseInt(request.getParameter("pjt_card")));
		
		// Mapping한다.
		dao.insertPost(postDTO);

		// 최근에 생성된 Post의 p_no를 가져오는 작업
		int p_no = dao.selectPost();

		// insertForm에서 체크한 담당자들을 chargeDTO를 통해 담는 과정
		ChargeDTO chargeDTO = new ChargeDTO();

		// checkbox에서 선택된 담당자들을 담는다.
		// String 배열에 선택한 member를 담는다.
		String[] supervisorStr = request.getParameterValues("pjt_member");

		// int 배열에 member들을 선언한다.
		int[] supervisors = new int[supervisorStr.length];

		// 받은 담당자들을 int로 형변환 시킨다.
		for (int i = 0; i < supervisorStr.length; i++) {
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

		// p_no를 객체에 담는다.
		ddateDTO.setP_no(p_no);

		// Form에 입력한 name을 입력한다.
		ddateDTO.setD_date(request.getParameter("DateInfo"));

		// 해당 Post에 Mapping한다.
		dao.DdateInsertPost(ddateDTO);
	}

	// listPostAction (Post 리스트 보기)
	public List<PostDTO> listPostActionService(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		HttpSession session = request.getSession();
		
		// session에 담긴 프로젝트를 가져온다.
		int pjt_no = (Integer)session.getAttribute("pjt_no");
		
		// 프로젝트를 set한다.
		request.setAttribute("pjt_no", pjt_no);
		
		// list에 Mapping할 메소드를 담는다.
		List<PostDTO> list = dao.listPost(pjt_no);

		// list를 return하여 Action에서 Forward한다.
		return list;
	}

	// detailPostAction (Post 내용 보기)
	public PostDTO detailPostActionService(HttpServletRequest request) {
		HttpSession session = request.getSession();

		// PostDTO에 있는 p_no를 가지고 온다.
		int p_no = (Integer)session.getAttribute("p_no");

		// postDTO에 mapping할 메소드를 넣는다.
		PostDTO postDTO = dao.detailPost(p_no);

		// DdateDTO에 Mapping할 메소드를 넣는다.
		DdateDTO ddateDTO = dao.DdateInfo(p_no);

		// 마감일 객체에 set한다.
		request.setAttribute("DdateDTO", ddateDTO);

		// postDTO를 return하여 Action에서 Forward한다.
		return postDTO;
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
		
		// p_no 세션에서 p_no를 불러온다.
		int p_no = (Integer)session.getAttribute("p_no");
		
		// 불러온 p_no를 객체에 set한다.
		ddateDTO.setP_no(p_no);
		
		// 수정 날짜를 가져와서 객체에 set한다.
		ddateDTO.setD_date(request.getParameter("update_Ddate"));
		
		// 만약 마감일에 상세보기 내용이 null이 아니라면(내용이 있다면) 
		if (dao.detailDdate(p_no) != null) {
			
			// 동일하게 수정 값을 객체에 넣는다.
			ddateDTO.setD_date(request.getParameter("update_Ddate"));

			// Mapping 한다.
			dao.updateDdate(ddateDTO);
			
		// 만약 Ddate에 내용이 없다면
		} else {

			// 해당 Post에 insert Mapping한다.
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

	// list에 회원 이름, 이메일 담기
	public List<MemberDTO> listMemberService(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session = request.getSession();

		// Project에 포함될 인원을 담아야 하기 때문에 프로젝트 번호를 가져온다.
		int pjt_no = (Integer)session.getAttribute("pjt_no"); 

		// list에 Mapping할 메소드를 담는다.
		List<MemberDTO> list = dao.listMember(pjt_no);

		// list를 return하여 Action에서 Set 후 Forward 한다.
		return list;
	}
	
	// list에 card 이름, 위치 담기
	public List<CardDTO> cardInfoService(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// 프로젝트에 포함된 card 목록을 가져오기 위해 list에 담는다.
		List<CardDTO> list = dao.card_info();

		// list를 return하여 Action에서 set 후 Forward 한다.
		return list;

	}

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
		
		// session에 p_no를 가져온다.
		int p_no = (Integer)session.getAttribute("p_no");

		// 객체에 Mapping한다.
		DdateDTO ddateDTO = dao.DdateInfo(p_no);

		// 객체를 return한다.
		return ddateDTO;
	}
}
