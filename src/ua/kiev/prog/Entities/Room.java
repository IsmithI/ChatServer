package ua.kiev.prog.Entities;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by smith on 23.12.16.
 */
public class Room {

    private List<User> users;
    private List<Message> messages;
    private String roomName;

    public Room(String roomName) {
        this.roomName = roomName;
        users = new ArrayList<>();
        messages = new LinkedList<>();
    }

    public synchronized void addMessage(Message m) {
        messages.add(m);
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public synchronized void addUser(User u) {
        users.add(u);
    }

    public synchronized void removeUser(User u) {
        users.remove(u);
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public List<User> getUsers() {
        return users;
    }

    public String getRoomName() {
        return roomName;
    }
}
