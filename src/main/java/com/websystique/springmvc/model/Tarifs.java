package com.websystique.springmvc.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name="tarifs")
public class Tarifs {
    private Integer id;
    private String name;
    private Integer speed;
    private Integer cost;
    private Collection<Subscribers> subscribersById;

    @Column(name = "companyid")
    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    private Integer companyId;

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
    @Column(name = "speed", nullable = true)
    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    @Basic
    @Column(name = "cost", nullable = true)
    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tarifs tarifs = (Tarifs) o;

        if (id != null ? !id.equals(tarifs.id) : tarifs.id != null) return false;
        if (name != null ? !name.equals(tarifs.name) : tarifs.name != null) return false;
        if (speed != null ? !speed.equals(tarifs.speed) : tarifs.speed != null) return false;
        if (cost != null ? !cost.equals(tarifs.cost) : tarifs.cost != null) return false;

        return true;
    }

    @Override
    public String toString() {
        return "Tarifs{" +
                "name='" + name + '\'' +
                ", speed=" + speed +
                ", cost=" + cost +
                '}';
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (speed != null ? speed.hashCode() : 0);
        result = 31 * result + (cost != null ? cost.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "tarifsByTarif")
    public Collection<Subscribers> getSubscribersById() {
        return subscribersById;
    }

    public void setSubscribersById(Collection<Subscribers> subscribersById) {
        this.subscribersById = subscribersById;
    }
}
