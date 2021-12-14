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

$("#dataTableOrder").on('click', '.delete', function() {
    var ID = $(this).closest('tr').find('td').eq(0).text();   
    $("#confirmDeleteOrder").modal("show");
    document.getElementById("idForDeleteOrder").value = ID;
    
});

$("#dataTableOrder").on('click', '.update', function() {
    var ID = $(this).closest('tr').find('td').eq(0).text();
    
    $("#detailOrder").modal("show");
});

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