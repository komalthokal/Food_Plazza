<%@page import="com.model.Food" %>
<%@page import="com.dao.FoodImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript">
function total(){
	let f_price=document.getElementById("f_price").value;
	let f_quan=document.getElementById("f_quan").value;
	document.getElementById("t_price").value=f_price*f_quan;
}
</script>
<title>Insert title here</title>
</head>
<body>
<%
FoodImpl fd=new FoodImpl();
int f_id=Integer.parseInt(request.getParameter("f_id"));
Food f=fd.get_food_byid(f_id);
%>
<%@ include file="header.jsp" %>
<form action="cart" method="post" onsubmit="return cart()">
<input type="hidden" id="f_id" name="f_id" value="<%=f.getF_id()%>">
<input type="hidden" id="c_email" name="c_email" value="<%=c_email%>">
<table border="1">
<caption style="color:crimson"><h1>AddToCart</h1></caption>

<tr>
<td><label for="f_name">Name:</label></td>
<td><input type="text" id="f_name" name="f_name" placeholder="Enter Name" value="<%=f.getF_name() %>"></td>
<td><span id="n_error" style="color:red"></span></td>
</tr>

<tr>
<td><label for="f_price">Price:</label></td>
<td><input type="text" id="f_price" name="f_price" placeholder="Enter Price" value="<%=f.getF_price() %>"></td>
<td><span id="p_error" style="color:red"></span></td>
</tr>

<tr>
<td><label for="f_quantity">Enter Quantity:</label></td>
<td><input type="number" id="f_quan" name="f_quan" placeholder="Enter quantity"></td>
<td><span id="q_error" style="color:red"></span></td>
</tr>

<tr>
<td><label for="t_price">Total Price:</label></td>
<td><input type="text" id="t_price" name="t_price" placeholder="Enter price" onclick="total()"></td>
<td><span id="p_error" style="color:red"></span></td>
</tr>

</table>
<button type="submit" name="action" value="add">Submit</button>
<button type="reset">Clear</button>

</form>
<%@include file="footer.jsp" %>

</body>
</html>