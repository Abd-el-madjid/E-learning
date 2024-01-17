<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <title>E-Learning</title><link rel="website icon" type="png" href="resourceex/logo_univ2.png">
 <link rel="stylesheet" href="./css/main.css">
    <link rel="stylesheet" href="./css/displaymodule.css">
</head>
<body>
<%@include file="headerTeacher.jsp"%>
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
               <ul class="dure-table">
                  <li class="table-header">
                    <div class="col col-1"> <h3><c:out value="${semain.value}"/></h3></div>
                    <div class="col col-2"> 
                    <form id="updatesemain" action="beforeabdate" method="post" >
                    	 <input name="moduleName" value="<c:out value="${moduleName}"/>" hidden>
				         	 <input name="delet_semain" value="<c:out value="${semain.key}"/>" hidden>
				         	 	 <input name="semain_value" value="<c:out value="${semain.value}"/>" hidden>
				         	  <input class="btn" type="submit" value="update">			
				         </form> </a></div>
                    <div class="col col-3"> 
                         <form id="deletsemain" action="DeletSemainServlet" method="post" >
				         	 <input name="delet_semain" value="<c:out value="${semain.key}"/>" hidden>
				         	 <input class="btn" type="submit" value="Delet">			
				         </form>
				     </div>
                   
                  </li>
               </ul>
            </div>
            
           <div class="disc">
            <jsp:useBean id="descriptions" scope="session" type="java.util.HashMap"/>
                <ul class="disc-table">
                   <li class="table-header">
                     <div class="col col-1"><c:out value="${descriptions.get(semain.key)}"/> </div>
                     <div class="col col-2">
                           <form id="updatetinfo" action="beforeabdate" method="post" >
				               <input name="delet_semain" value="<c:out value="${semain.key}"/>" hidden>
				               <input name="moduleName" value="<c:out value="${moduleName}"/>" hidden >
				               <input name="update_info" value="<c:out value="${descriptions.get(semain.key)}"/>" hidden>
					         <input class="btn2" type="submit" value="Update">			
				           </form>
				     </div>
                     <div class="col col-3"> 
                            <form id="deletinfo" action="DeletSupportServlet" method="post" >
                                <input name="delet_semain" value="<c:out value="${semain.key}"/>" hidden>
				 		        <input name="moduleName" value="<c:out value="${moduleName}"/>" hidden>
			               	    <input name="delet_info" value="<c:out value="${descriptions.get(semain.key)}"/>" hidden>
					          <input class="btn2" type="submit" value="Delete">			
				            </form>
				     </div>
                    
                   </li>
                </ul>
            </div>
            <div class="cour">
                <ul class="cour-table">
                    <li class="table-header">
                      <div class="col col-1">cour</div>
                      <div class="col col-2"><input type="submit" class="btn2" value="update" hidden> </div>
                      <div class="col col-3">  <input type="submit" class="btn2" value="delet" hidden></div>
                      <div class="col col-4">
                             <form id="addcour" action="AddSupportServlet" method="get" >
				                <input name="delet_semain" value="<c:out value="${semain.key}"/>"hidden >
			                 	<input name="moduleName" value="<c:out value="${moduleName}"/>" hidden>
				             	<input name="type" value="cour" hidden>
					           <input class="btn2" type="submit" value="Add">			
				             </form>
				     </div>
                    </li>
                  <jsp:useBean id="cours" scope="session" type="java.util.HashMap"/>
                  <c:if test="${cours.get(semain.key).size() != 0}">
                  <c:forEach var="cour" items="${cours.get(semain.key)}">
                    <li class="table-row">
                        <div class="col col-1" data-label="cour ">
                            <a href="<c:out value="${cour.key}"/>" target="_blank">
                            <c:out value="${cour.value}"/>
                            </a>
                        </div>
                        <div class="col col-2" data-label="update "> </div>
                        <div class="col col-3" data-label="delet">
                            <form id="deletcour" action="DeletSupportServlet" method="post" >
				               <input name="delet_semain" value="<c:out value="${semain.key}"/>" hidden>
			              	   <input name="moduleName" value="<c:out value="${moduleName}"/>" hidden>
					           <input name="delet_cour" value="<c:out value="${cour.key}"/>" hidden>
					         <input class="btn" type="submit" value="Delete ">			
				            </form>
				         </div>
                        <div class="col col-4" data-label=" Add">
                           <form id="updatetcour" action="beforeabdate" method="post" >
                            <input name="delet_semain" value="<c:out value="${semain.key}"/>" hidden>
                            <input name="cour_name" value="<c:out value="${cour.value}"/>" hidden>
			              	   <input name="moduleName" value="<c:out value="${moduleName}"/>" hidden>
					         <input name="update_cour" value="<c:out value="${cour.key}"/>" hidden>
					        <input class="btn" type="submit" value="Update">			
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
                      <div class="col col-2"><input type="submit" class="btn2" value="update" hidden> </div>
                      <div class="col col-3">  <input type="submit" class="btn2" value="delet" hidden></div>
                      <div class="col col-4"> 
                          <form id="addtd" action="AddSupportServlet" method="get" >
				              <input name="delet_semain" value="<c:out value="${semain.key}"/>" hidden>
				              <input name="moduleName" value="<c:out value="${moduleName}"/>" hidden>
				              <input name="type" value="td" hidden>
					         <input class="btn2" type="submit" value="Add">			
				          </form>
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
                        <div class="col col-2" data-label="update "> </div>
                        <div class="col col-3" data-label="delet">
                           <form id="delettd" action="DeletSupportServlet" method="post" >
				               <input name="delet_semain" value="<c:out value="${semain.key}"/>" hidden>
			                   <input name="moduleName" value="<c:out value="${moduleName}"/>" hidden>
					           <input name="delet_td" value="<c:out value="${td.key}"/>" hidden>
					         <input class="btn" type="submit" value="Delete">			
				           </form>
				        </div>
                        <div class="col col-4" data-label=" Add">
                           <form id="updatettd" action="beforeabdate" method="post" >
                            <input name="delet_semain" value="<c:out value="${semain.key}"/>" hidden>
                          <input name="moduleName" value="<c:out value="${moduleName}"/>" hidden>
                              <input name="td_name" value=" <c:out value="${td.value}"/>" hidden>
					         <input name="update_td" value="<c:out value="${td.key}"/>" hidden>
					         <input class="btn" type="submit" value="Update">			
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
                      <div class="col col-2"><input type="submit" class="btn2" value="update" hidden> </div>
                      <div class="col col-3">  <input type="submit" class="btn2" value="delet" hidden></div>
                      <div class="col col-4"> 
                      
                          <form id="addtp" action="AddSupportServlet" method="get" >
				              <input name="delet_semain" value="<c:out value="${semain.key}"/>" hidden>
				              <input name="moduleName" value="<c:out value="${moduleName}"/>" hidden>
				              <input name="type" value="tp" hidden>
					         <input class="btn2" type="submit" value="Add">			
				          </form>
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
                        <div class="col col-2" data-label="update "> </div>
                        <div class="col col-3" data-label="delete">
                           <form id="delettp" action="DeletSupportServlet" method="post" >
				               <input name="delet_semain" value="<c:out value="${semain.key}"/>" hidden>
			                   <input name="moduleName" value="<c:out value="${moduleName}"/>" hidden>
					           <input name="delet_tp" value="<c:out value="${tp.key}"/>" hidden>
					         <input class="btn" type="submit" value="Delete">			
				           </form>
				        </div>
				        
                        <div class="col col-4" data-label=" Add">
                           <form id="updatettp" action="beforeabdate" method="post" >
                             <input name="delet_semain" value="<c:out value="${semain.key}"/>" hidden>
                          <input name="moduleName" value="<c:out value="${moduleName}"/>" hidden>
                            <input name="tp_name" value=" <c:out value="${tp.value}"/>" hidden>
					       
					         <input name="update_tp" value="<c:out value="${tp.key}"/>" hidden>
					         <input class="btn" type="submit" value="Update">			
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