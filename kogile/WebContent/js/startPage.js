/*$(document).ready(function(){
	$('.poem-stanza').addClass('highlight');
})*/

//결과같다 위와
$(function(){
	$('.add_btn').on('click', function(){
		$('.create').prepend('<li>null</li>');
	});
});

