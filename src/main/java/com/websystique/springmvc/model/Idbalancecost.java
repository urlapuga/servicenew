package com.websystique.springmvc.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Idbalancecost {
    private int id;
    private Double balance;
    private Long cost;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "balance", nullable = true, precision = 0)
    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @Basic
    @Column(name = "cost", nullable = true, precision = 0)
    public Long getCost() {
        return cost;
    }

    public void setCost(Long cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Idbalancecost that = (Idbalancecost) o;

        if (id != that.id) return false;
        if (balance != null ? !balance.equals(that.balance) : that.balance != null) return false;
        if (cost != null ? !cost.equals(that.cost) : that.cost != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (balance != null ? balance.hashCode() : 0);
        result = 31 * result + (cost != null ? cost.hashCode() : 0);
        return result;
    }
}
