package com.websystique.springmvc.model.chat;

import javax.persistence.*;
import java.sql.Timestamp;
@NamedQueries(value = {
        @NamedQuery(
                name = "getByRoom",
                query = "from ChatMessages m where m.room = :room ORDER BY m.timecreated asc"
        ),
        @NamedQuery(
                name = "getByUser",
                query = "from ChatMessages m where (m.fromuser = :user1 and m.touser = :user2) or(m.fromuser = :user2 and m.touser = :user1) ORDER BY m.timecreated asc"
        )
})
@Entity
@Table(name = "chat_messages", schema = "service")
public class ChatMessages {
    private int id;
    private Timestamp timecreated;
    private String text;
    private Integer fromuser;
    private Integer touser;
    private String image;
    private Integer room;

    public ChatMessages() {
    }

    public ChatMessages(String text, Integer fromuser, Integer touser, Integer room) {
        this.text = text;
        this.fromuser = fromuser;
        this.touser = touser;
        this.room = room;
    }

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "timecreated", nullable = true)
    public Timestamp getTimecreated() {
        return timecreated;
    }

    public void setTimecreated(Timestamp timestamp) {
        this.timecreated = timestamp;
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
    @Column(name = "fromuser", nullable = true)
    public Integer getFromuser() {
        return fromuser;
    }

    public void setFromuser(Integer from) {
        this.fromuser = from;
    }

    @Basic
    @Column(name = "touser", nullable = true)
    public Integer getTouser() {
        return touser;
    }

    public void setTouser(Integer to) {
        this.touser = to;
    }

    @Basic
    @Column(name = "image", nullable = true, length = 255)
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Basic
    @Column(name = "room", nullable = true)
    public Integer getRoom() {
        return room;
    }

    public void setRoom(Integer room) {
        this.room = room;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ChatMessages that = (ChatMessages) o;

        if (id != that.id) return false;
        if (timecreated != null ? !timecreated.equals(that.timecreated) : that.timecreated != null) return false;
        if (text != null ? !text.equals(that.text) : that.text != null) return false;
        if (fromuser != null ? !fromuser.equals(that.fromuser) : that.fromuser != null) return false;
        if (touser != null ? !touser.equals(that.touser) : that.touser != null) return false;
        if (image != null ? !image.equals(that.image) : that.image != null) return false;
        if (room != null ? !room.equals(that.room) : that.room != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (timecreated != null ? timecreated.hashCode() : 0);
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + (fromuser != null ? fromuser.hashCode() : 0);
        result = 31 * result + (touser != null ? touser.hashCode() : 0);
        result = 31 * result + (image != null ? image.hashCode() : 0);
        result = 31 * result + (room != null ? room.hashCode() : 0);
        return result;
    }
}
