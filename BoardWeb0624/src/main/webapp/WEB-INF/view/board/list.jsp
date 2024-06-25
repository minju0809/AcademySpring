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
	<h1> 목록보기 </h1>
	<h3>총 게시글 수: ${totalcount}</h3>
	<table border=1>
		<tr>
			<td> 번호 </td> <td> 글쓴이 </td> <td> 제목 </td>  <td> 삭제 </td> 
		</tr>
		<c:forEach var="m" items="${li}">
			<tr>
				<td> ${m.getSeq()}  </td> 
				<td> 
					<a href="<%=path %>/editBoard.do?seq=${m.getSeq()}">${m.getWriter()}</a> 
				</td>
				<td> ${m.getTitle()}   </td> 
				<td>
					<a href="<%=path %>/deleteBoard.do?seq=${m.getSeq()}">삭제</a>
				</td> 
			</tr> 
		</c:forEach>
	</table>
</body>
</html>

<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.*" %>
<%@ page import="com.majustory.biz.board.*" %>
<%
 List<BoardVO>  li = ( List<BoardVO> ) session.getAttribute("li");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> 목록보기 </h1>
<table border=1>
<tr><td> 번호  </td> <td> 글쓴이   </td> <td> 제목   </td> 
<%
  for (BoardVO m :li) {
%>
<tr>
<td> <%=m.getSeq() %>  </td> 
<td> <%=m.getWriter() %>   </td>
<td> <%=m.getTitle() %>   </td> 
</tr> 

<% } %>

</table>
</body>
</html> --%>