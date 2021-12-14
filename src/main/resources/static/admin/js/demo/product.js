(function () {
	updateListCategory();
})();

$('#dataTableProduct').DataTable({
	  select: true,
	  ajax: {
          url: "/admin/api/v1/product/products",
          method: "get",
        },
        "columns": [
          { data: "id"},
          { data: "name" },
          { data: "createdDate" },
          { data: "updatedDate" },
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

$("#addProduct").click(function(){
	 $("#newProduct").modal("show");
});

function addNewProduct(event){
	event.preventDefault();
	var form = $("#fileUploadFormProduct")[0];
    var data = new FormData(form);
    if(validateProduct()){
    	$.ajax({
			url : "/admin/api/v1/product/product",
			type:"POST",
			enctype: 'multipart/form-data',
			data : data,
			
			processData: false,
		    contentType: false,
		    cache: false,
		    timeout: 1000000,
			success : function(jsonResult){
				if(jsonResult.status == 200){	
					alert("Thêm sản phẩm thành công!");
					$('#dataTableProduct').DataTable().ajax.reload();
				}else{
					alert("Thêm sản phẩm thất bại!");
				}
			},
			error : function(jqXhr, textStatus, errorMessage) { // error
				// callback

			} 
		});
    }
}

function updateProduct(event){
	event.preventDefault();
	var form = $("#fileUploadFormProductUpdate")[0];
    var data = new FormData(form);
    if(validateProductUpdate()){
    	$.ajax({
			url : "/admin/api/v1/product/product",
			type:"PUT",
			enctype: 'multipart/form-data',
			data : data,
			
			processData: false,
		    contentType: false,
		    cache: false,
		    timeout: 1000000,
			success : function(jsonResult){
				var data = jsonResult.data;
				if(jsonResult.status == 200){	
					alert("Cập nhật sản phẩm thành công!");
					detailProduct(data.id);
					$('#dataTableProduct').DataTable().ajax.reload();
				}else{
					alert("Cập nhật sản phẩm thất bại!");
				}
			},
			error : function(jqXhr, textStatus, errorMessage) { // error
				// callback

			} 
		});
    }
}

$("#dataTableProduct").on('click', '.update', function() {
    var ID = $(this).closest('tr').find('td').eq(0).text();
    detailProduct(ID);   
    $("#detailProduct").modal("show");
});

$("#dataTableProduct").on('click', '.delete', function() {
    var ID = $(this).closest('tr').find('td').eq(0).text();
    document.getElementById("idForDeleteProduct").value = ID;
    $("#confirmDeleteProduct").modal("show");  
});

function deleteProduct(){
	var idProduct = document.getElementById("idForDeleteProduct").value;
	$.ajax({
		url : "/admin/api/v1/product/product?id="+idProduct,
		method : "DELETE",
		success : function(data){
				$('#dataTableProduct').DataTable().ajax.reload();
				$("#confirmDeleteProduct").modal("hide");	
		},
		error : function(jqXHR,testStatus,errorThrown){
			setErrorLog("error !")
			$("#confirmDeleteProduct").modal("hide");
			console.log(jqXHR);
			console.log(testStatus);
			console.log(errorThrown);
		}
	});
}
		
function updateListCategory(){
	$("#productCategory").empty();
	$("#productCategoryUpdate").empty();
		$.ajax({
			url:"/admin/api/v1/category/categories",
			type:"GET",
			success : function(responseData){
				var html = "";
				var data = responseData.data;
				for(var i=0;i<responseData.data.length;i++){
					html += "<option value='" + data[i].id +  "'>" + data[i].name +"</option>";
				}
				
				$("#productCategory").html(html);
				$("#productCategoryUpdate").html(html);
				
			},
			error : function(jqXhr, textStatus, errorMessage) { // error
				// callback

			} 
		});	
}

function detailProduct(id){
	$.ajax({
		url:"/admin/api/v1/product/product",
		type:"GET",
		data : {
			id : id,
		},
		success : function(responseData){
			var data = responseData.data;
			$("#productIdUpdate").val(id);
			$("#productNameUpdate").val(data.name);
			$("#productAvailableUpdate").val(data.available);
			$("#productPriceUpdate").val(data.price);
			$("#colorUpdate").val(data.color);
			$("#storageUpdate").val(data.storage);
			$("#productDetailDescriptionUpdate").summernote("code", data.detailDescription);
			document.getElementById("outputProductUpdate").src = "/upload/product/" + data.avatar;
				
		},
		error : function(jqXhr, textStatus, errorMessage) { // error
			// callback

		} 
	});
}

function validateProduct(){
	var reg = /^\d+$/;
	var productName = $("#productName").val();
	var productAvailable = $("#productAvailable").val();
	var productPrice = $("#productPrice").val();
	var productDetailDescription = $("#productDetailDescription").val();
	if(productName == ""){
		alert("tên sản phẩm không được trống !");
		return false;
	}
	if(!productAvailable.match(reg)){
		alert("lỗi nhập số lượng !");
		return false;
	}
	if(!productPrice.match(reg)){
		alert("lỗi nhập giá !");
		return false;
	}
	if(productDetailDescription == ""){
		alert("mô tả không được trống !");
		return false;
	}
	return true;
}

function validateProductUpdate(){
	var reg = /^\d+$/;
	var productName = $("#productNameUpdate").val();
	var productAvailable = $("#productAvailableUpdate").val();
	var productPrice = $("#productPriceUpdate").val();
	var productDetailDescription = $("#productDetailDescriptionUpdate").val();
	if(productName == ""){
		alert("tên sản phấm không được trống !");
		return false;
	}
	if(!productAvailable.match(reg)){
		alert("lỗi nhập số lượng !");
		return false;
	}
	if(!productPrice.match(reg)){
		alert("lỗi nhập giá !");
		return false;
	}
	if(productDetailDescription == ""){
		alert("mô tả không được trống !");
		return false;
	}
	return true;
}

var loadFile = function (event) {
    var image = document.getElementById("outputProduct");
    image.src = URL.createObjectURL(event.target.files[0]);
}

var loadFileUpdate = function (event) {
    var image = document.getElementById("outputProductUpdate");
    image.src = URL.createObjectURL(event.target.files[0]);
}