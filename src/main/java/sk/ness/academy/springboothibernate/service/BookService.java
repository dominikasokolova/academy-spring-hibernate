package sk.ness.academy.springboothibernate.service;

import sk.ness.academy.springboothibernate.dto.BookDto;
import sk.ness.academy.springboothibernate.model.Book;

import java.util.List;

public interface BookService {
  List<BookDto> findAll();
  void save(Book book);
}
