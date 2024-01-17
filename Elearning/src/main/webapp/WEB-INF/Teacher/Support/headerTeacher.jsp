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
  
    <link rel="stylesheet" href="./css/header.css">
    <link rel="stylesheet" href="./js/header.js">
    <script src="./js/header.js"></script>
</head>
<body>
	<!-- header section starts  -->

	<header>



		

		<a href="./LoginServlet" class="logo"><img id="logo_img" src="resourceex/logo_univ2.png" width="70" height="60"></a>
		<i id="menu" class="fa fa-bars" aria-hidden="true" ></i>
		<div id="mySidenav" class="sidenav">
			<a href="javascript:void(0)" class="closebtn" >&times;</a>
			<ul>
				<li><a class="" href="./LoginServlet"><span class="icon "><i class="fas  fa-home"></i></span>Home</a></li>
				<li><a href="./AddSemainServlet"><span class="icon "><i class=" fa fa-user-plus" aria-hidden="true"></i></span>Add week</a></li>
				<li><a href="./ModuleListServlet"><span class="icon "><i class=" fa fa-users" aria-hidden="true"></i></span>List of Modules</a></li>
				<li ><a href="./UpdateProfileServlet"><span class="icon "><i class="fa fa-pencil-square-o" aria-hidden="true"></i></span>Update Profile</a></li>
		
			</ul>
		</div>
		<nav class="navbar">
			<ul>
				<li><a class="" href="./LoginServlet">Home</a></li>
				<li><a href="./AddSemainServlet">Add week</a></li>
				<li><a href="./ModuleListServlet">List of Module</a></li>
				<li style="display: none"><a href="./UpdateProfileServlet">Update Profile</a></li>
		
					</ul>
		</nav>

		<div id="login" class="fas fa-user-circle"></div>
			<div id="profile" class="profile ">
				<img src="resourceex/profile_teacher.jpg" class="image" alt="">
				<h3 class="name"> <jsp:useBean id="teacher" scope="session" type="model.User"/>
                        <c:out value="${teacher.lastname}"/>  <c:out value="${teacher.firstname}"/></h3>
				<h4 id="role" class="role">
                        <c:out value="${teacher.type}"/></h4>
				
				<a href="./profileServlet" id="view_profile" class="btn_profile">view profile</a>
				<div class="flex-btn">
					<a href="./LogOutServlet" class="option-btn"><i class=" fa-solid fa-arrow-right-from-bracket" aria-hidden="true"></i>log out</a>
				</div>
			</div>
	</header>

	<!-- header section ends -->
</body>
</html>