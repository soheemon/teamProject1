package kogile.checklist.Mapper;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import kogile.checklist.Service.Board;
import kogile.checklist.Service.Search;

public interface CheckListMapper {
	int insertchecklist(Board board);
	
	int insertchecklist1();
	
	
	List<Board> listBoard(RowBounds row, Search search);
	
}
