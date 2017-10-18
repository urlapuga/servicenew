package com.websystique.springmvc.model;

import javax.persistence.*;
import java.sql.Timestamp;


@NamedQueries({
        @NamedQuery(
                name = "managerTasks",
                query = "from Tasks s where s.type = 5"
        ),
        @NamedQuery(
                name = "technicianTasks",
                query = "from Tasks s where s.type = 1 OR s.type = 2"
        ),

        @NamedQuery(
                name = "byemployeeTasks",
                query = "from Tasks s where s.employeeTaskTo = :employeeId"
        ),
        @NamedQuery(
                name = "byCompany",
                query = "from Tasks s where s.company = :companyId"
        ),

        @NamedQuery(
                name = "bySubscriber",
                query = "from Tasks s where s.subscriberId = :subscriberId"
        )
})
@Entity
@Table(name = "tasks")
public class Tasks {
    private Integer id;
    private String text;
    private Integer employee;
    private Integer employeeTaskTo;
    private Integer status;
    private Employees employeesByEmployee;
    private Employees employeesByEmployeeTaskTo;
    private TaskStatus taskStatusByStatus;
    private Integer type;
    private Timestamp datecreated;
    private String dateto;
    private Timestamp dateactionperformed;
    private Integer company;
    private Integer subscriberId;

    @Basic
    @Column(name = "subscriber")
    public Integer getSubscriberId() {
        return subscriberId;
    }

    public void setSubscriberId(Integer subscriberId) {
        this.subscriberId = subscriberId;
    }

    @Basic
    @Column(name = "company")
    public Integer getCompany() {
        return company;
    }

    public void setCompany(Integer company) {
        this.company = company;
    }

    @Basic
    @Column(name = "type")
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Tasks(String text) {
        this.text = text;
    }

    public Tasks() {
        this.status  = 0;
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
    @Column(name = "text", nullable = true, length = 200)
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Basic
    @Column(name = "employee", nullable = true)
    public Integer getEmployee() {
        return employee;
    }

    public void setEmployee(Integer employee) {
        this.employee = employee;
    }

    @Basic
    @Column(name = "employee_task_to", nullable = true)
    public Integer getEmployeeTaskTo() {
        return employeeTaskTo;
    }

    public void setEmployeeTaskTo(Integer employeeTaskTo) {
        this.employeeTaskTo = employeeTaskTo;
    }

    @Basic
    @Column(name = "status", nullable = true)
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    @Basic
    @Column(name = "datecreated")
    public Timestamp getDatecreated() {
        return datecreated;
    }

    public void setDatecreated(Timestamp datecreated) {
        this.datecreated = datecreated;
    }
    @Basic
    @Column(name = "dateto")
    public String getDateto() {
        return dateto;
    }

    public void setDateto(String dateto) {
        this.dateto = dateto;
    }
    @Basic
    @Column(name = "dateactionperformed")
    public Timestamp getDateactionperformed() {
        return dateactionperformed;
    }

    public void setDateactionperformed(Timestamp dateactionperformed) {
        this.dateactionperformed = dateactionperformed;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tasks tasks = (Tasks) o;

        if (id != null ? !id.equals(tasks.id) : tasks.id != null) return false;
        if (text != null ? !text.equals(tasks.text) : tasks.text != null) return false;
        if (employee != null ? !employee.equals(tasks.employee) : tasks.employee != null) return false;
        if (employeeTaskTo != null ? !employeeTaskTo.equals(tasks.employeeTaskTo) : tasks.employeeTaskTo != null)
            return false;
        if (status != null ? !status.equals(tasks.status) : tasks.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + (employee != null ? employee.hashCode() : 0);
        result = 31 * result + (employeeTaskTo != null ? employeeTaskTo.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "employee", referencedColumnName = "id", insertable = false, updatable = false)
    public Employees getEmployeesByEmployee() {
        return employeesByEmployee;
    }

    public void setEmployeesByEmployee(Employees employeesByEmployee) {
        this.employeesByEmployee = employeesByEmployee;
    }

    @ManyToOne
    @JoinColumn(name = "employee_task_to", referencedColumnName = "id", insertable = false, updatable = false)
    public Employees getEmployeesByEmployeeTaskTo() {
        return employeesByEmployeeTaskTo;
    }

    public void setEmployeesByEmployeeTaskTo(Employees employeesByEmployeeTaskTo) {
        this.employeesByEmployeeTaskTo = employeesByEmployeeTaskTo;
    }

    @ManyToOne
    @JoinColumn(name = "status", referencedColumnName = "id", insertable = false, updatable = false)
    public TaskStatus getTaskStatusByStatus() {
        return taskStatusByStatus;
    }

    public void setTaskStatusByStatus(TaskStatus taskStatusByStatus) {
        this.taskStatusByStatus = taskStatusByStatus;
    }

    @Override
    public String toString() {
        return "Tasks{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", employee=" + employee +
                ", employeeTaskTo=" + employeeTaskTo +
                ", status=" + status +
                ", employeesByEmployee=" + employeesByEmployee +
                ", employeesByEmployeeTaskTo=" + employeesByEmployeeTaskTo +
                ", taskStatusByStatus=" + taskStatusByStatus +
                ", type=" + type +
                ", datecreated=" + datecreated +
                ", dateto='" + dateto + '\'' +
                ", dateactionperformed=" + dateactionperformed +
                ", company=" + company +
                ", subscriberId=" + subscriberId +
                '}';
    }
}
