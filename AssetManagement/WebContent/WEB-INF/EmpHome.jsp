<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <%@include file="Header_Employee.jsp" %>

<center>
 <% 
	  	int eid=(Integer)session.getAttribute("eid");
        if(eid==0)
	   response.sendRedirect("/");
	   %>
	   <h1 ><font color="red">Welcome At Employee Home,<%=eid %></font></h1>
	   

</center>
</body>
</html>