$('#dataTableUser').DataTable({
	  select: true,
	  ajax: {
          url: "/admin/api/v1/users/users",
          method: "get",
        },
        "columns": [
          { data: "id"},
          { data: "name" },
          { data: "email" },
          { data: "phone" },
          { data: "address" },
        ],
        "columnDefs": [{
        	"targets":5,
        	"center":true,
        	"render": function(data,type,full,meta){
        		var del = '<button class="btn btn-primary  update">Cập nhật</button>';
        		return del;
        	}
        	
        }],
  });

$("#dataTableUser").on('click', '.update', function() {
    var ID = $(this).closest('tr').find('td').eq(0).text();
    				$.ajax({
						url : "/admin/api/v1/users/user?id="+ID,
						type : "GET",
						success : function(responseData){
							var html = "";
							var data = responseData.data;
							if(responseData.status == 200){
								html = '<select class="js-select2"'
									+'	onchange="updateUserRole('+ data.id +',this)"'
									+'		name="property">'
									+'		<option selected="selected" value="' +data.role + '">' +data.role + '</option>'
									+'		<option value="USER">USER</option>'
									+'		<option value="ADMIN">ADMIN</option>'
									+'</select>';
								$("#selectUserRole").html(html);
								$("#usernameDetail").html(data.name);
								$("#outputUserRole").html(data.avatar);
							}
						},
						error : function(jqXHR,testStatus,errorThrown){	
							console.log(jqXHR);
							console.log(testStatus);
							console.log(errorThrown);
						}
					});

    $("#detailUser").modal("show");
});

function updateUserRole(id,option){
	 var value = option.value;
	 $.ajax({
			url:"/admin/api/v1/users/user?id="+ id +"&role="+value,
			method: 'put',
	        contentType: 'application/json',
			success : function(data){
				
				if(data.status == 200){
					$('#dataTableUser').DataTable().ajax.reload();		
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