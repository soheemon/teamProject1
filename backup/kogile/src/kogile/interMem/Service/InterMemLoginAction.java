package kogile.interMem.Service;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kogile.interMem.DAO.InterMemDao;
import kogile.module.InterMember;

/*
 * kogile 사이트 로그인 처리
 */

public class InterMemLoginAction implements Action {

	private String redirectPath = "";
	private boolean isRedirect;

	InterMemDao dao = InterMemDao.getInstance();
	
	static final boolean DEBUG = false;
	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		
		//이미 가입했는지 확인.
		String email = (String) request.getParameter("email");
		System.out.println("사용자가 입력한 이메일" + email);
		InterMember member = null;
		
		//가입 안했을때 예외처리
		if((member = isAlreadyMember(email)) == null) {
			System.out.println("아이디를 찾을 수 없습니다.");
			redirectPath = LoginPath.INTER_MEM_LOGIN; // loginForm으로 다시 이동.
			isRedirect = true;
		//회원목록에 id는 존재한다.
		}else {
			//가져온 member 정보로 id랑 비밀번호 일치하는지 확인.
			String plainPw = (String)request.getParameter("password");
			String hashedPw = Sha256Hash.sha256(plainPw);
			System.out.println("사용자 입력 비번" + hashedPw);
			
			if(member.getPassword().equals(hashedPw)){
				
				System.out.println("로그인 성공");
				int member_no = (int) member.getMember_no();
				System.out.println("내부멤버번호: " + member_no);
				int totalMemNum = totalMemNum(member_no);
				System.out.println(totalMemNum);
				session.setAttribute("total_m_no", totalMemNum);
				
				redirectPath = LoginPath.HOME;
				isRedirect = true;
			}else{
				System.out.println("아이디와 비밀번호를 확인해 주세요.");
				redirectPath = LoginPath.INTER_MEM_LOGIN; // loginForm으로 다시 이동.
				isRedirect = true;
			}
		}
		
		ActionForward forward = new ActionForward();
		
		forward.setPath(redirectPath);
		forward.setRedirect(isRedirect);
		return forward;
	}
	
	public InterMember isAlreadyMember(String email) {
		InterMember member = null; 
		member = dao.selectInterMember(email);
		return member;
	}
	
	public int totalMemNum(int member_no) {
		int totalNum = dao.selectTotalMemNumWithInMem(member_no);
		return totalNum;
		
	}
	
}
