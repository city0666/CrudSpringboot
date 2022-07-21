package com.sample.test.ui.BookController.BookModel.Request;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UpdateBookDetailsRequestModel {
	/* Validation user end */
	@NotNull(message="Auther cannot be null")
	@Size(min=2, message = "Auther must not be less than 2 characters")
	private String auther;
	
	
	
	@NotNull(message="publisher cannot be null")
	@Size(min=2, message = "publisher must not be less than 2 characters")
	private String publisher;
	
	
	

	public String getAuther() {
		return auther;
	}

	public void setAuther(String auther) {
		this.auther = auther;
	}


	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}


}
