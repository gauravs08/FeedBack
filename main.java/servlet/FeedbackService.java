package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * @author: Gaurav sharma
 */

@WebServlet("/feedbackSubmit")
public class FeedbackService extends HttpServlet {
	
	private static final long serialVersionUID = 1L;


	public void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("In processRequest method..");
		String user = req.getParameter("email");
		String pass = req.getParameter("message");
		if (!"".equals(user) && !"".equals(pass)) {
			response(resp, "Thank you for your feedback");
		} else {
			response(resp, "Invalid Feedback");
		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}
	private void response(HttpServletResponse resp, String msg)
			throws IOException {
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<t1>" + msg + "</t1>");
		out.println("</body>");
		out.println("</html>");
	}

    public void saveFeedback() {
        // nothing here yet.
    }

    public void getAllFeedback() {
        // nothing here yet.
    }

}
