package com.websystique.springmvc.model.kofe;

import javax.persistence.*;

@NamedNativeQueries({
        @NamedNativeQuery(name = "addOrUpdate",query = "" +
                "INSERT INTO kofe_main_sklad (ingredient,amount) VALUES(:ingredient, :amount) ON DUPLICATE KEY UPDATE amount=amount+:amount")
})

@Entity
@Table(name = "kofe_main_sklad", schema = "service")
public class KofeMainSklad {
    private int id;
    private Integer ingredient;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        KofeMainSklad that = (KofeMainSklad) o;

        if (id != that.id) return false;
        if (ingredient != null ? !ingredient.equals(that.ingredient) : that.ingredient != null) return false;
        if (amount != null ? !amount.equals(that.amount) : that.amount != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (ingredient != null ? ingredient.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        return result;
    }
}
