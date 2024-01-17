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
	<script src="https://kit.fontawesome.com/6cce549920.js" crossorigin="anonymous"></script>
	  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

	<!-- custom css file link  -->


	<!-- jquery cdn link  -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

	<!-- custom js file link  -->
	
	  <link rel="icon" href="resourceex/logo_univ.png">
    <link rel="stylesheet" href="./css/profile.css">
        <link rel="stylesheet" href="./css/main.css">
</head>
<body>
<%@include file="headerEtudiant.jsp"%>
<section class="home" id="home" style="
    background-image: url(resourceex/home_back.png) ;
    background-size: cover;
">
<section id="sid_profile" class="sid_profile">


	<div class="side-bar">

   

   <div class="profile2">
      <img src="resourceex/profile_etudiant.jpg" id="image" alt="">
      
      
   </div>

   <nav class="navbar">
   <ul>
     <li><a class="" href="./LoginServlet"><span class="icon "><i class="fas  fa-home"></i></span>Home</a></li>
				<li><a href="./ModuleListServlet"><span class="icon "><i class=" fa fa-users" aria-hidden="true"></i></span>List of Modules</a></li>
				<li ><a href="./UpdateProfileServlet"><span class="icon "><i class="fa fa-pencil-square-o" aria-hidden="true"></i></span>Update password</a></li>
			
				<li  style="display: none"><a href="./AddUserServlet"><span class="icon "><i class=" fa fa-user-plus" aria-hidden="true"></i></span>Add User</a></li>
				
				<li style="display: none"><a href="#Ressources_étudiantes">Update User</a></li>
		 </ul>
   </nav>

</div>
               
	<div id="info_container" class="info_container">
	       
		<div id="info_box" class="info_box"> 
			<h4>Email</h4>
           <span  class="icons"><i class="fas fa-envelope"></i></span> <p id="Email" > <c:out value="${etudiant.email}"/>  </p>
        </div>
		<div id="info_box" class="info_box">
			<h4>last name</h4>
           <span  class="icons"><i class="fa-solid fa-user"></i></span> <p id="	last_name" > <c:out value="${etudiant.lastname}"/>  </p>
        </div>
		<div id="info_box" class="info_box">
			<h4>First name</h4>
           <span  class="icons"><i class="fa-solid fa-user"></i></span> <p id="	" ><c:out value="${etudiant.firstname}"/> </p>
        </div>
        <div id="info_box" class="info_box">
			<h4>sex</h4>
           <span class="icons"><i class='fa fa-male'></i></span> <p id="	" >  <c:out value="${etudiant.sex}"/>  </p>
        </div>
		
		<div id="info_box" class="info_box">
			<h4>password</h4>
          <span  class="icons"><i class="fa-solid fa-lock"></i></span>  <p id="	" > *********  </p>
        </div>
         <div id="info_box" class="info_box">
			<h4>role</h4>
           <span class="icons"><i class='far fa-id-badge'></i></span> <p id="	" >  <c:out value="${etudiant.type}"/></p>
        </div>
	
		<div id="info_box" class="info_box">
			 </div>
		<div id="info_box" class="info_box">
			 </div>
       
		
	
</div>
	 </section>	
	  </section>
<%@include file="footer.jsp"%>
<script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
<script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
</body>
</html>