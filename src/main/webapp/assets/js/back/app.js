$(function(){

	$('ul.nav li.hasSub').on('click', function(e){
		// e.preventDefault();
		if(!$(this).hasClass('active')) {
			//$('ul.nav li').removeClass('active');
			$(this).addClass('active');
			$('ul.sub-nav').slideUp();
			$(this).children('ul.sub-nav').slideDown();
		}
	});
});