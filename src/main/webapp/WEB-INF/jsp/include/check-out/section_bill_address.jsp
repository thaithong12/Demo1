<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="col-md-7">
	<!-- Billing Details -->
	<div class="billing-details">
		<div class="section-title">
			<h3 class="title">Billing address</h3>
		</div>
		<div class="form-group">
			<input class="input" type="text" name="first-name"
				placeholder="First Name">
		</div>
		<div class="form-group">
			<input class="input" type="text" name="last-name"
				placeholder="Last Name">
		</div>
		<div class="form-group">
			<input class="input" type="email" name="email" placeholder="Email">
		</div>
		<div class="form-group">
			<input class="input" type="text" name="address" placeholder="Address">
		</div>
		<div class="form-group">
			<input class="input" type="text" name="city" placeholder="City">
		</div>
		<div class="form-group">
			<input class="input" type="text" name="country" placeholder="Country">
		</div>
		<div class="form-group">
			<input class="input" type="text" name="zip-code"
				placeholder="ZIP Code">
		</div>
		<div class="form-group">
			<input class="input" type="tel" name="tel" placeholder="Telephone">
		</div>
		<div class="form-group">
			<div class="input-checkbox">
				<input type="checkbox" id="create-account"> <label
					for="create-account"> <span></span> Create Account?
				</label>
				<div class="caption">
					<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit,
						sed do eiusmod tempor incididunt.</p>
					<input class="input" type="password" name="password"
						placeholder="Enter Your Password">
				</div>
			</div>
		</div>
	</div>
	<!-- /Billing Details -->

	<!-- Shiping Details -->
	<div class="shiping-details">
		<div class="section-title">
			<h3 class="title">Shiping address</h3>
		</div>
		<div class="input-checkbox">
			<input type="checkbox" id="shiping-address"> <label
				for="shiping-address"> <span></span> Ship to a diffrent
				address?
			</label>
			<div class="caption">
				<div class="form-group">
					<input class="input" type="text" name="first-name"
						placeholder="First Name">
				</div>
				<div class="form-group">
					<input class="input" type="text" name="last-name"
						placeholder="Last Name">
				</div>
				<div class="form-group">
					<input class="input" type="email" name="email" placeholder="Email">
				</div>
				<div class="form-group">
					<input class="input" type="text" name="address"
						placeholder="Address">
				</div>
				<div class="form-group">
					<input class="input" type="text" name="city" placeholder="City">
				</div>
				<div class="form-group">
					<input class="input" type="text" name="country"
						placeholder="Country">
				</div>
				<div class="form-group">
					<input class="input" type="text" name="zip-code"
						placeholder="ZIP Code">
				</div>
				<div class="form-group">
					<input class="input" type="tel" name="tel" placeholder="Telephone">
				</div>
			</div>
		</div>
	</div>
	<!-- /Shiping Details -->

	<!-- Order notes -->
	<div class="order-notes">
		<textarea class="input" placeholder="Order Notes"></textarea>
	</div>
	<!-- /Order notes -->
</div>