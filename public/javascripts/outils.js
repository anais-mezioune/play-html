(function($){
	
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



/*function display($(content))){
	if ($(content).css('display', 'none')){
		$content.css('display', 'block');
    } else{
    	$(content).css("display", "none");
    }
}*/