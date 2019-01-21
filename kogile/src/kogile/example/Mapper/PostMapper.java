package kogile.example.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import kogile.Module.DescriptionDTO;
import kogile.Module.ReplyDTO;
import kogile.Module.ReplyMemberDTO;
import kogile.Module.ReplyUpdateSearchDTO;
import kogile.Module.TagDTO;

public interface PostMapper {
	//Description
	int insertDescription(DescriptionDTO description);
	DescriptionDTO descriptionList(int seq);
	int deleteDescription(DescriptionDTO description);
	int updateDescription(DescriptionDTO description);
	//Reply
	int insertReply(ReplyDTO reply);
	List<ReplyDTO> replyList(int seq);
	int deleteReply(ReplyDTO reply);
	ReplyDTO replyUpdateForm(ReplyDTO reply);
	ReplyDTO replyUpdateSearch(ReplyUpdateSearchDTO search);
	int updateReply(ReplyDTO reply);
	
	List<ReplyMemberDTO> replyMemberList(int seq);
	List<ReplyMemberDTO> replyMemberList2(int seq);
	
	//Tag
	int insertTag(TagDTO tag);
	int replyNum();
	List<TagDTO> tagMember(int seq);
	List<TagDTO> tagMember2(int seq);
	//태그된 사람에게 알림보내기
	int insertTagNotice(TagDTO tag);
	int tagNum();
	int tag_total_m_no(TagDTO tag);
}
