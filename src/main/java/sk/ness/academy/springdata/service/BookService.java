package sk.ness.academy.springdata.service;

import sk.ness.academy.springdata.model.Book;

import java.util.List;

public interface BookService {
  List<Book> findAll();

  void save(Book book);
}
