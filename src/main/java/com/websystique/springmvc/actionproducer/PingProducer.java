package com.websystique.springmvc.actionproducer;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class PingProducer {
    public static boolean ping(String ipAddress){

        InetAddress inet = null;
        try {
            inet = InetAddress.getByName(ipAddress);
        } catch (UnknownHostException e) {
            return false;
        }
        try {
            return inet.isReachable(5000);
        } catch (IOException e) {
            return false;
        }
    }
}
