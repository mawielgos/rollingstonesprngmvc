/* Delete selected row - Start */
$(document).ready(function(){
	$("#deleterowbutton").on('click', function () {
		$("#deleterowbutton").attr("disabled","disabled");
		$("#waitText3").text('Please wait ... ');
		$("#deleterowbutton").css('cursor','progress');
		
		var id = null;
		var customerId = null;
		try {
			var selectedrowindex = $("#jqxgrid").jqxGrid('getselectedrowindex');
			var rowscount = $("#jqxgrid").jqxGrid('getdatainformation').rowscount;
			if (selectedrowindex >= 0 && selectedrowindex < rowscount) {
				id = $("#jqxgrid").jqxGrid('getrowid', selectedrowindex);
			}
		}catch(err){}
	
		if (id != null){
			customerId = $('#jqxgrid').jqxGrid('getrowdata', id).customerId;	
	
			$.ajax({
				type: 'GET',
				url: contextPath+'/product/remove.do?productId='+productId,
				dataType: 'json',
				success : function(responseData, textStatus, jqXHR) {
					var commit = $("#jqxgrid").jqxGrid('deleterow', id);
					$("#deleterowbutton").removeAttr("disabled","disabled");
					$("#waitText3").text('Row deleted successfully');
					$("#deleterowbutton").css('cursor','pointer');
					
					hideAndFade("#waitText3");
				},
				error : function(jqXHR, textStatus, errorThrown) {
					console.log('error: '+textStatus);
					$("#deleterowbutton").removeAttr("disabled","disabled");
					$("#waitText3").text('Error: '+textStatus);
					hideAndFade("#waitText3");
					$("#deleterowbutton").css('cursor','pointer');
				}
			});
		} else {
			$("#deleterowbutton").removeAttr("disabled","disabled");
			$("#waitText3").text('Please select a row');
			hideAndFade("#waitText3");
			$("#deleterowbutton").css('cursor','pointer');
		}
	});
});
/* Delete selected row - End */