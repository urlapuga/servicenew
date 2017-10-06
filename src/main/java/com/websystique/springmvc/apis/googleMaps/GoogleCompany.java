package com.websystique.springmvc.apis.googleMaps;

public class GoogleCompany {
    private String name;
    private String website;
    private String adress;
    private String googleId;
    private String icon = "";

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getGoogleId() {
        return googleId;
    }

    public void setGoogleId(String googleId) {
        this.googleId = googleId;
    }

    @Override
    public String toString() {
        return "GoogleCompany{" +
                "name='" + name + '\'' +
                ", website='" + website + '\'' +
                ", adress='" + adress + '\'' +
                ", googleId='" + googleId + '\'' +
                ", icon='" + icon + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public String getAdress() {

        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getWebsite() {

        return website;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    private String phone;
}
