<%--
  Created by IntelliJ IDEA.
  User: Mohammad Rahman
  Date: 1/31/2021
  Time: 11:55 PM
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

  <div class="form-group">
    <core:if test="${!empty requestScope['message_error']}">
      ${requestScope['message_error']}
    </core:if>
  </div>


  <div class="table-wrapper">
    <div class="table-title">
      <div class="row">
        <div class="col-sm-6">
          <h2><b>Ticket Confirmed</b></h2>
        </div>
      </div>

    </div>

    <div class="row " style="display: flex; flex-direction: column; justify-content: center;" >
      <!--<form action="#">-->
        <div class="row">
          <div class="col-md-12">
            <div class="form-group">
              <label for="firstname">Name</label>
              <input type="text" readonly class="form-control" value="${sessionScope.pay_firstname} ${sessionScope.pay_lastname}" name="firstname" id="firstname" placeholder="">
            </div>
          </div>
        </div>
        <div class="row">
          <div class="col-md-12 ">
            <div class="form-group">
              <label for="lastname">Date & Time</label>
              <input type="text" readonly class="form-control" value="${sessionScope.pay_datetime}" name="lastname" id="lastname" placeholder="">
            </div>
          </div>
        </div>
        <div class="row ">
          <div class="col-md-12 ">
            <div class="form-group">
              <label for="address">Flight Name</label>
              <input type="text" readonly class="form-control" value="${sessionScope.pay_ticket}" name="address" id="address" placeholder="">
            </div>
          </div>
        </div>
        <div class="row">
          <div class="col-md-12">
            <%--<button type="submit" name="apply_filter" class="btn btn-primary ">Search Flight</button>--%>
            <div class="form-group">
              <label for="noofpersons">Booking Confirmed</label>
              <input type="button"  disabled class="form-control btn btn-success" name="noofpersons" id="noofpersons" value="Booking Confirmed">
            </div>
          </div>
        </div>
      <!--</form>-->
    </div>


  </div>
</div>



</body>
</html>

