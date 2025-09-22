<%@page import="com.model.Orders"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="header.jsp" %>
<form class="main">
<%Orders od=(Orders)request.getAttribute("order"); %>
OrderId:<%=od.getO_id() %><br>
EmailId:<%=od.getC_email() %><br>
TotalPrice:<%=od.getT_price() %><br>
Date:<%=od.getDate() %>
</form>
<%@include file="footer.jsp" %>
</body>
</html>