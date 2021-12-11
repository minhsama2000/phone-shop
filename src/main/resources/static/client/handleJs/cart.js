(function () {
	loadCart()
})();

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
				html += '<tr class="cart-table-body">'
										+'<td class="product-remove"><a href=""'
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
			var index = 0;
			var proQty = $('.quantity-Block');

			var decrease = $(".input_Capacity-Prev").on("click",function(){
				index = decrease.index(this);
				var $qty=$(this).parent().find('input');
			    var currentVal = parseInt($qty.val());
			    var newVal = 0;
			    if (!isNaN(currentVal) && currentVal > 1) {
			        $qty.val(currentVal - 1);
			        newVal = $qty.val();
			       
			    	document.getElementsByClassName("totalSingle")[index].innerHTML=newVal*parseInt(document.getElementsByClassName("priceSingle")[index].innerHTML);
//			    	cartTotal()
//			    	updateCart(document.getElementsByClassName("cartProductId")[index].value,newVal);
			    }
			});
			
			var increase = $('.input_Capacity_next').on('click',function(){
				
				index = increase.index(this);
				var $qty=$(this).parent().find('input');
			    var currentVal = parseInt($qty.val());
			    var newVal = 0;
			    if (!isNaN(currentVal) && currentVal > 0) {
			        $qty.val(currentVal + 1);
			        newVal = $qty.val();
			       	document.getElementsByClassName("totalSingle")[index].innerHTML=newVal*parseInt(document.getElementsByClassName("priceSingle")[index].innerHTML);
//			       	cartTotal();
//			       	updateCart(document.getElementsByClassName("cartProductId")[index].value,newVal);
			    }
			});
		},
		error : function(jqXhr, textStatus, errorMessage) { // error
			// callback			
							
		} 
	});
}

function cartTotal(){
	var total = 0;
	var totalProduct = document.getElementsByClassName("totalOneProduct");
	for(var i=0;i<totalProduct.length;i++){
		total += parseInt(totalProduct[i].innerHTML);
	}
	$("#totalCart").html("$"+total);
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