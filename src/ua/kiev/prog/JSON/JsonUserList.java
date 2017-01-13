package ua.kiev.prog.JSON;

import ua.kiev.prog.Entities.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by smith on 21.12.16.
 */
public class JsonUserList {
    private final List<User> list;

    public JsonUserList(List<User> sourceList) {
        this.list = new ArrayList<>();
        for (User u : sourceList) {
            this.list.add(u);
        }
    }
}
