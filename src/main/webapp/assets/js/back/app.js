$(function(){
    // sidebar menu toggle
	$('ul.nav li.hasSub').on('click', function(e){
		// e.preventDefault();
		if(!$(this).hasClass('active')) {
			$('ul.nav li').removeClass('active');
			$(this).addClass('active');
			$('ul.sub-nav').slideUp();
			$(this).children('ul.sub-nav').slideDown();
		}
	});

    /**
     * media uploader popup
     */
    $("#addMediaFile").on("click", function(e){
        e.preventDefault();

    });

    // profile page datepickter
    $('input#inputDateOfBirth').datepicker({dateFormat: 'dd-mm-yy'});

    // initiate datatable
    $('table.table').DataTable();

    // ajax on message
   /* $('.inbox li.list-group-item a').on('click', function(e){
        e.preventDefault();

        var ajaxURL = $(this).attr('href');

        $.ajax({
            type: 'POST',
            url: ajaxURL+"&ajax=true",
            dataType: 'json',
            success: function(data){
//                $('.panel-body').text(data);
                console.log("hey lenin");
                console.log(data);

            }
        });
    });*/

});