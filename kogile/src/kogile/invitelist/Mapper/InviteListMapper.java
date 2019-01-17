package kogile.invitelist.Mapper;

import java.util.List;

import kogile.invitelist.Service.InviteList;

public interface InviteListMapper {
	List<InviteList> inviteList(int pjt_no);
	List<InviteList> inviteList2(int pjt_no);
	
}
