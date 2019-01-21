package kogile.kakaoOauth.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kogile.interMem.DAO.InterMemDao;
import kogile.module.IsInterMem;
import kogile.module.TotalMemInfo;

public class TotalMemInfoSelectAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TotalMemNo로 사용자를 조회한다.
		IsInterMem memberNum = null;
		InterMemDao dao = InterMemDao.getInstance();
		memberNum = dao.IsInterMember(11);
		
		TotalMemInfo memInfo = null;
		//일반회원에 해당
		if(memberNum.getMember_no() != null) {
			int num = Integer.parseInt(memberNum.getMember_no());
			memInfo = dao.interMemSearch(num);
		}else {
			int num = Integer.parseInt(memberNum.getExter_m_no());
			memInfo = dao.exterMemSearch(num);
		}
		
		System.out.println("이름:" + memInfo.getMember_name());
		System.out.println("이메일:" + memInfo.getMember_email());
		return null;
	}

}
