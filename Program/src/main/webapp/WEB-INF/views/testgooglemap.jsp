<!DOCTYPE html>
<html>
<head>
<!-- <script type="text/javascript" src="https://maps.googleapis.com/maps/api/directions/json?origin=146%20%C4%91%C6%B0%E1%BB%9Dng%20ho%C3%A0ng%20mai&destination=109%20tr%E1%BA%A7n%20h%C6%B0ng%20%C4%91%E1%BA%A1o&key=AIzaSyBaE3VU4GTpO7jXeyDBRySvk5ioqGQcXa0"></script> -->
<script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false"></script>
<!-- <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBaE3VU4GTpO7jXeyDBRySvk5ioqGQcXa0&libraries=places"></script> -->



<script src="https://apis.google.com/js/api.js" type="text/javascript"></script>

<script src="/Project/webjars/jquery/2.1.4/jquery.min.js"></script>
<script type="text/javascript">


check = function(){
	var start = $('#orig').val();
	var end = $('#dest').val()
	$.ajax({
		url: 'https://maps.googleapis.com/maps/api/distancematrix/json?origins='+start+'&destinations='+ end +'&departure_time=now&key=AIzaSyBBfOsyFLL66XcGm6vH5ZTPobC15E76Now&fbclid=IwAR2_awBKuNM_Pcbp_y-XpaSaAv8mSc2lOjqTjVDkPExZtNZWd0fpV0tTjpc',
		get: 'post',
		success: function(result) {
			console.log(result);
			console.log(result.rows[0].elements[0].distance.text);
			$('#dist').val(result.rows[0].elements[0].distance.text);
		}
	});
}




</script>
</head>
<body>
<button onclick="check()">we</button>
    <br>
    Basic example for using the Distance Matrix.<br><br>
    Origin: <input id="orig" type="text" style="width:35em"><br><br>
    Destination: <input id="dest" type="text" style="width:35em"><br><br>
    Distance: <input id="dist" type="text" style="width:35em">
    
    <p id="demo">Kích vào button để lấy vị trí.</p>

	<button onclick="getLocation()">Lấy vị trí</button>
	
	<div id="mapholder"></div>
</body>
</html> 


