package kogile.post.Mapper;

import java.util.List;

import kogile.post.DTO.DescriptionDTO;
import kogile.post.DTO.ReplyDTO;
import kogile.post.DTO.ReplyMemberDTO;
import kogile.post.DTO.ReplyUpdateSearchDTO;
import kogile.post.DTO.TagDTO;
import kogile.post.Model.CardDTO;
import kogile.post.Model.ChargeDTO;
import kogile.post.Model.DdateDTO;
import kogile.post.Model.MemberDTO;
import kogile.post.Model.PostDTO;
import kogile.post.Model.PostMemberDTO;
import kogile.project.Model.PostDragDTO;

public interface PostMapper {
	// post 삽입
	int insertPost(PostDTO postDTO);
	
	// 최근 post 구하기
	int selectPost();
	
	// project에 포함 된 사람 post까지 출력
	int chargeInfo(ChargeDTO chargeDTO);
	
	// list 보기
	List<PostDTO> listPost(int pjt_no);
	
	// post 상세보기
	PostDTO detailPost(int p_no); 
	
	// post 수정하기
	int updatePost(PostDTO postDTO);
	
	// post 삭제하기
	int deletePost(int p_no);
	
	// 회원 정보 구하기
	List<MemberDTO> inter_member(int pjt_no);
	List<MemberDTO> exter_member(int pjt_no);
	
	// card 정보 가져오기
	List<CardDTO> card_info(int pjt_no);
	
	// Post에 회원 정보 호출하기
	List<PostMemberDTO> post_inter_member(int p_no);
	List<PostMemberDTO> post_exter_member(int p_no);
	
	// insertForm 이동시 현재시간 구하기
	DdateDTO ddateInfo(int p_no);
	
	// Post에 Ddate insert하기
	int ddateInsertPost(DdateDTO ddateDTO);
	
	// 마감일 수정하기
	int updateDdate(DdateDTO ddateDTO);
	
	// 마감일 상세보기
	DdateDTO detailDdate(int p_no);
	
	// 마감일 삭제하기
	int deleteDdate(int p_no);
	
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
	int dragPost(PostDragDTO postDragDTO);
}

