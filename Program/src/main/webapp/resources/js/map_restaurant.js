function myMap() {
  geocoder = new google.maps.Geocoder();
  var address =$('.address_restaurant').text();
  console.log(address);
  var latlng = new google.maps.LatLng(-34.397, 150.644);
var mapProp= {
  center:latlng,
  zoom:18,
};
var map = new google.maps.Map(document.getElementById("googleMap"),mapProp);
if (geocoder) {
      geocoder.geocode( { 'address': address}, function(results, status) {
        if (status == google.maps.GeocoderStatus.OK) {
          if (status != google.maps.GeocoderStatus.ZERO_RESULTS) {
          map.setCenter(results[0].geometry.location);

            console.log(results);
            var infowindow = new google.maps.InfoWindow(
                    { content: '<b>'+address+'</b>',
                      size: new google.maps.Size(150,50)
                    });

                var marker = new google.maps.Marker({
                    position: results[0].geometry.location,
                    map: map, 
                    title:address
                }); 
                google.maps.event.addListener(marker, 'click', function() {
                    infowindow.open(map,marker);
                });
          } else {
            alert("No results found");
          }
        } else {
          alert("Geocode was not successful for the following reason: " + status);
        }
      });
    }
}