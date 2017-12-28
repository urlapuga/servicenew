package com.websystique.springmvc.model.kofe;

import javax.persistence.*;
import java.util.Collection;

@NamedQueries(value = {
        @NamedQuery(name = "getWorkerByPin",query = "from KofeWorkers w where w.pincode =:pincode")
})

@Entity
@Table(name = "kofe_workers", schema = "service")
public class KofeWorkers {
    private int id;
    private String name;
    private String phone;
    private Integer place;
    private Double zarabotal;
    private Collection<KofeWorkLog> kofeWorkLogsById;
    private KofePlaces kofePlacesByPlace;
    private Integer status;
    private String pincode;

    @Column(name = "pincode")
    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public KofeWorkers(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public KofeWorkers() {
    }

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    @Column(name = "status")
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "place")
    public Integer getPlace() {
        return place;
    }

    public void setPlace(Integer place) {
        this.place = place;
    }

    @Basic
    @Column(name = "zarabotal")
    public Double getZarabotal() {
        return zarabotal;
    }

    public void setZarabotal(Double zarabotal) {
        this.zarabotal = zarabotal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        KofeWorkers that = (KofeWorkers) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (place != null ? !place.equals(that.place) : that.place != null) return false;
        if (zarabotal != null ? !zarabotal.equals(that.zarabotal) : that.zarabotal != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (place != null ? place.hashCode() : 0);
        result = 31 * result + (zarabotal != null ? zarabotal.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "kofeWorkersByWorker")
    public Collection<KofeWorkLog> getKofeWorkLogsById() {
        return kofeWorkLogsById;
    }

    public void setKofeWorkLogsById(Collection<KofeWorkLog> kofeWorkLogsById) {
        this.kofeWorkLogsById = kofeWorkLogsById;
    }

    @ManyToOne
    @JoinColumn(name = "place", referencedColumnName = "id", insertable = false, updatable = false)
    public KofePlaces getKofePlacesByPlace() {
        return kofePlacesByPlace;
    }

    public void setKofePlacesByPlace(KofePlaces kofePlacesByPlace) {
        this.kofePlacesByPlace = kofePlacesByPlace;
    }

    @Override
    public String toString() {
        return "KofeWorkers{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", place=" + place +
                ", zarabotal=" + zarabotal + " status=" + status +
                '}';
    }
}
