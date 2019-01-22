package kogile.chat.Mapper;


import java.util.List;

import kogile.chat.Model.ChatDTO;
import kogile.project.Model.ProjectDTO;

public interface ChatMapper {
	int insertChat(ChatDTO chat);
	List<ChatDTO> listChat();
}
