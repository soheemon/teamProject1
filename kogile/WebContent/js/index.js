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
      
      //label(0122)
      var click_check = $('.label_btn').hasClass('on');

      $('.label_btn').on('click', function(){
        click_check = $('.label_btn').hasClass('on');
        if(click_check == false){
          $(this).addClass('on');
          $('.label_box').show();
        }else{
          $(this).removeClass('on');
          $('.label_box').hide();
        }
        return false;
      });

      $('.label_close').on('click', function(){
        $('.label_btn').removeClass('on');
        $('.label_box').hide();
      });
});