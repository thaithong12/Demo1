<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div>
	<!-- product widget -->
	<c:forEach items="${topselling1}" var="item" >
		<div class="product-widget">
		<div class="product-img">
			<img src="<c:url value="resources/images/${item.getOneImage()}"/>" alt="">
		</div>
		<div class="product-body">
			<p class="product-category">Category</p>
			<h3 class="product-name">
				<a href="#">${item.name }</a>
			</h3>
			<h4 class="product-price">
				${item.price}
				<del class="product-old-price">$990.00</del>
			</h4>
		</div>
	</div>
	</c:forEach>
	

	<!-- /product widget -->

	<!-- product widget -->

	<!-- /product widget -->

	<!-- product widget -->
	
	<!-- product widget -->
</div>