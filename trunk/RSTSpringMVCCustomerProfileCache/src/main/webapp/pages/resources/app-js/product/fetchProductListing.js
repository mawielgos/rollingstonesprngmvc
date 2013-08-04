var fetchAllRecords = function (){
	$("#jqxgrid").remove();
	
	$("#fetch").attr("disabled","disabled");
	$("#waitText1").text('Please wait ... ');
	$("#fetch").css('cursor','progress');

	$.ajax({
		type: 'GET',
		url: contextPath+'/product/list.view',
		dataType: 'json',
		success : function(responseData, textStatus, jqXHR) {
			$('<div id="jqxgrid"></div>').appendTo($("#jqxWidget"));

			$("#fetch").removeAttr("disabled","disabled");
			$("#waitText1").text('');
			$("#fetch").css('cursor','pointer');
			
			var data = new Array();

			for (x in responseData){
				var row = {};
				row["productId"] = responseData[x].productId;
				row["productShortName"] = responseData[x].productShortName;
				row["productName"] = responseData[x].productName;
				row["productPrice"] = responseData[x].productPrice;
				row["productImagePath"] = responseData[x].productImagePath;
				
				data[x] = row;
			}

			var source = {
					localdata: data,
					datatype: "array"
			};

			var initrowdetails = function (index, parentElement, gridElement, datarecord) {
				var imagePath = datarecord.productImagePath;
				var img = "<img id='prodImage' src='"+contextPath+"/product/image.view?imagePath="+imagePath
					+ "' style='-webkit-user-select: none; border:1px solid #ABABAB; border-radius: 4px;width:80px;height:80px;'/>";
				var tabsdiv = $($(parentElement).children()[0]);
				$(tabsdiv).append(img);
			};
			var dataAdapter = new $.jqx.dataAdapter(source);
			var editrow = -1;

			$("#jqxgrid").jqxGrid({
				width: 510,
				autoheight: true,
				source: dataAdapter,
				theme: theme,
				rowdetails: true,
				columnsresize: true,
				autoshowcolumnsmenubutton: false,
				sortable: true,
				rowdetailstemplate: { rowdetails: "<div style='margin: 10px;'></div>", rowdetailsheight: 100 },
				ready: function () {
					$("#jqxgrid").jqxGrid('sortby', 'customerName', 'asc');
				},
				initrowdetails: initrowdetails,
				columns: [
				          { text: 'Short Name', datafield: 'productShortName', width: 120 },
				          { text: 'Name', datafield: 'productName', width: 180 },
				          { text: 'Price', datafield: 'productPrice', width: 100, filtertype: 'number' },
				          { text: 'Edit', datafield: 'Edit', columntype: 'button', sortable: false, cellsrenderer: function () {
				        	  return "Edit";
					          }, buttonclick: function (row) {
					        	  editrow = row;
					        	  var offset = $("#jqxgrid").offset();

					        	  dataRecord_row = $("#jqxgrid").jqxGrid('getrowdata', editrow);

					        	  $("#ed_productId").val(dataRecord_row.productId);
					        	  $("#ed_productShortName").val(dataRecord_row.productShortName);
					        	  $("#ed_productName").val(dataRecord_row.productName);
					        	  $("#ed_productPrice").val(dataRecord_row.productPrice);
					        	  $("#ed_productImageName").val(dataRecord_row.productImagePath);
					        
					        	  $("#popupWindow").jqxWindow({
					        		  position: { x: parseInt(offset.left) + 160, y: parseInt(offset.top) + 60 }, 
					        		  height: 220, 
					        		  width: 410, 
					        		  resizable: true, 
					        		  theme: theme, 
					        		  isModal: true, 
					        		  cancelButton: $("#Cancel"), 
					        		  modalOpacity: 0.5, 
					        		  showCloseButton: true           
					        	  });
					        	  $("#popupWindow").jqxWindow('open');
					        	  
					        	  $("#popupWindow").on('open', function () {
					        		  $("#ed_productShortName").jqxInput('selectAll');
					        	  });						        	  
								  $("#Cancel").jqxButton({ theme: theme });
								  $("#ed_save").jqxButton({ theme: theme });
								  
								  $("#ed_save").on('click', editSave);
					          }
				          }
				   ]
			});
		},
		error : function(jqXHR, textStatus, errorThrown) {
			console.log('error:', errorThrown);
			$("#fetch").removeAttr("disabled","disabled");
			$("#waitText1").text('Error: '+textStatus);
			$("#fetch").css('cursor','pointer');
			hideAndFade("#waitText1");
		}
	});
};