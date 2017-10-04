package com.websystique.springmvc.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="subscribers")
public class Subscribers {
    private Integer id;
    private String name;
    private String email;
    private String phone;
    private Integer device;
    private Integer port;
    private String ipaddress;
    private String macaddress;
    private Timestamp dateRegistered;
    private Timestamp datepayedto;
    private Integer status;
    private Integer tarif;
    private Integer iptype;
    private Devices devicesByDevice;
    private SubscriberStatus subscriberStatusByStatus;
    private Tarifs tarifsByTarif;
    private IpType ipTypeByIptype;

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
    @Column(name = "name", nullable = true, length = 0)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "email", nullable = true, length = 0)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "phone", nullable = true, length = 0)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
    @Column(name = "ipaddress", nullable = true, length = 0)
    public String getIpaddress() {
        return ipaddress;
    }

    public void setIpaddress(String ipaddress) {
        this.ipaddress = ipaddress;
    }

    @Basic
    @Column(name = "macaddress", nullable = true, length = 0)
    public String getMacaddress() {
        return macaddress;
    }

    public void setMacaddress(String macaddress) {
        this.macaddress = macaddress;
    }

    @Basic
    @Column(name = "date_registered", nullable = true)
    public Timestamp getDateRegistered() {
        return dateRegistered;
    }

    public void setDateRegistered(Timestamp dateRegistered) {
        this.dateRegistered = dateRegistered;
    }

    @Basic
    @Column(name = "datepayedto", nullable = true)
    public Timestamp getDatepayedto() {
        return datepayedto;
    }

    public void setDatepayedto(Timestamp datepayedto) {
        this.datepayedto = datepayedto;
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
    @Column(name = "tarif", nullable = true)
    public Integer getTarif() {
        return tarif;
    }

    public void setTarif(Integer tarif) {
        this.tarif = tarif;
    }

    @Basic
    @Column(name = "iptype", nullable = true)
    public Integer getIptype() {
        return iptype;
    }

    public void setIptype(Integer iptype) {
        this.iptype = iptype;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Subscribers that = (Subscribers) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (device != null ? !device.equals(that.device) : that.device != null) return false;
        if (port != null ? !port.equals(that.port) : that.port != null) return false;
        if (ipaddress != null ? !ipaddress.equals(that.ipaddress) : that.ipaddress != null) return false;
        if (macaddress != null ? !macaddress.equals(that.macaddress) : that.macaddress != null) return false;
        if (dateRegistered != null ? !dateRegistered.equals(that.dateRegistered) : that.dateRegistered != null)
            return false;
        if (datepayedto != null ? !datepayedto.equals(that.datepayedto) : that.datepayedto != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (tarif != null ? !tarif.equals(that.tarif) : that.tarif != null) return false;
        if (iptype != null ? !iptype.equals(that.iptype) : that.iptype != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (device != null ? device.hashCode() : 0);
        result = 31 * result + (port != null ? port.hashCode() : 0);
        result = 31 * result + (ipaddress != null ? ipaddress.hashCode() : 0);
        result = 31 * result + (macaddress != null ? macaddress.hashCode() : 0);
        result = 31 * result + (dateRegistered != null ? dateRegistered.hashCode() : 0);
        result = 31 * result + (datepayedto != null ? datepayedto.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (tarif != null ? tarif.hashCode() : 0);
        result = 31 * result + (iptype != null ? iptype.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "device", referencedColumnName = "id", insertable = false, updatable = false)
    public Devices getDevicesByDevice() {
        return devicesByDevice;
    }

    public void setDevicesByDevice(Devices devicesByDevice) {
        this.devicesByDevice = devicesByDevice;
    }

    @ManyToOne
    @JoinColumn(name = "status", referencedColumnName = "id", insertable = false, updatable = false)
    public SubscriberStatus getSubscriberStatusByStatus() {
        return subscriberStatusByStatus;
    }

    public void setSubscriberStatusByStatus(SubscriberStatus subscriberStatusByStatus) {
        this.subscriberStatusByStatus = subscriberStatusByStatus;
    }

    @ManyToOne
    @JoinColumn(name = "tarif", referencedColumnName = "id", insertable = false, updatable = false)
    public Tarifs getTarifsByTarif() {
        return tarifsByTarif;
    }

    public void setTarifsByTarif(Tarifs tarifsByTarif) {
        this.tarifsByTarif = tarifsByTarif;
    }

    @ManyToOne
    @JoinColumn(name = "iptype", referencedColumnName = "id", insertable = false, updatable = false)
    public IpType getIpTypeByIptype() {
        return ipTypeByIptype;
    }

    public void setIpTypeByIptype(IpType ipTypeByIptype) {
        this.ipTypeByIptype = ipTypeByIptype;
    }
}
