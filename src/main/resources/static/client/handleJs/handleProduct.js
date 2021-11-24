var product= function(ten,gia,hinhAnh,mau,id){
    this.ten=ten;
    this.gia=gia;
    this.hinhAnh=hinhAnh;
    this.mau=mau;
    if(id){
    this.id=id;
    }
}

var product1 =new product("iphone5",7000000,"./assets/images/iP11-5-510x510-1.jpg","den",1)
console.log(product1);
// var iphone5 =new product("iphone5",7000000,"./assets/images/iP11-5-510x510-1.jpg","den",1);

// console.log(iphone5)
var listCart=[];

var resApi=" http://localhost:3000/productListCart"

fetch(resApi)
.then(function(response){
    return response.json();
})
.then(function(post){
    console.log(post);
  post.map(function(e){
      console.log(e);
        var newProduct= new product(e.ten,e.gia,e.hinhAnh,e.mau,e.id);
        console.log(newProduct)
        listCart.push(newProduct)
        console.log(listCart)

    })
    return listCart
})

