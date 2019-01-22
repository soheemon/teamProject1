package kogile.project.Mapper;


import java.util.List;

import kogile.project.Model.InviteDTO;
import kogile.project.Model.ProjectDTO;

public interface ProjectMapper {
	int insertBoard(ProjectDTO pb);
	List<ProjectDTO> projectList();
	ProjectDTO mainDetail(int seq);
	int selectInvite();
	InviteDTO selectPjt();
	int insertInvite(InviteDTO invite);
	int insertPjt_Info(int invite_no);
	int insertCard(int pjt_no);
	
}
