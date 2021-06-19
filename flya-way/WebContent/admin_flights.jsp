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
    <a class="navbar-brand" href="#">
      ${sessionScope.username}
    </a>
  </div>
  <ul class="nav navbar-nav" >
    <li class=""><a href="/Flyaway_Booking/admin_home.jsp">Home</a></li>

    <li class="activeNav"><a href="/Flyaway_Booking/AdminFlights"> Flights</a></li>


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
    <div class="table-title table-title-admin" style="">
      <div class="row">
        <div class="col-sm-6">
          <h2><b>All Flights</b></h2>
        </div>
      </div>

    </div>

    <div class="row " style="display: flex; justify-content: flex-end; min-height: 20px;">
        <h1> </h1>
        <a href="#createModal" class="btn btn-success" data-toggle="modal" style="background: linear-gradient(to right, #2ed05a 0%, rgba(24, 126, 17, 0.85) 100%); color: #ffffff;"> <span>Add Flight</span></a>

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

          </tr>
          </thead>

          <tbody>

          <c:forEach  var="availableflight"  items="${requestScope['availableflights']}" varStatus="loop">
            <tr>
              <td><c:out value="${availableflight.id}"/></td>
              <td><c:out value="${availableflight.source}"/></td>
              <td><c:out value="${availableflight.designation}"/></td>
              <td><c:out value="${availableflight.availableSeats}"/></td>
              <td><c:out value="$ ${availableflight.price} "/></td>
                <%-- <c:set var="selectcheck" value="sessionScope.courseSelectionCounter"/> --%>
              <c:set var = "counter" value = "${sessionScope.courseSelectionCounter}" />
              <fmt:parseNumber var = "i" type = "number" value = "${counter}" />

            </tr>
          </c:forEach>

          </tbody>
        </table>

      </div>
    </div>

  </div>
</div>







<!-- Add Flight HTML -->
<div id="createModal" class="modal fade">
  <div class="modal-dialog">
    <div class="modal-content">
      <form action="/Flyaway_Booking/AdminFlights" method="post">
        <div class="modal-header">
          <h4 class="modal-title" style="background: linear-gradient(to right, #2ed05a 0%, rgba(24, 126, 17, 0.85) 100%); color: #ffffff; -webkit-background-clip: text; -webkit-text-fill-color: transparent;">Add Flight Details</h4>
          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        </div>
        <div class="modal-body">

          <div class="form-group form-floating-label">
            <label for="usernamecreate" class="placeholder">Flight Name</label>
            <input  id="usernamecreate" name="name" type="text" class="form-control input-border-bottom" required>

          </div>
          <div class="form-group form-floating-label">
            <label for="source" class="placeholder">Flight source</label>
            <input  id="source" name="source" type="text" class="form-control input-border-bottom" required>

          </div>
          <div class="form-group form-floating-label">
            <label for="designation" class="placeholder">Flight designation</label>
            <input  id="designation" name="designation" type="text" class="form-control input-border-bottom" required>

          </div>
          <div class="form-group form-floating-label">
            <label for="datetime" class="placeholder">Flight Date & Time</label>
            <input  id="datetime" name="datetime" type="text" class="form-control input-border-bottom" required>

          </div>
          <div class="form-group form-floating-label">
            <label for="seats" class="placeholder">Flight Seats</label>
            <input  id="seats" name="seats" type="text" class="form-control input-border-bottom" required>

          </div>
          <div class="form-group form-floating-label">
            <label for="priceperseat" class="placeholder">Price Per Seat $</label>
            <input  id="priceperseat" name="priceperseat" type="text" class="form-control input-border-bottom" required>

          </div>

          <div class="form-action">

          </div>

        </div>

        <div class="modal-footer">
          <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
          <input type="submit"  style="background: linear-gradient(to right, #2ed05a 0%, rgba(24, 126, 17, 0.85) 100%); color: #ffffff;" class="btn btn-rounded btn-login" value="Add Flight">
        </div>
      </form>
    </div>
  </div>
</div>





</body>
</html>

