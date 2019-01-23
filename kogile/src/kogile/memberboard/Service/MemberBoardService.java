package kogile.memberboard.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.omg.CORBA.DynAnyPackage.Invalid;

import kogile.invitelist.Service.InviteList;
import kogile.memberboard.DAO.MemberBoardDao;
import kogile.notice.Service.Notice;

public class MemberBoardService {
	private static MemberBoardService service = new MemberBoardService();
	private static MemberBoardDao dao;
	
	public static MemberBoardService getInstance() {
		dao = MemberBoardDao.getInstance();
		return service;
	}

	public int insertNoticeService(HttpServletRequest request){
		MemberBoard board = new MemberBoard();
		HttpSession session = request.getSession();
		int pjt_no = (Integer)session.getAttribute("pjt_no");
		
		board.setNo(Integer.parseInt(request.getParameter("no")));
		board.setPjt_no(pjt_no);
		System.out.println("board�� ���� �� : " + board);
		dao.insertMemberBoard(board);
		
		board.getNo();
		System.out.println("board.getNo : " + board.getNo());
		
		InviteList invite = dao.selectInvite(board.getNo());
		invite.setNo(board.getNo());
		request.setAttribute("invite", invite);
		System.out.println("invite �� : " + invite);
		invite.getNo();
		invite.getInv_no();
		System.out.println("invite.getNo�� : "  + invite.getNo() +"\t" + "invite.getInv_no�� : "  + invite.getInv_no());
		
		Notice notice = new Notice();

		notice.setNo(invite.getNo());
		notice.setInv_no(invite.getInv_no());
		System.out.println("���� notice" + notice);
		
		return dao.insertNotice(notice);
	}
}
