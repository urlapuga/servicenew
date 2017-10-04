package com.websystique.springmvc.model;

import javax.persistence.*;

@Entity
@Table(name = "task_type", schema = "service", catalog = "")
public class TaskType {
    private int id;
    private String name;

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 255)
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

        TaskType taskType = (TaskType) o;

        if (id != taskType.id) return false;
        if (name != null ? !name.equals(taskType.name) : taskType.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
