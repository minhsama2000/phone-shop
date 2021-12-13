(function () {
	updateTotal();
	loadCart();
	cartTotal();
})();

function updateCart(productId,quantity,color,storage){
	var id = parseInt(productId);
	$.ajax({
		url : "/api-security/v1/carts/cart",
		type:"PUT",
		data : JSON.stringify({
			productId : id,
			quantity : quantity,
			color:color,
			storage:storage
		}),
		dataType: 'json',
        contentType: 'application/json',
		success: function(responseData){
			
		},
		error : function(jqXhr, textStatus, errorMessage) { // error
			// callback

		}
	});
}

function updateTotal(){
	$.ajax({
		url : "/api-security/v1/carts/carts",
		type:"GET",
		dataType: 'json',
        contentType: 'application/json',
		success: function(responseData){
			var html = "";
			$("#listCartHeader").empty();
			var data = responseData.data;
			$("#totalHeaderCart").html(responseData.data.length)
			for(var i=0;i<data.length;i++){
				html += '<li class="cart-item">'
							+'	<div class="row ">'
							+'		<div class="col col-litle l-2 cart-item-img">'
							+'			<img src="/upload/product/'+data[i].avatar+'" alt=""'
							+'				srcset="">'
							+'		</div>'
							+'		<div class="col col-litle l-6 cart-item-name">'
							+'			<a href="/product-details?id='+data[i].productId+'"><span>'+data[i].name+' </span></a>'
							+'		</div>'
							+'		<div class="col col-litle l-3 cart-Quantiy">'
							+'			<span> sl x '+data[i].quantity+'</span>'
							+'		</div>'
							+'	</div>'

						+'	</li>';
			}
			$("#listCartHeader").html(html);
		},
		error : function(jqXhr, textStatus, errorMessage) { // error
			// callback

		}
	});
}

function loadCart(){
	$("#cart-table").empty();
	$.ajax({
		url : "/api-security/v1/carts/carts",
		type:"GET",
		dataType: 'json',
	    contentType: "application/json; charset=utf-8",
		success:function(responseData){
			var html = "";
			var data = responseData.data;
			for(var i=0;i<data.length;i++){
				html += '<tr class="cart-table-body"><input type="hidden" value="'+data[i].productId+'" class="cartProductId"/>'
										+'<input type="hidden" value="'+data[i].color+'" class="cartColor"/>'
										+'<input type="hidden" value="'+data[i].storage+'" class="cartStorage"/>'
										+'<td class="product-remove"><a '
										+'	class="remove_cart_product"> <i class="fas fa-trash-alt"></i>'
										+'</a></td>'

										+'<td class="product-thumbnail"><a href=""> <img'
										+'		src="/upload/product/'+ data[i].avatar +'" alt="" />'
										+'</a></td>'
										+'<td class="product-name" data-title="Sản phẩm"><a'
										+'	href="/product-details?id='+data[i].productId+'">'+data[i].name+'</a>'
										+'	<dl class="variation">'
										+'		<dt class="variation-capacity-tile">Dung lượng:</dt>'
										+'		<dd class="variation-capacity-value">'
										+'			<p>'+getStorage(data[i].storage)+'GB</p>'
										+'		</dd>'
										+'		<dt class="variation-color">Màu sắc:</dt>'
				+'		<dd class="variation-color-value">'
				+'			<p>'+getColor(data[i].color)+'</p>'
				+'		</dd>'
				+'	</dl></td>'

				+'<td class="product-price" data-title="Giá"><span'
				+'	class="product-Price-amount"> <bdi class="priceSingle">'+data[i].price+''
				+'			 </bdi>'
				+'	<span class="woocommerce-Price-currencySymbol">&#8363;</span></span></td>'

				+'	<td class="product-quantity" data-title="Số lượng">'
				+'	<div class="quantity-Block">'
				+'		<span style="cursor: pointer" type="button" class="badge badge-light input_Capacity-Prev">-</span>'
				+'			<input class="currentQuantity" type="text" id="quantity_id" value="'+data[i].quantity+'" />'
				+'		<span style="cursor: pointer" type="button" class="badge badge-light input_Capacity_next">+</span>'
				+'	</div>'
				+'</td>'

				+'	<td class="product-subtotal" data-title="Tạm tính"><span'
				+'		class="woocommerce-Price-amount amount"><bdi  class="totalSingle">'+data[i].quantity*data[i].price+''
				+'				</bdi><span class="woocommerce-Price-currencySymbol">&#8363;</span></span></td>'
				+'</tr>';
			}
			$("#cart-table").html(html);
			cartTotal();
			var index = 0;
			var proQty = $('.quantity-Block');

			var removeCart = $(".remove_cart_product").on("click",function(){
				index = removeCart.index(this);
				var productId = document.getElementsByClassName("cartProductId")[index].value;
				var color = document.getElementsByClassName("cartColor")[index].value;
				var storage = document.getElementsByClassName("cartStorage")[index].value;
				$(".cart-table-body")[index].remove();
				remove(productId,color,storage);
				cartTotal();
			}); 
			
			var decrease = $(".input_Capacity-Prev").on("click",function(){
				index = decrease.index(this);
				var $qty=$(this).parent().find('input');
			    var currentVal = parseInt($qty.val());
			    var color = document.getElementsByClassName("cartColor")[index].value;
				var storage = document.getElementsByClassName("cartStorage")[index].value;
			    var newVal = 0;
			    if (!isNaN(currentVal) && currentVal > 1) {
			        $qty.val(currentVal - 1);
			        newVal = $qty.val();
			       
			    	document.getElementsByClassName("totalSingle")[index].innerHTML=newVal*parseInt(document.getElementsByClassName("priceSingle")[index].innerHTML);
			    	cartTotal()
			    	updateCart(document.getElementsByClassName("cartProductId")[index].value,newVal,color,storage);
			    }
			});
			
			var increase = $('.input_Capacity_next').on('click',function(){
				
				index = increase.index(this);
				var $qty=$(this).parent().find('input');
			    var currentVal = parseInt($qty.val());
			    var color = document.getElementsByClassName("cartColor")[index].value;
				var storage = document.getElementsByClassName("cartStorage")[index].value;
			    var newVal = 0;
			    if (!isNaN(currentVal) && currentVal > 0) {
			        $qty.val(currentVal + 1);
			        newVal = $qty.val();
			       	document.getElementsByClassName("totalSingle")[index].innerHTML=newVal*parseInt(document.getElementsByClassName("priceSingle")[index].innerHTML);
			       	cartTotal();
			       	updateCart(document.getElementsByClassName("cartProductId")[index].value,newVal,color,storage);
			    }
			});
		},
		error : function(jqXhr, textStatus, errorMessage) { // error
			// callback			
							
		} 
	});
}

function remove(productId,cartColor,cartStorage){
	var id = parseInt(productId);
	console.log(id);
	$.ajax({
		url : "/api-security/v1/carts/cart?productId="+id+"&color="+cartColor+"&storage="+cartStorage,
		type:"DELETE",
		dataType: 'json',
        contentType: 'application/json',
		success: function(responseData){
			
		},
		error : function(jqXhr, textStatus, errorMessage) { // error
			// callback

		}
	});
}

function cartTotal(){
	var total = 0;
	var totalProduct = document.getElementsByClassName("totalSingle");
	for(var i=0;i<totalProduct.length;i++){
		total += parseInt(totalProduct[i].innerHTML.trim());
	}
	$("#totalCart").html(total);
}


function getColor(color){
if(color == 1){
		return "Đen";
	}if(color == 2){

		return "Đỏ";
	}if(color == 3){

		return "Xanh";
	}if(color == 4){

		return "Vàng";
	}
}

function getStorage(storage){
	if(storage == 1){

		return "32";
	}
if(storage == 2){

	return "64";
	}
if(storage == 3){

	return "128";
}
if(storage == 4){

	return "256";
}
}