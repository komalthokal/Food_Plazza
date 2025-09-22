<%@page import="com.model.Customer" %>
<%@page import="com.dao.CustomerImpl" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="header.jsp" %>
<%
CustomerImpl cd=new CustomerImpl();
Customer cs=cd.get_customerbyemail(c_email);
%>

<form action="customer" method="post" onsubmit="return customer()">
 <input type="hidden" id="c_email" name="c_email" value="<%=cs.getC_email()%>">
 
 <table border="1">
 <caption style="color:crimson"><h1>Edit Profile</h1></caption>
 <tr>
 <td><label for="C_name">Enter name:</label></td>
 <td><input type="text" id="c_name" name="C_name" placeholder="Enter name:" value="<%=cs.getC_name()%>"></td>
 <td><span id="n_error" style="color:red"></span></td>
 </tr>
 
 <tr>
 <td><label for="C_contact">Enter contact:</label></td>
 <td><input type="text" id="contact" name="C_contact" placeholder="Enter contact" value="<%=cs.getC_contact()%>"></td>
 <td><span id="c_error" style="color:red"></span></td>
 </tr>
 
 <tr>
 <td><label for="C_address">Enter address:</label></td>
 <td><input type="text" id="address" name="C_address" placeholder="Enter address" value="<%=cs.getC_address()%>"></td>
 <td><span id="a_error" style="color:red"></span></td>
 </tr>
 
 </table>
 
<button type="submit" name="action" value="update">Submit</button>
<button type="reset">Clear</button>

</form>
<%@include file="footer.jsp" %>
</body>
</html>