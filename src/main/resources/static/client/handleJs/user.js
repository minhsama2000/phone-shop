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
$('#dataTableUser').DataTable({
	  select: true,
	  ajax: {
        url: "/api-security/v1/orders/orders",
        method: "get",
      },
      "columns": [
        { data: "id"},
        { data: "codeName" },
        { data: "createdDate" },
        { data: "orderStatus" },
        { data: "total" },
      ],
      "columnDefs": [{
      	"targets":5,
      	"center":true,
      	"render": function(data,type,full,meta){
      		var del = '<button class="btn btn-primary detail">Detail</button> <button class="btn btn-danger delete">Delele</button>';
      		return del;
      	}
      	
      }],
});

$("#dataTableUser").on('click', '.delete', function() {
    var ID = $(this).closest('tr').find('td').eq(0).text();   
    $("#confirmDeleteOrder").modal("show");
    document.getElementById("idForDeleteOrder").value = ID;
    
});

$("#dataTableUser").on('click', '.detail', function() {
    var ID = $(this).closest('tr').find('td').eq(0).text();
    $("#reviewUserOrder").empty();
    $("#bodyReviewOrder").empty();
    				$.ajax({
						url : "/api-security/v1/orders/order/"+ID,
						type : "GET",
						success : function(responseData){
							var html = "";
							var htmlv2 = "";
							var htmlv3 = "";
							var data = responseData.data;
							var datav2 = responseData.data.dhOrderProductDtos;
							if(responseData.status == 200){
								htmlv3 = '<ul class="list-group">'
									+'  <li class="list-group-item">'+data.customerName+'</li>'
									+' <li class="list-group-item">'+data.customerPhone+'</li>'
									+' <li class="list-group-item">'+data.customerEmail+'</li>'
									+' <li class="list-group-item">'+data.customerAddress+'</li>'
									+'</ul>';
									$("#reviewUserOrder").html(htmlv3);
									for(var i=0;i<datav2.length;i++){
										htmlv2 += '<tr>'
										+'	<td>'+ datav2[i].productId +'</td>'
										+'	<td>'+ datav2[i].name +'</td>'
										+'	<td>'+ datav2[i].quantity +'</td>'
										+'	<td>'+ datav2[i].price +'</td>'
										+'	<td>'+ datav2[i].price*datav2[i].quantity +'</td>'
										+'	</tr>';
									}
									$("#bodyReviewOrder").html(htmlv2);
							}
						},
						error : function(jqXHR,testStatus,errorThrown){	
							console.log(jqXHR);
							console.log(testStatus);
							console.log(errorThrown);
						}
					});

    $("#detailOrder").modal("show");
});



$(document).ready(function(){
	$("#buttonDeleteOrder").on("click",function(){
		var id = document.getElementById("idForDeleteOrder").value;
		$.ajax({
			url : "/api-security/v1/orders/order/"+id,
			type : "DELETE",
			success : function(data){
					$.ajax({
						url : "/admin/api/v1/orders/order/"+id,
						type : "DELETE",
						success : function(data){
								$('#dataTableUser').DataTable().ajax.reload();
								$("#confirmDeleteOrder").modal("hide");	
						},
						error : function(jqXHR,testStatus,errorThrown){	
							$('#dataTableUser').DataTable().ajax.reload();
							$("#confirmDeleteOrder").modal("hide");
							setErrorLog("cannot delete this order !")
							console.log(jqXHR);
							console.log(testStatus);
							console.log(errorThrown);
						}
					});
					$('#dataTableUser').DataTable().ajax.reload();
					$("#confirmDeleteOrder").modal("hide");	
			},
			error : function(jqXHR,testStatus,errorThrown){	
				$('#dataTableUser').DataTable().ajax.reload();
				$("#confirmDeleteOrder").modal("hide");
				setErrorLog("cannot delete this order !")
				console.log(jqXHR);
				console.log(testStatus);
				console.log(errorThrown);
			}
		});
	});	
});