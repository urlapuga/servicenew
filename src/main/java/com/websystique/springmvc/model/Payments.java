package com.websystique.springmvc.model;

import javax.persistence.*;
import java.sql.Timestamp;

@NamedQueries(value = {
        @NamedQuery(name = "paymentsBySubscriber",query = "from Payments p where to=:subscriberId")
})

@Entity
@Table(name="payments")
public class Payments {
    private Integer id;
    private Integer amount;
    private Timestamp date;
    private String coment;
    private String from;
    private String to;

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
    @Column(name = "amount", nullable = true, precision = 0)
    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "date", nullable = true)
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Basic
    @Column(name = "coment", nullable = true, length = 0)
    public String getComent() {
        return coment;
    }

    public void setComent(String coment) {
        this.coment = coment;
    }

    @Basic
    @Column(name = "from", nullable = true, length = 0)
    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    @Basic
    @Column(name = "to", nullable = true, length = 0)
    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Payments payments = (Payments) o;

        if (id != null ? !id.equals(payments.id) : payments.id != null) return false;
        if (amount != null ? !amount.equals(payments.amount) : payments.amount != null) return false;
        if (date != null ? !date.equals(payments.date) : payments.date != null) return false;
        if (coment != null ? !coment.equals(payments.coment) : payments.coment != null) return false;
        if (from != null ? !from.equals(payments.from) : payments.from != null) return false;
        if (to != null ? !to.equals(payments.to) : payments.to != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (coment != null ? coment.hashCode() : 0);
        result = 31 * result + (from != null ? from.hashCode() : 0);
        result = 31 * result + (to != null ? to.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Payments{" +
                "id=" + id +
                ", amount=" + amount +
                ", date=" + date +
                ", coment='" + coment + '\'' +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                '}';
    }
}
