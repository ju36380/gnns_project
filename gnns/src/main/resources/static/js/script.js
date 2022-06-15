/* script.js */

//JQUERY 시작




$(document).ready(function(){

    // GNB
    $(".nav").hover(function() { //마우스를 topnav에 오버시
      $(".nav .navi_set .subnav").slideDown('normal').show(); //subnav가 내려옴.
      $(".nav .nav_bg").slideDown('normal').show(); //subnav가 내려옴.
      $(this).parent().hover(function() {  
      }, function(){  
        $(".nav .navi_set .subnav").slideUp('slow'); //subnav에서 마우스 벗어났을 시 원위치시킴  
        $(".nav_bg").slideUp('slow'); //subnav에서 마우스 벗어났을 시 원위치시킴  
      });  
    });


    //MAIN-TAB
    $(".mc_tab_conts > li").hide();
    $(".mc_tab_conts > li").eq(0).show();

    $(".mc_tab > li" ).click(function(){
      
      var tab_index = $(this).index();

      $(".mc_tab > li" ).removeClass("on");
      $(this).addClass("on");
      $(".mc_tab_conts li").hide();
      $(".mc_tab_conts li").eq(tab_index).show();
    });

    //HEADER SCROLL EVENT
    $(window).scroll(function() {
      var scroll = $(window).scrollTop();
      //console.log(scroll);
      if (scroll >= 50) {
        //console.log('a');
        $(".header").addClass("active");
      } else {
        //console.log('a');
        $(".header").removeClass("active");
      }
    });

    //모바일 메뉴
    $('.btn_lnb').click(function () {
      $('#lnb').addClass('active');
      $('body').css('overflow','hidden');
    });
  
    $('.m_btn_close').click(function () {
        $('#lnb').removeClass('active');
        $('body').css('overflow','auto');
    });    

    //로그인, 회원가입 인풋 클릭
    $(".m_blank").click(function(){
      $(this).addClass('focus');
      $(this).siblings().removeClass('focus');
    });

    $(".etc_btn li").click(function(){
      $(this).addClass('focus');
      $(this).siblings().removeClass('focus');
    });

    $(".m_input .mi_input").click(function(){
      $(this).addClass('focus');
      $(this).parent().siblings().find(".mi_input").removeClass('focus');
    });

    //NAV drop-down
    $(".btn_nav_depth_01 > a").click(function() { //마우스를 topnav에 클릭시
      $(this).addClass('on');
      $(this).parent().find(".nav_depth_box_02").slideDown('normal').show(); //subnav가 내려옴.
      $(this).parent().hover(function() {  
      }, function(){  
        $(this).parent().find(".nav_depth_box_02").slideUp('fast'); //subnav에서 마우스 벗어났을 시 원위치시킴  
        $(".btn_nav_depth_01 > a").removeClass('on');
      });  
    });    

    //파일첨부
    $(function(){
      $('.upload_text').val('');
      $('.input_file').change(function(){
        var i = $(this).val();
        $('.upload_text').val(i);
      });
    });

      //datepicker
    $( "input.datepicker" ).datepicker({
      showOn: "both",
      buttonImage: "/img/ico_datepicker.png",
      buttonImageOnly: true,
        buttonText: "Select date",
      
    });

      // KR language callendar
    $.datepicker.regional['kr'] = {
      closeText: '닫기', // 닫기 버튼 텍스트 변경
      currentText: '오늘', // 오늘 텍스트 변경
      monthNames: ['1 월','2 월','3 월','4 월','5 월','6 월','7 월','8 월','9 월','10 월','11 월','12 월'], // 개월 텍스트 설정
      monthNamesShort: ['1 월','2 월','3 월','4 월','5 월','6 월','7 월','8 월','9 월','10 월','11 월','12 월'], // 개월 텍스트 설정
      dayNamesMin: ['일','월','화','수','목','금','토'], // 요일 텍스트 설정
      dayNamesShort: ['월','화','수','목','금','토','일'], // 요일 텍스트 축약 설정&nbsp;   dayNamesMin: ['월','화','수','목','금','토','일'], // 요일 최소 축약 텍스트 설정
      dateFormat: 'yy-mm-dd', // 날짜 포맷 설정
      showMonthAfterYear: true
    };
    
    $('.ui-datepicker ').css({ "margin-left" : "-100px", "margin-top": "0px"});  //달력(calendar) 위치
    //  $('img.ui-datepicker-trigger').attr('align', 'absmiddle');
      // Seeting up default language, Korean
    $.datepicker.setDefaults($.datepicker.regional['kr']);


    $('#btnOpenPopup').click(function(){
      $('#popUp').css('display', 'block');
      $('body').css('overflow', 'hidden');
    });
    $('.p_close').click(function(){
      $('#popUp').css('display', 'none');
      $('body').css('overflow', 'auto');
    });

  });

  // lnb
(function($){
  
  var lnbUI = {
    click : function (target, speed) {
      var _self = this,
          $target = $(target);
      _self.speed = speed || 300;
      
      $target.each(function(){
        if(findChildren($(this))) {
          return;
        }
        $(this).addClass('noDepth');
      });
      
      function findChildren(obj) {
        return obj.find('> ul').length > 0;
      }
      
      $target.on('click','a', function(e){
          e.stopPropagation();
          var $this = $(this),
              $depthTarget = $this.next(),
              $siblings = $this.parent().siblings();
        
        $this.parent('li').find('ul li').removeClass('on');
        $siblings.removeClass('on');
        $siblings.find('ul').slideUp(250);
        
        if($depthTarget.css('display') == 'none') {
          _self.activeOn($this);
          $depthTarget.slideDown(_self.speed);
        } else {
          $depthTarget.slideUp(_self.speed);
          _self.activeOff($this);
        }
        
      })
      
    },
    activeOff : function($target) {
      $target.parent().removeClass('on');
    },
    activeOn : function($target) {
      $target.parent().addClass('on');
    }
  };
  
  
  // Call lnbUI
  $(function(){
    lnbUI.click('#lnb li', 300)
  });
  
  
}(jQuery));

const $btnPopup  = document.getElementById('btnOpenPopup');
const $popUp = document.getElementById('popUp');
if($btnPopup != null){
	$btnPopup.addEventListener('click' , function(){
	  $popUp.style.display = 'block';
	});
}

