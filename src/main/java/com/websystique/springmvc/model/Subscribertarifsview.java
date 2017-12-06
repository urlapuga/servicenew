package com.websystique.springmvc.model;

import jdk.nashorn.internal.ir.annotations.Immutable;

import javax.persistence.*;


@NamedQueries(value = {
        @NamedQuery(name = "tarifsBySubscriber", query = "FROM Subscribertarifsview  s where s.id = :subscriberId"),
        @NamedQuery(name = "allActiveTarifs",query = "FROM Subscribertarifsview  s where s.active = 1")
})
@Immutable
@Entity
@Table(name="subscribertarifsview")
public class Subscribertarifsview {
    private int id;
    private String name;
    private Integer speed;
    private Integer cost;
    private Integer device;
    private Integer port;
    private Integer active;
    private Integer tarifid;

    @Column(name = "tarifid")
    public Integer getTarifid() {
        return tarifid;
    }

    public void setTarifid(Integer tarifid) {
        this.tarifid = tarifid;
    }

    @Id
    @Column(name = "subscribertarifid")
    public Integer getSubscribertarifid() {
        return subscribertarifid;
    }

    public void setSubscribertarifid(Integer subscribertarifid) {
        this.subscribertarifid = subscribertarifid;
    }

    private Integer subscribertarifid;



    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "active")
    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "speed", nullable = true)
    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }


    @Basic
    @Column(name = "device", nullable = true)
    public Integer getDevice() {
        return device;
    }

    public void setDevice(Integer device) {
        this.device = device;
    }

    @Basic
    @Column(name = "port", nullable = true)
    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    @Basic
    @Column(name = "cost", nullable = true)
    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Subscribertarifsview that = (Subscribertarifsview) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (speed != null ? !speed.equals(that.speed) : that.speed != null) return false;
        if (cost != null ? !cost.equals(that.cost) : that.cost != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (speed != null ? speed.hashCode() : 0);
        result = 31 * result + (cost != null ? cost.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Subscribertarifsview{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", speed=" + speed +
                ", cost=" + cost +
                '}';
    }
}
