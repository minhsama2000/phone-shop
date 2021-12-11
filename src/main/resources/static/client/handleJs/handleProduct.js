var color = 1;
var storage = 1;

$("#chooseColor li").click(function(){
	for(var i = 0;i<$(".fa-check").length;i++){
		document.getElementsByClassName("fa-check")[i].style.color = "#aaa";
	}
	$(this).find("i").css("color","white");
	color = this.id;
});

$("#chooseStorage li").click(function(){
	for(var i = 0;i<$("#chooseStorage li").length;i++){
		document.getElementsByClassName("storage")[i].style.backgroundColor  = "white";
	}
	$(this).css("background-color","gray");
	storage = this.id;
});



function addToCart(productId,quantity){
	$.ajax({
		url : "/api-security/v1/carts/cart",
		type:"POST",
		data : JSON.stringify({
			productId : productId,
			quantity : quantity,
			color : color,
			storage : storage
		}),
		dataType: 'json',
	    contentType: "application/json; charset=utf-8",
		success:function(responseData){
			if(responseData.status == 200){
				alert("success");
			}		
		},
		error : function(jqXhr, textStatus, errorMessage) { // error
			// callback			
				window.location.href="/login"			
		} 
	});	
}