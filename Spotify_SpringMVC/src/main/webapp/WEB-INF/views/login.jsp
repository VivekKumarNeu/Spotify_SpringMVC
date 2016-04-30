<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page session="true" %>

<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Login</title>
     <link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/resources/css/login.css"  /> 
    <link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
  
	<c:if test="${sessionScope.loginUser == 'Invaliduser'}">
	<script>	
		alert("Wrong login credentials. Please try again.");
	</script>
	</c:if>
	
	<c:if test="${isuserthere == 'yes'}">
	<script>	
		alert("UserName Exists. Please use another username.");
	</script>
	</c:if>
	
  </head>
   <!--  <div class="container"> --> 
   <img src =${pageContext.servletContext.contextPath}/resources/images/spotifywall.jpg />
    <p></p><p><br/></p>
    	<div class="row">
        <!-- Row 1 -->
        <div class="col-md-8">
          <center><h1><font color="black"><b>Spotify: Music Library</b></font></h1></center>
        </div>
  			 <div class="col-md-4">
  				<div class="panel panel-default">
  					<div class="panel-body">
    						<div class="page-header">
  							<h3>Spotify Area</h3>

						</div>
  							<form:form action="verifyuser" commandName="user"  method="post">
                <div class="form-group">
    								<label>Email or Username</label>
    								<div class="input-group">
  									<span class="input-group-addon"> <span class="glyphicon glyphicon-user"></span></span>
  									<form:input Id="loguser" value="" type="text" class="form-control" path="userName" placeholder="Enter Username" required="required"/><font color="red"><form:errors path="userName"/></font>
								</div>
  							</div>
  							<div class="form-group">
    								<label>Password</label>
    								<div class="input-group">
  									<span class="input-group-addon"><span class="glyphicon glyphicon-star"></span></span>
  									<form:input type="password" value="" Id="logpass" class="form-control" path="password" placeholder="Enter Password" required="required"/><font color="red"><form:errors path="password"/></font>
								</div>
  							</div>
  							<hr/>
  							<button type="submit" class="btn btn-primary btn-space"><span class="glyphicon glyphicon-lock"></span> Login</button>
                </form:form>
                <button type="button" class="btn btn-info" data-toggle="modal" data-target="#myModal">New User ?</button>
				
                <!--  -->

               <!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog modal-sm">
     <form:form action="adduser" commandName="user" method="post">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Create New User</h4>
        </div>
        <div class="modal-dialog modal-sm">
                <div class="form-group">
                    <label>First Name</label>
                    <div class="input-group">
                    <span class="input-group-addon"> <span class="glyphicon glyphicon-user"></span></span>
                    <form:input class="form-control" path="firstName" placeholder="Type firstname" style="width:90%"/><font color="red"><form:errors path="firstName"/></font> 
                </div>
                </div>
                <div class="form-group">
                    <label>Last Name</label>
                    <div class="input-group">
                    <span class="input-group-addon"> <span class="glyphicon glyphicon-user"></span></span>
                    <form:input class="form-control" path="lastName" size="30" placeholder="Type lastname" style="width:90%" />  <font color="red"><form:errors path="lastName"/></font>
                </div>
                </div>
                <div class="form-group">
                    <label>Age</label>
                    <div class="input-group">
                    <span class="input-group-addon"> <span class="glyphicon glyphicon-user"></span></span>
                    <form:input class="form-control" path="age" size="2" placeholder="Type age" style="width:90%"/> <font color="red"><form:errors path="age"/></font>
                </div>
                </div>
                <div class="form-group">
                    <label>UserName</label>
                    <div class="input-group">
                    <span class="input-group-addon"> <span class="glyphicon glyphicon-user"></span></span>
                    <form:input class="form-control" path="userName" placeholder="Type username" style="width:90%"/><font color="red"><form:errors path="userName"/></font>
                </div>
                </div>
                <div class="form-group">
                    <label>Password</label>
                    <div class="input-group">
                    <span class="input-group-addon"> <span class="glyphicon glyphicon-user"></span></span>
                    <form:password class="form-control" path="password" placeholder="password" style="width:90%"/> <font color="red"><form:errors path="password"/></font>
                </div>
                </div>
                <div class="form-group">
                    <label>Email</label>
                    <div class="input-group">
                    <span class="input-group-addon"> <span class="glyphicon glyphicon-user"></span></span>
                    <form:input class="form-control" path="email" placeholder="Type Email-ID" style="width:90%"/> <font color="red"><form:errors path="email"/></font>
                </div>
                </div>
                <div class="form-group">
                    <label>Role</label>
                    <div class="input-group">
                    <span class="input-group-addon"> <span class="glyphicon glyphicon-user"></span></span>
                    <form:radiobutton path="role" value="Admin"/>Admin  <form:radiobutton path="role" value="Normal"/>user 
                </div>
                </div>
                
                
          </div>
         <div class="modal-footer">
           <button type="submit" class="btn btn-primary" value ="newuser" >Create account</button>
          <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
	    </div>
      </div>
      	</form:form>
    </div>
  </div>
<br/>
<p><br/></p>

</div>
</div>
</div>
<p></p><p><br/></p>

</div>
<!-- Row div end -->



    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
  </body>
</html>
