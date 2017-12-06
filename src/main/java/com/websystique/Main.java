package com.websystique;

import com.websystique.springmvc.actionproducer.SshProducer;
import com.websystique.springmvc.actionproducer.SshjProducer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

       // SshjProducer sshjProducer = new SshjProducer();
        List<String> list = new ArrayList<>();
        list.add("conf-t");
        list.add("int fa 1/0/45");
        list.add("shut");
        list.add("exit");
        list.add("exit");
        list.forEach(System.out::println);
       // sshjProducer.exec(list);
    }
}

