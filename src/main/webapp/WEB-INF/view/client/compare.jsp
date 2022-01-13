<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Compare</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
<style type="text/css">
body {
	margin-top: 20px;
}

.comparison-table {
	width: 100%;
	font-size: .875rem;
	overflow-x: auto;
	-webkit-overflow-scrolling: touch;
	-ms-overflow-style: -ms-autohiding-scrollbar
}

.comparison-table table {
	min-width: 41rem;
	table-layout: fixed
}

.comparison-table table tbody+tbody {
	border-top-width: 1px
}

.comparison-table .table-bordered thead td {
	border-bottom-width: 1px
}

.comparison-table .comparison-item {
	position: relative;
	padding: .875rem .75rem 1.125rem;
	border: 1px solid #e7e7e7;
	background-color: #fff;
	text-align: center
}

.comparison-table .comparison-item .comparison-item-thumb {
	display: block;
	width: 5rem;
	margin-right: auto;
	margin-bottom: .75rem;
	margin-left: auto
}

.comparison-table .comparison-item .comparison-item-thumb>img {
	display: block;
	width: 100%
}

.comparison-table .comparison-item .comparison-item-title {
	display: block;
	width: 100%;
	margin-bottom: 14px;
	color: #222;
	font-weight: 600;
	text-decoration: none
}

.comparison-table .comparison-item .comparison-item-title:hover {
	text-decoration: underline
}

.comparison-table .comparison-item .btn {
	margin: 0
}

.comparison-table .comparison-item .remove-item {
	display: block;
	position: absolute;
	top: -.3125rem;
	right: -.3125rem;
	width: 1.375rem;
	height: 1.375rem;
	border-radius: 50%;
	background-color: #f44336;
	color: #fff;
	text-align: center;
	cursor: pointer
}

.comparison-table .comparison-item .remove-item .feather {
	width: .875rem;
	height: .875rem
}

.table-bordered th, .table-bordered td {
	border: 1px solid #e7e7e7;
}

.bg-secondary {
	background-color: #f7f7f7 !important;
}
</style>
</head>
<body>
	<div class="container pb-5 mb-2">
		<div class="comparison-table">
			<table class="table table-bordered">
				<thead class="bg-secondary">
					<tr>
						<td class="align-middle"><select
							class="form-control custom-select" id="compare-criteria"
							data-filter="trigger">
								<option value="all">Comparison criteria *</option>
								<option value="summary">Summary</option>
								<option value="general">General</option>
						</select><small class="form-text text-muted">* Choose criteria to
								filter table below.</small>
							<div class="pt-3">
								<div class="custom-control custom-checkbox">
									<input class="custom-control-input" type="checkbox"
										id="differences"> <label class="custom-control-label"
										for="differences">Show differences only</label>
								</div>
							</div></td>
						<c:forEach items="${listCraw}" var="craw">
							<td>
								<div class="comparison-item">
										<line x1="18" y1="6" x2="6" y2="18"></line>
										<line x1="6" y1="6" x2="18" y2="18"></line></svg></span> <a
										class="comparison-item-thumb" href="shop-single.html"><img
										src="${craw.avatar}" alt="Apple iPhone Xs Max"></a><a
										class="comparison-item-title" href="shop-single.html">${craw.name}</a> <a
										class="btn btn-pill btn-outline-primary btn-sm"
										href="${craw.url}" type="button" data-toggle="toast"
										data-target="#cart-toast">Xem chi tiết</a>
								</div>
							</td>
						</c:forEach>
					</tr>
				</thead>
				<tbody id="summary" data-filter="target">
					<tr class="bg-secondary">
						<th class="text-uppercase">Summary</th>
						<c:forEach items="${listCraw}" var="craw">
							<td><span class="text-dark font-weight-semibold">${craw.name}</span></td>
						</c:forEach>

					</tr>
					<tr>
						<th>Price</th>
						<c:forEach items="${listCraw}" var="craw">
							<td>${craw.price}</td>
						</c:forEach>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<script type="text/javascript">
		$(function() {
			$('[data-filter="trigger"]').on(
					"change",
					function() {
						var t = $(this).find("option:selected").val()
								.toLowerCase();

						$('[data-filter="target"]').css("display", "none");
						$("#" + t).css("display", "table-row-group");
						if (t == "all") {
							$('[data-filter="target"]').css("display",
									"table-row-group")
						}
						$(this).css("display", "block");
					});
		})
	</script>
</body>
</html>