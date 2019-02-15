<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <%@include file="Header_Admin.jsp" %>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<title>User Home Page</title>
<%@page import="java.util.ArrayList,bean.AssetBean" %>

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

 <div class="container">
   
 <table class="table table-bordered">
 <tr><th>Aid</th><th>Asset Name</th><th>Status</tr>
 
<% 
ArrayList<AssetBean> list=(ArrayList<AssetBean>)request.getAttribute("LIST");
 
 %>
 
 <%
   for(AssetBean ee:list)
   {   
	  %>
   	 <tr>
   	 <td> <%=ee.getAid()%> </td>
   	 
   	 <td> <%=ee.getAsset()%> </td>
 
   	<td> <%=ee.getStatus()%> </td>
   	 
	 <tr/>
	 <%
	 }
  %>
  </table></div>
 
 

</body>
</html>