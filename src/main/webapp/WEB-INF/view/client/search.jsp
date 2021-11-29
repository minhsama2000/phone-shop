<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/WEB-INF/view/client/common/header.jsp"></jsp:include>


<div class="wrapper-body">
	<div class="container">
		<div class="product-show">
			<div class="product-show-nav">
				<div class="nav-bar">
					<span class="title-product"> danh sách sản phẩm tìm kiếm :
						iphone 7 </span>
				</div>
			</div>

			<div class="row no-gutters products-show-list">
				<div class="col l-12 navbar-filter">
					<ul class="row list-filter">
						<li class="filter-item">
							<div class="filter-price">
								giá <i class="fas fa-angle-down"></i>
							</div>
							<ul class="list-price">
								<li class="price-item"><i class="fas fa-check"></i> Dưới 2
									triệu</li>
								<li class="price-item"><i class="fas fa-check"></i> Từ 2 -
									4 triệu</li>
								<li class="price-item"><i class="fas fa-check"></i> Từ 4 -
									7 triệu</li>
								<li class="price-item"><i class="fas fa-check"></i> Từ 7 -
									13 triệu</li>
								<li class="price-item"><i class="fas fa-check"></i> Từ 13 -
									20 triệu</li>
							</ul>
						</li>
						<li class="filter-item">
							<div class="filter-capacity">
								dung lượng <i class="fas fa-angle-down"></i>
							</div>
							<ul class="list-capacity">
								<li class="capacity-item"><i class="fas fa-check"></i> 2GB
								</li>
								<li class="capacity-item"><i class="fas fa-check"></i> 4GB
								</li>
								<li class="capacity-item"><i class="fas fa-check"></i> 8GB
								</li>

							</ul>
						</li>
						<li class="filter-item">
							<div class="filter-sort">
								sắp xếp <i class="fas fa-angle-down"></i>
							</div>
							<ul class="list-sort">
								<li class="sort-item"><i class="fas fa-check"></i> màu</li>
								<li class="sort-item"><i class="fas fa-check"></i> giá thấp
									nhất</li>
								<li class="sort-item"><i class="fas fa-check"></i> giá cao
									nhất</li>
							</ul>
						</li>
					</ul>
					<div class="row filter-choosed">
						<div class="col l-4">
							<a href="" data-type="price"> <span>Từ 2 - 4 triệu</span> <i
								class="fas fa-times"></i>
							</a>
						</div>
						<div class="col l-4">
							<a href="" data-type="capacity"> <span>2GB</span> <i
								class="fas fa-times"></i>
							</a>
						</div>
					</div>
				</div>
				<c:forEach var="product" items="${products}">
					<div class="col l-3 ">
						<div class="product-item">
							<a href="/product-details?id=${product.id}">
								<div class="product-item-img">
									<img src="/upload/product/${product.avatar}" alt="" srcset="">
								</div>
								<div class="product-item-desc">
									<h3 class="product-item-title">${product.name}</h3>
									<span class="product-item-price"> ${product.price}đ </span>
								</div>
							</a>
						</div>
					</div>
				</c:forEach>

			</div>

		</div>

	</div>
	<div class="pagination">
		<c:if test="${choise == 3}">
			<c:forEach var="i" begin="1" end="${totalSize}">

				<a href="/search?page=${i-1}">${i-1}</a>

			</c:forEach>
		</c:if>
		<c:if test="${choise == 1}">
			<c:forEach var="i" begin="1" end="${totalSize}">

				<a href="/search?page=${i-1}&categoryId=${categoryId}&select=parent">${i-1}</a>

			</c:forEach>
		</c:if>
		<c:if test="${choise == 2}">
			<c:forEach var="i" begin="1" end="${totalSize}">

				<a href="/search?page=${i-1}&categoryId=${categoryId}">${i-1}</a>

			</c:forEach>
		</c:if>
		<c:if test="${choise == 0}">
			<c:forEach var="i" begin="1" end="${totalSize}">

				<a href="/search?page=${i-1}&searchText=${searchText}">${i-1}</a>

			</c:forEach>
		</c:if>
	</div>
</div>

<jsp:include page="/WEB-INF/view/client/common/footer.jsp"></jsp:include>