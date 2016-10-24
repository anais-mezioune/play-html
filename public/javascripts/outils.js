(function($){
	
	$("#main-nav-bar").click(function() {
	    $("#main-nav-bar").prepend("<span class='bouton-moins'>-</span>");
	    display(".bar-nav-bar");
	    display("#main-nav");
		
	});
	
	
	$(".section-list > li:first").click(function() {
	    display(".section-list > li:first .content-description");
	});
	
	$(".section-list > li:last").click(function() {
	    display(".section-list > li:last .content-description");
	});
	
	function display(content){
		var content = content;
		if ($(content).css('display') == "none"){
			$(content).css('display', 'block');
	    } else{
	    	$(content).css("display", "none");
	    }
	};
})(jQuery);



/*
 * .index() -> retourne l'index de l'element courant
 * 
 * 
 function display($(content))){
	if ($(content).css('display', 'none')){
		$content.css('display', 'block');
    } else{
    	$(content).css("display", "none");
    }
}*/