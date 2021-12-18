<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/WEB-INF/view/client/common/header.jsp"></jsp:include>



<div class="wrapper-body">
		<div class="container">
			<div class="row">
				<div class="col l-9">
					<div class="product-show-nav">
						<div class="nav-bar">
							<span class="title-product"> mô tả </span>
						</div>
					</div>
					<div class="product-desc mb-20">
						<div class="product-desc-feature">
							${blog.details}</div>

					</div>		
				</div>
				<div class="col l-3">
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