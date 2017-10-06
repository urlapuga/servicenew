package com.websystique.springmvc.apis.privat;
import java.security.MessageDigest;

public class XML {

    static String id = "130386";
    static String signature = "lx3PIDjmL2OzkJv69IM3DHu2gy15WvQ9";
    static String card = "4149437830388334";
    static String data ="<oper>cmt</oper><wait>1</wait><test>1</test><payment id=\"\"><prop name=\"cardnum\" value=\""+card+"\"/><prop name=\"country\" value=\"UA\"/></payment>";

    static String hashSign = HashTest(HashTest(data+signature,"MD5"), "SHA1");

    public static String xmlString(){


        String request = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n";
        System.out.println(hashSign);
        request += "<request version=\"1.0\">\n";
        request += "<merchant>\n" +
                "<id>" + id + "</id>\n" +
                "<signature>" + hashSign + "</signature>\n" +
                "</merchant>";


        request+="<data>"+data+"</data></request>";
        System.out.println(request);
        return request;
    }

    public static String HashTest(String message, String type) {
        StringBuilder sBuilder = null;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(type);
            messageDigest.update(message.getBytes());
            sBuilder = new StringBuilder();
            for (byte b : messageDigest.digest()) {
                sBuilder.append(String.format("%02X", b));
            }
        } catch (Exception e) {
        }
        return sBuilder.toString();
    }

}