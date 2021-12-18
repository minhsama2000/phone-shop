<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/WEB-INF/view/client/common/header.jsp"></jsp:include>



<div class="wrapper-body">
	<div class="container">
		<div class="product-show-nav">
			<div class="nav-bar">
				<span class="title-product"> tin tức </span>
			</div>
		</div>
		<div class="row">
			<div class="col col-litle l-9">
				<div class="wrapper-news">
					<ul class="news-list">
						<c:forEach var="blog" items="${blogs}">
							<li class="new-item"><a href="#" class="news-detail row ">
									<div class="new-img col l-3">

										</span> <img src="/upload/blog/${blog.avatar }" alt="">
									</div>
									<div class="news-desc col l-8">
										<h3 class="news-header">${blog.thumbnail }</h3>
										<p class="new-sub">${blog.shortDescription }</p>
									</div>
							</a></li>
						</c:forEach>
					</ul>
				</div>
			</div>
			<div class="col col-litle l-3 side-bar">
				<div class="side-bar-new">
					<div class="product-show-nav">
						<div class="nav-bar">
							<span class="title-product"> sản phẩm mới </span>
						</div>
					</div>
					<div class="side-bar-content">

						<c:forEach var="product" items="${topProducts}">
							<div class="side-bar-item">
								<a class="row" href="/product-detail?id=${product.id}">
									<div class="col c side-bar-img ">
										<img src="/upload/product/${product.avatar}" alt="">
									</div>
									<p class="col col-litle">
										<span class="product-new"> ${product.name} </span> <strong>
											${product.price}đ </strong>
									</p>
								</a>
							</div>
						</c:forEach>

					</div>
					<div class="side-bar-banner">
						<img src="/images/sider-bar-banner.jpg" alt="" srcset="">
					</div>
				</div>
				<div class="side-bar-new">
					<div class="product-show-nav">
						<div class="nav-bar">
							<span class="title-product"> bài viết mới </span>
						</div>
					</div>
					<div class="side-bar-content">
						
						<c:forEach var="blog" items="${topBlog}">
						<div class="side-bar-item">
							<a class="row" href="/detail-blog?id=${blog.id}">
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
</div>



<jsp:include page="/WEB-INF/view/client/common/footer.jsp"></jsp:include>