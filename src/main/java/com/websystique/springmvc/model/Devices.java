package com.websystique.springmvc.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name="devices")
public class Devices {
    private Integer id;
    private Integer type;
    private Integer model;
    private String ipaddress;
    private String login;
    private String password;
    private DeviceTypes deviceTypesByType;
    private DeviceModels deviceModelsByModel;
    private Collection<Subscribers> subscribersById;
    private String lat;
    private String lng;
    private Integer address;
    private Integer floor;


    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "lat", nullable = true, length = 255)
    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    @Basic
    @Column(name = "lng", nullable = true, length = 255)
    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    @Basic
    @Column(name = "type", nullable = true)
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Basic
    @Column(name = "model", nullable = true)
    public Integer getModel() {
        return model;
    }

    public void setModel(Integer model) {
        this.model = model;
    }

    @Basic
    @Column(name = "ipaddress", nullable = true, length = 20)
    public String getIpaddress() {
        return ipaddress;
    }

    public void setIpaddress(String ipaddress) {
        this.ipaddress = ipaddress;
    }

    @Basic
    @Column(name = "login", nullable = true, length = 20)
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Basic
    @Column(name = "password", nullable = true, length = 20)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Devices devices = (Devices) o;

        if (id != null ? !id.equals(devices.id) : devices.id != null) return false;
        if (type != null ? !type.equals(devices.type) : devices.type != null) return false;
        if (model != null ? !model.equals(devices.model) : devices.model != null) return false;
        if (ipaddress != null ? !ipaddress.equals(devices.ipaddress) : devices.ipaddress != null) return false;
        if (login != null ? !login.equals(devices.login) : devices.login != null) return false;
        if (password != null ? !password.equals(devices.password) : devices.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + (ipaddress != null ? ipaddress.hashCode() : 0);
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "address", nullable = true)
    public Integer getAddress() {
        return address;
    }

    public void setAddress(Integer address) {
        this.address = address;
    }

    @Basic
    @Column(name = "floor", nullable = true)
    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    @Override
    public String toString() {
        return "Devices{" +
                "id=" + id +
                ", type=" + type +
                ", model=" + model +
                ", ipaddress='" + ipaddress + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", deviceTypesByType=" + deviceTypesByType +
                ", deviceModelsByModel=" + deviceModelsByModel +
                ", lat='" + lat + '\'' +
                ", lng='" + lng + '\'' +
                ", address=" + address +
                ", floor=" + floor +
                '}';
    }
}
