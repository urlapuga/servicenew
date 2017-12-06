package com.websystique.springmvc.model.kofe;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "kofe_ingredients", schema = "service")
public class KofeIngredients {
    private int id;
    private String name;
    private Integer kilos;
    private Double buycost;
    private Collection<KofeIngredietSellerCost> kofeIngredietSellerCostsById;
    private Collection<KofeSklad> kofeSkladsById;
    private Collection<KofeZayavki> kofeZayavkisById;

    public KofeIngredients(String name) {
        this.name = name;
    }

    public KofeIngredients() {
    }

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    @Column(name = "kilos")
    public Integer getKilos() {
        return kilos;
    }

    public void setKilos(Integer kilos) {
        this.kilos = kilos;
    }

    @Basic
    @Column(name = "buycost")
    public Double getBuycost() {
        return buycost;
    }

    public void setBuycost(Double buycost) {
        this.buycost = buycost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        KofeIngredients that = (KofeIngredients) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (kilos != null ? !kilos.equals(that.kilos) : that.kilos != null) return false;
        if (buycost != null ? !buycost.equals(that.buycost) : that.buycost != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (kilos != null ? kilos.hashCode() : 0);
        result = 31 * result + (buycost != null ? buycost.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "kofeIngredientsByIngredient")
    public Collection<KofeIngredietSellerCost> getKofeIngredietSellerCostsById() {
        return kofeIngredietSellerCostsById;
    }

    public void setKofeIngredietSellerCostsById(Collection<KofeIngredietSellerCost> kofeIngredietSellerCostsById) {
        this.kofeIngredietSellerCostsById = kofeIngredietSellerCostsById;
    }

    @OneToMany(mappedBy = "kofeIngredientsByIngredient")
    public Collection<KofeSklad> getKofeSkladsById() {
        return kofeSkladsById;
    }

    public void setKofeSkladsById(Collection<KofeSklad> kofeSkladsById) {
        this.kofeSkladsById = kofeSkladsById;
    }

    @OneToMany(mappedBy = "kofeIngredientsByIngredient")
    public Collection<KofeZayavki> getKofeZayavkisById() {
        return kofeZayavkisById;
    }

    public void setKofeZayavkisById(Collection<KofeZayavki> kofeZayavkisById) {
        this.kofeZayavkisById = kofeZayavkisById;
    }

    @Override
    public String toString() {
        return "KofeIngredients{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", kilos=" + kilos +
                ", buycost=" + buycost +
                '}';
    }
}
