<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/WEB-INF/view/client/common/header.jsp"></jsp:include>


<div class="wrapper-body">
	<div class="container">
		<div class="product-show">
			<div class="product-show-nav">
				<div class="nav-bar">
					<span class="title-product"> danh sách sản phẩm tìm kiếm : </span>
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
								<li class="price-item"><i class="fas fa-check"></i> <a
									href="/filter?choise=1&start=0&end=2000000">Dưới 2 triệu</a></li>
								<li class="price-item"><i class="fas fa-check"></i> <a
									href="/filter?choise=1&start=2000000&end=4000000"> Từ 2 - 4
										triệu</a></li>
								<li class="price-item"><i class="fas fa-check"></i> <a
									href="/filter?choise=1&start=4000000&end=7000000"> Từ 4 - 7
										triệu</a></li>
								<li class="price-item"><i class="fas fa-check"></i><a
									href="/filter?choise=1&start=7000000&end=13000000"> Từ 7 -
										13 triệu</a></li>
								<li class="price-item"><i class="fas fa-check"></i> <a
									href="/filter?choise=1&start=13000000&end=20000000"> Từ 13
										- 20 triệu</a></li>
							</ul>
						</li>
						<li class="filter-item">
							<div class="filter-capacity">
								dung lượng <i class="fas fa-angle-down"></i>
							</div>
							<ul class="list-capacity">
								<li class="capacity-item"><i class="fas fa-check"></i><a
									href="/filter?choise=2&storage=1">32GB</a></li>
								<li class="capacity-item"><i class="fas fa-check"></i><a
									href="/filter?choise=2&storage=2">64GB</a></li>
								<li class="capacity-item"><i class="fas fa-check"></i><a
									href="/filter?choise=2&storage=3">128GB</a></li>
								<li class="capacity-item"><i class="fas fa-check"></i><a
									href="/filter?choise=2&storage=4">256GB</a></li>

							</ul>
						</li>
						<li class="filter-item">
							<div class="filter-sort">
								sắp xếp <i class="fas fa-angle-down"></i>
							</div>
							<ul class="list-sort">
								<li class="sort-item"><i class="fas fa-check"></i><a
									href="/filter?choise=3"> Giá thấp nhất</a></li>
								<li class="sort-item"><i class="fas fa-check"></i><a
									href="/filter?choise=4">Giá cao nhất</a></li>
							</ul>
						</li>
					</ul>
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
		<c:if test="${choise == 1}">
			<c:forEach var="i" begin="1" end="${totalSize}">

				<a href="/filter?page=${i-1}&start=${start}&end=${end}&choise=1">${i-1}</a>

			</c:forEach>
		</c:if>
		<c:if test="${choise == 2}">
			<c:forEach var="i" begin="1" end="${totalSize}">

				<a href="/filter?page=${i-1}&storage=${storage}&choise=2">${i-1}</a>

			</c:forEach>
		</c:if>
		<c:if test="${choise == 3}">
			<c:forEach var="i" begin="1" end="${totalSize}">

				<a href="/filter?page=${i-1}&choise=3">${i-1}</a>

			</c:forEach>
		</c:if>
		<c:if test="${choise == 4}">
			<c:forEach var="i" begin="1" end="${totalSize}">

				<a href="/filter?page=${i-1}&choise=4">${i-1}</a>

			</c:forEach>
		</c:if>
	</div>
</div>

<jsp:include page="/WEB-INF/view/client/common/footer.jsp"></jsp:include>