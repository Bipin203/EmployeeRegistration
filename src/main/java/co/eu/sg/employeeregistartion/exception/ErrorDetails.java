package co.eu.sg.employeeregistartion.exception;

import java.util.Date;

public class ErrorDetails {
	
	  private String message;
	  private String details;
	  private Date timestamp;
	  
	public ErrorDetails(String message, String details, Date timestamp) {
		this.message = message;
		this.details = details;
		this.timestamp = timestamp;
	}


}
