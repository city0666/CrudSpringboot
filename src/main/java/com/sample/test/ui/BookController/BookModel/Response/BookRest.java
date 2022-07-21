package com.sample.test.ui.BookController.BookModel.Response;

public class BookRest {
	private String Auther;
	private String Year;
	private String BookName;
	private String Publisher;
	private String bookId;

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getAuther() {
		return Auther;
	}

	public void setAuther(String auther) {
		Auther = auther;
	}

	public String getYear() {
		return Year;
	}

	public void setYear(String year) {
		Year = year;
	}

	public String getBookName() {
		return BookName;
	}

	public void setBookName(String bookName) {
		BookName = bookName;
	}

	public String getPublisher() {
		return Publisher;
	}

	public void setPublisher(String publisher) {
		Publisher = publisher;
	}

}
