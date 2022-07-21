package com.sample.test.ui.BookController;


import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sample.test.ui.BookController.BookModel.Request.BookDetailsRequestModel;
import com.sample.test.ui.BookController.BookModel.Request.UpdateBookDetailsRequestModel;
import com.sample.test.ui.BookController.BookModel.Response.BookRest;

@RestController
@RequestMapping("/book")
public class BookController {
	
	Map<String, BookRest> books;

	
	/* Demo purpose add basic features of CRUD Operation and pagination , sort and limit */
	
	/* get  Book key*/

	@SuppressWarnings("rawtypes")
	@GetMapping
	public String getallBooks(@RequestParam(value="page", defaultValue="1") int page, 
			@RequestParam(value="limit", defaultValue="50") int limit,
			@RequestParam(value="sort", defaultValue = "desc", required = false) String sort)
	
	
	{
	
		Object srr = null;

		for (Map.Entry entry : books.entrySet()) {
		    System.out.println(entry.getKey() + ", " + entry.getValue());
		 // String test= entry.getKey();
		  srr=entry.getKey();
		}
		
//		 System.out.println
		String ret ="get ALl Book was called with page = ";
		 System.out.println( ret);
		return  (srr.toString());
	}
	
	
	
	
	
	/* get a Book*/

	@GetMapping(path="/{bookId}")
    public ResponseEntity<BookRest> getBook (@PathVariable String bookId) {
		
		
		
		if(books.containsKey(bookId))
		{
			return new ResponseEntity<>(books.get(bookId), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	/* Update A Book*/

	@PutMapping(path="/{bookId}")
	public BookRest updatBook(@PathVariable String bookId, @Valid @RequestBody UpdateBookDetailsRequestModel bookDetails)

	{
		BookRest storedBookDetails = books.get(bookId);
		storedBookDetails.setAuther(bookDetails.getAuther());
		storedBookDetails.setPublisher(bookDetails.getPublisher());
		 
		 books.put(bookId, storedBookDetails);
		 
		 return storedBookDetails;
	}

	
	/* Create A Book*/

	@PostMapping
	public ResponseEntity<BookRest>createBook(@RequestBody BookDetailsRequestModel bookdetails) {
	BookRest returnValue = new BookRest();
        
		returnValue.setAuther(bookdetails.getAuther());
		returnValue.setBookName(bookdetails.getBookName());
		returnValue.setPublisher(bookdetails.getPublisher());
		returnValue.setYear(bookdetails.getYear());

		String boookId = UUID.randomUUID().toString();
		returnValue.setBookId(boookId);
		if(books == null) books = new HashMap<>();
		books.put(boookId, returnValue);
		return new ResponseEntity<BookRest>(returnValue, HttpStatus.OK);
	}
	
	/* Delete A Book*/

	@DeleteMapping(path="/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable String id)
	{
		books.remove(id);
		
		return ResponseEntity.noContent().build();
	}

}
