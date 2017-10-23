package com.websystique.springmvc.model;

import javax.persistence.*;

@Entity
@Table(name = "optic_lines", schema = "service")
public class OpticLines {
    private Integer id;

    @Id
    @GeneratedValue
    @Column(name="id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private Integer devicefrom;
    private Integer deviceto;
    private Devices devicesByDevicefrom;
    private Devices devicesByDeviceto;

    @Basic
    @Column(name = "devicefrom", nullable = true)
    public Integer getDevicefrom() {
        return devicefrom;
    }

    public void setDevicefrom(Integer devicefrom) {
        this.devicefrom = devicefrom;
    }

    @Basic
    @Column(name = "deviceto", nullable = true)
    public Integer getDeviceto() {
        return deviceto;
    }

    public void setDeviceto(Integer deviceto) {
        this.deviceto = deviceto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OpticLines that = (OpticLines) o;

        if (devicefrom != null ? !devicefrom.equals(that.devicefrom) : that.devicefrom != null) return false;
        if (deviceto != null ? !deviceto.equals(that.deviceto) : that.deviceto != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = devicefrom != null ? devicefrom.hashCode() : 0;
        result = 31 * result + (deviceto != null ? deviceto.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "devicefrom", referencedColumnName = "id",updatable = false,insertable = false)
    public Devices getDevicesByDevicefrom() {
        return devicesByDevicefrom;
    }

    public void setDevicesByDevicefrom(Devices devicesByDevicefrom) {
        this.devicesByDevicefrom = devicesByDevicefrom;
    }

    @ManyToOne
    @JoinColumn(name = "deviceto", referencedColumnName = "id",updatable = false,insertable = false)
    public Devices getDevicesByDeviceto() {
        return devicesByDeviceto;
    }

    public void setDevicesByDeviceto(Devices devicesByDeviceto) {
        this.devicesByDeviceto = devicesByDeviceto;
    }

    @Override
    public String toString() {
        return "OpticLines{" +
                "id=" + id +
                ", devicefrom=" + devicefrom +
                ", deviceto=" + deviceto +
                ", devicesByDevicefrom=" + devicesByDevicefrom +
                ", devicesByDeviceto=" + devicesByDeviceto +
                '}';
    }
}
