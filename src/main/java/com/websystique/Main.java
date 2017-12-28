package com.websystique;

import com.websystique.springmvc.actionproducer.SshTest;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        SshTest test = new SshTest("10.22.2.5","bil","Ehkfgeuf2017");
       // System.out.println((test.shut(45))?"ok":"error");
        String res = test.getMac(45);
        String result = res.split("\n")[7].split("    ")[1];
        char[] m = result.toCharArray();
        String mac = String.valueOf(m[0]+""+m[1]+":"+m[2]+""+m[3]+":"+m[5]+""+m[6]+":"+m[7]+""+m[8]+":"+m[10]+""+m[11]+":"+m[12]+""+m[13]);
        //: : :

        //switchport access vlan 209
        //switchport mode access
        //exit
        System.out.println("mac : " + mac);
    }
}

