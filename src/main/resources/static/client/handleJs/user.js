function validateUser(){
	var name = $("#name").val();
	var phone = $("#phone").val();
	var address = $("#address").val();
	var email = $("#email").val();
	if(name == ""){
		alert("Tên không được trống");
		return false;
	}
	if(phone == ""){
		alert("Số dt không được trống");
		return false;
	}
	if(address == ""){
		alert("Địa chỉ không được trống");
		return false;
	}
	if(email == ""){
		alert("Email không được trống");
		return false;
	}
	return true;
}

function uploadUser(event){
	event.preventDefault();
	var form = $("#userUploadForm")[0];
    var data = new FormData(form);
    if(validateUser()){
    	$.ajax({
			url : "/api/v1/users/user-update",
			type:"PUT",
			enctype: 'multipart/form-data',
			data : data,
			
			processData: false,
		    contentType: false,
		    cache: false,
		    timeout: 1000000,
			success : function(jsonResult){
				if(jsonResult.status == 200){	
					alert("Cập nhật thông tin thành công!");
					console.log(jsonResult.data);
				}else{
					alert("Cập nhật thông tin thất bại!");
				}
			},
			error : function(jqXhr, textStatus, errorMessage) { // error
				// callback

			} 
		});
    }
}