package com.websystique.springmvc.apis.privatSdk;

import com.liqpay.LiqPay;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final String PUBLIC_KEY = "i92795001588";
    private static final String PRIVATE_KEY ="6ds956RmkRyYiK4uq4YfsnOHNjsk6BqIE0Dqmvq8";

    public static void main(String[] args) throws Exception {

        //DateFormat dateFormat =

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date date = (Date)formatter.parse("17-12-2017");
        long mills = date.getTime();
        System.out.println(mills);
        Map params = new HashMap();
        params.put("action", "reports");
        params.put("version", "3");
        params.put("date_from", mills);
        params.put("date_to", "1516094154280");
        LiqPay liqpay = new LiqPay(PUBLIC_KEY, PRIVATE_KEY);

        HashMap<String, Object> res = (HashMap<String, Object>) liqpay.api("request", params);

        res.forEach((s,f)-> System.out.println(s + " " + f.toString()));



    }
}
