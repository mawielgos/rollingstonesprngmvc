<!DOCTYPE html>
<html lang="en-US">
<head>
<meta charset="UTF-8">

<title>Product Listing</title>
<link rel="stylesheet" href="resources/custom.css" media="all"/>
<link rel="stylesheet" href="resources/jquery/css/jquery-ui-1.10.2.smoothness.min.css" media="all"/>
<link rel="stylesheet" href="resources/jqwidgets/css/jqx.base.css" type="text/css" />

<script src="resources/jquery/js/jquery-1.9.1.min.js"></script>
<script src="resources/jquery/js/jquery-ui-1.10.2.smoothness.min.js"></script>
<script src="resources/jquery/js/jquery-validate.min.js"></script>

<script src="resources/jqwidgets/js/jqxcore.js"></script>
<script src="resources/jqwidgets/js/jqxdata.js"></script> 
<script src="resources/jqwidgets/js/jqxbuttons.js"></script>
<script src="resources/jqwidgets/js/jqxscrollbar.js"></script>
<script src="resources/jqwidgets/js/jqxmenu.js"></script>
<script src="resources/jqwidgets/js/jqxgrid.js"></script>
<script src="resources/jqwidgets/js/jqxgrid.selection.js"></script>
<script src="resources/jqwidgets/js/jqxtabs.js"></script>
<script src="resources/jqwidgets/js/jqxgrid.selection.js"></script>
<script src="resources/jqwidgets/js/jqxgrid.sort.js"></script> 
<script src="resources/jqwidgets/js/jqxwindow.js"></script>
<script src="resources/jqwidgets/js/jqxinput.js"></script>
<script src="resources/jqwidgets/js/jqxgrid.columnsresize.js"></script>

<script src="resources/jqwidgets/js/gettheme.js"></script>

<script src="resources/app-js/ProductListing.js"></script>
<script src="resources/app-js/product/addProductListing.js"></script>
<script src="resources/app-js/product/deleteProductListing.js"></script>
<script src="resources/app-js/product/editProductListing.js"></script>
<script src="resources/app-js/product/fetchProductListing.js"></script>

<script>
	rowCount=0;
	contextPath = '<%= request.getContextPath() %>';
	log = function(a,b){
	    if (typeof console!=="undefined"){
	        if(b == undefined){
	            console.log(a);
	        }else{
	            console.log(a+':',b);
	        }
	    }
	}
</script>
</head>

<body>
	<div id="accordionAll">
		<h3>Show all Products</h3>
		<div id="productAll">
			<button id="fetch" style="margin-right: 5px; font-size: 13px;">FETCH ALL</button><span id="waitText1"></span><button id="deleterowbutton" style="margin-right: 5px; font-size: 13px;">DELETE SELECTED</button><span id="waitText3"></span>
			<br><br>
			<div id='jqxWidget' style="float: left; width: 100%">
				<div id="jqxgrid"></div>
			</div>	
		</div>
		
		<h3>Add a Product</h3>
	 	<form id="productAddForm" action="#" method="POST">
		<div id="productAdd">
			<div id="accordionAdd">
				<h3>Product Details</h3>
				<div id="productMain">
					<table>
						<tr><td><label for="productName">Product Short Name : </label></td><td><input type="text" id="productShortName"/></td></tr>
						<tr><td><label for="productName">Product Name : </label></td><td><input type="text" id="productName"/></td></tr>
						<tr><td><label for="productName">Product Price  : </label></td><td><input type="text" id="productPrice"/></td></tr>
						<tr><td><label for="productName">Product Image : </label></td><td><input type="file" id="productImagePath"/></td></tr>
					</table>
					<br>
				</div>
			</div>
			<br>
			<button id="saveButton" style="margin-right: 5px; font-size: 13px;">SAVE</button>
			<span id="waitText2"></span>
			<button id="resetAdd" type="reset" style="font-size: 13px;">CLEAR</button>
		</div>
	 	</form>
	</div>

	<div id="popupWindow" style="display: none;">
		<div>Edit Product</div>
		<input id="ed_productId" type="hidden" />
		<input id="ed_productImageName" type="hidden" />
		<div style="overflow: hidden;">
			<table id="editTable">
				<tr>
					<td><label for="productName">Product Short Name : </label></td>
					<td><input type="text" id="ed_productShortName" /></td>
				</tr>
				<tr>
					<td><label for="productName">Product Name : </label></td>
					<td><input type="text" id="ed_productName" /></td>
				</tr>
				<tr>
					<td><label for="productName">Product Price : </label></td>
					<td><input type="text" id="ed_productPrice" /></td>
				</tr>
				<tr>
					<td><label for="productName">Product Image : </label></td>
					<td><input type="file" id="ed_productImagePath" /></td>
				</tr>
				<tr>
					<td></td>
					<td>
						<label><input type="checkbox" id="ed_sameImage" checked="checked"/><span style="cursor: pointer;">Keep the same image</span></label>
					</td>
				</tr>
				<tr class="ed_temp_button">
					<td style="padding-top: 10px;" align="right" colspan="2">
						<p id="waitText4"></p>
						<input style="margin-right: 5px;" type="button" id="ed_save" value="Save" />
						<input id="Cancel" type="button" value="Cancel" />
					</td>
				</tr>
			</table>
		</div>
	</div>
</body>
</HTML>
<script>
$(function(){
	$("#productMain").css( "height", "100%" );
});
</script>