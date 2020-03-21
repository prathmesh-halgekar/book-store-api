package com.prats.bookstore.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prats.bookstore.demo.json.BookJson;
import com.prats.bookstore.demo.model.Book;
import com.prats.bookstore.demo.service.BookService;


@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:4200")
public class BookController {

	@Autowired
	private BookService bookService;

	@GetMapping("/book/{id}")
	public ResponseEntity<BookJson> getBook(@PathVariable String id) {

		return ResponseEntity.ok(bookService.handleGetBookByIdRequest(id));
	}

	@GetMapping("/book")
	public ResponseEntity<List<Book>> getBooks() {

		return ResponseEntity.ok(bookService.handleGetAllBooksRequest());
	}

}
