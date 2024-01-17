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
			<div class="title">Add User</div>
			<div class="content">
			  <form name="addUser" action="AddUserServlet"  method="post"  onsubmit="return validateForm()">
				<div class="user-details">
				  <div class="input-box">
					<span class="details">Firstname</span>
					<input type="text" name="Firstname"   placeholder="Enter your Firstname"  required="required">
					<span class="note">write  Lastname here</span>
				  </div>
				  <div class="input-box">
					<span class="details">Lastname</span>
					<input type="text" name="Lastname"   placeholder="Enter your Lastname"  required="required">
					<span class="note">write  Lastname here</span>
				  </div>
				 
				  <div class="input-box">
					<span class="details">Email</span>
					<input type="email" name="Email" maxlength="100"  placeholder="Enter your Email" required="required">
			<span class="note">write  Lastname here</span>
		
				</div>  <div class="input-box">
					<span class="details">Password</span>
					<input type="text" name="Password" placeholder="Enter your password"  id="password" required>
						<span class="note">write  Password here</span>
				   </div>
				   <div class="gendre_type">
				<div class="gender-details">
				  <input type="radio" name="gender" value="Male"id="dot-1">
				  <input type="radio" name="gender" value="Female" id="dot-2">
				 <input type="radio" name="gender" value="Autre" id="dot-3">
				 
				  <span class="gender-title">Gender</span>
				  <div class="category">
					<label for="dot-1">
					<span class="dot one"></span>
					<span class="gender">Male</span>
				  </label>
				  <label for="dot-2">
					<span class="dot two"></span>
					<span class="gender">Female</span>
				  </label>
				  <label for="dot-3">
					<span class="dot three"></span>
					<span class="gender">Prefer not to say</span>
					</label>
				  </div>
				</div>
				<div class="type-details">
				  <input type="radio" name="type" value="etudiant"id="type-1">
				  <input type="radio" name="type" value="teacher"id="type-2">
				 
				  <span class="type-title">type</span>
				  <div class="category">
					<label for="type-1">
					<span class="dot one"></span>
					<span class="type">Student</span>
				  </label>
				  <label for="type-2">
					<span class="dot two"></span>
					<span class="type">Teacher</span>
				  </label>
				  
				  </div>
				</div>
			</div>
				<div class=" button">
				  <input class="btn" type="submit" value="Register">
				  <input class="btn" type="reset" value="reset">
				
				</div>
				</div>
			  </form>
			</div>
		  </div>

        </section>
  <%@include file="footer.jsp"%>
  <script>
	function validateForm() {
		var password = document.forms["addUser"]["Password"].value;
		if (password.length < 8) {
			alert("Password must be at least 8 characters long.");
			return false;
		}
		return true;
	}
</script>
</body>
</html>