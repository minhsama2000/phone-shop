

function getIdDetai(){
 fetch("http://localhost:3000/iddetail")
    .then(response => response.json())
    .then(function(e){
        var resApi = "http://localhost:3000/productList/"+ e.id
        getCourses(render,resApi)
    })
}
getIdDetai()

// function start() {
//     getCourses(render);
//   }
  function getCourses(callback,resApi) {
    fetch(resApi)
      .then((response) => response.json())
      .then(callback);
  }
  
  function render(response) {
    var wrappCourse = document.querySelector(".product-main");
    var data = 
        `
        <div class="col-litle l-5 ">
            <div class="product-main-img">
                <img src="${response.hinhAnh}" alt="" srcset="">
                <a  class=" row product-main-zoom">
                    <i class="fas fa-arrows-alt"></i>
                </a>
            </div>
        </div>
        <div class="col-litle l-7 product-main-infor">
            <h4 class="product-title-infor">
                ${response.tensanpham}
            </h4>
            <p class="product-price-infor">
                giá:
                <span>
                    ${response.gia}
                </span>
            </p>
            <ul class="product-promotion-infor">
                <span>khuyến mại</span>
                <li>
                    <i class="fas fa-check"></i>
                    <p>Lorem ipsum dolor sit, amet consectetur adipisicing elit. Veritatis, rerum.</p>
                </li>
                <li>
                    <i class="fas fa-check"></i>
                    <p>Lorem ipsum dolor sit, amet consectetur adipisicing elit. Veritatis, rerum.</p>
                </li>
                <li>
                    <i class="fas fa-check"></i>
                    <p>Lorem ipsum dolor sit, amet consectetur adipisicing elit. Veritatis, rerum.</p>
                </li>
                <li>
                    <i class="fas fa-check"></i>
                    <p>Lorem ipsum dolor sit, amet consectetur adipisicing elit. Veritatis, rerum.</p>
                </li>
             
            </ul>
            <form name="form-buy" action="">
                <div class="capacity-block">
                    <select name="Capacity" id="">
                        <option value=""></option>
                        <option value="128"></option>
                        <option value="256"></option>
                    </select>
                    <p>chọn dung lượng</p>
                    <ul class="capacity-lable">
                        <li deleteActive="false" value="128" 
                        } >128G</li>
                        <li deleteActve="false" value="256">256G</li>
                        <li deleteActve="false" value="256">56G</li>
                        <li deleteActve="false" value="256">6G</li>
                    </ul>
                </div>
                <div class="color-block">
                    <select name="color" id="">
                        <option value="">chọn</option>
                        <option value="den"></option>
                        <option value="do"></option>
                        <option value="xanh"></option>
                        <option value="vang"></option>
                    </select>
                    <p>chọn màu </p>
                    <ul>
                        <li deleteActive="flase" value="den">
                            <i class="fas fa-check"></i>
                        </li>
                        <li deleteActive="flase" value="do">
                            <i class="fas fa-check"></i>
                        </li>
                        <li deleteActive="flase" value="xanh">
                            <i class="fas fa-check"></i>
                        </li>
                        <li deleteActive="flase" value="vang">
                            <i class="fas fa-check"></i>
                        </li>
                      
                    </ul>
                </div>
                <div class="boxCountHide quantity-block">
                    <span class="quantity-prev">-</span>
                    <input value="1" min="1"  class="quantity-number">
                    <span class="quantity-add">+</span>
                </div>
                <div class="buttom-block">
                    <button   name="addtocart" formaction="./cart_list.html" >
                        <h4>thêm vào giỏ hàng </h4>
                        <p>giao tận nơi, lắp đặt miễn phí</p>
                    </button>

                    <button name="buyNow" formaction="./check_out.html">
                        <h4>mua hàng</h4>
                        <p> 
                        giao tận nơi, lắp đặt miễn phí
                        </p>
                    </button>
                </div>
            </form>
        </div>

    `
    wrappCourse.innerHTML = data;

    
  var elementClick = document.querySelector(".product-main-zoom")
  console.log(elementClick);
  var elementModal = document.querySelector(".product-modal-zoom")
  console.log(elementModal)
  elementClick.onclick= function(){
      elementModal.style.display="block";
  }
  elementModal.onclick = function(){
      elementModal.style.display="none";
  }
  // xử lý chọn màu và dung lượng

  // get Element BoxSize
  var elBoxSize = document.querySelectorAll(".capacity-block ul li");

  // get Element BoxColor
  var elBoxColor = document.querySelectorAll(".color-block ul li");

  // get Element BoxCount
  var elBoxCount = document.querySelector(".quantity-block");

  //get Elemet button addtocart
  var addtoCartE= document.querySelector("button[name='addtocart']")

  //get Element button buyNOw
  var buyNowE = document.querySelector("button[name='buyNow']")


  runElement(elBoxSize);
  runElement(elBoxColor);

    function runElement(ele) {
      for (var i = 0; i < ele.length; i++) {
        ele[i].addEventListener('click', function () {
          eventActiveBox(this);
        });
      }
  }

  function eventActiveBox(e) {
    var boxChilds = e.parentElement.children;
    if (e.classList.contains("active")) {
      e.classList.remove("active");
    } else {
      for (var i = 0; i < boxChilds.length; i++) {
      var boxChild = boxChilds[i].classList;
      if (boxChild.contains("active")) boxChild.remove("active");
    }
      e.classList.add("active");
    }

    showBoxCount();
  }

  function showBoxCount() {
  if (checkActive(elBoxSize) && checkActive(elBoxColor)) {
    elBoxCount.classList.add("boxCountShow");
    elBoxCount.classList.remove("boxCountHide");
    addtoCartE.classList.add("showbg")
    buyNowE.classList.add("showbg")
  } else {
      elBoxCount.classList.add("boxCountHide");
      elBoxCount.classList.remove("boxCountShow");
      addtoCartE.classList.remove("showbg")
      buyNowE.classList.remove("showbg")
    }
  }

  function checkActive(ele) {
  for (var i = 0; i < ele.length; i++) {
    if (ele[i].classList.contains("active")) {
      return true
    }
  }
  return false;
  }

  console.log(buyNowE) ;
  addtoCartE.onclick=function(e){
    if(elBoxCount.classList.contains("boxCountHide")){
    e.preventDefault();
    }
  }
  buyNowE.onclick=function(e){
    if(elBoxCount.classList.contains("boxCountHide")){
    e.preventDefault();
    }
  }
  function handleQuantityProduct(){
  //   get prev element
    var prevE= document.querySelector(".quantity-prev")
    var nextE= document.querySelector(".quantity-add")
    var quanE= document.querySelector(".quantity-number")
    prevE.onclick=function(){
        if(quanE.value>1){
            quanE.value--;
        }
    }
    nextE.onclick=function(){
      quanE.value++
    }
  }

  handleQuantityProduct()
  }
