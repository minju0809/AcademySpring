

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

<header> 마주스토리 쇼핑몰 관리자 공간  </header>
<nav class = noto-sans-kr-uniquifier> &emsp;&emsp;
<a href="${path}/formBoard.do"> 저장하기 </a> &emsp;&emsp;
<a href="${path}/listBoard.do"> 목록보기 </a> &emsp;&emsp;

<a href="${path}/psdformBoard.do"> 자료실저장하기 </a> &emsp;&emsp;
<a href="${path}/psdlistBoard.do"> 자료실목록보기 </a> &emsp;&emsp;

&emsp;<a href="${path}/index.jsp">홈으로</a> 
 
 </nav>
