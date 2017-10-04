package com.websystique.springmvc.actionproducer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropFabric {
    private static Properties props = new Properties();
    private static FileInputStream fis;

    public static Properties get() {
        try {
            fis = new FileInputStream("src/main/resources/config.properties");
            props.load(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return props;
    }
}
