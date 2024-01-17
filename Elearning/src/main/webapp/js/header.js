$(document).ready(function(){

    $('#menu').click(function(){
        $("#mySidenav").css("width", "25rem");
        $("#profile").css('transform' ,"scale(0)");
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
 $(document).on('click', '#teacherlist', function() {  
  $("#mySidenav").css("width", "25rem");
  console.log(" nav bar closed") ;
});

//profile show 
$(document).on('click', '#login', function() {  
    $("#profile").css('transform' ,"scale(1)");
    $("#mySidenav").css("width", "0px");
    console.log(" profile info ") ;
  });
  
  $(document).on('dblclick', '#login', function() {  
    $("#profile").css('transform' ,"scale(0)");
    console.log(" profile info ") ;
  });
 
$(window).on('load scroll',function(){

  $("#profile").css('transform' ,"scale(0)");
  console.log(" profile info ") ;
  $("#mySidenav").css("width", "0px");
  var scrolled = $(this).scrollTop() > 500;
  





});

}); 
 function submituseremail(email){
      //
      let update= document.getElementById("update-name");
      let updates = document.getElementById("update-submit");
  
      update.value = email ;
      updates.click();
  
  console.log(update.value);
  
  }
  _delet
  function submituseremail_delet(email){
    //
    let delet= document.getElementById("delet-name");
    let delets = document.getElementById("delet-submit");

    delet.value = email ;
    delets.click();

console.log(delet.value);

}
 
 
