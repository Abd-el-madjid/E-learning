<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <title>E-Learning</title>
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
</head>
<body>
<%@include file="headerAdmin.jsp"%>
   <section class="home" id="home" style="
    background-image: url(resourceex/home_back.png);
    background-size: cover;">
       
		<div class="container">
			<div class="title">Add Student to  Speciality</div> 
			<div class="content">
			  <form name="addUser" action="AddEtu_ENS_MO_SP"  method="post">
				<div class="user-details">
				 
				 
				 
				  <div class="input-box">
					<span class="details">Email</span>
					<input type="email" name="email" maxlength="100" value=" <c:out value="${emailetudiant}"/>" placeholder="Enter your Email" required="required">
			<span class="note">write  Lastname here</span>
		
				</div> 
				
							  <div class="input-box">
					<span class="details">specialite</span>
					 <select name="specialite" id="add-subject">
                         <option value=" ">
                                   --     specialite --
                                    </option>
					     <c:if test="${listOfspecialite.size()!=0}">
                                <c:forEach var="i" begin="0" end="${listOfspecialite.size()-1}" step="1">
                                    <option value="<c:out value="${listOfspecialite[i]}"/>">
                                        <c:out value="${listOfspecialite[i]}"/>
                                    </option>
                                </c:forEach>
                            </c:if>
                           
                             </select> 
                       <span class="note">write  specialite here</span>
                        
				  </div>
				<div class=" button">
				  <input class="btn" type="submit" value="Register">
				  <input class="btn" type="reset" value="reset">
				
				</div>
			  </form>

			 <div class=" centre" style="font-size: 18px;width: 100%;display: flex;text-align: center;justify-content: center;align-items: center;margin: 25px;">
			
			  <h1 style="color: darkmauve; text-align: center;">
			  <c:out value="${messageE}"/></h1>
			  </div>

			</div>
		  </div>

        </section>
  <%@include file="footer.jsp"%>
</body>
</html>