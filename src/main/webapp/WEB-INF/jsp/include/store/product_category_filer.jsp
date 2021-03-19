<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="aside">
	<h3 class="aside-title">Categories</h3>
	<div class="checkbox-filter">
		<c:forEach items="${categories}" var="category">
			<div class="input-checkbox">
				<input type="checkbox" id="category-1"> 
				<a href='<c:url value="/store-detail?id=${category.id}"/>'>				
					<span> ${category.name }</span>
				</a>

			</div>
		</c:forEach>
	</div>
</div>