package com.prats.bookstore.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prats.bookstore.demo.model.BookView;

public interface IBookViewRepository extends JpaRepository<BookView, Integer> {

}
