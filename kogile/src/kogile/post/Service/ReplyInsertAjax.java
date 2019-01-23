package kogile.post.Service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import kogile.post.DAO.PostDao;
import kogile.post.DTO.ReplyDTO;
import kogile.post.DTO.TagDTO;

public class ReplyInsertAjax implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String requestBody = getBody(request, response);
		JSONParser jsonParser = new JSONParser();
		JSONObject jsonData = (JSONObject) jsonParser.parse(requestBody);
		HttpSession session = request.getSession();
		
		//댓글작성 서비스 호출
		ReplyDTO reply = new ReplyDTO();
		int p_no = (Integer)session.getAttribute("p_no");
		int info_no = Integer.parseInt((String)jsonData.get("info_no"));

		reply.setP_no(p_no);
		reply.setR_contents((String)jsonData.get("r_contents"));
		reply.setInfo_no(info_no);

		PostDao dao = PostDao.getInstance();
		dao.insertReply(reply);
		
		//태그 처리 
		String tagInfoTmp = (String)jsonData.get("t.info_no");
		if(tagInfoTmp != null && tagInfoTmp.length() > 0) {
			TagDTO tag = new TagDTO();
			int replyNum = dao.replyNum();
			tag.setR_no(replyNum);
			
			int start = tagInfoTmp.indexOf('.');
			String tagInfo = tagInfoTmp.substring(start + 1, tagInfoTmp.length());
			tag.setInfo_no(Integer.parseInt(tagInfo));
			dao.insertTag(tag);
			
			//Notice
			TagDTO tag2 = new TagDTO();
			int tagNum = dao.tagNum();
			tag2.setTag_no(tagNum);
			tag2.setInfo_no(Integer.parseInt(tagInfo));
			
			int tag_total_m_no = dao.tag_total_m_no(tag2);
			tag2.setTotal_m_no(tag_total_m_no);
			dao.insertTagNotice(tag2);
			
		}
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
