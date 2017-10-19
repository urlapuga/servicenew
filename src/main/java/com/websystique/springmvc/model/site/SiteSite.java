package com.websystique.springmvc.model.site;


import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "site_site", schema = "service")
public class SiteSite {
    private int id;
    private String name;
    private Integer company;
    private String style;
    private String menustyle;
    private Integer menu;

    @Basic
    @Column(name = "menustyle")
    public String getMenustyle() {
        return menustyle;
    }

    public void setMenustyle(String menustyle) {
        this.menustyle = menustyle;
    }

    @Basic
    @Column(name = "style")
    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }
    @Basic
    @Column(name = "menu")
    public Integer getMenu() {
        return menu;
    }

    public void setMenu(Integer menu) {
        this.menu = menu;
    }

    private Collection<SitePages> sitePagesById;
    @Id
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

    @Basic
    @Column(name = "company", nullable = true)
    public Integer getCompany() {
        return company;
    }

    public void setCompany(Integer company) {
        this.company = company;
    }

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "siteSiteBySite", cascade = CascadeType.ALL)
    public Collection<SitePages> getSitePagesById() {
        return sitePagesById;
    }

    public void setSitePagesById(Collection<SitePages> sitePagesById) {
        this.sitePagesById = sitePagesById;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SiteSite siteSite = (SiteSite) o;

        if (id != siteSite.id) return false;
        if (name != null ? !name.equals(siteSite.name) : siteSite.name != null) return false;
        if (company != null ? !company.equals(siteSite.company) : siteSite.company != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (company != null ? company.hashCode() : 0);
        return result;
    }


    @Override
    public String toString() {
        return "SiteSite{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", company=" + company +
                ", sitePagesById=" + sitePagesById +
                "menu " + menu + "style " + style
                ;
    }
}
