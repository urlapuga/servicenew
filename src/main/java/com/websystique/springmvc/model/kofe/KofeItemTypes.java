package com.websystique.springmvc.model.kofe;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "kofe_item_types", schema = "service")
public class KofeItemTypes {
    private int id;
    private String name;

    @Transient
    private List<KofeItems> items = new ArrayList<>();

    public KofeItemTypes(String name) {
        this.name = name;
    }

    public KofeItemTypes() {
    }

    @Transient
    public List<KofeItems> getItems() {
        return items;
    }

    public void setItems(List<KofeItems> items) {
        this.items = items;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        KofeItemTypes that = (KofeItemTypes) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }


    @Override
    public String toString() {
        return "id=" + id +
                ", name='" + name + '\'';
    }
}
