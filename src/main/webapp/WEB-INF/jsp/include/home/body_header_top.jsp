<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="top-header">
	<div class="container">
		<ul class="header-links pull-left">
			<li><a href="#"><i class="fa fa-phone"></i> +021-95-51-84</a></li>
			<li><a href="#"><i class="fa fa-envelope-o"></i>
					email@email.com</a></li>
			<li><a href="#"><i class="fa fa-map-marker"></i> 1734
					Stonecoal Road</a></li>
		</ul>
		<ul class="header-links pull-right">
			<li><a href="#"><i class="fa fa-dollar"></i> USD</a></li>
			<li><div>
					<i class="fa fa-user-o"></i>
					<c:if test="${not empty pageContext.request.userPrincipal}">
						<c:if test="${username != ' '}">
							<span style="color: red;">${username}</span>
						</c:if>
						<a href="<c:url value="/logout"/>"><i class="fa fa-dollar"></i>
							Logout
						</a>
					</c:if>
					<c:if test="${empty pageContext.request.userPrincipal}">
						<a href='<c:url value="/login"/>'>Login</a>
					</c:if>
				</div></li>
		</ul>
	</div>
</div>