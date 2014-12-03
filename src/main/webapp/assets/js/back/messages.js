/**
 * Created by lenin on 12/3/14.
 */

$(document).ready(function(){

    /**
     * load messages by user
     */


    /**
     * save messages
     */

    $("form#sendMsgForm").submit(function(e){
        e.preventDefault();
        console.log('form submitted. processing started');
        // get datas
        var toUserId    = $("form#sendMsgForm input#toUserId").val(),
            fromUserId  = $("form#sendMsgForm input#fromUerId").val(),
            msg         = $("form#sendMsgForm textarea#msg").val();

        var formData  = "ajax=1";
        formData += "&toUserId=" + toUserId;
        formData += "&fromUserId=" + fromUserId;
        formData += "&msg=" + msg;

        console.log( formData );

        $.ajax({
            type: "POST",
            url: "save-message",
            data: formData,
            success: function( response ) {
                console.log( response ); // remove it later
                if( 'ok' == response.result ) {
                    var newMsg  = '<tr><td width="64px"><img src="'+response.profilePic+'" alt="..." class="img-rounded"></td><td>';
                        newMsg += '<h5>'+response.displayName+'</h5>';
                        newMsg += '<p>'+msg+'</p>';
                        newMsg += '</td></tr>';

                    $("table#messagesList").prepend(newMsg);
                } else {
                    console.log( 'error retrieving ok response' );
                }
            },
            error: function( response ) {
                alert("Error !!! see console for detail");
                console.log( response );
            }
        });
        return false;
    });


    /**
     * fetch new messages
     */
});
