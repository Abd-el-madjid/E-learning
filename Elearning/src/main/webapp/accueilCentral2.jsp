<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <title>E-Learning</title>
<!--	<link rel="website icon" type="png" href="resourceex/logo_univ2.png">
	
 google fonts cdn link  -->
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

	<script src="./js/accueilCentral2.js"></script>
</head>
<body>

	<!-- header section starts  -->

	<header>



			

		<a href="#home" class="logo"><img id="logo_img" src="resourceex/CUSPS_logo_primary_RGB_dkblue@4x.png" width="290" height="50"></a>
		<a href="#home" class="logo"><img id="logo_img_2" src="resourceex/CUSPS_logo_small_RGB_dkblue@4x.png" width="50" height="50"></a>
		<i id="menu" class="fa fa-bars" aria-hidden="true" ></i>
		<div id="mySidenav" class="sidenav">
			<a href="javascript:void(0)" class="closebtn" >&times;</a>
			<ul>
				<li><a class="active" href="#home">home</a></li>
				<li><a href="#about">about</a></li>
				<li><a href="#course">courses</a></li>
				<li><a href="#Ressources_étudiantes">student resources</a></li>
				<li><a href="https://online.columbia.edu/news/">news</a></li>
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
    background-image: url(resourceex/CampusNight.jpg);
    background-size: cover;">
			<div class="searchbar" id="searchbar">	<input type="text" id="search" class="search" placeholder="What are you looking for?">
				<button type="submit" class="searchButton">
					<i class="fa fa-search"></i>
				</button></div>

				<h1>Explore your passion <br> Make an Impact</h1>

				<a href="#"><button class="btn">Learn more</button></a>



			</section>

			<!-- home section ends -->

			<!-- about section starts  -->

			<section class="about" id="about">

				<div class="image">
					<img src="resourceex/colubia_university_pic2.jpg" alt="">
				</div>

				<div class="content">
					<h3>This is Columbia, online.</h3>
					<p>Columbia University is committed to improving the world today and for future <br> generations through outstanding education.</p>
					<p>Columbia Online is Columbia University’s central resource for students, faculty, alumni and staff to access online courses, programs, initiatives, and tools, and to share best practices in leveraging online and digital technologies to enhance teaching and learning.</p>
					<a href="#"><button class="btn">learn more</button></a>
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
						<img src="https://lh3.googleusercontent.com/38tLzh_oXyGMApT6_KB_VMd45-GsJfgZrUjzvbfEVsdmU-FXR-coUNaMiur__40elvMjzAZuszum8MdvNUJZLF5SbcmBgnI-brgY19Sgco6LNtHVzSSw02J_xhnosQiDM3tFRxKf=w2400" alt="">

						<div class="content">

							<a href="#" class="title">learn front end development</a>
							<p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Dolorem, beatae. Modi quos excepturi id quibusdam? Molestiae quis nihil non debitis!</p>
							<div class="info">
								<h3> <i class="far fa-clock"></i> 2 hours </h3>
								<h3> <i class="far fa-calendar-alt"></i> 6 months </h3>
								<h3> <i class="fas fa-book"></i> 12 modules </h3>
							</div>
						</div>
					</div>

					<div class="box">
						<img src="https://lh3.googleusercontent.com/l4zUHpaWRLjz4CZLAxdFoH4quH7W7pdPYl3CBnBUU-KYCO0bzPz5_1iUFFFIr1IY6Zb384634jXH5jHlpMqzSK8zlDkJSIPHbCyL8ZHBcLUyh36lKBmG3wWKAsBlqRxS-rYGdWD_=w2400" alt="">

						<div class="content">

							<a href="#" class="title">learn front end development</a>
							<p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Dolorem, beatae. Modi quos excepturi id quibusdam? Molestiae quis nihil non debitis!</p>
							<div class="info">
								<h3> <i class="far fa-clock"></i> 2 hours </h3>
								<h3> <i class="far fa-calendar-alt"></i> 6 months </h3>
								<h3> <i class="fas fa-book"></i> 12 modules </h3>
							</div>
						</div>
					</div>
					<div class="box">
						<img src="https://lh3.googleusercontent.com/URInbsn8nqtMqr1NODOdBIVpZ7ei8FK1zgl7Ln72nHBlYPWqQeCIxx1-lMi_TAREXaCz2jMcwcI5j_bBj90ljtwAgaxMo2z4klbyzTq3Ii2Z43fV-66Dzioyc2hTmx0DJxfWtJkT=w2400" alt="">

						<div class="content">

							<a href="#" class="title">learn front end development</a>
							<p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Dolorem, beatae. Modi quos excepturi id quibusdam? Molestiae quis nihil non debitis!</p>
							<div class="info">
								<h3> <i class="far fa-clock"></i> 2 hours </h3>
								<h3> <i class="far fa-calendar-alt"></i> 6 months </h3>
								<h3> <i class="fas fa-book"></i> 12 modules </h3>
							</div>
						</div>
					</div>
					<div class="box">
						<img src="https://lh3.googleusercontent.com/BjWxQp0HaqaOInBmKccdbHmi-NFNhX_ZfVMPnUeOOwtn-UDpovNm7biKapgh0RqmG0mB-LTBjK5hfNWUVC03eyz6nXmqZMIO64qwL8KX81tioIPmOiVU6V7bzGtggdN6hgBNoel4=w2400" alt="">

						<div class="content">

							<a href="#" class="title">learn front end development</a>
							<p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Dolorem, beatae. Modi quos excepturi id quibusdam? Molestiae quis nihil non debitis!</p>
							<div class="info">
								<h3> <i class="far fa-clock"></i> 2 hours </h3>
								<h3> <i class="far fa-calendar-alt"></i> 6 months </h3>
								<h3> <i class="fas fa-book"></i> 12 modules </h3>
							</div>
						</div>
					</div>

					<div class="box">
						<img src="https://lh3.googleusercontent.com/LBMfaRAKTzFu8cGPAOJcTmKEE7gHJG9cqxweO-cAshkFXXCl262No_A5iXFv2S-Df87dGsdRmXM-8usiGFq_RmBbm1jCrdBSueQ7y538fCQtfB0nHSqchuIyqM7tE-Zd6YZSX_tC=w2400" alt="">

						<div class="content">

							<a href="#" class="title">learn front end development</a>
							<p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Dolorem, beatae. Modi quos excepturi id quibusdam? Molestiae quis nihil non debitis!</p>
							<div class="info">
								<h3> <i class="far fa-clock"></i> 2 hours </h3>
								<h3> <i class="far fa-calendar-alt"></i> 6 months </h3>
								<h3> <i class="fas fa-book"></i> 12 modules </h3>
							</div>
						</div>
					</div>
					<div class="box">
						<img src="https://lh3.googleusercontent.com/zQkBf-9YvG501Y5l_X0-Ob3Oi23hd0XL5tcDOM_sL2vxoSeYw-otsQDyXfAR5Jlip-2TF8oVIl-tXnpkezDTwBYaHbsqlcAwpU7XqbD3q4rUglqt-9WdM8rUJ5eruOipXWlQzB7B=w2400" alt="">

						<div class="content">

							<a href="#" class="title">learn front end development</a>
							<p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Dolorem, beatae. Modi quos excepturi id quibusdam? Molestiae quis nihil non debitis!</p>
							<div class="info">
								<h3> <i class="far fa-clock"></i> 2 hours </h3>
								<h3> <i class="far fa-calendar-alt"></i> 6 months </h3>
								<h3> <i class="fas fa-book"></i> 12 modules </h3>
							</div>
						</div>
					</div>
				</div>

					<a href="#"><button class="btn">view all</button></a>
			</section>

			<!-- course section ends -->

			<!-- Ressources étudiantes section starts  -->

			<section class="Ressources_étudiantes" id="Ressources_étudiantes">

				<h1 class="heading">student resources</h1>
				<div class="carde-container">
					<div class="carde">
					<img src="https://lh3.googleusercontent.com/IkfbTH4XMfvH7LHFD8Iz-0aaNe8gGTIXc8ISbHswVzQLJIwKSbjPaRBIbRi7-2VLWHRR559obTtntgTkLz9tb6-XmabALFEhf8J3lopox9EMal2g81lVgFZMy1GQGmvudGz_D9AG=w2400" width="250 " alt="">
                          
						<div class="content_resource">

							<a href="#" class="title">scholarships</a>
							<p>Discover scholarships to support your studies at universities and colleges around the world.</p>

							<a href="#"><button class="btn Read_more">Read more</button></a>
						</div>
					</div>  
				
				
					<div class="carde">
						<img src="https://lh3.googleusercontent.com/Z4AMKIKo7MOX9PF3kiH4Meiqr_Lwv9x-slw5btCRwMYicskzQUoAeJuK2Z0Xu1swCndyyPz1tVNF1Hrt88zDM4tTpUhAOhGZZKyxVXGng0jd1WgrEOIStJZ9Glg0t7YiTsVw_vGx=w2400   " width="250 " alt="">
                             
						<div class="content_resource">

							<a href="#" class="title">test preparation</a>
							<p>Discover different courses to make sure you are best prepared for your tests, in order to get the best possible grades.</p>

							<a href="#"><button class="btn Read_more">Read more</button></a>
						</div>
					</div>  
				
				
					<div class="carde">
						<img src="https://lh3.googleusercontent.com/mMcJjvJW2G-Srs9kliNFwZ-r3RsqDKPtSGLy7bqa4K9l-aeuYuCCM9uYTURTJz4GHuSZgHIaYACRXcYLIRn-udaYQIcXNOAMtwfXqYh_t8Qol1g2w22aBn_0K0Q3WUVk0xojNmQj=w2400" width="250 " alt="">
                             
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
<a class="title">Columbia’s Zuckerman Institute Celebrates First Decade of Discovery</a>
<p>President Lee C. Bollinger helps kick off event in which experts on vision, memory, and touch were among those whose research was showcased at the institute's anniversary event...</p> </div>
<a class="title">Columbia Faculty Weigh In On the Midterm Elections</a>
<p>This year’s consequential midterm elections are around the corner. Find out what Columbia faculty members have had to say about what is motivating voters and what is at stake this year...</p>
<a href="https://news.columbia.edu/content/all-news"><button class="btn">See all the news</button></a>

</section>

<!-- news section ends -->

</main>
		<!-- footer section starts  -->

		<footer >
			<div class="footer">
			<div class="box-container">

						<div class="box">
							<img src="https://lh3.googleusercontent.com/0w1eLleNqcIP6ASNXIMbcLia6jPIjVHHYWxekLqllLcTglvRKc9zYf1FblRuu31hVPYF3_EA1V_cwRi9_JPLNAhi2-Ak0uyRIpXg0cFpbAEFhorq62XRfy832J10U5WRlI5gGPgD=w2400" width="280" height="50">
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
							<p><a href=""> <i class="fas fa-map-marker-alt"></i>535 W 116th St, New York, NY 10027 </a></p>
							<p> <a href=""><i class="fas fa-envelope"></i> tcintl@tc.columbia.edu</a></p>
							<p> <a href=""><i class="fas fa-phone"></i>+1 212-854-2772 </a></p>
						</div>

					</div>
					<div class="credit" >

						<p class="copyright">Copyright © 2022 Columbia University All Rights Reserved</p>
						<div class="social item">
							  <ion-icon name="logo-facebook"></ion-icon>
                      <ion-icon name="logo-twitter"></ion-icon>
                      <ion-icon name="logo-linkedin"></ion-icon>

						</div>
					</div>
				</div>

			</footer> 

			<!-- footer section ends -->



<script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
<script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>




















	</body>
</html>