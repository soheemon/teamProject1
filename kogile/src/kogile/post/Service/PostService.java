package kogile.post.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kogile.post.Dao.PostDao;
import kogile.post.Model.LabelDTO;
import kogile.post.Model.LabelInfoDTO;

public class PostService {
	private static PostService service = new PostService();
	private static PostDao dao;
	
	public static PostService getInstance() {
		dao = PostDao.getInstance();
		
		return service;
	}
	
	public List<LabelDTO> listlabel(HttpServletRequest request, HttpServletResponse response)throws Exception{
		HttpSession session = request.getSession();
//		int pjt_no = (Integer)session.getAttribute("pjt_no");
		int p_no = (Integer)session.getAttribute("p_no");
		int pjt_no = dao.searchpjt(p_no);
		
		List<LabelDTO> list = dao.listlabel(pjt_no);
		
		return list;
	}
	
	public void insertLabelService(HttpServletRequest request, HttpServletResponse response)throws Exception{
		HttpSession session = request.getSession();
		
		LabelDTO label = new LabelDTO();
		
		int p_no = (Integer)session.getAttribute("p_no");
		
		label.setColor_no(Integer.parseInt(request.getParameter("label_color")));
		label.setLabel_text(request.getParameter("label_text"));
		label.setPjt_no(dao.searchpjt(p_no));
		dao.insertlabel(label);
	}
	
	public void deleteLabelService(HttpServletRequest request, HttpServletResponse response)throws Exception {
		LabelDTO label = new LabelDTO();
//		String text = request.getParameter("label_text");
//		int color_no = Integer.parseInt(request.getParameter("color_no"));
		
		int label_no = Integer.parseInt(request.getParameter("label_no"));
		label.setLabel_no(label_no);
		
		dao.deletelabel(label);
	}
	
	
	public void updateLabelService(HttpServletRequest request, HttpServletResponse response)throws Exception{
		LabelDTO label = new LabelDTO();
		int label_no = Integer.parseInt(request.getParameter("label_no"));
		String label_text = request.getParameter("label_text");
		int color_no = Integer.parseInt(request.getParameter("color_no"));
		
		label.setLabel_no(label_no);
		label.setLabel_text(label_text);
		label.setColor_no(color_no);
		
		dao.updateLabel(label);
	}
	
	public LabelDTO updateLabelFormService(HttpServletRequest request, HttpServletResponse response)throws Exception {
		int label_no = Integer.parseInt(request.getParameter("label_no"));
		LabelDTO label = dao.searchLabel(label_no);
		
		return label;
	}
	
	public List<LabelDTO> postDetailViewService(HttpServletRequest request, HttpServletResponse response)throws Exception{
		
		HttpSession session = request.getSession();
		
		int p_no = (Integer)session.getAttribute("p_no");
		
		if(request.getParameter("label_no") != null) {
			int label_no = Integer.parseInt(request.getParameter("label_no"));
			LabelInfoDTO label_info = new LabelInfoDTO();
			label_info.setLabel_no(label_no);
			label_info.setP_no(p_no);
			
			dao.insertLabelInfo(label_info);
		}
		
		List<LabelDTO> list = dao.detialviewlabel(p_no);
		
		
		return list;
	}
	
	public void deleteLabelInfoService(HttpServletRequest request, HttpServletResponse response)throws Exception{
		HttpSession session = request.getSession();
		
		LabelInfoDTO label_info = new LabelInfoDTO();
		int label_no = Integer.parseInt(request.getParameter("label_no"));
		int p_no = (Integer)session.getAttribute("p_no");
		
		
		label_info.setLabel_no(label_no);
		label_info.setP_no(p_no);
		dao.deleteLabelInfo(label_info);
	}
	
	
	
}
