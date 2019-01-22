package kogile.project.DAO;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kogile.project.DAO.ProjectDAO;
import kogile.project.Model.ProjectDTO;
import net.sf.json.JSONArray;

public class ProjectService {
	private static ProjectDAO dao;
	private static ProjectService service = new ProjectService();

	public static ProjectService getInstance() {
		dao = ProjectDAO.getInstance();
		return service;
	}

	public void insertProjectService(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ProjectDTO pb = new ProjectDTO();
		pb.setTotal_m_no(3);
		pb.setPjt_title(request.getParameter("pjt_title"));
		pb.setPjt_contents(request.getParameter("pjt_contents"));
		System.out.println(pb.toString());
		dao.insertBoard(pb);

		List<ProjectDTO> list = dao.listBoard();

		JSONArray jsonArr = new JSONArray();
		jsonArr = JSONArray.fromObject(list);
		System.out.println(jsonArr.toString());
		response.getWriter().print(jsonArr.toString());
	}

	public List<ProjectDTO> listProjectService(HttpServletRequest request, HttpServletResponse response)throws IOException{
		List<ProjectDTO> list = dao.listBoard();
		
//		JSONArray jsonArr = new JSONArray();
//		jsonArr = JSONArray.fromObject(list);
//		System.out.println(jsonArr.toString());
//		response.getWriter().print(jsonArr.toString());
		
		return list;
	}

	public ProjectDTO detailProjectService(HttpServletRequest request) {
		HttpSession session = request.getSession();

		ProjectDTO pb = new ProjectDTO();
		int pjt_no = (Integer) session.getAttribute("pjt_no");

		return dao.mainDetail(pjt_no);
	}

}
