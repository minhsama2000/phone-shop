<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="wrapper-footer">
    <div class="container">
        <div class="row">
            <div class="col l-5">
                <div class="footer-about">
                    <h4 class="footer-title">
                        Apple Center Tùng Iphone Đà Nẵng
                    </h4>
                    <div class="footer-desc">
                        <p class="footer-desc-item">
                            <i class="fas fa-home"></i>
                            Cơ Sở 1: 196 Hoàng Diệu- Đà Nẵng
                        </p>
                        <p class="footer-desc-item">
                            <i class="fas fa-home"></i>
                            Cơ sở 2: 227 Nguyễn Văn Linh - Đà Nẵng
                        </p>
                        <p class="footer-desc-item">
                            <i class="fas fa-phone-volume"></i>
                            Hotline:02366 508633 - 0966 887 444 Mr. Tùng
                        </p>
                        <p class="footer-desc-item">
                            <i class="far fa-envelope"></i>
                            Email : tungiphone@gmail.com
                        </p>
                    </div>
                </div>
            </div>
            <div class="col l-3">
                <div class="footer-contact">
                    <h4 class="footer-title">
                        Chính sách
                    </h4>
                    <div class="footer-desc">
                        <a href="#" class="footer-desc-item">Chính sách đổi trả hàng</a>
                        <a href="#" class="footer-desc-item">Chính sách bảo hành</a>
                        <a href="#" class="footer-desc-item">Hướng dẫn mua hàng</a>
                        <a href="#" class="footer-desc-item">Chính sách đại lý</a>
                    </div>
                </div>
            </div>
            <div class="col l-4">
                <div class="footer-socical">
                    <h4 class="footer-title">
                        Fanpage Facebook
                    </h4>
                    <div class="footer-desc">
                     <div class="footer-social-fanpage">
                         <div class="footer-social-img">
                             <img src="/images/bg-footer-plugin.png" alt="" srcset="">
                         </div>
                         <div class="footer-social-title">
                            <a href="">Lorem ipsum dolor sit amet.</a>
                            <p>10000 lượt thích</p>
                        </div>
                    </div>
                    <div class="footer-social-like">
                     <a href="#">
                        <i class="fab fa-facebook-f"></i>
                        thích trang
                    </a>
                    <a href="#"> 
                        <i class="far fa-envelope"></i>
                        gửi tin nhắn
                    </a>
                </div>
            </div>

        </div>
    </div>
</div>
</div>
</div>
<div class="coppy-right">
    <div class="container">
        <p>
            coppyright by 
        </p>
    </div>
</div>
</div>
<script src="/js/main.js"></script>
<script src="/js/handleProduct.js"></script>
<script src="/js/search.js"></script>
<script src="/js/view.js"></script>
<script src="/js/cart.js"></script>
<script src="/js/checkout.js"></script>
<script src="/js/user.js"></script>
<script src="/js/jquery.min.js"></script>
<script src="/owcarosel/owl.carousel.min.js"></script>
<script>
 $(".owl-carousel").owlCarousel({
    loop: true,
    margin: 10,
    nav: true,
    responsive: {
      0:{
        items:1,
        nav:false,
        autoplay:true,
    },
}
})

function dropdownlink() {
  document.getElementById("myDropdown").classList.toggle("show");
}

// Close the dropdown if the user clicks outside of it
window.onclick = function(event) {
  if (!event.target.matches('.dropbtn')) {
    var dropdowns = document.getElementsByClassName("dropdown-content");
    var i;
    for (i = 0; i < dropdowns.length; i++) {
      var openDropdown = dropdowns[i];
      if (openDropdown.classList.contains('show')) {
        openDropdown.classList.remove('show');
      }
    }
  }
}
</script>
</body>
</html>
