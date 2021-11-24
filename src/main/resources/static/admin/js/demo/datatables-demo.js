

	(function () {
		updateContainer();
	})();
	
	$("#addCate").click(function(){
		 $("#newCate").modal("show");
	});
	
	$("#dataTableCate").on('click', '.update', function() {
	    var ID = $(this).closest('tr').find('td').eq(0).text();
	    detailCategory(ID);    
	    $("#detailCategory").modal("show");
	});
	
	$("#dataTableCate").on('click', '.delete', function() {
	    var ID = $(this).closest('tr').find('td').eq(0).text();   
	    $("#confirmDeleteCate").modal("show");
	    document.getElementById("idForDeleteCate").value = ID;
	    
	});
	
  $('#dataTableCate').DataTable({
	  select: true,
	  ajax: {
          url: "/admin/api/v1/category/categories",
          method: "get",
        },
        "columns": [
          { data: "id"},
          { data: "name" },
          { data: "created_date" },
          { data: "updated_date" },
        ],
        "columnDefs": [{
        	"targets":4,
        	"center":true,
        	"render": function(data,type,full,meta){
        		var del = '<button onclick="editCategory()" class="btn btn-primary  update">Edit</button> <button class="btn btn-danger delete">Delele</button>';
        		return del;
        	}
        	
        }],
  });

function addNewCate(event){
	event.preventDefault();
	var cateName = $("#cateName").val();
	var parentId = $("#parentCategory").children("option:selected").val();
	if(validateCate(cateName)){
		$.ajax({
			url:"/admin/api/v1/category/category",
			type:"POST",
			data : JSON.stringify({
				name:cateName,
				parent_id:parentId
			}),
			contentType: "application/json",
			success : function(responseData){
				if(responseData.status == "200"){
					alert("Thêm danh mục thành công!");
					updateContainer();
					$('#dataTableCate').DataTable().ajax.reload();
				}else{
					alert("Thêm danh mục thất bại!");
				}
			},
			error : function(jqXhr, textStatus, errorMessage) { // error
				// callback

			} 
		});
	}else{
		setErrorLog("tên danh mục không được null!");
	}
}

function updateCate(event){
	event.preventDefault();
	var cateId = $("#cateIdUpdate").val();
	var cateName = $("#cateNameUpdate").val();
	var parentId = $("#parentCategoryUpdate").children("option:selected").val();
	if(validateCate(cateName)){
		$.ajax({
			url:"/admin/api/v1/category/category",
			type:"PUT",
			data : JSON.stringify({
				id : cateId,
				name:cateName,
				parent_id:parentId
			}),
			contentType: "application/json",
			success : function(responseData){
				if(responseData.status == "200"){
					setErrorLog("Cập nhật danh mục thành công!");
					updateContainer();
					$('#dataTableCate').DataTable().ajax.reload();
				}else{
					setErrorLog("Cập nhật danh mục thất bại!");
				}
			},
			error : function(jqXhr, textStatus, errorMessage) { // error
				// callback

			} 
		});
	}else{
		setErrorLog("tên danh mục không được null!");
	}
}

function updateContainer(){
	updateParentCategory();
	
}

function updateParentCategory(){
	$("#parentCategory").empty();
		$.ajax({
			url:"/admin/api/v1/category/categories",
			type:"GET",
			success : function(responseData){
				var html = "<option value=''></option>";
				var data = responseData.data;
				for(var i=0;i<responseData.data.length;i++){
					html += "<option value='" + data[i].id +  "'>" + data[i].name +"</option>";
				}
				
				$("#parentCategory").html(html);
				
			},
			error : function(jqXhr, textStatus, errorMessage) { // error
				// callback

			} 
		});	
}

function detailCategory(id){
	$("#parentCategoryUpdate").empty();
	var html = "";
	$.ajax({
		url:"/admin/api/v1/category/category",
		type:"GET",
		data : {
			id : id,
		},
		success : function(responseData){
			var data = responseData.data;
			document.getElementById("cateNameUpdate").value = data.name;
			document.getElementById("cateIdUpdate").value = data.id;
			if(data.parent_id != null){
				$.ajax({
					url:"/admin/api/v1/category/category",
					type:"GET",
					data : {
						id : data.parent_id,
					},
					success : function(responseData){
						var data = responseData.data;
						html = "<option value='" + data.id + "'>"+ data.name +"</option>";
						$("#parentCategoryUpdate").html(html);
					},
					error : function(jqXhr, textStatus, errorMessage) { // error
						// callback

					} 
				});	
			}else{
				html = "<option value=''></option>";
				$("#parentCategoryUpdate").html(html);
			}	
				
			$.ajax({
				url:"/admin/api/v1/category/categories",
				type:"GET",
				success : function(responseData){
					var data = responseData.data;
					for(var i=0;i<responseData.data.length;i++){
						html += "<option value='" + data[i].id +  "'>" + data[i].name +"</option>";
					}
					$("#parentCategoryUpdate").html(html);
				},
				error : function(jqXhr, textStatus, errorMessage) { // error
					// callback

				} 
			});			
		},
		error : function(jqXhr, textStatus, errorMessage) { // error
			// callback

		} 
	});
}

$(document).ready(function(){
	$("#buttonDeleteCate").on("click",function(){
		var id = document.getElementById("idForDeleteCate").value;
		$.ajax({
			url : "/admin/api/v1/category/category",
			type : "DELETE",
			data : {
				id : id
			},
			success : function(data){
					updateContainer();
					$('#dataTableCate').DataTable().ajax.reload();
					$("#confirmDeleteCate").modal("hide");	
			},
			error : function(jqXHR,testStatus,errorThrown){	
				$('#dataTableCate').DataTable().ajax.reload();
				$("#confirmDeleteCate").modal("hide");
				setErrorLog("cannot delete this category, because it has a dependency with the product !")
				console.log(jqXHR);
				console.log(testStatus);
				console.log(errorThrown);
			}
		});
	});	
});

function validateCate(name){
	if(name == ""){
		return false;
	}
	return true;
}

function setErrorLog(message){
	$("#errorLog").html("<p>\'" + message + "\'</p>");
	$("#modalDialog").modal("show");
}
