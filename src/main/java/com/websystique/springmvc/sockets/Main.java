package com.websystique.springmvc.sockets;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {

    }
public void send(){
    try {
        Socket socket = new Socket("127.0.0.1",12345);
        DataOutputStream dOut = new DataOutputStream(socket.getOutputStream());
        dOut.writeBytes("test");
    } catch (IOException e) {
        e.printStackTrace();
    }
}
}

