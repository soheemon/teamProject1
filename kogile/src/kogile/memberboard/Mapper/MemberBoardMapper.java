package kogile.memberboard.Mapper;

import java.util.List;

import kogile.invitelist.Service.InviteList;
import kogile.memberboard.Service.MemberBoard;
import kogile.memberboard.Service.MemberSearch;
import kogile.notice.Service.Notice;


public interface MemberBoardMapper {

	List<MemberBoard> memberBoard(MemberSearch search);
	List<MemberBoard> memberBoard2(MemberSearch search);
	
	int insertMemberBoard(MemberBoard board);
	InviteList selectInvite(int no);
	int insertNotice(Notice notice);
}
