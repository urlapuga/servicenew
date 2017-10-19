package com.websystique.springmvc.model.site;

import javax.persistence.*;

@Entity
@Table(name = "site_texts", schema = "service", catalog = "")
public class SiteTexts {
    private int id;
    private Integer langId;
    private Integer textId;
    private String text;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "lang_id", nullable = true)
    public Integer getLangId() {
        return langId;
    }

    public void setLangId(Integer langId) {
        this.langId = langId;
    }

    @Basic
    @Column(name = "text_id", nullable = true)
    public Integer getTextId() {
        return textId;
    }

    public void setTextId(Integer textId) {
        this.textId = textId;
    }

    @Basic
    @Column(name = "text", nullable = true, length = 255)
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SiteTexts siteTexts = (SiteTexts) o;

        if (id != siteTexts.id) return false;
        if (langId != null ? !langId.equals(siteTexts.langId) : siteTexts.langId != null) return false;
        if (textId != null ? !textId.equals(siteTexts.textId) : siteTexts.textId != null) return false;
        if (text != null ? !text.equals(siteTexts.text) : siteTexts.text != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (langId != null ? langId.hashCode() : 0);
        result = 31 * result + (textId != null ? textId.hashCode() : 0);
        result = 31 * result + (text != null ? text.hashCode() : 0);
        return result;
    }
}
