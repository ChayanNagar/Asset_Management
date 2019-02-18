<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <%@page import="bean.AssetBean,java.util.ArrayList" %>
 <%@include file="Header_Manager.jsp" %>
    <body >
   <% 
	  	int eid=(Integer)session.getAttribute("eid");
        if(eid==0)
	   response.sendRedirect("/");
	   %>
   <center>
   <h1>Asset Request</h1>
<h1 ><font color="red">Welcome Manager ,${eid}</font></h1>
 </center>
  <% 
 ArrayList<AssetBean> list=(ArrayList<AssetBean>)request.getAttribute("LIST");
 
 %>
 
  
	<div class="container">
	<div class="col-sm-3">
    <form action="managerAssetRequest" method="post" >
    <h2>${msg}</h2>
       
        <div class="form-group">
    <label for="Asset">Asset:</label>
    <select name="assetname" id="desig">
  <option value="Select">Select</option>
   <%
   for(AssetBean ee:list)
   {
	  %>
   
  
    <option value="<%=ee.getAid()%>#<%=ee.getAsset()%>"><%=ee.getAid()%>.<%=ee.getAsset()%></option>
    
  
  <%
	 }
  %>  
 
  </select>
  </div>
       
      <button type="submit" class="btn btn-primary">Raise Request</button>
</form>
</div>
</div>
	
</body>
</html>