<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <%@include file="Header_Admin.jsp" %>
    <body >
   <% 
	  	String email=(String)session.getAttribute("email");
        if(email==null)
	   response.sendRedirect("/");
	   %>
   <center>
<h1 ><font color="red">Welcome Admin ,${email}</font></h1>
 </center>
   

	<div class="container">
	<div class="col-sm-3">
    <form action="insertAssetDetails" method="post" >
    <h2>${msg}</h2>
        <div class="form-group">
    <label for="aname">Asset Name:</label>
     <input type="text" class="form-control" name="asset" id="Asset">
   </div> 
  
  <div class="form-group">
    <label for="status">Status:</label>
    <div class="radio">
  <label><input type="radio" name="status" value="0"checked>Available</label>
</div>
<div class="radio">
  <label><input type="radio" name="status" value="1">Not Available</label>
</div>
    
  </div>
 
      <button type="submit" class="btn btn-primary">Insert</button>
</form>
</div>
</div>
	
</body>
</html>