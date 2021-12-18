<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/WEB-INF/view/client/common/header.jsp"></jsp:include>



<div class="wrapper-body">
	<div class="container">
		<div class="row">
			<div class="col col-litle l-9 wrapper-content">
				<div class="slider-list">
					<div class=" owl-carousel owl-theme ">
						<div class=" slider-item item">
							<img src="/images/banner1.jpg" alt="">
						</div>
						<div class="slider-item item">
							<img src="/images/banner2.jpg" alt="">
						</div>
						<div class="slider-item item">
							<img src="/images/banner3.jpg" alt="">
						</div>
						<div class="slider-item item">
							<img src="/images/banner4.jpg" alt="">
						</div>
					</div>
				</div>
				<div class="wrapper-content-menu">
					<div class="wrapper-nav">
						<div class=" nav-bar">
							<ul class=" row no-gutters nav-bar-list">
								<li class="nav-bar-item"><a id="productNew"> sản phẩm
										mới </a></li>
								<li class="nav-bar-item"><a id="productSeller"> sản
										phẩm bán chạy </a></li>

							</ul>
						</div>
					</div>
					<div class="row wrapper-content-show" id="setProduct"></div>
				</div>
			</div>
			<div class="col col-litle l-3 side-bar">
				<div class="side-bar-new">
					<div class="product-show-nav">
						<div class="nav-bar">
							<span class="title-product"> tin tức </span>
						</div>
					</div>
					<div class="side-bar-content">

						<c:forEach var="blog" items="${topBlog}">
							<div class="side-bar-item">
								<a class="row" href="">
									<div class="col c side-bar-img ">
										<img src="/upload/blog/${blog.avatar}" alt="">
									</div>
									<p class="col col-litle">${blog.thumbnail}</p>
								</a>
							</div>
						</c:forEach>
					</div>
					<div class="side-bar-banner">
						<img src="/images/sider-bar-banner.jpg" alt="" srcset="">
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="product-show">
			<div class="product-show-nav">
				<div class="nav-bar">
					<span class="title-product"> Điện thoại </span>
					<ul class="row no-gutters nav-bar-list">
						<c:forEach var="phone" items="${phones}">
							<li class="nav-bar-item"><a
								onclick="phoneProduct(${phone.id});"> ${phone.name}</a></li>
						</c:forEach>
					</ul>
				</div>
			</div>
			<div class="row products-show-list" id="phoneProduct"></div>
		</div>
	</div>
	<div class="container">
		<div class="product-show">
			<div class="product-show-nav">
				<div class="nav-bar">
					<span class="title-product"> Tablet </span>
					<ul class="row no-gutters nav-bar-list">
						<c:forEach var="tablet" items="${tablets}">
							<li class="nav-bar-item"><a
								onclick="tabletProduct(${tablet.id})"> ${tablet.name} </a></li>
						</c:forEach>
					</ul>
				</div>
			</div>
			<div class="row products-show-list" id="tabletProduct"></div>
		</div>
	</div>
	<div class="container">
		<div class="product-show">
			<div class="product-show-nav">
				<div class="nav-bar">
					<span class="title-product"> Phụ kiện </span>
					<ul class="row no-gutters nav-bar-list">
						<c:forEach var="tool" items="${tools}">
							<li class="nav-bar-item"><a
								onclick="toolProduct(${tool.id})"> ${tool.name} </a></li>
						</c:forEach>
					</ul>
				</div>
			</div>
			<div class="row products-show-list" id="toolProduct"></div>
		</div>
	</div>
	<div class="container">
		<div class="product-show">
			<div class="product-show-nav">
				<div class="nav-bar">
					<span class="title-product"> Laptop </span>
					<ul class="row no-gutters nav-bar-list">
						<c:forEach var="laptop" items="${laptops}">
							<li class="nav-bar-item"><a
								onclick="toolProduct(${laptop.id})"> ${laptop.name} </a></li>
						</c:forEach>
					</ul>
				</div>
			</div>
			<div class="row products-show-list" id="laptopProduct"></div>
		</div>
	</div>
</div>



<jsp:include page="/WEB-INF/view/client/common/footer.jsp"></jsp:include>