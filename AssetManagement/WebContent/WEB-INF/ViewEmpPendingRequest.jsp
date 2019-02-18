<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <%@include file="Header_Manager.jsp" %>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<title>User Home Page</title>
<%@page import="java.util.ArrayList,bean.RequestBean,java.sql.Date" %>

</head>
<body>
<center>
<% 
	  	int eid=(Integer)session.getAttribute("eid");
        if(eid==0)
	   response.sendRedirect("/");
       	   %>

<h1 ><font color="red">Welcome Manager, ${eid}</font></h2>
</center>

 <div class="container">
   
 <table class="table table-bordered">
 <tr><th>Request Id</th><th>Asset Id</th><th>Asset Name</th><th>Employee Id</th><th>Request Date</th><th>Manager Approved Date</th><th>Status </th></tr>
 
<% 
 ArrayList<RequestBean> list=(ArrayList<RequestBean>)request.getAttribute("LIST");
 
 %>
 
 <%
   for(RequestBean ee:list)
   {   
	  %>
   	 <tr>
   	 <td> <%=ee.getRid()%> </td>
   	 
   	 <td> <%=ee.getAid()%> </td>
 
   	<td> <%=ee.getAssetname()%> </td>
   	<td> <%=ee.getEid()%> </td>
	<td> <%=ee.getRequestDate()%> </td>
	<td>
	<%if(ee.getManagerApprovedDate()==null){
	out.println("PENDING");
	}
	else{
		out.println("APPROVED");
	}
	
	%> 
	
</td>
	
	 <td>
	 	 <% if(ee.getStatus()==0){
	 out.println("PENDING");}
	 else
	 {
		 out.println("NOT PENDING");
	 }
	 %> </td>
	
	 
	 
	 </td>
	  
	 <tr/>
	 <%
	 }
  %>
  </table></div>
 
 

</body>
</html>