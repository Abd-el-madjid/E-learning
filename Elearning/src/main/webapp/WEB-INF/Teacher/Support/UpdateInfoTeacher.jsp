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
    <script src="./js/header.js"></script>
</head>
<body>
<%@include file="headerTeacher.jsp"%>
   <section class="home" id="home" style="
    background-image: url(resourceex/home_back.png) ;
    background-size: cover;
">
       
		<div class="container">
			<div class="title">Update Discription</div>
			<div class="content">
			  <form name="addUser" action="UpdateSupportServlet"  method="post">
				<div class="user-details">
				  <div class="input-box">
					  <span class="details"> Old Discription</span>
					  <input  name="type"  value="info" hidden style="display: none" >
					   <input name="delet_semain" value="<c:out value="${delet_semain}"/>" hidden style="display: none" >
				<input name="moduleName" value="<c:out value="${moduleName}"/>" hidden style="display: none"  >
					  <input  name="Info" value=" <c:out value="${update_info}"/>"  >
			         <span class="note">your  old Discription here</span> 
			     </div>
	
				<div class="input-box">
					<span class="details">new Discription</span>
					
					<input type="text" name="newInfo"   placeholder="..."  required="required">
					<span class="note">write  new Discription Lien here</span>
				  </div>

				 
		 </div>
			
				<div class=" button">
				  <input class="btn" type="submit" value="Update">
				  <input class="btn" type="reset" value="reset">
				
				</div>
			  </form>
			</div>
		  </div>

        </section>
  <%@include file="footer.jsp"%>
</body>
</html>