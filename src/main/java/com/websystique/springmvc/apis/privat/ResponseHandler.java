package com.websystique.springmvc.apis.privat;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResponseHandler {

    private String handle(String url, Map<String, String> params) {

        String charset = "UTF-8";

        String param1 = null;
        String param2 = null;
        String result = null;
        try {
            param1 = URLEncoder.encode("param1", charset);
            param2 = URLEncoder.encode("param2", charset);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        String query = String.format("param1=%s&param2=%s", param1, param2);
        System.out.println(query);
        java.net.URLConnection urlConnection = null;
        try {
            urlConnection = new URL(url).openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        urlConnection.setUseCaches(false);
        urlConnection.setDoOutput(true); // Triggers POST.
        urlConnection.setRequestProperty("accept-charset", charset);
        urlConnection.setRequestProperty("content-type", "application/x-www-form-urlencoded");

        OutputStreamWriter writer = null;

        try {
            writer = new OutputStreamWriter(urlConnection.getOutputStream(), charset);
            writer.write(query);
        } catch (IOException e) {
            e.printStackTrace();
        }


        if (writer != null) try {
            writer.close();
        } catch (IOException logOrIgnore) {
        }


        try {
            result = output(urlConnection.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    private String output(InputStream is) {
        String readLine;
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String resultString = "";
        try {
            while (((readLine = br.readLine()) != null)) {
                resultString += readLine;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultString;
    }

    Map<Integer, Map<String, String>> getMap(String url ,Map<String,String> params ){

        String inputFile = handle(url,params);
        Map<Integer, Map<String, String>> values = new HashMap<>();

        //System.out.println(inputFile);

        JSONArray jsonarray = new JSONArray(inputFile);
        for (int i = 0; i < jsonarray.length(); i++) {
            JSONObject jsonobject = jsonarray.getJSONObject(i);
            List<Map<String, String>> list = new ArrayList<>();
            Map<String, String> map = new HashMap<>();
            jsonobject.keySet().stream().forEach(l -> map.put(l, jsonobject.getString(l)));
            values.put(i, map);
        }
        //values.forEach((k, v) -> System.out.println(k + " " + v));
        return values;
    }
}
