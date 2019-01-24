package kogile.post.Service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import kogile.post.DAO.PostDao;
import kogile.post.DTO.DescriptionDTO;

public class insertDescriptionAjax implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String requestBody = getBody(request, response);
		JSONParser jsonParser = new JSONParser();
		JSONObject jsonData = (JSONObject) jsonParser.parse(requestBody);
		
		String desContents = (String)jsonData.get("desContents");
		DescriptionDTO description = new DescriptionDTO();
		//설명내용 받아와 셋팅
		description.setD_contents(desContents);
		//훗날 수정필요 >> 포스트 넘버 받아와 셋팅
		description.setP_no(1);
		PostDao dao = PostDao.getInstance();
		
		dao.insertDescription(description);
		
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
