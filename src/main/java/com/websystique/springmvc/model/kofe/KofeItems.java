package com.websystique.springmvc.model.kofe;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "kofe_items", schema = "service")
public class KofeItems {
    private int id;
    private String name;
    private Double cost;
    private Integer type;
    private Integer addition;

    @Column(name = "addition")
    public Integer getAddition() {
        return addition;
    }

    public void setAddition(Integer addition) {
        this.addition = addition;
    }

    public KofeItems(String name, Integer type) {
        this.name = name;
        this.type = type;
    }

    public KofeItems() {
        
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
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "cost")
    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    @Basic
    @Column(name = "type")
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        KofeItems kofeItems = (KofeItems) o;

        if (id != kofeItems.id) return false;
        if (name != null ? !name.equals(kofeItems.name) : kofeItems.name != null) return false;
        if (cost != null ? !cost.equals(kofeItems.cost) : kofeItems.cost != null) return false;
        if (type != null ? !type.equals(kofeItems.type) : kofeItems.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (cost != null ? cost.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "KofeItems{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", type=" + type +
                '}';
    }
}
