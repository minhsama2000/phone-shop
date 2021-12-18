<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/view/admin/common/navbar.jsp"></jsp:include>
<jsp:include page="/WEB-INF/view/admin/common/sidebar.jsp"></jsp:include>

<div id="content-wrapper">

	<div class="container-fluid">

		<!-- Breadcrumbs-->
		<ol class="breadcrumb">
			<li class="breadcrumb-item"><a href="#">Dashboard</a></li>
			<li class="breadcrumb-item active">Tables</li>
		</ol>

		<button type="button" name="addCate" id="addCate" class="btn btn-info">Thêm danh mục</button>
		<!-- DataTables Example -->
		<div class="card mb-3">
			<div class="card-header">
				<i class="fas fa-table"></i> Data Table Category
			</div>
			<div class="card-body">
				<div class="table-responsive">
					<table class="table table-bordered" id="dataTableCate" width="100%"
						cellspacing="0">
						<thead>
							<tr>
								<th>id</th>
								<th>Name</th>
								<th>Created date</th>
								<th>Updated date</th>
								<th></th>
							</tr>
						</thead>
					</table>
				</div>
			</div>
			<div class="card-footer small text-muted">Updated yesterday at
				11:59 PM</div>
		</div>
		
		<button type="button" name="addProduct" id="addProduct" class="btn btn-info">Thêm sản phẩm</button>
		<!-- DataTables Example -->
		<div class="card mb-3">
			<div class="card-header">
				<i class="fas fa-table"></i> Data Table Product
			</div>
			<div class="card-body">
				<div class="table-responsive">
					<table class="table table-bordered" id="dataTableProduct" width="100%"
						cellspacing="0">
						<thead>
							<tr>
								<th>id</th>
								<th>Name</th>
								<th>Created date</th>
								<th>Updated date</th>
								<th></th>
							</tr>
						</thead>
					</table>
				</div>
			</div>
			<div class="card-footer small text-muted">Updated yesterday at
				11:59 PM</div>
		</div>

		<p class="small text-center text-muted my-5">
			<em>More table examples coming soon...</em>
		</p>

	</div>
	<!-- /.container-fluid -->

	<jsp:include page="/WEB-INF/view/admin/common/footer.jsp"></jsp:include>