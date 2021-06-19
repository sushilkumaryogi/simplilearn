<%--
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>


<div style="display: flex; justify-content: center; align-items: center; margin-top: 100px;">
<h3 style="color:darkgreen"> 

 <core:if test="${!empty param.message}">		        	
		        	${requestScope['message']}
 </core:if>
 
 </h3>
<a href="login.jsp" style="color: #006dcc;"> <b> Back Page </b></a>
</div>
</body>
</html>
