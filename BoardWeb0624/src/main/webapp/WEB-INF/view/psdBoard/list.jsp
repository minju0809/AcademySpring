<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%
 String path = request.getContextPath();
System.out.println("path : " + path);
%> 
<%@ page import="com.majustory.biz.psdBoard.*" %>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> 목록보기 ( ${totalcount} )  (${map.totalcount})</h1>
<table border=1>
<tr>
	<td> 번호  </td> 
	<td> 글쓴이   </td> 
	<td> 제목   </td>  
	<td> 내용   </td>
	<td> 나이   </td>
	<td> 날짜   </td>
	<td> 사진   </td>
	<td> 조회수   </td>  
	<td> 삭제   </td>  
</tr> 
<c:forEach var="m" items="${li}">

<tr>
<td> <a href="<%=path %>/psdEdit.do?seq=${m.getSeq()}">${m.getSeq()}</a> </td> 
<td> ${m.getWriter()} </td>
<td> ${m.getTitle()}  </td> 
<td> ${m.getContent()} </td> 
<td> ${m.getAge()} </td> 
<td> ${m.getRegdate()} </td>
<td> <img src="<%=path %>/psdBoard/files/${m.getUploadFileStr()}" /> </td>  
<td> ${m.getCnt()} </td> 
<td> <a href="<%=path %>/psdDelete.do?seq=${m.getSeq()}">삭제</a> </td> 
</tr> 


</c:forEach>

</table>
</body>
</html>