package ua.kiev.prog.Entities;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by smith on 18.12.16.
 */
public class User {

    private String login, password;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String toJSON() {
        Gson gson = new GsonBuilder().create();
        return gson.toJson(this);
    }

    public static User fromJSON(String s) {
        Gson gson = new GsonBuilder().create();
        return gson.fromJson(s, User.class);
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
