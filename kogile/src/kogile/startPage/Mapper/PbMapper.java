package kogile.startPage.Mapper;


import java.util.List;

import kogile.startPage.DTO.InviteDTO;
import kogile.startPage.DTO.ProjectBoard;

public interface PbMapper {
	int insertBoard(ProjectBoard pb);
	List<ProjectBoard> projectList();
	ProjectBoard mainDetail(int seq);
	int selectInvite();
	InviteDTO selectPjt();
	int insertInvite(InviteDTO invite);
	int insertPjt_Info(int invite_no);
	
}
