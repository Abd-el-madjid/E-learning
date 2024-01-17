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


 $('.fa-search').click(function (evt){
    $('.search').removeAttr('value');
    $(".search").focus();
    evt.preventDefault();
  });

    $(window).on('load scroll',function(){

      var scrolled = $(this).scrollTop() > 200;
    $("header").css('background-color', scrolled ? '#27213c' : "inherit");
$("header").css('box-shadow', scrolled ? '0 .1rem .3rem rgba(0,0,0,.3)' : "inherit");

    $(".sign_in_button").css('background-color', scrolled ? '#086ca9' : "#27213c");

   $(".logo").css("width",scrolled ? '55px':'100px'); 
    $(".logo").css("height",scrolled ? '55px':'100px');
    $("#logo_img").attr("src",  scrolled ? " resourceex/logo_univ2.png": "resourceex/logo_univ.png");
 
$("#logo_img").css("width",scrolled ? '70px':'100px');
$("#logo_img").css("height",scrolled ? '65px':'100px');
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


 
 

