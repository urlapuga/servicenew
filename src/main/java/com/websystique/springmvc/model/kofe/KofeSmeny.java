package com.websystique.springmvc.model.kofe;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;


@NamedQueries(value = {
        @NamedQuery(name = "getSmenaByPinAndWorker",query = "from KofeSmeny k where k.place =:place and k.worker =:worker and k.dateclosed=NULL ")
})
@Entity
@Table(name = "kofe_smeny", schema = "service")
public class KofeSmeny {
    private int id;
    private Timestamp dateopened;
    private Integer worker;
    private Integer place;
    private Timestamp dateclosed;
    private Double moneyMade;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "dateopened")
    public Timestamp getDateopened() {
        return dateopened;
    }

    public void setDateopened(Timestamp dateopened) {
        this.dateopened = dateopened;
    }

    @Basic
    @Column(name = "worker")
    public Integer getWorker() {
        return worker;
    }

    public void setWorker(Integer worker) {
        this.worker = worker;
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
    @Column(name = "dateclosed")
    public Timestamp getDateclosed() {
        return dateclosed;
    }

    public void setDateclosed(Timestamp dateclosed) {
        this.dateclosed = dateclosed;
    }

    @Basic
    @Column(name = "moneyMade")
    public Double getMoneyMade() {
        return moneyMade;
    }

    public void setMoneyMade(Double moneyMade) {
        this.moneyMade = moneyMade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KofeSmeny kofeSmeny = (KofeSmeny) o;
        return id == kofeSmeny.id &&
                Objects.equals(dateopened, kofeSmeny.dateopened) &&
                Objects.equals(worker, kofeSmeny.worker) &&
                Objects.equals(place, kofeSmeny.place) &&
                Objects.equals(dateclosed, kofeSmeny.dateclosed) &&
                Objects.equals(moneyMade, kofeSmeny.moneyMade);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, dateopened, worker, place, dateclosed, moneyMade);
    }
}
