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
			<div class="title">Add Week</div>
			<div class="content">
			  <form name="addUser" action="AddSemainServlet"  method="post">
				<div class="user-details">
				  <div class="input-box">
					<span class="details">Module</span>
					 <select name="Module" id="add-subject">
                         <option value=" ">
                                   --     module --
                                    </option>
					     <c:if test="${listOfmodules1.size()!=0}">
                                <c:forEach var="i" begin="0" end="${listOfmodules1.size()-1}" step="1">
                                    <option value="<c:out value="${listOfmodules1[i].name}"/>">
                                        <c:out value="${listOfmodules1[i].name}"/>
                                    </option>
                                </c:forEach>
                            </c:if>
                           
                             </select> 
                       <span class="note">write  Module here</span>
                        
				  </div>
				  <div class="input-box">
					<span class="details">start week</span>
					<input type="date" name="Debut_semain"   placeholder="Enter your Lastname"  required="required">
					<span class="note">write  date here</span>
				  </div>
				 
				  <div class="input-box">
					<span class="details">end week </span>
					<input type="date" name="Fin_semain" maxlength="100"  placeholder="Enter your Email" required="required">
			<span class="note">write  date here</span>
		
				</div>
				</div>  
			
				<div class=" button">
				  <input class="btn" type="submit" value="ADD">
				  <input class="btn" type="reset" value="Reset">
				
				</div>
			  </form>
			</div>
		  </div>

        </section>
  <%@include file="footer.jsp"%>
</body>
</html>