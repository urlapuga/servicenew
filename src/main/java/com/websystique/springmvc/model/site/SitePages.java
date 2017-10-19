package com.websystique.springmvc.model.site;


import javax.persistence.*;

@NamedQueries(value = {
        @NamedQuery(
                name = "getBySite",
                query = "from SitePages p where p.site = :siteId ORDER BY p.pagenumber asc"
        )
})

@Entity
@Table(name = "site_pages", schema = "service")
public class SitePages {
    private int id;
    private Integer site;
    private Integer pagenumber;
    private String text;
    private String name;
    private String anchor;
    private String background;
    private PageElement pageElementById;
    private SiteSite siteSiteBySite;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "anchor")
    public String getAnchor() {
        return anchor;
    }

    public void setAnchor(String anchor) {
        this.anchor = anchor;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    @Column(name = "pagenumber", nullable = true)
    public Integer getPagenumber() {
        return pagenumber;
    }

    public void setPagenumber(Integer pagenumber) {
        this.pagenumber = pagenumber;
    }

    @Basic
    @Column(name = "text", nullable = true, length = 255)
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Basic
    @Column(name = "background", nullable = true, length = 255)
    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SitePages sitePages = (SitePages) o;

        if (id != sitePages.id) return false;
        if (site != null ? !site.equals(sitePages.site) : sitePages.site != null) return false;
        if (pagenumber != null ? !pagenumber.equals(sitePages.pagenumber) : sitePages.pagenumber != null) return false;
        if (text != null ? !text.equals(sitePages.text) : sitePages.text != null) return false;
        if (background != null ? !background.equals(sitePages.background) : sitePages.background != null) return false;

        return true;
    }

    @OneToOne(mappedBy = "sitePagesByPageId")
    public PageElement getPageElementById() {
        return pageElementById;
    }

    public void setPageElementById(PageElement pageElementById) {
        this.pageElementById = pageElementById;
    }

    @ManyToOne
    @JoinColumn(name = "site", referencedColumnName = "id", updatable = false, insertable = false)
    public SiteSite getSiteSiteBySite() {
        return siteSiteBySite;
    }

    public void setSiteSiteBySite(SiteSite siteSiteBySite) {
        this.siteSiteBySite = siteSiteBySite;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (site != null ? site.hashCode() : 0);
        result = 31 * result + (pagenumber != null ? pagenumber.hashCode() : 0);
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + (background != null ? background.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "SitePages{" +
                "id=" + id +
                ", site=" + site +
                ", pagenumber=" + pagenumber +
                ", text='" + text + '\'' +
                ", background='" + background + '\'' +
                ", pageElementById=" + pageElementById;
    }
}
