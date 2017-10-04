package com.websystique.springmvc.model.address;

import javax.persistence.*;

@Entity
@Table(name = "addr_adress", schema = "service", catalog = "")
public class AddrAdress {
    private int id;
    private String building;
    private String room;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "building", nullable = true, length = 255)
    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    @Basic
    @Column(name = "room", nullable = true, length = 255)
    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AddrAdress that = (AddrAdress) o;

        if (id != that.id) return false;
        if (building != null ? !building.equals(that.building) : that.building != null) return false;
        if (room != null ? !room.equals(that.room) : that.room != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (building != null ? building.hashCode() : 0);
        result = 31 * result + (room != null ? room.hashCode() : 0);
        return result;
    }
}
