package com.websystique.springmvc.model.kofe;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "kofe_additions", schema = "service")
public class KofeAdditions {

    private List<KofeItems> itemsList;
    private int id;
    private String name;

    public KofeAdditions(String name) {
        this.name = name;
    }

    public KofeAdditions() {
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
                ", name='" + name + '\'' +
                '}';
    }
}
