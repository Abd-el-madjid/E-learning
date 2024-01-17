<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"> <title>E-Learning</title>
<link rel="website icon" type="png" href="resourceex/logo_univ2.png">
	<!-- google fonts cdn link  -->
	<link rel="preconnect" href="https://fonts.gstatic.com">
	<link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@300;400;600&display=swap" rel="stylesheet">

	<!-- font awesome cdn link  -->
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css">
      <link rel="stylesheet" href="path/to/font-awesome/css/font-awesome.min.css">
	<!-- custom css file link  -->
	<link rel="stylesheet" href="accueilCentral.css">

	<!-- jquery cdn link  -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

	<!-- custom js file link  -->
		  <link rel="icon" href="../../resourceex/logo_univ.png">
    <link rel="stylesheet" href="./css/table_module.css">
     
       <link rel="stylesheet" href="./css/main.css">
     <script src="./js/module.js"></script>
     <script src="./js/img.js.js"></script>
</head>
<body>
<%@include file="headerTeacher.jsp"%>
    <section class="home" id="home" style="
    background-image: url(resourceex/home_back.png) ;
    background-size: cover;
">
       
		<div class="container"><h2>List of Modules </h2>
			
			    <form id="module-form" action="ModuleDisplayServlet" method="post" style="display: none">
                <label>
                    <input type="text" name="module-name" id="module-name">
                </label>
                <input type="submit" id="module-submit">
            </form>
			<ul class="responsive-table">
			  <li class="table-header">
				<div class="col col-11">Module</div>
				<div class="col col-12">Spéciality</div>
				
			  </li>
			   
			 <jsp:useBean id="listOfmodules" scope="session" type="java.util.List"/>
                <c:if test="${listOfmodules.size()!=0}">
                    <c:forEach var="i" begin="0" end="${listOfmodules.size()-1}" step="1">
			  <li class="table-row">
			 		
			
				<div class="col col-11" onclick="submitmoduleName('<c:out value="${listOfmodules[i].name}"/>')" data-label="Module"><a >
                                <c:out value="${listOfmodules[i].name}"/></a></div>
				<div class="col col-12" data-label=" Spécialité"> ${listOfmodules[i].specialte}</div>
				
			
			  </li>
		    </c:forEach>
                </c:if>
			</ul>
		  </div>
        </section>
        <%@include file="footer.jsp"%>
</body>
</html>