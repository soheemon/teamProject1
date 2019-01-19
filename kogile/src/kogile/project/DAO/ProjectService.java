package kogile.project.DAO;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kogile.project.DAO.ProjectDAO;
import kogile.project.DTO.ProjectDTO;

public class ProjectService {
	private static ProjectDAO dao;
	private static ProjectService service = new ProjectService();
	
	public static ProjectService getInstance(){
		dao = ProjectDAO.getInstance();
		return service;
	}
	
	public void insertProjectService(HttpServletRequest request)throws Exception{
		ProjectDTO pb = new ProjectDTO();
		pb.setTotal_m_no(3);
		pb.setPjt_title(request.getParameter("title"));
		pb.setPjt_contents(request.getParameter("contents"));
		
		dao.insertBoard(pb);
	}
	
	public List<ProjectDTO> listProjectService(HttpServletRequest request){
		List<ProjectDTO> list = dao.listBoard();
		return list;	
	}

	public ProjectDTO detailProjectService(HttpServletRequest request) {
		ProjectDTO pb = new ProjectDTO();
		int pjt_no = Integer.parseInt(request.getParameter("pjt_no"));
		
		return dao.mainDetail(pjt_no);
	}
	
}
