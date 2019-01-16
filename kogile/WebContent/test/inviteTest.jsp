<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
 <link rel="stylesheet" href="/resources/demos/style.css">
 <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
 <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script type="text/javascript">

/*     $("#memName").autocomplete({
        source: function(request, response){
            $.ajax({	
                url     : 'memberBoardAction.json', 
                dataType : 'json', 
                success : function(data){  
                	response(function (item) {
                        return {
                            label: item.mail;
                        }
                    });
                },
                error    : function(request, status, error){
                    alert("회원 이름으로 정보를 불러오는 중 오류가 발생하였습니다.")
                }
            });
        }
}); */


</script>
</head>

<body>
<div class="col-sm-10">
    <div class="col-sm-12">
        <input type="hidden" name="memCode" id="memCode"/>
        <input type="hidden" name="value-keyword" id="value-keyword"/>
        <input type="hidden" name="str" id="str"/>
        <input type="text" class="col-xs-10 col-sm-10" id="memName" name="memName" autocomplete="on" placeholder="회원이름">
    </div>
</div>

</body>
</html>