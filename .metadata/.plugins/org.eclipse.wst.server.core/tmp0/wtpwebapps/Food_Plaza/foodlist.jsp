<%@ page import="com.model.Food" %>
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
<% List<Food> list=(List)session.getAttribute("f_list"); %>
<%@ include file="header.jsp" %>
<table border="1" style="margin-top:2rem">
<caption style="color:crimson"><h1>FoodList</h1></caption>

<tr>
<th>Id</th>
<th>Name</th>
<th>Type</th>
<th>Category</th>
<th>Price</th>
<th colspan="2">Action</th>
</tr>
<% for(Food f:list){ %>

<tr>
<td><%=f.getF_id() %></td>
<td><%=f.getF_name() %></td>
<td><%=f.getF_type() %></td>
<td><%=f.getF_category() %></td>
<td><%=f.getF_price() %></td>
<%if(c_email==null && a_email!=null){ %>
<td>
<a href="updatefood.jsp?f_id=<%=f.getF_id()%>" style="color:green; text-decoration:none;">update</a>
<a href="food?action=delete&f_id=<%=f.getF_id()%>" style="color:red; text-decoration:none;">delete</a>
</td>
<% } %>
<%if(c_email!=null && a_email==null){ %>
<td>
<a href="addtocart.jsp?f_id=<%=f.getF_id()%>" style="color:green; text-decoration:none;">add</a>
</td>
<% } %>
</tr>
<%} %>
</table>
<%@include file="footer.jsp" %>
</body>
</html>