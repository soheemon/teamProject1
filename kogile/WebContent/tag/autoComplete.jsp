<%@page import="kogile.post.DTO.TagDTO"%>
<%@page import="java.util.List"%>
<%@page import="kogile.post.DAO.PostDao"%>
<%@page import="kogile.post.Service.PostService"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<%
	//한글로 인코딩
	request.setCharacterEncoding("UTF-8"); 

JSONArray list = new JSONArray();
JSONObject object = null;
//value�� �����ͼ�.. DB�� ����Ʈ�� ������...
//��ġ�ϴ� �����͸� JSONObject�� ����ݴϴ�.

//��� ��ȸ�ؼ�@ �̸��� �����ɴϴ�.
//
PostDao dao = PostDao.getInstance();
//�ʳ� ���� �ʿ�!
int pjt_no = 1;
List<TagDTO> list2 = dao.tagMemberList(pjt_no);
String value = request.getParameter("value").replaceAll("@", "").replace(" ", "");

if(value != null && value.length() > 0){
	for(TagDTO tag : list2) {
		
		if(tag.getName().indexOf(value) > -1) {
	
	object = new JSONObject();
	String fullString = tag.getName()+"."+tag.getInfo_no();
	object.put("data", fullString);
	list.add(object);
		}

	}
		PrintWriter pw = response.getWriter();
		pw.print(list);			
		
		pw.flush();
		pw.close();
}
//list2�� ��� ��� �̸��� ���ִ�. 
//1) ����Ʈ�� ���鼭 �츮�� �Է��� ������ �����ϴ��� Ȯ���Ѵ�.
// =>foreach������ value, indexof �޼��� ���
//=> ��ġ�ϸ� Ű: data ���: name���� object�� �ִ´�.
%>
</head>
<body>

</body>
</html>