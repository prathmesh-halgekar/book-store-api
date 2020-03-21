package com.prats.bookstore.demo.json;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.prats.bookstore.demo.model.Book;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class BookJson {

	@Getter
	@Setter
	private Book book;

	@Getter
	@Setter
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private List<Book> relevantBooks;

	public BookJson(Book book, List<Book> relevantBooks) {
		super();
		this.book = book;
		this.relevantBooks = relevantBooks;
	}

}
