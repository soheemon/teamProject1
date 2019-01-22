package kogile.chat.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kogile.chat.DAO.ChatService;
import kogile.chat.Service.Action;
import kogile.chat.Service.ActionForward;

public class ChatInsertAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ChatService cs =ChatService.getInstance();
		cs.insertChatService(request);

		
		return null;
	}

}
