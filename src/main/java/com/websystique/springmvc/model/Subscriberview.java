package com.websystique.springmvc.model;

import jdk.nashorn.internal.ir.annotations.Immutable;

import javax.persistence.*;

@NamedQueries(value = {
        @NamedQuery(name = "byCityId",query = "from Subscriberview s where s.city = :id"),
        @NamedQuery(name = "byStreetId",query = "from Subscriberview s where s.street = :id"),
        @NamedQuery(name = "byBuildingId",query = "from Subscriberview s where s.building = :id")
})

@Immutable
@Entity
@Table(name = "subscriberview")
public class Subscriberview {
    private int id;
    private String name;
    private String phone;
    private String ipaddress;
    private String cityname;
    private String streetname;
    private String number;
    private String room;
    private String tarif;
    private String statusname;
    private int city;
    private int street;
    private int building;

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 40)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "phone", nullable = true, length = 20)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "ipaddress", nullable = true, length = 20)
    public String getIpaddress() {
        return ipaddress;
    }

    public void setIpaddress(String ipaddress) {
        this.ipaddress = ipaddress;
    }

    @Basic
    @Column(name = "cityname", nullable = false, length = 255)
    public String getCityname() {
        return cityname;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname;
    }

    @Basic
    @Column(name = "streetname", nullable = true, length = 255)
    public String getStreetname() {
        return streetname;
    }

    public void setStreetname(String streetname) {
        this.streetname = streetname;
    }

    @Basic
    @Column(name = "number", nullable = true, length = 10)
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Basic
    @Column(name = "room", nullable = true, length = 255)
    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    @Basic
    @Column(name = "tarif", nullable = true, length = 255)
    public String getTarif() {
        return tarif;
    }

    public void setTarif(String tarif) {
        this.tarif = tarif;
    }

    @Basic
    @Column(name = "statusname", nullable = true, length = 10)
    public String getStatusname() {
        return statusname;
    }

    public void setStatusname(String statusname) {
        this.statusname = statusname;
    }

    @Basic
    @Column(name = "city", nullable = false)
    public int getCity() {
        return city;
    }

    public void setCity(int city) {
        this.city = city;
    }

    @Basic
    @Column(name = "street", nullable = false)
    public int getStreet() {
        return street;
    }

    public void setStreet(int street) {
        this.street = street;
    }

    @Basic
    @Column(name = "building", nullable = false)
    public int getBuilding() {
        return building;
    }

    public void setBuilding(int building) {
        this.building = building;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Subscriberview that = (Subscriberview) o;

        if (id != that.id) return false;
        if (city != that.city) return false;
        if (street != that.street) return false;
        if (building != that.building) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (ipaddress != null ? !ipaddress.equals(that.ipaddress) : that.ipaddress != null) return false;
        if (cityname != null ? !cityname.equals(that.cityname) : that.cityname != null) return false;
        if (streetname != null ? !streetname.equals(that.streetname) : that.streetname != null) return false;
        if (number != null ? !number.equals(that.number) : that.number != null) return false;
        if (room != null ? !room.equals(that.room) : that.room != null) return false;
        if (tarif != null ? !tarif.equals(that.tarif) : that.tarif != null) return false;
        if (statusname != null ? !statusname.equals(that.statusname) : that.statusname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (ipaddress != null ? ipaddress.hashCode() : 0);
        result = 31 * result + (cityname != null ? cityname.hashCode() : 0);
        result = 31 * result + (streetname != null ? streetname.hashCode() : 0);
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (room != null ? room.hashCode() : 0);
        result = 31 * result + (tarif != null ? tarif.hashCode() : 0);
        result = 31 * result + (statusname != null ? statusname.hashCode() : 0);
        result = 31 * result + city;
        result = 31 * result + street;
        result = 31 * result + building;
        return result;
    }
}
