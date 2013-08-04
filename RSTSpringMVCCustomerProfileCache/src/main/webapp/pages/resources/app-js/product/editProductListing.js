/* Edit a Customer - ed_save button event - Start */
var editSave = function(){
	$("#ed_save").attr("disabled","disabled");
	$("#waitText4").text('Please wait ... ');
	$("#ed_save").css('cursor','progress');

	var ed_objForm = new FormData();
	ed_objForm.append("productId", $("#ed_productId").val());
	ed_objForm.append("productShortName", $("#ed_productShortName").val());
	ed_objForm.append("productName", $("#ed_productName").val());
	ed_objForm.append("productPrice", $("#ed_productPrice").val());
	if (($("#ed_productImagePath"))[0].files[0] == undefined){
		ed_objForm.append("file", null);
	}else{
		ed_objForm.append("file", ($("#ed_productImagePath"))[0].files[0]);	
	}
	ed_objForm.append("sameImage", $("#ed_sameImage")[0].checked);
	ed_objForm.append("productImageName", $("#ed_productImageName").val());

	$.ajax({
		data: ed_objForm,
		type: 'POST',
		url: contextPath+'/product/update.do',
	    cache:false,
	    processData:false,
	    contentType: false,
		success : function(data, textStatus, jqXHR) {
			$("#ed_save").removeAttr("disabled","disabled");
			$("#waitText4").text('Save successful...');
			hideAndFade("#waitText4");
			$("#ed_save").css('cursor','pointer');
			
			fetchAllRecords();			
            $("#popupWindow").jqxWindow('hide');
		},
		error : function(jqXHR, textStatus, errorThrown) {
			console.log('error:', errorThrown);
			$("#ed_save").removeAttr("disabled","disabled");
			$("#waitText4").text('Save failed : '+errorThrown);
			hideAndFade("#waitText4");
			$("#ed_save").css('cursor','pointer');
		}
	});
};
/* Edit a Customer - ed_save button event - Start */