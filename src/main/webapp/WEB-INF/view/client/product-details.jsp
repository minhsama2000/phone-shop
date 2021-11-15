<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/view/client/common/header.jsp"></jsp:include>


<div class="wrapper-body">
	<div class="product-container">
		<div class="container mb-20">
			<div class="row">
				<div class="col col-litle l-9">
					<div class="row product-main">
						<div class="col-litle l-5 ">
							<div class="product-main-img">
								<img src="/images/iP11-5-510x510-1.jpg" alt="" srcset="">
								<a class=" row product-main-zoom"> <i
									class="fas fa-arrows-alt"></i>
								</a>
							</div>
						</div>
						<div class="col-litle l-7 product-main-infor">
							<h4 class="product-title-infor">iPhone 6 256GB 99% like new
							</h4>
							<p class="product-price-infor">
								giá: <span> 18.600.000₫ </span>
							</p>
							<ul class="product-promotion-infor">
								<span>khuyến mại</span>
								<li><i class="fas fa-check"></i>
									<p>Lorem ipsum dolor sit, amet consectetur adipisicing
										elit. Veritatis, rerum.</p></li>
								<li><i class="fas fa-check"></i>
									<p>Lorem ipsum dolor sit, amet consectetur adipisicing
										elit. Veritatis, rerum.</p></li>
								<li><i class="fas fa-check"></i>
									<p>Lorem ipsum dolor sit, amet consectetur adipisicing
										elit. Veritatis, rerum.</p></li>
								<li><i class="fas fa-check"></i>
									<p>Lorem ipsum dolor sit, amet consectetur adipisicing
										elit. Veritatis, rerum.</p></li>

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
										<li deleteActive="false" value="128">128G</li>
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
									<p>chọn màu</p>
									<ul>
										<li deleteActive="flase" value="den"><i
											class="fas fa-check"></i></li>
										<li deleteActive="flase" value="do"><i
											class="fas fa-check"></i></li>
										<li deleteActive="flase" value="xanh"><i
											class="fas fa-check"></i></li>
										<li deleteActive="flase" value="vang"><i
											class="fas fa-check"></i></li>

									</ul>
								</div>
								<div class="boxCountHide quantity-block">
									<span class="quantity-prev">-</span> <input value="1" min="1"
										class="quantity-number"> <span class="quantity-add">+</span>
								</div>
								<div class="buttom-block">
									<button name="addtocart" formaction="./cart_list.html">
										<h4>thêm vào giỏ hàng</h4>
										<p>giao tận nơi, lắp đặt miễn phí</p>
									</button>

									<button name="buyNow" formaction="./check_out.html">
										<h4>mua hàng</h4>
										<p>giao tận nơi, lắp đặt miễn phí</p>
									</button>
								</div>
							</form>
						</div>

					</div>
				</div>
				<div class="col col-litle l-3">
					<div class="list-store">
						<h4 class="list-store-title">Danh sách cửa hàng</h4>
						<div class="store-item">
							<span> <i class="fas fa-map-marker-alt"></i>
							</span>
							<div class="store-item-name">
								<h4>chi nhánh 1</h4>
								<p>196 Hoàng Diệu - Đà Nẵng</p>
							</div>
						</div>
						<div class="store-item">
							<span> <i class="fas fa-map-marker-alt"></i>
							</span>
							<div class="store-item-name">
								<h4>chi nhánh 1</h4>
								<p>196 Hoàng Diệu - Đà Nẵng</p>
							</div>
						</div>
						<div class="store-item">
							<span> <i class="fas fa-map-marker-alt"></i>
							</span>
							<div class="store-item-name">
								<h4>chi nhánh 1</h4>
								<p>196 Hoàng Diệu - Đà Nẵng</p>
							</div>
						</div>
						<div class="store-item">
							<span> <i class="fas fa-map-marker-alt"></i>
							</span>
							<div class="store-item-name">
								<h4>chi nhánh 1</h4>
								<p>196 Hoàng Diệu - Đà Nẵng</p>
							</div>
						</div>
					</div>

				</div>
			</div>
		</div>
		<div class="container">
			<div class="row">
				<div class="col l-9">
					<div class="product-show-nav">
						<div class="nav-bar">
							<span class="title-product"> mô tả </span>
						</div>
					</div>
					<div class="product-desc mb-20">
						<div class="product-desc-feature">
							<h3>I. Đặc điểm nổi bật của iPhone X</h3>
							<h4>1.thiết kế sang trọng</h4>
							<p>Với thiết kế tràn viền, không có nút Home, iPhone X sở hữu
								màn hình Super Retina hoàn toàn mới, tấm nền Oled mang kích
								thướng 5,8 inches, với độ phân giải 2436 x 1125 pixel có mật độ
								điểm ảnh cao ngất ngưởng đến 458 ppi.</p>
							<div class="product-desc-img">
								<img src="/images/iP11-5-510x510-1.jpg" alt="">
							</div>
							<h4>2. Màn hình OLED thế hệ mới</h4>
							<p>Màn hình siêu việt chấm dứt mọi điểm yếu của các đời
								iPhone trước đây, iPhone X sở hữu màn hình tràn cạnh với tỷ lệ
								hiển thị lên tới hơn 80%. Đặc biệt, với màn hình OLED thế hệ mới
								giúp cho siêu phẩm này trở nên hoàn hảo hơn cũng như tiêu hao ít
								năng lượng hơn.</p>
							<h4>3. Camera kép vượt trội</h4>
							<p>Sở hữu cameral kép với độ phân giải 12MP, đèn flash led
								truetone 4 bóng kết hợp với hai ống kính đều được tích hợp tính
								năng rung quang học cho hình ảnh rõ nét, chân thật như đang
								trông thấy hình ảnh ngoài đời thực vậy. Hơn nữa, với những điểm
								ưu việt như khẩu độ rộng hơn, HDR thế hệ mới, hay vi xử
								lý hình ảnh riêng lấy nét nhanh và đặc biệt là công
								nghệ nhận diện và phát sáng các phần tử trong khung
								hình. Chính những điều này đã làm nên vị trí số 1 về chất lượng
								hình ảnh mà không một dòng smartphone nào có thể sánh được.</p>
							<div class="product-desc-img">
								<img src="/images/iP11-5-510x510-1.jpg" alt="">
							</div>

							<h4>4. Khả năng nhận diện khuôn mặt</h4>

							<p>Face ID là hệ thống bảo mật nhận diện khuôn mặt mới của
								Apple, nhờ vào cụm camera TrueDepth. Hệ thống này bao gồm 8 cảm
								biến và camera giúp phân tích sâu khuôn mặt của người dùng. Cho
								nên dù người dùng đeo kính, đổi kiểu tóc hay trong bóng tối, hệ
								thống vẫn có thể quét được khuôn mặt của họ. Apple sử dụng 1
								loạt cảm biến ở mặt trước kết hợp với máy quét ánh
								sáng nhằm vẽ lên biểu đồ khuôn mặt với hơn 30.000 điểm
								chấm. Sau đó tái tạo hình dáng khuôn mặt theo biểu đồ
								3D với các chi tiết cụ thể về độ lồi lõm của bề mặt.

								Chính điều này sẽ giảm tối đa tỉ lệ rủi ro khi sử
								dụng, theo những gì công bố thì khả năng nhận diện sai
								của Face ID chỉ rơi vào 1/1.000.000.</p>

							<h4>5. Hỗ trợ sạc không dây, sạc nhanh</h4>
							<p>Lorem, ipsum dolor sit amet consectetur adipisicing elit.
								Suscipit quo dolorem esse ullam perspiciatis error odit at
								aliquam maiores reprehenderit, obcaecati aspernatur tenetur
								accusantium minus neque quidem reiciendis placeat soluta?</p>
						</div>

					</div>
					<div class="product-same">
						<div class="product-show-nav">
							<div class="nav-bar mb-20">
								<span class="title-product"> sản phẩm tương tự </span>
							</div>
						</div>
						<div class="row mb-20">
							<div class="col l-3 ">
								<div class="product-item">
									<a href="">
										<div class="product-item-img">
											<img src="/images/iP11-6-510x510-1.jpg" alt=""
												srcset="">
										</div>
										<div class="product-item-desc">
											<h3 class="product-item-title">iphone 7</h3>
											<span class="product-item-price"> 18.600.0000đ </span>
										</div>
									</a>
								</div>
							</div>
							<div class="col l-3 ">
								<div class="product-item">
									<a href="">
										<div class="product-item-img">
											<img src="/images/iP11-6-510x510-1.jpg" alt=""
												srcset="">
										</div>
										<div class="product-item-desc">
											<h3 class="product-item-title">iphone 7</h3>
											<span class="product-item-price"> 18.600.0000đ </span>
										</div>
									</a>
								</div>
							</div>
							<div class="col l-3 ">
								<div class="product-item">
									<a href="">
										<div class="product-item-img">
											<img src="/images/iP11-6-510x510-1.jpg" alt=""
												srcset="">
										</div>
										<div class="product-item-desc">
											<h3 class="product-item-title">iphone 7</h3>
											<span class="product-item-price"> 18.600.0000đ </span>
										</div>
									</a>
								</div>
							</div>
							<div class="col l-3 ">
								<div class="product-item">
									<a href="">
										<div class="product-item-img">
											<img src="/images/iP11-6-510x510-1.jpg" alt=""
												srcset="">
										</div>
										<div class="product-item-desc">
											<h3 class="product-item-title">iphone 7</h3>
											<span class="product-item-price"> 18.600.0000đ </span>
										</div>
									</a>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col l-3 ">
								<div class="product-item">
									<a href="">
										<div class="product-item-img">
											<img src="/images/iP11-6-510x510-1.jpg" alt=""
												srcset="">
										</div>
										<div class="product-item-desc">
											<h3 class="product-item-title">iphone 7</h3>
											<span class="product-item-price"> 18.600.0000đ </span>
										</div>
									</a>
								</div>
							</div>
							<div class="col l-3 ">
								<div class="product-item">
									<a href="">
										<div class="product-item-img">
											<img src="/images/iP11-6-510x510-1.jpg" alt=""
												srcset="">
										</div>
										<div class="product-item-desc">
											<h3 class="product-item-title">iphone 7</h3>
											<span class="product-item-price"> 18.600.0000đ </span>
										</div>
									</a>
								</div>
							</div>
							<div class="col l-3 ">
								<div class="product-item">
									<a href="">
										<div class="product-item-img">
											<img src="/images/iP11-6-510x510-1.jpg" alt=""
												srcset="">
										</div>
										<div class="product-item-desc">
											<h3 class="product-item-title">iphone 7</h3>
											<span class="product-item-price"> 18.600.0000đ </span>
										</div>
									</a>
								</div>
							</div>
							<div class="col l-3 ">
								<div class="product-item">
									<a href="">
										<div class="product-item-img">
											<img src="/images/iP11-6-510x510-1.jpg" alt=""
												srcset="">
										</div>
										<div class="product-item-desc">
											<h3 class="product-item-title">iphone 7</h3>
											<span class="product-item-price"> 18.600.0000đ </span>
										</div>
									</a>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col l-3">
					<div class="side-bar-new">
						<div class="product-show-nav">
							<div class="nav-bar">
								<span class="title-product"> bài viết mới </span>
							</div>
						</div>
						<div class="side-bar-content">
							<div class="side-bar-item">
								<a class="row" href="">
									<div class="col c side-bar-img ">
										<img src="/images/sider-bar.jpg" alt="">
									</div>
									<p class="col col-litle">Lorem ipsum dolor sit amet
										consectetur adipisicing elit. Cum mollitia asperiores</p>
								</a>
							</div>
							<div class="side-bar-item">
								<a class="row" href="">
									<div class="col c side-bar-img ">
										<img src="/images/sider-bar1.jpg" alt="">
									</div>
									<p class="col col-litle">Lorem ipsum dolor sit amet
										consectetur adipisicing elit. Cum mollitia asperiores</p>
								</a>
							</div>
							<div class="side-bar-item">
								<a class="row" href="">
									<div class="col c side-bar-img ">
										<img src="/images/sider-bar2.jpg" alt="">
									</div>
									<p class="col col-litle">Lorem ipsum dolor sit amet
										consectetur adipisicing elit. Cum mollitia asperiores</p>
								</a>
							</div>
						</div>
						<div class="side-bar-banner">
							<img src="/images/sider-bar-banner.jpg" alt="" srcset="">
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>
	<div class="product-modal-zoom">
		<div>
			<img src="/images/iP11-6-510x510-1.jpg" alt="" srcset="">
		</div>
		<p></p>
		<span> iP11-6-510x510-1 </span>
	</div>

</div>



<jsp:include page="/WEB-INF/view/client/common/footer.jsp"></jsp:include>