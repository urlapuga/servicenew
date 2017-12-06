package com.websystique.springmvc.model.kofe;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "kofe_zayavki", schema = "service", catalog = "")
public class KofeZayavki {
    private int id;
    private Integer ingredient;
    private Integer place;
    private Timestamp date;
    private Integer status;
    private Timestamp datecreated;
    private Double amount;
    private KofeIngredients kofeIngredientsByIngredient;
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
    @Column(name = "ingredient")
    public Integer getIngredient() {
        return ingredient;
    }

    public void setIngredient(Integer ingredient) {
        this.ingredient = ingredient;
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
    @Column(name = "date")
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Basic
    @Column(name = "status")
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Basic
    @Column(name = "datecreated")
    public Timestamp getDatecreated() {
        return datecreated;
    }

    public void setDatecreated(Timestamp datecreated) {
        this.datecreated = datecreated;
    }

    @Basic
    @Column(name = "amount")
    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        KofeZayavki that = (KofeZayavki) o;

        if (id != that.id) return false;
        if (ingredient != null ? !ingredient.equals(that.ingredient) : that.ingredient != null) return false;
        if (place != null ? !place.equals(that.place) : that.place != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (datecreated != null ? !datecreated.equals(that.datecreated) : that.datecreated != null) return false;
        if (amount != null ? !amount.equals(that.amount) : that.amount != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (ingredient != null ? ingredient.hashCode() : 0);
        result = 31 * result + (place != null ? place.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (datecreated != null ? datecreated.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "ingredient", referencedColumnName = "id", insertable=false,updatable = false)
    public KofeIngredients getKofeIngredientsByIngredient() {
        return kofeIngredientsByIngredient;
    }

    public void setKofeIngredientsByIngredient(KofeIngredients kofeIngredientsByIngredient) {
        this.kofeIngredientsByIngredient = kofeIngredientsByIngredient;
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
