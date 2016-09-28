<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%@page session="true"%>

<html>
<head>
<link href="<c:url value="/css/lol.css" />" rel="stylesheet">
<link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>


</head>

<body background=${pageContext.servletContext.contextPath}/resources/images/wallpaper3.png>
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" media="screen">  
<div class="container">
    <div class="row user-menu-container square">
        <div class="col-md-12 user-details">
            <div class="row coralbg white">
                <div class="col-md-6 no-pad">
                    <div class="user-pad">
                        <h4><a title="Log Out" href="logout">Log Out</a></h4>
                        <h3>Welcome , ${user.userName}</h3>
                    </div>
                </div>
                <div class="col-md-6 no-pad">
                    <div class="col-md-1 no-pad">
			</div>
                <div class="col-md-8 no-pad">
                    <div class="user-image">
                    <div class="col-sm-6"></div>
                        <img class="col-sm-3" src="http://loopssolutions.com/Images/admin.png" class="img-responsive thumbnail">
                    </div>
		</div>
                    <div class="col-md-1 no-pad">
			</div>
                </div>
            </div>
            <div class="row overview greyback">
            
                <div class="col-md-6 user-pad text-center">
                    <h3>Age</h3>
                    <h4>${userage}</h4>
                   
                </div>
                <div class="col-md-6 user-pad text-center">
                    <h3>Role</h3>
                    <h4>${user.role}</h4>
                </div>
            </div>
        </div>
</div>

    
    <div class="row user-menu-container square">
    <div class="card hovercard">
        <div class="card-background">
            
        </div>
        
    </div>
    <div class="btn-pref btn-group btn-group-justified btn-group-lg" role="group" aria-label="...">
        <div class="btn-group" role="group">
            <button type="button" id="stars" class="btn btn-default" href="#tab1" data-toggle="tab" onclick="finduser()"><span class="glyphicon glyphicon-star" aria-hidden="true"></span>
                <div class="hidden-xs" onclick="add(this)">Users</div>
            </button>
        </div>
        
        <div class="btn-group" role="group">
            <button type="button" id="following" class="btn btn-default" href="#tab2" data-toggle="tab" onclick="showplaylists()"><span class="glyphicon glyphicon-user" aria-hidden="true"></span>
                <div class="hidden-xs">User - PlayList</div>
            </button>
        </div>
    </div>

        <div class="well">
      <div class="tab-content">
        <div class="tab-pane fade in" id="tab1">
          <div id="results"></div>
        </div>
        <div class="tab-pane fade in" id="tab2">
          <div id="AllPlaylist">          
               <c:forEach items="${sessionScope.allusershere}" var="element">
  						<ul style="list-style-type:disc">
    					<li> ${element.userName}</li><br/>
    						<c:forEach items="${element.playlists}" var="playlistsss">
    						<ul><li>${playlistsss.playlistName}</li></ul>
    						</c:forEach>
    					</ul>
				</c:forEach>
          </div>
        </div>
      </div>
    </div>
    
    </div>
    
    <div align="center" class="col-md-6 no-pad">
    <button type="button" class="btn btn-primary btn-default" onclick="generatepdf()">Generate Pdf</button>
    </div>
    <div align="center" class="col-md-6 no-pad">
    <button type="button" class="btn btn-primary btn-default" onclick="location.href='contact.htm';">Send Mail</button>
    </div>
 
</div>
</body>

<script>

var finduser = function finduser() {
    $.ajax({
    	type: "POST",
    	dataType : "json",
    	url : "getusers.htm",
        success: function (data) {
        	$("#results").empty();
            var tostr=JSON.stringify(data);
            var end=tostr.indexOf("}}");
            var jsonStr=tostr.substring(0,end+2);
            var outerObj=$.parseJSON(jsonStr);
            $.each(outerObj, function(i, val) {
                var innerStr=JSON.stringify(val);
                var innerObj=$.parseJSON(innerStr);
                var str="<tr>";
                $.each(innerObj, function(j, value) {
                	str+="User : ";
                    str+="<td>"+value+"</td>";
                });
                str+="</tr>";
                $("#results").append(str);
            });
        }
    });
};





function requestdetails(i, personId, ok) {
    $.ajax({
    	type: "POST",
    	dataType : "json",
    	url : "getusers/approverequest.htm",
    	data : {query: i , personId : personId},
        success: function (data) {
        	if(data == 1)
        		finduser();
        	else
        		alert("Error while deleting");
        }
    });
};

// 3rd Ajax call

var showplaylists = function () {
    $.ajax({
    	type: "POST",
    	url : "getusers/getuseralbums.htm",
        success: function (data) {
        	
        }
    });
};

//call for pdf

var generatepdf = function () {
	var win = window.open('${pageContext.servletContext.contextPath}/resources/images/report.pdf', '_blank');
	if(win){
	    win.focus();
	}else{
	    alert('Please allow popups for this site');
	}
};


$( document ).ready(function() {
    
	    $.ajax({
	    	type: "POST",
	    	url : "getusers/getpdf.htm",
	        success: function (data) {
	        	
	        }
	    });
	
  });

var showplaylists = function () {
    $.ajax({
    	type: "POST",
    	url : "getusers/getuseralbums.htm",
        success: function (data) {
        	
        }
    });
};




</script>
</html>    