package com.websystique.springmvc.model;

import javax.persistence.*;

@NamedQueries(value = {
        @NamedQuery(name = "TarifsOfSubscriber",query = "From SubscriberTarifs st where st.subscriberId= :subscriberId")
})

@Entity
@Table(name = "subscriber_tarifs", schema = "service", catalog = "")
public class SubscriberTarifs {
    private int id;
    private Integer subscriberId;
    private Integer tarifId;
    private Integer device;
    private Integer port;
    private Integer active;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "subscriber_id", nullable = true)
    public Integer getSubscriberId() {
        return subscriberId;
    }

    public void setSubscriberId(Integer subscriberId) {
        this.subscriberId = subscriberId;
    }

    @Basic
    @Column(name = "tarif_id", nullable = true)
    public Integer getTarifId() {
        return tarifId;
    }

    public void setTarifId(Integer tarifId) {
        this.tarifId = tarifId;
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
    @Column(name = "active", nullable = true)
    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SubscriberTarifs that = (SubscriberTarifs) o;

        if (id != that.id) return false;
        if (subscriberId != null ? !subscriberId.equals(that.subscriberId) : that.subscriberId != null) return false;
        if (tarifId != null ? !tarifId.equals(that.tarifId) : that.tarifId != null) return false;
        if (device != null ? !device.equals(that.device) : that.device != null) return false;
        if (port != null ? !port.equals(that.port) : that.port != null) return false;
        if (active != null ? !active.equals(that.active) : that.active != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (subscriberId != null ? subscriberId.hashCode() : 0);
        result = 31 * result + (tarifId != null ? tarifId.hashCode() : 0);
        result = 31 * result + (device != null ? device.hashCode() : 0);
        result = 31 * result + (port != null ? port.hashCode() : 0);
        result = 31 * result + (active != null ? active.hashCode() : 0);
        return result;
    }
}
