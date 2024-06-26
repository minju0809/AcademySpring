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
 
<h1> 상세보기  </h1>
<form action="<%=path%>/updateBoard.do">
제목   <input  type=text  name=title value="${m.title}"> <br>
글쓴이  <input  type=text  name=writer value="${m.writer}"> <br>
내용   <input  type=text  name=content value="${m.content}"> <br>
이미지이름 <input  type=text  name=content value="${m.uploadFileStr}"> <br>
사진 <img src="<%=path %>/psdBoard/files/${m.uploadFileStr}" />
<input  type=submit  value="수정하기" >
</form>


</body>
</html>