(function($) {
	
	function DragPost(elementStatus, containerStatus, p_no) {
    	  
      	$.ajax({
      		type : "POST",
      		url : "updatePostDragAction.do",
      		data : {
      			old_c_no : elementStatus,
      			new_c_no : containerStatus,
      			p_no : p_no
      			
      		}
      	
      	}).then(function(res) {
      		console.log("성공");
      	}).catch(function(err){
      		console.log("실패");
      	})
      }
    
	
  // drag 가 일어나고 있는 Container 를 담아둔다.
  var currentContainer = null;

  // event target list
  dragula(
    [
      document.getElementById("1"),
      document.getElementById("2"),
      document.getElementById("3"),
      document.getElementById("4")
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
      
      console.log("currentElement", $currentElement);

      // element 의 status 를 바탕으로 todo, doing 등 카테고리 체크를 한다.
      var elementStatus = $currentElement.attr("data-status");
      // 최종 Container 의 status 값을 체크한다.
      var containerStatus = $(currentContainer).attr("data-status");

      console.log("elementStatus", elementStatus);
      console.log("containerStatus", containerStatus);

      var p_no = $($currentElement[0]).find('.select_pno').val();
      // elementStatus 와 containerStatus 가 같지 않다는 것은 카테고리 이동이 있었다는 것이므로 update
		// 를 한다.
      if (elementStatus !== containerStatus) {
        // 이동된 해당 카드의 status 를 update 될 카테고리의 status 로 변경한다.
        // todo (0) => done 으로 이동 => (0) => (1)
        // 같은 카드의 중복이동이 있을 수 있기 때문에 변경
        $currentElement.attr("data-status", containerStatus);

        console.log("타켓 elementStatus", elementStatus);

        // 여기서 ajax call 로 update 처리를 한다.
        console.log("update");
        
        
        DragPost(elementStatus, containerStatus, p_no);
        
      }
      
    })
    .on("out", function(_, container) {
      currentContainer = container;
    });
  

  
})(jQuery);