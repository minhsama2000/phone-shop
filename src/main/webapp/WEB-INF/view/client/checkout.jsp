<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/view/client/common/header.jsp"></jsp:include>


<div class="wrapper-body-checkout">
	<div class="check-out-title">
		<div class="container">
			<img src="/images/logo.png" alt="">
		</div>
	</div>
	<div class="container">
		<div class="row">
			<div class="col l-7 block_checkout_left">
				<form action="" method="POST" class="form_name_adress form"
					id="form-1">
					<h3 class="form_name_title">Thông tin thanh toán</h3>
					<div class="row">
						<div class="col l-6">
							<div class="adress_form_left">
								<div class="input_name form-group">
									<label>Họ và tên</label> <input
										class="input_full_name form-control" type="text"
										name="fullname" id="fullname"
										placeholder="vui lòng nhập tên đầy đủ"> <span
										class="form-message"></span>
								</div>
								<div class="input_phone form-group">
									<label for="fonnumber">Số điện thoại</label> <input type="tel"
										name="phonenumber" id="phonenumber"
										class="input_phone_number form-control"
										placeholder="nhập số điện thoại"> <span
										class="form-message"></span>
								</div>
							</div>
						</div>
						<div class="col l-6">
							<div class="adress_form_right">
								<div class="input_address form-group">
									<label>địa chỉ</label> <input
										class="input_address_detail form-control" type="text"
										name="adress" id="adress" placeholder="nhập địa chỉ">
									<span class="form-message"></span>
								</div>
								<div class="input_email form-group ">
									<label for="">email</label> <input type="email" name="email"
										id="email" class="input_email_custom form-control"
										placeholder="nhập địa chỉ email"> <span
										class="form-message"></span>
								</div>
							</div>
						</div>
					</div>
					<div class="row adress_form_action">
						<button class="col l-o-8 form_submit_adress form-submit" action=""
							type="submit">save</button>
					</div>
				</form>
			</div>
			<div class="col l-5  block_checkout_right">
				<h3 class="heading_checkout">ĐƠN HÀNG CỦA BẠN</h3>
				<div class="row product_checkout">
					<div class="col l-12 product_checkout_title">
						<div class="row mb-20 border-b">
							<p class="col l-8">
								<strong> sản phẩm </strong>
							</p>
							<span class="col l-4"> <strong> tạm tính </strong>
							</span>
						</div>
						<div class="row mb-20 border-b">
							<ul class="col l-8 product_item_checkout">
								<li class="product_name">iPhone 6 512GB 99% like new <strong
									class="product_quantity">× 2</strong>
								</li>
								<li class="product_infor"><span class="product_capacity">
										dung lượng
										<p class="product_capacity_value">256G</p>

								</span> <span class="product_color"> màu
										<p class="product_color_value">đen</p>
								</span></li>
							</ul>
							<span class="col l-4"> 59.200.000đ </span>
						</div>
						<div class="row mb-20 border-b">
							<p class="col l-8">Tạm tính</p>
							<span class="col l-4">59.200.000đ</span>
						</div>
						<div class="row mb-20 border-b">
							<p class="col l-8">Tổng</p>
							<span class="col l-1 total_check">59.200.000đ</span>
						</div>
					</div>

				</div>
				<p class="checkout_rule mb-10">Chuyển khoản ngân hàng</p>
				<p class="checkout_rule_desc mb-20 ">Thực hiện thanh toán vào
					ngay tài khoản ngân hàng của chúng tôi. Vui lòng sử dụng Mã đơn
					hàng của bạn trong phần Nội dung thanh toán. Đơn hàng sẽ đươc giao
					sau khi tiền đã chuyển.</p>
				<button id="checkout" type="submit">đặt hàng</button>
			</div>
		</div>
	</div>
</div>



<jsp:include page="/WEB-INF/view/client/common/footer.jsp"></jsp:include>