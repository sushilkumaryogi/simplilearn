<%--
  Created by IntelliJ IDEA.
  User: Mohammad Rahman
  Date: 2/1/2021
  Time: 12:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.List"%>
<%@ page import="java.sql.*" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>




<c:if test="${sessionScope.username != null}">

</c:if>
<c:if test="${!empty sessionScope.username}">

</c:if>
<c:if test="${empty sessionScope.username}">
  <c:redirect url = "/login.jsp"/>
</c:if>


<html>
<head>
  <title>course-project</title>
  <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
  <link rel="stylesheet" href="/Flyaway_Booking/resources/css/bootstrap.min.css">
  <script src="/Flyaway_Booking/resources/js/jquery.min.js"></script>
  <script src="/Flyaway_Booking/resources/js/bootstrap.min.js"></script>
  <script src="/Flyaway_Booking/resources/js/main.js"></script>
  <link rel="stylesheet" href="/Flyaway_Booking/resources/css/main.css">
</head>
<body>

<div class="navbar navbar-inverse navbar-fixed-left navbar-fixed-left-admin">
  <div class="logo">
    <a class="navbar-brand" href="#">${sessionScope.username}</a>
    <p class="username">.</p>
    <%-- <p class="username" > <%= username %> </p> --%>
  </div>
  <ul class="nav navbar-nav" >
    <li class="activeNav"><a href="/Flyaway_Booking/admin_home.jsp">Home</a></li>

    <li class=""><a href="/Flyaway_Booking/AdminFlights"> Flights</a></li>


    <li ><a href="/Flyaway_Booking/destroysession.jsp">LOG OUT</a></li>
  </ul>
</div>
<div class="container">
  <br>

  <div class="table-wrapper">
    <div class="table-title table-title-admin">
      <div class="row">
        <div class="col-sm-6">
          <h2><b>Home</b></h2>
        </div>
      </div>
    </div>
    <div class="row ">
      <div class="col">
        <h1>
          <c:if test="${!empty sessionScope.username}">
            ${sessionScope.username} wellcome to FlyAway :)
          </c:if>
        </h1>
      </div>
    </div>
  </div>
</div>



</body>
</html>

