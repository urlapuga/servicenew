package com.websystique.springmvc.model.address;

import javax.persistence.*;

@NamedQueries(value = {
        @NamedQuery(name = "byStreet",query = "from AddrBuildings b where b.street=:streetId")
})

@Entity
@Table(name = "addr_buildings", schema = "service")
public class AddrBuildings {
    private int id;
    private String number;
    private Integer street;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "number", nullable = true, length = 10)
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Basic
    @Column(name = "street", nullable = true)
    public Integer getStreet() {
        return street;
    }

    public void setStreet(Integer street) {
        this.street = street;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AddrBuildings that = (AddrBuildings) o;

        if (id != that.id) return false;
        if (number != null ? !number.equals(that.number) : that.number != null) return false;
        if (street != null ? !street.equals(that.street) : that.street != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (street != null ? street.hashCode() : 0);
        return result;
    }
}
