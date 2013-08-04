/* Add Customer - submit button event - Start */
$(document).ready(function(){
	$("#saveButton").click(function() {
		if (!$("#productAddForm").validate().form()){
			return false;
		}
		
		$("#saveButton").attr("disabled","disabled");
		$("#waitText2").text('Please wait ... ');
		$("#saveButton").css('cursor','progress');
	
		var objForm = new FormData();
		objForm.append("productShortName", $("#productShortName").val());
		objForm.append("productName", $("#productName").val());
		objForm.append("productPrice", $("#productPrice").val());
		objForm.append("file", ($("#productImagePath"))[0].files[0]);
		 
		$.ajax({
			data: objForm,
			type: 'POST',
			url: contextPath+'/product/add.do',
		    cache:false,
		    processData:false,
		    contentType: false,
			success : function(data, textStatus, jqXHR) {
				$("#productAddForm")[0].reset();
				
				$("#saveButton").removeAttr("disabled","disabled");
				$("#saveButton").css('cursor','pointer');
				$("#waitText2").text('Save successful...');
				
				fetchAllRecords();
				
				hideAndFade("#waitText2", activateFetchArea);
			},
			error : function(jqXHR, textStatus, errorThrown) {
				console.log('error:', errorThrown);
				$("#saveButton").removeAttr("disabled","disabled");
				$("#waitText2").text('Save failed : '+errorThrown);
				$("#saveButton").css('cursor','pointer');
				
				hideAndFade("#waitText2");
			}
		});	
	});
});
/* Add Product - submit button event - End */