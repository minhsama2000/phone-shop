<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/css/login.css">
<title>Register</title>
<script type="text/javascript">
	function validateFormRegister() {
		let fullname = document.getElementById("fullname").value;
		let email = document.forms["registerForm"]["email"].value;
		let username = document.forms["registerForm"]["username"].value;
		let name = document.forms["registerForm"]["name"].value;
		let password = document.forms["registerForm"]["password"].value;
		let confirm_password = document.forms["registerForm"]["password_confirmation"].value;

		if (fullname == "") {
			alert("Email must be filled out");
			return false;
		}
		if (email == "") {
			alert("Email must be filled out");
			return false;
		}
		if (username == "") {
			alert("username must be filled out");
			return false;
		}
		if (name == "") {
			alert("Name must be filled out");
			return false;
		}
		if (password == "") {
			alert("Name must be filled out");
			return false;
		}
		if (confirm_password == "") {
			alert("Verify password must be filled out");
			return false;
		}
		return true;
	}
</script>
</head>
<body>
	<div class="main">
		<form action="/signup" method="POST" class="form" name="registerForm"
			onsubmit="return validateFormRegister()">
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
				<button class="form-submit">Đăng kí</button>
			</div>
		</form>
	</div>

	<script src="/js/login.js"></script>
</body>
</html>