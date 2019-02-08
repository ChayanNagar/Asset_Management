<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  

<link href="<c:url value="/resources/css/style1.css" />" rel="stylesheet"> 
<title>Insert title here</title>
</head>
<body>
<h1 align="center" class="container" style="background-color:#f1f1f1" > Admin Login page</h1>
	
<center>
<form action="ALoginCheck" method="post">
  

  <div class="container">
  <div class="col-sm-5">
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