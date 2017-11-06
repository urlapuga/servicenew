package com.websystique.springmvc.converters;

import java.security.MessageDigest;
import java.util.UUID;

public class PassToHashConverter {

    public static String generatePass() {
        String uuid = UUID.randomUUID().toString().split("-")[0];
        return "uuid = " + uuid;
    }

    public static boolean checkPass(String pass, String hash) {
        return convert(pass).equals(hash);
    }

    public static String convert(String message) {
        String type = "SHA1";
        StringBuilder sBuilder = null;
        try {
            MessageDigest messageDigest1 = MessageDigest.getInstance(type);
            messageDigest1.update(message.getBytes());
            sBuilder = new StringBuilder();
            for (byte b : messageDigest1.digest()) {
                sBuilder.append(String.format("%02X", b));
            }
        } catch (Exception e) {
        }
        return sBuilder.toString();
    }
}
