<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Page</title>
</head>
<body>
<%@ include file="header.jsp" %>

<form action="customer" method="post" onsubmit="return customer()">
    <table border="1" style="margin-top:2rem">
        <caption style="color:crimson"><h1>Registration</h1></caption>

        <tr>
            <td><label for="C_name">Enter name:</label></td>
            <td><input type="text" id="C_name" name="C_name" placeholder="Enter name:"></td>
            <td><span id="n_error" style="color:red"></span></td>
        </tr>

        <tr>
            <td><label for="C_email">Enter email:</label></td>
            <td><input type="email" id="C_email" name="C_email" placeholder="Enter email:"></td>
            <td><span id="e_error" style="color:red"></span></td>
        </tr>

        <tr>
            <td><label for="C_pass">Enter password:</label></td>
            <td><input type="password" id="C_pass" name="C_pass" placeholder="Enter password:"></td>
            <td><span id="p_error" style="color:red"></span></td>
        </tr>

        <tr>
            <td><label for="C_address">Enter Address:</label></td>
            <td><input type="text" id="C_address" name="C_address" placeholder="Enter Address:"></td>
            <td><span id="a_error" style="color:red"></span></td>
        </tr>

        <tr>
            <td><label for="C_contact">Enter contact no.:</label></td>
            <td><input type="tel" id="C_contact" name="C_contact" placeholder="Enter contact:"></td>
            <td><span id="c_error" style="color:red"></span></td>
        </tr>

        <tr>
            <td colspan="3" style="text-align:center;">
                <button type="submit" name="action" value="add">Submit</button>
                <button type="reset">Clear</button>
            </td>
        </tr>
    </table>
</form>

<%@ include file="footer.jsp" %>
</body>
</html>
