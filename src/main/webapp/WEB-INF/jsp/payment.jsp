<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>Credit Card Payment </title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />

    <link rel="stylesheet" type="text/css" href="<c:url value="resources/payment/bootstrap/css/bootstrap.min.css"/>" />
    <link rel="stylesheet" type="text/css" href="<c:url value="resources/payment/font-awesome/css/font-awesome.min.css"/>" />

    <script type="text/javascript" src="<c:url value="resources/payment/js/jquery-1.10.2.min.js"/>"></script>
    <script type="text/javascript" src="<c:url value="resources/payment/bootstrap/js/bootstrap.min.js"/>"></script>
</head>
<body>

<div class="container">

<div class="page-header">
    <h1>Credit Card Payment Form <small>A responsive credit card payment template</small></h1>
</div>

<!-- Credit Card Payment Form - START -->

<div class="container">
    <div class="row">
        <div class="col-xs-12 col-md-4 col-md-offset-4">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <div class="row">
                        <h3 class="text-center">Payment Details</h3>
                        <img class="img-responsive cc-img" src="http://www.prepbootstrap.com/Content/images/shared/misc/creditcardicons.png">
                    </div>
                </div>
                <div class="panel-body">
                    <form:form action="/payment" modelAttribute="cardModel" method="POST" role="form">
                        <div class="row">
                            <div class="col-xs-12">
                                <div class="form-group">
                                    <label>CARD NUMBER</label>
                                    <div class="input-group">
                                    	<form:input path="cardNumber"/>
                                
                                        <span class="input-group-addon"><span class="fa fa-credit-card"></span></span>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-xs-7 col-md-7">
                                <div class="form-group">
                                    <label><span class="hidden-xs">EXPIRATION</span><span class="visible-xs-inline">EXP</span> DATE</label>
                                    
                                    <form:input path="expDate"/>
                                    
                                </div>
                            </div>
                            <div class="col-xs-5 col-md-5 pull-right">
                                <div class="form-group">
                                    <label>CV CODE</label>
                                    <form:input path="cvcCode"/>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-xs-12">
                                <div class="form-group">
                                    <label>CARD OWNER</label>
                                   <form:input path="name"/>
                                </div>
                            </div>
                        </div>
                        <div class="panel-footer">
                    <div class="row">
                        <div class="col-xs-12">
                            <button type="submit" class="btn btn-warning btn-lg btn-block">Process payment</button>
                        </div>
                    </div>
                </div>
                     </form:form>
                </div>
                
               
            </div>
        </div>
    </div>
</div>

<style>
    .cc-img {
        margin: 0 auto;
    }
</style>
<!-- Credit Card Payment Form - END -->

</div>

</body>
</html>