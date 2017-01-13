package ua.kiev.prog;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ua.kiev.prog.Entities.User;
import ua.kiev.prog.JSON.JsonUserList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by smith on 18.12.16.
 */
public class UserList {

    private final Gson gson;
    private static final UserList userList = new UserList();
    private final List<User> list = new ArrayList<>();

    private UserList() {
        gson = new GsonBuilder().create();
    }

    public static UserList getInstance() {
        return userList;
    }

    public synchronized String toJSON() {
        return gson.toJson(new JsonUserList(list));
    }

    public synchronized void add(User u) {
        list.add(u);
    }
}
