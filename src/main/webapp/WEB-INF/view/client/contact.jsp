<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/WEB-INF/view/client/common/header.jsp"></jsp:include>
<link rel="stylesheet" href="/css/login.css">



<div class="wrapper-body">
	<div class="contact-img">
		<h1>liên hệ</h1>
	</div>
	<div class="container">
		<div class="row pt-20">
			<div class="col l-6 contact-infor">
				<h4 class="contact-title">CÔNG TY TNHH CÔNG NGHỆ TRUYỀN THÔNG</h4>
				<ul class="contact-list">
					<li class="contact-item"><i class="fas fa-map-marker-alt"></i>
						<span> <strong>Trụ sở chính:</strong> Lorem ipsum dolor,
							sit amet consectetur adipisicing elit.
					</span></li>
					<li class="contact-item"><i class="fas fa-map-marker-alt"></i>
						<span> <strong>chi nhánh Hà Nội:</strong> Lorem ipsum
							dolor, sit amet consectetur adipisicing elit.
					</span></li>
					<li class="contact-item"><i class="fas fa-map-marker-alt"></i>
						<span> <strong>chi nhánh Đà Nẵng:</strong> Lorem ipsum
							dolor, sit amet consectetur adipisicing elit.
					</span></li>
					<li class="contact-item"><i class="fas fa-map-marker-alt"></i>
						<span> <strong>chi nhánh Lâm Đồng:</strong> Lorem ipsum
							dolor, sit amet consectetur adipisicing elit.
					</span></li>
					<li class="contact-item"><i class="fas fa-phone"></i> <span>
							<strong>Điện thoại:</strong> 097899999
					</span></li>
					<li class="contact-item"><i class="fas fa-envelope"></i> <span>
							<strong>Email:</strong> abc@gmail.com
					</span></li>
				</ul>

			</div>
			<div class="col l-4 l-o-1 contact-form">
				<form action="" method="POST" class="form1" id="form-1">
					<div class="form-contain">
						<div class="form-group">
							<label for="fullname" class="form-label">Tên đầy đủ</label> <input
								id="contact_name" name="fullname" type="text"
								placeholder="nhập tên đầy đủ" class="form-control" />
							<span class="form-message"></span>
						</div>

						<div class="form-group">
							<label for="phonenumber" class="form-label">Số điện thoại</label>
							<input id="contact_phone" name="phonenumber" type="text"
								placeholder="nhập số điện thoại" class="invalid form-control" />
							<span class="form-message"></span>
						</div>
						<div class="form-group">
							<label for="email" class="form-label">Email</label> <input
								id="contact_email" name="email" type="text"
								placeholder="VD: email@domain.com" class="invalid form-control" />
							<span class="form-message"></span>
						</div>
						<div class="form-group">
							<label for="messeage" class="form-label">Ghi chú</label>
							<textarea name="messeage" id="contact_message" cols="30" rows="5"
								placeholder="Tin nhắn"></textarea>
						</div>
						<button type="button" onclick="sendContact()" class="form-submit">Gửi đi</button>
					</div>
				</form>

			</div>
		</div>
		<div class="row">
			<iframe
				src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3918.7315604075657!2d106.63698931533436!3d10.831843261128956!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x317529d6749900bb%3A0x4c1da6236763b98e!2zVGhp4bq_dCBr4bq_IHdlYnNpdGUgZ2nDoSBy4bq7IHThuqFpIFRQSENNIC0gV2ViIMSQ4bqhaSBUw61u!5e0!3m2!1svi!2s!4v1616471348716!5m2!1svi!2s"
				frameborder="0"></iframe>
		</div>
	</div>
</div>



<jsp:include page="/WEB-INF/view/client/common/footer.jsp"></jsp:include>