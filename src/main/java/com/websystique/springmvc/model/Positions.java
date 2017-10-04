package com.websystique.springmvc.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name="positions")
public class Positions {
    private Integer id;
    private String name;
    private Collection<Employees> employeesById;

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 0)
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

        Positions positions = (Positions) o;

        if (id != null ? !id.equals(positions.id) : positions.id != null) return false;
        if (name != null ? !name.equals(positions.name) : positions.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "positionsByPositionId")
    public Collection<Employees> getEmployeesById() {
        return employeesById;
    }

    public void setEmployeesById(Collection<Employees> employeesById) {
        this.employeesById = employeesById;
    }
}
