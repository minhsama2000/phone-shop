<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
.reviewOrder {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

.reviewOrder td, th {
	border: 1px solid #dddddd;
	text-align: left;
	padding: 8px;
}
</style>
<div class="modal" id="modalDialog" tabindex="-1" role="dialog">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title">Modal Dialog</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body" id="errorLog">
				<p>Modal body text goes here.</p>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>

<div class="modal fade" id="newCate" role="dialog">
	<div class="modal-dialog">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header"></div>
			<div class="modal-body">
				<div class="row">
					<div class="col-lg-12">
						<div class="card">
							<div class="card-header">New</div>
							<div class="card-body">
								<div class="card-title">
									<h3 class="text-center title-2">Danh mục</h3>
								</div>
								<hr>
								<div class="form-group">
									<label class="control-label" for="email">Chọn danh mục
										cha:</label>
									<div class="col-sm-12">
										<select id="parentCategory" class="form-control">

											<select />
									</div>
								</div>
								<div class="form-group">
									<label for="cc-payment" class="control-label mb-1">Tên
										danh mục</label> <input id="cateName" name="name" type="text"
										class="form-control" aria-required="true" data-val="true"
										data-val-required="Please enter the name" aria-invalid="false"
										placeholder="name">
								</div>

							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button type="submit" onclick="addNewCate(event);"
					class="btn btn-info">Thêm</button>
				<button type="button" class="btn btn-default" data-dismiss="modal">Đóng</button>
			</div>
		</div>
	</div>

</div>

<div class="modal fade" id="detailCategory" role="dialog">
	<div class="modal-dialog">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header"></div>
			<div class="modal-body">
				<div class="row">
					<div class="col-lg-12">
						<div class="card">
							<div class="card-header">Update</div>
							<div class="card-body">
								<div class="card-title">
									<h3 class="text-center title-2">Danh mục</h3>
								</div>
								<hr>
								<intput type="hidden" id="cateIdUpdate" />
								<div class="form-group">
									<label class="control-label" for="email">Chọn danh mục
										cha:</label>
									<div class="col-sm-12">
										<select id="parentCategoryUpdate" class="form-control">

											<select />
									</div>
								</div>
								<div class="form-group">
									<label for="cc-payment" class="control-label mb-1">Tên
										danh mục</label> <input id="cateNameUpdate" name="name" type="text"
										class="form-control" aria-required="true" data-val="true"
										data-val-required="Please enter the name" aria-invalid="false"
										placeholder="name">
								</div>

							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button type="submit" onclick="updateCate(event);"
					class="btn btn-info">Cập nhật</button>
				<button type="button" class="btn btn-default" data-dismiss="modal">Đóng</button>
			</div>
		</div>
	</div>

</div>



<div class="modal fade" id="confirmDeleteCate" role="dialog">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title">Modal title</h5>
			</div>
			<div class="modal-body">
				<p>Are you sure</p>
			</div>
			<div class="modal-footer">
				<input type="hidden" id="idForDeleteCate" />
				<button type="button" id="buttonDeleteCate" class="btn btn-primary">Delete</button>
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			</div>
		</div>

	</div>
</div>









<div class="modal fade" id="newProduct" role="dialog">
	<div class="modal-dialog modal-lg">

		<!-- Modal content-->
		<form method="POST" enctype="multipart/form-data"
			id="fileUploadFormProduct">
			<div class="modal-content">
				<div class="modal-header"></div>
				<div class="modal-body">
					<div class="row">

						<div class="col-lg-6">
							<div class="card">
								<div class="card-header">New</div>
								<div class="card-body">
									<div class="card-title">
										<h3 class="text-center title-2">Sản phẩm</h3>
									</div>
									<hr>
									<div class="form-group">
										<label class="control-label" for="email">Chọn danh
											mục:</label>
										<div class="col-sm-12">
											<select id="productCategory" name="categoryId"
												class="form-control">
												<option value=""></option>
												<select />
										</div>
									</div>

									<div class="form-group">
										<label for="cc-payment" class="control-label mb-1">Tên
											sản phẩm</label> <input id="productName" name="name" type="text"
											class="form-control" aria-required="true"
											data-val-required="Please enter the name"
											aria-invalid="false" placeholder="name">
									</div>
									<div class="form-group">
										<label for="cc-payment" class="control-label mb-1">Số
											lượng tồn</label> <input id="productAvailable" name="available"
											type="text" class="form-control" aria-required="true"
											value="0" data-val="true"
											data-val-required="Please enter the name"
											aria-invalid="false" placeholder="0">
									</div>
									<div class="form-group">
										<label for="cc-payment" class="control-label mb-1">Giá
											(Đ)</label> <input id="productPrice" name="price" type="text"
											class="form-control" aria-required="true" data-val="true"
											data-val-required="Please enter the name" value="0"
											aria-invalid="false" placeholder="20">
									</div>
									<div class="form-group">
										<label for="cc-payment" class="control-label mb-1">Màu
											sắc</label>
										<div class="col-sm-12">
											<select id="color" name="color" class="form-control">
												<option value="0">Không có</option>
												<option value="1">Đỏ</option>
												<option value="2">Xanh</option>
												<option value="3">Đen</option>
												<option value="4">Vàng</option>
												<select />
										</div>
									</div>
									<div class="form-group">
										<label for="cc-payment" class="control-label mb-1">Storage</label>
										<div class="col-sm-12">
											<select id="storage" name="storage" class="form-control">

												<option value="0">Không có</option>
												<option value="1">32G</option>
												<option value="2">64G</option>
												<option value="3">128G</option>
												<option value="4">256G</option>

												<select />
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="col-lg-6">
							<div class="card">
								<div class="form-group has-success">
									<label for="cc-name" class="control-label mb-1">Description</label>
									<textarea id="productDetailDescription" class="summernote"
										name="detailDescription" type="text"></textarea>
									<span class="help-block field-validation-valid"
										data-valmsg-for="cc-name" data-valmsg-replace="true"></span>
								</div>


								<label for="cc-name" class="control-label mb-1"></label> <img
									id="outputProduct" class="img-rounded" alt="" width="250"
									height="200" src="" />
								<p>
									<label for="ufile" style="cursor: pointer">chon file
										anh</label>
								</p>
								<input name="file" id="ufile" type="file" style="display: none"
									onchange="loadFile(event)" />

							</div>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<div>
						<button onclick="addNewProduct(event);" type="submit"
							class="btn btn-lg btn-info btn-block">
							<span id="payment-button-amount">Submit</span> <span
								id="payment-button-sending" style="display: none;">Sending</span>
						</button>
					</div>

					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>
		</form>
	</div>
</div>


<div class="modal fade" id="detailProduct" role="dialog">
	<div class="modal-dialog modal-lg">

		<!-- Modal content-->
		<form method="POST" enctype="multipart/form-data"
			id="fileUploadFormProductUpdate">
			<div class="modal-content">
				<div class="modal-header"></div>
				<div class="modal-body">
					<div class="row">

						<div class="col-lg-6">
							<div class="card">
								<div class="card-header">Detail</div>
								<div class="card-body">
									<div class="card-title">
										<h3 class="text-center title-2">Sản phẩm</h3>
									</div>
									<hr>
									<div class="form-group">
										<label class="control-label" for="email">Chọn danh
											mục:</label>
										<div class="col-sm-12">
											<select id="productCategoryUpdate" name="categoryId"
												class="form-control">
												<option value=""></option>
												<select />
										</div>
									</div>
									<input type="hidden" id="productIdUpdate" name="id" />
									<div class="form-group">
										<label for="cc-payment" class="control-label mb-1">Tên
											sản phẩm</label> <input id="productNameUpdate" name="name"
											type="text" class="form-control" aria-required="true"
											data-val-required="Please enter the name"
											aria-invalid="false" placeholder="name">
									</div>
									<div class="form-group">
										<label for="cc-payment" class="control-label mb-1">Số
											lượng tồn</label> <input id="productAvailableUpdate" name="available"
											type="text" class="form-control" aria-required="true"
											value="0" data-val="true"
											data-val-required="Please enter the name"
											aria-invalid="false" placeholder="0">
									</div>
									<div class="form-group">
										<label for="cc-payment" class="control-label mb-1">Giá
											(Đ)</label> <input id="productPriceUpdate" name="price" type="text"
											class="form-control" aria-required="true" data-val="true"
											data-val-required="Please enter the name" value="0"
											aria-invalid="false" placeholder="20">
									</div>
									<div class="form-group">
										<label for="cc-payment" class="control-label mb-1">Màu
											sắc</label>
										<div class="col-sm-12">
											<select id="colorUpdate" name="color" class="form-control">
												<option value="0">Không có</option>
												<option value="1">Đỏ</option>
												<option value="2">Xanh</option>
												<option value="3">Đen</option>
												<option value="4">Vàng</option>
												<select />
										</div>
									</div>
									<div class="form-group">
										<label for="cc-payment" class="control-label mb-1">Storage</label>
										<div class="col-sm-12">
											<select id="storageUpdate" name="storage"
												class="form-control">

												<option value="0">Không có</option>
												<option value="1">32G</option>
												<option value="2">64G</option>
												<option value="3">128G</option>
												<option value="4">256G</option>

												<select />
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="col-lg-6">
							<div class="card">
								<div class="form-group has-success">
									<label for="cc-name" class="control-label mb-1">Description</label>
									<textarea id="productDetailDescriptionUpdate"
										class="summernote" name="detailDescription" type="text"></textarea>
									<span class="help-block field-validation-valid"
										data-valmsg-for="cc-name" data-valmsg-replace="true"></span>
								</div>


								<label for="cc-name" class="control-label mb-1"></label> <img
									id="outputProductUpdate" class="img-rounded" alt="" width="250"
									height="200" src="" />
								<p>
									<label for="ufileUpdate" style="cursor: pointer">chon
										file anh</label>
								</p>
								<input name="file" id="ufileUpdate" type="file"
									style="display: none" onchange="loadFileUpdate(event)" />

							</div>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<div>
						<button onclick="updateProduct(event);" type="submit"
							class="btn btn-lg btn-info btn-block">
							<span id="payment-button-amount">Submit</span> <span
								id="payment-button-sending" style="display: none;">Sending</span>
						</button>
					</div>

					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>
		</form>
	</div>
</div>

<div class="modal fade" id="confirmDeleteProduct" role="dialog">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title">Title</h5>
			</div>
			<div class="modal-body">
				<p>Are you sure</p>
			</div>
			<div class="modal-footer">
				<input type="hidden" id="idForDeleteProduct" />
				<button type="button" onclick="deleteProduct();"
					class="btn btn-primary">Delete</button>
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			</div>
		</div>

	</div>
</div>













<div class="modal fade" id="confirmDeleteOrder" role="dialog">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title">Modal title</h5>
			</div>
			<div class="modal-body">
				<p>Are you sure</p>
			</div>
			<div class="modal-footer">
				<input type="hidden" id="idForDeleteOrder" />
				<button type="button" id="buttonDeleteOrder" class="btn btn-primary">Delete</button>
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			</div>
		</div>

	</div>
</div>

<div class="modal fade" id="detailOrder" role="dialog">
	<div class="modal-dialog">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header"></div>
			<div class="modal-body">
				<div class="row">
					<div class="col-lg-12">
						<div class="card">
							<div class="card-header">Update</div>
							<div class="card-body">
								<div class="card-title">
									<h3 class="text-center title-2">Trạng thái</h3>
								</div>
								<hr>
								<intput type="hidden" id="cateIdUpdate" />
								<div class="form-group">
									<label class="control-label" for="email">Chọn trạng
										thái:</label>
									<div class="col-sm-12">
										<div class="rs-select2--trans rs-select2--sm"
											id="selectStatus"></div>

									</div>

								</div>
								<div class="form-group" id="reviewUserOrder">
									
								</div>
								<table class="reviewOrder">
									<thead>
										<tr>
											<th>Product id</th>
											<th>Product name</th>
											<th>Quantity</th>
											<th>Price</th>
											<th>Total</th>
										</tr>
									</thead>
									<tbody id="bodyReviewOrder">
										<tr>
											<td>Alfreds Futterkiste</td>
											<td>Maria Anders</td>
											<td>Germany</td>
										</tr>
									</tbody>

								</table>

							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Đóng</button>
			</div>
		</div>
	</div>

</div>

<div class="modal fade" id="detailUser" role="dialog">
	<div class="modal-dialog">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header"></div>
			<div class="modal-body">
				<div class="row">
					<div class="col-lg-12">
						<div class="card">
							<div class="card-header">User</div>
							<div class="card-body">
								<div class="card-title">
									<h3 class="text-center title-2">Detail & Update role</h3>
								</div>
								<hr>
								<intput type="hidden" id="cateIdUpdate" />
								<div class="form-group">
									<label class="control-label" for="email">Chọn quyền:</label>
									<div class="col-sm-12">
										<div class="rs-select2--trans rs-select2--sm"
											id="selectUserRole"></div>

									</div>

								</div>
								<div class="form-group">
									<label class="control-label" for="email">Username: </label>
									<div class="col-sm-12">
										<h4 id="usernameDetail"></h4>
									</div>

								</div>
								<label for="cc-name" class="control-label mb-1"></label> <img
									id="outputUserRole" class="img-rounded" alt="" width="250"
									height="200" src="" />
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Đóng</button>
			</div>
		</div>
	</div>

</div>