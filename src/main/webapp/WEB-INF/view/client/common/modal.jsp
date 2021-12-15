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
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Đóng</button>
			</div>
		</div>
	</div>

</div>