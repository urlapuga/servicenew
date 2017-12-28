package com.websystique.springmvc.kofe;

import com.google.gson.Gson;
import com.websystique.springmvc.model.kofe.KofeItems;
import com.websystique.springmvc.model.kofe.KofeZakaz;

import java.io.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {

    private static Gson gson = new Gson();
    static String file  = "test.tt";
    public static void main(String[] args) throws IOException {
        write();
        read();
    }

    private static void write() throws FileNotFoundException {


        KofeZakaz zakaz = new KofeZakaz();
     //   zakaz.setDateTime(new Timestamp().getTime());
        List<KofeItems> kofeItemsList = new ArrayList<>();
        kofeItemsList.add(new KofeItems("1", 1));
        kofeItemsList.add(new KofeItems("2", 2));
        kofeItemsList.add(new KofeItems("3", 3));

        PrintWriter pw = new PrintWriter(new FileOutputStream(file));
        for (KofeItems club : kofeItemsList)
            pw.print(gson.toJson(club));
        pw.close();

    }

    static void read() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {



       //  KofeItems[] read = gson.fromJson(line, KofeItems[].class);

                System.out.println();
         //System.out.println(read);
        }
    }
}
