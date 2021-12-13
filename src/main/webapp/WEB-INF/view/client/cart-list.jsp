<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/WEB-INF/view/client/common/header.jsp"></jsp:include>



<div class="wrapper-cart">
	<div class="container">
		<h1 class="cart-table-title">giỏ hàng</h1>
		<div class="continue-shopping ">
			<a class="button-continue-shopping " href="/home"> <i
				class="fas fa-long-arrow-alt-left"></i> Tiếp tục xem sản phẩm
			</a>
		</div>
		</br>
		<div class="cart-noitify"></div>
		<div class="cart_form">
			<div class="row no-gutters">
				<div class="col l-9">
					<form class="haddle_Cart_Form" action="">
						<div class="cart-table">
							<table>
								<thead>
									<tr>
										<th></th>
										<th class="product-name" colspan="2">Sản phẩm</th>
										<th class="product-price">Giá</th>
										<th class="product-quantity">Số lượng</th>
										<th class="product-subtotal">Tạm tính</th>
									</tr>
								</thead>
								<tbody id="cart-table">




								</tbody>
							</table>
						</div>

					</form>
				</div>
				<div class="col l-3 border-l">
					<div class="cart-sidebar">
						<div class="cart_totals ">
							<table>
								<thead>
									<tr>
										<th class="product-name">Cộng giỏ hàng</th>
									</tr>
								</thead>
							</table>

							<!-- <h2>Cộng giỏ hàng</h2> -->

							<table class="shop_table shop_table_responsive">
								<tr class="order-total">
									<th>Tổng</th>
									<td data-title="Tổng"><strong> <span
											class="woocommerce-Price-amount amount"> <bdi
													id="totalCart"> </bdi> <span
												class="woocommerce-Price-currencySymbol">&#8363;</span>
										</span>
									</strong></td>
								</tr>
							</table>

							<div class="cart-checkout">
								<a href="/checkout"> Tiến hành thanh toán </a>
							</div>

						</div>
					</div>

				</div>
			</div>
		</div>
	</div>

</div>



<jsp:include page="/WEB-INF/view/client/common/footer.jsp"></jsp:include>