package com.websystique.springmvc.model.kofe;

import javax.persistence.*;

@NamedQueries(value = {
        @NamedQuery(name="getIngredientsByItem",query = "from KofeItemIngredientsView k where k.itemid =:itemId")
})

@Entity
@Table(name = "kofe_item_ingredients_view", schema = "service", catalog = "")
public class KofeItemIngredientsView {
    public KofeItemIngredientsView() {
    }
    @Id
    @Column(name = "itemid",insertable = false,updatable = false)
    private int itemid;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "ingredientid")
    private Integer ingredientid;
    @Basic
    @Column(name = "ingredientname")
    private String ingredientname;
    @Basic
    @Column(name = "amount")
    private Double amount;
    @Column(name = "buycost")
    private Double buycost;
    @Column(name = "thiscost")
    private Double thiscost;

    @ManyToOne
    @JoinColumn(name="itemid", nullable=false,insertable = false,updatable = false)
    KofeItems kofeItems;

    public Double getBuycost() {
        return buycost;
    }

    public void setBuycost(Double buycost) {
        this.buycost = buycost;
    }


    public Double getThiscost() {
        return thiscost;
    }

    public void setThiscost(Double thiscost) {
        this.thiscost = thiscost;
    }


    public int getItemid() {
        return itemid;
    }

    public void setItemid(int itemid) {
        this.itemid = itemid;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIngredientid() {
        return ingredientid;
    }

    public void setIngredientid(Integer ingredientid) {
        this.ingredientid = ingredientid;
    }


    public String getIngredientname() {
        return ingredientname;
    }

    public void setIngredientname(String ingredientname) {
        this.ingredientname = ingredientname;
    }


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
