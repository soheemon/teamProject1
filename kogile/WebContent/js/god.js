(function($) {
  	    function submitFunction(containerStatus , elementStatus , post) {
			$.ajax({
				type : "POST",
				url : "movePostAction.post",
				data : {//데이터가공 에러방지위해서  하나의 객체로 묶어서보냄 데이터라는걸로
					/* 	chatName : encodeURIComponent(chatName),
						chatContent : encodeURIComponent(chatContent) */
					containerStatus : containerStatus,
					elementStatus: elementStatus,
					post : post,
				},
			});
		};
	
	
	
	
	
	
  // drag 가 일어나고 있는 Container 를 담아둔다.
  var currentContainer = null;
  var containerStatus = null;
  var elementStatus = null;
  var post=null;
  // event target list
  dragula(
    [
      document.getElementById("To Do"),
      document.getElementById("Doing"),
      document.getElementById("Done"),
      document.getElementById("Close")
    ],
    {
      removeOnSpill: false
    }
  )
    .on("drag", function(_, container) {
      // drag event 가 일어나면 해당 Container 를 저장한다
      currentContainer = container;
    })
    .on("dragend", function(el, e) {
      // drag event 가 끝났을때 update 여부를 판단한다.

      var $currentElement = $(el);

      // element 의 status 를 바탕으로 todo, doing 등 카테고리 체크를 한다.
      var elementStatus = $currentElement.attr("data-status");
      // 최종 Container 의 status 값을 체크한다.
      var containerStatus = $(currentContainer).attr("data-status");
      // elementStatus 와 containerStatus 가 같지 않다는 것은 카테고리 이동이 있었다는 것이므로 update 를 한다.
      var post  = $($currentElement[0]).find('.post_no').val();
      
      console.log("db위치",elementStatus);
      console.log("변경할위치",containerStatus);
      console.log("포스트위치", post);
      
     if (elementStatus !== containerStatus) {
        // 이동된 해당 카드의 status 를 update 될 카테고리의 status 로 변경한다.
        // todo (0) => done 으로 이동 => (0) => (1)
        // 같은 카드의 중복이동이 있을 수 있기 때문에 변경
        
    	 $currentElement.attr("data-status", containerStatus);
        
        // 여기서 ajax call 로 update 처리를 한다.
        console.log("update");
      }

      submitFunction(containerStatus , elementStatus, post);
      
    })
    .on("out", function(_, container) {
      currentContainer = container;
    });
  
  
})(jQuery);
