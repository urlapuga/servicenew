package com.websystique.springmvc.model.kofe;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "kofe_ingrediet_seller_cost", schema = "service", catalog = "")
public class KofeIngredietSellerCost {
    private int id;
    private Integer ingredient;
    private BigDecimal cost;
    private Integer seller;
    private String coment;
    private KofeIngredients kofeIngredientsByIngredient;
    private KofeSellers kofeSellersBySeller;

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
    @Column(name = "cost")
    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    @Basic
    @Column(name = "seller")
    public Integer getSeller() {
        return seller;
    }

    public void setSeller(Integer seller) {
        this.seller = seller;
    }

    @Basic
    @Column(name = "coment")
    public String getComent() {
        return coment;
    }

    public void setComent(String coment) {
        this.coment = coment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        KofeIngredietSellerCost that = (KofeIngredietSellerCost) o;

        if (id != that.id) return false;
        if (ingredient != null ? !ingredient.equals(that.ingredient) : that.ingredient != null) return false;
        if (cost != null ? !cost.equals(that.cost) : that.cost != null) return false;
        if (seller != null ? !seller.equals(that.seller) : that.seller != null) return false;
        if (coment != null ? !coment.equals(that.coment) : that.coment != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (ingredient != null ? ingredient.hashCode() : 0);
        result = 31 * result + (cost != null ? cost.hashCode() : 0);
        result = 31 * result + (seller != null ? seller.hashCode() : 0);
        result = 31 * result + (coment != null ? coment.hashCode() : 0);
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
    @JoinColumn(name = "seller", referencedColumnName = "id", insertable=false,updatable = false)
    public KofeSellers getKofeSellersBySeller() {
        return kofeSellersBySeller;
    }

    public void setKofeSellersBySeller(KofeSellers kofeSellersBySeller) {
        this.kofeSellersBySeller = kofeSellersBySeller;
    }
}
