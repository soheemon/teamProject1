package kogile.example.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import kogile.Module.Description;
import kogile.Module.Reply;
import kogile.Module.ReplyUpdateSearch;

public interface PostMapper {
	//Description
	int insertDescription(Description description);
	Description descriptionList(int seq);
	int deleteDescription(Description description);
	int updateDescription(Description description);
	//Reply
	int insertReply(Reply reply);
	List<Reply> replyList(int seq);
	int deleteReply(Reply reply);
	Reply replyUpdateForm(Reply reply);
	Reply replyUpdateSearch(ReplyUpdateSearch search);
	int updateReply(Reply reply);
}
