package kogile.post.Mapper;

import java.util.List;

import kogile.post.Model.LabelDTO;
import kogile.post.Model.LabelInfoDTO;

public interface PostLabelMapper {
	List<LabelDTO> labellist(int pjt_no);
	int insertlabel(LabelDTO label);
	int deletelabel(LabelDTO label);
	int updatelabel(LabelDTO label);
	LabelDTO searchlabel(int label_no);
	int searchpjt(int p_no);
	List<LabelDTO> detialviewlabel(int p_no);
	int insertLabelInfo(LabelInfoDTO label_info);
	int deleteLabelInfo(LabelInfoDTO label_info);
}
