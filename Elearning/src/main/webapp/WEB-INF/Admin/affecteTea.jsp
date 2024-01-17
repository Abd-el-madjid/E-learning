<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page import="java.util.*" %>
<%@ page import="model.Daomodule" %>
<%@ page import="model.module" %>
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
       <script src="./js/filtre.js"></script>
	
</head>
<body>
<%@include file="headerAdmin.jsp"%>

   <section class="home" id="home" style="
    background-image: url(resourceex/home_back.png);
    background-size: cover;">
       
		<div class="container">
			<div class="title">Add Teacher to  Module</div> 
			<div class="content">
			  <form name="addUser" action="AddEtu_ENS_MO_SP"  method="post">
				<div class="user-details">
				 
				 
				 
				  <div class="input-box">
					<span class="details">Email</span>
					<input type="email" name="email" maxlength="100" value=" <c:out value="${emailteacher}"/>" placeholder="Enter your Email" required="required">
			<span class="note">write  Lastname here</span>
		
				</div> 
				  <%Daomodule Daomodule = new Daomodule();
  List<String> specialities = new ArrayList<>();
specialities = Daomodule.getspecialitesname();
%>
				
							  <div class="input-box"  style="display: none">
					<span class="details">specialite</span>
					 <select onchange="showInputs(this)" name="specialite_module" id="add-subject" required  >
                        
					    <% for (String speciality : specialities) { %>
                               
                               <option value="  <%= speciality %>">
                                          <%= speciality %>
                                    </option>
                            <% } %>
                           
                             </select> 
                       <span class="note">write  specialite here</span>
                        
				  </div>
				  
				  
				  
				  
				  		  <%
				  		 List<module> modules = new ArrayList<>(); 
				 		
							
						  modules=Daomodule.getmodules(); 
						  
%>
				
						
							  <div class="input-box">
					<span class="details">Module</span>
					 <select onchange="showInputs(this)" name="Module" id="add-subject">
                        <option value=" ">
                                   --     module --
                                    </option>
					    <% for (int iterator=0; iterator< modules.size()-1;
								  iterator++) {%>
								   
                               
                             
                                       
                               <option value="<%=modules.get(iterator).getName()%>/<%=modules.get(iterator).getSpecialte()%>">
                            
                                          <%= modules.get(iterator).getName() %> /  <%=  modules.get(
						  iterator).getSpecialte()%>
                                    </option>
                                    
                            <% } %>
                           
                             </select> 
                       <span class="note">write  specialite here</span>
                        
				  </div>
				  
				  
				  
				  
				 
   <% 
      int i = 1;
      List<String> listOfspecialite = new ArrayList<>();
      listOfspecialite	= Daomodule.getspecialitesname();
      Map<String, List<String>> result = Daomodule.getModulesForSpecialities(listOfspecialite);
      for (Map.Entry<String, List<String>> entry : result.entrySet()) {
    %>
    		
    		
    		
    			  <div class="input-box divId<%= i%>" style="display: none">
					<span class="details inputDiv"> <%= entry.getKey() %></span>
					 <select onchange="showInputs(this)" name="specialite2" id="add-subject">
                        
					       <%
        for (String module : entry.getValue()) {
      %>         
                               <option value="  <%= module %>">
                                     <%= module %>
                                    </option>
                            <% } %>
                           
                             </select> 
                       <span class="note">write  specialite here</span>
                        
				  </div>
				    <%
    i++;  }
    %>
    
   
     
   
     
				  </div>
				<div class=" button">
				  <input class="btn" type="submit" value="add">
				  <input class="btn" type="reset" value="reset">
				
				</div>
			  </form>
			 <div class=" centre" style="font-size: 18px;width: 100%;display: flex;text-align: center;justify-content: center;align-items: center;margin: 25px;">
			
			  <h1 style="color: darkmauve; text-align: center;">
			  <c:out value="${messageT}"/></h1>
			  </div>
			 
			</div>
		  </div>

        </section>
  <%@include file="footer.jsp"%>
</body>
</html>