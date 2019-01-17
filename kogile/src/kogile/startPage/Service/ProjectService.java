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
	
	public void insertProjectService(HttpServletRequest request)throws Exception{
		ProjectBoard pb = new ProjectBoard();
		pb.setTotal_m_no(3);
		pb.setPjt_title(request.getParameter("title"));
		pb.setPjt_contents(request.getParameter("contents"));
		
		dao.insertBoard(pb);
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
