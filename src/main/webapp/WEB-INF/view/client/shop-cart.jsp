<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/view/client/common/header.jsp"></jsp:include>


<div class="wrapper-cart">
	<div class="container">
		<h1 class="cart-table-title">giỏ hàng</h1>
		<div class="cart-noitify"></div>
		<div class="cart_form">
			<div class="row no-gutters">
				<div class="col l-8">
					<form class="haddle_Cart_Form" action="">
						<div class="cart-table">
							<table>
								<thead>
									<tr>
										<th class="product-name" colspan="3">Sản phẩm</th>
										<th class="product-price">Giá</th>
										<th class="product-quantity">Số lượng</th>
										<th class="product-subtotal">Tạm tính</th>
									</tr>
								</thead>
								<tbody>
									<tr class="cart-table-body">
										<td class="product-remove"><a href=""
											class="remove_cart_product"> <i class="fas fa-trash-alt"></i>
										</a></td>

										<td class="product-thumbnail"><a href=""> <img
												src="/images/iP11-5-510x510-1.jpg" alt="" />
										</a></td>
										<td class="product-name" data-title="Sản phẩm"><a
											href="./product_detail.html">iPhone X 512GB 100% new </a>
											<dl class="variation">
												<dt class="variation-capacity-tile">Dung lượng:</dt>
												<dd class="variation-capacity-value">
													<p>128GB</p>
												</dd>
												<dt class="variation-color">Màu sắc:</dt>
												<dd class="variation-color-value">
													<p>Đen</p>
												</dd>
											</dl></td>

										<td class="product-price" data-title="Giá"><span
											class="product-Price-amount"> <bdi>29.600.000 <span
													class="woocommerce-Price-currencySymbol">&#8363;</span> </bdi>
										</span></td>

										<td class="product-quantity" data-title="Số lượng">
											<div class="quantity-Block">
												<input type="button" value="-" class="input_Capacity-Prev">
												<input type="number" id="quantity_id" value="2"
													inputmode="numeric" /> <input type="button" value="+"
													class="input_Capacity_next">
											</div>
										</td>

										<td class="product-subtotal" data-title="Tạm tính"><span
											class="woocommerce-Price-amount amount"><bdi>59.200.000<span
													class="woocommerce-Price-currencySymbol">&#8363;</span></bdi></span></td>
									</tr>
									<tr class="cart-table-body">
										<td class="product-remove"><a href=""
											class="remove_cart_product"> <i class="fas fa-trash-alt"></i>
										</a></td>

										<td class="product-thumbnail"><a href=""> <img
												src="/images/iphone-7-32g-1.jpg" alt="" />
										</a></td>
										<td class="product-name" data-title="Sản phẩm"><a
											href="./product_detail.html">iPhone X 512GB 100% new </a>
											<dl class="variation">
												<dt class="variation-capacity-tile">Dung lượng:</dt>
												<dd class="variation-capacity-value">
													<p>128GB</p>
												</dd>
												<dt class="variation-color">Màu sắc:</dt>
												<dd class="variation-color-value">
													<p>Đen</p>
												</dd>
											</dl></td>

										<td class="product-price" data-title="Giá"><span
											class="product-Price-amount"> <bdi>29.600.000 <span
													class="woocommerce-Price-currencySymbol">&#8363;</span> </bdi>
										</span></td>

										<td class="product-quantity" data-title="Số lượng">
											<div class="quantity-Block">
												<input type="button" value="-" class="input_Capacity-Prev">
												<input type="number" id="quantity_id" value="2"
													inputmode="numeric" /> <input type="button" value="+"
													class="input_Capacity_next">
											</div>
										</td>

										<td class="product-subtotal" data-title="Tạm tính"><span
											class="woocommerce-Price-amount amount"><bdi>59.200.000<span
													class="woocommerce-Price-currencySymbol">&#8363;</span></bdi></span></td>
									</tr>
									<tr class="cart-table-body">
										<td class="product-remove"><a href=""
											class="remove_cart_product"> <i class="fas fa-trash-alt"></i>
										</a></td>

										<td class="product-thumbnail"><a href=""> <img
												src="/images/iphone-7-32g-1.jpg" alt="" />
										</a></td>
										<td class="product-name" data-title="Sản phẩm"><a
											href="./product_detail.html">iPhone X 512GB 100% new </a>
											<dl class="variation">
												<dt class="variation-capacity-tile">Dung lượng:</dt>
												<dd class="variation-capacity-value">
													<p>128GB</p>
												</dd>
												<dt class="variation-color">Màu sắc:</dt>
												<dd class="variation-color-value">
													<p>Đen</p>
												</dd>
											</dl></td>

										<td class="product-price" data-title="Giá"><span
											class="product-Price-amount"> <bdi>29.600.000 <span
													class="woocommerce-Price-currencySymbol">&#8363;</span> </bdi>
										</span></td>

										<td class="product-quantity" data-title="Số lượng">
											<div class="quantity-Block">
												<input type="button" value="-" class="input_Capacity-Prev">
												<input type="number" id="quantity_id" value="2"
													inputmode="numeric" /> <input type="button" value="+"
													class="input_Capacity_next">
											</div>
										</td>

										<td class="product-subtotal" data-title="Tạm tính"><span
											class="woocommerce-Price-amount amount"><bdi>59.200.000<span
													class="woocommerce-Price-currencySymbol">&#8363;</span></bdi></span></td>
									</tr>
									<tr class="w-100" rowspan="2">
										<td colspan="5" class="actions clear">
											<div class="continue-shopping ">
												<a class="button-continue-shopping "
													href="./product_detail.html"> <i
													class="fas fa-long-arrow-alt-left"></i> Tiếp tục xem sản
													phẩm
												</a>
											</div>

											<button type="submit" class="button primary "
												name="update_cart" value="Cập nhật giỏ hàng">Cập
												nhật giỏ hàng</button>
										</td>

									</tr>

								</tbody>
							</table>
						</div>
					</form>
				</div>
				<div class="col l-4 border-l">
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
								<tr class="cart-subtotal">
									<th>Tạm tính</th>
									<td data-title="Tạm tính"><span
										class="woocommerce-Price-amount amount"> <bdi>108.800.000
											<span class="woocommerce-Price-currencySymbol">&#8363;</span>
											</bdi>
									</span></td>
								</tr>
								<tr class="order-total">
									<th>Tổng</th>
									<td data-title="Tổng"><strong> <span
											class="woocommerce-Price-amount amount"> <bdi>108.800.000<span
													class="woocommerce-Price-currencySymbol">&#8363;</span> </bdi>
										</span>
									</strong></td>
								</tr>
							</table>

							<div class="cart-checkout">
								<a href="./check_out.html"> Tiến hành thanh toán </a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

</div>



<jsp:include page="/WEB-INF/view/client/common/footer.jsp"></jsp:include>