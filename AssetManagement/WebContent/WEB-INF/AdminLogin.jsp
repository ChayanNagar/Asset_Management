<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  
<link rel="stylesheet" href="<c:url value='/resources/css/style1.css'/>" />


<title>Admin Login Page</title>
</head>
<body>
<h1 align="center" class="container" > Login page</h1>
	
<center>
<form action="ALoginCheck" method="post">
  

  <div class="container">
  <div class="col-sm-5">
 \
  <div class="form-group">
    <label for="designation">Designation:</label>
    <select name="Designation" id="desig">
  <option value="select">Select</option>
 <option value="Admin">Admin</option>
 <option value="Manager">Manager</option>
  <option value="Employee">Employee</option>
  <option value="Support">Support</option>
  </select>
  </div>
  
 
    <label for="uname" class="container" style="background-color:#f1f1f1"><b>Username</b></label>
    <input type="text" placeholder="Enter Username" name="uname" required>
     <br></br>
    <label for="psw" class="container" style="background-color:#f1f1f1"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="password" required>
        
   <center> <button type="submit">Login</button></center>
    <label>
      <input type="checkbox" checked="checked" name="remember"> Remember me
    </label>
  </div>

  <div class="container" style="background-color:#f1f1f1">
    <button type="button" class="cancelbtn">Cancel</button>
    <span class="psw">Forgot <a href="#">password?</a></span>
  </div>
  </div>
</form>
</center>


</body>
</html>