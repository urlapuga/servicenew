package com.websystique.springmvc.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "companies")
public class Companies {
    private Integer id;
    private String name;
    private Collection<Employees> employeesById;

    public Companies() {
    }

    public Companies(String name) {
        this.name = name;
    }

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

        Companies companies = (Companies) o;

        if (id != null ? !id.equals(companies.id) : companies.id != null) return false;
        if (name != null ? !name.equals(companies.name) : companies.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "companiesByCompanyId")
    public Collection<Employees> getEmployeesById() {
        return employeesById;
    }

    public void setEmployeesById(Collection<Employees> employeesById) {
        this.employeesById = employeesById;
    }
}
