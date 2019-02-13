<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <%@include file="Header_Admin.jsp" %>
  <%@page import="bean.UserBean,java.util.ArrayList" %>
 
 
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
 <script type="text/javascript">
 $(document).ready(function(){
	 $("#mid").hide();
	  $("#eid").hide();
	  $("#sid").hide();
	$("#desig").change(function(){
	var v=$("#desig").val();
	  if(v=='Manager')
	     {
		  $("#mid").show();
		  $("#eid").hide();
		  $("#sid").hide();
	  	    }
	   if(v=='Employee')
	  { 
	  $("#eid").show();
	  $("#mid").hide();
	  $("#sid").hide();
	  }
	   if(v=='Support')
		  { 
		  $("#sid").show();
		  $("#mid").hide();
		  $("#eid").hide();
		  }
		
	});
		});  //ready end

</script>
 
   <body >
   <center>
   <% 
	  	String uname=(String)session.getAttribute("uname");
        if(uname==null)
	   response.sendRedirect("/");
	   %>
<h1 ><font color="red">Welcome at Admin Home,${uname}</font></h1>
 </center>
  <% 
 ArrayList<UserBean> list=(ArrayList<UserBean>)request.getAttribute("LIST");
 
 %>
 
 
   <%
   for(UserBean ee:list)
   {
	  %>

	<div class="container">
	<div class="col-sm-3">
    <form action="userStatusUpdate" method="post" >
     
     <div class="form-group">
    <label for="uid">Uid:</label>
    <input type="text" readonly  value="<%=ee.getUid()%>"  class="form-control" id="pwd" name="uid" />
  </div>
 
    <div class="form-group">
    <label for="fname">First Name:</label>
     <input type="text" class="form-control" value="<%=ee.getFname()%>" name="fname" id="Fname">
   </div> 
  
  <div class="form-group">
    <label for="lname">Last Name:</label>
    <input type="text" class="form-control" value="<%=ee.getLname()%>"name="lname" id="Lname">
  </div>
 
   <div class="form-group">
    <label for="email">Email Id:</label>
   <input type="email" class="form-control" value="<%=ee.getEmail()%>" id="emailid" name="email" />
  </div>
  
   <div class="form-group">
    <label for="pass">Password:</label>
   <input type="password" class="form-control" value="<%=ee.getPwd()%>" id="pass" name="pwd" />
  </div>
  
   <div class="form-group">
    <label for="designation">Designation:</label>
    <select name="Designation" id="desig" >
  <option value="select">Select</option>
  <option selected="selected"><%=ee.getDesignation()%></option>
  <option value="Manager">Manager</option>
  <option value="Employee">Employee</option>
  <option value="Support">Support</option>
  </select>
  </div>
  
  <div id="mid">
   <div class="form-group">
   
    <label for="manager">Manager Id:</label>
   <input type="number" class="form-control" value="<%=ee.getMmid()%>"id="Manager" name="mmid" value="0"/>
   </div>
  </div>
  
 <div id="eid">
  <div class="form-group">
  
    <label for="emp">Employee Id:</label>
   <input type="number" class="form-control" value="<%=ee.getEeid()%>" id="Emp" name="eeid" value="0" />
   </div>
  </div>
  
  <div id="sid">
  <div class="form-group">
  
    <label for="support">Support Id:</label>
   <input type="number" class="form-control" value="<%=ee.getSsid()%>" id="Support" name="ssid" value="0" />
   </div>
  </div>
  
  <div class="form-group">
    <label for="mob">Mobile No:</label>
   <input type="number" class="form-control" value="<%=ee.getMobile()%>" id="Mobile" name="mobile" />
  </div>
  
   <div class="form-group">
    <label for="date">Date Of Joining:</label>
   <input type="date" class="form-control" value="<%=ee.getDoj()%>" id="Date" name="doj" />
  </div>
  
  
  <div class="form-group">
    <label for="act">Active:</label>
   <input type="text" class="form-control" value="<%=ee.getActive()%>" id="Act" name="active" />
  </div>
   <%
	 }
  %>
  
 
     <button type="submit" class="btn btn-primary">Submit</button>
</form>
</div>
</div>
	
</body>
</html>