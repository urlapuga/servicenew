package com.websystique.springmvc.model.kofe;

import javax.persistence.*;
import java.util.Collection;


@NamedQueries(value = {
        @NamedQuery(name = "getPlaceByPin", query = "From KofePlaces p where p.pincode = :pin")
})
@Entity
@Table(name = "kofe_places", schema = "service")
public class KofePlaces {
    private int id;
    private String address;
    private Integer pincode;
    private Collection<KofeItemsPlacesCosts> kofeItemsPlacesCostsById;
    private Collection<KofeSklad> kofeSkladsById;
    private Collection<KofeWorkLog> kofeWorkLogsById;
    private Collection<KofeWorkers> kofeWorkersById;
    private Collection<KofeZayavki> kofeZayavkisById;

    public KofePlaces(String addr, Integer pin) {
        this.address = addr;
        this.pincode = pin;
    }

    public KofePlaces() {
    }

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "pincode")
    public Integer getPincode() {
        return pincode;
    }

    public void setPincode(Integer pincode) {
        this.pincode = pincode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        KofePlaces that = (KofePlaces) o;

        if (id != that.id) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (pincode != null ? !pincode.equals(that.pincode) : that.pincode != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (pincode != null ? pincode.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "kofePlacesByPlace")
    public Collection<KofeItemsPlacesCosts> getKofeItemsPlacesCostsById() {
        return kofeItemsPlacesCostsById;
    }

    public void setKofeItemsPlacesCostsById(Collection<KofeItemsPlacesCosts> kofeItemsPlacesCostsById) {
        this.kofeItemsPlacesCostsById = kofeItemsPlacesCostsById;
    }

    @OneToMany(mappedBy = "kofePlacesByPlace")
    public Collection<KofeSklad> getKofeSkladsById() {
        return kofeSkladsById;
    }

    public void setKofeSkladsById(Collection<KofeSklad> kofeSkladsById) {
        this.kofeSkladsById = kofeSkladsById;
    }

    @OneToMany(mappedBy = "kofePlacesByPlace")
    public Collection<KofeWorkLog> getKofeWorkLogsById() {
        return kofeWorkLogsById;
    }

    public void setKofeWorkLogsById(Collection<KofeWorkLog> kofeWorkLogsById) {
        this.kofeWorkLogsById = kofeWorkLogsById;
    }

    @OneToMany(mappedBy = "kofePlacesByPlace")
    public Collection<KofeWorkers> getKofeWorkersById() {
        return kofeWorkersById;
    }

    public void setKofeWorkersById(Collection<KofeWorkers> kofeWorkersById) {
        this.kofeWorkersById = kofeWorkersById;
    }

    @OneToMany(mappedBy = "kofePlacesByPlace")
    public Collection<KofeZayavki> getKofeZayavkisById() {
        return kofeZayavkisById;
    }

    public void setKofeZayavkisById(Collection<KofeZayavki> kofeZayavkisById) {
        this.kofeZayavkisById = kofeZayavkisById;
    }

    @Override
    public String toString() {
        return "KofePlaces{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", pincode=" + pincode +
                '}';
    }
}
