package com.websystique.springmvc.model.statistics;

import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Immutable
public class Allmanagerwork {
    private Date date;
    private long made;
    private String lastname;
    private int id;

    public Allmanagerwork() {
    }

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "date", nullable = true)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Basic
    @Column(name = "made", nullable = false)
    public long getMade() {
        return made;
    }

    public void setMade(long made) {
        this.made = made;
    }

    @Basic
    @Column(name = "lastname", nullable = true, length = 30)
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Allmanagerwork that = (Allmanagerwork) o;

        if (made != that.made) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (lastname != null ? !lastname.equals(that.lastname) : that.lastname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = date != null ? date.hashCode() : 0;
        result = 31 * result + (int) (made ^ (made >>> 32));
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        return result;
    }
}
