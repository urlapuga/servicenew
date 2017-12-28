package com.websystique.springmvc.model.kofe;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "kofe_additions", schema = "service")
public class KofeAdditions {

    @Id
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "name")
    private String name;

   @ManyToMany
   @JoinTable(name = "kofe_additions_items",
            joinColumns = {@JoinColumn(name = "addition")},
            inverseJoinColumns = {@JoinColumn(name = "item")})
    private List<KofeItems> itemsList = new ArrayList<>();


    public List<KofeItems> getItemsList() {
        return itemsList;
    }

    public void setItemsList(List<KofeItems> itemsList) {
        this.itemsList = itemsList;
    }

    public KofeAdditions(String name) {
        this.name = name;
    }

    public KofeAdditions() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

        KofeAdditions that = (KofeAdditions) o;

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
        return "KofeAdditions{" +
                "id=" + id +
                ", name='" + name + '\'' + itemsList+
                '}';
    }
}
