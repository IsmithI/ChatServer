package ua.kiev.prog.Servlets;

import ua.kiev.prog.DBEntities.*;
import ua.kiev.prog.Entities.Message;
import ua.kiev.prog.MessageList;
import ua.kiev.prog.Utils;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static ua.kiev.prog.Utils.requestBodyToArray;

public class AddServlet extends HttpServlet {

	private MessageList msgList = MessageList.getInstance();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		byte[] buf = requestBodyToArray(req);
        String bufStr = new String(buf, StandardCharsets.UTF_8);
//        String to = req.getParameter("to");

		Message msg = Message.fromJSON(bufStr);
		if (msg != null) {
			EntityManager em = Utils.getEntityManager();
			try {
				em.getTransaction().begin();

				DBMessage dbmessage = new DBMessage(msg.getFrom(), msg.getTo(), msg.getText());
				em.persist(dbmessage);

				em.getTransaction().commit();
				msgList.add(msg);
			} catch (Exception e) {
				em.getTransaction().rollback();
				resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			}
		}
		else
			resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
	}
}
