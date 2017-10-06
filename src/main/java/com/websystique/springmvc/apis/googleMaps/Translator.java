package com.websystique.springmvc.apis.googleMaps;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Translator {


    public static String coordinates(String string) {
        JSONObject jsonObject = new JSONObject(string);

        String resultStatus = jsonObject.getString("status");

        System.out.println("status " + resultStatus);
        if (resultStatus.equals("ZERO_RESULTS")) return "0";
        JSONArray tsmresponse = (JSONArray) jsonObject.get("results");

        ArrayList<String> list = new ArrayList<String>();
        JSONObject geometry = tsmresponse.getJSONObject(0).getJSONObject("geometry").getJSONObject("viewport").getJSONObject("southwest");
        Double lng = geometry.getDouble("lng");
        Double lat = geometry.getDouble("lat");
        return lat.toString() + "," + lng.toString();
    }

    public static List<String> companyList(String string) {
        List<String> companyIds = new ArrayList<>();
        JSONObject jsonObject = new JSONObject(string);
        JSONArray results = jsonObject.getJSONArray("results");
        for (int i = 0; i < results.length(); i++) {
            JSONObject object = results.getJSONObject(i);
            companyIds.add(object.getString("place_id"));
        }
        return companyIds;
    }

    public static GoogleCompany getCompany(String string) {
        GoogleCompany googleCompany = new GoogleCompany();

        String phone = "";
        String website = "";
        JSONObject jsonObject = new JSONObject(string);
        JSONObject result = jsonObject.getJSONObject("result");
        try {
            website = result.getString("website");
            phone = result.getString("formatted_phone_number");
        } catch (Exception e) {
        }

        googleCompany.setAdress(result.getString("vicinity"));
        googleCompany.setName(result.getString("name"));
        googleCompany.setIcon(result.getString("icon"));
        googleCompany.setGoogleId(result.getString("place_id"));
        googleCompany.setWebsite(website);
        googleCompany.setPhone(phone);
        return googleCompany;

    }
}
