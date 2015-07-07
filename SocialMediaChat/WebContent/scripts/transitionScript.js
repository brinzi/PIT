/*Transition for Domains*/
	var cur="#new";
	
	function change(x, cur){
	
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