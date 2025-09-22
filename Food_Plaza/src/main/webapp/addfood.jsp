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
<form action="food" method="post" onsubmit="return food()">
<table border="1" style="margin-top:2rem">
<caption style="color:crimson"><h1>Add Food</h1></caption>

        <tr>
            <td><label for="F_name">Enter food name:</label></td>
            <td><input type="text" id="F_name" name="f_name" placeholder="Enter food name"></td>
            <td><span id="n_error" style="color:red"></span></td>
        </tr>
        <tr>
            <td><label for="f_type">Enter food type:</label></td>
            <td><input type="text" id="f_type" name="f_type" placeholder="Enter food type"></td>
            <td><span id="t_error" style="color:red"></span></td>
        </tr>
        <tr>
            <td><label for="f_category">Enter food category:</label></td>
            <td><input type="text" id="f_category" name="f_category" placeholder="Enter food category"></td>
            <td><span id="c_error" style="color:red"></span></td>
        </tr>
        <tr>
            <td><label for="f_price">Enter food price:</label></td>
            <td><input type="text" id="f_price" name="f_price" placeholder="Enter food price"></td>
            <td><span id="p_error" style="color:red"></span></td>
        </tr>
        
</table>
<button type="submit" name="action" value="addf">Add</button>
<button type="reset">Clear</button>

</form>
<%@ include file="footer.jsp" %>

</body>
</html>