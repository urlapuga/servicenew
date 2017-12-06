package com.websystique.springmvc.model.kofe;

import javax.persistence.*;

@Entity
@Table(name = "kofe_additions_items", schema = "service")
public class KofeAdditionsItems {
    private int id;
    private Integer item;
    private Integer addition;

    public KofeAdditionsItems(Integer id, Integer additionId) {
        this.item = id;
        this.addition = additionId;
    }

    public KofeAdditionsItems() {
    }

    @Column(name = "addition")
    public Integer getAddition() {
        return addition;
    }

    public void setAddition(Integer addition) {
        this.addition = addition;
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
    @Column(name = "item")
    public Integer getItem() {
        return item;
    }

    public void setItem(Integer item) {
        this.item = item;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        KofeAdditionsItems that = (KofeAdditionsItems) o;

        if (id != that.id) return false;
        if (item != null ? !item.equals(that.item) : that.item != null) return false;
        return addition != null ? addition.equals(that.addition) : that.addition == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (item != null ? item.hashCode() : 0);
        result = 31 * result + (addition != null ? addition.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "KofeAdditionsItems{" +
                "id=" + id +
                ", item=" + item +
                ", addition=" + addition +
                '}';
    }
}
