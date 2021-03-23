<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="col-md-5 order-details">
	<div class="section-title text-center">
		<h3 class="title">Your Order</h3>
	</div>
	<div class="order-summary">
		<div class="order-col">
			<div>
				<strong>PRODUCT</strong>
			</div>
			<div>
				<strong>TOTAL</strong>
			</div>
			<div>
				<strong>Action</strong>
			</div>
		</div>
		<div class="order-products">
			<c:forEach items="${ghs}" var="gh">
				<div class="order-col">
					<div>${gh.quantity }x ${gh.name }</div>
					<div>${gh.quantity * gh.price }</div>
					<div><a href="#">Delete</a></div>
				</div>
			
			</c:forEach>
		</div>
		<div class="order-col">
			<div>Shiping</div>
			<div>
				<strong>FREE</strong>
			</div>
		</div>
		<div class="order-col">
			<div>
				<strong>TOTAL</strong>
			</div>
			<div>
				<strong class="order-total">${total}</strong>
			</div>
		</div>
	</div>
	
	<a href="#" class="primary-btn order-submit">Place order</a>
</div>