package com.websystique.springmvc.model.kofe;

import javax.persistence.*;

@Entity
@Table(name = "kofe_item_ingredients", schema = "service", catalog = "")
public class KofeItemIngredients {
    private int id;
    private Integer itemid;
    private Integer ingredientid;
    private Double amount;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "itemid")
    public Integer getItemid() {
        return itemid;
    }

    public void setItemid(Integer itemid) {
        this.itemid = itemid;
    }

    @Basic
    @Column(name = "ingredientid")
    public Integer getIngredientid() {
        return ingredientid;
    }

    public void setIngredientid(Integer ingredientid) {
        this.ingredientid = ingredientid;
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

        KofeItemIngredients that = (KofeItemIngredients) o;

        if (id != that.id) return false;
        if (itemid != null ? !itemid.equals(that.itemid) : that.itemid != null) return false;
        if (ingredientid != null ? !ingredientid.equals(that.ingredientid) : that.ingredientid != null) return false;
        if (amount != null ? !amount.equals(that.amount) : that.amount != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (itemid != null ? itemid.hashCode() : 0);
        result = 31 * result + (ingredientid != null ? ingredientid.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        return result;
    }
}
