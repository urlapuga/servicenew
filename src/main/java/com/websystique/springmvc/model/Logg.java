package com.websystique.springmvc.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "logg")
public class Logg {
    private int id;
    private Timestamp when;
    private String what;
    private String whatId;
    private String action;
    private String who;


    @Column(name = "who")
    public String getWho() {
        return who;
    }

    public void setWho(String who) {
        this.who = who;
    }

    public Logg(String what, String whatId, String action,Timestamp when,String who) {
        this.who = who;
        this.when = when;
        this.what = what;
        this.whatId = whatId;
        this.action = action;
    }

    public Logg() {
    }

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "when_done", nullable = true)
    public Timestamp getWhen() {
        return when;
    }

    public void setWhen(Timestamp when) {
        this.when = when;
    }

    @Basic
    @Column(name = "what", nullable = true, length = 100)
    public String getWhat() {
        return what;
    }

    public void setWhat(String what) {
        this.what = what;
    }

    @Basic
    @Column(name = "what_id", nullable = true, length = 100)
    public String getWhatId() {
        return whatId;
    }

    public void setWhatId(String whatId) {
        this.whatId = whatId;
    }

    @Basic
    @Column(name = "action", nullable = true, length = 20)
    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Logg logg = (Logg) o;

        if (id != logg.id) return false;
        if (when != null ? !when.equals(logg.when) : logg.when != null) return false;
        if (what != null ? !what.equals(logg.what) : logg.what != null) return false;
        if (whatId != null ? !whatId.equals(logg.whatId) : logg.whatId != null) return false;
        if (action != null ? !action.equals(logg.action) : logg.action != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (when != null ? when.hashCode() : 0);
        result = 31 * result + (what != null ? what.hashCode() : 0);
        result = 31 * result + (whatId != null ? whatId.hashCode() : 0);
        result = 31 * result + (action != null ? action.hashCode() : 0);
        return result;
    }

}
