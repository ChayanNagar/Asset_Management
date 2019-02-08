  
  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  
   <img src="<%=request.getContextPath()%>/images/logo.png" />
     
 
 <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet"> 
                
<%-- <spring:url value="/resources/js/validation.js" var="MyJS1" />
<script src="${MyJS1}"></script>
 --%>
  <script src="<c:url value="/resources/js/validation.js" />"></script>


                <body>
                <h1>Spring MVC CSS Demo</h1>
             
             
             <a href="" onclick="call();">GO</a>
                </body>  
                
                   