package kogile.kakaoOauth.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kogile.kakaoOauth.DAO.KaKaoDao;
import kogile.module.ExterMember;

import kogile.module.ExterMember.interlinked_type;

public class kakaoInsertMemberAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		//세션에 kakaoId가 있습니다.
		//form에서 건네받은 parameter로는 id와 email이 있습니다.
		//이거를 합쳐서 가입을 시켜야 합니다.
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		int kakaoId = (int) session.getAttribute("kakaoId");
		System.out.println(kakaoId);
		System.out.println(request.getParameter("name"));
		System.out.println(request.getParameter("email"));

		ExterMember member = new ExterMember();
		member.setExter_m_email(request.getParameter("email"));
		member.setExter_mem_name(request.getParameter("name"));
		member.setType(ExterMember.interlinked_type.KAKAO); // kakao
		member.setInterlinked_info((int) session.getAttribute("kakaoId"));

		KaKaoDao dao = KaKaoDao.getInstance();
		dao.insertExterMember(member);
		
		return null;
	}
}
