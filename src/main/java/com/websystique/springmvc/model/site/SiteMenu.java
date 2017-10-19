package com.websystique.springmvc.model.site;

import javax.persistence.*;

@Entity
@Table(name = "site_menu", schema = "service", catalog = "")
public class SiteMenu {
    private int id;
    private String name;
    private String link;

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
    @Column(name = "link", nullable = true, length = 255)
    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SiteMenu siteMenu = (SiteMenu) o;

        if (id != siteMenu.id) return false;
        if (name != null ? !name.equals(siteMenu.name) : siteMenu.name != null) return false;
        if (link != null ? !link.equals(siteMenu.link) : siteMenu.link != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (link != null ? link.hashCode() : 0);
        return result;
    }
}
