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
	

	
	$("#changeCars").click(function(){
		cur=change("#cars",cur);
	});
	
	$("#changeNew").click(function(){
		cur=change("#new",cur);
	});
	
	
	$(document).on("click","#friendTab", function(){
		$("#chat").slideDown();
	});


	$(document).on("click","#registerButton", function(){
		change("#register","#login");
	});

});