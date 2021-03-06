<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="col-md-4 col-xs-6">
	<div class="section-title">
		<h4 class="title">Top selling</h4>
		<div class="section-nav">
			<div id="slick-nav-3" class="products-slick-nav"></div>
		</div>
	</div>

	<div class="products-widget-slick" data-nav="#slick-nav-3">
		<div>
			<!-- product widget -->
			<jsp:include page="section-2-topselling-product-widget.jsp"/>
			<!-- /product widget -->

			<!-- product widget -->
			<jsp:include page="section-2-topselling-product-widget.jsp"/>
			<!-- /product widget -->

			<!-- product widget -->
			<jsp:include page="section-2-topselling-product-widget.jsp"/>
			<!-- product widget -->
		</div>

		<div>
			<!-- product widget -->
			<div class="product-widget">
				<div class="product-img">
					<img src="./img/product01.png" alt="">
				</div>
				<div class="product-body">
					<p class="product-category">Category</p>
					<h3 class="product-name">
						<a href="#">product name goes here</a>
					</h3>
					<h4 class="product-price">
						$980.00
						<del class="product-old-price">$990.00</del>
					</h4>
				</div>
			</div>
			<!-- /product widget -->

			<!-- product widget -->
			<div class="product-widget">
				<div class="product-img">
					<img src="./img/product02.png" alt="">
				</div>
				<div class="product-body">
					<p class="product-category">Category</p>
					<h3 class="product-name">
						<a href="#">product name goes here</a>
					</h3>
					<h4 class="product-price">
						$980.00
						<del class="product-old-price">$990.00</del>
					</h4>
				</div>
			</div>
			<!-- /product widget -->

			<!-- product widget -->
			<div class="product-widget">
				<div class="product-img">
					<img src="./img/product03.png" alt="">
				</div>
				<div class="product-body">
					<p class="product-category">Category</p>
					<h3 class="product-name">
						<a href="#">product name goes here</a>
					</h3>
					<h4 class="product-price">
						$980.00
						<del class="product-old-price">$990.00</del>
					</h4>
				</div>
			</div>
			<!-- product widget -->
		</div>
	</div>
</div>
