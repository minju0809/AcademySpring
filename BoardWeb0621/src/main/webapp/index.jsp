<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	Start~~

	<h1>Start ~~</h1>

	<form action="<%=path%>/insert.do">
		제목 <input type=text name=title><br> 
		글쓴이 <input type=text name=writer><br> 
		내용 <input type=text name=content><br> 
		<input type=submit value="저장하기">
	</form>
</body>
</html>