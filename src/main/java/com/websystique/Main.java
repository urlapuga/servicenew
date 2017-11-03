package com.websystique;

import com.websystique.springmvc.converters.MoneyConverter;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {

        System.out.println(MoneyConverter.convert("1234,12",1));
       // Document doc = Jsoup.connect("https://www.summa-propisyu.ru/?summ=326.90").get();
      //  Elements newsHeadlines = doc.select("#result1");
       // System.out.println(newsHeadlines.text());

    }


    }

