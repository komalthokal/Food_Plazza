<%@page import="com.model.Food" %>
<%@page import="com.dao.FoodImpl" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
FoodImpl fd=new FoodImpl();
int f_id=Integer.parseInt(request.getParameter("f_id"));
Food f=fd.get_food_byid(f_id);
%>
<%@ include file="header.jsp" %>
<form action="food" method="post" onsubmit="return food()">
 <input type="hidden" id="f_id" name="f_id" value="<%=f.getF_id()%>">
 
 <table border="1">
 <caption style="color:crimson"><h1>Update Food</h1></caption>
 <tr>
 <td><label for="f_name">Enter name:</label></td>
 <td><input type="text" id="f_name" name="f_name" placeholder="Enter name:" value="<%=f.getF_name()%>"></td>
 <td><span id="n_error" style="color:red"></span></td>
 </tr>
 
 <tr>
 <td><label for="f_type">Enter type:</label></td>
 <td><input type="text" id="f_type" name="f_type" placeholder="Enter type" value="<%=f.getF_type()%>"></td>
 <td><span id="t_error" style="color:red"></span></td>
 </tr>
 
 <tr>
 <td><label for="f_category">Enter category:</label></td>
 <td><input type="text" id="f_category" name="f_category" placeholder="Enter category" value="<%=f.getF_category()%>"></td>
 <td><span id="n_error" style="color:red"></span></td>
 </tr>
 
 <tr>
 <td><label for="f_price">Enter Price:</label></td>
 <td><input type="text" id="f_price" name="f_price" placeholder="Enter price" value="<%=f.getF_price()%>"></td>
 <td><span id="p_error" style="color:red"></span></td>
 </tr>
 </table>
 
<button type="submit" name="action" value="update">Submit</button>
<button type="reset">Clear</button>

</form>
<%@include file="footer.jsp" %>
</body>
</html>