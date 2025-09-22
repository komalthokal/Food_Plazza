<%@ page import="com.model.Customer" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% List<Customer> list=(List)session.getAttribute("f_list"); %>
<%@ include file="header.jsp" %>
<table border="1" style="margin-top:2rem">
<caption style="color:crimson"><h1>Customer List</h1></caption>

<tr>
<th>Name</th>
<th>Email</th>
<th>password</th>
<th>Contact</th>
<th>Address</th>
<th colspan="2">Action</th>
</tr>
<% for(Customer c:list){ %>

<tr>
<td><%=c.getC_name() %></td>
<td><%=c.getC_email() %></td>
<td><%=c.getC_pass() %></td>
<td><%=c.getC_contact() %></td>
<td><%=c.getC_address() %></td>
<%if(c_email==null && a_email!=null){ %>
<td>
<a href="customer?action=delete&c_email=<%=c.getC_email()%>" style="color:red; text-decoration:none;">delete</a>
</td>
<% } %>
</tr>
<%} %>
</table>
<%@include file="footer.jsp" %>
</body>
</html>