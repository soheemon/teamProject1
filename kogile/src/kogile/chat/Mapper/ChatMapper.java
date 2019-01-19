package kogile.chat.Mapper;


import java.util.List;

import kogile.chat.DTO.ChatDTO;
import kogile.project.DTO.ProjectDTO;

public interface ChatMapper {
	int insertChat(ChatDTO chat);
	List<ChatDTO> listChat();
}
