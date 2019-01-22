package kogile.memberboard.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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
	
	public int insertMemberBoardService(HttpServletRequest request){
		MemberBoard board = new MemberBoard();
		
		board.setNo(Integer.parseInt(request.getParameter("no")));
		board.setPjt_no(Integer.parseInt(request.getParameter("pjt_no")));
		
		return dao.insertMemberBoard(board);
		
	}
	/*
	public InviteList inviteListService(HttpServletRequest request){
		//int inv_no = Integer.parseInt(request.getParameter("inv_no"));

		int inv_no = 80;
		
		InviteList invite = dao.selectInvite(inv_no);

		request.setAttribute("invite", invite);
		invite.getNo();
		invite.getInv_no();
		
		
		return invite;
		
	}*/
	
	public int insertNoticeService(HttpServletRequest request){
		
		int inv_no = 80;
		
		InviteList invite = dao.selectInvite(inv_no);

		request.setAttribute("invite", invite);
		invite.getNo();
		invite.getInv_no();
		System.out.println("invite.getNo값 : "  + invite.getNo() +"\t" + "invite.getInv_no값 : "  + invite.getInv_no());
		
		Notice notice = new Notice();
		
		//request.getAttribute("invite");
		//System.out.println("getAttribute : " + request.getAttribute("invite"));
		
		notice.setNo(invite.getNo());
		notice.setInv_no(invite.getInv_no());
		System.out.println("서비스 notice" + notice);
		
		return dao.insertNotice(notice);
	}
}
