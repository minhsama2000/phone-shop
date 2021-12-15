$('#dataTableOrder').DataTable({
	  select: true,
	  ajax: {
          url: "/admin/api/v1/orders/orders",
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
        	"targets":4,
        	"center":true,
        	"render": function(data,type,full,meta){
        		var del = '<button class="btn btn-primary  update">Edit</button> <button class="btn btn-danger delete">Delele</button>';
        		return del;
        	}
        	
        }],
  });

$('#dataTableDonOder').DataTable({
	  select: true,
	  ajax: {
        url: "/admin/api/v1/orders/orders-status?status=4",
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
      	"targets":4,
      	"center":true,
      	"render": function(data,type,full,meta){
      		var del = '<button class="btn btn-primary  update">Edit</button> <button class="btn btn-danger delete">Delele</button>';
      		return del;
      	}
      	
      }],
});

$("#dataTableOrder").on('click', '.delete', function() {
    var ID = $(this).closest('tr').find('td').eq(0).text();   
    $("#confirmDeleteOrder").modal("show");
    document.getElementById("idForDeleteOrder").value = ID;
    
});

$("#dataTableOrder").on('click', '.update', function() {
    var ID = $(this).closest('tr').find('td').eq(0).text();
    $("#selectStatus").empty();
    $("#reviewUserOrder").empty();
    $("#bodyReviewOrder").empty();
    				$.ajax({
						url : "/admin/api/v1/orders/order/"+ID,
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
								html = '<select class="js-select2"'
									+'	onchange="updateOrderStatus('+ data.id +',this)"'
									+'		name="property">'
									+'		<option selected="selected" value="1">' +data.orderStatus + '</option>'
									+'		<option value="2">Xác nhận</option>'
									+'		<option value="3">Xác nhận đang giao hàng</option>'
									+'		<option value="4">Hoàn thành giao hàng</option>'
									+'</select>';
									$("#selectStatus").html(html);
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

$("#dataTableDonOder").on('click', '.update', function() {
    var ID = $(this).closest('tr').find('td').eq(0).text();
    $("#reviewUserOrder").empty();
    $("#bodyReviewOrder").empty();
    				$.ajax({
						url : "/admin/api/v1/orders/order/"+ID,
						type : "GET",
						success : function(responseData){
							var html = "";
							var htmlv2 = "";
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

function updateOrderStatus(orderId,status){
	 var value = status.value;
	  $.ajax({
			url:"/admin/api/v1/orders/order?orderId="+orderId+"&orderStatus="+value,
			method: 'put',
	        contentType: 'application/json',
			success : function(data){
				
				if(data.status == 200){
					$('#dataTableOrder').DataTable().ajax.reload();	
					$('#dataTableDonOder').DataTable().ajax.reload();	
					alert("success");
				}else{
					alert(data.message);
				}
			},
			error : function(jqXHR,testStatus,errorThrown){
				alert("cannot change!")
				console.log(jqXHR);
				console.log(testStatus);
				console.log(errorThrown);
			}
		});
}

$(document).ready(function(){
	$("#buttonDeleteOrder").on("click",function(){
		var id = document.getElementById("idForDeleteOrder").value;
		$.ajax({
			url : "/admin/api/v1/orders/order/"+id,
			type : "DELETE",
			success : function(data){
					updateContainer();
					$.ajax({
						url : "/admin/api/v1/orders/order/"+id,
						type : "DELETE",
						success : function(data){
								$('#dataTableOrder').DataTable().ajax.reload();
								$("#confirmDeleteOrder").modal("hide");	
						},
						error : function(jqXHR,testStatus,errorThrown){	
							$('#dataTableOrder').DataTable().ajax.reload();
							$("#confirmDeleteOrder").modal("hide");
							setErrorLog("cannot delete this order !")
							console.log(jqXHR);
							console.log(testStatus);
							console.log(errorThrown);
						}
					});
					$('#dataTableOrder').DataTable().ajax.reload();
					$("#confirmDeleteOrder").modal("hide");	
			},
			error : function(jqXHR,testStatus,errorThrown){	
				$('#dataTableOrder').DataTable().ajax.reload();
				$("#confirmDeleteOrder").modal("hide");
				setErrorLog("cannot delete this order !")
				console.log(jqXHR);
				console.log(testStatus);
				console.log(errorThrown);
			}
		});
	});	
});