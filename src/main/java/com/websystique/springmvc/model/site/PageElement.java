package com.websystique.springmvc.model.site;

import javax.persistence.*;

@Entity
@Table(name = "page_element", schema = "service")
public class PageElement {
    private int pageId;
    private Integer elementId;
    private SitePages sitePagesByPageId;
    private SiteElements siteElementsByElementId;

    @Id
    @Column(name = "page_id", nullable = false)
    public int getPageId() {
        return pageId;
    }

    public void setPageId(int pageId) {
        this.pageId = pageId;
    }

    @Basic
    @Column(name = "element_id", nullable = true)
    public Integer getElementId() {
        return elementId;
    }

    public void setElementId(Integer elementId) {
        this.elementId = elementId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PageElement that = (PageElement) o;

        if (pageId != that.pageId) return false;
        if (elementId != null ? !elementId.equals(that.elementId) : that.elementId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = pageId;
        result = 31 * result + (elementId != null ? elementId.hashCode() : 0);
        return result;
    }

    @OneToOne
    @JoinColumn(name = "page_id", referencedColumnName = "id", nullable = false)
    public SitePages getSitePagesByPageId() {
        return sitePagesByPageId;
    }

    public void setSitePagesByPageId(SitePages sitePagesByPageId) {
        this.sitePagesByPageId = sitePagesByPageId;
    }

    @ManyToOne
    @JoinColumn(name = "element_id", referencedColumnName = "id", insertable = false, updatable = false)
    public SiteElements getSiteElementsByElementId() {
        return siteElementsByElementId;
    }

    public void setSiteElementsByElementId(SiteElements siteElementsByElementId) {
        this.siteElementsByElementId = siteElementsByElementId;
    }

    @Override
    public String toString() {
        return "PageElement{" +
                "pageId=" + pageId +
                ", elementId=" + elementId +
                ", siteElementsByElementId=" + siteElementsByElementId +
                '}';
    }
}
