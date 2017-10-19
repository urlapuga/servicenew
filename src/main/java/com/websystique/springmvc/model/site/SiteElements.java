package com.websystique.springmvc.model.site;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "site_elements", schema = "service", catalog = "")
public class SiteElements {
    private int id;
    private String name;
    private String html;
    private String includes;
    private Collection<PageElement> pageElementsById;

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
    @Column(name = "html", nullable = true, length = 255)
    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    @Basic
    @Column(name = "includes", nullable = true, length = 255)
    public String getIncludes() {
        return includes;
    }

    public void setIncludes(String includes) {
        this.includes = includes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SiteElements that = (SiteElements) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (html != null ? !html.equals(that.html) : that.html != null) return false;
        if (includes != null ? !includes.equals(that.includes) : that.includes != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (html != null ? html.hashCode() : 0);
        result = 31 * result + (includes != null ? includes.hashCode() : 0);
        return result;
    }

    @OneToMany(fetch=FetchType.EAGER,mappedBy = "siteElementsByElementId", cascade = CascadeType.ALL)
    public Collection<PageElement> getPageElementsById() {
        return pageElementsById;
    }

    public void setPageElementsById(Collection<PageElement> pageElementsById) {
        this.pageElementsById = pageElementsById;
    }

    @Override
    public String toString() {
        return "SiteElements{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", html='" + html + '\'' +
                ", includes='" + includes + '\'';
    }
}
