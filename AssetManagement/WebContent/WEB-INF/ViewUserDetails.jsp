<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <%@include file="Header_Admin.jsp" %>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<title>User Home Page</title>
<%@page import="java.util.ArrayList,bean.UserBean,java.sql.Date" %>

</head>
<body>
<center>
<% 
	  	int eid=(Integer)session.getAttribute("eid");
        if(eid==0)
	   response.sendRedirect("/");
       	   %>

<h1 ><font color="red">Welcome Admin, ${eid}</font></h2>
</center>
<h2>${msg1}</h2>
 <div class="container">
   
 <table class="table table-bordered">
 <tr><th>Uid</th><th>First Name</th><th>Last Name</th><th>EmailId</th><th>Password</th><th>Designation</th><th>EmpId</th><th>ManagerId</th><th>SupportId</th><th>DOJ</th><th>Mobile No</th><th>Status</th></tr>
 
<% 
 ArrayList<UserBean> list=(ArrayList<UserBean>)request.getAttribute("LIST");
 
 %>
 
 <%
   for(UserBean ee:list)
   {   
	  %>
   	 <tr>
   	 <td> <%=ee.getUid()%> </td>
 
   	<td> <%=ee.getFname()%> </td>
   	<td> <%=ee.getLname()%> </td>
	<td> <%=ee.getEmail()%> </td>
	 <td><%=ee.getPwd()%> </td>
	 <td><%=ee.getDesignation()%> </td>
	 <td><%=ee.getEeid()%></td>
	  <td><%=ee.getMmid()%></td>
 	   <td><%=ee.getSsid()%></td>
 	    <td><%=ee.getDoj()%></td>
 	    <td><%=ee.getMobile()%></td>
 	    <td><%=ee.getActive()%></td>
 	    <td> <a href="UserStatus?userid=<%=ee.getUid()%>" class="glyphicon glyphicon-edit"  onClick="return confirm('Do you really want to Update this record?')"></a> </td>
	    
	 <tr/>
	 <%
	 }
  %>
  </table></div>
 
 

</body>
</html>