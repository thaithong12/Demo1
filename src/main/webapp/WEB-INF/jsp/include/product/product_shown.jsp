<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<div class="row">
	<!-- Product main img -->
	<c:forEach items="shownDetail" var="item">
		<div class="col-md-5 col-md-push-2">
			<div id="product-main-img">
				<!-- image x4 -->
				<c:forEach items="${product.imageEntities}" var="item">
					<div class="product-preview">
						<img src="<c:url value="resources/images/${item.name}"/>"
							alt="aaaaaaaaaaaaaaa">
					</div>
				</c:forEach>
			</div>
		</div>
	</c:forEach>
	<!-- /Product main img -->

	<!-- Product thumb imgs -->
	<div class="col-md-2  col-md-pull-5">
		<div id="product-imgs">
			<!-- image x4 -->
			<c:forEach items="${product.imageEntities}" var="item">
				<div class="product-preview">
					<img src="<c:url value="resources/images/${item.name}"/>" alt="">
				</div>
			</c:forEach>
		</div>
	</div>

	<div class="col-md-5">
		<div class="product-details">
			<h2 class="product-name">${product.name}</h2>
			<div>
				<div class="product-rating">
					<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
						class="fa fa-star"></i> <i class="fa fa-star"></i> <i
						class="fa fa-star-o"></i>
				</div>
				<a class="review-link" href="#">10 Review(s) | Add your review</a>
			</div>
			<div>
				<h3 class="product-price">
				<span id="price-after">
				<fmt:formatNumber type="number" pattern="###,###"
						value="${product.price}" /> vnd</span>
					
					<del class="product-old-price">$990.00</del>
				</h3>
				<span class="product-available">In Stock</span>
			</div>

			<div class="product-options">
				<label> Size <select class="input-select">
						<option value="0">X</option>
				</select>
				</label> <label> ${product.description} 
				<select productid="${product.id}" id="color-change-select" class="input-select">
					<c:forEach items="${colors }" var="color">
						<option value="${color.id}">${color.name }</option>
					</c:forEach>
						
				</select>
				</label>
			</div>

			<div class="add-to-cart">
				<div class="qty-label">
					Qty
					<div class="input-number">
						<input type="number"> <span class="qty-up">+</span> <span
							class="qty-down">-</span>
					</div>
				</div>
				<button class="add-to-cart-btn">
					<i class="fa fa-shopping-cart"></i> add to cart
				</button>
			</div>

			<ul class="product-btns">
				<li><a href="#"><i class="fa fa-heart-o"></i> add to
						wishlist</a></li>
				<li><a href="#"><i class="fa fa-exchange"></i> add to
						compare</a></li>
			</ul>

			<ul class="product-links">
				<li>Category:</li>
				<li><a href="#">Headphones</a></li>
				<li><a href="#">Accessories</a></li>
			</ul>

			<ul class="product-links">
				<li>Share:</li>
				<li><a href="#"><i class="fa fa-facebook"></i></a></li>
				<li><a href="#"><i class="fa fa-twitter"></i></a></li>
				<li><a href="#"><i class="fa fa-google-plus"></i></a></li>
				<li><a href="#"><i class="fa fa-envelope"></i></a></li>
			</ul>

		</div>
	</div>

</div>