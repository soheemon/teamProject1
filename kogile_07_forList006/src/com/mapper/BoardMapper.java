package com.mapper;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.service.Board;
import com.service.Search;

public interface BoardMapper {
	int insertchecklist(Board board);
	int insertlist(Board board);
	
	List<Board> listBoard(RowBounds row, Search search);
	List<Board> listBoard20(RowBounds row, Search search);
	
	int countBoard(Search search);
	int countBoard20(Search search);

	Board detailBoard(int checklist_no);
	Board detailBoard20(int list_no);
	
	int updateBoard(Board board);
	int updateBoard20(Board board);
	
	int deleteBoard(Board board);
	int deleteBoard20(Board board);

	
	
	/*
	 * 	List<Board> listBoard(Search search);
	 * List<Board> listBoard(RowBounds row, Search search);
		
	*/
	
}
