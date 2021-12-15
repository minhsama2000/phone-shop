
<jsp:include page="/WEB-INF/view/admin/common/navbar.jsp"></jsp:include>
<jsp:include page="/WEB-INF/view/admin/common/sidebar.jsp"></jsp:include>

<div id="content-wrapper">

	<div class="container-fluid">

		<!-- Breadcrumbs-->
		<ol class="breadcrumb">
			<li class="breadcrumb-item"><a href="#">Dashboard</a></li>
			<li class="breadcrumb-item active">Order</li>
		</ol>

		<!-- DataTables Example -->
		<div class="card mb-3">
			<div class="card-header">
				<i class="fas fa-table"></i> Data Table Order
			</div>
			<div class="card-body">
				<div class="table-responsive">
					<table class="table table-bordered" id="dataTableOrder" width="100%"
						cellspacing="0">
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
		
		<!-- DataTables Example -->
		<div class="card mb-3">
			<div class="card-header">
				<i class="fas fa-table"></i> Data Table Done order
			</div>
			<div class="card-body">
				<div class="table-responsive">
					<table class="table table-bordered" id="dataTableDonOder" width="100%"
						cellspacing="0">
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

		<p class="small text-center text-muted my-5">
			<em>More table examples coming soon...</em>
		</p>

	</div>
	<!-- /.container-fluid -->

	<jsp:include page="/WEB-INF/view/admin/common/footer.jsp"></jsp:include>