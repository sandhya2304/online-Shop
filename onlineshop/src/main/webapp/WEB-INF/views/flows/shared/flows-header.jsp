<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
    
    <spring:url var="css" value="/resources/css" />
     <spring:url var="js" value="/resources/js" />
     
    <c:set var="contextRoot" value="${pageContext.request.contextPath}" /> 
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Online Shopping -> ${title} </title>
    
    <script>
       window.menu = '${title}';
       window.contextRoot = '${contextRoot}';
    </script>

    <!-- Bootstrap core CSS -->
    <link href="${css}/bootstrap.css" rel="stylesheet">


    <!-- Bootstrap core CSS -->
    <link href="${css}/dataTables.bootstrap.css" rel="stylesheet">
    

    <!-- Add custom CSS here -->
    <link href="${css}/myapp.css" rel="stylesheet">

</head>

<body>

<div class="wrapper">
  
    <!-- Navigation -->
     
     <%@include file="../shared/flows-navbar.jsp" %> 
  
   
   
    <!-- Page Content -->
    