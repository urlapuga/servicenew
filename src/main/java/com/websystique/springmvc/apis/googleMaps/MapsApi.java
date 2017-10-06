package com.websystique.springmvc.apis.googleMaps;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MapsApi {

    public static List<GoogleCompany> getCompaniesData(List<String> idList) {
        List<GoogleCompany> companyList = new ArrayList<>();
        for (String cId : idList) {
            companyList.add(getByPlaceId(cId));
        }
        return companyList;
    }

    public static String getCoordinates(String request) {
        return Translator.coordinates(RequestSender.sendGet(Urls.coordinates(request)));
    }

    public static List<String> companyList(String coordinates) {
        List<String> companyIds = new ArrayList<>();
        String request = Urls.companiesByCoordinates(coordinates);
        String response = RequestSender.sendGet(request);
        JSONObject object = new JSONObject(response);
        String responseStatus = object.getString("status");
        System.out.println(responseStatus);
        String nextPageToken = " ";
        try {
            nextPageToken = object.getString("next_page_token");
        } catch (Exception e) {
            nextPageToken = "";
        }
        companyIds = Translator.companyList(RequestSender.sendGet(request));

        while (nextPageToken.length() > 0) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            response = MapsApi.getNextPage(nextPageToken);
            object = new JSONObject(response);
            try {
                nextPageToken = object.getString("next_page_token");
            } catch (Exception e) {
                nextPageToken = "";
            }
            companyIds.addAll(Translator.companyList(response));
        }
        return companyIds;
    }

    public static GoogleCompany getByPlaceId(String placeid) {
        String request = Urls.byPlaceId(placeid);
        return Translator.getCompany(RequestSender.sendGet(request));
    }

    public static String getNextPage(String pageId) {
        String request = Urls.byPageId(pageId);
        return RequestSender.sendGet(request);
    }

    public static List<GoogleCompany> getCompaniesByRequestString(String request) {
        System.out.println(request);
        String coordinates = MapsApi.getCoordinates(request);
        if(coordinates=="0")return new ArrayList<>();

        List<String> companyIds = MapsApi.companyList(coordinates);
        return MapsApi.getCompaniesData(companyIds);
    }
}
