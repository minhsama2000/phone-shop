<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/view/admin/common/navbar.jsp"></jsp:include>
<jsp:include page="/WEB-INF/view/admin/common/sidebar.jsp"></jsp:include>
<div id="content-wrapper">

	<div class="container-fluid">

		<!-- Breadcrumbs-->
		<ol class="breadcrumb">
			<li class="breadcrumb-item"><a href="#">Dashboard</a></li>
			<li class="breadcrumb-item active">Overview</li>
		</ol>

		<!-- Icon Cards-->
		<div class="row">
			<div class="col-xl-3 col-sm-6 mb-3">
				<div class="card text-white bg-success o-hidden h-100">
					<div class="card-body">
						<div class="card-body-icon">
							<i class="fas fa-fw fa-shopping-cart"></i>
						</div>
						<div class="mr-5">Doanh thu: ${totalEarn} đ</div>
					</div>
					
				</div>
			</div>
			<div class="col-xl-3 col-sm-6 mb-3">
				<div class="card text-white bg-danger o-hidden h-100">
					<div class="card-body">
						<div class="card-body-icon">
							<i class="fas fa-fw fa-life-ring"></i>
						</div>
						<div class="mr-5">Số thành viên: ${totalUser}</div>
					</div>
					
				</div>
			</div>
		</div>

		<!-- DataTables Example -->

		<div class="card mb-3">
			<div class="card-header">
				<i class="fas fa-table"></i> Data Table Done order
			</div>
			<div class="card-body">
				<div class="table-responsive">
					<table class="table table-bordered" id="dataTableDonOder"
						width="100%" cellspacing="0">
						<thead>
							<tr>
								<th>id</th>
								<th>Order code</th>
								<th>Created date</th>
								<th>Order status</th>
								<th>Total</th>
								<th></th>
							</tr>
						</thead>
					</table>
				</div>
			</div>
		</div>
		<div class="card-footer small text-muted">Updated yesterday at
			11:59 PM</div>
	</div>

</div>
<!-- /.container-fluid -->

<jsp:include page="/WEB-INF/view/admin/common/footer.jsp"></jsp:include>