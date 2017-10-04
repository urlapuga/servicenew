package com.websystique.springmvc.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name="employees")
public class Employees {
    private Integer id;
    private String name;
    private String lastname;
    private String phonenumber;
    private String email;
    private Integer companyId;
    private Integer positionId;
    private String login;
    private String password;
    private Companies companiesByCompanyId;
    private Positions positionsByPositionId;
    private Collection<Tasks> tasksById;
    private Collection<Tasks> tasksById_0;

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

    @Basic
    @Column(name = "lastname", nullable = true, length = 0)
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Basic
    @Column(name = "phonenumber", nullable = true, length = 0)
    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    @Basic
    @Column(name = "email", nullable = true, length = 0)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "company_id", nullable = true)
    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    @Basic
    @Column(name = "position_id", nullable = true)
    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    @Basic
    @Column(name = "login", nullable = true, length = 0)
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Basic
    @Column(name = "password", nullable = true, length = 0)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employees employees = (Employees) o;

        if (id != null ? !id.equals(employees.id) : employees.id != null) return false;
        if (name != null ? !name.equals(employees.name) : employees.name != null) return false;
        if (lastname != null ? !lastname.equals(employees.lastname) : employees.lastname != null) return false;
        if (phonenumber != null ? !phonenumber.equals(employees.phonenumber) : employees.phonenumber != null)
            return false;
        if (email != null ? !email.equals(employees.email) : employees.email != null) return false;
        if (companyId != null ? !companyId.equals(employees.companyId) : employees.companyId != null) return false;
        if (positionId != null ? !positionId.equals(employees.positionId) : employees.positionId != null) return false;
        if (login != null ? !login.equals(employees.login) : employees.login != null) return false;
        if (password != null ? !password.equals(employees.password) : employees.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        result = 31 * result + (phonenumber != null ? phonenumber.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (companyId != null ? companyId.hashCode() : 0);
        result = 31 * result + (positionId != null ? positionId.hashCode() : 0);
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "company_id", referencedColumnName = "id", insertable = false, updatable = false)
    public Companies getCompaniesByCompanyId() {
        return companiesByCompanyId;
    }

    public void setCompaniesByCompanyId(Companies companiesByCompanyId) {
        this.companiesByCompanyId = companiesByCompanyId;
    }

    @ManyToOne
    @JoinColumn(name = "position_id", referencedColumnName = "id", insertable = false, updatable = false)
    public Positions getPositionsByPositionId() {
        return positionsByPositionId;
    }

    public void setPositionsByPositionId(Positions positionsByPositionId) {
        this.positionsByPositionId = positionsByPositionId;
    }

    @OneToMany(mappedBy = "employeesByEmployee")
    public Collection<Tasks> getTasksById() {
        return tasksById;
    }

    public void setTasksById(Collection<Tasks> tasksById) {
        this.tasksById = tasksById;
    }

    @OneToMany(mappedBy = "employeesByEmployeeTaskTo")
    public Collection<Tasks> getTasksById_0() {
        return tasksById_0;
    }

    public void setTasksById_0(Collection<Tasks> tasksById_0) {
        this.tasksById_0 = tasksById_0;
    }
}
