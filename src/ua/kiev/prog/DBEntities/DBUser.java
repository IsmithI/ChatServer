package ua.kiev.prog.DBEntities;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ua.kiev.prog.Entities.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by smith on 08.01.17.
 */
@Entity
@Table(name = "DBUsers")
@NamedQuery(name = "DBUser.getAll", query = "SELECT u FROM DBUser u")
public class DBUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "login")
    private String login;
    private String password;

    @ManyToMany(mappedBy = "users", cascade = CascadeType.ALL)
    List<DBRoom> rooms = new ArrayList<>();

    public DBUser() {}

    public DBUser(String login, String password) {
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
}
