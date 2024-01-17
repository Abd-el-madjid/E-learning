<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Modules for Specialities</title>
  </head>
  <body>
    <h1>Modules for Specialities</h1>
     <%@ page import="model.Daomodule" %>
     <% 
      Daomodule Daomodule = new Daomodule();
      List<String> listOfspecialite = new ArrayList<>();
      listOfspecialite	= Daomodule.getspecialitesname();
      Map<String, List<String>> result = Daomodule.getModulesForSpecialities(listOfspecialite);
      for (Map.Entry<String, List<String>> entry : result.entrySet()) {
    %>
		
    <h2><%= entry.getKey() %></h2>
    <table border="1">
      <tr>
        <th>Module</th>
      </tr>
      <%
        for (String module : entry.getValue()) {
      %>
      <tr>
        <td><%= module %></td>
      </tr>
      <%
        }
      %>
    </table>
    <%
      }
    %>
  </body>
</html>
