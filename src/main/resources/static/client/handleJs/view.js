(function (){
	load();
	setNewProduct();
	phoneProduct(5);
	tabletProduct(8);
	toolProduct(10);
	laptopProduct(11);
})();
function load(){
	$.ajax({
		url : "/api/v1/category/category?id="+1,
		type:"GET",
		success:function(responseData){
			var html = "";
			var data = responseData.data;
			for(var i=0;i<data.length;i++){
				html += '<li class="sub-menu-item"><a href="/search?categoryId='+data[i].id+'">' + data[i].name + '</a></li>';
			}
			$("#phone-menu").append(html);
		},
		error : function(jqXhr, textStatus, errorMessage) { // error
			// callback

		} 
	});	
	$.ajax({
		url : "/api/v1/category/category?id="+2,
		type:"GET",
		success:function(responseData){
			var html = "";
			var data = responseData.data;
			for(var i=0;i<data.length;i++){
				html += '<li class="sub-menu-item"><a href="/search?categoryId='+data[i].id+'">' + data[i].name + '</a></li>';
			}
			$("#ipad-menu").append(html);
		},
		error : function(jqXhr, textStatus, errorMessage) { // error
			// callback

		} 
	});	
	$.ajax({
		url : "/api/v1/category/category?id="+3,
		type:"GET",
		success:function(responseData){
			var html = "";
			var data = responseData.data;
			for(var i=0;i<data.length;i++){
				html += '<li class="sub-menu-item"><a href="/search?categoryId='+data[i].id+'">' + data[i].name + '</a></li>';
			}
			$("#tool-menu").append(html);
		},
		error : function(jqXhr, textStatus, errorMessage) { // error
			// callback

		} 
	});	
	$.ajax({
		url : "/api/v1/category/category?id="+4,
		type:"GET",
		success:function(responseData){
			var html = "";
			var data = responseData.data;
			for(var i=0;i<data.length;i++){
				html += '<li class="sub-menu-item"><a href="/search?categoryId='+data[i].id+'">' + data[i].name + '</a></li>';
			}
			$("#laptop-menu").append(html);
		},
		error : function(jqXhr, textStatus, errorMessage) { // error
			// callback

		} 
	});	
}

document.getElementById("productNew").addEventListener("click",setNewProduct);
document.getElementById("productSeller").addEventListener("click",setProductSeller);

function setNewProduct(){
	$("#setProduct").empty();
	$.ajax({
		url : "/api/v1/product/products/desc",
		type:"GET",
		data :{
			limit : 4
		},
		success:function(responseData){
			var html = "";
			var data = responseData.data;
			for(var i=0;i<data.length;i++){
				html += '<div class="col col-litle l-3 ">'
					+'<div class="product-item">'
					+'<a href="/product-details?id='+ data[i].id +'">'
					+'<div class="product-item-img">'
					+'<img src="upload/product/'+ data[i].avatar +'" alt=""'
					+'		srcset="">'
					+'</div>'
					+'<div class="product-item-desc">'
					+'	<h3 class="product-item-title">'+data[i].name+'</h3>'
					+'	<span class="product-item-price"> '+ data[i].price +'đ </span>'
					+'</div>'
					+'</a>'
					+'</div>'
					+'</div>';
			}
			$("#setProduct").append(html);
		},
		error : function(jqXhr, textStatus, errorMessage) { // error
			// callback

		} 
	});	
}

function setProductSeller(){
	$("#setProduct").empty();
	$.ajax({
		url : "/api/v1/product/products/random",
		type:"GET",
		data :{
			limit : 4
		},
		success:function(responseData){
			var html = "";
			var data = responseData.data;
			for(var i=0;i<data.length;i++){
				html += '<div class="col col-litle l-3 ">'
					+'<div class="product-item">'
					+'<a href="/product-details?id='+ data[i].id +'">'
					+'<div class="product-item-img">'
					+'<img src="upload/product/'+ data[i].avatar +'" alt=""'
					+'		srcset="">'
					+'</div>'
					+'<div class="product-item-desc">'
					+'	<h3 class="product-item-title">'+data[i].name+'</h3>'
					+'	<span class="product-item-price"> '+ data[i].price +'đ </span>'
					+'</div>'
					+'</a>'
					+'</div>'
					+'</div>';
			}
			$("#setProduct").append(html);
		},
		error : function(jqXhr, textStatus, errorMessage) { // error
			// callback

		} 
	});	
}

function phoneProduct(id){
	$("#phoneProduct").empty();
	$.ajax({
		url : "/api/v1/product/products",
		type:"GET",
		data :{
			id : id,
			limit : 4
		},
		success:function(responseData){
			var html = "";
			var data = responseData.data;
			for(var i=0;i<data.length;i++){
				html += '<div class="col col-litle l-3 ">'
					+'<div class="product-item">'
					+'<a href="/product-details?id='+ data[i].id +'">'
					+'<div class="product-item-img">'
					+'<img src="upload/product/'+ data[i].avatar +'" alt=""'
					+'		srcset="">'
					+'</div>'
					+'<div class="product-item-desc">'
					+'	<h3 class="product-item-title">'+data[i].name+'</h3>'
					+'	<span class="product-item-price"> '+ data[i].price +'đ </span>'
					+'</div>'
					+'</a>'
					+'</div>'
					+'</div>';
			}
			$("#phoneProduct").append(html);
		},
		error : function(jqXhr, textStatus, errorMessage) { // error
			// callback

		} 
	});	
}

function tabletProduct(id){
	$("#tabletProduct").empty();
	$.ajax({
		url : "/api/v1/product/products",
		type:"GET",
		data :{
			id : id,
			limit : 4
		},
		success:function(responseData){
			var html = "";
			var data = responseData.data;
			for(var i=0;i<data.length;i++){
				html += '<div class="col col-litle l-3 ">'
					+'<div class="product-item">'
					+'<a href="/product-details?id='+ data[i].id +'">'
					+'<div class="product-item-img">'
					+'<img src="upload/product/'+ data[i].avatar +'" alt=""'
					+'		srcset="">'
					+'</div>'
					+'<div class="product-item-desc">'
					+'	<h3 class="product-item-title">'+data[i].name+'</h3>'
					+'	<span class="product-item-price"> '+ data[i].price +'đ </span>'
					+'</div>'
					+'</a>'
					+'</div>'
					+'</div>';
			}
			$("#tabletProduct").append(html);
		},
		error : function(jqXhr, textStatus, errorMessage) { // error
			// callback

		} 
	});	
}

function toolProduct(id){
	$("#toolProduct").empty();
	$.ajax({
		url : "/api/v1/product/products",
		type:"GET",
		data :{
			id : id,
			limit : 4
		},
		success:function(responseData){
			var html = "";
			var data = responseData.data;
			for(var i=0;i<data.length;i++){
				html += '<div class="col col-litle l-3 ">'
					+'<div class="product-item">'
					+'<a href="/product-details?id='+ data[i].id +'">'
					+'<div class="product-item-img">'
					+'<img src="upload/product/'+ data[i].avatar +'" alt=""'
					+'		srcset="">'
					+'</div>'
					+'<div class="product-item-desc">'
					+'	<h3 class="product-item-title">'+data[i].name+'</h3>'
					+'	<span class="product-item-price"> '+ data[i].price +'đ </span>'
					+'</div>'
					+'</a>'
					+'</div>'
					+'</div>';
			}
			$("#toolProduct").append(html);
		},
		error : function(jqXhr, textStatus, errorMessage) { // error
			// callback

		} 
	});	
}

function laptopProduct(id){
	$("#laptopProduct").empty();
	$.ajax({
		url : "/api/v1/product/products",
		type:"GET",
		data :{
			id : id,
			limit : 4
		},
		success:function(responseData){
			var html = "";
			var data = responseData.data;
			for(var i=0;i<data.length;i++){
				html += '<div class="col col-litle l-3 ">'
					+'<div class="product-item">'
					+'<a href="/product-details?id='+ data[i].id +'">'
					+'<div class="product-item-img">'
					+'<img src="upload/product/'+ data[i].avatar +'" alt=""'
					+'		srcset="">'
					+'</div>'
					+'<div class="product-item-desc">'
					+'	<h3 class="product-item-title">'+data[i].name+'</h3>'
					+'	<span class="product-item-price"> '+ data[i].price +'đ </span>'
					+'</div>'
					+'</a>'
					+'</div>'
					+'</div>';
			}
			$("#laptopProduct").append(html);
		},
		error : function(jqXhr, textStatus, errorMessage) { // error
			// callback

		} 
	});	
}