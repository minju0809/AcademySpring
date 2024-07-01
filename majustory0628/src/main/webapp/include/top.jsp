<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<c:set var="path" scope="session" 
       value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마주스토리</title>
<link  href="${path}/include/css/top.css"  rel="stylesheet" type="text/css" />
<style type="text/css">

</style>

</head>
<body>

<header> 마주스토리 골프 회원관리 프로그램  </header>
<nav > &emsp;&emsp;

<a href="${path}/test.do"> Test </a> &emsp;&emsp;

&emsp;<a href="${path}/teacherList.do"> 강사조회 </a> 
&emsp;&emsp;<a href="${path}/enrolMent.do"> 수강신청 </a> 
&emsp;&emsp;<a href="${path}/memberList.do"> 회원정보조회 </a> 
&emsp;&emsp;<a href="${path}/teacherMoney.do"> 강사매출현황 </a> 
&emsp;&emsp;&emsp;<a href="${path}/index.jsp">홈으로</a> 

&emsp;&emsp;<a href="${path}/login.do"> 로그인 </a> 
&emsp;&emsp;<a href="${path}/boardForm.do"> 게시판글등록 </a> 
&emsp;&emsp;<a href="${path}/selectAll.do"> 게시판목록보기 </a> 
 </nav>