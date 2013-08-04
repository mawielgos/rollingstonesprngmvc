$(document).ready(function(){
	theme = getDemoTheme();
	
	/* Setting style on the buttons - Start */	
	$("#saveButton").jqxButton({ theme: theme });
	$("#resetAdd").jqxButton({ theme: theme });
	$("#fetch").jqxButton({ theme: theme });
	$("#deleterowbutton").jqxButton({ theme: theme });
	/* Setting style on the buttons - End */
	
	/* Enabling form validation - Start */
	$('#productAddForm input').attr('class', 'required');
	$("#productAddForm").validate();
	/* Enabling form validation - End */

	/* Accordion for outer most area */
	$( "#accordionAll" ).accordion({
		collapsible: true,
		/* active: false, */
		active:0,
		heightStyle: "content",
		activate: function( event, ui ) {
			$("#productShortName").focus();
		}
	});

	/* Accordions for inside add customer */
	$( "#accordionAdd" ).accordion({
		collapsible: true,
		active: 0
	});

	/* Fetch all Customer - fetch button event - Start */
	$( "#fetch" ).click(function() {
		fetchAllRecords();
	});
});

/* Hide slowly effect */
var hideAndFade = function(selector, callback){
	setTimeout(function() {
		$(selector).text('');
		if (callback && typeof(callback) === "function") {  
	        callback();
	    }
	}, 1000);
};

/* Activate the fetch area */
var activateFetchArea = function(){
	$( "#accordionAll" ).accordion( {active:0} );	
}
