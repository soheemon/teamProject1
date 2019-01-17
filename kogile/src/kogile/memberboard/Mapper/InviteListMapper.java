package kogile.memberboard.Mapper;

import java.util.List;

import kogile.memberboard.Service.InviteList;

public interface InviteListMapper {
	List<InviteList> inviteList(int pjt_no);
	List<InviteList> inviteList2(int pjt_no);
	
}
