package com.ashokit.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ashokit.bindings.Book;

@RestController
public class BookRestController {

	@GetMapping(
			value="/book",
			produces= {"application/json"}
	)
	public ResponseEntity<Book> getBook() {
		// logic to retrieve book from db

		Book book = new Book();
		book.setBookId(101);
		book.setBookName("Spring");
		book.setIsbn("ISBN001");
		book.setBookPrice(450.50);

		return new ResponseEntity<Book>(book, HttpStatus.OK);
	}
	
	//extra added 
	
	@GetMapping(
			value="/friend",
			produces= {"application/json"}
	)
	public ResponseEntity<String> friend() {
		// logic to retrieve book from db
        
		String str="Friends, Welcome to AWS World ! Have a Good Day";

		return new ResponseEntity<String>(str, HttpStatus.OK);
	}
	
	@PostMapping(
			value="/addbook",
			consumes= {"application/json"}
	)
	public ResponseEntity<String> addBook(@RequestBody Book book) {
		// logic to retrieve book from db
		System.out.println("Book stored....");
		return new ResponseEntity<String>("Book Saved", HttpStatus.CREATED);
	}
	
	@GetMapping(
			value="/books",
			produces= {"application/json"}
	)
	public ResponseEntity<List<Book>> getBooks() {
		// logic to retrieve book from db

		Book b1 = new Book(101,"Spring","ISBN001",450.50);
		Book b2 = new Book(102,"Spring Boot","ISBN002",650.50);
		Book b3 = new Book(103,"Hibernate","ISBN003",250.50);
		Book b4 = new Book(104,"J2SE","ISBN004",350.50);
		Book b5 = new Book(105,"J2EE","ISBN005",450.50);
		Book b6 = new Book(106,"Angular","ISBN006",550.50);
		
		List<Book> books = new ArrayList<>();
		books.add(b1);
		books.add(b2);
		books.add(b3);
		books.add(b4);
		books.add(b5);
		books.add(b6);

		return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
	}
	
	@GetMapping(
			value="/book/{isbn}",
			produces= {"application/xml","application/json"}
	)
	public ResponseEntity<Book> getBookByISBN(@PathVariable("isbn") String isbn) {
		// logic to retrieve book from db

		Book book = new Book();
		book.setBookId(301);
		book.setBookName("Spring Boot");
		book.setIsbn(isbn);
		book.setBookPrice(550.50);

		return new ResponseEntity<Book>(book, HttpStatus.OK);
	}
}
