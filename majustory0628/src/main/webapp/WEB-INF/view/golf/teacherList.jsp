<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="/include/top.jsp" %>

<section>
<br>
  <div align="center"><h2> teacherList ( 강사조회 ) </h2>  </div> 
  <div align="center"> 
   
<table border=1  width=500>
<tr align="center"> <th>강사코드</th><th>강사명</th><th>강의명</th>
                    <th>수강료(원)</th><th>강사자격취득일</th> </tr>
<c:forEach  var="m" items ="${li}" >
	
	<tr align="center">
	   <td> ${m.getTEACHER_CODE() } </td> 
	   <td> ${m.getTEACHER_NAME()}</td> 
	   <td> ${m.getCLASS_NAME() }</td> 
	   <td> ${m.getCLASS_PRICE() }</td> 
	   <td> &#8361; ${m.getTEACHAR_REGIST_DATE()} </td> 
	</tr>
</c:forEach>

</table>
 
 
  </div> 
<br> 
</section>

<%@ include file="/include/bottom.jsp" %>