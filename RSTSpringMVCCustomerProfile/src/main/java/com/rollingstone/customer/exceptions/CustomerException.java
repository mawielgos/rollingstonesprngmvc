package com.rollingstone.customer.exceptions;

import java.util.Date;

public class CustomerException extends Exception {

	  private String name;
	    private Date date;
	    private String message;

	    public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		public CustomerException(String message) {
	    this.message = message;
	    }
		
		public CustomerException(String name, Date date) {
	        this.name = name;
	        this.date = date;
	    }

	    public String getName() {
	        return name;
	    }

	    public Date getDate() {
	        return date;
	    }

}
