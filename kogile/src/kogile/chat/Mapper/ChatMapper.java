package kogile.chat.Mapper;


import java.util.List;

import kogile.chat.DTO.ChatDTO;
import kogile.startPage.DTO.ProjectBoard;

public interface ChatMapper {
	int insertChat(ChatDTO chat);
	List<ChatDTO> listChat();
}
