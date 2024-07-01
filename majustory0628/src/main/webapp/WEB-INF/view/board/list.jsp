<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="/include/top.jsp" %>

<section>
<br>
  <div align="center"><h2> 게시판 목록 보기  </h2>  </div> 
  <div align="center"> 
  
 <table border=1  width=700>
<tr align="center">
 <th>SEQ</th><th>TITLE</th><th>WRITER</th>
 <th>REGDATE</th><th>CNT</th> 
</tr>

<c:forEach  var="m" items="${li}" >
	
<tr align="center">
   <td> ${m.seq} </td> 
   <td> 
   <a href=boardEdit.do?seq=${m.seq}>
      ${m.title }
   </a>
   </td> 
   <td> ${m.writer }</td> 
   <td> ${m.regdate}</td> 
   <td> ${m.cnt}</td> 
</tr>

</c:forEach>

</table>  

<form action="${path}/selectAll.do"  method="post">
<table >
<tr>
 <td><select name="searchCondition">
     <option value="title" > 제목  </option>
     <option value="writer" > 글쓴이  </option>
     </select> 
 </td>  
 <td> <input type=text  name="searchKeyword" > </td>
 <td> <input type=submit value="검색"> </td> 
</tr>
</table>
</form>
 
  </div> 
<br> 
</section>

<%@ include file="/include/bottom.jsp" %>