<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="col-md-7">
	<!-- Billing Details -->
	<div class="billing-details">
		<form:form modelAttribute="accountInfo" action="/confirmation" method="post">
			Name<form:input path="name" />
			Add<form:input path="address" />
			Phone<form:input path="phone" />
			Email<form:input path="email" />
			<button type="submit">Add</button>
		</form:form>



	</div>
	<!-- /Billing Details -->

	<!-- Shiping Details -->

	<!-- /Shiping Details -->

	<!-- Order notes -->
	<!-- /Order notes -->
</div>