package ua.kiev.prog.Servlets;

import ua.kiev.prog.DBEntities.DBMessage;
import ua.kiev.prog.DBEntities.DBUser;
import ua.kiev.prog.Entities.User;
import ua.kiev.prog.MessageList;
import ua.kiev.prog.Utils;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class GetListServlet extends HttpServlet {

//	private MessageList msgList = MessageList.getInstance();

    @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String fromStr = req.getParameter("from");
		int from = 0;
		try {
			from = Integer.parseInt(fromStr);
		} catch (Exception ex) {
			resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
		}

		EntityManager em = Utils.getEntityManager();
		em.getTransaction().begin();

		Query query = em.createNamedQuery("DBMessage.getAll", DBUser.class);
		List<DBMessage> dbmessages = query.getResultList();

		MessageList msgList = new MessageList(dbmessages);
		
		String json = msgList.toJSON(from);
		if (json != null) {
			OutputStream os = resp.getOutputStream();
            byte[] buf = json.getBytes(StandardCharsets.UTF_8);
			os.write(buf);
		}
	}
}
