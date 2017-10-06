package com.websystique.springmvc.apis.googleMaps;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;

public class RequestSender {
    public static String sendGet(String urlString){
        BufferedReader rd;
        OutputStreamWriter wr;
        String result = "";
        try {
            URI uri = new URI(urlString);
            URL url = uri.toURL();

            URLConnection conn = url.openConnection();
            conn.setDoOutput(true);
            wr = new OutputStreamWriter(conn.getOutputStream());
            wr.flush();

            // Get the response
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                result+=line;
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return result;
    }
}
