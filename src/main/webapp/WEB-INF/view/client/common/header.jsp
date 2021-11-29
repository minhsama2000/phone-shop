<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="/fonts/fontawesome-free-5.15.4-web/css/all.min.css">
<link rel="stylesheet" href="/css/main.css">
<link rel="stylesheet" href="/css/globall.css">
<link rel="stylesheet" href="/css/style.css">
<link rel="stylesheet" href="/assets/owl.carousel.min.css">
<link rel="stylesheet" href="/assets/owl.theme.default.min.css">
<link rel="stylesheet" href="/css/product_detail.css">
<link rel="stylesheet" href="/css/check_out.css">
<link rel="stylesheet" href="/css/cart_list.css">
 <link rel="stylesheet" href="/css/search.css">
 
<title>Phone shop</title>
</head>
<body>
	<div id="main">
		<div class="wrapper-header">
			<div class="container">
				<div class="header-inner">
					<div class="row">
						<div class="col l-3">
							<div class="header-logo">
								<a href="/home"> <img src="/images/logo.png" alt="">
								</a>
							</div>
						</div>
						<div class="col l-9">
							<div class="header-detail">
								<div class="row">
									<div class="col col-litle l-5">
										<div class="header-detail-form">

											<div class="form-service">
												<ul class=" row no-gutters form-service-list">
													<li class="col l-3 form-service-item">
														<div class="service-item-img">
															<img src="/images/sieu-thi-dien-thoai-chinh-hang.png"
																alt="">
														</div>
														<p class="service-item-desc">sản phẩm chính hãng</p>
													</li>

													<li class="col l-3 form-service-item">
														<div class="service-item-img">
															<img src="/images/vận-chuyển-toàn-quốc.png" alt="">
														</div>
														<p class="service-item-desc">vận chuyển miễn phí</p>
													</li>
													<li class="col l-3 form-service-item">
														<div class="service-item-img">
															<img src="/images/sửa-chữa.png" alt="">
														</div>
														<p class="service-item-desc">sửa chữa miễn phí</p>
													</li>
													<li class="col l-3 form-service-item">
														<div class="service-item-img">
															<img src="/images/linh-kien-chinh-hang.png" alt="">
														</div>
														<p class="service-item-desc">hỗ trợ trả góp</p>
													</li>
												</ul>
											</div>
										</div>
									</div>
									<div class="col col-litle l-3">
										<div class="header-detail-phone">
											<ul>
												<p>gọi ngay để nhận ưu đãi</p>
												<p>09879999999</p>
												<p>gọi ngay để nhận ưu đãi</p>
												<p>09879999999</p>
											</ul>

										</div>
									</div>
									<div class="col col-litle l-4">
										<div class="header-detail-socical">
											<ul class=" row no-gutters menu-top-list">
												<li class="col l-4 menu-top-item"><a href=""> giới
														thiệu</a></li>
												<li class="col l-4 menu-top-item"><a href="">
														khuyến mại </a></li>
												<li class="col l-4 menu-top-item"><a
													href="./contact.html">liên hệ</a></li>
											</ul>
											<ul class="row menu-top-socical">
												<a href="https://www.facebook.com/ngocquy.bui.1042"
													class=" menu-top-item"> <i class="fab fa-facebook-f"></i>
												</a>
												<a class=" menu-top-item"> <i class="fab fa-instagram"></i>
												</a>
												<a class=" menu-top-item"> <i class="fab fa-youtube"></i>
												</a>
											</ul>
											<div class="time-work">

												<p>
													<i class="far fa-clock"></i>8h00-17h00
												</p>
											</div>

										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="row header-Form-seach">
						<div class="col l-6 l-o-3">
							<form class="form-seach row" action="/search" method="post">
								<input type="search" name="searchText" placeholder="nhập sản phẩm cần tìm">
								<button type="submit">
									<i class="fas fa-search"></i>
								</button>
							</form>
						</div>
						<div class="col col-litle l-3">
							<div class="header-Cart-login">
								<div class="row">

									<div class="col col-litle l-10 header-login">
										<div class="row ">
											<div class=" col-litle l-6 form-Login">
												<a href="./login.html" class="login-icon"> <i
													class="fas fa-user"></i> <span> đăng nhập </span>
												</a>
											</div>
											<!-- form login -->

											<div class=" col-litle l-6 form-Login">
												<a href="./regester.html" class="login-icon"> <i
													class="fas fa-sign-out-alt"></i> <span> Đăng ký </span>
												</a>

											</div>
										</div>
										<!-- form logout -->

									</div>
									<div class="col col-litle l-2 header-Cart">
										<a href="./cart_list.html"> <i
											class="fas fa-shopping-cart"></i>
										</a>
										<div class="header-Cart-list">
											<ul class="cart-list-item">
												<li class="cart-item">
													<div class="row ">
														<div class="col col-litle l-2 cart-item-img">
															<img src="./assets/images/iP11-5-510x510-1.jpg" alt=""
																srcset="">
														</div>
														<div class="col col-litle l-6 cart-item-name">
															<span>iphone-7-32g-1 </span>
														</div>
														<div class="col col-litle l-3 cart-Quantiy">
															<span> sl x 1</span>
														</div>
													</div>

												</li>
												<li class="cart-item">
													<div class="row ">
														<div class="col col-litle l-2 cart-item-img">
															<img src="./assets/images/iP11-5-510x510-1.jpg" alt=""
																srcset="">
														</div>
														<div class="col col-litle l-6 cart-item-name">
															<span>iphone-7-32g-1</span>
														</div>
														<div class="col col-litle l-3 cart-Quantiy">
															<span> sl x 1</span>
														</div>
													</div>

												</li>
												<li class="cart-item">
													<div class="row ">
														<div class="col col-litle l-2 cart-item-img">
															<img src="./assets/images/iP11-5-510x510-1.jpg" alt=""
																srcset="">
														</div>
														<div class="col col-litle l-6 cart-item-name">
															<span>iphone-7-32g-1</span>
														</div>
														<div class="col col-litle l-3 cart-Quantiy">
															<span> sl x 1</span>
														</div>
													</div>

												</li>
											</ul>

										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="wrapper-nav">
				<div class="container">
					<div class="nav-bar">
						<ul class=" row no-gutters nav-bar-list">
							<li class="nav-bar-item"><a href="/home"> <i
									class="fas fa-home"></i> trang chủ
							</a></li>
							<li class="nav-bar-item"><a href="/search?categoryId=14&select=parent"> <i
									class="fas fa-mobile-alt"></i> điện thoại
							</a>
								<ul class="sub-menu" id="phone-menu">

								</ul></li>
							<li class="nav-bar-item"><a href="/search?categoryId=15&select=parent"> <i
									class="fas fa-tablet-alt"></i> ipad
							</a>
								<ul class="sub-menu" id="ipad-menu">

								</ul></li>
							<li class="nav-bar-item"><a href="/search?categoryId=16&select=parent"> phụ kiện <i
									class="fas fa-headphones-alt"></i>
							</a>
								<ul class="sub-menu" id="tool-menu">

								</ul></li>
							<li class="nav-bar-item"><a href="/search?categoryId=17&select=parent"> laptop <i
									class="fas fa-laptop"></i>
							</a>
								<ul class="sub-menu" id="laptop-menu">

								</ul></li>
							<li class="nav-bar-item"><a href=""> <i
									class="fa fa-shopping-bag"></i> khuyến mại
							</a>
								<ul class="sub-menu">

								</ul></li>
							<li class="nav-bar-item"><a href="./news.html"> <i
									class="fa fa-list-alt"></i> tin tức
							</a></li>
							<li class="nav-bar-item"><a href="./contact.html"> <i
									class="fas fa-id-card"></i> liên hệ
							</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>