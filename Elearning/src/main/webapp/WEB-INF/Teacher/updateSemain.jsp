<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <title>E-Learning</title><link rel="website icon" type="png" href="resourceex/logo_univ2.png">
	
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
    <link rel="stylesheet" href="./css/form.css">
       <link rel="stylesheet" href="./css/main.css">
   <link rel="stylesheet" href="./css/button.css">
</head>
<body>
<%@include file="headerTeacher.jsp"%>
   <section class="home" id="home" style="
    background-image: url(resourceex/home_back.png) ;
    background-size: cover;
">
       
		<div class="container">
			<div class="title">update Week</div>
			<div class="content">
			  <form name="addUser" action="UpdateSemainServlet"  method="post">
				<div class="user-details">
				  <div class="input-box">
					<span class="details">Module</span>
						<input type="text" name="Module" value="<c:out value="${moduleName}"/>"  placeholder="<c:out value="${moduleName}"/>  "  required="required">
					 <input type="text" name="id_semain" value="<c:out value="${id_semain}"/>"   hidden  style="display: none;">
					 
        
                       <span class="note">write  Module here</span>
                        
				  </div>
				  <jsp:useBean id="semain" scope="session" type="java.util.HashMap"/>
				    <c:forEach var="semain" items="${semain}">
					
				
				    <div class="input-box" style="display: none;">
					<span class="details">Duree</span>
						<input type="text" name="semain_value" value="<c:out value="${semain_value}"/>"  placeholder="<c:out value="${moduleName}"/>  "  required="required">
					 
        
                       <span class="note">write  Module here</span>
                        
				  </div>
				  <div class="input-box">
					<span class="details">start week</span>
					<input type="date" name="Debut_semain"   value="<c:out value="${semain.key}"/>"  required="required">
					<span class="note">write  date here</span>
				  </div>
				 
				  <div class="input-box">
					<span class="details">end week </span>
					<input type="date" name="Fin_semain" maxlength="100"  value="<c:out value="${semain.value}"/>"  required="required">
			<span class="note">write  date here</span>
		
				</div>
				  </c:forEach>
				</div>  
			
				<div class=" button">
				  <input class="btn" type="submit" value="Update">
				  <input class="btn" type="reset" value="Reset">
				
				</div>
			  </form>
			</div>
		  </div>

        </section>
  <%@include file="footer.jsp"%>
</body>
</html>