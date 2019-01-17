package kogile.startPage.Service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import kogile.startPage.DAO.ProjectBoardDao;
import kogile.startPage.DTO.ProjectBoard;

public class ProjectService {
	private static ProjectBoardDao dao;
	private static ProjectService service = new ProjectService();
	
	public static ProjectService getInstance(){
		dao = ProjectBoardDao.getInstance();
		return service;
	}
	
	public int insertProjectService(HttpServletRequest request) {
		ProjectBoard pb = new ProjectBoard();
		pb.setPjt_writer(request.getParameter("writer"));
		pb.setPjt_title(request.getParameter("title"));
		pb.setPjt_contents(request.getParameter("contents"));
		
		return dao.insertBoard(pb);
	}
	
	public List<ProjectBoard> listProjectService(HttpServletRequest request){
		List<ProjectBoard> list = dao.listBoard();
		return list;	
	}

	public ProjectBoard mainDetailService(HttpServletRequest request) {
		ProjectBoard pb = new ProjectBoard();
		int seq=Integer.parseInt(request.getParameter("seq"));
		
		return dao.mainDetail(seq);
	}
	
}
