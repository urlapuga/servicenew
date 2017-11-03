package com.websystique.springmvc.converters;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;

public class MoneyConverter {
    public static String convert(String amount, int pdv) {
        try {
            URL url = new URL("https://num-words.com");
            Map<String, Object> params = new LinkedHashMap<>();
            params.put("number_in", amount);
            params.put("type", "1");
            params.put("language", "ua");
            params.put("currency", "uah");
            params.put("pdv", "20");
            params.put("eurocent", "1");
            params.put("site_lang", "/ru");
            params.put("site_lng", "ru");
            params.put("action", "recalc");

            StringBuilder postData = new StringBuilder();
            for (Map.Entry<String, Object> param : params.entrySet()) {
                if (postData.length() != 0) postData.append('&');
                postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
                postData.append('=');
                postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
            }
            byte[] postDataBytes = postData.toString().getBytes("UTF-8");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
            conn.setDoOutput(true);
            conn.getOutputStream().write(postDataBytes);

            Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));

            String result = "";
            for (int c; (c = in.read()) >= 0; ) {
                result += (char) c;
            }

            int i = (pdv == 0) ? 1 : 6;
            return result.split("</div>")[i].split("readonly>")[1].split("</textarea>")[0];
        } catch (IOException e) {
            return "";
        }
    }
    }

