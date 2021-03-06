<%@page import="com.javadev.phoneshop.entity.DhUser"%>
<%@page
	import="org.springframework.security.core.userdetails.UserDetails"%>
<%@page
	import="org.springframework.security.core.context.SecurityContextHolder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String username = "";
Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
Boolean authorGuest = SecurityContextHolder.getContext().getAuthentication().getAuthorities().stream()
		.anyMatch(r -> r.getAuthority().equals("USER"));
Boolean authorAdmin = SecurityContextHolder.getContext().getAuthentication().getAuthorities().stream()
		.anyMatch(r -> r.getAuthority().equals("ADMIN"));
Boolean authorFullCT = SecurityContextHolder.getContext().getAuthentication().getAuthorities().stream()
		.anyMatch(r -> r.getAuthority().equals("FULLCONTROL"));
if (principal instanceof UserDetails) {
	username = ((UserDetails) principal).getUsername();
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="/admin/vendor/datatables/dataTables.bootstrap4.css"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
	integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
	crossorigin="anonymous"></script>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
	integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
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
<link rel="stylesheet" href="/css/contact.css">
<link rel="stylesheet" href="/css/news.css">
<link rel="stylesheet" href="/css/main.css">
<style>
.dropbtn {
	cursor: pointer;
	font-size: 18px;
}

.dropbtn:hover, .dropbtn:focus {
	background-color: #2980B9;
}

.dropdown {
	margin-left: 87px;
	position: relative;
	display: inline-block;
	margin-top: 9px;
}

.dropdown-content {
	display: none;
	position: absolute;
	background-color: #f1f1f1;
	min-width: 160px;
	overflow: auto;
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
	z-index: 1;
}

.dropdown-content a {
	color: black;
	padding: 12px 16px;
	text-decoration: none;
	display: block;
}

.dropdown a:hover {
	background-color: #ddd;
}

.show {
	display: block;
}
</style>
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
														<p class="service-item-desc">s???n ph???m ch??nh h??ng</p>
													</li>

													<li class="col l-3 form-service-item">
														<div class="service-item-img">
															<img src="/images/v???n-chuy???n-to??n-qu???c.png" alt="">
														</div>
														<p class="service-item-desc">v???n chuy???n mi???n ph??</p>
													</li>
													<li class="col l-3 form-service-item">
														<div class="service-item-img">
															<img src="/images/s???a-ch???a.png" alt="">
														</div>
														<p class="service-item-desc">s???a ch???a mi???n ph??</p>
													</li>
													<li class="col l-3 form-service-item">
														<div class="service-item-img">
															<img src="/images/linh-kien-chinh-hang.png" alt="">
														</div>
														<p class="service-item-desc">h??? tr??? tr??? g??p</p>
													</li>
												</ul>
											</div>
										</div>
									</div>
									<div class="col col-litle l-3">
										<div class="header-detail-phone">
											<ul>
												<p>g???i ngay ????? nh???n ??u ????i</p>
												<p>09879999999</p>
												<p>g???i ngay ????? nh???n ??u ????i</p>
												<p>09879999999</p>
											</ul>

										</div>
									</div>
									<div class="col col-litle l-4">
										<div class="header-detail-socical">
											<ul class=" row no-gutters menu-top-list">
												<li class="col l-4 menu-top-item"><a href=""> gi???i
														thi???u</a></li>
												<li class="col l-4 menu-top-item"><a href="">
														khuy???n m???i </a></li>
												<li class="col l-4 menu-top-item"><a
													href="/contact">li??n h???</a></li>
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
								<input type="search" name="searchText"
									placeholder="nh???p s???n ph???m c???n t??m">
								<button type="submit">
									<i class="fas fa-search"></i>
								</button>
							</form>
						</div>
						<div class="col col-litle l-3">
							<div class="header-Cart-login">
								<div class="row">

									<div class="col col-litle l-10 header-login">

										<%
											if (!username.equals("") && authorGuest) {
										%>

										<div class="dropdown">
											<a onclick="dropdownlink()" class="dropbtn">My account</a>
											<div id="myDropdown" class="dropdown-content">
												<a href="/user-profile"><i class="fa fa-user"></i> Your
													profile </a> <a href="/logout"><i class="fa fa-exclamation"></i>
													Logout</a>
											</div>
										</div>
										<%
											} else if (authorAdmin || authorFullCT) {
										%>

										<div class="dropdown">
											<a onclick="dropdownlink()" class="dropbtn">My account</a>
											<div id="myDropdown" class="dropdown-content">
												<a href="/user-profile"><i class="fa fa-user"></i> Your
													profile</a> <a href="/admin/index"><i
													class="fa fa-user-secret"></i> Admin</a> <a href="/logout"><i
													class="fa fa-exclamation"></i> Logout</a>
											</div>
										</div>

										<%
											} else {
										%>
										<div class="row ">
											<div class=" col-litle l-6 form-Login">
												<a href="/login" class="login-icon"> <i
													class="fas fa-user"></i> <span> ????ng nh???p </span>
												</a>
											</div>


											<div class=" col-litle l-6 form-Login">
												<a href="/register" class="login-icon"> <i
													class="fas fa-sign-out-alt"></i> <span> ????ng k?? </span>
												</a>

											</div>

										</div>

										<%
											}
										%>


										<!-- form logout -->

									</div>
									<div class="col col-litle l-2 header-Cart">
										<a class="link-cart-icon" href="/cart-list"> <i
											class="fas fa-shopping-cart"></i>
										</a> <span id="totalHeaderCart">0</span>
										<div class="header-Cart-list">
											<ul class="cart-list-item" id="listCartHeader">

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
									class="fas fa-home"></i> trang ch???
							</a></li>
							<li class="nav-bar-item"><a
								href="/search?categoryId=1&select=parent"> <i
									class="fas fa-mobile-alt"></i> ??i???n tho???i
							</a>
								<ul class="sub-menu" id="phone-menu">

								</ul></li>
							<li class="nav-bar-item"><a
								href="/search?categoryId=2&select=parent"> <i
									class="fas fa-tablet-alt"></i> tablet
							</a>
								<ul class="sub-menu" id="ipad-menu">

								</ul></li>
							<li class="nav-bar-item"><a
								href="/search?categoryId=3&select=parent"> ph??? ki???n <i
									class="fas fa-headphones-alt"></i>
							</a>
								<ul class="sub-menu" id="tool-menu">

								</ul></li>
							<li class="nav-bar-item"><a
								href="/search?categoryId=4&select=parent"> laptop <i
									class="fas fa-laptop"></i>
							</a>
								<ul class="sub-menu" id="laptop-menu">

								</ul></li>
							<li class="nav-bar-item"><a href="/news"> <i
									class="fa fa-list-alt"></i> tin t???c
							</a></li>
							<li class="nav-bar-item"><a href="/contact"> <i
									class="fas fa-id-card"></i> li??n h???
							</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>