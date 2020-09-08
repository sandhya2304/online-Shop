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
    </script>

    <!-- Bootstrap core CSS -->
    <link href="${css}/bootstrap.css" rel="stylesheet">

    <!-- Add custom CSS here -->
    <link href="${css}/myapp.css" rel="stylesheet">

</head>

<body>

<div class="wrapper">
  
  <!-- Navigation -->
   
   <%@include file="./shared/navbar.jsp" %>
   
   
    <!-- Page Content -->
    
    <!-- Loading the home content -->
    
    <div class="content">
    <c:if test="${userClickHome == true}">
        <%@include file="./home.jsp" %>
    </c:if>
    
     <!-- Loading when user clicks About  -->
    
    <c:if test="${userClickAbout == true}">
        <%@include file="./about.jsp" %>
    </c:if>
    
     <!-- Loading when user clicks Contact  -->
    
    <c:if test="${userClickContact == true}">
        <%@include file="./contact.jsp" %>
    </c:if>
    
    
     <!-- Loading when user clicks catgeory and products  -->
    
    <c:if test="${userClickAllProducts == true or userClickCategoryProducts== true}">
        <%@include file="./listProducts.jsp" %>
    </c:if>
    
    </div>
    
    <!-- Footer -->
          <%@include file="./shared/footer.jsp" %>
   
    <!-- /.container -->

    <!-- JavaScript -->
    <script src="${js}/jquery.js"></script>
    <script src="${js}/bootstrap.js"></script>
    
    
    <!-- self coded javascript -->
     <script src="${js}/myapp.js"></script>

</div>
</body>

</html>
