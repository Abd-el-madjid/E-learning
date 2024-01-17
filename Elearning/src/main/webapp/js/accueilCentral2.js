/**
 * 
 */
$(document).ready(function(){

    $('#menu').click(function(){
        $("#mySidenav").css("width", "20rem");
        console.log(" nav bar opened") ;
    }); 
    $('#menu').dblclick(function(){
        $("#mySidenav").css("width", "0px");
        console.log(" nav bar closed") ;
    }); 

 $(document).on('click', '.closebtn', function() {  
  $("#mySidenav").css("width", "0px");
  console.log(" nav bar closed") ;
});


 

    $(window).on('load scroll',function(){

      var scrolled = $(this).scrollTop() > 400;
    $("header").css('background-color', scrolled ? '#27213c' : "inherit");
$("header").css('box-shadow', scrolled ? '0 .1rem .3rem rgba(0,0,0,.3)' : "inherit");

    $(".sign_in_button").css('background-color', scrolled ? '#086ca9' : "#27213c");
 
$("#logo_img").attr("src",  scrolled ? " resourceex/CUSPS_logo_primary_RGB_white@4x.png": "resourceex/CUSPS_logo_primary_RGB_dkblue@4x.png");
$("#logo_img").css("width",scrolled ? '255px':'290px');
$("#logo_img").css("height",scrolled ? '48px':'55px');
$("#logo_img2").attr("src",  scrolled ? " resourceex/CUSPS_logo_small_RGB_white@4x.png": "resourceex/CUSPS_logo_small_RGB_dkblue@4x.png");

 $("#search_bar").css('display', scrolled ? 'flex' : "none");
        $('section').each(function(){

            let top = $(window).scrollTop();
            let height = $(this).height();
            let id = $(this).attr('id');
            let offset = $(this).offset().top - 200;

            if(top > offset && top < offset + height){
                $('.navbar ul li a').removeClass('active');
                $('.navbar').find(`[href="#${id}"]`).addClass('active');
            }


        });

    });

}); 
 
 

