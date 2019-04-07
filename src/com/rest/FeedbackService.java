package com.rest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/*
 * @author: Gaurav sharma
 * Note: Before running this "FeedBack-api" project should be running on localhost 8080 port
 */

@WebServlet("/feedbackSubmit")
public class FeedbackService extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static WebTarget feedbackApiGET = ClientBuilder.newBuilder()
			// .build().target("http://localhost:8080/FeedBack2/api/json/feedback/get");
			.build().target("http://localhost:8080/FeedBack-api/api/json/feedback/get");
	private static WebTarget feedbackApiPOST = ClientBuilder.newBuilder()
			// .build().target("http://localhost:8080/FeedBack2/api/json/feedback/post");
			.build().target("http://localhost:8080/FeedBack-api/api/json/feedback/post");
	public void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("In processRequest method..");
		if (!"".equals(req.getParameter("email")) && !"".equals(req.getParameter("message"))) {
			response(resp, "Thank you for your feedback");
		} else {
			response(resp, "Invalid Feedback");
		}

		Feedback fd = new Feedback();

		fd.setEmail(req.getParameter("email"));
		fd.setMessage(req.getParameter("message"));
		fd.setBrowser(req.getHeader("User-Agent"));
		fd.setTime(LocalDateTime.now().toString());

		this.saveFeedback(fd);

	}

	
	public static List<Feedback> getAllFeedbacksByApi() {
		Feedbacks res = feedbackApiGET
				// .queryParam("email", 1).queryParam("message", num)
				.request(MediaType.APPLICATION_JSON).get(Feedbacks.class);
		return res.getFeedbacks();
	}
	
	public static Response submitFeedBackByApi(Feedback fd) {
		
		return feedbackApiPOST
				// .target(REST_URI)
				.request(MediaType.APPLICATION_JSON).post(Entity.entity(fd, MediaType.APPLICATION_JSON));
	}
<<<<<<< HEAD
	public void saveFeedback(Feedback fd) {
    	// http://localhost:8080/RESTfulExample/json/product/post

    		//try {
    			// Just to testt if read is also working
    			FeedbackService fs = new FeedbackService();
    			//List<Feedback> fds = fs.getAllFeedbacksByApi();
    			
    		Response res =	fs.submitFeedBackByApi(fd);
    		if (res.getStatus() != HttpURLConnection.HTTP_CREATED) {
				throw new RuntimeException("Failed : HTTP error code : "+ res.getStatus());
			}else {
				System.out.println("Output from Server .... \n");
				System.out.println("Feedback Sumbitted successfuly.");
			}
/*
    			ObjectToJSON obj = new ObjectToJSON();
    			//boolean input = obj.writeFeedbackToJsonFile(fd);
    			boolean success = obj.appendObjToJSON(fd);
    			//String input = "{\"message\":some Message,\"email\":\"xyz@abc.com\"}";

    			
    			URL url = new URL("http://localhost:8080/FeedBack-api/api/json/feedback/post");
    			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    			//URLConnection conn = url.openConnection();
    			conn.setDoOutput(true);
    			conn.setRequestProperty("Content-Type", "application/json");
    			//conn.setConnectTimeout(5000);
    			//conn.setReadTimeout(5000);
    			
    			
    			 * OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream());
    			 * out.write(jsonObject.toString()); out.close();
    			 
    			
    			  if (conn.getResponseCode() != 200) { 
    				  throw new  RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
    				  }
    			 

    			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

    			String output;
    			System.out.println("Output from Server .... \n");
    			while ((output = br.readLine()) != null) {

    				System.out.println(output);
    			}
    			br.close();
    			conn.disconnect();
    		} catch (MalformedURLException e) {

    			e.printStackTrace();
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
 */

=======
	public void saveFeedback(Feedback fd) {
    	// http://localhost:8080/RESTfulExample/json/product/post

    		//try {
    			// Just to testt if read is also working
    			FeedbackService fs = new FeedbackService();
    			//List<Feedback> fds = fs.getAllFeedbacksByApi();
    			
    		Response res =	fs.submitFeedBackByApi(fd);
    		if (res.getStatus() != HttpURLConnection.HTTP_CREATED) {
				throw new RuntimeException("Failed : HTTP error code : "+ res.getStatus());
			}else {
				System.out.println("Output from Server .... \n");
				System.out.println("Feedback Sumbitted successfuly.");
			}
/*
    			ObjectToJSON obj = new ObjectToJSON();
    			//boolean input = obj.writeFeedbackToJsonFile(fd);
    			boolean success = obj.appendObjToJSON(fd);
    			//String input = "{\"message\":some Message,\"email\":\"xyz@abc.com\"}";

    			
    			URL url = new URL("http://localhost:8080/FeedBack-api/api/json/feedback/post");
    			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    			//URLConnection conn = url.openConnection();
    			conn.setDoOutput(true);
    			conn.setRequestProperty("Content-Type", "application/json");
    			//conn.setConnectTimeout(5000);
    			//conn.setReadTimeout(5000);
    			
    			
    			 * OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream());
    			 * out.write(jsonObject.toString()); out.close();
    			 
    			
    			  if (conn.getResponseCode() != 200) { 
    				  throw new  RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
    				  }
    			 

    			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

    			String output;
    			System.out.println("Output from Server .... \n");
    			while ((output = br.readLine()) != null) {

    				System.out.println(output);
    			}
    			br.close();
    			conn.disconnect();
    		} catch (MalformedURLException e) {

    			e.printStackTrace();
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
 */

>>>>>>> branch 'master' of https://github.com/gauravs08/FeedBack.git
    }

	public void getAllFeedback() {
		try {

			URL url = new URL("http://localhost:8080/feedbackSubmit/json/get");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {

				System.out.println(output);
			}

			conn.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();

		}

	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// processRequest(request, response);
	}
	
	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// processRequest(request, response);
	}
	
	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// processRequest(request, response);
	}
	
	private void response(HttpServletResponse resp, String msg) throws IOException {
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<t1>" + msg + "</t1>");
		out.println("</body>");
		out.println("</html>");
	}
}
