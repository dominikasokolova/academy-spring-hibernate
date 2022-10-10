package sk.ness.academy.springboothibernate.dao;

import sk.ness.academy.springboothibernate.model.Book;

import java.util.List;

public interface BookDao {
  List<Book> findAll();
  void persist(Book book);
}
