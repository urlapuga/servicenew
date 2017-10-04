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
    @Column(name = "ipaddress", nullable = true, length = 0)
    public String getIpaddress() {
        return ipaddress;
    }

    public void setIpaddress(String ipaddress) {
        this.ipaddress = ipaddress;
    }

    @Basic
    @Column(name = "login", nullable = true, length = 0)
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Basic
    @Column(name = "password", nullable = true, length = 0)
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

    @ManyToOne
    @JoinColumn(name = "type", referencedColumnName = "id", insertable = false, updatable = false)
    public DeviceTypes getDeviceTypesByType() {
        return deviceTypesByType;
    }

    public void setDeviceTypesByType(DeviceTypes deviceTypesByType) {
        this.deviceTypesByType = deviceTypesByType;
    }

    @ManyToOne
    @JoinColumn(name = "model", referencedColumnName = "id", insertable = false, updatable = false)
    public DeviceModels getDeviceModelsByModel() {
        return deviceModelsByModel;
    }

    public void setDeviceModelsByModel(DeviceModels deviceModelsByModel) {
        this.deviceModelsByModel = deviceModelsByModel;
    }

    @OneToMany(mappedBy = "devicesByDevice")
    public Collection<Subscribers> getSubscribersById() {
        return subscribersById;
    }

    public void setSubscribersById(Collection<Subscribers> subscribersById) {
        this.subscribersById = subscribersById;
    }
}
