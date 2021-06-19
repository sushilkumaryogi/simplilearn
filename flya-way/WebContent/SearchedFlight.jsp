<%--
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

<div class="navbar navbar-inverse navbar-fixed-left">
  <div class="logo">
    <a class="navbar-brand" href="#">
      ${sessionScope.username}
    </a>
  </div>
  <ul class="nav navbar-nav" >
    <li class=""><a href="/Flyaway_Booking/home.jsp">Home</a></li>

    <li class="activeNav"><a href="/Flyaway_Booking/AvailableFlights">All Flights</a></li>


    <li ><a href="/Flyaway_Booking/destroysession.jsp">LOG OUT</a></li>
  </ul>
</div>
<div class="container">
  <br>

  <div class="form-group has-success">
    <core:if test="${not empty requestScope['message_success']}">
      ${requestScope['message_success']}
    </core:if>
  </div>

  <div class="form-group has-danger">
    <core:if test="${!empty requestScope['message_error']}">
      ${requestScope['message_error']}
    </core:if>
  </div>


  <div class="table-wrapper">
    <div class="table-title">
      <div class="row">
        <div class="col-sm-6">
          <h2><b>Searched Flights Are Listed</b></h2>
        </div>
      </div>

    </div>



    <div class="row">
      <div class="col">

        <table id="srfe" class="table table-striped table-hover">
          <thead>
          <tr>
            <th>So No</th>
            <th>Source</th>
            <th>Designation</th>
            <th>Available Seats</th>
            <th>Price Per Seat</th>
            <th>Choose</th>

          </tr>
          </thead>

          <tbody>

          <c:forEach  var="availableflight"  items="${requestScope['availableflights']}" varStatus="loop">
            <tr>
              <td><c:out value="${availableflight.id}"/></td>
              <td><c:out value="${availableflight.source}"/></td>
              <td><c:out value="${availableflight.designation}"/></td>
              <td><c:out value="${availableflight.availableSeats}"/></td>
              <td><c:out value="${availableflight.price}"/></td>
                <%-- <c:set var="selectcheck" value="sessionScope.courseSelectionCounter"/> --%>
              <c:set var = "counter" value = "${sessionScope.courseSelectionCounter}" />
              <fmt:parseNumber var = "i" type = "number" value = "${counter}" />
              <td>
                <!--<form method='post' action='/Select_Lesson'> -->
                <a href="/Flyaway_Booking/payment.jsp"><input type='submit' class='btn btn-xs btn-danger' name='submit' value='Select Flight' ></a>
                 <input type='hidden' name='lesson_id'  style='color: lightgreen;' value='${availableflight.id}'>
                <!--</form>-->
              </td>
            </tr>
          </c:forEach>

          </tbody>
        </table>

      </div>
    </div>

  </div>
</div>



</body>
</html>

