package kogile.interMem.Service;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kogile.interMem.DAO.InterMemDao;
import kogile.module.InterMember;

public class InterMemberInsertAction implements Action {

	private String redirectPath = "";
	private boolean isRedirect;
	
	static final boolean DEBUG = true;
	
	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String plainPassword = request.getParameter("password");
		
		String hassedPassword = Sha256Hash.sha256(plainPassword);
		
		if(DEBUG){System.out.println(hassedPassword);}
		
		InterMember member = new InterMember();
		
		if(DEBUG){System.out.println(member.toString());}
		member.setEmail(request.getParameter("email"));
		member.setMember_name(request.getParameter("name"));
		member.setPassword(hassedPassword);

		InterMemDao dao = InterMemDao.getInstance();
		dao.insertInterMember(member);
		
		System.out.println("회원가입 되었습니댱.");
		//세션에 ID 써주기.
		
		ActionForward forward = new ActionForward();
		forward.setPath(LoginPath.HOME);
		forward.setRedirect(true);
		
		return forward;
	}
}
