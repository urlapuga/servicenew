package com.websystique.springmvc.model.kofe;

import javax.persistence.*;

@NamedQueries(value = {
        @NamedQuery(name= "getitemsbyaddition" ,query = "from KofeAddItemView k where k.addition = :additionId")
})

@Entity
@Table(name = "kofe_add_item_view", schema = "service")
public class KofeAddItemView {
    private int id;
    private Integer addition;
    private Integer item;
    private String name;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "addition")
    public Integer getAddition() {
        return addition;
    }

    public void setAddition(Integer addition) {
        this.addition = addition;
    }

    @Basic
    @Column(name = "item")
    public Integer getItem() {
        return item;
    }

    public void setItem(Integer item) {
        this.item = item;
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

        KofeAddItemView that = (KofeAddItemView) o;

        if (id != that.id) return false;
        if (addition != null ? !addition.equals(that.addition) : that.addition != null) return false;
        if (item != null ? !item.equals(that.item) : that.item != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (addition != null ? addition.hashCode() : 0);
        result = 31 * result + (item != null ? item.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "KofeAddItemView{" +
                "id=" + id +
                ", addition=" + addition +
                ", item=" + item +
                ", name='" + name + '\'' +
                '}';
    }
}
