<%--
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<%--<c:if test="${sessionScope.username != null}">
  <c:redirect url = "/home.jsp"/>
</c:if>
<c:if test="${!empty sessionScope.username}">
  <c:redirect url = "/home.jsp"/>
</c:if>--%>


<c:if test="${ sessionScope.user_role == 100}">
  <c:redirect url = "/Flyaway_Booking/admin_home.jsp"/>
</c:if>
<c:if test="${ sessionScope.user_role == 1}">
  <c:redirect url = "/Flyaway_Booking/home.jsp"/>
</c:if>



<html>

<head>
  <title>Login</title>
  <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
  <link rel="stylesheet" href="/Flyaway_Booking/resources/css/bootstrap.min.css">
  <script src="/Flyaway_Booking/resources/js/jquery.min.js"></script>
  <script src="/Flyaway_Booking/resources/js/bootstrap.min.js"></script>
  <script src="/Flyaway_Booking/resources/js/main.js"></script>
  <link rel="stylesheet" href="/Flyaway_Booking/resources/css/main.css">
</head>
<body>

<div class="container loginbody">
  <!--<h3 class="mainprojecttitle"><a  href="/index.jsp"> Welcome To FlyAway Booking System</a></h3> -->
  <h2 style="background: linear-gradient(to right, #30CFD0 0%, #330867 100%); -webkit-background-clip: text; -webkit-text-fill-color: transparent;">Welcome To FlyAway Booking System</h2>

</div>
<div class="container loginbodyy">
  <div class="logincontent">
    <div class="table-wrapper login-wrapper">
      <form action="/Flyaway_Booking/Login" method="post" >
        <div class="table-title">
          <div class="row">
            <div class="col-sm-6">
              <h2><b>Login</b></h2>
            </div>
          </div>
        </div>
        <div class="modal-body">
          <div class="form-group">
            <label>Username</label>
            <input id="username" name="username" type="text" class="form-control" >
          </div>
          <div class="form-group">
            <label>Password</label>
            <input id="password" name="password" type="text" class="form-control" >

            <input type="hidden" name="requestfrom" value="login" />
          </div>
        </div>



        <div class="form-group has-success">
          <core:if test="${!empty param.message}">
            ${requestScope['message']}
          </core:if>
        </div>

    <div class="modal-footer">
      <a href="#createModal" class="btn btn-success" data-toggle="modal" style="background: linear-gradient(to right, #30CFD0 0%, rgba(34, 63, 255, 0.85) 100%); color: #ffffff;"> <span>Registration here!</span></a>
      <input type="submit" name="submit" class="btn btn-info" value="Log in">
    </div>
    </form>
  </div>
</div>
</div>
<div id="snackbar"></div>




<!-- Registration HTML -->
<div id="createModal" class="modal fade">
  <div class="modal-dialog">
    <div class="modal-content">
      <form action="/Flyaway_Booking/RegisterClient" method="post">
        <div class="modal-header">
          <h4 class="modal-title" style="background: linear-gradient(to right, #30CFD0 0%, #330867 100%); -webkit-background-clip: text; -webkit-text-fill-color: transparent;">FlyAway Registration</h4>
          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        </div>
        <div class="modal-body">

          <div class="form-group form-floating-label">
            <input  id="usernamecreate" name="usernamecreate" type="text" class="form-control input-border-bottom" required>
            <label for="usernamecreate" class="placeholder">Username</label>
          </div>
          <div class="form-group form-floating-label">
            <input  id="passwordcreate" name="passwordcreate" type="text" class="form-control input-border-bottom" required>
            <label for="passwordcreate" class="placeholder">Password</label>

            <input type="hidden" name="requestfrom" value="adduser" />
            <div class="show-password">
              <i class="icon-eye"></i>
            </div>
          </div>

          <div class="form-action">

          </div>

        </div>

        <div class="modal-footer">
          <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
          <input type="submit"  style="background: linear-gradient(to right, #30CFD0 0%, rgba(34, 63, 255, 0.85) 100%); color: #ffffff;" class="btn btn-rounded btn-login" value="Add New User">
        </div>
      </form>
    </div>
  </div>
</div>



</body>

</html>

