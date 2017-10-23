package com.websystique.springmvc.model.site;

import javax.persistence.*;
import java.sql.Timestamp;

@NamedQueries(value = {
        @NamedQuery(name = "getHeatMapBySite",query = "from SiteHeatMaps sh where sh.site=:siteId")
})

@Entity
@Table(name = "site_heatmaps", schema = "service")
public class SiteHeatMaps {
    private int id;
    private Timestamp date;
    private Integer site;
    private String heat;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "date", nullable = true)
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Basic
    @Column(name = "site", nullable = true)
    public Integer getSite() {
        return site;
    }

    public void setSite(Integer site) {
        this.site = site;
    }

    @Basic
    @Column(name = "heat", nullable = true, length = 1000)
    public String getHeat() {
        return heat;
    }

    public void setHeat(String heat) {
        this.heat = heat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SiteHeatMaps that = (SiteHeatMaps) o;

        if (id != that.id) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (site != null ? !site.equals(that.site) : that.site != null) return false;
        if (heat != null ? !heat.equals(that.heat) : that.heat != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (site != null ? site.hashCode() : 0);
        result = 31 * result + (heat != null ? heat.hashCode() : 0);
        return result;
    }
}
