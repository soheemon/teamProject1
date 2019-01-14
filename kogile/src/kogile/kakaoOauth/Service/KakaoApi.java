package kogile.kakaoOauth.Service;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class KakaoApi {
	
	public enum HttpMethodType { POST, GET }
	
	private static final String API_SERVER_HOST  = "https://kapi.kakao.com";
	private static final String KAKAO_AUTH	= "https://kauth.kakao.com";
	private static final String OAUTH_PATH = "/oauth/authorize";
	private static final String OAUTH_TOKEN = "/oauth/token";
	private static final String APT_KEY = "e16764ac8ecc77d571c58088d37b119b";
	private static final String REDIRECT_URI = "/oauth_kakao";
	private static final String LOGOUT_URL ="/v1/user/logout";
	private static final String TOKEN_INFO = "/v1/user/access_token_info";
	
	public KakaoApi(){};
	
	HttpsURLConnection con = null;
	HttpServletRequest request = null;
	
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	private void closeOutStream(DataOutputStream out){

		if(out != null) {
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void discon(HttpsURLConnection con) {
		if(con != null) {
			con.disconnect();
		}
	}
	
	private void setAsTkenFromSession(String accessToken) {
		if(accessToken != null) {
			HttpSession session = request.getSession();
			session.setAttribute("access_token", accessToken);
		}
	}
	
	private String getAsTkenFromSession() {
		HttpSession session = request.getSession();
		String accessToken ="";
		if((accessToken = (String) session.getAttribute("access_token")) != null) {
			System.out.println("세션에 Access Token이 없습니다.");
		}
		return accessToken;
	}
	
	public void getAccessToken(String code) {
		String param =
				"grant_type=" + "authorization_code" + "&" +
	            "client_id=" + "e16764ac8ecc77d571c58088d37b119b" + "&" +
	            "redirect_uri=" +"http://localhost:8082/MVC/oauth_kakao" + "&" +
	            "code=" + code;
		
		System.out.println("파라미터" + param);
		System.out.println("URL" + KAKAO_AUTH + OAUTH_TOKEN);
		doRequest(HttpMethodType.POST, KAKAO_AUTH + OAUTH_TOKEN, param, true);
		//get code!
		JSONObject resResponse = null;
		resResponse = (JSONObject) getResponse();
		
		String accessToken = (String) resResponse.get("access_token");
		System.out.println(accessToken);
		
		setAsTkenFromSession(accessToken);

	}
	//AccessToken을 통해서 사용자 정보 가져오기.
	public void tokenValidationCk() {
		String accessToken = null;
		if((accessToken = getAsTkenFromSession()) == null) {
			System.out.println("로그인이 안되어있네요.");
			return;
		}
		
		HashMap<String, String> header = new HashMap<String, String>();
		header.put("Authorization", "Bearer " + accessToken);
		doRequest(HttpMethodType.GET, API_SERVER_HOST + TOKEN_INFO, header, false);
		JSONObject res = (JSONObject) getResponse();
		System.out.println(res.get("id"));
	}
	
	public void logOut() {
		String accessToken = null;
		if((accessToken = getAsTkenFromSession()) == null) {
			System.out.println("로그인이 안되어있네요.");
			return;
		}
		
		HashMap<String, String> header = new HashMap<String, String>();
		header.put("Authorization", "Bearer " + getAsTkenFromSession());
		doRequest(HttpMethodType.POST, API_SERVER_HOST + LOGOUT_URL, header, false);
		String res = (String) getResponse();
		System.out.println(res);
	}
	
	private void doRequest(HttpMethodType method, String url, Object param, boolean isBodyData) {
		
		URL reqestUrl = null;
		try {
			reqestUrl = new URL(url);
		} catch (MalformedURLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		try {
			con = (HttpsURLConnection) reqestUrl.openConnection();
			con.setRequestMethod(method.toString());
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		con.setDoOutput(true); // 서버로부터 메시지를 받을 수 있게 한다.
		con.setUseCaches(false);
		con.setDefaultUseCaches(false);
		con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		con.setRequestProperty("charset", "utf-8");
		
		//datatype이 Post일때 처리
		if (method.toString().equals(HttpMethodType.POST.toString())) {
			
			//데이터를 Body에 담아야 할때
			if(isBodyData){
				DataOutputStream out = null;
				try {
					out = new DataOutputStream(con.getOutputStream());
					out.writeBytes((String)param);
					out.flush();// 버퍼 비움. 전송!
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					closeOutStream(out);
				}
			}else {
				HashMap<String, String> header = (HashMap<String, String>)param;
			    for (String key : header.keySet()){
			        con.setRequestProperty(key, header.get(key));
			    }
			}
		}	
	}
	
	private String readAll(Reader rd) {
		StringBuilder sb = new StringBuilder();
		int cp;
		try {
			while ((cp = rd.read()) != -1) {
				sb.append((char) cp);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sb.toString();
	}
	
	private Object getResponse() {
		
		BufferedReader br = null;
		try {
			System.out.println(con.getResponseCode());
			System.out.println(con.getResponseMessage());
			System.out.println(con.getContentType());
			
			br = new BufferedReader(new InputStreamReader(con.getInputStream()));
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		String jsonText = readAll(br);
		System.out.println(jsonText);
		
		//데이터 타입이 json일때만.. 파싱
		Object obj = null; // 결과는 Object 형식으로 return 합니다.
		//1) Json일때 파싱해서 전달합니다.
		if(con.getContentType().equals("application/json;charset=utf-8")) {
			JSONParser parser = new JSONParser();
			
			try {
				obj = parser.parse(jsonText);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}else{
			System.out.println("json파일이 아닙니다.");
		}

		try {
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		discon(con);
		return obj;
	}
}
