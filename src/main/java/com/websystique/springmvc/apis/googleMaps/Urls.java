package com.websystique.springmvc.apis.googleMaps;

public class Urls {
    private static String key = "AIzaSyAsw03u9TXR4sgXYG4ybb-lPfnUxgy-SYs";
    private static String keyString = "&key="+key;

    private static String placesApi = "https://maps.googleapis.com/maps/api/place/";

    public static String coordinates(String query){
        return placesApi+"textsearch/json?query="+query+keyString;
    }

    public static String companiesByCoordinates(String coordinates){
        return placesApi+"nearbysearch/json?location="+coordinates+"&radius=500"+keyString;
    }

    public static String companiesByQuery(String query){
        return placesApi+"nearbysearch/json?location="+coordinates(query)+"&radius=500"+keyString;
    }

    public static String byPlaceId(String placeid){
        return placesApi+"details/json?placeid="+placeid+keyString;
    }

    public static String byPageId(String pageToken){
        return placesApi+"nearbysearch/json?pagetoken="+pageToken+keyString;
    }

}
