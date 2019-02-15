<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <%@include file="Header_Admin.jsp" %>
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
		  $("#sid").show();
	  	    }
	   if(v=='Employee')
	  { 
	  $("#eid").show();
	  $("#mid").show();
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
   <% 
	  	int eid=(Integer)session.getAttribute("eid");
        if(eid==0)
	   response.sendRedirect("/");
	   %>
   <center>
<h1 ><font color="red">Welcome Admin ,${eid}</font></h1>
 </center>
   

	<div class="container">
	<div class="col-sm-3">
    <form action="insertUserDetails" method="post" >
     <h2>${msg}</h2>
    <div class="form-group">
    <label for="fname">First Name:</label>
     <input type="text" class="form-control" name="fname" id="Fname">
   </div> 
  
  <div class="form-group">
    <label for="lname">Last Name:</label>
    <input type="text" class="form-control" name="lname" id="Lname">
  </div>
 
   <div class="form-group">
    <label for="email">Email Id:</label>
   <input type="email" class="form-control" id="emailid" name="email" />
  </div>
  
   <div class="form-group">
    <label for="pass">Password:</label>
   <input type="password" class="form-control" id="pass" name="pwd" />
  </div>
  
   <div class="form-group">
    <label for="designation">Designation:</label>
    <select name="Designation" id="desig">
  <option value="select">Select</option>
  <option value="Manager">Manager</option>
  <option value="Employee">Employee</option>
  <option value="Support">Support</option>
  </select>
  </div>
  
  <div id="mid">
   <div class="form-group">
   
    <label for="manager">Manager Id:</label>
   <input type="number" class="form-control" id="Manager" name="mmid" value="0"/>
   </div>
  </div>
  
 <div id="eid">
  <div class="form-group">
  
    <label for="emp">Employee Id:</label>
   <input type="number" class="form-control" id="Emp" name="eeid" value="0" />
   </div>
  </div>
  
  <div id="sid">
  <div class="form-group">
  
    <label for="support">Support Id:</label>
   <input type="number" class="form-control" id="Support" name="ssid" value="0" />
   </div>
  </div>
  
  <div class="form-group">
    <label for="mob">Mobile No:</label>
   <input type="number" class="form-control" id="Mobile" name="mobile" />
  </div>
  
   <div class="form-group">
    <label for="date">Date Of Joining:</label>
   <input type="date" class="form-control" id="Date" name="doj" />
  </div>
  
  
  <div class="form-group">
    <label for="act">Active:</label>
   <input type="text" class="form-control" id="Act" name="active" />
  </div>
  
 
     <button type="submit" class="btn btn-primary">Submit</button>
</form>
</div>
</div>
	
</body>
</html>