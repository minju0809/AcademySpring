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
<img src="<%=path %>/psdBoard/files/${m.getUploadFileStr()}" width=300 height=100 />
<form action="<%=path%>/psdUpdate.do" 
      enctype="multipart/form-data" method="post" >
번호   <input  type=text  name=seq  value="${m.seq}"  > <br>
제목   <input  type=text  name=title  value="${m.title}"  > <br>
나이   <input  type=text  name=age   value="${m.age}" > <br>
글쓴이  <input  type=text  name=writer   value="${m.writer}" > <br>
업로드  <input  type=file  name=uploadFile   > <br>
내용   <textarea  cols=40  rows=4   name=content > ${m.content} </textarea> <br>
<input  type=submit  value="수정하기" >
</form>


</body>
</html>