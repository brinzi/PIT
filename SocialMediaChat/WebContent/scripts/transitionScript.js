/*Transition for Domains*/
var cur = '#new';
var activeChatWindow = '';
var openChatWindows = [
];
function change(x, cur) {
    if (x != cur) {
        $(cur).fadeOut('slow');
        $(x).fadeIn('slow');
        return x;
    } else
    return cur;
};
function windowIsOpened(wId) {
    for (var window in openChatWindows) {
        if (openChatWindows[window] == wId)
        	return true;
    }
    return false;
}
function appendChatWindow(active, win, userid) {
	openChatWindows.push(userid);
    if (active)
    $('#myTabContent').append('<div class="tab-pane fade in active display" id="' + win
    + '" data-userid=' + userid + '></div>');
     else
    $('#myTabContent').append('<div class="tab-pane fade display" id="' + win
    + '"data-userid=' + userid + '></div>');
}
function appendChatWindowTab(active, win) {
    if (active)
    $('#chat>ul').append($('<li class="active"><a id="' + win + 'Tab" href="#' + win
    + '" data-toggle="tab">' + win + '</a></li>'));
     else
    $('#chat>ul').append($('<li class=""><a id="' + win + 'Tab" href="#' + win
    + '" data-toggle="tab">' + win + '</a></li>'));
}
$(document).ready(function () {
	
	
	if(x!=cur){
		$(cur).fadeOut("slow");
		$(x).fadeIn("slow");
		return x;
		}
		else
			return cur;
	};
$(document).ready(function(){
	

	$(cur).show();
	
		
	$(document).on("click","#friendTab", function(){
		$("#chat").slideDown();
	});


	$(document).on("click","#registerButton", function(){
		change("#register","#login");
	});

});
    $(cur).show();
    $('#changeCars').click(function () {
        cur = change('#cars', cur);
    });
    $('#changeNew').click(function () {
        cur = change('#new', cur);
    });
    $(document).on('click', '#chat>ul>li>a', function () {
        console.log($(this).attr('href').split('#') [1]);
        activeChatWindow = $(this).attr('href').split('#') [1];
    });
    $(document).on('click', '#friendTab', function () {
        $('#chat').slideDown();
        console.log($(this).data('userid'));
        activeChatWindow = $(this).text();
        if (openChatWindows.length == 0) {
            
            appendChatWindow(true, activeChatWindow, $(this).data('userid'));
            appendChatWindowTab(true, activeChatWindow);
           
        } else if (!windowIsOpened($(this).data('userid'))) {
        
            appendChatWindowTab(false, activeChatWindow);
            appendChatWindow(false, activeChatWindow, $(this).data('userid'));
            $('#' + $(this).text() + 'Tab').trigger('click');
          
        } else {
            console.log('#' + $(this).text());
            $('#' + activeChatWindow + 'Tab').trigger('click');
        }
    });
    $(document).on('click', '#registerButton', function () {
        change('#register', '#login');
    });
});
