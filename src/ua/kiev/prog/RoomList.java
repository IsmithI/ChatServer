package ua.kiev.prog;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ua.kiev.prog.Entities.Room;
import ua.kiev.prog.JSON.JsonRoomList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by smith on 23.12.16.
 */
public class RoomList {

    private static final RoomList roomList = new RoomList();

    private final Gson gson;
    private final List<Room> list = new ArrayList<>();

    private RoomList() {
        gson = new GsonBuilder().create();
    }

    public synchronized String toJSON() {
        return gson.toJson(new JsonRoomList(list));
    }

    public static RoomList getInstance() {
        return roomList;
    }
}
