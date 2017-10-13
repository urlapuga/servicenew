package com.websystique.springmvc.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "potential_clients", schema = "service", catalog = "")
public class PotentialClients {
    private Integer id;
    private String name;
    private Timestamp dateCreated;
    private Timestamp dateDone;
    private Integer doneBy;
    private Integer adress;
    private String phone;

    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 30)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "date_created", nullable = false)
    public Timestamp getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Timestamp dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Basic
    @Column(name = "date_done", nullable = false)
    public Timestamp getDateDone() {
        return dateDone;
    }

    public void setDateDone(Timestamp dateDone) {
        this.dateDone = dateDone;
    }

    @Basic
    @Column(name = "done_by", nullable = true)
    public Integer getDoneBy() {
        return doneBy;
    }

    public void setDoneBy(Integer doneBy) {
        this.doneBy = doneBy;
    }

    @Basic
    @Column(name = "adress", nullable = true)
    public Integer getAdress() {
        return adress;
    }

    public void setAdress(Integer adress) {
        this.adress = adress;
    }

    @Basic
    @Column(name = "phone", nullable = true, length = 30)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PotentialClients that = (PotentialClients) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (dateCreated != null ? !dateCreated.equals(that.dateCreated) : that.dateCreated != null) return false;
        if (dateDone != null ? !dateDone.equals(that.dateDone) : that.dateDone != null) return false;
        if (doneBy != null ? !doneBy.equals(that.doneBy) : that.doneBy != null) return false;
        if (adress != null ? !adress.equals(that.adress) : that.adress != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (dateCreated != null ? dateCreated.hashCode() : 0);
        result = 31 * result + (dateDone != null ? dateDone.hashCode() : 0);
        result = 31 * result + (doneBy != null ? doneBy.hashCode() : 0);
        result = 31 * result + (adress != null ? adress.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PotentialClients{" +
                "name='" + name + '\'' +
                ", dateCreated=" + dateCreated +
                ", dateDone=" + dateDone +
                ", doneBy=" + doneBy +
                ", adress=" + adress +
                ", phone='" + phone + '\'' +
                '}';
    }
}
