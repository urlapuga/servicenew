<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=Cp1251" pageEncoding="Cp1251" %>
<meta http-equiv="content-type" content="text/html; charset=cp1251">
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no">
    <meta charset="utf-8">
    <title>Simple markers</title>
    <style>
        #map {
            height: 100%;
        }

        html, body {
            height: 100%;
            margin: 0;
            padding: 0;
        }
    </style>
</head>
<body>
<div id="map"></div>
<script>
    function initMap() {
        var myLatLng = {lat: 50.491, lng: 30.494};
        var map = new google.maps.Map(document.getElementById('map'), {
            zoom: 12,
            center: myLatLng
        });


        <c:forEach items="${devicelist}" var="device">

        var contentString = '<div>${device.ipaddress}</div>';

        var infowindow${device.id} = new google.maps.InfoWindow({
            content: contentString
        });

        var marker${device.id} = new google.maps.Marker({
            position: {lat: ${device.lat}, lng: ${device.lng}},
            map: map,
            title: 'Hello World!'
        });
        marker${device.id}.addListener('click', function () {
            infowindow${device.id}.open(map, marker${device.id});
        });


        </c:forEach>



        <c:forEach items="${opticlines}" var="line">

        var flightPlanCoordinates = [
            {lat: ${line.devicesByDevicefrom.lat}, lng: ${line.devicesByDevicefrom.lng}},
            {lat: ${line.devicesByDeviceto.lat},lng:  ${line.devicesByDeviceto.lng}}
        ];
        var flightPath = new google.maps.Polyline({
            path: flightPlanCoordinates,
            geodesic: true,
            strokeColor: '#FF0000',
            strokeOpacity: 1.0,
            strokeWeight: 2
        });
        flightPath.setMap(map);

        </c:forEach>


    }
</script>
<script async defer
        src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCSEBW9aXHWYpsAQjDbxRKmeVvwyBDbU5A&callback=initMap">
</script>
</body>
</html>