package kogile.post.Service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import kogile.post.DAO.PostDao;
import kogile.post.DTO.ReplyDTO;

public class ReplyUpdateAjax implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String requestBody = getBody(request, response);
		System.out.println(requestBody);
		JSONParser jsonParser = new JSONParser();
		JSONObject jsonData = (JSONObject) jsonParser.parse(requestBody);
		
		//댓글작성 서비스 호출
		
		int r_no = Integer.parseInt((String)jsonData.get("r_no"));
		int info_no = Integer.parseInt((String)jsonData.get("info_no"));
		String r_contents = (String)jsonData.get("r_contents");
		
		ReplyDTO reply = new ReplyDTO();
		reply.setInfo_no(info_no);
		reply.setR_no(r_no);
		reply.setR_contents(r_contents);
		
		PostDao dao = PostDao.getInstance();
		dao.updateReply(reply);
		
		return null;
	}
	public static String getBody(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String body = "";
		StringBuilder stringBuilder = new StringBuilder();
		BufferedReader bufferedReader = null;
		
		try {
			InputStream inputStream = request.getInputStream();
			if(inputStream != null) {
				bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
				char[] charBuffer = new char[128];
				int bytesRead = -1;
				while((bytesRead = bufferedReader.read(charBuffer)) > 0) {
					stringBuilder.append(charBuffer, 0, bytesRead);
				}
			} else {
				stringBuilder.append("");
			}
		}catch (Exception e) {
			// TODO: handle exception
		}finally {
			if(bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (Exception e2) {
					throw e2;
				}
			}
		}
		body = stringBuilder.toString();
		return body;
	}
}
