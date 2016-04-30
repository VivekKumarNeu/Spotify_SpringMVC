<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page session="true"%>

<!DOCTYPE html>
<html>
<head>
<link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" media="screen">
<script src="http://cdnjs.cloudflare.com/ajax/libs/handlebars.js/2.0.0-alpha.1/handlebars.min.js"></script>
<style>
body {
    padding: 20px;
	
}

#search-form, .form-control {
    margin-bottom: 20px;
}

.cover {
    width: 400px;
    height: 400px;
    display: inline-block;
    background-size: cover;
    margin-left: 10%;
    margin-bottom: 5%;
}

.cover:hover {
    cursor: pointer;
}


</style>
</head>
<body background=${pageContext.servletContext.contextPath}/resources/images/background1.jpg >

<h4> Welcome ${user.userName},</h4>
<c:if test="${sessionScope.statofuser == 'No'}">
 	<h4>Account Type : Free(Limited)</h4>
</c:if>
<c:if test="${sessionScope.statofuser == 'ok'}">
 	<h4>Account Type : Premium</h4>
</c:if>
<c:if test="${sessionScope.statofuser == 'No'}">
<button name="sendrequest" id="sendrequest" onclick="sendrequest()">Upgrade</button>
</c:if>

 <a title="Log Out" href="logout">Log Out</a>

<div class="container">


    <h1 class="col-md-6">Please insert an Artist name</h1>
    <input type="text" id="playlistquery" placeholder="PlayList name" value="" class="form-control col-md-9" required="required" onkeypress="return numbersonly(event)" />
    
    <form id="search-form" class="col-md-9">
      <input type="hidden" id="hiddenName" value=${user.userName} />
        <input type="text" id="query" placeholder="Artist name" value="" class="form-control" required="required" />
        <input type="submit" id="search" class="btn btn-primary" value="Search" required="required" />
    </form>
    <input type="hidden" id="pagedata" value="songperpage" />
    <div id="results"></div>
    <br/>
</div>
    <h3>Your PlayList:</h3>
	<ul style="list-style-type:disc">
	            <c:forEach items="${sessionScope.localplaylistval}" var="element">
  							<li>${element.playlistName}</li>
    			</c:forEach>
	</ul>
	
	<h3>Songs List:</h3>
	<div id="songslist">
	
	</div>
	<button name='showmore' onclick="showmore()">Show More</button>
	<input type="hidden" id="hiddencount" value=${sessionScope.countofsongs} />
	
</body>
<script id="results-template" type="text/x-handlebars-template">
    {{#each albums.items}}   
		<div class="col-md-4 cover" data-album-id="{{id}}" img style="background-image:url({{images.0.url}})"><b style="color:'#98AFC7';">{{name}}</b> 
			<button name="save" value="{{id}}" class="btn btn-info" style="float: right;" onclick="add(value,this)">Add to PlayList</button>
	    </div>
	{{/each}}
</script>


<script>
var templateSource = document.getElementById('results-template').innerHTML,
    template = Handlebars.compile(templateSource),
    resultsPlaceholder = document.getElementById('results');
	playingCssClass = 'playing',
	audioObject = null;

	var fetchTracks = function (albumId, callback) {
	$.ajax({
    	url: 'https://api.spotify.com/v1/albums/' + albumId,
    	success: function (response) {
        	callback(response);
    	}
	});
	};

var searchAlbums = function (query) {
    $.ajax({
        url: 'https://api.spotify.com/v1/search',
        data: {
            q: query,
            type: 'album'
        },
        success: function (response) {
            resultsPlaceholder.innerHTML = template(response);
        }
    });
};

// playing it js

results.addEventListener('click', function(e) {
    var target = e.target;
    if (target !== null && target.classList.contains('cover')) {
        if (target.classList.contains(playingCssClass)) {
            audioObject.pause();
        } else {
            if (audioObject) {
                audioObject.pause();
            }
            fetchTracks(target.getAttribute('data-album-id'), function(data) {            
                audioObject = new Audio(data.tracks.items[0].preview_url);
                audioObject.play();
                target.classList.add(playingCssClass);
                audioObject.addEventListener('ended', function() {
                    target.classList.remove(playingCssClass);
                });
                audioObject.addEventListener('pause', function() {
                    target.classList.remove(playingCssClass);
               });
            });
        }
    }
});




document.getElementById('search-form').addEventListener('submit', function (e) {
    e.preventDefault();
    searchAlbums(document.getElementById('query').value);
}, false);

</script>

<script type="text/javascript">
    function add(i) {
    	$.ajax({
        	type: "POST",
        	dataType : "json",
        	url : "songtodb.htm",
        	data : {query: i , playlistname : document.getElementById('playlistquery').value , hiddenName : document.getElementById('hiddenName').value, pagedata : document.getElementById('pagedata').value },
        	success: function (response) {
        		alert("Songs added successfully!");
        		$("#songslist").empty();
        		showmore();
        	//	$('button').on('click',function() {
        	//	    $(this).prop("disabled",true);
        	//		});
        			
              }
        });
    }


// ajax call for getting albums

function findalbum() {
    $.ajax({
    	type: "POST",
    	url : "usercontoller.htm",
        success: function (data) {
        	$('#showalbumstable').reload();
        }
    });
};

// ajax call for getting all the songs for user







// ajax call for deleting the song

function deletethis(i) {
    $.ajax({
    	type: "POST",
    	url : "usercontoller/deleteasong.htm",
    	data : {trackid : i},
        success: function (data) {
        //$("#songslist").empty();
        	refresh();
        	//showmore();
        }
    });
};

// ajax refresh function


function refresh() {
$.ajax({
            url:'usercontoller/allsongs.htm',
            type:'POST',
            data : {newlistsize : $("#listtt li").size()},
            success:function(data){
				var len = data.length;
				$("#songslist").empty();
				$("#songslist").append("<ul id='listtt'>");
		        for (var i=0; i<len; ++i) {
		        	$("#songslist").append("<li><b>"+data[i].trackName+"</b> : "+ data[i].trackDuration+"</li> <button name='delete' value="+data[i].trackID+" class='btn btn-info' style='float: right;' onclick='deletethis(value,this)'>Delete this Song</button>");
		        	$("#songslist").append("<br/>");
		        }
		        $("#songslist").append("</ul>");
			 },
			 error:function(junk){
			 }
        });
};


//  Request for upgrade

function sendrequest() {
    $.ajax({
    	type: "POST",
    	url : "usercontoller/requestupdate.htm",
        success: function (data) {
        //	$('sendrequest').on('click',function() {
    	//	    $(this).prop("disabled",true);
    	//		});
        }
    });
};

function showmore() {
	var xx = $("#songslist li").size();
    $.ajax({
    	type: "POST",
    	url : "usercontoller/showmoresongs.htm",
    	data : { hiddensong : document.getElementById('hiddencount').value , newlistsize : xx },
        success: function (data) {
        	var len = data.length;
        	$("#songslist").empty();
        	$("#songslist").append("<ul id='listtt'>");
	        for (var i=0; i<len; ++i) {
	        	$("#songslist").append("<li><b>"+data[i].trackName+"</b> : "+ data[i].trackDuration+"</li> <button name='delete' value="+data[i].trackID+" class='btn btn-info' style='float: right;' onclick='deletethis(value,this)'>Delete this Song</button>");
	        	$("#songslist").append("<br/>");
	        }
	        $("#songslist").append("</ul>");
        }
    });
};

</script>

<script>
function numbersonly(e){
    var unicode=e.charCode? e.charCode : e.keyCode
    if (unicode!=8){ 
        if (unicode<65|unicode>122) 
            return false 
    }
}

</script>


</html>