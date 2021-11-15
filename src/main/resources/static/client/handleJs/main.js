


// ===================================================
var resApi = "http://localhost:3000/productList";

function start() {
    getCourses(render);

 
  
  }
  start();
  
  function getCourses(callback) {
    fetch(resApi)
      .then((response) => response.json())
      .then(callback);
  }
  
  function render(response) {
    var wrappCourse = document.querySelector(".wrapper-content-show");
    var data = response.reduce((couses, course) => {
      couses.push(       
        ` <div class="col col-litle l-3 ">
           <div class="product-item" onclick="showDetail(${course.id})" data_id=${course.id}>
          <a href="./product_detail.html"  >
              <div class="product-item-img">
                      <img src="${course.hinhAnh}" alt="" srcset="">
              </div>
              <div class="product-item-desc">
                  <h3 class="product-item-title">
                      ${course.tensanpham}
                  </h3>
                  <span class="product-item-price">
                      ${course.gia}
                  </span>
              </div>
          </a>
      </div>
  </div>`);
      return couses;
    }, []);
    wrappCourse.innerHTML = data.join("");
  }
  function createCourse(data, callback) {
    var options = {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(data),
    };
    fetch(resApi, options)
      .then(function (response) {
        response.json();
      })
      .then(callback);
  }
  function DeleteCouse(callback, id) {
    var options = {
      method: "DELETE",
      headers: {
        "Content-Type": "application/json",
      },
    };
    fetch(resApi + "/" + id, options)
      .then(function (response) {
        response.json();
      })
      .then(callback);
  }
  function FixCouse(data,callback, id) {
    var options = {
      method: "PUT",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(data),
    };
    fetch(resApi + "/" + id, options)
      .then(function (response) {
        response.json();
      })
      .then(callback);
  }
  


  var onProductDetail = document.getElementsByClassName("product-item");
  console.log(onProductDetail)
      Leng=onProductDetail.length
      for(var i=0;i<Leng;i++){
       onProductDetail[i].addEventListener("click",function(){
         alert()
       })
      }
  function showDetail(a){
    var data={
      "id":a
    }
    console.log(a);
    var options = {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(data),
    };
    fetch("http://localhost:3000/iddetail", options)
  }
 
  
  
