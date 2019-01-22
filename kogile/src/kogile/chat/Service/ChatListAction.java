package kogile.chat.Service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kogile.chat.DAO.ChatService;
import kogile.chat.Model.ChatDTO;
import kogile.chat.Service.Action;
import kogile.chat.Service.ActionForward;

public class ChatListAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ChatService cs = ChatService.getInstance();
		cs.listChatService(response);
		
		return null;
	}

}
