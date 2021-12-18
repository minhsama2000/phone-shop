(function () {
	
})();

$("#addBlog").click(function(){
	 $("#newBlog").modal("show");
});

$("#dataTableBlog").on('click', '.update', function() {
    var ID = $(this).closest('tr').find('td').eq(0).text();
    detailBlog(ID);   
    $("#detailBlog").modal("show");
});

$("#dataTableBlog").on('click', '.delete', function() {
    var ID = $(this).closest('tr').find('td').eq(0).text();
    document.getElementById("idForDeleteBlog").value = ID;
    $("#confirmDeleteBlog").modal("show");  
});

var loadBlogFile = function (event) {
    var image = document.getElementById("outputBlog");
    image.src = URL.createObjectURL(event.target.files[0]);
	var uploadedFilePath = $('#blogFile').val();
}

var loadDetailBlogFile = function (event) {
    var image = document.getElementById("detailOutputBlog");
    image.src = URL.createObjectURL(event.target.files[0]);
	var uploadedFilePath = $('#blogFileDetail').val();
}

$('#dataTableBlog').DataTable({
	  select: true,
	  ajax: {
          url: "/admin/api/v1/blog/blogs",
          method: "get",
        },
        "columns": [
          { data: "id"},
          { data: "thumbnail" },
          { data: "createdDate" },
          { data: "updatedDate" },
        ],
        "columnDefs": [{
        	"targets":4,
        	"center":true,
        	"render": function(data,type,full,meta){
        		var del = '<button class="btn btn-primary update">Edit</button> <button class="btn btn-danger delete">Delele</button>';
        		return del;
        	}
        	
        }],
  });

$(document).ready(function(){
	$("#buttonDeleteBlog").on("click",function(){
		var id = document.getElementById("idForDeleteBlog").value;
		$.ajax({
			url : "/admin/api/v1/blog/blog?id="+id,
			type : "DELETE",
			success : function(data){
				if(data.status == 200){
					$('#dataTableBlog').DataTable().ajax.reload();
					$("#confirmDeleteBlog").modal("hide");
				}	
			},
			error : function(jqXHR,testStatus,errorThrown){
				alert("cannot delete this blog!")
				console.log(jqXHR);
				console.log(testStatus);
				console.log(errorThrown);
			}
		});
	});	
});

function addNewBlog(event){
	event.preventDefault();
	var form = $('#blogUploadForm')[0];

    var data = new FormData(form);
	if(validateBlog()){
		$.ajax({
			url : "/admin/api/v1/blog/blog",
			type:"POST",
			enctype: 'multipart/form-data',
			data : data,
			
			processData: false,
		    contentType: false,
		    cache: false,
		    timeout: 1000000,
			success : function(jsonResult){
				if(jsonResult.status == 200){			
					alert("Thêm blog thành công !");
					$('#dataTableBlog').DataTable().ajax.reload();
				}else{
					alert("Thêm thất bại !");
				}
			},
			error : function(jqXhr, textStatus, errorMessage) { // error
				// callback

			} 
		});
	}
}

function updateBlog(event){
	 event.preventDefault();
	 var form = $('#blogDetailForm')[0];
	 var data = new FormData(form);
	 console.log(data.get("id"))
	$.ajax({
		url : "/admin/api/v1/blog/blog",
		type:"PUT",
		enctype: 'multipart/form-data',
		data : data,
		
		processData: false,
	    contentType: false,
	    cache: false,
	    timeout: 10000,
	    success : function(jsonResult){
	    	if(jsonResult.status == 200){			
				alert("Cập nhật blog thành công !");
				$('#dataTableBlog').DataTable().ajax.reload();
			}else{
				alert("Cập nhật thất bại !");
			}
		},
		error : function(jqXhr, textStatus, errorMessage) { // error
			// callback

		} 
	});
}

function detailBlog(id){
	$.ajax({
		url : "/admin/api/v1/blog/blog?id="+id,
		type : "GET",
		success : function(responseData){
			var object = responseData.data;
			if(object){
				document.getElementById("detailBlogThumbnail").value = object.thumbnail;
				document.getElementById("updateBlogId").value = object.id;
				document.getElementById("detailShortDescription").value = object.shortDescription;
				$("#updateDetailsBlog").summernote("code", object.details);
				document.getElementById("detailOutputBlog").src = "/upload/blog/" + object.avatar;
			}
			
		},
		error : function(jqXHR,testStatus,errorThrown){
			console.log(jqXHR);
			console.log(testStatus);
			console.log(errorThrown);
		}
	});
}

function validateBlog(){
	var blogThumbnail = document.getElementById("blogThumbnail");
	var shortDescription = document.getElementById("shortDescription");
	var details = document.getElementById("detailsBlog");
	if(blogThumbnail.value == ""){
		alert("Invalid name");
		return false;
	}
	if(shortDescription.value == ""){
		alert("Invalid short description");
		return false;
	}
	if(details.value == ""){
		alert("Invalid details");
		return false;
	}
	return true;
}