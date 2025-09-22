<%@page import="com.model.Feedback" %>
<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% List<Feedback> list=(List)session.getAttribute("fb_list"); %>
<%@include file="header.jsp" %>
<table border="1" style="margin-top:2rem">
<caption style="color:crimson"><b>FeedbackList</b></caption>
<tr>
<td>EmailId</td>
<td>Review</td>
<td>Advice</td>
<td>Ranks</td>
<td>Action</td>
</tr>

<%for(Feedback f:list){ %>

<tr>
<td><%=f.getC_email() %></td>
<td><%=f.getReview() %></td>
<td><%=f.getAdvice() %></td>
<td><%=f.getRanks() %></td>
<td> 
<a href="feedback?action=delete&c_email=<%=f.getC_email()%>" style="color:red; text-decoration:none;">Delete</a>
</td>
</tr>
<% } %>
</table>
<%@include file="footer.jsp" %>
</body>
</html>