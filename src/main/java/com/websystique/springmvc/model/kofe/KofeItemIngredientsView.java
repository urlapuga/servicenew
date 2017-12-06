package com.websystique.springmvc.model.kofe;

import javax.persistence.*;

@NamedQueries(value = {
        @NamedQuery(name="getIngredientsByItem",query = "from KofeItemIngredientsView k where k.itemid =:itemId")
})

@Entity
@Table(name = "kofe_item_ingredients_view", schema = "service", catalog = "")
public class KofeItemIngredientsView {

    private int itemid;
    private String name;
    private Integer ingredientid;
    private String ingredientname;
    private Double amount;
    private Double buycost;

    @Column(name = "buycost")
    public Double getBuycost() {
        return buycost;
    }

    public void setBuycost(Double buycost) {
        this.buycost = buycost;
    }

    @Column(name = "thiscost")
    public Double getThiscost() {
        return thiscost;
    }

    public void setThiscost(Double thiscost) {
        this.thiscost = thiscost;
    }

    private Double thiscost;
    @Id
    @Column(name = "itemid")
    public int getItemid() {
        return itemid;
    }

    public void setItemid(int itemid) {
        this.itemid = itemid;
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
    @Column(name = "ingredientid")
    public Integer getIngredientid() {
        return ingredientid;
    }

    public void setIngredientid(Integer ingredientid) {
        this.ingredientid = ingredientid;
    }

    @Basic
    @Column(name = "ingredientname")
    public String getIngredientname() {
        return ingredientname;
    }

    public void setIngredientname(String ingredientname) {
        this.ingredientname = ingredientname;
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

        KofeItemIngredientsView that = (KofeItemIngredientsView) o;

        if (itemid != that.itemid) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (ingredientid != null ? !ingredientid.equals(that.ingredientid) : that.ingredientid != null) return false;
        if (ingredientname != null ? !ingredientname.equals(that.ingredientname) : that.ingredientname != null)
            return false;
        if (amount != null ? !amount.equals(that.amount) : that.amount != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = itemid;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (ingredientid != null ? ingredientid.hashCode() : 0);
        result = 31 * result + (ingredientname != null ? ingredientname.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        return result;
    }


    @Override
    public String toString() {
        return "KofeItemIngredientsView{" +
                "itemid=" + itemid +
                ", name='" + name + '\'' +
                ", ingredientid=" + ingredientid +
                ", ingredientname='" + ingredientname + '\'' +
                ", amount=" + amount +
                '}';
    }
}
