package ua.kiev.prog.DBEntities;

import ua.kiev.prog.Entities.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by smith on 08.01.17.
 */
@Entity
@Table(name = "DBRooms")
public class DBRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @OneToMany(mappedBy = "roomMessages", cascade = CascadeType.ALL)
    private List<DBMessage> messages = new LinkedList<>();

    @ManyToMany
    @JoinTable(
            name = "RoomUsers",
            joinColumns = {@JoinColumn(name = "room_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")}
    )
    List<DBUser> users = new ArrayList<>();

    private String roomName;

    public DBRoom() {}

    public DBRoom(String roomName) {
        this.roomName = roomName;
    }

    public DBRoom(String roomName, List<User> users) {
        this.roomName = roomName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }
}
