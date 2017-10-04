package com.websystique.springmvc.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "ip_type", schema = "service")
public class IpType {
    private Integer id;
    private String name;
    private Collection<Subscribers> subscribersById;

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

        IpType ipType = (IpType) o;

        if (id != null ? !id.equals(ipType.id) : ipType.id != null) return false;
        if (name != null ? !name.equals(ipType.name) : ipType.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "ipTypeByIptype")
    public Collection<Subscribers> getSubscribersById() {
        return subscribersById;
    }

    public void setSubscribersById(Collection<Subscribers> subscribersById) {
        this.subscribersById = subscribersById;
    }
}
