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
    <script src="./js/header.js"></script>
</head>
<body>
<%@include file="headerAdmin.jsp"%>
   <section class="home" id="home" style="
    background-image: url(resourceex/home_back.png) ;
    background-size: cover;
">
       
		<div class="container">
			<div class="title">Update Profile Information</div>
			<div class="content">
			  <form name="update_profile" action="UpdateProfileServlet"  method="Post">
				<div class="user-details">
				  <div class="input-box">
					  <span class="details">Email</span>
					 <input  name="email"  value="<c:out value="${admin.email}"/>"  hidden style="display: none">
			         <input  name="newemail" value="<c:out value="${admin.email}"/>" placeholder="<c:out value="${admin.email}"/> "  required="required">
			         <span class="note">   Email here</span> 
			     </div>
				  <div class="input-box">
				  		  
					 <span class="details">Gendre</span>
				<!--	 <input  value="<c:out value="${admin.sex}"/>" name="sex"  hidden>
			<span class="note">Enter  Lastname here</span> -->
		                
			<h2 class="details"><c:out value="${admin.sex}"/> </h2>
		<span class="note">   Gendre here</span>
				</div>
				  <div class="input-box">
				  		  
					 <span class="details">Type</span>
				<!--	 <input name="type" maxlength="100"   value="<c:out value="${admin.type}"/> " placeholder="Enter your Email" required="required" hidden>
			<span class="note">Enter  Lastname here</span> -->
			              
			<h2 class="details"><c:out value="${admin.type}"/> </h2>
		<span class="note">   Type here</span>
				</div>
				<div class="input-box">
					<span class="details">Firstname</span>
					<input type="text" name="newFirstname" value="<c:out value="${admin.firstname}"/> "  placeholder="<c:out value="${admin.firstname}"/> " required="required">
					<span class="note">   Firstname here</span>
				  </div>
				  <div class="input-box">
					<span class="details">Lastname</span>
					<input type="text" name="newLastname"  value="<c:out value="${admin.lastname}"/>" placeholder="<c:out value="${admin.lastname}"/>"  required="required">
					<span class="note">   Lastname here</span>
				  </div>
				 
		  <div class="input-box">
					<span class="details"> old Password</span>
					<input type="password" name="Password"   required>
					<span class="note">write  old Password here</span>
				   </div>
				   
				 <div class="input-box">
					<span class="details">Password</span>
					<input type="password" name="newPassword"  required>
					<span class="note">write  new Password here</span>
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
    <script>
	function validateForm() {
		var password = document.forms["update_profile"]["Password"].value;
		if (password.length < 8) {
			alert("Password must be at least 8 characters long.");
			return false;
		}
		return true;
	}
</script>
</body>
</html>