package com.websystique.springmvc.model.site;

import javax.persistence.*;

@Entity
@Table(name = "site_textids", schema = "service", catalog = "")
public class SiteTextids {
    private int id;
    private String type;
    private Integer textid;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "type", nullable = true, length = 255)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "textid", nullable = true)
    public Integer getTextid() {
        return textid;
    }

    public void setTextid(Integer textid) {
        this.textid = textid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SiteTextids that = (SiteTextids) o;

        if (id != that.id) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (textid != null ? !textid.equals(that.textid) : that.textid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (textid != null ? textid.hashCode() : 0);
        return result;
    }
}
