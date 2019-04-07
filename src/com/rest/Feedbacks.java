package com.rest;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Produces;

@Produces("application/json")
public class Feedbacks {
	    //@Expose
	    
	    public Feedbacks() {} // constructor require
	    List<Feedback> feedbacks = new ArrayList<Feedback>();

		public List<Feedback> getFeedbacks() {
			return feedbacks;
		}

		public void addFeedback(Feedback feedback) {
			this.feedbacks.add(feedback);
		}
}
