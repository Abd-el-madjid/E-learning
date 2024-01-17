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
    <link rel="stylesheet" href="./css/table.css">
       <link rel="stylesheet" href="./css/main.css">
       

</head>
<body>
<%@include file="headerAdmin.jsp"%>
    <section class="home" id="home" style="
    background-image: url(resourceex/home_back.png) ;
    background-size: cover;
">

		<div class="container"><h2>List of Teachers </h2>
			 <button class="btn" style="display: none"> add User</button>
	
			
			<ul id="responsive-table" class="responsive-table">
			  <li class="table-header">
				<div class="col col-1">Id</div>
				<div class="col col-2">Email</div>
				<div class="col col-3">Fisrt Name</div>
				<div class="col col-4">Last Name</div>
				<div class="col col-5">Password</div>
				<div class="col col-6">Type</div>
				<div class="col col-7">Gendre</div>
				<div class="col col-8">Update</div>
					<div class="col col-9">send</div>
				<div class="col col-10">Delet</div>
			  </li>
			   
			      <jsp:useBean id="listOfTeacher" scope="session" type="java.util.List"/>
                <c:if test="${listOfTeacher.size()!=0}">
                <c:forEach var="i" begin="0" end="${listOfTeacher.size()-1}" step="1">
              	
			  <li class="table-row">
			 		
				<div class="col col-1" data-label=" Id">i</div>
				<div class="col col-2"  data-label="Email"> ${listOfTeacher[i].email}</div>
				<div class="col col-3" data-label="Fisrt Name"> ${listOfTeacher[i].firstname}</div>
				<div class="col col-4" data-label="Last Name"> ${listOfTeacher[i].lastname}</div>
				<div class="col col-5" data-label="Password"> ${listOfTeacher[i].password}</div>
				<div class="col col-6" data-label="Type">${listOfTeacher[i].type}</div>
				<div class="col col-7" data-label="Gendre"> ${listOfTeacher[i].sex}</div>
				<div class="col col-8" data-label="Update"> 
				<form id="update" action="beforeabdate" method="post" >
		<input name="email" value="${listOfTeacher[i].email}" hidden> 
		<input name="sex" value="${listOfTeacher[i].sex}" hidden> 
		<input name="type" value="${listOfTeacher[i].type}" hidden>
		<input name="password" value="${listOfTeacher[i].password}" hidden>
		<input name="lname" value="${listOfTeacher[i].lastname}" hidden>
		<input name="fname" value="${listOfTeacher[i].firstname}" hidden>
				<input class="btn" type="submit" value="Update">
				</form>	
				</div>
					<div class="col col-9" data-label="send">
					 <form id="afecteform" action="AddEtu_ENS_MO_SP" method="get" >
					
	 <input name="email" value="${listOfTeacher[i].email}" hidden> 
					<input name="type" value="etudiant" hidden>
					 <input class="btn" type="submit" value="send">			
				</form>
				</div>
				<div class="col col-10" data-label="Delet">
					 <form id="deletform" action="DeletUserServlet" method="post" >
					
				 <input name="type" value="listOfTeacher" hidden>
					 <input name="k" value="${listOfTeacher[i].email}" hidden>
					 <input class="btn" type="submit" value="Delet">			
				</form>
				</div>
			  </li>
		    </c:forEach>
                </c:if>
			</ul>
		  </div>
        </section>
        <%@include file="footer.jsp"%>
</body>
</html>