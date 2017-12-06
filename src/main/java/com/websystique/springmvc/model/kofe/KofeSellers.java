package com.websystique.springmvc.model.kofe;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "kofe_sellers", schema = "service", catalog = "")
public class KofeSellers {
    private int id;
    private String name;
    private String address;
    private String phone;
    private String coment;
    private Collection<KofeIngredietSellerCost> kofeIngredietSellerCostsById;

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
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

        KofeSellers that = (KofeSellers) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (coment != null ? !coment.equals(that.coment) : that.coment != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (coment != null ? coment.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "kofeSellersBySeller")
    public Collection<KofeIngredietSellerCost> getKofeIngredietSellerCostsById() {
        return kofeIngredietSellerCostsById;
    }

    public void setKofeIngredietSellerCostsById(Collection<KofeIngredietSellerCost> kofeIngredietSellerCostsById) {
        this.kofeIngredietSellerCostsById = kofeIngredietSellerCostsById;
    }
}
