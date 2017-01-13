package ua.kiev.prog.Servlets;

import ua.kiev.prog.DBEntities.*;
import ua.kiev.prog.Entities.User;
import ua.kiev.prog.UserList;
import ua.kiev.prog.Utils;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static ua.kiev.prog.Utils.requestBodyToArray;

/**
 * Created by smith on 21.12.16.
 */
public class AddUserServlet extends HttpServlet {

    private UserList list = UserList.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        byte[] buf = requestBodyToArray(req);
        String stBuf = new String(buf, StandardCharsets.UTF_8);

        User user = User.fromJSON(stBuf);
        if (user != null) {
            EntityManager em = Utils.getEntityManager();
            try {
                em.getTransaction().begin();

                DBUser dbuser = new DBUser(user.getLogin(), user.getPassword());
                em.persist(dbuser);

                em.getTransaction().commit();

                System.out.println("user added!");
                list.add(user);
            } catch (Exception e) {
                em.getTransaction().rollback();
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            }
        }
        else
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
    }
}
