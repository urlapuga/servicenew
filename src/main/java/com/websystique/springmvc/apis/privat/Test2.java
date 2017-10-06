package com.websystique.springmvc.apis.privat;

import java.io.BufferedInputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class Test2 {


        public static BufferedInputStream postMessage(String msg, String address)
                    throws Exception
        {
            BufferedInputStream bis = null;
            String res = "";
            System.out.println("RouterMDB/postMessage to address: " + address);
            try
            {
                URL url = new URL(address);
                URLConnection uc = url.openConnection();
                HttpURLConnection conn = (HttpURLConnection) uc;
                conn.setDoInput(true);
                conn.setDoOutput(true);
                conn.setRequestMethod("POST");
                conn.setRequestProperty("Content-type", "text/xml");
                PrintWriter pw = new PrintWriter(conn.getOutputStream());
                pw.write(msg);
                pw.close();
               bis = new BufferedInputStream(conn.getInputStream());
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        return bis;
        }



}
