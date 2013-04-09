<!DOCTYPE HTML>
<head>
<title>Add Customer</title>
<link rel="stylesheet" href="resources/jquery/css/jquery-ui-1.10.2.smoothness.min.css" media="all"/>
<link rel="stylesheet" href="resources/jquery/css/custom.css" media="all"/>
<script src="resources/jquery/js/jquery-1.9.1.min.js"></script>
<script src="resources/jquery/js/jquery-ui-1.10.2.smoothness.min.js"></script>
<script>
	/* $(function() {
	    $( "#accordion" ).accordion();
	}); */
	$(function() {
	    $( "#custMemberSince, #cardExpDate" ).datepicker();
	});
	
	rowCount=0;
</script>
</head>

<body>

<div id="accordion">
	<h3>Customer Details</h3>
	<div id="customerMain">
		<label>Customer Name : </label><input type="text" id="custName" name="customerName"/>
		<label>Member since : </label><input type="text" id="custMemberSince" name="memberSince" /> 
		<label>Balance : </label><input type="text" id="custBalance" name="balance" />
	</div>

	<h3>Address</h3>
	<div id="addressDetails">
		<label>House Number : </label><input type="text" id="addrHouseNumber" name="houseNumber"/>
		<label>Street : </label><input type="text" id="addrHouseStreet" name="street"/> 
		<label>City : </label><input type="text" id="addrCity" name="city"/> 
		<label>State : </label><input type="text" id="addrState" name="state"/> 
		<label>Country : </label><input type="text" id="addrCountry" name="country"/>
	</div>

	<h3>Credit Card</h3>
	<div id="creditCardDetails">
		<label>Card Number : </label><input type="text" id="cardNumber" name="cardNumber"/> 
		<label>Security code : </label><input type="text" id="cardSecurityCode" name="securityCode"/> 
		<label>Exp. Date : </label><input type="text" id="cardExpDate" name="expDate"/> 
		<label>Card Type : </label><input type="text" id="cardType" name="cardType"/>
	</div>

	<h3>Contact Details</h3>
	<div id="contactDetails">
		<table id="contactTable">
			<tr id="rowList0">
				<td><img id="addRow" src="./resources/add.png" alt="Add" style="cursor: pointer;"></td>
				<td><label>Phone Number : </label><input type="text" id="contactPhoneNumber" name="phoneNumber"/></td>
				<td><label>Phone Type : </label><input type="text" id="contactPhoneType" name="phoneType"/></td> 
			 	<td><label>Contact Type : </label><input type="text" id="contactType" name="contactType"/></td>
			 	<td><label>Email Id : </label><input type="text" id="contactEmailId" name="emailId"/></td>
			</tr>
		</table>
	</div>
</div>
<br>
<button id="submit">SAVE</button><p id="waitText"></p>
</body>
</HTML>
<script>
	var allInputs = $(":input");
	$("#addRow").click(function(){
		var row = $("#contactTable tr:first").html();
		rowCount=rowCount+1;
		var rowId = "rowList"+rowCount;
		$("#contactTable tr:last").after('<tr id="'+rowId+'">'+row+'</tr>');
	});

	$("#submit").click(function() {
		$("#submit").attr("disabled","disabled");
		$("#waitText").text('Please wait ... ');
		
		var arr = [];
		
		for (var count=0; count<=rowCount; count++){
			console.log($("#rowList"+count+" [name~='phoneNumber']").val());
		    var contact = {
		    		phoneNumber: $("#rowList"+count+" [name~='phoneNumber']").val(),
		    		phoneType: $("#rowList"+count+" [name~='phoneType']").val(),
		    		contactType: $("#rowList"+count+" [name~='contactType']").val(),
		    		emailId : $("#rowList"+count+" [name~='emailId']").val(),
			    };
		    arr.push(contact);
		}

		console.log(arr);
		
		formElements = new Object({
			customerId : 1,
			customerName: $("#custName").val(), 
		  	memberSince: new Date($("#custMemberSince").val()),
		  	balance: parseFloat($("#custBalance").val()),
		  	customerAddress : {
		  		houseNumber: $("#addrHouseNumber").val(),
		  		street: $("#addrHouseStreet").val(),
		  		city: $("#addrCity").val(),
		  		state: $("#addrState").val(),
		  		country: $("#addrCountry").val()
		  	},
		  	defaultCard: {
		  		cardNumber : $("#cardNumber").val(),
		  		securityCode : $("#cardSecurityCode").val(),
		  		expDate : new Date($("#cardExpDate").val()),
		  		cardType : $("#cardType").val()
		  	},
		  	contacts : arr
		  	/* contacts : [{
		  		phoneNumber : $("#contactPhoneNumber").val(),
		  		phoneType : $("#contactPhoneType").val(),
		  		contactType : $("#contactType").val(),
		  		emailId : $("#contactEmailId").val()
		  	}] */
	  	});
		
		$.ajax({
			type: 'POST',
			url: '<%=request.getContextPath() %>/customer/add.do',
			dataType: 'json',
			contentType: "application/json; charset=utf-8",
			data: JSON.stringify(formElements),
			success : function(data, textStatus, jqXHR) {
				console.log('data:', data);
				$("#submit").removeAttr("disabled","disabled");
				$("#waitText").text('Save successful');
			},
			error : function(jqXHR, textStatus, errorThrown) {
				console.log('error:', errorThrown);
				$("#submit").removeAttr("disabled","disabled");
				$("#waitText").text('Save failed : '+errorThrown);
			}
		});
		
	});
</script>