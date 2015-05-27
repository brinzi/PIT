/*Transition for Domains*/
$(document).ready(function(){
	
	var cur="#new";
	
	$(cur).show();
	
	function change(x, cur){
	
	if(x!=cur){
		$(cur).fadeOut("slow");
		$(x).fadeIn("slow");
		return x;
		}
		else
			return cur;
	};
	
	$("#changeCars").click(function(){
		cur=change("#cars",cur);
	});
	
	$("#changeNew").click(function(){
		cur=change("#new",cur);
	});

	

});