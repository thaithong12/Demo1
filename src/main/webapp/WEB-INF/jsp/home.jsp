	<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- change -->
<!DOCTYPE html>
<html>
	<jsp:include page="include/home/head.jsp" />
<body>
	<header>
		<jsp:include page="include/product/body_header_top.jsp" />
		<jsp:include page="include/product/body_header_search.jsp" />
	</header>
	<jsp:include page="include/home/body_header_navigation.jsp" />
	<jsp:include page="include/home/new_products.jsp" />
	<jsp:include page="include/home/hot_deal.jsp" />
	<jsp:include page="include/home/top_selling_1.jsp" />
	<jsp:include page="include/home/top_selling_2.jsp" />
	<jsp:include page="include/home/news_letter.jsp" />
	<jsp:include page="include/home/footer.jsp" />
	<jsp:include page="include/home/js.jsp" />
</body>
</html>