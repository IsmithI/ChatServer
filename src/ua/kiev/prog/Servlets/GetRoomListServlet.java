package ua.kiev.prog.Servlets;

import ua.kiev.prog.RoomList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

/**
 * Created by smith on 23.12.16.
 */
public class GetRoomListServlet extends HttpServlet {

    private RoomList list = RoomList.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OutputStream os = resp.getOutputStream();
        String json = list  .toJSON();
        byte[] buf = json.getBytes(StandardCharsets.UTF_8);
        os.write(buf);
    }
}
