package com.sample.test.ui.BookController.BookModel.Request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class BookDetailsRequestModel {
	/* Validation user end */
	@NotNull(message="Auther cannot be null")
	@Size(min=2, message = "Auther must not be less than 2 characters")
	private String auther;
	@NotNull(message="Book Name cannot be null")
	@Size(min=2, message = "Book Name must not be less than 2 characters")
	private String bookName;
	
	@NotNull(message="publisher cannot be null")
	@Size(min=2, message = "publisher must not be less than 2 characters")
	private String publisher;
	
	
	@NotNull(message="Published Year cannot be null")
	@Size(min=4, max=4, message = "Published year must not be less than 4 characters")
	private String year;

	public String getAuther() {
		return auther;
	}

	public void setAuther(String auther) {
		this.auther = auther;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}
}
