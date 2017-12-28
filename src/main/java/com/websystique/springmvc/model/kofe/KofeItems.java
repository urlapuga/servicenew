package com.websystique.springmvc.model.kofe;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;


@NamedQueries(value = {
        @NamedQuery(name = "itemsByType",query = "FROM KofeItems k where k.type = :type")
})
@Entity
@Table(name = "kofe_items", schema = "service")
public class KofeItems {
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "cost")
    private Double cost;
    @Basic
    @Column(name = "type")
    private Integer type;

    @Transient
    @Column(name = "addition")
    private Integer addition;

    @Transient
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "kofeItems")
    private Set<KofeItemIngredientsView> kofeItemIngredientsViews;

    public Set<KofeItemIngredientsView> getKofeItemIngredientsViews() {
        return kofeItemIngredientsViews;
    }

    public void setKofeItemIngredientsViews(Set<KofeItemIngredientsView> kofeItemIngredientsViews) {
        this.kofeItemIngredientsViews = kofeItemIngredientsViews;
    }

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


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

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
