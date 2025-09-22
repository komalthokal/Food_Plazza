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
<form action="feedback" method="post" onsubmit="return feedback()">
<input type="hidden" id="c_email" name="c_email" value="<%=c_email%>">
 
 <table border="1">
 <caption style="color:crimson"><h1>Add Feedback</h1></caption>
 
 <tr>
 <td><label for="review">Enter review:</label></td>
 <td><input type="text" id="review" name="review" placeholder="Enter review"></td>
 <td><span id="r_error" style="color:red"></span></td>
 </tr>
 
 <tr>
 <td><label for="advice">Enter Advise:</label></td>
 <td><input type="text" id="advice" name="advice" placeholder="Enter advise"></td>
 <td><span id="a_error" style="color:red"></span></td>
 </tr>
 
 <tr>
 <td><label for="ranks">Enter rank:</label></td>
 <td><input type="number" id="ranks" name="ranks" max="5" min="1"></td>
 <td><span id="r_error" style="color:red"></span></td>
 </tr>
 </table>
 <button type="submit" name="action" value="add">Submit</button>
<button type="reset">Clear</button>
 
</form>
<%@include file="footer.jsp" %>
</body>
</html>