function validateContact(){
	var name = $("#contact_name").val();
	var phone = $("#contact_phone").val();
	var email = $("#contact_email").val();
	var message = $("#contact_message").val();
	if(name == ""){
		alert("Tên trống");
		return false;
	}
	if(phone == ""){
		alert("Số dt trống");
		return false;
	}
	if(email == ""){
		alert("Email trống");
		return false;
	}
	if(message == ""){
		alert("Message trống");
		return false;
	}
	return true;
}

function sendContact(){
	var name = $("#contact_name").val();
	var phone = $("#contact_phone").val();
	var email = $("#contact_email").val();
	var message = $("#contact_message").val();
	if(validateContact){
		$.ajax({
			url : "/api/v1/contact/contact",
			type:"POST",
			data : {
				name : name,
				email : email,
				phone : phone,
				message : message,
			},
		    dataType : 'json',
			success : function(jsonResult){
				if(jsonResult.status == 200){	
					alert("Cảm ơn đã phản hồi cho chúng tôi!");
				}else{
					alert("Phản hồi không thành công!");
				}
			},
			error : function(jqXhr, textStatus, errorMessage) { // error
				// callback

			} 
		});
	}
}