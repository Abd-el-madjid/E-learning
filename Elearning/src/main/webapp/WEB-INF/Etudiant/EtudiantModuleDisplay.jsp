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
	
     <link rel="stylesheet" href="./css/main.css">
    <link rel="stylesheet" href="./css/displaymodule.css">
</head>
<body>
<%@include file="headerEtudiant.jsp"%>
    <section class="home" id="home" style="
    background-image: url(resourceex/home_back.png) ;
    background-size: cover;
">

  <div class="page student-module">
            
            <div class="module">
            <jsp:useBean id="moduleName" scope="session" type="java.lang.String"/>
         <h1><c:out value="${moduleName}"/></h1>
           </div>
           
        
           
           
            <jsp:useBean id="semains" scope="session" type="java.util.HashMap"/>


            <c:if test="${semains.size()!=0}">
                <c:forEach var="semain" items="${semains}">
 <div class="semain">
   <div class="dure">
               <div class="dure-table">
                  <div class="table-header">
                    <div class="col col-1"> <h3><c:out value="${semain.value}"/></h3></div>
                
                   
                  </div>
               </div>
            </div>
            
           <div class="disc">
            <jsp:useBean id="descriptions" scope="session" type="java.util.HashMap"/>
                <ul class="disc-table">
                   <li class="table-header">
                     <div class="col col-1"><c:out value="${descriptions.get(semain.key)}"/> </div>
                  
                  
                    
                   </li>
                </ul>
            </div>
            <div class="cour">
                <ul class="cour-table">
                    <li class="table-header">
                      <div class="col col-1">cour</div>
                    <div class="col col-4">
                           
   <input class="btn2" type="submit" value="download" hidden>
				     </div>
                    </li>
                  <jsp:useBean id="cours" scope="session" type="java.util.HashMap"/>
                    <jsp:useBean id="cours2" scope="session" type="java.util.HashMap"/>
                  <c:if test="${cours.get(semain.key).size() != 0}">
                  <c:forEach var="cour" items="${cours.get(semain.key)}">
                  
                    <li class="table-row">
                        <div class="col col-1" data-label="cour ">
                            <a href="<c:out value="${cour.key}"/>" target="_blank">
                            <c:out value="${cour.value}"/>
                            
                           
                           
                            </a> 
                            
                          
                        </div>
                      

				        
                        <div class="col col-4" data-label=" download">
                    <form action="download" method="get"> 
                    
                           <input name="id_cour" value="<c:out value="${cour.key}"/>"hidden >   
                           <input name="id_semain" value="<c:out value="${semain.key}"/>" hidden>
				 		        <input name="moduleName" value="<c:out value="${moduleName}"/>" hidden> 
                         <input name="type" value="cour" hidden>
                         <input class="btn" type="submit" value="downlowd">
                         </form>
  				        </div>
                      </li>
                      </c:forEach>
                    
                     </c:if>
                 </ul>
            </div>
            <div class="td">
                <ul class="td-table">
                    <li class="table-header">
                      <div class="col col-1">td</div>
                     <div class="col col-4"> 
                       
				          <input class="btn2" type="submit" value="download" hidden>	
				     </div>
                    </li>
                     <jsp:useBean id="tds" scope="session" type="java.util.HashMap"/>
                     <c:if test="${tds.get(semain.key).size() != 0}">
                     <c:forEach var="td" items="${tds.get(semain.key)}">
                    <li class="table-row">
                        <div class="col col-1" data-label="td ">
                            <a href="<c:out value="${td.key}"/>" target="_blank">
                              <c:out value="${td.value}"/>
                            </a>
                        </div>
                       
                        <div class="col col-4" data-label=" download">

    <form action="download" method="get"> 
                   
                           <input name="id_td" value="<c:out value="${td.key}"/>" hidden>   
                         <input name="id_semain" value="<c:out value="${semain.key}"/>" hidden>
				 		        <input name="moduleName" value="<c:out value="${moduleName}"/>" hidden> 
                         <input name="type" value="td" hidden >
                         <input class="btn" type="submit" value="downlowd">
                         </form>
				        </div>
                      </li>
                      </c:forEach>
                        </c:if>
                 </ul>
            </div>
              <div class="tp">
                <ul class="tp-table">
                    <li class="table-header">
                      <div class="col col-1">tp</div>
                      <div class="col col-4"> 
                      
                        
				          <input class="btn2" type="submit" value="download" hidden>	
				     </div>
                    </li>
                    
                     <jsp:useBean id="tps" scope="session" type="java.util.HashMap"/>
                     <c:if test="${tps.get(semain.key).size() != 0}">
                     <c:forEach var="tp" items="${tps.get(semain.key)}">
                    <li class="table-row">
                        <div class="col col-1" data-label="tp ">
                            <a href="<c:out value="${tp.key}"/>" target="_blank">
                              <c:out value="${tp.value}"/>
                            </a>
                        </div>
                    
				        
				        
                        <div class="col col-4" data-label=" download">
                          
 <form action="download" method="get"> 
                  
                           <input name="id_tp" value="<c:out value="${tp.key}"/>"hidden >   
                            <input name="id_semain" value="<c:out value="${semain.key}"/>" hidden>
				 		        <input name="moduleName" value="<c:out value="${moduleName}"/>" hidden> 
				 		         <input name="type" value="tp" hidden>
                         <input class="btn" type="submit" value="downlowd">
                         </form>
				        </div>
                      </li>
                     </c:forEach>
                     </c:if>
                 </ul>
            </div>
 </div>
 
                </c:forEach>
            </c:if>
        </div>
      </section>
          <%@include file="footer.jsp"%>
</body>
</html>