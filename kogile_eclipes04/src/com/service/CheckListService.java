package com.service;

import java.io.File;
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
		System.out.println("ok" + checklist_no);
		board = dao.detailBoard(checklist_no);
		
		return board;
	}

//	----------------------------------------------------------------------------------------
	
/*	public int insertBoardService(HttpServletRequest request)throws Exception{
		request.setCharacterEncoding("utf-8");
		
		// 파일 업로드(경로 파일크기, 인코등, 파일이름 중첩 정책) 
		String uploadPath = request.getRealPath("upload");
		int size = 20 *1024 *1024; // 20MB 
		
		MultipartRequest multi = 
				new MultipartRequest(request, uploadPath, size, "utf-8", new DefaultFileRenamePolicy());
		
		Board board = new Board();
		board.setContents(multi.getParameter("contents"));
		board.setTitle(multi.getParameter("title"));
		board.setWriter(multi.getParameter("writer"));
		
		// 파일 업로드시 
		if(multi.getFilesystemName("fname") != null){
			String fname = multi.getFilesystemName("fname");
			board.setFname(fname);
			
			// 썸네일 이미지(jpg, gif) aaa.gif -> aaa_small.gif
			String pattern = fname.substring(fname.indexOf(".")+1);//gif
			String headName = fname.substring(0, fname.indexOf(".")); //aaa.gif
			
			// 원본 File 객체 생성 
			String imagePath = uploadPath + "\\" + fname; 
			File src = new File(imagePath); // 원본 파일 이미지 만듬 
			
			// 썸네일 이미지 File 객체 
			String thumImagePath = uploadPath + "\\" + headName + "_small." + pattern; 
			File dest = new File(thumImagePath); 
			
			if(pattern.equals("gif")||pattern.equals("jpg")||pattern.equals("png")){
				ImageUtil.resize(src, dest, 100, ImageUtil.RATIO);
			}
			
		}
		return dao.insertBoard(board);
	}*/
	
//	----------------------------------------------------------------------------------------
	public ListModel listBoardService(int requestPage, HttpServletRequest request) throws Exception{
		
		Search search = new Search();
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();

		// 검색시 
		if(request.getParameterValues("area") != null){
			session.removeAttribute("search");
			search.setArea(request.getParameterValues("area"));
			search.setSearchKey('%'+request.getParameter("searchKey")+'%');
			session.setAttribute("search", search);
		}
		// 검색후 페이징 클릭 
		else if((Search)session.getAttribute("search") != null){
			search = (Search)session.getAttribute("search");
		}
		
		// 페이지당 글갯수, 총 글갯수, 총페이지수, 현재페이지
		// 시작페이지, 마지막페이지 , startRow, endRow 
		
		// 총글갯수 구하기 
		int totalCount = dao.countBoard(search);
//		System.out.println("갯수:" + totalCount);
		
		// 총페이지수 구하기 
		int totalPageCount = totalCount/PAGE_SIZE;
		if(totalCount%PAGE_SIZE > 0){
			totalPageCount++;
		}
//		System.out.println("페이지갯수:" + totalPageCount);
		
		// 시작페이지, 마지막페이지 구하기 
		// 시작페이지 = 현재페이지 - (현재페이지 -1) % 5
		int startPage = requestPage - (requestPage -1) % 5;
		int endPage = startPage + 4;
		if(endPage > totalPageCount){
			endPage = totalPageCount;
		}
		
		// startRow 시작글 구하기 : (현재페이지 -1) * 페이지당 글갯수 
		int startRow = (requestPage -1)* PAGE_SIZE;
		List<Board> list = dao.listBoard(search, startRow);
//		System.out.println("글갯수: " + list.size());
		ListModel listModel = new ListModel(list, requestPage, totalPageCount, startPage, endPage); 
		
		return listModel;
	}
	
	

	
	
	

}
