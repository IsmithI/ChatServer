package ua.kiev.prog.JSON;

import ua.kiev.prog.Entities.Room;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by smith on 23.12.16.
 */
public class JsonRoomList {
    private final List<Room> list;

    public JsonRoomList(List<Room> sourceList) {
        list = new ArrayList<>();
        for (Room room : sourceList) {
            list.add(room);
        }
    }
}
