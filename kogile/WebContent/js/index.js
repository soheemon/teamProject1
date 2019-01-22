$(document).ready(function(){
  //팝업
  $('.post_item').on('click', function(){
    $('.DetailPostPopUp').show();    
    $("html, body").css({overflow : "hidden", height : $(window).height()}).bind("scroll touchmove", function(e){e.preventDefault();e.stopPropagation();return false;});
  });

    $('.close_btn').on('click', function(){
      $('.popup').hide();
      $("html, body").css({overflow : "visible", height : "auto"}).unbind('scroll touchmove mousewheel');
    });

    $('.menu_open').on('click', function(){
        $('.menu').animate({
          right:0
        },300);
      });
      $('.close_btn2').on('click', function(){
        $('.menu').animate({
          right:'-350px'
        },300);
      });
      
      
});