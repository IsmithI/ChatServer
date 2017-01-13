package ua.kiev.prog.Servlets;

import ua.kiev.prog.UserList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

/**
 * Created by smith on 21.12.16.
 */
public class GetUserListServlet extends HttpServlet {

    private UserList userList = UserList.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OutputStream os = resp.getOutputStream();
        String json = userList.toJSON();
        byte[] buf = json.getBytes(StandardCharsets.UTF_8);
        os.write(buf);
        System.out.println("list is get");
    }
}
