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
 
<h1> form </h1>
<form action="<%=path%>/psdBoardInsert.do" 
      enctype="multipart/form-data" method="post" >
제목   <input  type=text  name=title> <br>
나이   <input  type=text  name=age> <br>
글쓴이  <input  type=text  name=writer> <br>
업로드  <input  type=file  name=uploadFile> <br>
내용   <input  type=text  name=content> <br>
<input  type=submit  value="저장하기" >
</form>


</body>
</html>