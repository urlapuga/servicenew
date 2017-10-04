package com.websystique.springmvc.model;

import javax.persistence.*;

@Entity
@Table(name = "pinger")
public class Pinger {
    private Integer id;
    private String ip;
    private Integer status;
    private Integer alertstatus;
    private String coment;


    public Pinger() {
    }

    public Pinger(String ip, String coment) {
        this.ip = ip;
        this.coment = coment;
    }


    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public boolean pinged(){
        return status==1;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "ip", nullable = true, length = 255)
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Basic
    @Column(name = "status", nullable = true)
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Basic
    @Column(name = "alertstatus", nullable = true)
    public Integer getAlertstatus() {
        return alertstatus;
    }

    public void setAlertstatus(Integer alertstatus) {
        this.alertstatus = alertstatus;
    }

    @Basic
    @Column(name = "coment", nullable = true, length = 255)
    public String getComent() {
        return coment;
    }

    public void setComent(String coment) {
        this.coment = coment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pinger pinger = (Pinger) o;

        if (id != null ? !id.equals(pinger.id) : pinger.id != null) return false;
        if (ip != null ? !ip.equals(pinger.ip) : pinger.ip != null) return false;
        if (status != null ? !status.equals(pinger.status) : pinger.status != null) return false;
        if (alertstatus != null ? !alertstatus.equals(pinger.alertstatus) : pinger.alertstatus != null) return false;
        if (coment != null ? !coment.equals(pinger.coment) : pinger.coment != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (ip != null ? ip.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (alertstatus != null ? alertstatus.hashCode() : 0);
        result = 31 * result + (coment != null ? coment.hashCode() : 0);
        return result;
    }
}
