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
<div align="center">
<h2>
index ... <br><br>
<a href="<%=path %>/formBoard.do"> 저장하기 </a> <br><br>
<a href="<%=path %>/listBoard.do"> 목록보기 </a> <br><br>

<a href="<%=path %>/psdformBoard.do"> 자료실저장하기 </a> <br><br>
<a href="<%=path %>/psdlistBoard.do"> 자료실목록보기 </a> <br><br>

</h2>
</div>
</body>
</html>