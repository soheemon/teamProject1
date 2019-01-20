package com.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.dao.CheckListDao;


public class CheckListService {
	private static CheckListDao dao;
	private static CheckListService service = new CheckListService();
	private static final int PAGE_SIZE = 2;
	
	public static CheckListService getInstance(){
		dao = CheckListDao.getInstance();
		return service;
	}
	
//	----------------------------------------------------------------------------------------
	public Board detailBoardService(HttpServletRequest request)throws Exception{
		Board board = null;
		int checklist_no  = Integer.parseInt(request.getParameter("checklist_no"));
		System.out.println("checklist_no" + checklist_no);
		board = dao.detailBoard(checklist_no);
		
		return board;
	}
//	----------------------------------------------------------------------------------------
	public CheckListModel listBoardService(int requestPage, HttpServletRequest request) throws Exception{
		
		Search search = new Search();
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();

		if(request.getParameterValues("area") != null){
			session.removeAttribute("search");
			search.setArea(request.getParameterValues("area"));
			search.setSearchKey('%'+request.getParameter("searchKey")+'%');
			session.setAttribute("search", search);
		}
		else if((Search)session.getAttribute("search") != null){
			search = (Search)session.getAttribute("search");
		}
		
		int totalCount = dao.countBoard(search);
		
		int totalPageCount = totalCount/PAGE_SIZE;
		if(totalCount%PAGE_SIZE > 0){
			totalPageCount++;
		}
		
		int startPage = requestPage - (requestPage -1) % 5;
		int endPage = startPage + 4;
		if(endPage > totalPageCount){
			endPage = totalPageCount;
		}
		
		int startRow = (requestPage -1)* PAGE_SIZE;
		List<Board> list = dao.listBoard(search, startRow);
		CheckListModel listModel = new CheckListModel(list, requestPage, totalPageCount, startPage, endPage); 
		
		return listModel;
	}

//	----------------------------------------------------------------------------------------
	
}
