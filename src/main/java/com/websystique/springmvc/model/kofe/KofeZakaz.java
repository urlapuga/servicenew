package com.websystique.springmvc.model.kofe;

import java.sql.Timestamp;

public class KofeZakaz {
    Integer[] items ;
    Timestamp dateTime;

    public KofeZakaz() {
    }

    public KofeZakaz(Integer[] items, Timestamp dateTime) {
        this.items = items;
        this.dateTime = dateTime;
    }

    public Integer[] getItems() {
        return items;
    }

    public void setItems(Integer[] items) {
        this.items = items;
    }

    public Timestamp getDateTime() {
        return dateTime;
    }

    public void setDateTime(Timestamp dateTime) {
        this.dateTime = dateTime;
    }
}
