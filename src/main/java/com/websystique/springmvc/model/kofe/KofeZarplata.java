package com.websystique.springmvc.model.kofe;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "kofe_zarplata", schema = "service", catalog = "")
public class KofeZarplata {
    private int id;
    private Integer worker;
    private Double amount;
    private Timestamp date;

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
    @Column(name = "amount")
    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "date")
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        KofeZarplata that = (KofeZarplata) o;

        if (id != that.id) return false;
        if (worker != null ? !worker.equals(that.worker) : that.worker != null) return false;
        if (amount != null ? !amount.equals(that.amount) : that.amount != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (worker != null ? worker.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }
}
