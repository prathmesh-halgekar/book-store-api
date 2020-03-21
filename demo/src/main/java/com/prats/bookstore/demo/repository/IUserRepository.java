package com.prats.bookstore.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prats.bookstore.demo.model.User;

public interface IUserRepository extends JpaRepository<User, Integer> {

}
