<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div id="header">
	<!-- container -->
	<div class="container">
		<!-- row -->
		<div class="row">
			<!-- LOGO -->
			<div class="col-md-3">
				<div class="header-logo">
					<a href="#" class="logo"> <img
						src="<c:url value="resources/images/logo.png"/>" alt="">
					</a>
				</div>
			</div>
			<!-- /LOGO -->

			<!-- SEARCH BAR -->
			<div class="col-md-6">
				<div class="header-search">
					<form action="/search" method="get">
						<input class="input" name="search" placeholder="Search here">
						<button type="submit" class="search-btn">Search</button>
					</form>
				</div>
			</div>
			<!-- /SEARCH BAR -->

			<!-- ACCOUNT -->
			<div class="col-md-3 clearfix">
				<div class="header-ctn">
					<!-- Wishlist -->
					<div>
						<a href="#"> <i class="fa fa-heart-o"></i> <span>Your
								Wishlist</span>
							<div class="qty">2</div>
						</a>
					</div>
					<!-- /Wishlist -->

					<!-- Cart -->
					<div class="dropdown">
						<a class="dropdown-toggle" data-toggle="dropdown"
							aria-expanded="true"> <i class="fa fa-shopping-cart"></i> <span>Your
								Cart</span>
							<div class="qty">3</div>
						</a>
						<div class="cart-dropdown">
							<div class="cart-list">
								<div class="product-widget">
									<div class="product-img">
										<img src="<c:url value="resources/images/product01.png"/>"
											alt="">
									</div>
									<div class="product-body">
										<h3 class="product-name">
											<a href="#">product name goes here</a>
										</h3>
										<h4 class="product-price">
											<span class="qty">1x</span>$980.00
										</h4>
									</div>
									<button class="delete">
										<i class="fa fa-close"></i>
									</button>
								</div>

								<div class="product-widget">
									<div class="product-img">
										<img src="<c:url value="resources/images/product02.png"/>"
											alt="">
									</div>
									<div class="product-body">
										<h3 class="product-name">
											<a href="#">product name goes here</a>
										</h3>
										<h4 class="product-price">
											<span class="qty">3x</span>$980.00
										</h4>
									</div>
									<button class="delete">
										<i class="fa fa-close"></i>
									</button>
								</div>
							</div>
							<div class="cart-summary">
								<small>3 Item(s) selected</small>
								<h5>SUBTOTAL: $2940.00</h5>
							</div>
							<div class="cart-btns">
								<a href="#">View Cart</a> <a href="#">Checkout <i
									class="fa fa-arrow-circle-right"></i></a>
							</div>
						</div>
					</div>
					<!-- /Cart -->

					<!-- Menu Toogle -->
					<div class="menu-toggle">
						<a href="#"> <i class="fa fa-bars"></i> <span>Menu</span>
						</a>
					</div>
					<!-- /Menu Toogle -->
				</div>
			</div>
			<!-- /ACCOUNT -->
		</div>
		<!-- row -->
	</div>
	<!-- container -->
</div>
</html>