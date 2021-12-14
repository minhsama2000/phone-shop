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
		.anyMatch(r -> r.getAuthority().equals("FULL_CONTROL"));
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
<link rel="stylesheet" href="/css/contact.css">
<link rel="stylesheet" href="/css/main.css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
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
								<input type="search" name="searchText"
									placeholder="nhập sản phẩm cần tìm">
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
													class="fas fa-user"></i> <span> đăng nhập </span>
												</a>
											</div>


											<div class=" col-litle l-6 form-Login">
												<a href="/register" class="login-icon"> <i
													class="fas fa-sign-out-alt"></i> <span> Đăng ký </span>
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
									class="fas fa-home"></i> trang chủ
							</a></li>
							<li class="nav-bar-item"><a
								href="/search?categoryId=14&select=parent"> <i
									class="fas fa-mobile-alt"></i> điện thoại
							</a>
								<ul class="sub-menu" id="phone-menu">

								</ul></li>
							<li class="nav-bar-item"><a
								href="/search?categoryId=15&select=parent"> <i
									class="fas fa-tablet-alt"></i> ipad
							</a>
								<ul class="sub-menu" id="ipad-menu">

								</ul></li>
							<li class="nav-bar-item"><a
								href="/search?categoryId=16&select=parent"> phụ kiện <i
									class="fas fa-headphones-alt"></i>
							</a>
								<ul class="sub-menu" id="tool-menu">

								</ul></li>
							<li class="nav-bar-item"><a
								href="/search?categoryId=17&select=parent"> laptop <i
									class="fas fa-laptop"></i>
							</a>
								<ul class="sub-menu" id="laptop-menu">

								</ul></li>
							<li class="nav-bar-item"><a href="/news"> <i
									class="fa fa-list-alt"></i> tin tức
							</a></li>
							<li class="nav-bar-item"><a href="/contact"> <i
									class="fas fa-id-card"></i> liên hệ
							</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
<hr>
<div class="container bootstrap snippet">
	<div class="row">
		<div class="col-sm-10">
			<h1>User name</h1>
		</div>
		<div class="col-sm-2">
			<a href="/users" class="pull-right"><img title="profile image"
				class="img-circle img-responsive"
				src="http://www.gravatar.com/avatar/28fd20ccec6865e2d5f0e1f4446eb7bf?s=100"></a>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-3">
			<!--left col-->

			<form class="form" action="" method="post" id="userUploadForm">
				<div class="text-center">
					<img src="http://ssl.gstatic.com/accounts/ui/avatar_2x.png"
						class="avatar img-circle img-thumbnail" alt="avatar">
					<h6>Upload a different photo...</h6>
					<input type="file" name="file" class="text-center center-block file-upload">
				</div>
				</hr>
				<br>


				<div class="panel panel-default">
					<div class="panel-heading">
						Website <i class="fa fa-link fa-1x"></i>
					</div>
					<div class="panel-body">
						<a href="http://bootnipets.com">facebook.com</a>
					</div>
				</div>


				<ul class="list-group">
					<li class="list-group-item text-muted">Activity <i
						class="fa fa-dashboard fa-1x"></i></li>
					<li class="list-group-item text-right"><span class="pull-left"><strong>Shares</strong></span>
						125</li>
					<li class="list-group-item text-right"><span class="pull-left"><strong>Likes</strong></span>
						13</li>
					<li class="list-group-item text-right"><span class="pull-left"><strong>Posts</strong></span>
						37</li>
					<li class="list-group-item text-right"><span class="pull-left"><strong>Followers</strong></span>
						78</li>
				</ul>
		</div>
		<!--/col-3-->
		<div class="col-sm-9">
			<ul class="nav nav-tabs">
				<li class="active"><a data-toggle="tab" href="#home">Home</a></li>
				<li><a data-toggle="tab" href="#messages">Password</a></li>
				<li><a data-toggle="tab" href="#order">Order</a></li>
			</ul>


			<div class="tab-content">
				<div class="tab-pane active" id="home">
					<hr>

					<div class="form-group">

						<div class="col-xs-6">
							<label for="last_name"><h4>Name</h4></label> <input type="text"
								class="form-control" name="name" id="name"
								placeholder="last name" title="enter your last name if any.">
						</div>
					</div>

					<div class="form-group">

						<div class="col-xs-6">
							<label for="phone"><h4>Phone</h4></label> <input type="text"
								class="form-control" name="phone" id="phone"
								placeholder="enter phone"
								title="enter your phone number if any.">
						</div>
					</div>
					<div class="form-group">

						<div class="col-xs-6">
							<label for="email"><h4>Email</h4></label> <input type="email"
								class="form-control" name="email" id="email"
								placeholder="you@email.com" title="enter your email.">
						</div>
					</div>
					<div class="form-group">

						<div class="col-xs-6">
							<label for="email"><h4>Address</h4></label> <input type="email"
								class="form-control" name="address" id="address"
								placeholder="somewhere" title="enter a location">
						</div>
					</div>
					<div class="form-group">
						<div class="col-xs-12">
							<br>
							<button class="btn btn-lg btn-success" type="button"
								onclick="uploadUser(event)">
								<i class="glyphicon glyphicon-ok-sign"></i> Save
							</button>
						</div>
					</div>
					</form>

					<hr>

				</div>
				<!--/tab-pane-->
				<div class="tab-pane" id="messages">

					<h2></h2>

					<hr>
					<form class="form" action="##" method="post" id="registrationForm">

						<div class="form-group">

							<div class="col-xs-6">
								<label for="password"><h4>Password</h4></label> <input
									type="password" class="form-control" name="password"
									id="password" placeholder="password"
									title="enter your password.">
							</div>
						</div>
						<div class="form-group">

							<div class="col-xs-6">
								<label for="password2"><h4>Verify</h4></label> <input
									type="password" class="form-control" name="password2"
									id="password2" placeholder="password2"
									title="enter your password2.">
							</div>
						</div>
						<div class="form-group">
							<div class="col-xs-12">
								<br>
								<button class="btn btn-lg btn-success" type="submit">
									<i class="glyphicon glyphicon-ok-sign"></i> Save
								</button>
							</div>
						</div>
					</form>

				</div>
				<!--/tab-pane-->
				<div class="tab-pane" id="order">

					<h2></h2>
					<table id="orderUserTable">
						<thead>
							<tr>
								<td>1</td>
								<td>2</td>
								<td>3</td>
								<td>4</td>
							</tr>
						</thead>
					</table>
					<hr>

				</div>
				<!--/tab-pane-->
				<div class="tab-pane" id="settings">


					<hr>
					<form class="form" action="##" method="post" id="registrationForm">
						<div class="form-group">

							<div class="col-xs-6">
								<label for="first_name"><h4>First name</h4></label> <input
									type="text" class="form-control" name="first_name"
									id="first_name" placeholder="first name"
									title="enter your first name if any.">
							</div>
						</div>
						<div class="form-group">

							<div class="col-xs-6">
								<label for="last_name"><h4>Last name</h4></label> <input
									type="text" class="form-control" name="last_name"
									id="last_name" placeholder="last name"
									title="enter your last name if any.">
							</div>
						</div>

						<div class="form-group">

							<div class="col-xs-6">
								<label for="phone"><h4>Phone</h4></label> <input type="text"
									class="form-control" name="phone" id="phone"
									placeholder="enter phone"
									title="enter your phone number if any.">
							</div>
						</div>

						<div class="form-group">
							<div class="col-xs-6">
								<label for="mobile"><h4>Mobile</h4></label> <input type="text"
									class="form-control" name="mobile" id="mobile"
									placeholder="enter mobile number"
									title="enter your mobile number if any.">
							</div>
						</div>
						<div class="form-group">

							<div class="col-xs-6">
								<label for="email"><h4>Email</h4></label> <input type="email"
									class="form-control" name="email" id="email"
									placeholder="you@email.com" title="enter your email.">
							</div>
						</div>
						<div class="form-group">

							<div class="col-xs-6">
								<label for="email"><h4>Location</h4></label> <input type="email"
									class="form-control" id="location" placeholder="somewhere"
									title="enter a location">
							</div>
						</div>
						<div class="form-group">

							<div class="col-xs-6">
								<label for="password"><h4>Password</h4></label> <input
									type="password" class="form-control" name="password"
									id="password" placeholder="password"
									title="enter your password.">
							</div>
						</div>
						<div class="form-group">

							<div class="col-xs-6">
								<label for="password2"><h4>Verify</h4></label> <input
									type="password" class="form-control" name="password2"
									id="password2" placeholder="password2"
									title="enter your password2.">
							</div>
						</div>
						<div class="form-group">
							<div class="col-xs-12">
								<br>
								<button class="btn btn-lg btn-success pull-right" type="submit">
									<i class="glyphicon glyphicon-ok-sign"></i> Save
								</button>
								<!--<button class="btn btn-lg" type="reset"><i class="glyphicon glyphicon-repeat"></i> Reset</button>-->
							</div>
						</div>
					</form>
				</div>

			</div>
			<!--/tab-pane-->
		</div>
		<!--/tab-content-->

	</div>
	<!--/col-9-->
</div>
<!--/row-->

<script type="text/javascript">
	$(document).ready(function() {

		var readURL = function(input) {
			if (input.files && input.files[0]) {
				var reader = new FileReader();

				reader.onload = function(e) {
					$('.avatar').attr('src', e.target.result);
				}

				reader.readAsDataURL(input.files[0]);
			}
		}

		$(".file-upload").on('change', function() {
			readURL(this);
		});
	});
</script>
<jsp:include page="/WEB-INF/view/client/common/footer.jsp"></jsp:include>