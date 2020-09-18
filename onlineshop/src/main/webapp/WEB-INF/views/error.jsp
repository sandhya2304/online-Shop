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

 <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <a class="navbar-brand" href="${contextRoot}/home">Home</a>
            </div>   
         </div>     
    </nav>
    
    <div class="content">
       <div class="container">
           <div class="row">
           
             <div class="col-xs-12">
             
               <div class="jumbotron">
               
                 <h1> ${errorTitle}</h1>
                 <hr/>
                 
                 
                 <blockquote style="word-wrap:break-word">
                   
                     ${errorDescription}
                 
                 </blockquote>
               
               </div>
             
             
             </div>
           
           
           </div>
       
       </div>
    </div>


  
 

    <!-- JavaScript -->
    <script src="${js}/jquery.js"></script>
    <script src="${js}/bootstrap.js"></script>
    
    <!-- datatables plugin -->
     <script src="${js}/jquery.dataTables.js"></script>
     
      <!-- datatables plugin -->
     <script src="${js}/dataTables.bootstrap.js"></script>
    
    
    <!-- self coded javascript -->
     <script src="${js}/myapp.js"></script>

</div>
</body>

</html>
