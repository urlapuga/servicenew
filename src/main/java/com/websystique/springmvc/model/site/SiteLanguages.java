package com.websystique.springmvc.model.site;

import javax.persistence.*;

@Entity
@Table(name = "site_languages", schema = "service", catalog = "")
public class SiteLanguages {
    private int id;
    private String lang;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "lang", nullable = true, length = 255)
    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SiteLanguages that = (SiteLanguages) o;

        if (id != that.id) return false;
        if (lang != null ? !lang.equals(that.lang) : that.lang != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (lang != null ? lang.hashCode() : 0);
        return result;
    }
}
