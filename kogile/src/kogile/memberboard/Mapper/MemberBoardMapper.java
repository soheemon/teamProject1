package kogile.memberboard.Mapper;

import java.util.List;

import kogile.memberboard.Service.MemberBoard;
import kogile.memberboard.Service.MemberSearch;


public interface MemberBoardMapper {

	List<MemberBoard> memberBoard(MemberSearch search);
	List<MemberBoard> memberBoard2(MemberSearch search);
	
	int insertMemberBoard(MemberBoard board);
}
