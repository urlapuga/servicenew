package com.websystique.springmvc.model.kofe;

import javax.persistence.*;

@NamedQueries(value = {
        @NamedQuery(name = "getByPlaceItem",
                query = "From KofeItemsPlacesCosts k where k.place=:place AND k.item=:item")
})

@Entity
@Table(name = "kofe_items_places_costs", schema = "service")
public class KofeItemsPlacesCosts {
    private int id;
    private Integer item;
    private Integer place;
    private Double cost;
    private KofeItems kofeItemsByItem;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        KofeItemsPlacesCosts that = (KofeItemsPlacesCosts) o;

        if (id != that.id) return false;
        if (item != null ? !item.equals(that.item) : that.item != null) return false;
        if (place != null ? !place.equals(that.place) : that.place != null) return false;
        if (cost != null ? !cost.equals(that.cost) : that.cost != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (item != null ? item.hashCode() : 0);
        result = 31 * result + (place != null ? place.hashCode() : 0);
        result = 31 * result + (cost != null ? cost.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "item", referencedColumnName = "id", insertable=false,updatable = false)
    public KofeItems getKofeItemsByItem() {
        return kofeItemsByItem;
    }

    public void setKofeItemsByItem(KofeItems kofeItemsByItem) {
        this.kofeItemsByItem = kofeItemsByItem;
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
