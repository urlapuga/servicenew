package com.websystique.springmvc.apis.privat;

public class urlString {
    static String exchangeRates(){
        return "https://api.privatbank.ua/p24api/pubinfo?json&exchange&coursid=5";
    }
    static String balance(){
        return " https://api.privatbank.ua/p24api/balance";
    }

}
