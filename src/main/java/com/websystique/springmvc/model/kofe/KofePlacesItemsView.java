package com.websystique.springmvc.model.kofe;

import javax.persistence.*;
import java.util.Objects;
@NamedQueries(value = {
        @NamedQuery(name = "getByPlace",query = "from KofePlacesItemsView k where k.place =:place")
})

@Entity
@Table(name = "kofe_places_items_view", schema = "service")
public class KofePlacesItemsView {
    private int id;
    private Integer item;
    private Integer place;
    private Double cost;
    private String name;
    private Integer type;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "item")
    public Integer getItem() {
        return item;
    }

    public void setItem(Integer item) {
        this.item = item;
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
    @Column(name = "cost")
    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
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
        KofePlacesItemsView that = (KofePlacesItemsView) o;
        return id == that.id &&
                Objects.equals(item, that.item) &&
                Objects.equals(place, that.place) &&
                Objects.equals(cost, that.cost) &&
                Objects.equals(name, that.name) &&
                Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, item, place, cost, name, type);
    }

    @Override
    public String toString() {
        return "KofePlacesItemsView{" +
                "cost=" + cost +
                ", name='" + name + '\'' +
                '}';
    }
}
