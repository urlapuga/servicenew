package com.websystique;

import com.websystique.springmvc.converters.MoneyConverter;
import com.websystique.springmvc.converters.PassToHashConverter;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

public class Main {

    public static void main(String[] args) throws IOException {
        String pass = PassToHashConverter.generatePass();

        String hashSign = PassToHashConverter.convert(pass);
        System.out.println(hashSign);

    }



}

