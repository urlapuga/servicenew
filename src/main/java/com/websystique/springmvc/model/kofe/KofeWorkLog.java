package com.websystique.springmvc.model.kofe;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "kofe_work_log", schema = "service", catalog = "")
public class KofeWorkLog {
    private int id;
    private Integer worker;
    private Integer place;
    private Timestamp timelogined;
    private Timestamp timeloggedout;
    private Double money;
    private KofeWorkers kofeWorkersByWorker;
    private KofePlaces kofePlacesByPlace;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    @Column(name = "timelogined")
    public Timestamp getTimelogined() {
        return timelogined;
    }

    public void setTimelogined(Timestamp timelogined) {
        this.timelogined = timelogined;
    }

    @Basic
    @Column(name = "timeloggedout")
    public Timestamp getTimeloggedout() {
        return timeloggedout;
    }

    public void setTimeloggedout(Timestamp timeloggedout) {
        this.timeloggedout = timeloggedout;
    }

    @Basic
    @Column(name = "money")
    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        KofeWorkLog that = (KofeWorkLog) o;

        if (id != that.id) return false;
        if (worker != null ? !worker.equals(that.worker) : that.worker != null) return false;
        if (place != null ? !place.equals(that.place) : that.place != null) return false;
        if (timelogined != null ? !timelogined.equals(that.timelogined) : that.timelogined != null) return false;
        if (timeloggedout != null ? !timeloggedout.equals(that.timeloggedout) : that.timeloggedout != null)
            return false;
        if (money != null ? !money.equals(that.money) : that.money != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (worker != null ? worker.hashCode() : 0);
        result = 31 * result + (place != null ? place.hashCode() : 0);
        result = 31 * result + (timelogined != null ? timelogined.hashCode() : 0);
        result = 31 * result + (timeloggedout != null ? timeloggedout.hashCode() : 0);
        result = 31 * result + (money != null ? money.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "worker", referencedColumnName = "id", insertable=false,updatable = false)
    public KofeWorkers getKofeWorkersByWorker() {
        return kofeWorkersByWorker;
    }

    public void setKofeWorkersByWorker(KofeWorkers kofeWorkersByWorker) {
        this.kofeWorkersByWorker = kofeWorkersByWorker;
    }

    @ManyToOne
    @JoinColumn(name = "place", referencedColumnName = "id", insertable=false,updatable = false)
    public KofePlaces getKofePlacesByPlace() {
        return kofePlacesByPlace;
    }

    public void setKofePlacesByPlace(KofePlaces kofePlacesByPlace) {
        this.kofePlacesByPlace = kofePlacesByPlace;
    }
}
