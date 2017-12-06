package com.websystique.springmvc.model.kofe;

import javax.persistence.*;

@Entity
@Table(name = "kofe_sklad", schema = "service", catalog = "")
public class KofeSklad {
    private int id;
    private Integer place;
    private Integer ingredient;
    private Double amount;
    private Double maxamount;
    private Double minamount;
    private KofePlaces kofePlacesByPlace;
    private KofeIngredients kofeIngredientsByIngredient;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    @Column(name = "ingredient")
    public Integer getIngredient() {
        return ingredient;
    }

    public void setIngredient(Integer ingredient) {
        this.ingredient = ingredient;
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
    @Column(name = "maxamount")
    public Double getMaxamount() {
        return maxamount;
    }

    public void setMaxamount(Double maxamount) {
        this.maxamount = maxamount;
    }

    @Basic
    @Column(name = "minamount")
    public Double getMinamount() {
        return minamount;
    }

    public void setMinamount(Double minamount) {
        this.minamount = minamount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        KofeSklad kofeSklad = (KofeSklad) o;

        if (id != kofeSklad.id) return false;
        if (place != null ? !place.equals(kofeSklad.place) : kofeSklad.place != null) return false;
        if (ingredient != null ? !ingredient.equals(kofeSklad.ingredient) : kofeSklad.ingredient != null) return false;
        if (amount != null ? !amount.equals(kofeSklad.amount) : kofeSklad.amount != null) return false;
        if (maxamount != null ? !maxamount.equals(kofeSklad.maxamount) : kofeSklad.maxamount != null) return false;
        if (minamount != null ? !minamount.equals(kofeSklad.minamount) : kofeSklad.minamount != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (place != null ? place.hashCode() : 0);
        result = 31 * result + (ingredient != null ? ingredient.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (maxamount != null ? maxamount.hashCode() : 0);
        result = 31 * result + (minamount != null ? minamount.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "place", referencedColumnName = "id", insertable=false,updatable = false)
    public KofePlaces getKofePlacesByPlace() {
        return kofePlacesByPlace;
    }

    public void setKofePlacesByPlace(KofePlaces kofePlacesByPlace) {
        this.kofePlacesByPlace = kofePlacesByPlace;
    }

    @ManyToOne
    @JoinColumn(name = "ingredient", referencedColumnName = "id", insertable=false,updatable = false)
    public KofeIngredients getKofeIngredientsByIngredient() {
        return kofeIngredientsByIngredient;
    }

    public void setKofeIngredientsByIngredient(KofeIngredients kofeIngredientsByIngredient) {
        this.kofeIngredientsByIngredient = kofeIngredientsByIngredient;
    }
}
