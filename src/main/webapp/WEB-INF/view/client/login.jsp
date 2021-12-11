<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/css/login.css">
<script src="/js/jquery.min.js"></script>
<title>login</title>
</head>
<body>
	<div class="main">
		<form action="/perform_login" method="POST" class="form" id="form-2">
			<div class="form-img">
				<img src="/images/iphone-7-32g-1.jpg" alt="">
			</div>

			<div class="form-contain">
				<h3 class="heading">Đăng Nhập Tài Khoản</h3>
				<div class="spacer"></div>
				<c:if test="${not empty param.login_error}">
					<div class="alert alert-danger" role="alert" style="color: white">Login
						attempt was not successful, try again.</div>
				</c:if>
				<div class="form-group">
					<label for="fullname" class="form-label">Username</label> <input
						id="usernameLogin" name="username" type="text"
						placeholder="nhập tên đầy đủ" class="form-control" /> <span
						class="form-message"></span>
				</div>

				<div class="form-group">
					<label for="password" class="form-label">Mật khẩu</label> <input
						id="password" name="password" type="password"
						placeholder="Nhập mật khẩu" class="form-control" /> <span
						class="form-message"></span>
				</div>
				<button class="form-submit">Đăng nhập</button>
			</div>
		</form>
	</div>

	<script src="/js/login.js"></script>
	<script>
    validator({
      form: "#form-2",
      formGroup: ".form-group",
      formError: ".form-message",
      Rules: [
        validator.isRequired("#fullname"),
        validator.isRequired("#password"),
        validator.isRequired("#password_confirmation"),
        validator.isconfirmed("#password_confirmation", function () {
          return document.querySelector("#password").value;
        }),
      ],
      formSubmit(data) {
        console.log(data);
      },
    });
  </script>
</body>
</html>