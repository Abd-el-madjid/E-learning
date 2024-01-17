<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<!DOCTYPE html>
<html>

<head>
	<meta charset="utf-8">
	 <title>E-Learning</title>
	<link rel="website icon" type="png" href="resourceex/logo_univ2.png">
	
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    
     <link rel="stylesheet" href="index.css"/>
     
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  
</head>

<body >
  
  <div class="content">
    <div class="container">
    <a><i class="fa fa-arrow-left" aria-hidden="true"></i></a>
      <div class="row k">
        <div class="col-md-6 align-top bg-transparent">
         <a href="accueilCentral.jsp">  
       
       
          <img   src="resourceex/logo_univ.png" alt="Image" class="img-fluid">
          </a>
        </div>
        <div class="col-md-6 contents">
          <div class="row justify-content-center">
            <div class="col-md-8 justify-content-center">
              <div class="mb-4">
               <h1 class="w">Welcome To <span class="e"> E-Learning</span></h1>
        <h3  class="u">University Of Constantine 2</h3>
              <h3>Sign In</h3>
                 </div>
            <form action="./LoginServlet" method="post">
              <div class="form-group first">
                <label for="email">Email</label>
                <input type="text" name="email" class="form-control" id="username">

              </div>
              <div class="form-group last mb-4">
                <label for="password">Password</label>
                <input type="password" name="password" class="form-control" id="password">
                
              </div>
              
           

              <input type="submit" value="Log In" class="btn btn-block btn-primary">

              
             
            </form>
            </div>
          </div>
          
        </div>
        
      </div>
    </div>
  </div>


</body>
</html>