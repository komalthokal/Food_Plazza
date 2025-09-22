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
<form action="login" method="post" onsubmit="return login()">
<table border="1" style="margin-top:2rem">
<caption style="color:crimson"><h1>Log In</h1></caption>

<tr><td><label for="type">Select type:</label></td>
<td>
<select id="type" name="type">
<option>Select</option>
<option value="user">User</option>
<option value="admin">Admin</option>
</select>
</td>
<td><span id="s_error" style="color:red"></span></td></tr>

<tr>
<td><label for="email">Enter Email Id:</label></td>
<td><input type="email" id="email" name="email" placeholder="Enter emailid"></td>
<td><span id="e_error" style="color:red"></span></td>
</tr>

<tr>
<td><label for="pass">Enter password:</label></td>
<td><input type="password" id="pass" name="pass" placeholder="Enter password"></td>
<td><span id="p_error" style="color:red"></span></td>
</tr>
</table>
<button type="submit" name="action" value="login">Log In</button>
<button type="reset">Clear</button>

</form>
<%@ include file="footer.jsp" %>
</body>
</html>