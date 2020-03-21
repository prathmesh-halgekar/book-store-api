package com.prats.bookstore.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prats.bookstore.demo.model.Book;

public interface IBookRepository extends JpaRepository<Book, String> {

}
