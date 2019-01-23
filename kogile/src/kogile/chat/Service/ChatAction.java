package kogile.chat.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChatAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward Forward = new ActionForward();
		Forward.setPath("chat.jsp");
		Forward.setRedirect(true);
		return Forward;
	}

}
