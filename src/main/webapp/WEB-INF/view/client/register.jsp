<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/css/login.css">
<script src="/js/jquery.min.js"></script>
<title>Register</title>
</head>
<body>
	<div class="main">
		<form action="" class="form" name="registerForm" id="registerForm">
			<div class="form-img">
				<img src="/images/iphone-7-32g-1.jpg" alt="">
			</div>

			<div class="form-contain">
				<h3 class="heading">Đăng Kí Tài Khoản</h3>
				<div class="spacer"></div>
				<div class="form-group">
					<label for="fullname" class="form-label">Tên đầy đủ</label> <input
						id="fullname" name="name" type="text"
						placeholder="nhập tên đầy đủ" class="form-control" /> <span
						class="form-message"></span>
				</div>

				<div class="form-group">
					<label for="email" class="form-label">Email</label> <input
						id="email" name="email" type="text"
						placeholder="VD: email@domain.com" class="invalid form-control" />
					<span class="form-message"></span>
				</div>

				<div class="form-group">
					<label for="username" class="form-label">Username</label> <input
						id="username" name="username" type="text" placeholder="username"
						class="invalid form-control" /> <span class="form-message"></span>
				</div>

				<div class="form-group">
					<label for="password" class="form-label">Mật khẩu</label> <input
						id="password" name="password" type="password"
						placeholder="Nhập mật khẩu" class="form-control" /> <span
						class="form-message"></span>
				</div>

				<div class="form-group">
					<label for="password_confirmation" class="form-label">Nhập
						lại mật khẩu</label> <input id="password_confirmation"
						name="password_confirmation" placeholder="Nhập lại mật khẩu"
						type="password" class="form-control" /> <span
						class="form-message"></span>
				</div>
				<button class="form-submit" id="btn-signup">Đăng kí</button>
			</div>
		</form>
	</div>

	<script src="/js/login.js"></script>
</body>
</html>