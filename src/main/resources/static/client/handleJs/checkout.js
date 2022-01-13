function validateOrder(){
	var fullname = $("#customerName").val();
	var email = $("#customerEmail").val();
	var address = $("#customerAddress").val();
	var phone = $("#customerPhone").val();
	if(fullname == ""){
		alert("tên không được trống!")
		return false;
	}
	if(email == ""){
		alert("email không được trống!")
		return false;
	}
	if(address == ""){
		alert("địa chỉ không được trống!")
		return false;
	}
	if(phone == ""){
		alert("số điện thoại không được trống!")
		return false;
	}
	return true;
}

(function () {
	loadCartCheckout()
})();

function loadCartCheckout(){
	$("#orderCheckout").empty();
	var total = 0;
	$.ajax({
		url : "/api-security/v1/carts/carts",
		type:"GET",
		dataType: 'json',
	    contentType: "application/json; charset=utf-8",
		success:function(responseData){
			var html = "";
			var data = responseData.data;
			if(responseData.status == 200){
				for(var i=0;i<data.length;i++){		
					html += '<li class="product_name">'+data[i].name+' <strong'
						+' class="product_quantity">× '+data[i].quantity+'</strong>'
						+' <span class="totalSingleCheckout">'+data[i].quantity*data[i].price  +'đ</span>	</li>';
					total += data[i].price*data[i].quantity;
				}
			}
			$("#totalCheckout").html(total+"đ")
			$("#orderCheckout").html(html);
		},
		error : function(jqXhr, textStatus, errorMessage) { // error
			// callback			
							
		} 
	});
}

function checkout(){
	var fullname = $("#customerName").val();
	var email = $("#customerEmail").val();
	var address = $("#customerAddress").val();
	var phone = $("#customerPhone").val();
	var paymentMethod = $("#paymentMethod").val();
	if(validateOrder()){
		$.ajax({
			url : "/api/v1/checkout/order",
			type:"POST",
			data : JSON.stringify({
				customerName : fullname,
				customerEmail : email,
				customerAddress : address,
				customerPhone : phone,
				paymentMethod : paymentMethod
			}),
			dataType: 'json',
	        contentType: 'application/json',
			success: function(responseData){
				if(responseData.status == 200){
					alert("success");
					console.log(responseData);
				}
				if(responseData.status == 415){
					alert("have no cart");
				}
			},
			error : function(jqXhr, textStatus, errorMessage) { // error
				// callback
				
			}
		});
	}
}