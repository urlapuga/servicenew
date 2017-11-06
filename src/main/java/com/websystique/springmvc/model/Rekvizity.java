package com.websystique.springmvc.model;

import javax.persistence.*;
import java.sql.Timestamp;

@NamedQueries(value = {
        @NamedQuery(name = "rekvizityBySubscriber", query = "from Rekvizity r where subscriber = :subscriberId")
})

@Entity
@Table(name = "rekvizity")
public class Rekvizity {
    private int id;
    private Integer subscriber;
    private String fopname;
    private String address;
    private Integer rr;
    private String bank;
    private Integer mfo;
    private Integer edrpou;
    private String edr;
    private String nalogform;
    private String director;
    private String phone;
    private Timestamp data;
    private Integer pdv;


    @Column(name = "site")
    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    private String site;

    @Column(name = "pdv")
    public Integer getPdv() {
        return pdv;
    }

    public void setPdv(Integer pdv) {
        this.pdv = pdv;
    }

    @Column(name = "data")
    public Timestamp getData() {
        return data;
    }

    public void setData(Timestamp data) {
        this.data = data;
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
    @Column(name = "subscriber", nullable = true)
    public Integer getSubscriber() {
        return subscriber;
    }

    public void setSubscriber(Integer subscriber) {
        this.subscriber = subscriber;
    }

    @Basic
    @Column(name = "fopname", nullable = true, length = 255)
    public String getFopname() {
        return fopname;
    }

    public void setFopname(String fopname) {
        this.fopname = fopname;
    }

    @Basic
    @Column(name = "address", nullable = true, length = 255)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "rr", nullable = true)
    public Integer getRr() {
        return rr;
    }

    public void setRr(Integer rr) {
        this.rr = rr;
    }

    @Basic
    @Column(name = "bank", nullable = true, length = 255)
    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    @Basic
    @Column(name = "mfo", nullable = true)
    public Integer getMfo() {
        return mfo;
    }

    public void setMfo(Integer mfo) {
        this.mfo = mfo;
    }

    @Basic
    @Column(name = "edrpou", nullable = true)
    public Integer getEdrpou() {
        return edrpou;
    }

    public void setEdrpou(Integer edrpou) {
        this.edrpou = edrpou;
    }

    @Basic
    @Column(name = "edr", nullable = true, length = 255)
    public String getEdr() {
        return edr;
    }

    public void setEdr(String edr) {
        this.edr = edr;
    }

    @Basic
    @Column(name = "nalogform", nullable = true, length = 255)
    public String getNalogform() {
        return nalogform;
    }

    public void setNalogform(String nalogform) {
        this.nalogform = nalogform;
    }

    @Basic
    @Column(name = "director", nullable = true, length = 255)
    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Basic
    @Column(name = "phone", nullable = true, length = 255)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rekvizity rekvizity = (Rekvizity) o;

        if (id != rekvizity.id) return false;
        if (subscriber != null ? !subscriber.equals(rekvizity.subscriber) : rekvizity.subscriber != null) return false;
        if (fopname != null ? !fopname.equals(rekvizity.fopname) : rekvizity.fopname != null) return false;
        if (address != null ? !address.equals(rekvizity.address) : rekvizity.address != null) return false;
        if (rr != null ? !rr.equals(rekvizity.rr) : rekvizity.rr != null) return false;
        if (bank != null ? !bank.equals(rekvizity.bank) : rekvizity.bank != null) return false;
        if (mfo != null ? !mfo.equals(rekvizity.mfo) : rekvizity.mfo != null) return false;
        if (edrpou != null ? !edrpou.equals(rekvizity.edrpou) : rekvizity.edrpou != null) return false;
        if (edr != null ? !edr.equals(rekvizity.edr) : rekvizity.edr != null) return false;
        if (nalogform != null ? !nalogform.equals(rekvizity.nalogform) : rekvizity.nalogform != null) return false;
        if (director != null ? !director.equals(rekvizity.director) : rekvizity.director != null) return false;
        if (phone != null ? !phone.equals(rekvizity.phone) : rekvizity.phone != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (subscriber != null ? subscriber.hashCode() : 0);
        result = 31 * result + (fopname != null ? fopname.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (rr != null ? rr.hashCode() : 0);
        result = 31 * result + (bank != null ? bank.hashCode() : 0);
        result = 31 * result + (mfo != null ? mfo.hashCode() : 0);
        result = 31 * result + (edrpou != null ? edrpou.hashCode() : 0);
        result = 31 * result + (edr != null ? edr.hashCode() : 0);
        result = 31 * result + (nalogform != null ? nalogform.hashCode() : 0);
        result = 31 * result + (director != null ? director.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Rekvizity{" +
                "id=" + id +
                ", subscriber=" + subscriber +
                ", fopname='" + fopname + '\'' +
                ", address='" + address + '\'' +
                ", rr=" + rr +
                ", bank='" + bank + '\'' +
                ", mfo=" + mfo +
                ", edrpou=" + edrpou +
                ", edr='" + edr + '\'' +
                ", nalogform='" + nalogform + '\'' +
                ", director='" + director + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
