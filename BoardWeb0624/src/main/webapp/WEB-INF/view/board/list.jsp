<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%
 String path = request.getContextPath();
%> 
<%@ page import="com.majustory.biz.board.*" %>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> 목록보기 ( ${totalcount} )  (${map.totalcount})</h1>
<table border=1>
<tr><td> 번호  </td> <td> 글쓴이   </td> <td> 제목   </td>  <td> 날짜   </td>  <td> 조회수   </td> 
<c:forEach var="m" items="${li}">

<tr>
<td> ${m.getSeq()}  </td> 
<td> <a href="<%=path %>/editBoard.do?seq=${m.getSeq()}">${m.getWriter()}</a>  </td>
<td> <a href="<%=path %>/deleteBoard.do?seq=${m.getSeq()}">${m.getTitle()}</a>   </td> 
<td> ${m.getRegdate()}  </td> 
<td> ${m.getCnt()}  </td> 
</tr> 


</c:forEach>

</table>
</body>
</html>