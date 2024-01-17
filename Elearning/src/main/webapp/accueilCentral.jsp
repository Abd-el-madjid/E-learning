<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	
 <link rel="stylesheet" href="./css/accueilCentral.css">
	<!-- jquery cdn link  -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

	<!-- custom js file link  -->
	 <link rel="stylesheet" href="./js/accueilCentral.js">

	<script src="./js/accueilCentral.js"></script>
	<script src="./js/img.js"></script>
</head>
<body>

	<!-- header section starts  -->

	<header>



		

		<a href="#home" class="logo"><img id="logo_img" src="resourceex/logo_univ.png" width="100" height="100"></a>
		<i id="menu" class="fa fa-bars" aria-hidden="true" ></i>
		<div id="mySidenav" class="sidenav">
			<a href="javascript:void(0)" class="closebtn" >&times;</a>
			<ul>
				<li><a class="active" href="#home">home</a></li>
				<li><a href="#about">about</a></li>
				<li><a href="#course">courses</a></li>
				<li><a href="#Ressources_étudiantes">student resources</a></li>
				<li><a href="#news">news</a></li>
				<li><a href="#contact_info">contact us</a></li>
			</ul>
		</div>
		<nav class="navbar">
			<ul>
				<li><a class="active" href="#home">home</a></li>
				<li><a href="#about">about</a></li>
				<li><a href="#course">courses</a></li>
				<li><a href="#Ressources_étudiantes">Resources </a></li>
				<li><a href="#news">news</a></li>
				<li><a href="#contact_info">contact</a></li>
				<li><a href="#home" id="search_bar"><i class="fa fa-search"></i></a></li>
			</ul>
		</nav>

		<div id="login" ><a href="./LoginServlet"><button class="sign_in_button btn">sign in </button></a></div>

	</header>

	<!-- header section ends -->

	<main>

		<section class="home" id="home" style="
    background-image: url(resourceex/accueil_back2.jpeg);
    background-size: cover;">
    
			<div class="searchbar" id="searchbar">	<input type="search " placeholder="What are you looking for?" id="search" class="form-control non search search-input" data-table="list"/>
				<button type="submit" class="searchButton">
					<i class="fa fa-search"></i>
				</button>
	<table class="list" >

		<tbody >
				<tr class="non2" >
				<td > <a href="#about">about</a></td>
				<td  class="non2">	
					<h3>This is Ntic, online.</h3>
					<p>Faculty of New Technologies is committed to improving the world today and for future <br> generations through outstanding education.</p>
					<p>Ntic Online is  Faculty Ntic central resource for students,  alumni and staff to access online courses, programs, initiatives, and tools, and to share best practices in leveraging online and digital technologies to enhance teaching and learning.</p>
				</td>
			</tr >
			<tr class="non2 ">
				<td ><a href="#course"> courses</a></td>
				<td  class="non2">

					<h1 >Find your courses</h1>    
					<a href="https://www.udemy.com/course/the-ultimate-mysql-bootcamp-go-from-sql-beginner-to-expert/" class="title">learn front end development</a>
					<p>The Ultimate MySQL Bootcamp: Go from SQL Beginner to Expert</p>
					<a href="https://www.udemy.com/course/the-complete-bootstrap-5-course-for-beginners-step-by-step/" class="title">learn front end development</a>
					<p>Bootstrap 5 Course - The Complete Guide Step by Step (2023)</p>
					<a href="https://www.udemy.com/course/php-for-complete-beginners-includes-msql-object-oriented/" class="title">learn front end development</a>
					<p>PHP for Beginners - Become a PHP Master - CMS Project</p>
					<a href="https://www.udemy.com/course/cours-html-css/" class="title">learn front end development</a>
					<p>HTML  - Le Cours Complet</p>
					<a href="https://www.udemy.com/course/cours-html-css/" class="title">learn front end development</a>
					<p> CSS - Le Cours Complet</p>
					<a href="https://www.udemy.com/course/cours-javascript/" class="title">learn front end development</a>
					<p>Apprendre Javascript: Cours Javascript Complet</p>




				</td>
			</tr >
			<tr class="non2">
				<td ><a href="#student resources">student resources</a></td>
				<td  class="non2">	
					<h1 >student resources</h1>
					<a >scholarships</a>
					<p>Discover scholarships to support your studies at universities and colleges around the world.</p>

					<a >test preparation</a>
					<p>Discover different courses to make sure you are best prepared for your tests, in order to get the best possible grades.</p>

					<a >Test</a>
					<p>Students Discover the student tests for admissions to higher education.</p>

				</td>
			</tr >
			<tr class="non2">
				<td ><a href="#news"> News</a></td>
				<td  class="non2">
					<h1 >follow the latest news</h1><br>
					<a >Postponement of exams on Sunday 22 January 2023</a>
					<p>Due to difficult weather conditions and snowfall, to keep students and dear professors safe, Sunday 22 January 2023 exams have been postponed to another day, which will be announced in the coming days, God willing.

						For more information and for the latest college news Zorro College website or official Facebook page of the College



					</p> 
				</div>
				<a >Consultation: Cleaning of headquarters, indoor and outdoor spaces</a>
				<p>The Faculty of Modern Information and Communication Technologies at Abdul Hamid Mehri Constantine University 02 announces the organization of a consultation
				Special to:</p>
				<a ><button class="btn">See all the news</button></a>
			</td>
		  </tr >
		  <tr class="non2">
			<td ><a href="#contact_info"> contact</a></td>
			<td  class="non2">

				<h3>quick links</h3>

				<a href="#contact_info">contact</a>       

				<h3>contact info</h3>
				<p><a href=""> <i class="fas fa-map-marker-alt"></i> Nouvelle ville Ali Mendjeli BP : 67A, Constantine <br/>
				Algerie La Nouvelle Ville Ali Mendjeli, 25016 </a></p>
				<p > email  adress <i class="fas fa-envelope"></i> webmaster@univ-constantine2</p>
				<p >phone number  <i class="fas fa-phone"></i>+213 031 77 50 27 </p>


				<p class="copyright">Copyright © 2022 Faculty of New Information and Communication Technologies  NTIC All Rights Reserved</p>
				
					<p>social media	  facebook twitter  linkedin</p>



				</td>
			</tr >

		</tbody>
	</table></div>

				<h1>Explore your passion <br> Make an Impact</h1>

				<a href="https://www.univ-constantine2.dz/facntic/"><button class="btn">Learn more</button></a>



			</section>

			<!-- home section ends -->

			<!-- about section starts  -->

			<section class="about" id="about">

				<div class="image">
					<img src="resourceex/ntic.jpg" alt="">
				</div>

				<div class="content">
					<h3>This is Ntic, online.</h3>
					<p>Faculty of New Technologies is committed to improving the world today and for future <br> generations through outstanding education.</p>
					<p>Ntic Online is  Faculty Ntic central resource for students,  alumni and staff to access online courses, programs, initiatives, and tools, and to share best practices in leveraging online and digital technologies to enhance teaching and learning.</p>
					<a href="https://www.univ-constantine2.dz/facntic/"><button class="btn">learn more</button></a>
				</div>

			</section>

			<!-- about section ends -->

			<!-- course section starts  -->

			<section class="course" id="course" style="
    background: url(resourceex/home_back.png ) no-repeat;
    background-size: cover;
">

				<h1 class="heading">Find your courses</h1>    

				<div class="box-container">

					<div class="box">
						<img src="resourceex/thumb-8.png" alt="">

						<div class="content">

							<a href="https://www.udemy.com/course/the-ultimate-mysql-bootcamp-go-from-sql-beginner-to-expert/" class="title">learn back end development</a>
							<p>The Ultimate MySQL Bootcamp: Go from SQL Beginner to Expert</p>
							<div class="info">
								<h3> <i class="far fa-clock"></i> 48 hours </h3>
								<h3> <i class="far fa-calendar-alt"></i> 6 months </h3>
								<h3> <i class="fas fa-book"></i> 14 modules </h3>
							</div>
						</div>
					</div>

					<div class="box">
						<img src="resourceex/thumb-4.png" alt="">

						<div class="content">

							<a href="https://www.udemy.com/course/the-complete-bootstrap-5-course-for-beginners-step-by-step/" class="title">learn front end development</a>
							<p>Bootstrap 5 Course - The Complete Guide Step by Step (2023)</p>
							<div class="info">
								<h3> <i class="far fa-clock"></i> 24 hours </h3>
								<h3> <i class="far fa-calendar-alt"></i> 2 months </h3>
								<h3> <i class="fas fa-book"></i> 6 modules </h3>
							</div>
						</div>
					</div>
					<div class="box">
						<img src="resourceex/thumb-7.png" alt="">

						<div class="content">

							<a href="https://www.udemy.com/course/php-for-complete-beginners-includes-msql-object-oriented/" class="title">learn back end development</a>
							<p>PHP for Beginners - Become a PHP Master - CMS Project</p>
							<div class="info">
								<h3> <i class="far fa-clock"></i> 36 hours </h3>
								<h3> <i class="far fa-calendar-alt"></i> 4 months </h3>
								<h3> <i class="fas fa-book"></i> 12 modules </h3>
							</div>
						</div>
					</div>
					<div class="box">
						<img src="resourceex/post-1-6.png" alt="">

						<div class="content">

							<a href="https://www.udemy.com/course/cours-html-css/" class="title">learn front end development</a>
							<p>HTML  - Le Cours Complet</p>
							<div class="info">
								<h3> <i class="far fa-clock"></i> 10 hours </h3>
								<h3> <i class="far fa-calendar-alt"></i> 1 months </h3>
								<h3> <i class="fas fa-book"></i> 2 modules </h3>
							</div>
						</div>
					</div>

					<div class="box">
						<img src="resourceex/post-2-1.png" alt="">

						<div class="content">

							<a href="https://www.udemy.com/course/cours-html-css/" class="title">learn front end development</a>
							<p> CSS - Le Cours Complet</p>
							<div class="info">
								<h3> <i class="far fa-clock"></i> 12 hours </h3>
								<h3> <i class="far fa-calendar-alt"></i> 1 months </h3>
								<h3> <i class="fas fa-book"></i> 4 modules </h3>
							</div>
						</div>
					</div>
					<div class="box">
						<img src="resourceex/post-3-1.png" alt="">

						<div class="content">

							<a href="https://www.udemy.com/course/cours-javascript/" class="title">learn front and back  end development</a>
							<p>Apprendre Javascript: Cours Javascript Complet</p>
							<div class="info">
								<h3> <i class="far fa-clock"></i> 24 hours </h3>
								<h3> <i class="far fa-calendar-alt"></i> 3 months </h3>
								<h3> <i class="fas fa-book"></i> 5 modules </h3>
							</div>
						</div>
					</div>
				</div>

					<a href="https://www.udemy.com/"><button class="btn">view all</button></a>
			</section>

			<!-- course section ends -->

			<!-- Ressources étudiantes section starts  -->

			<section class="Ressources_étudiantes" id="Ressources_étudiantes">

				<h1 class="heading">student resources</h1>
				<div class="carde-container">
					<div class="carde">
					<img src="resourceex/scholarships.jpg" width="250 " alt="">
                          
						<div class="content_resource">

							<a href="https://scholarships360.org/scholarships/computer-science-scholarships/" class="title">scholarships</a>
							<p>Discover scholarships to support your studies at universities and colleges around the world.</p>

							<a href="https://scholarships360.org/scholarships/computer-science-scholarships/"><button class="btn Read_more">Read more</button></a>
						</div>
					</div>  
				
				
					<div class="carde">
						<img src="resourceex/preparation.jpg   " width="250 " alt="">
                             
						<div class="content_resource">

							<a href="https://www.varsitytutors.com/computer_science-practice-tests" class="title">test preparation</a>
							<p>Discover different courses to make sure you are best prepared for your tests, in order to get the best possible grades.</p>

							<a href="https://www.varsitytutors.com/computer_science-practice-tests"><button class="btn Read_more">Read more</button></a>
						</div>
					</div>  
				
				
					<div class="carde">
						<img src="resourceex/Test.jpg" width="250 " alt="">
                             
						<div class="content_resource">

							<a href="#" class="title">Test</a>
							<p>Students Discover the student tests for admissions to higher education.</p>

							<a href="#"><button class="btn Read_more">Read more</button></a>
						</div>
					</div>  
				</div>

			</section>

			<!-- Ressources étudiantes section ends -->
<!-- news section starts  -->

<section class="news" id="news" style="
    background: url(resourceex/home_back.png ) no-repeat;
    background-size: cover;
">
<div class="carde">
<h1 class="heading">follow the latest news</h1><br>
<a class="title">Postponement of exams on Sunday 22 January 2023</a>
<p>Due to difficult weather conditions and snowfall, to keep students and dear professors safe, Sunday 22 January 2023 exams have been postponed to another day, which will be announced in the coming days, God willing.

For more information and for the latest college news Zorro College website or official Facebook page of the College



</p> 
</div>
<a class="title">Consultation: Cleaning of headquarters, indoor and outdoor spaces</a>
<p>The Faculty of Modern Information and Communication Technologies at Abdul Hamid Mehri Constantine University 02 announces the organization of a consultation
Special to:</p>
<a href="https://www.univ-constantine2.dz/facntic/"><button class="btn">See all the news</button></a>

</section>

<!-- news section ends -->

</main>
		<!-- footer section starts  -->

		<footer >
			<div class="footer">
			<div class="box-container">

						<div class="box">
						<div class="image_footer">
							<img src="resourceex/logo_univ2.png" width="210" height="180"></div>
</div>
						<div class="box">
							<h3>quick links</h3>
							<a class="active" href="#home">home</a>       
							<a href="#about">about</a>       
							<a href="#course">course</a>       
							<a href="#Ressources_étudiantes">Ressources étudiantes</a>       
							<a href="https://online.columbia.edu/news/">news</a>       
							<a href="#contact_info">contact</a>       
						</div>

						<div id="contact_info" class="box">
							<h3>contact info</h3>
							<p><a href=""> <i class="fas fa-map-marker-alt"></i> Nouvelle ville Ali Mendjeli BP : 67A, Constantine <br/>
            Algerie La Nouvelle Ville Ali Mendjeli, 25016 </a></p>
					 <p class="right-side-header" title="Copy Text" id="text" onclick="copyElementText(this.id)"><i class="fas fa-envelope"></i> webmaster@univ-constantine2</p>
							<p class="right-side-header" title="Copy Text" id="text" onclick="copyElementText(this.id)"> <i class="fas fa-phone"></i>+213 031 77 50 27 </p>
						</div>

					</div>
					<div class="credit" >

						<p class="copyright">Copyright © 2022 Faculty of New Information and Communication Technologies  NTIC All Rights Reserved</p>
						<div class="social item">
						
						<a href="https://www.facebook.com/faculteNTICUC2">	 <ion-icon name="logo-facebook"> </ion-icon></a>
                     <a href="https://twitter.com/fac_ntic_UC2"> <ion-icon name="logo-twitter"></ion-icon></a> 
                   <a href="https://www.facebook.com/faculteNTICUC">   <ion-icon name="logo-linkedin"></ion-icon></a>

						</div>
					</div>
				</div>

			</footer> 

			<!-- footer section ends -->



<script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
<script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>




















	</body>
</html>