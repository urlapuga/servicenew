package com.websystique.springmvc.apis.privat;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        DataInputStream dis = null;
        try {
            BufferedInputStream bs = Test2.postMessage(XML.xmlString(),"https://api.privatbank.ua/p24api/balance");
            dis = new DataInputStream(bs);
            while (dis.available() != 0) {
                System.out.println(dis.readLine());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
