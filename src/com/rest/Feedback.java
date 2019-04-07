<<<<<<< HEAD
package com.rest;

import javax.ws.rs.Produces;

@Produces("application/json")
public class Feedback {

	String email;
	String message;
	String time;
	String browser;

	public Feedback() {} //constructor require
	
	public String getTime() {
		return time;
	}
	
	public void setTime(String time) {
		this.time = time;
	}
	
	public String getBrowser() {
		return browser;
	}
	
	public void setBrowser(String browser) {
		this.browser = browser;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String name) {
		this.email = name;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String msg) {
		this.message = msg;
	}

	@Override
	public String toString() {
		return "Feedback [email=" + email 
					+ ", message=" + message 
					+ ", time="+time
					+ ", browser="+browser+"]";
	}
	

=======
package com.rest;

import javax.ws.rs.Produces;

@Produces("application/json")
public class Feedback {

	String email;
	String message;
	String time;
	String browser;

	public Feedback() {} //constructor require
	
	public String getTime() {
		return time;
	}
	
	public void setTime(String time) {
		this.time = time;
	}
	
	public String getBrowser() {
		return browser;
	}
	
	public void setBrowser(String browser) {
		this.browser = browser;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String name) {
		this.email = name;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String msg) {
		this.message = msg;
	}

	@Override
	public String toString() {
		return "Feedback [email=" + email 
					+ ", message=" + message 
					+ ", time="+time
					+ ", browser="+browser+"]";
	}
	

>>>>>>> branch 'master' of https://github.com/gauravs08/FeedBack.git
}